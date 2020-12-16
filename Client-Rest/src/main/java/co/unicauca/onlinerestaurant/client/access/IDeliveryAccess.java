package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.common.domain.entity.Delivery;

/**
 *
 * @author Mariat
 */
public interface IDeliveryAccess {

    /**
     * Buscar un pedido utilizando un socket
     *
     * @param id identificado del postre principal
     * @return objeto postre
     * @throws Exception error al buscar un plato
     */
    public Delivery findDelivery(String id) throws Exception;

    /**
     * Actualiza un postre consumiendo un API REST
     *
     * @param id Identificador del pedido
     * @param descripcion descripcion del pedido
     * @param cantidad cantidad de pedidos
     * @param direcionEnvio
     * @return objeto pedido
     * @throws Exception error al actualizar el pedido
     */
    public boolean updateDelivery(String id, String descripcion, Integer cantidad, String direcionEnvio) throws Exception;

    /**
     * Elimina un pedido consumiendo un API REST
     *
     * @param id Identificador del pedido
     * @return true si se elimino correctamente el postre o false en caso
     * contrario
     * @throws Exception error al actualizar el pedido
     */
    public boolean deleteDelivery(String id) throws Exception;

    /**
     * Crea un pedido consumiendo un API REST
     *
     * @param delivery pedido del restaurante
     * @return Devuelve el id del pedido creado
     * @throws Exception error crear el pedido
     */
    public boolean createDelivery(Delivery delivery) throws Exception;

    /**
     * Lista todos los postres consumiendo un API REST
     *
     * @return Lista de postres
     * @throws java.lang.Exception
     */
    public java.util.List<Delivery> list() throws Exception;

}
