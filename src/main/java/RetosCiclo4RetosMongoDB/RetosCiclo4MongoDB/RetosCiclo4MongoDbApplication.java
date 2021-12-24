package RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB;

import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Interface.InterfaceProducto;
import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Interface.InterfaceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import RetosCiclo4RetosMongoDB.RetosCiclo4MongoDB.Interface.InterfaceOrder;

@SpringBootApplication
public class RetosCiclo4MongoDbApplication implements CommandLineRunner{

    @Autowired
    private InterfaceUsuario interfaceUsuario;
    @Autowired
    private InterfaceProducto interfaceProducto;
    @Autowired
    private InterfaceOrder interfaceOrder;
    
	public static void main(String[] args) {
		SpringApplication.run(RetosCiclo4MongoDbApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        interfaceUsuario.deleteAll();
        interfaceProducto.deleteAll();
        interfaceOrder.deleteAll();
        
    }

}
