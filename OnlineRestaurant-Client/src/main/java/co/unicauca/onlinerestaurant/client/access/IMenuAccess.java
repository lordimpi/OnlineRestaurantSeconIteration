package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.domain.Menu;

/**
 * Interface que define los servicios de persistencia del Menu
 *
 * @author Santiago Acuña
 */
public interface IMenuAccess {

    /**
     * Metodo encargado de Buscar un menu
     *
     * @param id identificador del menu
     * @return objeto de tipo Menu
     * @throws Exception error al buscar un Menu
     */
    public Menu findMenu(String id) throws Exception;

    /**
     * Metodo encargado de Buscar un menu y restaurante
     *
     * @param name nombre
     * @return objeto de tipo Menu
     * @throws Exception error al buscar un Menu y restaurante
     */
    public Menu findMenubyRN(String name) throws Exception;

    /**
     * Metodo encargado de actualizar un Menu
     *
     * @param id identificador del menu
     * @param id_dish identificador de plato
     * @param id_drink identificador de la bebida
     * @param id_entry identificador de la entrada
     * @param id_salad identificador de la bebida
     * @param id_dessert identificador del postre
     * @return true si se actualizo correctamente y false en caso contrario
     * @throws Exception error al actualizar Menu
     */
    public boolean updateMenu(String id, String id_dish, String id_drink, String id_entry, String id_salad, String id_dessert) throws Exception;

    /**
     * Metodo de Eliminar Un Menu
     *
     * @param id identificador del menu
     * @return true si realizo correctamente y false en caso contrario
     * @throws Exception error al Eliminar Menu
     */
    public boolean deleteMenu(String id) throws Exception;

    /**
     * Metodo de Crear menu
     *
     * @param id identificador del Menu
     * @return true creado correctamente y false en caso contrario
     * @throws Exception error al crear el Menu
     */
    public boolean createMenu(String id) throws Exception;

}
