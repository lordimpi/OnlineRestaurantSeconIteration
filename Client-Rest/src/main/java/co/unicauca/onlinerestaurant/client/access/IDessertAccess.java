package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.common.domain.entity.Dessert;

/**
 * Interface que define los servicios de persistencia de Dessert del restaurante
 *
 * @author Camilo Otaya
 */
public interface IDessertAccess {

    /**
     * Buscar un postre utilizando un socket
     *
     * @param id identificado del postre principal
     * @return objeto postre
     * @throws Exception error al buscar un plato
     */
    public Dessert findDessert(String id) throws Exception;

    /**
     * Actualiza un postre consumiendo un API REST
     *
     * @param id Identificador del postre
     * @param name Nombre del postre
     * @param cost Precio del postre
     * @return objeto plato
     * @throws Exception error al actualizar el plato
     */
    public boolean updateDessert(String id, String name, Double cost) throws Exception;

    /**
     * Elimina un postre consumiendo un API REST
     *
     * @param id Identificador del postre
     * @return true si se elimino correctamente el postre o false en caso
     * contrario
     * @throws Exception error al actualizar el postre
     */
    public boolean deleteDessert(String id) throws Exception;

    /**
     * Crea un postre consumiendo un API REST
     *
     * @param dessert Postre del restaurante
     * @return Devuelve el id del postre creado
     * @throws Exception error crear el postre
     */
    public boolean createDessert(Dessert dessert) throws Exception;

    /**
     * Lista todos los postres consumiendo un API REST
     *
     * @return Lista de postres
     * @throws java.lang.Exception
     */
    public java.util.List<Dessert> list() throws Exception;

}
