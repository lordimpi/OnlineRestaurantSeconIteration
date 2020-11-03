package co.unicauca.onlinerestaurant.presentation.rest;

import co.unicauca.common.domain.entity.Dessert;

import co.unicauca.onlinerestaurant.domain.service.DessertService;
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
 * API REST
 *
 * @author Camilo Otaya
 */
@Stateless
@Path("/desserts")
public class DessertController {

    @Inject
    private DessertService service;

    public DessertController() {
        service = new DessertService();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/OnlineRestaurant-Service/restaurant-service/desserts/ 

     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Dessert> findAll() {
        return service.findAll();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/OnlineRestaurant-Service/restaurant-service/desserts/1 

     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Dessert findById(@PathParam("id") String id) {
        return service.findById(id);
    }

    /*
        Su uso desde consola mediante client url:
        curl -X POST \
          http://localhost:8085/OnlineRestaurant-Service/restaurant-service/desserts/ \
          -H 'Content-Type: application/json' \
          -d '{
               "id":1,
               "name":"Postre de fresa",
               "price":6000
        }'
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(Dessert dessert) {
        JsonResponse resp;
        if (service.create(dessert)) {
            resp = new JsonResponse(true, "Postre creado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo crear el postre", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X PUT \
          http://localhost:8085/OnlineRestaurant-Service/restaurant-service/products/1 \
          -H 'Content-Type: application/json' \
          -d '{
               "name":"Postre de fres REF. JDK3-34-343",
               "price":6000
        }'
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") String id, Dessert dessert) {
        JsonResponse resp;
        if (service.update(id, dessert)) {
            resp = new JsonResponse(true, "Postre modificado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo modificar el postre", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();

    }

    /*
        Su uso desde consola mediante client url:
        curl -X DELETE http://localhost:8085/Product-Service/product-service/desserts/1 

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
