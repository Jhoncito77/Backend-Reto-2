/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.ControladorWeb;

import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Modelo.Producto;
import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Servicios.ProductoServicios;
import java.util.List;
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
@RequestMapping("/api/cleaningproduct")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,
                                  RequestMethod.PUT,RequestMethod.DELETE})
public class ProductoWeb {
    @Autowired
    private ProductoServicios servicios;
    
    @GetMapping("/all")
    public List<Producto> listarProductos(){
        return servicios.listarProductos();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto guardarProducto(@RequestBody Producto producto){
        return servicios.crearProducto(producto);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto updateProducto(@RequestBody Producto producto){
        return servicios.updateProducto(producto);
    }
    
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarProducto(@PathVariable String reference){
        return servicios.deleteProducto(reference);
    }
}
