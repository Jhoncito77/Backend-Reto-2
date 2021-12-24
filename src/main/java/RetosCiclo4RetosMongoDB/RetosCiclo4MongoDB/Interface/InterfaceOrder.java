/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Interface;

import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Modelo.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author 57300
 */
public interface InterfaceOrder extends MongoRepository<Order, Integer> {

    public List<Order> findBySalesManZone(String zone);

    public List<Order> findBySalesManId(Integer id);

    public List<Order> findBySalesManIdAndStatus(Integer id, String status);

    public List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer id);
}
