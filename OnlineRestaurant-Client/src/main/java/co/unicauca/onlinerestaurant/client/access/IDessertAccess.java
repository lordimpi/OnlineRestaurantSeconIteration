package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.domain.Dessert;

/**
 * Interface que define los servicios de persistencia de Dessert del restaurante
 *
 * @author Camilo Otaya
 */
public interface IDessertAccess {

    /**
     * Buscar un postre utilizando un socket
     *
     * @param id identificado del postre principal
     * @return objeto postre
     * @throws Exception error al buscar un plato
     */
    public Dessert findDessert(String id) throws Exception;

}
