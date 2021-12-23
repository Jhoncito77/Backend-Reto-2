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
    private Usuariorepositorio metodosCrud;
    
    public List<Usuario> getAll(){
        return metodosCrud.getUsuarios();
    }
    
    public boolean existeEmail(String email){
        return metodosCrud.validarPorEmail(email);
    }
    
    public Usuario autenticarUsuario(String email, String Password){
        Optional<Usuario> usuario = metodosCrud.validarEmailAndPassword(email, Password);
        if(usuario.isPresent()){
            return usuario.get();
        }else{
            return new Usuario();
        }
    }
    
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
    
    public boolean deleteUsuario(int id) {
        Boolean aBoolean = metodosCrud.getUsuario(id).map(usuario -> {
            metodosCrud.deleteUsuario(usuario);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
