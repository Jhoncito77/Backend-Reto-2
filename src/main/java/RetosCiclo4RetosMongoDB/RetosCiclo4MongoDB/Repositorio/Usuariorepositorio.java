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
    private InterfaceUsuario crud;
    
    public List<Usuario> getUsuarios(){
        return crud.findAll();
    }
    
    public boolean validarPorEmail (String email){
        Optional<Usuario> usuario = crud.findByEmail(email);
        if(usuario.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    
    public Optional<Usuario> validarEmailAndPassword(String email, String password){
        return crud.findByEmailAndPassword(email, password);
    } 
    
    public Optional<Usuario> getUsuario(int id){
        return crud.findById(id);
    }
    
    public Usuario saveUsuario(Usuario usuario){
        return crud.save(usuario);
    }
    
    public void update(Usuario usuario){
        crud.save(usuario);
    }
    
    public void deleteUsuario(Usuario usuario){
        crud.delete(usuario);
    }
}
