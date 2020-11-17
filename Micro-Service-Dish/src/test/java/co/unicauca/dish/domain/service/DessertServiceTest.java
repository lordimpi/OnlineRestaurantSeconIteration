package co.unicauca.dish.domain.service;

import co.unicauca.common.domain.entity.Dessert;
import co.unicauca.dish.access.IDessertRepository;
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
public class DessertServiceTest {
    
    public DessertServiceTest() {
    }
    /**
     * Test of findById method, of class DessertService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        String id = "";
        DessertService instance = new DessertService();
        Dessert expResult = null;
        Dessert result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserRepository method, of class DessertService.
     */
    @Test
    public void testSetUserRepository() {
        System.out.println("setUserRepository");
        IDessertRepository repository = null;
        DessertService instance = new DessertService();
        instance.setUserRepository(repository);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class DessertService.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        DessertService instance = new DessertService();
        List<Dessert> expResult = null;
        List<Dessert> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class DessertService.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Dessert newDessert = null;
        DessertService instance = new DessertService();
        boolean expResult = false;
        boolean result = instance.create(newDessert);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DessertService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String id = "";
        Dessert newDessert = null;
        DessertService instance = new DessertService();
        boolean expResult = false;
        boolean result = instance.update(id, newDessert);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DessertService.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        DessertService instance = new DessertService();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
