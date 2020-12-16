package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.common.domain.entity.Delivery;
import co.unicauca.onlinerestaurant.client.access.IDeliveryAccess;
import java.util.List;

/**
 *
 * @author Mariat
 */
public class DeliveryService {
    
    private final IDeliveryAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IDeliveryService
     */
    public DeliveryService(IDeliveryAccess service) {
        this.service = service;
    }
    
    /**
     * Busca un pedido en el servidor remoto
     *
     * @param id identificador del pedido
     * @return Objeto tipo Pedido, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Delivery findDelivery(String id) throws Exception {
        return service.findDelivery(id);

    }
    
     /**
     * Lista objetos de tipo Dessert
     *
     * @return lista de objetos dessert
     * @throws Exception se lanza cuando no logra conexión con el servidor
     */
    public List<Delivery> listDelivery() throws Exception {
        return service.list();
    }
    
    /**
     * Actualiza un pedido en el servidor remoto
     *
     * @param id Identificador del pedido
     * @param descripcion descripcion del pedido
     * @param cantidad cantidad de pedidos
     * @param direccionEnvio
     * @return objeto de tipo delivery
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean updateDelivery(String id, String descripcion, Integer cantidad, String direccionEnvio) throws Exception {
        return service.updateDelivery(id, descripcion, cantidad, direccionEnvio);
    }
    
    /**
     * Elimina un pedido en el servidor remoto
     *
     * @param id identificador del pedido
     * @return true si se realizo conrrectamente false en caso contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean deleteDelivery(String id) throws Exception {
        return service.deleteDelivery(id);
    }
    
    
     /**
     * Crea un pedido en el servidor remoto
     *
     * @param delivery objeto de tipo delivery
     * @return true si se creo correctamente o false en caso contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean createDelivery(Delivery delivery) throws Exception {
        return service.createDelivery(delivery);

    }


    
}
