/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.domain.Salad;

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
