package co.unicauca.delivery.access;

import co.unicauca.common.domain.entity.Delivery;
import java.util.List;

/**
 *
 * @author Santiago Acuña
 */
public interface IDeliveryRepository {

    /**
     * Declaracion de busqueda de todos los pedidos
     *
     * @return
     */
    List<Delivery> findAll();

    /**
     * Declaracion del metodo buscar
     *
     * @param id Identificador de un pedido
     * @return un menu
     */
    Delivery findById(String id);

    /**
     * Declaracion del metodo crear pedido
     *
     * @param newDelivery Pedido
     * @return True si pudo crear, false de lo contrario
     */
    boolean create(Delivery newDelivery);

    /**
     * Declaracion del metodo actualizar un pedido
     *
     * @param newDelivery Pedido a Actulizar
     * @return True si pudo, false de lo contrario
     */
    boolean update(Delivery newDelivery);

    /**
     * Declaracion del metodo elimar peido
     *
     * @param id identificador del pedido
     * @return true si pudo borrar, false de lo contrario
     */
    boolean delete(String id);
}
