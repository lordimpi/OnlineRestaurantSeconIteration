package co.unicauca.menu.access;

/**
 * Fabrica que se encarga de instanciar ProductRepository o cualquier otro que
 * se cree en el futuro. Debido a que en esta aplicación se usa inyección de
 * dependencias con el framework de JavaEE, no se utiliza esta clase.F
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

}
