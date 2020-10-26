package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.onlinerestaurant.client.access.IRestaurantAccess;
import co.unicauca.onlinerestaurant.commons.domain.Restaurant;
import java.util.List;

/**
 * Es una fachada para comunicar la presentación con el dominio
 *
 * @author Santiago Acuña
 */
public class RestaurantService {

    private final IRestaurantAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IRestaurantAccess
     */
    public RestaurantService(IRestaurantAccess service) {

        this.service = service;

    }

    /**
     * Lista todos los restaurantes
     *
     * @return Lista de restaurantes encontrados
     * @throws Exception Si no encuentra lista de restaurantes
     */
    public List<Restaurant> listRestaurants() throws Exception {
        return service.list();

    }

}
