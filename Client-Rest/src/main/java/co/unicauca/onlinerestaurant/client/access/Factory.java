package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.client.domain.services.MenuService;

/**
 * Fabrica que se encarga de instanciar TypeServiceREST o cualquier otro que se
 * cree en el futuro.
 *
 * @author Santiago Acuña
 */
public class Factory {

    private static Factory instance;

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
    public IUserAccess getCustomerService() {
        return new UserAccessREST();
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IMainDishService
     *
     * @return una clase hija de la abstracción IRepositorioPlatoPrincipal
     */
    public IMainDishAccess getMainDishService() {
        return new MainDishAccessREST();
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IRestaurantService
     *
     * @return una clase hija de la abstracción IRepositorioRestaurante
     */
    public IRestaurantAccess getRestaurantService() {
        return new RestaurantAccessREST();

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IMenuService
     *
     * @return una clase hija de la abstracción IRepositorioMenu
     */
    public IMenuAccess getMenuService() {
        return new MenuAccessREST();
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IDessertService
     *
     * @return una clase hija de la abstracción IRepositorioPostre
     */
    public IDessertAccess getDessertService() {
        return new DessertAccessREST();
    }

    /**
     * Método que crea una instancia concreta de la jerarquia ISaladService
     *
     * @return una clase hija de la abstracción IRepositorioSalad
     */
    public ISaladAccess getSaladService() {
        return new SaladAccessREST();
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IDrinkService
     *
     * @return una clase hija de la abstracción IRepositorioDrink
     */
    public IDrinkAccess getDrinkService() {
        return new DrinkAccessREST();
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IEntryService
     *
     * @return una clase hija de la abstracción IRepositorioEntry
     */
    public IEntryAccess getEntryService() {
        return new EntryAccessREST();
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IUserService
     *
     * @return una clase hija de la abstracción IRepositorioUser
     */
    public IUserAccess getUserService() {
        return new UserAccessREST();
    }
}
