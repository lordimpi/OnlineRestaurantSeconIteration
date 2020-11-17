/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.dish.domain.service;

import co.unicauca.common.domain.entity.Salad;
import co.unicauca.dish.access.ISaladRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author soces
 */
public class SaladServiceTest {
    
    public SaladServiceTest() {
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
     * Test of findById method, of class SaladService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        String id = "";
        SaladService instance = new SaladService();
        Salad expResult = null;
        Salad result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaladRepository method, of class SaladService.
     */
    @Test
    public void testSetSaladRepository() {
        System.out.println("setSaladRepository");
        ISaladRepository repository = null;
        SaladService instance = new SaladService();
        instance.setSaladRepository(repository);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class SaladService.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        SaladService instance = new SaladService();
        List<Salad> expResult = null;
        List<Salad> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class SaladService.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Salad newSalad = null;
        SaladService instance = new SaladService();
        boolean expResult = false;
        boolean result = instance.create(newSalad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class SaladService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String id = "";
        Salad newSalad = null;
        SaladService instance = new SaladService();
        boolean expResult = false;
        boolean result = instance.update(id, newSalad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class SaladService.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        SaladService instance = new SaladService();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
