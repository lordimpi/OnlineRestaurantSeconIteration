package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.common.domain.entity.User;
import co.unicauca.onlinerestaurant.client.access.IUserAccess;

/**
 * Es una fachada para comunicar la presentación con el dominio
 *
 * @author Santiago Acuña
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
    public User findCustomer(String id) throws Exception {
        return service.findCustomer(id);

    }

    /**
     * Busca un cliente en el servidor remoto
     *
     * @param name
     * @param pws
     * @return
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public User findCustomer(String name, String pws) throws Exception {
        return service.findCustomer(name, pws);

    }

    /**
     * Creacion de un user
     *
     * @param user
     * @return
     * @throws Exception
     */
    public boolean createCustomer(User user) throws Exception {
        return service.createCustomer(user);

    }

}
