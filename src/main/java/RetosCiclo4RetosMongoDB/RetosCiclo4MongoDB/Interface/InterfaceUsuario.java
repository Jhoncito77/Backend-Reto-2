/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Interface;

import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Modelo.Usuario;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author 57300
 */
public interface InterfaceUsuario extends MongoRepository<Usuario, Integer>{
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByEmailAndPassword(String email, String Password);
}
