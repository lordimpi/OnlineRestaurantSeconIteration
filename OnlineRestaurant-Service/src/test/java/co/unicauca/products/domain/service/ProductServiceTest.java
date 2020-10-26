package co.unicauca.products.domain.service;

import co.unicauca.onlinerestaurant.domain.service.ProductService;
import co.unicauca.onlinerestaurant.access.ProductRepository;
import co.unicauca.common.domain.entity.Product;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Libardo, Julio
 */
public class ProductServiceTest {

    /**
     * Test of CRUD products.
     */
    @Test
    public void CrudProducts() {
        System.out.println("CRUD_Products");
        ProductService service = new ProductService();
        service.setProductRepository(new ProductRepository());

        List<Product> result = service.findAll();
        assertEquals(3, result.size());

        service.create(new Product(10, "product1", 500d));

        Product prod = service.findById(10);
        assertEquals("product1", prod.getName());
        assertEquals(500d, prod.getPrice());

        service.delete(10);
        prod = service.findById(10);
        assertEquals(null, prod);

    }

}
