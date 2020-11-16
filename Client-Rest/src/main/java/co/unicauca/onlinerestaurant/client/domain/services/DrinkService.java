package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.common.domain.entity.Drink;
import co.unicauca.onlinerestaurant.client.access.IDrinkAccess;
import java.util.List;

/**
 *
 * @author Maria Teresa Trujillo
 */
public class DrinkService {

    private final IDrinkAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IDrinkService
     */
    public DrinkService(IDrinkAccess service) {
        this.service = service;
    }

    /**
     * Busca una bebida en el servidor remoto
     *
     * @param id identificador de la bebida
     * @return Objeto tipo Bebida, null si no lo encuentra
     * @throws java.lang.Exception la excepcion se lanza cuando no logra
     * conexión con el servidor
     */
    public Drink findDrink(String id) throws Exception {
        return service.findDrink(id);

    }

    /**
     * Lista objetos de tipo Drink
     *
     * @return lista de objetos drink
     * @throws Exception se lanza cuando no logra conexión con el servidor
     */
    public List<Drink> listDrinks() throws Exception {
        return service.list();
    }

    /**
     * Actualiza una bebida en el servidor remoto
     *
     * @param id identificador de la bebida
     * @param name nombre
     * @param price precio
     * @return objeto de tipo drink
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean updateDrink(String id, String name, Double price) throws Exception {
        return service.updateDrink(id, name, price);
    }

    /**
     * Elimina una bebida en el servidor remoto
     *
     * @param id identificador de la bebida
     * @return true si se realizo conrrectamente false en caso contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
     public boolean deleteDrink(String id) throws Exception {
        return service.deleteDrink(id);
    }

    /**
     * Crea una bebida en el servidor remoto
     *
     * @param drink objeto de tipo bebida
     * @return true si se creo correctamente y false en caso contrario
     * @throws Exception se lanza cuando no logra conexión con el servidor
     */
    public boolean createDrink(Drink drink) throws Exception {
        return service.createDrink(drink);

    }

}
