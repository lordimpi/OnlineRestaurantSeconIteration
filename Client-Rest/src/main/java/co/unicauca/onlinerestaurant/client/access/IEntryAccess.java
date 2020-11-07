package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.common.domain.entity.DishEntry;

/**
 * Interface que define los servicios de persistencia de platos de Entrada del
 * restaurante
 *
 * @author Ximena Gallego
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

    /**
     * Actualiza un plato de Entrada consumiendo un API REST
     *
     * @param id Identificador del plato
     * @param name Nombre del plato de entrada
     * @param price Precio del plato de entrada
     * @return objeto plato de entrada
     * @throws Exception error al actualizar el plato
     */
    public boolean updateDishEntry(String id, String name, Double price) throws Exception;

    /**
     * Elimina un plato de Entrada consumiendo un API REST
     *
     * @param id Identificador del plato
     * @return true si se elimino correctamente el plato o false en caso
     * contrario
     * @throws Exception error al actualizar el plato
     */
    public boolean deleteDishEntry(String id) throws Exception;

    /**
     * Crea un plato consumiendo un API REST
     *
     * @param dishEntry Plato de entrada del restaurante
     * @return Devuelve el id del plato creado
     * @throws Exception error crear el plato
     */
    public boolean createDishEntry(DishEntry dishEntry) throws Exception;

    /**
     * Lista todos los platos de Entrada consumiendo un API REST
     *
     * @return Lista de platos
     * @throws java.lang.Exception
     */
    public java.util.List<DishEntry> list() throws Exception;
}
