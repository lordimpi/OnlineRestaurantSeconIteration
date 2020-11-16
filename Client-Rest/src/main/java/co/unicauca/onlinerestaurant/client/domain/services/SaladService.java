package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.common.domain.entity.Salad;
import co.unicauca.onlinerestaurant.client.access.ISaladAccess;
import java.util.List;

/**
 * Es una fachada para comunicar la presentación con el dominio
 *
 * @author Ximena Gallego
 */
public class SaladService {

    private final ISaladAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo ICustomerService
     */
    public SaladService(ISaladAccess service) {
        this.service = service;
    }

    /**
     * Busca una ensalada en servidor remoto
     *
     * @param id identificador de la ensalada
     * @return objeto de tipo salad
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public Salad findSalad(String id) throws Exception {
        return service.findSalad(id);

    }

    /**
     * Lista objetos de tipo Salad
     *
     * @return lista de objetos salad
     * @throws Exception se lanza cuando no logra conexión con el servidor
     */
    public List<Salad> listSalads() throws Exception {
        return service.list();
    }

    /**
     * Actualiza una ensalada en el servidor remoto
     *
     * @param id identificador de la ensalada
     * @param name nombre
     * @param price precio
     * @return objeto de tipo salad
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean updateSalad(String id, String name, Double price) throws Exception {
        return service.updateSalad(id, name, price);
    }

    /**
     * Elimina una ensalada en el servidor remoto
     *
     * @param id identificador de la ensalada
     * @return true si se realizo conrrectamente false en caso contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean deleteSalad(String id) throws Exception {
        return service.deleteSalad(id);
    }

    /**
     * Crea una ensalada en el servidor remoto
     *
     * @param salad objeto de tipo salad
     * @return true si se creo correctamente o false en caso contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean createSalad(Salad salad) throws Exception {
        return service.createSalad(salad);

    }

}
