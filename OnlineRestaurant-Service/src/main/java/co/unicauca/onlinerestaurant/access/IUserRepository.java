package co.unicauca.onlinerestaurant.access;

import java.util.List;
import co.unicauca.common.domain.entity.User;

/**
 *
 * @author Camilo Otaya
 */
public interface IUserRepository {

    List<User> findAll();

    User findById(String id);

    boolean create(User newUser);

    boolean update(User newUser);

    boolean delete(String id);

}
