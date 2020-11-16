package co.unicauca.dish.access;

import co.unicauca.common.domain.entity.Drink;
import java.util.List;

/**
 *
 * @author Mariat Trujillo
 */
public interface IDrinkRepository {

    List<Drink> findAll();

    Drink findById(String id);

    boolean create(Drink newDrink);

    boolean update(Drink newDrink);

    boolean delete(String id);

}
