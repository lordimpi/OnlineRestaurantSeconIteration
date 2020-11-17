/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.domain.service;

import co.unicauca.common.domain.entity.Restaurant;
import co.unicauca.restaurant.access.IRestaurantRepository;
import co.unicauca.restaurant.access.RestaurantRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Maria Trujillo
 */
public class RestaurantServiceTest {
    
    public RestaurantServiceTest() {
    }  
   /**
     * test del CRUD
     */
    @Test
    public void testCRUD() {
        System.out.println("CRUD general");
        String id = "1000";
        int t;
        
        IRestaurantRepository repo=new RestaurantRepository();
        RestaurantService instance = new RestaurantService();
        Restaurant expResult = new Restaurant();
        
        instance.setUserRepository(repo);
        
        List<Restaurant> tamaño=new ArrayList(); 
        tamaño = instance.findAll();
        t=tamaño.size();
        
        expResult.setAddressRestaurant("prueba");
        expResult.setNameRestaurant("prueba");
        expResult.setPhone("prueba");
        expResult.setIdRestaurant(id);
        expResult.setIdmenuLu("1");
        expResult.setIdmenuMa("1");
        expResult.setIdmenuMi("1");
        expResult.setIdmenuJu("1");
        expResult.setIdmenuVi("1");
        expResult.setIdmenuSa("1");
        //create crear un nuevo resturante
        
        instance.create(expResult);
        
        //findById buscar el restaurante por id
        Restaurant result = instance.findById(id);
        assertEquals("prueba", result.getPhone());      
        assertEquals("prueba", result.getNameRestaurant());       
        assertEquals("prueba", result.getAddressRestaurant());       
        assertEquals("1000", result.getIdRestaurant());
        
      
        //findAll buscar lista de restaurantes
        List<Restaurant> nresult=new ArrayList(); 
        nresult = instance.findAll();
        
        assertEquals(t+1, nresult.size()); 
        
        
        //Update actualizar el restaurante
        expResult.setAddressRestaurant("prueba2");
        expResult.setNameRestaurant("prueba2");
        expResult.setPhone("prueba2");
        expResult.setIdRestaurant(id);
        expResult.setIdmenuLu("1");
        expResult.setIdmenuMa("1");
        expResult.setIdmenuMi("1");
        expResult.setIdmenuJu("1");
        expResult.setIdmenuVi("1");
        expResult.setIdmenuSa("1");
        instance.update(expResult.getIdRestaurant(), expResult);
        
        result = instance.findById(id);
        assertEquals("prueba2", result.getPhone());      
        assertEquals("prueba2", result.getNameRestaurant());       
        assertEquals("prueba2", result.getAddressRestaurant());       
        assertEquals("1000", result.getIdRestaurant());
        
        
        //Delete Borrar el restaurante
        instance.delete(id);
        result = instance.findById(id);
        assertEquals(null, result);           
    }
    
}
