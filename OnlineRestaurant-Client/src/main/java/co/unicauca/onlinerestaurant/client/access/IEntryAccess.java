/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.domain.DishEntry;

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
