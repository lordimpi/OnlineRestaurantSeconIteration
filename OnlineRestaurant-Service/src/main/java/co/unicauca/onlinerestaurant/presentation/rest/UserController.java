package co.unicauca.onlinerestaurant.presentation.rest;

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
import co.unicauca.onlinerestaurant.domain.service.UserService;
import co.unicauca.common.domain.entity.User;
import javax.ws.rs.core.Response;

/**
 * API REST
 *
 * @author Camilo Otaya
 */
@Stateless
@Path("/users")
public class UserController {

    @Inject
    private UserService service;

    public UserController() {
        service = new UserService();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/OnlineRestaurant-Service/restaurant-service/users/ 

     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> findAll() {
        return service.findAll();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/OnlineRestaurant-Service/restaurant-service/users/1 

     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User findById(@PathParam("id") String id) {
        return service.findById(id);
    }

    /*
        Su uso desde consola mediante client url:
        curl -X POST \
          http://localhost:8085/OnlineRestaurant-Service/restaurant-service/users/
          -H 'Content-Type: application/json' \
          -d '{
               "id_user":1,
               "first_name":"Carlos",
               "last_name":"Anacona",
               "address":"Calle 5 #25-50",
               "mobile":"3122321234",
               "email":"carlosanacona@gmail.com",
               "rol":"Admin",
               "pws":"1"
            }'
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(User user) {
        JsonResponse resp;
        if (service.create(user)) {
            resp = new JsonResponse(true, "Usuario creado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo crear el usuario", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X PUT \
          http://localhost:8080/OnlineRestaurant-Service/restaurant-service/users/1 \
          -H 'Content-Type: application/json' \
          -d '{
               "id_user":"40",
               "first_name":"Carlos",
               "last_name":"Anacona",
               "address":"Calle 5 #25-50",
               "mobile":"3122321234",
               "email":"carlosanacona@gmail.com",
               "rol":"Admin",
               "password":"1"
        }'
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") String id, User user) {
        JsonResponse resp;
        if (service.update(id, user)) {
            resp = new JsonResponse(true, "Usuario modificado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo modificar el usuario", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();

    }

    /*
        Su uso desde consola mediante client url:
        curl -X DELETE http://localhost:8080/Product-Service/product-service/users/1 

     */
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        JsonResponse resp;

        if (service.delete(id)) {
            resp = new JsonResponse(true, "Usuario eliminado con éxito", null);

        } else {
            resp = new JsonResponse(false, "No se pudo eliminar el usuario", DomainErrors.getErrors());
        }
        service.delete(id);

        return Response.ok().entity(resp).build();

    }

}
