/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.onlinerestaurant.client.access.IEntryAccess;
import co.unicauca.onlinerestaurant.commons.domain.DishEntry;

/**
 * Es una fachada para comunicar la presentación con el dominio
 *
 * @author soces
 */
public class EntryService {

    private final IEntryAccess service;

    /**
     * Constructor que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IEntryService
     */
    public EntryService(IEntryAccess service) {
        this.service = service;
    }

    /**
     * Busca una Entry en el servidor remoto
     *
     * @param id identificador de la entrada
     * @return Objeto tipo Entrada, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public DishEntry findEntry(String id) throws Exception {
        return service.findEntry(id);

    }

}
