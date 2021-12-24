/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Repositorio;

import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Modelo.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Interface.InterfaceOrder;

/**
 *
 * @author 57300
 */
@Repository
public class OrderRepositorio {
    @Autowired
    private InterfaceOrder crud;

    public List<Order> getAll() {
        return crud.findAll();
    }
    public Optional<Order> getOrder(Integer id){
        return crud.findById(id);
    }

    public Order save(Order order) {
        return crud.save(order);
    }

    public void update(Order order){
        crud.save(order);
    }

    public void delete (Order order){
        crud.delete(order);
    }


    public List<Order> getOrderByZone(String zone){
        return crud.findBySalesManZone(zone);
    }
    public List<Order>getBySalesManId(Integer id){
        return crud.findBySalesManId(id);
    }
    public List<Order>getBySalesManIdAndStatus(Integer id, String status){
        return crud.findBySalesManIdAndStatus(id, status);
    }
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(registerDay, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(registerDay, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);

        return mongoTemplate.find(query,Order.class);
    }
}
