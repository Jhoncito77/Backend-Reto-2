/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Servicios;

import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Modelo.Producto;
import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Repositorio.ProductoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 57300
 */
@Service
public class ProductoServicios {
    @Autowired
    private ProductoRepositorio metodosCrud;
    
    public List<Producto> listarProductos(){
        return metodosCrud.listarProductos();
    }
    
    public Optional<Producto> getProducto(String referencia){
        return metodosCrud.getProducto(referencia);
    }
        
    public Producto crearProducto(Producto producto){
        if(producto.getReference()==null){
            return producto;
        }else{
            Optional<Producto> auxiliar = metodosCrud.getProducto(producto.getReference());
            if(auxiliar.isEmpty()){
                return metodosCrud.guardarProducto(producto);
            }else{
                return producto;
            }
        }
        
    }
    
    public Producto updateProducto(Producto producto){
        if(producto.getReference()!=null){
            Optional<Producto> auxProducto = metodosCrud.getProducto(producto.getReference());
            if(!auxProducto.isEmpty()){
                if(producto.getReference()!=null){
                    auxProducto.get().setReference(producto.getReference());
                }
                if(producto.getBrand()!=null){
                    auxProducto.get().setBrand(producto.getBrand());
                }
                if(producto.getCategory()!=null){
                    auxProducto.get().setCategory(producto.getCategory());
                }
                if(producto.getDescription()!=null){
                    auxProducto.get().setDescription(producto.getDescription());
                }
                if(!producto.isAvailability()){
                    auxProducto.get().setAvailability(producto.isAvailability());
                }
                if(producto.getPrice()!=0){
                    auxProducto.get().setPrice(producto.getPrice());
                }
                if(producto.getQuantity()!=0){
                    auxProducto.get().setQuantity(producto.getQuantity());
                }
                if(producto.getPhotography()!=null){
                    auxProducto.get().setPhotography(producto.getPhotography());
                }
                metodosCrud.updateProducto(auxProducto.get());
                return auxProducto.get();
            }else{
            return auxProducto.get();
            }
        }
        return producto;
    }
    
    public boolean deleteProducto(String reference){
        boolean borrar = metodosCrud.getProducto(reference).map(producto->{
        metodosCrud.deleteProducto(producto);
        return true;
        }).orElse(false);
        return borrar;
    }
    
    public List<Producto>getByPrice(double price){
        return metodosCrud.getByPrice(price);
    }
    public List<Producto>getByDescriptionContainingIgnoreCase(String description){
        return metodosCrud.getByDescriptionContainingIgnoreCase(description);
    }
}
