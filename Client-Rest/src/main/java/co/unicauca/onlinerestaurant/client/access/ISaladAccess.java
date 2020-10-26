package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.common.domain.entity.Salad;

/**
 * Interface que define los servicios de persistencia de Ensalada del
 * restaurante
 *
 * @author soces
 */
public interface ISaladAccess {

    /**
     * Metodo encargado de Buscar una Ensalada
     *
     * @param id identificador de Ensalada
     * @return objeto de tipo Ensalada
     * @throws Exception error al buscar Ensalada
     */
    public Salad findSalad(String id) throws Exception;

}
