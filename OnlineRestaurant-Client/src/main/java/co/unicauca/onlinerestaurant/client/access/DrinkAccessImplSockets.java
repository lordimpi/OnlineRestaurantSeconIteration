package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.client.infra.OnlineRestaurantSocket;
import co.unicauca.onlinerestaurant.commons.domain.Drink;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio de Bebida. Permite hacer el CRUD de Bebidas solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 *
 * @author Mariat Trujillo
 */
public class DrinkAccessImplSockets implements IDrinkAccess {

    private OnlineRestaurantSocket mySocket;

    public DrinkAccessImplSockets() {

        this.mySocket = new OnlineRestaurantSocket();
    }

    /**
     * Busca una Bebida. Utiliza socket para pedir el servicio al servidor
     *
     * @param id identificador de la bebida
     * @return Objeto Drink
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public Drink findDrink(String id) throws Exception {

        String jsonResponse = null;
        String requestJson = findDrinkRequestJson(id);
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
                //Encontró el customer
                Drink drink = jsonToDrink(jsonResponse);
                return drink;
            }
        }

    }

    /**
     * Elimina una Bebida. Utiliza socket para pedir el servicio al servidor
     *
     * @param id identificador
     * @return true o false segunsea el caso
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public boolean deleteDrink(String id) throws Exception {

        String jsonResponse = null;
        String requestJson = deleteDrinkRequestJson(id);
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
        }
        if (jsonResponse.contains("true")) {
            return true;
        }
        return false;
    }

    /**
     * Crea una bebida. Utiliza socket para pedir el servicio al servidor
     *
     * @param drink objeto de tipo bebida
     * @return true o false
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public boolean createDrink(Drink drink) throws Exception {

        String jsonResponse = null;
        String requestJson = createDrinkRequestJson(drink);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(DrinkAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(MainDishAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            }
            if (jsonResponse.contains("true")) {

                return true;
            }
            return false;

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
     * @param idDrink identificación de la bebida
     * @return solicitud de consulta del cliente en formato Json, algo como:
     * {"resource":"drink","action":"get","parameters":[{"name":"id","value":"98000001"}]}
     */
    private String findDrinkRequestJson(String idDrink) {

        Protocol protocol = new Protocol();
        protocol.setResource("drink");
        protocol.setAction("get");
        protocol.addParameter("id_drink", idDrink);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Elimina una solicitud json para ser enviada por el socket
     *
     * @param idDrink identificación de la bebida
     * @return solicitud de eliminacion de administrador en formato Json
     */
    private String deleteDrinkRequestJson(String idDrink) {

        Protocol protocol = new Protocol();
        protocol.setResource("drink");
        protocol.setAction("delete");
        protocol.addParameter("id_drink", idDrink);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Crea la solicitud json de creación del drink para ser enviado por el
     * socket
     *
     * @param drink objeto customer
     * @return devulve algo como:
     * {"resource":"drink","action":"post","parameters":[{"name":"id","value":"980000012"},{"name":"fistName","value":"Juan"},...}]}
     */
    private String createDrinkRequestJson(Drink drink) {

        Protocol protocol = new Protocol();
        protocol.setResource("drink");
        protocol.setAction("post");
        protocol.addParameter("id_drink", drink.getId_Drink());
        protocol.addParameter("drink_name", drink.getNameDrink());
        protocol.addParameter("drink_price", Double.toString(drink.getDrinkPrice()));

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }

    /**
     * Convierte jsonMainDish, proveniente del server socket, de json a un
     * objeto Drink
     *
     * @param jsonMainDish objeto cliente en formato json
     */
    private Drink jsonToDrink(String jsonDrink) {

        Gson gson = new Gson();
        Drink drink = gson.fromJson(jsonDrink, Drink.class);

        return drink;

    }

}
