/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Repositorio;

import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Interface.InterfaceProducto;
import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Modelo.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 57300
 */
@Repository
public class ProductoRepositorio {
    @Autowired
    private InterfaceProducto crud;
    
    public List<Producto> listarProductos(){
        return crud.findAll();
    }
    
    public Optional<Producto> getProducto(String reference){
        return crud.findById(reference);
    }
    
    public Producto guardarProducto(Producto producto){
        return crud.save(producto);
    }
    
    public void updateProducto(Producto producto){
        crud.save(producto);
    }
    
    public void deleteProducto(Producto producto){
        crud.delete(producto);
    }
}
