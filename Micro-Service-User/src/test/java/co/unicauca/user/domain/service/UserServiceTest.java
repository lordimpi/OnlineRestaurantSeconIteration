/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        String id = "1000";
        int t;
       
        
        IUserRepository repo=new UserRepository();
        UserService instance = new UserService();
        User expResult = new User();
        
        instance.setUserRepository(repo);
        
        List<User> tamaño=new ArrayList(); 
        tamaño = instance.findAll();
        t=tamaño.size();
        
        expResult.setAddress("prueba");
        expResult.setEmail("prueba");
        expResult.setFirstName("prueba");
        expResult.setLastName("prueba");
        expResult.setMobile("prueba");
        expResult.setPws("prueba");
        expResult.setRol("user");
        expResult.setId("1000");
        
        //create creacion de usuario
        
        instance.create(expResult);
        
        //findById buscar usuario por su id
        User result = instance.findById(id);
        assertEquals("prueba", result.getAddress());      
        assertEquals("prueba", result.getEmail());       
        assertEquals("prueba", result.getFirstName());       
        assertEquals("prueba", result.getLastName());       
        assertEquals("prueba", result.getMobile());
        assertEquals("prueba", result.getPws());
        assertEquals("user", result.getRol());
        assertEquals("1000", result.getId());
        
        //findByEmail buscar usuario por su email
        result = instance.findByEmail("prueba");
        
        assertEquals("prueba", result.getAddress());      
        assertEquals("prueba", result.getEmail());       
        assertEquals("prueba", result.getFirstName());       
        assertEquals("prueba", result.getLastName());       
        assertEquals("prueba", result.getMobile());
        assertEquals("prueba", result.getPws());
        assertEquals("user", result.getRol());
        assertEquals("1000", result.getId());
       
        
        //findAll encontrar una lista de usuarios
        List<User> nresult=new ArrayList(); 
        nresult = instance.findAll();
        assertEquals(t+1, nresult.size()); 
        
        
        //Update actializa un usuario
        expResult.setAddress("prueba2");
        expResult.setEmail("prueba2");
        expResult.setFirstName("prueba2");
        expResult.setLastName("prueba2");
        expResult.setMobile("prueba2");
        expResult.setPws("prueba2");
        expResult.setRol("user");
        expResult.setId("1000");
        
        instance.update(expResult.getId(), expResult);
        
        result = instance.findById(id);
        assertEquals("prueba2", result.getAddress());      
        assertEquals("prueba2", result.getEmail());       
        assertEquals("prueba2", result.getFirstName());       
        assertEquals("prueba2", result.getLastName());       
        assertEquals("prueba2", result.getMobile());
        assertEquals("prueba2", result.getPws());
        assertEquals("user", result.getRol());
        assertEquals("1000", result.getId());
        
        //delete borrar el usuario
        instance.delete(id);
        result = instance.findById(id);
        assertEquals(null, result);           
    }
    
}
