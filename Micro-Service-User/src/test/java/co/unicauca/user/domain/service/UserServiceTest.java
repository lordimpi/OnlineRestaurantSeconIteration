/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.user.domain.service;

import co.unicauca.common.domain.entity.User;
import co.unicauca.user.access.IUserRepository;
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
public class UserServiceTest {
    
    public UserServiceTest() {
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
     * Test of findById method, of class UserService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        String id = "";
        UserService instance = new UserService();
        User expResult = null;
        User result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEmail method, of class UserService.
     */
    @Test
    public void testFindByEmail() {
        System.out.println("findByEmail");
        String email = "";
        UserService instance = new UserService();
        User expResult = null;
        User result = instance.findByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserRepository method, of class UserService.
     */
    @Test
    public void testSetUserRepository() {
        System.out.println("setUserRepository");
        IUserRepository repository = null;
        UserService instance = new UserService();
        instance.setUserRepository(repository);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class UserService.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        UserService instance = new UserService();
        List<User> expResult = null;
        List<User> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class UserService.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        User newUser = null;
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.create(newUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UserService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String id = "";
        User newUser = null;
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.update(id, newUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class UserService.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
