package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.common.domain.entity.MainDish;
import co.unicauca.onlinerestaurant.client.access.IMainDishAccess;
import java.util.List;

/**
 * Es una fachada para comunicar la presentación con el dominio
 *
 * @author Santiago Acuña
 */
public class MainDishService {

    private final IMainDishAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IMainDishService
     */
    public MainDishService(IMainDishAccess service) {
        this.service = service;
    }

    /**
     * Busca un plato en el servidor remoto
     *
     * @param id identificador del plato
     * @return Objeto tipo Plato, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public MainDish findMainDish(String id) throws Exception {
        return service.findMainDish(id);

    }

    /**
     * Lista objetos de tipo MainDish
     *
     * @return lista de objetos mainDish
     * @throws Exception se lanza cuando no logra conexión con el servidor
     */
    public List<MainDish> listDishes() throws Exception {
        return service.list();
    }

    /**
     * Actualiza un plato en el servidor remoto
     *
     * @param id identificador de plato
     * @param name nombre
     * @param price precio
     * @return objeto de tipo mainDish
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public MainDish updateMainDish(String id, String name, String price) throws Exception {
        return service.updateMainDish(id, name, price);
    }

    /**
     * Elimina un plato en el servidor remoto
     *
     * @param id identificador del plato
     * @return true si se realizo conrrectamente false en caso contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean deleteMainDish(String id) throws Exception {
        return service.deleteMainDish(id);
    }

    /**
     * Crea un plato en el servidor remoto
     *
     * @param mainDish objeto de tipo mainDish
     * @return true si se creo correctamente o false en caso contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean createMainDish(MainDish mainDish) throws Exception {
        return service.createMainDish(mainDish);

    }

}
