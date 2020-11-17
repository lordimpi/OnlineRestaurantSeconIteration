/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author soces
 */
public class DessertServiceTest {
    
    public DessertServiceTest() {
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
    
     @Test
    public void testCrudDesserts() {
        System.out.println("CRUD_Drinksesserts");
        DessertService service = new DessertService();
        List<Dessert> result = service.findAll();
        assertEquals(5, result.size());

        //
        service.create(new Dessert("100", "drink1", 500d));

        Dessert dessert = service.findById("100");
        assertEquals("dessert1", dessert.getName_Dish_Dessert());
        assertEquals(500d, dessert.getCost_Dish_Dessert());

        service.delete("100");
        dessert = service.findById("100");
        assertEquals(null, dessert);

    }
    
}
