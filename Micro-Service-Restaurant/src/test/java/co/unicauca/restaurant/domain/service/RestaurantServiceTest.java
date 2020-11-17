/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.domain.service;

import co.unicauca.common.domain.entity.User;
import co.unicauca.restaurant.access.IRestaurantRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mariat
 */
public class RestaurantServiceTest {
    
    public RestaurantServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of findById method, of class RestaurantService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        String id = "";
        RestaurantService instance = new RestaurantService();
        User expResult = null;
        User result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserRepository method, of class RestaurantService.
     */
    @Test
    public void testSetUserRepository() {
        System.out.println("setUserRepository");
        IRestaurantRepository repository = null;
        RestaurantService instance = new RestaurantService();
        instance.setUserRepository(repository);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class RestaurantService.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        RestaurantService instance = new RestaurantService();
        List<User> expResult = null;
        List<User> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class RestaurantService.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        User newUser = null;
        RestaurantService instance = new RestaurantService();
        boolean expResult = false;
        boolean result = instance.create(newUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class RestaurantService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String id = "";
        User newUser = null;
        RestaurantService instance = new RestaurantService();
        boolean expResult = false;
        boolean result = instance.update(id, newUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class RestaurantService.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        RestaurantService instance = new RestaurantService();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
