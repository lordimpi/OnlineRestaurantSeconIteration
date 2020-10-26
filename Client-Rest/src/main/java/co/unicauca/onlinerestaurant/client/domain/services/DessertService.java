package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.common.domain.entity.Dessert;
import co.unicauca.onlinerestaurant.client.access.IDessertAccess;

/**
 *
 * @author Santiago Acuña
 */
public class DessertService {

    private final IDessertAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IDessertService
     */
    public DessertService(IDessertAccess service) {
        this.service = service;
    }

    /**
     * Busca una bebida en el servidor remoto
     *
     * @param id identificador del postre
     * @return Objeto tipo Postre, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Dessert findDessert(String id) throws Exception {
        return service.findDessert(id);

    }

}
