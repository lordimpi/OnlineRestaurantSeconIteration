package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.domain.Restaurant;

/**
 * Interface que define los servicios de persistencia del Restaurante
 *
 * @author Santiago Acuña
 */
public interface IRestaurantAccess {

    /**
     * Buscar un restaurante utilizando un socket
     *
     * @param id del restaurante
     * @return objeto restaurante
     * @throws Exception error al buscar un restaurante
     */
    public Restaurant findRestaurant(String id) throws Exception;

    /**
     * Crea un Restaurante
     *
     * @param restaurant restaurante
     * @return devuelve el del restaurante creado
     * @throws Exception error crear el restaurante
     */
    public boolean createRestaurant(Restaurant restaurant) throws Exception;

    /**
     * Lista todos los restaurantes
     * @return Lista de restaurantes
     * @throws java.lang.Exception
     */
    public java.util.List<Restaurant> list() throws Exception;

}
