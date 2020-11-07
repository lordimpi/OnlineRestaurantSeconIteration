package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.common.domain.entity.User;
import co.unicauca.onlinerestaurant.client.access.IUserAccess;

/**
 * Es una fachada para comunicar la presentación con el dominio
 *
 * @author Camilo Otaya
 */
public class UserService {

    private final IUserAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo ICustomerService
     */
    public UserService(IUserAccess service) {
        this.service = service;
    }

    /**
     * Busca un cliente en el servidor remoto
     *
     * @param id identificador del cliente
     * @return Objeto tipo Cliente, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public User findUser(String id) throws Exception {
        return service.findUser(id);

    }

    /**
     * Busca un cliente en el servidor remoto
     *
     * @param id Identificador del usuario
     * @param firstname nombre del usuario
     * @param lastname apellido del usuario
     * @param address dirección del usuario
     * @param mobile telefono del usuario
     * @param email email del usuario
     * @param rol rol del usuario
     * @param pws contraseña del usuario
     * @return
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public User findUser(String id, String firstname, String lastname, String address, String mobile, String email, String rol, String pws) throws Exception {
        return service.findUser(id);

    }

    /**
     * Creacion de un user
     *
     * @param user
     * @return
     * @throws Exception
     */
    public boolean createUser(User user) throws Exception {
        return service.createUser(user);

    }

}
