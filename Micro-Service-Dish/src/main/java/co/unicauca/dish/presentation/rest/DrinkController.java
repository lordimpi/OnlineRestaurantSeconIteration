package co.unicauca.dish.presentation.rest;

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
import co.unicauca.dish.domain.service.DrinkService;
import co.unicauca.common.domain.entity.Drink;
import co.unicauca.dish.infra.DomainErrors;
import co.unicauca.dish.infra.JsonResponse;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * API REST
 *
 * @author Mariat Trujillo
 */
@Stateless
@Path("/drinks")
public class DrinkController {

    @Inject
    private DrinkService service;

    public DrinkController() {
        service = new DrinkService();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/Micro-Service-Dish/dish-service/drinks/ 

     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Drink> findAll() {
        return service.findAll();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/Micro-Service-Dish/dish-service/drinks/1 

     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Drink findById(@PathParam("id") String id) {
        return service.findById(id);
    }

    /*
        Su uso desde consola mediante client url:
        curl -X POST \
          http://localhost:8085/Micro-Service-Dish/dish-service/drinks/ \
          -H 'Content-Type: application/json' \
          -d '{
    
        }'
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(Drink drink) {
        JsonResponse resp;
        if (service.create(drink)) {
            resp = new JsonResponse(true, "Bebida creado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo crear la bebida", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X PUT \
          http://localhost:8085/Micro-Service-Dish/dish-service/drinks/1 \
          -H 'Content-Type: application/json' \
          -d '{
               
        }'
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") String id, Drink drink) {
        JsonResponse resp;
        if (service.update(id, drink)) {
            resp = new JsonResponse(true, "Bebida modificada con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo modificar la bebida", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();

    }

    /*
        Su uso desde consola mediante client url:
        curl -X DELETE http://localhost:8085/Micro-Service-Dish/dish-service/drinks/1 

     */
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        JsonResponse resp;

        if (service.delete(id)) {
            resp = new JsonResponse(true, "Bebida eliminada con éxito", null);

        } else {
            resp = new JsonResponse(false, "No se pudo eliminar la bebida", DomainErrors.getErrors());
        }
        service.delete(id);

        return Response.ok().entity(resp).build();

    }
}
