package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.client.UserJerseyClient;
import co.unicauca.common.domain.entity.User;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Interfaz donde se declara un CRUD para platos principales
 *
 * @author Camilo Otaya
 */
public class UserAccessREST implements IUserAccess {

    UserJerseyClient jersey;
    Response rta;

    public UserAccessREST() {
        this.jersey = new UserJerseyClient();
    }

    /**
     * Buscar un usuario consumiendo un API REST mediante un cliente jersey
     *
     * @param id identificado del usuario
     * @return objeto usuario
     * @throws Exception error al buscar un usuario
     */
    @Override
    public User findUser(String id) throws Exception {
        User user = jersey.findById_JSON(User.class, id);
        return user;
    }

    /**
     * Buscar un usuario consumiendo un API REST mediante un cliente jersey
     *
     * @param email identificado del usuario
     * @return objeto usuario
     * @throws Exception error al buscar un usuario
     */
    @Override
    public User findUserEmail(String email) throws Exception {
        User user = jersey.findByEmail_JSON(User.class, email);
        return user;
    }

    /**
     *
     * @param newUser Objeto de tipo usuario
     * @param email email del usuario
     * @return True si pudo modificar, false de lo contrario
     * @throws Exception error al actualizar el usuario
     */
    @Override
    public boolean updateUser(String email, User newUser) throws Exception {
        User user = findUserEmail(email);
        if (user == null) {
            return false;
        }
        User user2 = findUserEmail(newUser.getEmail());
        if (user2 != null) {
            return false;
        }
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setAddress(newUser.getAddress());
        user.setMobile(newUser.getMobile());
        user.setEmail(newUser.getEmail());
        user.setRol(newUser.getRol());
        user.setPws(newUser.getPws());
        rta = jersey.edit_JSON(user, email);
        return true;
    }

    /**
     * Elimina un usuario consumiendo un API REST mediante un cliente jersey
     *
     * @param id Identificador del usuario
     * @return true si se elimino correctamente el usuario o false en caso
     * contrario
     * @throws Exception error al actualizar el usuario
     */
    @Override
    public boolean deleteUser(String id) throws Exception {
        User user = findUser(id);
        if (user == null) {
            return false;
        }
        rta = jersey.delete(id);
        return true;
    }

    /**
     * Crea un usuario consumiendo un API REST mediante un cliente jersey
     *
     * @param user usuario del restaurante
     * @return Devuelve el id del usuario creado
     * @throws Exception error crear el usuario
     */
    @Override
    public boolean createUser(User user) throws Exception {
        User users = findUserEmail(user.getEmail());
        if (users != null) {
            return false;
        }
        rta = jersey.create_JSON(user);
        return true;
    }

    /**
     * Lista todos los usuarios consumiendo un API REST mediante un cliente
     * jersey
     *
     * @return Lista de usuarios
     * @throws java.lang.Exception
     */
    @Override
    public List<User> list() throws Exception {
        GenericType<List<User>> listResponseTypeM = new GenericType<List<User>>() {
        };
        List<User> user = jersey.findAll(listResponseTypeM);
        return user;
    }

}
