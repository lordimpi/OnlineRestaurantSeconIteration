package co.unicauca.onlinerestaurant.presentation.rest;

import co.unicauca.common.domain.entity.MainDish;
import co.unicauca.onlinerestaurant.domain.service.MainDishService;
import co.unicauca.onlinerestaurant.infra.DomainErrors;
import co.unicauca.onlinerestaurant.infra.JsonResponse;
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
 *
 * @author Santiago Acuña
 */
/**
 * API REST
 *
 * @author Santiago Acuña
 */
@Stateless
@Path("/maindishes")
public class MainDishController {

    @Inject
    private MainDishService service;

    public MainDishController() {
        service = new MainDishService();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/OnlineRestaurant-Service/restaurant-service/maindishes/ 

     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<MainDish> findAll() {
        return service.findAll();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/OnlineRestaurant-Service/restaurant-service/maindishes/1 

     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public MainDish findById(@PathParam("id") String id) {
        return service.findById(id);
    }

    /*
        Su uso desde consola mediante client url:
        curl -X POST \
          http://localhost:8085/OnlineRestaurant-Service/restaurant-service/maindishes/ \
          -H 'Content-Type: application/json' \
          -d '{
               "id":101,
               "name":"Alitas de pollo",
               "price":20000
        }'
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(MainDish mainDish) {
        JsonResponse resp;
        if (service.create(mainDish)) {
            resp = new JsonResponse(true, "Plato principal creado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo crear el plato principal", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X PUT \
          http://localhost:8085/OnlineRestaurant-Service/restaurant-service/maindishes/103 \
          -H 'Content-Type: application/json' \
          -d '{
               "name":"caldo de huevo",
               "price":2400
        }'
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") String id, MainDish mainDish) {
        JsonResponse resp;
        if (service.update(id, mainDish)) {
            resp = new JsonResponse(true, "Plato principal modificado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo modificar el plato principal", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();

    }

    /*
        Su uso desde consola mediante client url:
        curl -X DELETE http://localhost:8080/Product-Service/product-service/maindishes/103 

     */
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        JsonResponse resp;

        if (service.delete(id)) {
            resp = new JsonResponse(true, "Plato principal eliminado con éxito", null);

        } else {
            resp = new JsonResponse(false, "No se pudo eliminar el plato principal", DomainErrors.getErrors());
        }
        service.delete(id);

        return Response.ok().entity(resp).build();

    }
}
