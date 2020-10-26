/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.onlinerestaurant.client.access.IMenuAccess;
import co.unicauca.onlinerestaurant.commons.domain.Menu;

/**
 * Es una fachada para comunicar la presentación con el dominio
 *
 * @author Santiago Acuña
 */
public class MenuService {

    private final IMenuAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IMenuService
     */
    public MenuService(IMenuAccess service) {
        this.service = service;
    }

    /**
     * Busca un Menu en el servidor remoto
     *
     * @param id identificador del Menu
     * @return Objeto tipo menu, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Menu findMenu(String id) throws Exception {
        return service.findMenu(id);

    }

    /**
     * Busca un menu en el servidor remoto
     *
     * @param name nombre
     * @return objeto de tipo menu
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public Menu findbyMenubyRN(String name) throws Exception {
        return service.findMenubyRN(name);

    }

    /**
     * Actualiza un menu en el servidor remoto
     *
     * @param id identificador del menu
     * @param id_dish identificador del plato
     * @param id_drink identificador de la bebida
     * @param id_entry indentificador de la entrada
     * @param id_salad identificador de la ensalada
     * @param id_dessert identificador del postre
     * @return true si se realizo la actualizacion correctamente o false en caso
     * contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean updateMenu(String id, String id_dish, String id_drink, String id_entry, String id_salad, String id_dessert) throws Exception {
        return service.updateMenu(id, id_dish, id_drink, id_entry, id_salad, id_dessert);
    }

    /**
     * Elimina un menu en el servidor Remoto
     *
     * @param id identificador del menu
     * @return true si se realizo corectamente o false en caso contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean deleteMenu(String id) throws Exception {
        return service.deleteMenu(id);
    }

    /**
     * Crea un menuen el servidor remoto
     *
     * @param id identificsdor del menu
     * @return true o false
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean createMenu(String id) throws Exception {
        return service.createMenu(id);
    }

}
