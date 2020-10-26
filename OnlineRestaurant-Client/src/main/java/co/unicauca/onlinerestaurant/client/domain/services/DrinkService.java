/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.onlinerestaurant.client.access.IDrinkAccess;
import co.unicauca.onlinerestaurant.commons.domain.Drink;

/**
 * Es una fachada para comunicar la presentación con el dominio
 *
 * @author Mariat Trujillo
 */
public class DrinkService {

    private final IDrinkAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IDrinkService
     */
    public DrinkService(IDrinkAccess service) {
        this.service = service;
    }

    /**
     * Busca una bebida en el servidor remoto
     *
     * @param id identificador de la bebida
     * @return Objeto tipo Bebida, null si no lo encuentra
     * @throws java.lang.Exception la excepcion se lanza cuando no logra
     * conexión con el servidor
     */
    public Drink findDrink(String id) throws Exception {
        return service.findDrink(id);

    }

    /**
     * Elimina una bebida en el servidor remoto
     *
     * @param id identificador de la bebida
     * @throws Exception la excepcion se lanza cuando no logra conexión con el
     * servidor
     */
    public void deleteDrink(String id) throws Exception {
        service.deleteDrink(id);

    }

    /**
     * Crea una bebida en el servidor remoto
     *
     * @param drink objeto de tipo bebida
     * @return true si se creo correctamente y false en caso contrario
     * @throws Exception se lanza cuando no logra conexión con el servidor
     */
    public boolean createDrink(Drink drink) throws Exception {
        return service.createDrink(drink);

    }

}
