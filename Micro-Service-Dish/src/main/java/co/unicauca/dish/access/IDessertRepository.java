package co.unicauca.dish.access;

import co.unicauca.common.domain.entity.Dessert;
import java.util.List;

/**
 *
 * @author Camilo Otaya
 */
public interface IDessertRepository {
    
    List<Dessert> findAll();

    Dessert findById(String id);

    boolean create(Dessert newDessert);

    boolean update(Dessert newDessert);

    boolean delete(String id);
    
}
