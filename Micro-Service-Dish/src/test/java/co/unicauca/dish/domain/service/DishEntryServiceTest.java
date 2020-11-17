/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.dish.domain.service;

import co.unicauca.common.domain.entity.DishEntry;
import co.unicauca.dish.access.IDishEntryRepository;
import co.unicauca.dish.access.DishEntryRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mariat Trujillo
 */
public class DishEntryServiceTest {

    public DishEntryServiceTest() {
    }

    @Test
    public void testCrudDishEntrys() {
        System.out.println("CRUD_DishEntrys");
        int t;
        DishEntryService service = new DishEntryService();
        IDishEntryRepository repo = new DishEntryRepository();
        service.setDishEntryRepository(repo);
        service.delete("100");
        List<DishEntry> tamaño = new ArrayList();
        tamaño = service.findAll();
        t = tamaño.size();
        
        //crete
        service.createDishEntry(new DishEntry("100", "dishEntry1", 500));
        //listarlos
        List<DishEntry> result = service.findAll();
        assertEquals(t+1, result.size());
        //buscar
        DishEntry dishEntry = service.findById("100");
        assertEquals("dishEntry1", dishEntry.getNameDishEntry());
        assertEquals(500, dishEntry.getCostDishEntry());
        //delete
        service.delete("100");
        dishEntry = service.findById("100");
        assertEquals(null, dishEntry);

    }
}
