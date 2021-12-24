/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.ControladorWeb;

import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Modelo.Order;
import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Servicios.OrderServicios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 57300
 */
@RestController
@RequestMapping(("/api/order"))
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OrderWeb {
    @Autowired
    private OrderServicios servicios;

      @GetMapping("/all")
    public List<Order> getAll(){
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id) {
        return servicios.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return servicios.save(order);
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return servicios.update(order);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return servicios.delete(id);
    }

    @GetMapping("/zona/{zone}")
    public List<Order> getOrdersByZone(@PathVariable("zone") String zone){
        return servicios.getOrderByZone(zone);
    }
    @GetMapping("/salesman/{id}")
    public List<Order>getBySalesManId(@PathVariable("id") Integer id){
          return servicios.getBySalesManId(id);
    }
    @GetMapping("/state/{status}/{id}")
    public List<Order>getBySalesManIdAndStatus(@PathVariable("id")Integer id, @PathVariable("status")String status){
          return servicios.getBySalesManIdAndStatus(id, status);
    }

    @GetMapping("/date/{registerDay}/{id}")
    public List<Order>getByRegisterDayAndSalesManId(@PathVariable("registerDay")String registerDay, @PathVariable("id") Integer id){
          return servicios.getByRegisterAndSalesManId(registerDay, id);
    }

}
