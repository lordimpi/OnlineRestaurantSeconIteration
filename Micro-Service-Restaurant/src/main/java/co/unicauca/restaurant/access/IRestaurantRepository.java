package co.unicauca.restaurant.access;

import co.unicauca.common.domain.entity.Restaurant;
import java.util.List;

/**
 *
 * @author Camilo Otaya
 */
public interface IRestaurantRepository {
    
    List<Restaurant> findAll();

    Restaurant findById(String id);

    boolean create(Restaurant newRestaurant);

    boolean update(Restaurant newRestaurant);

    boolean delete(String id);
    
}
