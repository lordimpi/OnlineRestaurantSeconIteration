package co.unicauca.dish.domain.service;

import co.unicauca.common.domain.entity.Salad;
import co.unicauca.dish.access.ISaladRepository;
import co.unicauca.dish.access.SaladRepository;
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
public class SaladServiceTest {
    
    public SaladServiceTest() {
    }
    
  
     @Test
    public void testCrudSalads() {
        System.out.println("CRUD_Salads");
        int t;
        SaladService service = new SaladService();
        ISaladRepository repo= new SaladRepository();
        service.setSaladRepository(repo);
        service.delete("100");
        List<Salad> tamaño = new ArrayList();
        tamaño = service.findAll();
        t = tamaño.size();
        //crete
        service.create(new Salad("100", "salad1", 500d));
        //listarlos
        List<Salad> result = service.findAll();
        assertEquals(t+1, result.size());
        //buscar
        Salad salad = service.findById("100");
        assertEquals("salad1", salad.getNameSalad());
        assertEquals(500d, salad.getCostSalad());
        //delete
        service.delete("100");
        salad = service.findById("100");
        assertEquals(null, salad);

    }
}
