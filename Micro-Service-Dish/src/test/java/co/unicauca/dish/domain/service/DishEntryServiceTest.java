/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.dish.domain.service;

import co.unicauca.common.domain.entity.DishEntry;
import co.unicauca.dish.access.IDishEntryRepository;
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
public class DishEntryServiceTest {
    
    public DishEntryServiceTest() {
    }


    /**
     * Test of findById method, of class DishEntryService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        String id = "";
        DishEntryService instance = new DishEntryService();
        DishEntry expResult = null;
        DishEntry result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDishEntryRepository method, of class DishEntryService.
     */
    @Test
    public void testSetDishEntryRepository() {
        System.out.println("setDishEntryRepository");
        IDishEntryRepository repository = null;
        DishEntryService instance = new DishEntryService();
        instance.setDishEntryRepository(repository);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class DishEntryService.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        DishEntryService instance = new DishEntryService();
        List<DishEntry> expResult = null;
        List<DishEntry> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createDishEntry method, of class DishEntryService.
     */
    @Test
    public void testCreateDishEntry() {
        System.out.println("createDishEntry");
        DishEntry newDishEntry = null;
        DishEntryService instance = new DishEntryService();
        boolean expResult = false;
        boolean result = instance.createDishEntry(newDishEntry);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDishEntry method, of class DishEntryService.
     */
    @Test
    public void testUpdateDishEntry() {
        System.out.println("updateDishEntry");
        String id = "";
        DishEntry newDishEntry = null;
        DishEntryService instance = new DishEntryService();
        boolean expResult = false;
        boolean result = instance.updateDishEntry(id, newDishEntry);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DishEntryService.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        DishEntryService instance = new DishEntryService();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
