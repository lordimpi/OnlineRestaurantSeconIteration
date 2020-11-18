package co.unicauca.user.domain.service;

import co.unicauca.common.domain.entity.User;
import co.unicauca.user.access.IUserRepository;
import co.unicauca.user.access.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Maria Trujillo
 */
public class UserServiceTest {
    
    public UserServiceTest() {
    }
    /**
     * test del CRUD
     */
    @Test
    public void testCRUD() {
        System.out.println("CRUD general");
        String id = "1";
        int t;
       
        
        IUserRepository repo=new UserRepository();
        UserService instance = new UserService();
        User expResult = new User();
        
        instance.setUserRepository(repo);
        
        List<User> tamaño=new ArrayList(); 
        tamaño = instance.findAll();
        t=tamaño.size();
        
        expResult.setAddress("prueba");
        expResult.setEmail("petere@gmail.com");
        expResult.setFirstName("prueba");
        expResult.setLastName("prueba");
        expResult.setMobile("prueba");
        expResult.setPws("prueba");
        expResult.setRol("user");
        
        //create creacion de usuario
        
        instance.create(expResult);
        
        //findById buscar usuario por su id
        User result = instance.findById(id);
        assertEquals("calle 10", result.getAddress());      
        assertEquals("alejo1@rc.com", result.getEmail());       
        assertEquals("alejo", result.getFirstName());       
        assertEquals("rodriguez", result.getLastName());       
        assertEquals("3166161700", result.getMobile());
        assertEquals("123", result.getPws());
        assertEquals("admin", result.getRol());
        assertEquals("1", result.getId());
        
        //findByEmail buscar usuario por su email
        result = instance.findByEmail("petere@gmail.com");
        
        assertEquals("prueba", result.getAddress());      
        assertEquals("petere@gmail.com", result.getEmail());       
        assertEquals("prueba", result.getFirstName());       
        assertEquals("prueba", result.getLastName());       
        assertEquals("prueba", result.getMobile());
        assertEquals("prueba", result.getPws());
        assertEquals("user", result.getRol());       
        
        //findAll encontrar una lista de usuarios
        List<User> nresult=new ArrayList(); 
        nresult = instance.findAll();
        assertEquals(t+1, nresult.size()); 
        
        
        //Update actualizar un usuario
        expResult.setAddress("prueba2");
        expResult.setEmail("petere@gmail.com");
        expResult.setFirstName("prueba2");
        expResult.setLastName("prueba2");
        expResult.setMobile("prueba2");
        expResult.setPws("prueba2");
        expResult.setRol("user");
        
        instance.update(expResult.getEmail(), expResult);
        
        result = instance.findByEmail("petere@gmail.com");
        assertEquals("prueba2", result.getAddress());      
        assertEquals("petere@gmail.com", result.getEmail());       
        assertEquals("prueba2", result.getFirstName());       
        assertEquals("prueba2", result.getLastName());       
        assertEquals("prueba2", result.getMobile());
        assertEquals("prueba2", result.getPws());
        assertEquals("user", result.getRol());
        
        //delete borrar el usuario
        instance.delete("petere@gmail.com");
        result = instance.findByEmail("petere@gmail.com");
        assertEquals(null, result);           
    }
    
}
