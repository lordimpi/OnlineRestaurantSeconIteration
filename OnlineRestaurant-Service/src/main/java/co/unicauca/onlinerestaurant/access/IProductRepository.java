package co.unicauca.onlinerestaurant.access;

import co.unicauca.common.domain.entity.Product;
import java.util.List;

/**
 *
 * @author Santiago Acuña
 */
public interface IProductRepository {

    List<Product> findAll();

    Product findById(Integer id);

    boolean create(Product newProduct);

    boolean update(Product newProduct);

    boolean delete(Integer id);

}
