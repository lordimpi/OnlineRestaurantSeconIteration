package co.unicauca.menu.presentation.rest;


import co.unicauca.common.domain.entity.Menu;

import co.unicauca.menu.domain.service.MenuService;
import co.unicauca.menu.infra.DomainErrors;
import co.unicauca.menu.infra.JsonResponse;
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
 * @author Julian Rodriguez
 */
@Stateless
@Path("/menus")
public class MenuController {

    @Inject
    private MenuService service;

    public MenuController() {
        service = new MenuService();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/Micro-Service-Menu/menu-service/menus/ 

     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Menu> findAll() {
        return service.findAll();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/Micro-Service-Menu/menu-service/menus/1 

     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Menu findById(@PathParam("id") String id) {
        return service.findById(id);
    }

    /*
        Su uso desde consola mediante client url:
        curl -X POST \
         http://localhost:8085/Micro-Service-Menu/menu-service/menus/ \
          -H 'Content-Type: application/json' \
        {
     "dessert": {
        "id_Dish_Dessert": "2"
    },
    "drink": {
        "id_Drink": "2"   
    },
    "entry": {
        "idDishEntry": "2"
    },
    "id_menu": "1000",
    "maindish": {
        "id_mainDish": "1"    
    },
    "salad": {
        "idSalad": "1"
    }
}
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(Menu menu) {
        JsonResponse resp;
        if (service.create(menu)) {
            resp = new JsonResponse(true, "Menu creado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo crear el menu", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X PUT \
          http://localhost:8085/Micro-Service-Menu/menu-service/menus/1000 \
          -H 'Content-Type: application/json' \
          -d '{
    "dessert": {
        "id_Dish_Dessert": "2"
    },
    "drink": {
        "id_Drink": "2"   
    },
    "entry": {
        "idDishEntry": "2"
    },
    "id_menu": "1000",
    "maindish": {
        "id_mainDish": "1"    
    },
    "salad": {
        "idSalad": "1"
    }
}'
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") String id, Menu menu) {
        JsonResponse resp;
        if (service.update(id, menu)) {
            resp = new JsonResponse(true, "Menu modificado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo modificar el menu", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();

    }

    /*
        Su uso desde consola mediante client url:
        curl -X DELETE http://localhost:8085/Micro-Service-Menu/menu-service/menus/1000

     */
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        JsonResponse resp;

        if (service.delete(id)) {
            resp = new JsonResponse(true, "menu eliminado con éxito", null);

        } else {
            resp = new JsonResponse(false, "No se pudo eliminar el menu", DomainErrors.getErrors());
        }
        service.delete(id);

        return Response.ok().entity(resp).build();

    }

}