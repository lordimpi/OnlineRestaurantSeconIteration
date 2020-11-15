package co.unicauca.restaurant.presentation.rest;


import co.unicauca.common.domain.entity.Restaurant;

import co.unicauca.restaurant.domain.service.RestaurantService;
import co.unicauca.restaurant.infra.DomainErrors;
import co.unicauca.restaurant.infra.JsonResponse;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * API REST
 *
 * @author Camilo Otaya
 */
@Stateless
@Path("/restaurants")
public class RestaurantController {

    @Inject
    private RestaurantService service;

    public RestaurantController() {
        service = new RestaurantService();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/OnlineRestaurant-Service/restaurant-service/restaurants/ 

     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Restaurant> findAll() {
        return service.findAll();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/OnlineRestaurant-Service/restaurant-service/restaurants/1 

     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Restaurant findById(@PathParam("id") String id) {
        return service.findById(id);
    }

    /*
        Su uso desde consola mediante client url:
        curl -X POST \
          http://localhost:8085/OnlineRestaurant-Service/restaurant-service/restaurants/ \
          -H 'Content-Type: application/json' \
          -d '{
               "id":1,
               "name":"Postre de fresa",
               "price":6000
        }'
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(Restaurant restaurant) {
        JsonResponse resp;
        if (service.create(restaurant)) {
            resp = new JsonResponse(true, "Postre creado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo crear el postre", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X PUT \
          http://localhost:8085/OnlineRestaurant-Service/restaurant-service/restaurants/1 \
          -H 'Content-Type: application/json' \
          -d '{
               "name":"Postre de fres REF. JDK3-34-343",
               "price":6000
        }'
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") String id, Restaurant restaurant) {
        JsonResponse resp;
        if (service.update(id, restaurant)) {
            resp = new JsonResponse(true, "Postre modificado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo modificar el postre", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();

    }

    /*
        Su uso desde consola mediante client url:
        curl -X DELETE http://localhost:8085/Product-Service/product-service/restaurants/1 

     */
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        JsonResponse resp;

        if (service.delete(id)) {
            resp = new JsonResponse(true, "postre eliminado con éxito", null);

        } else {
            resp = new JsonResponse(false, "No se pudo eliminar el postre", DomainErrors.getErrors());
        }
        service.delete(id);

        return Response.ok().entity(resp).build();

    }

}