package co.unicauca.onlinerestaurant.access;

import co.unicauca.common.domain.entity.MainDish;
import java.util.List;

/**
 *
 * @author Santiago Acuña
 */
public interface IMainDish {

    List<MainDish> findAll();

    MainDish findById(String id);

    boolean create(MainDish newMainDish);

    boolean update(MainDish newMainDish);

    boolean delete(String id);
}
