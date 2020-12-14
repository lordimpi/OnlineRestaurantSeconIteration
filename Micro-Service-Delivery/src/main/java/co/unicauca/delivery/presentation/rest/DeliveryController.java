package co.unicauca.delivery.presentation.rest;

import co.unicauca.common.domain.entity.Delivery;
import co.unicauca.common.infra.DomainErrors;
import co.unicauca.common.infra.JsonResponse;
import co.unicauca.delivery.domain.service.DeliveryService;
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
 * @author Santiago Acuña
 */
@Stateless
@Path("/deliveries")
public class DeliveryController {

    @Inject
    private DeliveryService service;

    public DeliveryController() {
        service = new DeliveryService();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/Micro-Service-Delivery/delivery-service/deliveries

     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Delivery> findAll() {
        return service.findAll();
    }

    /*
        Su uso desde consola mediante client url:
            curl -X GET http://localhost:8085/Micro-Service-Delivery/delivery-service/deliveries/1

     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Delivery findById(@PathParam("id") String id) {
        return service.findById(id);
    }


    /*
        Su uso desde consola mediante client url:
        curl -X POST \ http://localhost:8085/Micro-Service-Delivery/delivery-service/deliveries/
             {
                    "cantidad": 122,
                    "descripcion": "LLevar en un tarrito de axion con salsa de ajo",
                    "direccionEnvio": "calle jirafa",
                    "miMenu": {
                        "id_menu": "1"
                    }
              }
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(Delivery delivery) {
        JsonResponse resp;
        if (service.create(delivery)) {
            resp = new JsonResponse(true, "Pedido creado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo crear el pedido", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X PUT \
          http://localhost:8085/Micro-Service-Delivery/delivery-service/deliveries/4 \
          -H 'Content-Type: application/json' \
          -d {
                    "cantidad": 122,
                    "descripcion": "LLevar en un tarrito de axion con salsa de ajo y piña",
                    "direccionEnvio": "calle espinaca",
                    "miMenu": {
                        "id_menu": "2"
                    }
              }
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") String id, Delivery delivery) {
        JsonResponse resp;
        if (service.update(id, delivery)) {
            resp = new JsonResponse(true, "Pedido modificado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo modificar el pedido", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();

    }

    /*
        Su uso desde consola mediante client url:
        curl -X DELETE http://localhost:8085/Micro-Service-Delivery/delivery-service/deliveries/4

     */
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        JsonResponse resp;

        if (service.delete(id)) {
            resp = new JsonResponse(true, "Pedido eliminado con éxito", null);

        } else {
            resp = new JsonResponse(false, "No se pudo eliminar el pedido", DomainErrors.getErrors());
        }
        service.delete(id);

        return Response.ok().entity(resp).build();

    }
}
