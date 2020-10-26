package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.common.domain.entity.Salad;
import co.unicauca.onlinerestaurant.client.access.ISaladAccess;

/**
 *
 * @author Santiago Acuña
 */
public class SaladService {

    private final ISaladAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo ICustomerService
     */
    public SaladService(ISaladAccess service) {
        this.service = service;
    }

    /**
     * Busca una ensalada en servidor remoto
     *
     * @param id identificador de la ensalada
     * @return objeto de tipo salad
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public Salad findSalad(String id) throws Exception {
        return service.findSalad(id);

    }

}
