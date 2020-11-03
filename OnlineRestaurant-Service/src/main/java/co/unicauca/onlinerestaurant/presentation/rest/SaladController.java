package co.unicauca.onlinerestaurant.presentation.rest;

import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import co.unicauca.onlinerestaurant.domain.service.SaladService;
import co.unicauca.common.domain.entity.Salad;
import co.unicauca.onlinerestaurant.infra.DomainErrors;
import co.unicauca.onlinerestaurant.infra.JsonResponse;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
/**
 * API-Rest Ensalada
 *
 * @author Ximena Gallego
 */
@Stateless
@Path("/salads")
public class SaladController {
     @Inject
    private SaladService service;

    public SaladController() {
        service = new SaladService();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/OnlineRestaurant-Service/restaurant-service/salads/ 

     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Salad> findAll() {
        return service.findAll();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/OnlineRestaurant-Service/restaurant-service/salads/1 

     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Salad findById(@PathParam("id") String id) {
        return service.findById(id);
    }

    /*
        Su uso desde consola mediante client url:
        curl -X POST \
          http://localhost:8085/OnlineRestaurant-Service/restaurant-service/salads/ \
          -H 'Content-Type: application/json' \
          -d '{
               "id":1,
               "name":"frutos tropicales",
               "price":6700
        }'
    */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(Salad salad) {
        JsonResponse resp;
        if (service.createSalad(salad)) {
            resp = new JsonResponse(true, "Ensalada creada con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo crear la Ensalada", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X PUT \
          http://localhost:8085/OnlineRestaurant-Service/restaurant-service/salads/1 \
          -H 'Content-Type: application/json' \
          -d '{
               "name":"Ensalada verde",
               "price":2450
        }'
    */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") String id, Salad salad) {
        JsonResponse resp;
        if (service.update(id, salad)) {
            resp = new JsonResponse(true, "Ensalada modificada con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo modificar la Ensalada", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();

    }

    /*
        Su uso desde consola mediante client url:
        curl -X DELETE http://localhost:8085/Product-Service/product-service/salads/1 

     */
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        JsonResponse resp;

        if (service.delete(id)) {
            resp = new JsonResponse(true, "Ensalada eliminada con éxito", null);

        } else {
            resp = new JsonResponse(false, "No se pudo eliminar la ensalada", DomainErrors.getErrors());
        }
        service.delete(id);

        return Response.ok().entity(resp).build();

    }

}
