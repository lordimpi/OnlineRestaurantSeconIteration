package co.unicauca.onlinerestaurant.infra;

/**
 * Utilidades varias utilizadas por otras clases
 *
 * @author Santiago Acuña
 */
public class Utilities {

    /**
     * Verifica si un String contiene sólo digitos
     *
     * @param str Cadena a verificvar
     * @return true si contiene sólo digitos, false en caso contrario
     */
    public static boolean isNumeric(String str) {

        boolean resultado;

        try {
            Integer.parseInt(str);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

}
