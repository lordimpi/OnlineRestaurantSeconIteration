/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.dish.domain.service;

import co.unicauca.common.domain.entity.Drink;
import co.unicauca.dish.access.IDrinkRepository;
import co.unicauca.dish.access.DrinkRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mariat Trujillo
 */
public class DrinkServiceTest {
    
    public DrinkServiceTest() {
    }
    
     @Test
    public void testCrudDrinks() {
        System.out.println("CRUD_Drinks");
        int t;
        DrinkService service = new DrinkService();
        IDrinkRepository repo= new DrinkRepository();
        service.setDrinkRepository(repo);
        service.delete("100");
        List<Drink> tamaño=new ArrayList(); 
        tamaño = service.findAll();
        t=tamaño.size();
        
        //crete
        service.create(new Drink("100", "drink1", 500d));
        //listarlos
        List<Drink> result = service.findAll();
        assertEquals(t+1, result.size());
        //buscar
        Drink drink = service.findById("100");
        assertEquals("drink1", drink.getNameDrink());
        assertEquals(500d, drink.getDrinkPrice());
        //delete
        service.delete("100");
        drink = service.findById("100");
        assertEquals(null, drink);

    }
}
