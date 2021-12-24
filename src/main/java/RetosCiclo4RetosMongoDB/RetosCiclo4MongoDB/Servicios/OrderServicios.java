/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Servicios;

import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Modelo.Order;
import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Repositorio.OrderRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 57300
 */
@Service
public class OrderServicios {
     @Autowired
    private OrderRepositorio metodosCrud;

    public List<Order> getAll() {
        return metodosCrud.getAll();
    }
    public Optional<Order> getOrder(Integer id){
        return metodosCrud.getOrder(id);
    }

    public Order save(Order order){
        if (order.getId() == null){
            return order;
        } else {
            return metodosCrud.save(order);
        }
    }

    public Order update(Order order){
        if (order.getId() != null){
            Optional<Order> dbOrder = metodosCrud.getOrder(order.getId());
            if (!dbOrder.isEmpty()) {

                if (order.getId() != null) {
                    dbOrder.get().setId(order.getId());
                }

                if (order.getRegisterDay() != null) {
                    dbOrder.get().setRegisterDay(order.getRegisterDay());
                }

                if (order.getStatus() != null) {
                    dbOrder.get().setStatus(order.getStatus());
                }

                if (order.getSalesMan() != null) {
                    dbOrder.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    dbOrder.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    dbOrder.get().setQuantities(order.getQuantities());
                }
                metodosCrud.update(dbOrder.get());
                return dbOrder.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(Integer id){
        return getOrder(id).map(order -> {
            metodosCrud.delete(order);
            return true;
        }).orElse(false);
    }

    public List<Order> getOrderByZone(String zone){
        return metodosCrud.getOrderByZone(zone);
    }

    public List<Order>getBySalesManId(Integer id){
        return metodosCrud.getBySalesManId(id);
    }

    public List<Order>getBySalesManIdAndStatus(Integer id, String status){
        return metodosCrud.getBySalesManIdAndStatus(id, status);
    }

    public List<Order>getByRegisterAndSalesManId(String registerDay, Integer id){
        return metodosCrud.getByRegisterDayAndSalesManId(registerDay, id);
    }

}
