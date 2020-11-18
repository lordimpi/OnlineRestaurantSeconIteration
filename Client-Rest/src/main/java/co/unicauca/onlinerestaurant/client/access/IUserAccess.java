package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.common.domain.entity.User;

/**
 * Interface que define los servicios de persistencia de Clientes del
 * restaurante
 *
 * @author Camilo Otaya
 */
public interface IUserAccess {

    /**
     * Buscar un usuario consumiendo un API REST
     *
     * @param id identificado del usuario
     * @return objeto usuario
     * @throws Exception error al buscar un usuario
     */
    public User findUser(String id) throws Exception;

    /**
     * Buscar un usuario consumiendo un API REST
     *
     * @param email identificado del usuario
     * @return objeto usuario
     * @throws Exception error al buscar un usuario
     */
    public User findUserEmail(String email) throws Exception;

    /**
     * Actualiza un usuario consumiendo un API REST
     *
     * @param email email del usuario
     * @param user Objeto de tipo usuario
     * @return objeto usuario
     * @throws Exception error al actualizar el usuario
     */
    public boolean updateUser(String email, User user) throws Exception;
    /**
     * Elimina un usuario consumiendo un API REST
     *
     * @param email Identificador del usuario
     * @return true si se elimino correctamente el usuario o false en caso
     * contrario
     * @throws Exception error al actualizar el usuario
     */
    public boolean deleteUser(String email) throws Exception;

    /**
     * Crea un usuario consumiendo un API REST
     *
     * @param user Usuario del restaurante
     * @return Devuelve el id del usuario creado
     * @throws Exception error crear el usuario
     */
    public boolean createUser(User user) throws Exception;

    /**
     * Lista todos los usuarios consumiendo un API REST
     *
     * @return Lista de usuarios
     * @throws java.lang.Exception
     */
    public java.util.List<User> list() throws Exception;

}
