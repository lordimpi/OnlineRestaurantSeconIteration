package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.common.domain.entity.Customer;
import co.unicauca.onlinerestaurant.client.access.ICustomerAccess;

/**
 * Es una fachada para comunicar la presentación con el dominio
 *
 * @author Santiago Acuña
 */
public class CustomerService {

    private final ICustomerAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo ICustomerService
     */
    public CustomerService(ICustomerAccess service) {
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
    public Customer findCustomer(String id) throws Exception {
        return service.findCustomer(id);

    }
    /**
     * Busca un cliente en el servidor remoto
     * @param name
     * @param pws
     * @return
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Customer findCustomer(String name,String pws) throws Exception {
        return service.findCustomer(name,pws);

    }

    /**
     * Creacion de un Customer
     * @param customer
     * @return
     * @throws Exception 
     */
    public boolean createCustomer(Customer customer) throws Exception {
        return service.createCustomer(customer);

    }

}
