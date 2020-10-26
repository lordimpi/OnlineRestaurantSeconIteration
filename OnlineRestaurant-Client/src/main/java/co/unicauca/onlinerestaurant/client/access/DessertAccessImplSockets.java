package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.client.infra.OnlineRestaurantSocket;
import co.unicauca.onlinerestaurant.commons.domain.Dessert;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio de Postre. Permite hacer el CRUD de postre solicitando los servicios
 * con la aplicación server. Maneja los errores devueltos
 *
 * @author Camilo Otaya
 */
public class DessertAccessImplSockets implements IDessertAccess {

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private OnlineRestaurantSocket mySocket;

    public DessertAccessImplSockets() {
        mySocket = new OnlineRestaurantSocket();
    }

    /**
     * Busca un postre. Utiliza socket para pedir el servicio al servidor
     *
     * @param id del postre para el menú
     * @return Objeto Postre
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public Dessert findDessert(String id) throws Exception {
        String jsonResponse = null;
        String requestJson = findDessertRequestJson(id);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(CustomerAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(CustomerAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el postre
                Dessert dessert = jsonToDessert(jsonResponse);
                return dessert;
            }
        }

    }

    /**
     * Extra los mensajes de la lista de errores
     *
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    /**
     * Convierte el jsonError a un array de objetos jsonError
     *
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     *
     * @param idDessert identificación de postre
     * @return solicitud de consulta del cliente en formato Json, algo como:
     * {"resource":"customer","action":"get","parameters":[{"name":"id","value":"98000001"}]}
     */
    private String findDessertRequestJson(String idDessert) {

        Protocol protocol = new Protocol();
        protocol.setResource("dessert");
        protocol.setAction("get");
        protocol.addParameter("id_dessert", idDessert);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Convierte jsonCustomer, proveniente del server socket, de json a un
     * objeto Dessert
     *
     * @param jsonDessert objeto cliente en formato json
     */
    private Dessert jsonToDessert(String jsonDessert) {

        Gson gson = new Gson();
        Dessert dessert = gson.fromJson(jsonDessert, Dessert.class);

        return dessert;

    }

}
