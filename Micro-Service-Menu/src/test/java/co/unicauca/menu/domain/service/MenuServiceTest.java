/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.menu.domain.service;

import co.unicauca.common.domain.entity.Dessert;
import co.unicauca.common.domain.entity.DishEntry;
import co.unicauca.common.domain.entity.Drink;
import co.unicauca.common.domain.entity.MainDish;
import co.unicauca.common.domain.entity.Menu;
import co.unicauca.common.domain.entity.Salad;
import co.unicauca.menu.access.IMenuRepository;
import co.unicauca.menu.access.MenuRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mariat Trujillo
 */
public class MenuServiceTest {

    public MenuServiceTest() {
    }
    /**
     * test del Menu
     */
    @Test
    public void testCRUD() {
        System.out.println("CRUD general");
        int t;

        IMenuRepository repo = new MenuRepository();
        MenuService instance = new MenuService();
        Menu expResult = new Menu();

        MainDish md = new MainDish();
        Drink d = new Drink();
        DishEntry de = new DishEntry();
        Salad s = new Salad();
        Dessert des = new Dessert();

        instance.setUserRepository(repo);
        
        List<Menu> tamaño=new ArrayList(); 
        tamaño = instance.findAll();
        t=tamaño.size();

        expResult.setId_menu("1000");
        
        md.setId_mainDish("1");
        d.setId_Drink("1");
        de.setIdDishEntry("1");
        s.setIdSalad("1");
        des.setId_Dish_Dessert("1");
        
        expResult.setDrink(d);
        expResult.setDessert(des);
        expResult.setEntry(de);
        expResult.setMaindish(md);
        expResult.setSalad(s);

        //create crea un nuevo menu 
        instance.create(expResult);

        //findById busca un menu por id
        Menu result = instance.findById("1000");
        assertEquals("1", result.getDrink().getId_Drink());
        assertEquals("1", result.getEntry().getIdDishEntry());
        assertEquals("1", result.getMaindish().getId_mainDish());
        assertEquals("1", result.getSalad().getIdSalad());
        assertEquals("1", result.getDessert().getId_Dish_Dessert());


        //findAll buscar una lista de todos los menus
        List<Menu> nresult = new ArrayList();
        nresult = instance.findAll();

        assertEquals(t+1, nresult.size());

        //Update actualizar menu
        md.setId_mainDish("2");
        d.setId_Drink("2");
        de.setIdDishEntry("2");
        s.setIdSalad("2");
        des.setId_Dish_Dessert("2");
        
        expResult.setDrink(d);
        expResult.setDessert(des);
        expResult.setEntry(de);
        expResult.setMaindish(md);
        expResult.setSalad(s);


        instance.update(expResult.getId_menu(), expResult);

        result = instance.findById("1000");
        assertEquals("2", result.getDrink().getId_Drink());
        assertEquals("2", result.getEntry().getIdDishEntry());
        assertEquals("2", result.getMaindish().getId_mainDish());
        assertEquals("2", result.getSalad().getIdSalad());
        assertEquals("2", result.getDessert().getId_Dish_Dessert());;

        //delete borrar el menu de prueba
        instance.delete("1000");
        result = instance.findById("1000");
        assertEquals(null, result);
    }
}
