package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.client.RestaurantJerseyClient;
import co.unicauca.common.domain.entity.Restaurant;
import co.unicauca.common.domain.entity.Restaurant;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * 
 * @author Santiago Acuña
 */
public class RestaurantAccessREST implements IRestaurantAccess{
     RestaurantJerseyClient jersey;
    Response rta;

    public RestaurantAccessREST() {
        this.jersey = new RestaurantJerseyClient();
    }

    /**
     * Buscar un usuario consumiendo un API REST mediante un cliente jersey
     *
     * @param id identificado del usuario
     * @return objeto usuario
     * @throws Exception error al buscar un usuario
     */
    @Override
    public Restaurant findRestaurant(String id) throws Exception {
        Restaurant user = jersey.findById_JSON(Restaurant.class, id);
        return user;
    }
  
    @Override
    public List<Restaurant> list() throws Exception {
        GenericType<List<Restaurant>> listResponseTypeM = new GenericType<List<Restaurant>>() {
        };
        List<Restaurant> user = jersey.findAll(listResponseTypeM);
        return user;
    }

}
