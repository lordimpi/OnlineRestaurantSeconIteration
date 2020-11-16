package co.unicauca.dish.presentation.rest;

import co.unicauca.common.domain.entity.DishEntry;
import co.unicauca.dish.domain.service.DishEntryService;
import co.unicauca.dish.infra.DomainErrors;
import co.unicauca.dish.infra.JsonResponse;
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
 * API REST- platos de Entrada
 *
 * @author Ximena Gallego
 */
@Stateless
@Path("/dishentrys")
public class DishEntryController {

    @Inject
    private DishEntryService service;

    public DishEntryController() {
        service = new DishEntryService();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/Micro-Service-Dish/dish-service/dishentrys/ 

     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<DishEntry> findAll() {
        return service.findAll();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/Micro-Service-Dish/dish-service/dishentrys/1 

     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public DishEntry findById(@PathParam("id") String id) {
        return service.findById(id);
    }

    /*
        Su uso desde consola mediante client url:
        curl -X POST \
          http://localhost:8085/Micro-Service-Dish/dish-service/dishentrys/ \
          -H 'Content-Type: application/json' \
          -d '{
               "id":10,
               "name":"enpandas",
               "price":1000
        }'
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(DishEntry dishEntry) {
        JsonResponse resp;
        if (service.createDishEntry(dishEntry)) {
            resp = new JsonResponse(true, "Plato de Entrada creado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo crear el plato de Entrada", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X PUT \
          http://localhost:8085/Micro-Service-Dish/dish-service/dishentrys/103 \
          -H 'Content-Type: application/json' \
          -d '{
               "name":"caldo de huevo",
               "price":2400
        }'
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") String id, DishEntry dishEntry) {
        JsonResponse resp;
        if (service.updateDishEntry(id, dishEntry)) {
            resp = new JsonResponse(true, "Plato de Entrada modificado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo modificar el plato de Entrada", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();

    }

    /*
        Su uso desde consola mediante client url:
        curl -X DELETE http://localhost:8085/Micro-Service-Dish/dish-service/dishentrys/103 

     */
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        JsonResponse resp;

        if (service.delete(id)) {
            resp = new JsonResponse(true, "Plato de Entrada eliminado con éxito", null);

        } else {
            resp = new JsonResponse(false, "No se pudo eliminar el plato Entrada", DomainErrors.getErrors());
        }
        service.delete(id);

        return Response.ok().entity(resp).build();

    }

}
