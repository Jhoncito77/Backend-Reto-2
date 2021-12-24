/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Repositorio;

import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Interface.InterfaceUsuario;
import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Modelo.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 57300
 */
@Repository
public class Usuariorepositorio {
    @Autowired
    /**
     * instancia de la interface usuario
     */
    private InterfaceUsuario crud;
    /**
     * metodo para traer todos los usuarios
     * @return 
     */
    public List<Usuario> getUsuarios(){
        return crud.findAll();
    }
    /**
     * metodo para validar usuario por email
     * @param email
     * @return 
     */
    public boolean validarPorEmail (String email){
        Optional<Usuario> usuario = crud.findByEmail(email);
        if(usuario.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    /**
     * metodo para validar usuario por email y password
     * @param email
     * @param password
     * @return 
     */
    public Optional<Usuario> validarEmailAndPassword(String email, String password){
        return crud.findByEmailAndPassword(email, password);
    } 
    /**
     * metodo para traer usuario por id
     * @param id
     * @return 
     */
    public Optional<Usuario> getUsuario(int id){
        return crud.findById(id);
    }
    /**
     * metodo para guardar nuevo usuario
     * @param usuario
     * @return 
     */
    public Usuario saveUsuario(Usuario usuario){
        return crud.save(usuario);
    }
    /**
     * metodo para actualizar usuario
     * @param usuario 
     */
    public void update(Usuario usuario){
        crud.save(usuario);
    }
    /**
     * metodo para borrar usuario
     * @param usuario 
     */
    public void deleteUsuario(Usuario usuario){
        crud.delete(usuario);
    }
    /**
     * metodo para traer cumpleaños por mes
     * @param monthBirthtDay
     * @return 
     */
    public List<Usuario>getByMonthBirthtDay(String monthBirthtDay){
        return crud.findByMonthBirthtDay(monthBirthtDay);
    }
}
