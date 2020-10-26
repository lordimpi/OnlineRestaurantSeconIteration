package co.unicauca.onlinerestaurant.client.access;

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
    public ICustomerAccess getCustomerService() {

        ICustomerAccess result = null;
        String type = "default";
        switch (type) {
            case "default":
                result = new CustomerAccessREST();
                break;
        }

        return result;

    }

}
