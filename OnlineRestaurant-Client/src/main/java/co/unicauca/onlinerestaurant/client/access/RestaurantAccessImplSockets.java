package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.client.infra.OnlineRestaurantSocket;
import co.unicauca.onlinerestaurant.commons.domain.Restaurant;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.commons.infra.Protocol;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio de Restaurante. Permite listar los restaurante solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 *
 * @author Santiago Acuña
 */
public class RestaurantAccessImplSockets implements IRestaurantAccess {

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private OnlineRestaurantSocket mySocket;
    /**
     * Constructor por defecto
     */
    public RestaurantAccessImplSockets() {
        this.mySocket = new OnlineRestaurantSocket();
    }

    /**
     * Busca un Restaurante. Utiliza socket para pedir el servicio al servidor
     *
     * @param id del restaurante
     * @return Objeto Restaurant
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public Restaurant findRestaurant(String id) throws Exception {
        String jsonResponse = null;
        String requestJson = findRestaurantRequestJson(id);
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
                Restaurant restaurant = jsonToRestaurant(jsonResponse);
                return restaurant;
            }
        }

    }

    /**
     * Crea un Restaurante. Utiliza socket para pedir el servicio al servidor
     *
     * @param restaurant Restaurante
     * @return devuelve el id del restaurante creado
     * @throws Exception error crear el restaurante
     */
    @Override
    public boolean createRestaurant(Restaurant restaurant) throws Exception {
        String jsonResponse = null;
        String requestJson = createRestaurantRequestJson(restaurant);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(CustomerAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(CustomerAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            }

            return jsonResponse.contains("true");

        }

    }

    /**
     * Crea una lista de restaurante. Utiliza un socket para pedir el servicio
     * del servidor
     *
     * @return la lista de restaurantes creada
     * @throws Exception error al crear la lista de restaurantes
     */
    @Override
    public List<Restaurant> list() throws Exception {

        String jsonResponse = null;
        String requestJson = listRestaurantRequestJson();

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
                //Encontró los restaurantes
                List<Restaurant> restaurants = jsonToRestaurantList(jsonResponse);
                return restaurants;
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
     * @param idRestaurant identificación del restaurante
     * @return solicitud de consulta del restaurante en formato Json, algo como:
     * {"resource":"restaurant","action":"get","parameters":[{"name":"id","value":"1"}]}
     */
    private String findRestaurantRequestJson(String idRestaurant) {

        Protocol protocol = new Protocol();
        protocol.setResource("restaurant");
        protocol.setAction("get");
        protocol.addParameter("id_restaurant", idRestaurant);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     * @return solicitud de consulta del restaurante en formato Json, algo como:
     * {"resource":"restaurant","action":"get","parameters":[{"name":"id","value":"1"}]}
     */
    private String listRestaurantRequestJson() {

        Protocol protocol = new Protocol();
        protocol.setResource("restaurant");
        protocol.setAction("gets");

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }

    /**
     * Crea la solicitud json de creación del restaurant para ser enviado por el
     * socket
     *
     * @param restaurant objeto restaurant
     * @return devulve algo como:
     * {"resource":"customer","action":"post","parameters":[{"name":"id","value":"1"},{"name":"resname","value":"la
     * vaquita feliz"},...}]}
     */
    private String createRestaurantRequestJson(Restaurant restaurant) {

        Protocol protocol = new Protocol();
        protocol.setResource("restaurant");
        protocol.setAction("post");
        protocol.addParameter("idres", restaurant.getIdRestaurant());
        protocol.addParameter("nameres", restaurant.getNameRestaurant());
        protocol.addParameter("addressres", restaurant.getAddressRestaurant());
        protocol.addParameter("phoneres", restaurant.getPhone());
        protocol.addParameter("idmenu", restaurant.getIdmenu());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }

    /**
     * Convierte jsonRestaurant, proveniente del server socket, de json a un
     * objeto Restaurant
     *
     * @param jsonRestaurant objeto restaurant en formato json
     */
    private Restaurant jsonToRestaurant(String jsonRestaurant) {

        Gson gson = new Gson();
        Restaurant restaurant = gson.fromJson(jsonRestaurant, Restaurant.class);

        return restaurant;

    }

    /**
     * Convierte jsonRestaurant, proveniente del server socket, de array json a
     * un list restaurant
     *
     * @param jsonRestaurant Cadena json serializado
     * @return Lista deserializada de jsonRestaurant
     */
    private List<Restaurant> jsonToRestaurantList(String jsonRestaurant) {

        Gson gson = new Gson();

        Type foundListType = new TypeToken<ArrayList<Restaurant>>() {
        }.getType();
        List<Restaurant> restaurants = gson.fromJson(jsonRestaurant, foundListType);

        return restaurants;

    }

}
