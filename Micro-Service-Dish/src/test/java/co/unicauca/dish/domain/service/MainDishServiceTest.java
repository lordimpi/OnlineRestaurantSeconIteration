package co.unicauca.dish.domain.service;

import co.unicauca.common.domain.entity.MainDish;
import co.unicauca.dish.access.IMainDishRepository;
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
public class MainDishServiceTest {
    
    public MainDishServiceTest() {
    }
    /**
     * Test of findById method, of class MainDishService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        String id = "";
        MainDishService instance = new MainDishService();
        MainDish expResult = null;
        MainDish result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMainDishRepository method, of class MainDishService.
     */
    @Test
    public void testSetMainDishRepository() {
        System.out.println("setMainDishRepository");
        IMainDishRepository repository = null;
        MainDishService instance = new MainDishService();
        instance.setMainDishRepository(repository);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class MainDishService.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        MainDishService instance = new MainDishService();
        List<MainDish> expResult = null;
        List<MainDish> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class MainDishService.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        MainDish newMainDish = null;
        MainDishService instance = new MainDishService();
        boolean expResult = false;
        boolean result = instance.create(newMainDish);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class MainDishService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String id = "";
        MainDish newMainDish = null;
        MainDishService instance = new MainDishService();
        boolean expResult = false;
        boolean result = instance.update(id, newMainDish);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MainDishService.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        MainDishService instance = new MainDishService();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
