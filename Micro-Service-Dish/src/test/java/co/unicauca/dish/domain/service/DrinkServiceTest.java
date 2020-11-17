package co.unicauca.dish.domain.service;

import co.unicauca.common.domain.entity.Drink;
import co.unicauca.dish.access.IDrinkRepository;
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
public class DrinkServiceTest {
    
    public DrinkServiceTest() {
    }
    /**
     * Test of findById method, of class DrinkService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        String id = "";
        DrinkService instance = new DrinkService();
        Drink expResult = null;
        Drink result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDrinkRepository method, of class DrinkService.
     */
    @Test
    public void testSetDrinkRepository() {
        System.out.println("setDrinkRepository");
        IDrinkRepository repository = null;
        DrinkService instance = new DrinkService();
        instance.setDrinkRepository(repository);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class DrinkService.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        DrinkService instance = new DrinkService();
        List<Drink> expResult = null;
        List<Drink> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class DrinkService.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Drink newDrink = null;
        DrinkService instance = new DrinkService();
        boolean expResult = false;
        boolean result = instance.create(newDrink);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DrinkService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String id = "";
        Drink newDrink = null;
        DrinkService instance = new DrinkService();
        boolean expResult = false;
        boolean result = instance.update(id, newDrink);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DrinkService.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        DrinkService instance = new DrinkService();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
