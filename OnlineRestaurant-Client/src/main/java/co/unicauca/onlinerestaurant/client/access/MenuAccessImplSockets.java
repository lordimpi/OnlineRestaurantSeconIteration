package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.client.infra.OnlineRestaurantSocket;
import co.unicauca.onlinerestaurant.commons.domain.Menu;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio de Menu. Permite hacer el CRUD de menus solicitando los servicios
 * con la aplicación server. Maneja los errores devueltos
 *
 * @author Santiago Acuña
 */
public class MenuAccessImplSockets implements IMenuAccess {

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private OnlineRestaurantSocket mySocket;

    /**
     * Contructor por defecto
     */
    public MenuAccessImplSockets() {

        this.mySocket = new OnlineRestaurantSocket();
    }

    /**
     * Busca un menu. Utiliza socket para pedir el servicio al servidor
     *
     * @param id identificador del Menu
     * @return objeto de tipo Menu
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public Menu findMenu(String id) throws Exception {
        String jsonResponse = null;
        String requestJson = findMenuRequestJson(id);
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
                Menu menu = jsonToMenu(jsonResponse);
                return menu;
            }
        }
    }

    /**
     * Busca un menu. Utiliza socket para pedir el servicio al servidor
     *
     * @param name Nombre
     * @return objeto de tipo menu
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public Menu findMenubyRN(String name) throws Exception {
        String jsonResponse = null;
        String requestJson = findMenubyRNRequestJson(name);
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
                Menu menu = jsonToMenu(jsonResponse);
                return menu;
            }
        }
    }

    /**
     * Actualiza un menu.Utiliza socket para pedir el servicio al servidor
     *
     * @param id identificador del menu
     * @param id_dish identificador del plato
     * @param id_drink identificador de la bebida
     * @param id_entry identificador de la entrada
     * @param id_salad identificador de la ensalada
     * @param id_dessert identificador del postre
     * @return true actualizacion correctamente y false en caso contrario
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public boolean updateMenu(String id, String id_dish, String id_drink, String id_entry, String id_salad, String id_dessert) throws Exception {
        String jsonResponse = null;
        String requestJson = updateMenuRequestJson(id, id_dish, id_drink, id_entry, id_salad, id_dessert);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();
            return true;

        } catch (IOException ex) {
            Logger.getLogger(CustomerAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");

        }
        return jsonResponse.contains("true");
    }

    /**
     * Elimina un Menu.Utiliza socket para pedir el servicio al servidor
     *
     * @param id identificador del menu
     * @return true si la eliminacion fue exitosa y false en caso contrario
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public boolean deleteMenu(String id) throws Exception {
        String jsonResponse = null;
        String requestJson = deleteMenuRequestJson(id);
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
        return jsonResponse.contains("true");
    }

    /**
     * Crea un Menu.Utiliza socket para pedir el servicio al servidor
     *
     * @param id identificador del menu
     * @return true si la creación fue correcta y false en caso que falle
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public boolean createMenu(String id) throws Exception {

        String jsonResponse = null;
        String requestJson = createMenuRequestJson(id);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(MainDishAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(MainDishAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            }
            return jsonResponse.contains("true");
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
     * @param idMainDish identificación del plato
     * @return solicitud de consulta del cliente en formato Json, algo como:
     * {"resource":"maindish","action":"get","parameters":[{"name":"id","value":"98000001"}]}
     */
    private String findMenuRequestJson(String idMenu) {

        Protocol protocol = new Protocol();
        protocol.setResource("menu");
        protocol.setAction("get");
        protocol.addParameter("id_menu", idMenu);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Busca una solicitud json para ser enviada por el socket
     *
     * @param name nombre
     * @return solicitud de busqueda de menu en formato Json
     */
    private String findMenubyRNRequestJson(String name) {

        Protocol protocol = new Protocol();
        protocol.setResource("menu");
        protocol.setAction("get2");
        protocol.addParameter("name", name);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * crea una solicitud json para ser enviada por el socket
     *
     * @param idMainDish
     * @return
     */
    private String updateMenuRequestJson(String id_menu, String id_dish, String id_drink, String id_entry, String id_salad, String id_dessert) {

        Protocol protocol = new Protocol();
        protocol.setResource("menu");
        protocol.setAction("put");
        protocol.addParameter("id_menu", id_menu);
        protocol.addParameter("id_dish", id_dish);
        protocol.addParameter("id_drink", id_drink);
        protocol.addParameter("id_entry", id_entry);
        protocol.addParameter("id_salad", id_salad);
        protocol.addParameter("id_dessert", id_dessert);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Elimina una solicitud json para ser enviada por el socket
     *
     * @param id identificador
     * @return cadena
     */
    private String deleteMenuRequestJson(String id) {

        Protocol protocol = new Protocol();
        protocol.setResource("menu");
        protocol.setAction("delete");
        protocol.addParameter("id_dish", id);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Crea la solicitud json de creación del maindish para ser enviado por el
     * socket
     *
     * @param id identificador
     * @return devulve algo como:
     * {"resource":"maindish","action":"post","parameters":[{"name":"id","value":"980000012"},{"name":"fistName","value":"Juan"},...}]}
     */
    private String createMenuRequestJson(String id) {

        Protocol protocol = new Protocol();
        protocol.setResource("maindish");
        protocol.setAction("post");
        protocol.addParameter("id_dish", id);
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }

    /**
     * Convierte jsonMainDish, proveniente del server socket, de json a un
     * objeto MainDish
     *
     * @param jsonMainDish objeto cliente en formato json
     */
    private Menu jsonToMenu(String jsonMenu) {

        Gson gson = new Gson();
        Menu menu = gson.fromJson(jsonMenu, Menu.class);

        return menu;

    }

}
