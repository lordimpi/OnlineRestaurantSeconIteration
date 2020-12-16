package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.client.DeliveryJerseyClient;
import co.unicauca.common.domain.entity.Delivery;
import java.util.List;
import javax.ws.rs.core.GenericType;

import javax.ws.rs.core.Response;

/**
 *
 * @author Mariat
 */
public class DeliveryAccessREST implements IDeliveryAccess {

    DeliveryJerseyClient jersey;
    Response rta;

    public DeliveryAccessREST() {
        this.jersey = new DeliveryJerseyClient();
    }

    /**
     * Buscar un pedido consumiendo un API REST mediante un cliente jersey
     *
     * @param id identificado del menu
     * @return objeto postre
     * @throws Exception error al buscar un postre
     */
    @Override
    public Delivery findDelivery(String id) throws Exception {
        Delivery delivery = jersey.findById_JSON(Delivery.class, id);
        return delivery;
    }

    /**
     * Actualiza un pedido consumiendo un API REST mediante un cliente jersey
     *
     * @param id Identificador del pedido
     * @param descripcion descripcion del pedido
     * @param cantidad cantidad de pedidos
     * @param direcionEnvio
     * @return objeto pedido
     * @throws Exception error al actualizar el pedido
     */
    @Override
    public boolean updateDelivery(String id, String descripcion, Integer cantidad, String direcionEnvio) throws Exception {
        Delivery delivery = findDelivery(id);
        if (delivery == null) {
            return false;
        }
        delivery.setDescripcion(descripcion);
        delivery.setCantidad(cantidad);
        rta = jersey.edit_JSON(delivery, id);
        return true;
    }

    /**
     * Elimina un pedido consumiendo un API REST mediante un cliente jersey
     *
     * @param id Identificador del pedido
     * @return true si se elimino correctamente el pedido o false en caso
     * contrario
     * @throws Exception error al actualizar el pedido
     */
    @Override
    public boolean deleteDelivery(String id) throws Exception {
        Delivery delivery = findDelivery(id);
        if (delivery == null) {
            return false;
        }
        rta = jersey.delete(id);
        return true;
    }

    /**
     * Crea un pedido consumiendo un API REST mediante un cliente jersey
     *
     * @param delivery pedido del restaurante
     * @return Devuelve el id del pedido creado
     * @throws Exception error crear el pedido
     */
    @Override
    public boolean createDelivery(Delivery delivery) throws Exception {
        Delivery dish = findDelivery(delivery.getId_Delivery());
        if (dish != null) {
            return false;
        }
        rta = jersey.create_JSON(delivery);
        return true;
    }

    /**
     * Lista todos los platos consumiendo un API REST mediante un cliente jersey
     *
     * @return Lista de platos
     * @throws java.lang.Exception
     */
    @Override
    public List<Delivery> list() throws Exception {
        GenericType<List<Delivery>> listResponseTypeM = new GenericType<List<Delivery>>() {
        };
        List<Delivery> delivery = jersey.findAll(listResponseTypeM);
        return delivery;
    }

}
