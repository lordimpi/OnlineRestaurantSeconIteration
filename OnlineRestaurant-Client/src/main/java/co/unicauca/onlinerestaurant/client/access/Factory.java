package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar CustomerServiceImplSockets o cualquier
 * otro que se cree en el futuro.
 *
 * @author Santiago Acuña
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia ICustomerService
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public ICustomerAccess getCustomerService() {

        ICustomerAccess result = null;
        String type = Utilities.loadProperty("customer.service");

        switch (type) {
            case "default":
                result = new CustomerAccessImplSockets();
                break;
        }

        return result;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IMainDishService
     *
     * @return una clase hija de la abstracción IRepositorioPlatoPrincipal
     */
    public IMainDishAccess getMainDishService() {

        IMainDishAccess result = null;
        String type = Utilities.loadProperty("maindish.service");

        switch (type) {
            case "default":
                result = new MainDishAccessImplSockets();
                break;
        }

        return result;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IDessertService
     *
     * @return una clase hija de la abstracción IRepositorioPostre
     */
    public IDessertAccess getDessertService() {

        IDessertAccess result = null;
        String type = Utilities.loadProperty("dessert.service");

        switch (type) {
            case "default":
                result = new DessertAccessImplSockets();
                break;
        }

        return result;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IRestaurantService
     *
     * @return una clase hija de la abstracción IRepositorioRestaurante
     */
    public IRestaurantAccess getRestaurantService() {

        IRestaurantAccess result = null;
        String type = Utilities.loadProperty("restaurant.service");

        switch (type) {
            case "default":
                result = new RestaurantAccessImplSockets();
                break;
        }

        return result;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IMenuService
     *
     * @return una clase hija de la abstracción IRepositorioMenu
     */
    public IMenuAccess getMenuService() {

        IMenuAccess result = null;
        String type = Utilities.loadProperty("restaurant.service");

        switch (type) {
            case "default":
                result = new MenuAccessImplSockets();
                break;
        }

        return result;
    }

    /**
     * Método que crea una instancia concreta de la jerarquia ISaladService
     *
     * @return una clase hija de la abstracción IRepositorioSalad
     */
    public ISaladAccess getSaladService() {
        ISaladAccess result = null;
        String type = Utilities.loadProperty("salad.service");

        switch (type) {
            case "default":
                result = new SaladAccessImplSockets();
                break;
        }

        return result;
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IDrinkService
     *
     * @return una clase hija de la abstracción IRepositorioDrink
     */
    public IDrinkAccess getDrinkService() {
        IDrinkAccess result = null;
        String type = Utilities.loadProperty("salad.service");

        switch (type) {
            case "default":
                result = new DrinkAccessImplSockets();
                break;
        }

        return result;
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IEntryService
     *
     * @return una clase hija de la abstracción IRepositorioEntry
     */
    public IEntryAccess getEntryService() {
        IEntryAccess result = null;
        String type = Utilities.loadProperty("entry.service");

        switch (type) {
            case "default":
                result = new EntryAccessImplSocket();
                break;
        }

        return result;
    }
}
