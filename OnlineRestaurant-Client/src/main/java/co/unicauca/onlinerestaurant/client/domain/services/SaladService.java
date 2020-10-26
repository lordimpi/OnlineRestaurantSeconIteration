/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.onlinerestaurant.client.access.ISaladAccess;
import co.unicauca.onlinerestaurant.commons.domain.Salad;

/**
 * Es una fachada para comunicar la presentación con el dominio
 *
 * @author soces
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
