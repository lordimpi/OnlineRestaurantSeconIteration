package co.unicauca.user.access;

import co.unicauca.common.domain.entity.User;
import java.util.List;

/**
 *
 * @author Camilo Otaya Bravo
 */
public interface IUserRepository {

    /**
     * Declaracion del metodo listar usuarios para ser utilizado por la API REST
     *
     * @return Retorna lista de usuarios
     */
    List<User> findAll();

    /**
     * Declaracion del metodo buscar usuario por Id para ser utilizado por la
     * API REST
     *
     * @param id Identificador del usuario
     * @return Retorna un usuario
     */
    User findById(String id);

    /**
     * Declaracion del metodo crear usuario para ser utilizado por la API REST
     *
     * @param newUser Objeto de tipo usuario a crear
     * @return Retorna true si pudo crear el usuario, false de lo contrario
     */
    boolean create(User newUser);

    /**
     * Declaracion del metodo actualizar usuario para ser utilizado por la API
     * REST
     *
     * @param newUser Objeto de tipo usuario que sera actualizado
     * @return Retorna true si pudo actualizar, false de lo contrario
     */
    boolean update(User newUser);

    /**
     * Declaracion del metodo borrar usuario para ser utilizado por la API REST
     *
     * @param id Identificador del usuario
     * @return Retorna true si pudo eliminar, false de lo contrario
     */
    boolean delete(String id);

}
