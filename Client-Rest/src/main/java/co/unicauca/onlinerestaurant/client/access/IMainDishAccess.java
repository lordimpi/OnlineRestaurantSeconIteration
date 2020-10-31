package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.common.domain.entity.MainDish;

/**
 * Interfaz donde se declara un crud para platos
 *
 * @author Santiago Acuña
 */
public interface IMainDishAccess {

    /**
     * Buscar un plato utilizando un socket
     *
     * @param id identificado del plato principal
     * @return objeto plato
     * @throws Exception error al buscar un plato
     */
    public MainDish findMainDish(String id) throws Exception;

    /**
     * Actualiza un plato utilizando un socket
     *
     * @param id Identificador del plato
     * @param name Nombre del plato
     * @param price Precio del plato
     * @return objeto plato
     * @throws Exception error al actualizar el plato
     */
    public boolean updateMainDish(String id, String name, Double price) throws Exception;

    /**
     * Elimina un plato utilizando un una api rest
     *
     * @param id Identificador del plato
     * @return true si se elimino correctamente el plato o false en caso
     * contrario
     * @throws Exception error al actualizar el plato
     */
    public boolean deleteMainDish(String id) throws Exception;

    /**
     * Crea un plato utilizando un socket
     *
     * @param mainDish Plato del restaurante
     * @return Devuelve el id del plato creado
     * @throws Exception error crear el plato
     */
    public boolean createMainDish(MainDish mainDish) throws Exception;

    /**
     * Lista todos los platos
     *
     * @return Lista de platos
     * @throws java.lang.Exception
     */
    public java.util.List<MainDish> list() throws Exception;

}
