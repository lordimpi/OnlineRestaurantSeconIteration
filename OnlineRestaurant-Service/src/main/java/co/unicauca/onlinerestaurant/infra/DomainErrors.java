package co.unicauca.onlinerestaurant.infra;

import java.util.ArrayList;
import java.util.List;

/**
 * Lista de errores de validación del dominio
 *
 * @author Santiago Acuña
 *
 */
public class DomainErrors {

    /**
     * Lista de errores
     */
    private static List<Error> errors = new ArrayList<>();

    // GETTERS AND SETTERS
    public static List<Error> getErrors() {
        return errors;
    }

    public static void setErrors(List<Error> errors) {
        DomainErrors.errors = errors;
    }

}
