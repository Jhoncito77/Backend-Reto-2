/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.ControladorWeb;

import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Modelo.Usuario;
import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Servicios.UsuarioServicios;
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
@RequestMapping("/api/user")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,
                                  RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioWeb {
    @Autowired
    private UsuarioServicios servicios;
    
    @GetMapping("/all")
    public List<Usuario> getUsuarios(){
        return servicios.getAll();
    }
    
    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email){
        return servicios.existeEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public Usuario autenticarUsuario(@PathVariable String email, @PathVariable String password){
        return servicios.autenticarUsuario(email, password);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario guardarUsuario(@RequestBody Usuario usuario){
        return servicios.guardarUsuario(usuario);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario actualizarDatos(@RequestBody Usuario usuario){
        return servicios.update(usuario);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return servicios.deleteUsuario(id);
    }
}
