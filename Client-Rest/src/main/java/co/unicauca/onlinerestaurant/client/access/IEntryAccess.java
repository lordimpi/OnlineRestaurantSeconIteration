package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.common.domain.entity.DishEntry;

/**
 * Interface que define los servicios de persistencia de platos de Entrada del
 * restaurante
 *
 * @author soces
 */
public interface IEntryAccess {

    /**
     * Buscar un plato de Entrada utilizando un socket
     *
     * @param id identificado del plato de entrada principal
     * @return objeto plato de entrada
     * @throws Exception error al buscar un plato de entrada
     */
    public DishEntry findEntry(String id) throws Exception;

}
