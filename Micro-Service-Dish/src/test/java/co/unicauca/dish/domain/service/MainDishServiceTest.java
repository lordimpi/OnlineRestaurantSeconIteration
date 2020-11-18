package co.unicauca.dish.domain.service;

import co.unicauca.common.domain.entity.MainDish;
import co.unicauca.dish.access.IMainDishRepository;
import co.unicauca.dish.access.MainDishRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mariat Trujillo
 */
public class MainDishServiceTest {

    public MainDishServiceTest() {
    }

    @Test
    public void testCrudMainDishs() {
        System.out.println("CRUD_MainDishes");
        int t;
        MainDishService service = new MainDishService();
        IMainDishRepository repo = new MainDishRepository();
        service.setMainDishRepository(repo);
        service.delete("100");
        List<MainDish> tamaño = new ArrayList();
        tamaño = service.findAll();
        t = tamaño.size();
        
        //crete
        service.create(new MainDish("100", "mainDish1", 500d)); 
        //listarlos
        List<MainDish> result = service.findAll();
        assertEquals(t+1, result.size());
        //buscar
        MainDish mainDish = service.findById("100");
        assertEquals("mainDish1", mainDish.getNameDish());
        assertEquals(500d, mainDish.getDishPrice());
        //delete
        service.delete("100");
        mainDish = service.findById("100");
        assertEquals(null, mainDish);

    }
}
