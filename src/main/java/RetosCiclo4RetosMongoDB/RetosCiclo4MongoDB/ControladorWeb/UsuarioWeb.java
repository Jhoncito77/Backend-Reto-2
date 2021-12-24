/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.ControladorWeb;

import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Modelo.Usuario;
import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Servicios.UsuarioServicios;
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
@RequestMapping("/api/user")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,
                                  RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioWeb {
    @Autowired
    /**
     * Variable que que trae los metodos crud
     */
    private UsuarioServicios servicios;
    
    /**
     * Metodo para traer todos los usuarios registrados
     * @return usuarios registrados
     */
    @GetMapping("/all")
    public List<Usuario> getUsuarios(){
        return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuario(@PathVariable int id){
        return servicios.getUsuario(id);
    }
    
    /**
     * Metodo para validar si existe un emailen base de datos
     * @param email
     * @return true si existe || false si no existe
     */
    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email){
        return servicios.existeEmail(email);
    }
    
    /**
     * Metodo para autenticar un usuario por email y password
     * @param email
     * @param password
     * @return Usuario 
     */
    @GetMapping("/{email}/{password}")
    public Usuario autenticarUsuario(@PathVariable String email, @PathVariable String password){
        return servicios.autenticarUsuario(email, password);
    }
    
    /**
     * Metodo usado para guardar un nuevo usuario
     * @param usuario
     * @return Usuario
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario guardarUsuario(@RequestBody Usuario usuario){
        return servicios.guardarUsuario(usuario);
    }
    
    /**
     * Metodo usado para actualizar un usuario
     * @param usuario
     * @return Usuario
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario actualizarDatos(@RequestBody Usuario usuario){
        return servicios.update(usuario);
    }
    
    /**
     * Metodo usado para eliinar un usuario
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return servicios.deleteUsuario(id);
    }
    
    @GetMapping("/birthday/{monthBirthDay}")
        public List<Usuario>getByMonthBirthtDay(@PathVariable("monthBirthDay")String monthBirthDay){
            return servicios.getByMonthBirthDay(monthBirthDay);
        }
}
