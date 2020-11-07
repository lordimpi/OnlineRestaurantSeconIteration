package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.common.domain.entity.DishEntry;
import co.unicauca.onlinerestaurant.client.access.IEntryAccess;
import java.util.List;

/**
 *
 * @author Santiago Acuña
 */
public class EntryService {

    private final IEntryAccess service;

    /**
     * Constructor que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IEntryService
     */
    public EntryService(IEntryAccess service) {
        this.service = service;
    }

    /**
     * Busca una Entry en el servidor remoto
     *
     * @param id identificador de la entrada
     * @return Objeto tipo Entrada, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public DishEntry findEntry(String id) throws Exception {
        return service.findEntry(id);

    }
     /**
     * Lista objetos de tipo DishEntry
     *
     * @return lista de objetos dishEntry
     * @throws Exception se lanza cuando no logra conexión con el servidor
     */
    public List<DishEntry> listEntrys() throws Exception {
        return service.list();
    }

    /**
     * Actualiza un plato de entrada en el servidor remoto
     *
     * @param id identificador de plato de entrada
     * @param name nombre
     * @param price precio
     * @return objeto de tipo DishEntry
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean updateDishEntry(String id, String name, Double price) throws Exception {
        return service.updateDishEntry(id, name, price);
    }

    /**
     * Elimina un plato de entrada en el servidor remoto
     *
     * @param id identificador del plato de entrada
     * @return true si se realizo conrrectamente false en caso contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean deleteDishEntry(String id) throws Exception {
        return service.deleteDishEntry(id);
    }

    /**
     * Crea un plato de entrada en el servidor remoto
     *
     * @param dishEntry objeto de tipo mainDish
     * @return true si se creo correctamente o false en caso contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean createDishEntry(DishEntry dishEntry) throws Exception {
        return service.createDishEntry(dishEntry);

    }

}
