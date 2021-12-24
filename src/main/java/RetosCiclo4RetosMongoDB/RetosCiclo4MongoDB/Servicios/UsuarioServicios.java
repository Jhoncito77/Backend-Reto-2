/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Servicios;

import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Modelo.Usuario;
import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Repositorio.Usuariorepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 57300
 */
@Service
public class UsuarioServicios {
    @Autowired
    /**
     * Instancia del repositorio
     */
    private Usuariorepositorio metodosCrud;
    /**
     * metodo para traer a todos los usuarios
     * @return 
     */
    public List<Usuario> getAll(){
        return metodosCrud.getUsuarios();
    }
    /**
     * metodo para traer un usuario por id
     * @param id
     * @return 
     */
    public Optional<Usuario> getUsuario(int id){
        return metodosCrud.getUsuario(id);
    }
    /**
     * metodo para validar si un email existe en la BD
     * @param email
     * @return 
     */
    public boolean existeEmail(String email){
        return metodosCrud.validarPorEmail(email);
    }
    /**
     * Metodo usado para autenticar usuario por email y password
     * @param email
     * @param Password
     * @return 
     */
    public Usuario autenticarUsuario(String email, String Password){
        Optional<Usuario> usuario = metodosCrud.validarEmailAndPassword(email, Password);
        if(usuario.isPresent()){
            return usuario.get();
        }else{
            return new Usuario();
        }
    }
    /**
     * Metodo usado para guardar un nuevo usuario
     * @param usuario
     * @return 
     */
    public Usuario guardarUsuario(Usuario usuario){
        if(usuario.getId()==null){
            return usuario;
        }else{
            Optional<Usuario> auxiliar = metodosCrud.getUsuario(usuario.getId());
            if(auxiliar.isEmpty()){
                if(existeEmail(usuario.getEmail())==false){
                    return metodosCrud.saveUsuario(usuario);
                }else{
                    return usuario;
                }
            }
        }
        return usuario;
    }
    /**
     * Metodo  usado para editar un usuario
     * @param usuario
     * @return 
     */
    public Usuario update(Usuario usuario){
        if(usuario.getId()!= null){
            Optional<Usuario> auxUsuario = metodosCrud.getUsuario(usuario.getId());
            if(!auxUsuario.isEmpty()){
                if(usuario.getIdentification()!=null){
                auxUsuario.get().setIdentification(usuario.getIdentification());
                }
                if(usuario.getName()!=null){
                auxUsuario.get().setName(usuario.getName());
                }
                if(usuario.getAddress()!=null){
                auxUsuario.get().setAddress(usuario.getAddress());
                }
                if(usuario.getCellPhone()!=null){
                auxUsuario.get().setCellPhone(usuario.getCellPhone());
                }
                if(usuario.getEmail()!=null){
                auxUsuario.get().setEmail(usuario.getEmail());
                }
                if(usuario.getPassword()!=null){
                auxUsuario.get().setPassword(usuario.getPassword());
                }
                if(usuario.getZone()!=null){
                auxUsuario.get().setZone(usuario.getZone());
                }
                if(usuario.getType()!=null){
                auxUsuario.get().setType(usuario.getType());
                }
                metodosCrud.update(auxUsuario.get());
                return auxUsuario.get();
            }else{
                return usuario;
            }
            
        }else{
            return usuario;
        }
        
    }
    /**
     * metodo usado para borrar un usuario
     * @param id
     * @return 
     */
    public boolean deleteUsuario(int id) {
        Boolean aBoolean = metodosCrud.getUsuario(id).map(usuario -> {
            metodosCrud.deleteUsuario(usuario);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    /**
     * Metodo usado para traer cumpleaños de usuarios por meses
     * @param monthBirthDay
     * @return 
     */
    public List<Usuario>getByMonthBirthDay(String monthBirthDay){
        return metodosCrud.getByMonthBirthtDay(monthBirthDay);
    }
}
