/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.dish.domain.service;

import co.unicauca.common.domain.entity.Dessert;
import co.unicauca.dish.access.IDessertRepository;
import co.unicauca.dish.access.DessertRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Maria Trujillo
 */
public class DessertServiceTest {
    
     public DessertServiceTest() {
    }

    @Test
    public void testCrudDesserts() {
        System.out.println("CRUD_Desserts");
        int t;
        DessertService service = new DessertService();
        IDessertRepository repo= new DessertRepository();
        service.setUserRepository(repo);
        service.delete("100");
        List<Dessert> tamaño=new ArrayList(); 
        tamaño = service.findAll();
        t=tamaño.size();
        
        //create crea un postre
        service.create(new Dessert("100", "dessert1", 500d));
        //list lista todos los postres
        List<Dessert> result = service.findAll();
        assertEquals(t+1, result.size());
        //find busca por id el postre creado
        Dessert dessert = service.findById("100");
        assertEquals("dessert1", dessert.getName_Dish_Dessert());
        assertEquals(500d, dessert.getCost_Dish_Dessert());
        //delete borra el postre de prueba
        service.delete("100");
        dessert = service.findById("100");
        assertEquals(null, dessert);

    }
}
