package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.common.domain.entity.Dessert;
import co.unicauca.onlinerestaurant.client.access.IDessertAccess;
import java.util.List;

/**
 *
 * @author Sebastian Camilo
 */
public class DessertService {

    private final IDessertAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IDessertService
     */
    public DessertService(IDessertAccess service) {
        this.service = service;
    }

    /**
     * Busca un postre en el servidor remoto
     *
     * @param id identificador del postre
     * @return Objeto tipo Postre, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Dessert findDessert(String id) throws Exception {
        return service.findDessert(id);

    }

    /**
     * Lista objetos de tipo Dessert
     *
     * @return lista de objetos dessert
     * @throws Exception se lanza cuando no logra conexión con el servidor
     */
    public List<Dessert> listDishes() throws Exception {
        return service.list();
    }

    /**
     * Actualiza un postre en el servidor remoto
     *
     * @param id identificador de un postre
     * @param name nombre del postre
     * @param cost precio del postre
     * @return objeto de tipo dessert
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean updateDessert(String id, String name, Double cost) throws Exception {
        return service.updateDessert(id, name, cost);
    }

    /**
     * Elimina un postre en el servidor remoto
     *
     * @param id identificador del postre
     * @return true si se realizo conrrectamente false en caso contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean deleteDessert(String id) throws Exception {
        return service.deleteDessert(id);
    }

    /**
     * Crea un postre en el servidor remoto
     *
     * @param dessert objeto de tipo dessert
     * @return true si se creo correctamente o false en caso contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean createDessert(Dessert dessert) throws Exception {
        return service.createDessert(dessert);

    }

}
