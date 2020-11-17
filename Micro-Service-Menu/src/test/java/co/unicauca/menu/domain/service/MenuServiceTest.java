/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.menu.domain.service;

import co.unicauca.common.domain.entity.Menu;
import co.unicauca.menu.access.IMenuRepository;
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
public class MenuServiceTest {
    
    public MenuServiceTest() {
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
     * Test of findById method, of class MenuService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        String id = "";
        MenuService instance = new MenuService();
        Menu expResult = null;
        Menu result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserRepository method, of class MenuService.
     */
    @Test
    public void testSetUserRepository() {
        System.out.println("setUserRepository");
        IMenuRepository repository = null;
        MenuService instance = new MenuService();
        instance.setUserRepository(repository);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class MenuService.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        MenuService instance = new MenuService();
        List<Menu> expResult = null;
        List<Menu> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMbyRN method, of class MenuService.
     */
    @Test
    public void testFindMbyRN() {
        System.out.println("findMbyRN");
        String rsName = "";
        MenuService instance = new MenuService();
        List<Menu> expResult = null;
        List<Menu> result = instance.findMbyRN(rsName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class MenuService.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Menu newMenu = null;
        MenuService instance = new MenuService();
        boolean expResult = false;
        boolean result = instance.create(newMenu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class MenuService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String id = "";
        Menu newMenu = null;
        MenuService instance = new MenuService();
        boolean expResult = false;
        boolean result = instance.update(id, newMenu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MenuService.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        MenuService instance = new MenuService();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
