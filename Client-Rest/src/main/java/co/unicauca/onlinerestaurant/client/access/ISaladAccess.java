package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.common.domain.entity.Salad;

/**
 * Interface que define los servicios de persistencia de Ensalada del
 * restaurante
 *
 * @author Ximena Gallego
 */
public interface ISaladAccess {

    /**
     * Buscar un plato consumiendo un API REST
     *
     * @param id identificado de la ensalada
     * @return objeto ensalada
     * @throws Exception error al buscar una ensalada
     */
    public Salad findSalad(String id) throws Exception;

    /**
     * Actualiza una ensalada consumiendo un API REST
     *
     * @param id Identificador de la ensalada
     * @param name Nombre de la ensalada
     * @param price Precio de la ensalada
     * @return objeto ensalada
     * @throws Exception error al actualizar la ensalada
     */
    public boolean updateSalad(String id, String name, Double price) throws Exception;

    /**
     * Elimina una ensalada consumiendo un API REST
     *
     * @param id Identificador de la ensalada
     * @return true si se elimino correctamente la ensalada o false en caso
     * contrario
     * @throws Exception error al actualizar la ensalada
     */
    public boolean deleteSalad(String id) throws Exception;

    /**
     * Crea una ensalada consumiendo un API REST
     *
     * @param salad ensalada del restaurante
     * @return Devuelve el id de la ensalada creado
     * @throws Exception error crear la ensalada
     */
    public boolean createSalad(Salad salad) throws Exception;

    /**
     * Lista todos las ensaladas consumiendo un API REST
     *
     * @return Lista de ensaladas
     * @throws java.lang.Exception
     */
    public java.util.List<Salad> list() throws Exception;

}
