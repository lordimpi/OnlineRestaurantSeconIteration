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
import co.unicauca.onlinerestaurant.domain.service.ProductService;
import co.unicauca.common.domain.entity.Product;
import co.unicauca.onlinerestaurant.infra.DomainErrors;
import co.unicauca.onlinerestaurant.infra.JsonResponse;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * API REST
 *
 * @author Santiago Acuña
 */
@Stateless
@Path("/products")
public class ProductController {
    @Inject
    private ProductService service;

    public ProductController() {
        service = new ProductService();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/OnlineRestaurant-Service/restaurant-service/products/ 

     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> findAll() {
        return service.findAll();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8085/OnlineRestaurant-Service/restaurant-service/products/1 

     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Product findById(@PathParam("id") Integer id) {
        return service.findById(id);
    }

    /*
        Su uso desde consola mediante client url:
        curl -X POST \
          http://localhost:8085/OnlineRestaurant-Service/restaurant-service/products/ \
          -H 'Content-Type: application/json' \
          -d '{
               "id":1,
               "name":"Nevera Lg",
               "price":6700000
        }'
    */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(Product product) {
        JsonResponse resp;
        if (service.create(product)) {
            resp = new JsonResponse(true, "Producto creado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo crear el producto", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X PUT \
          http://localhost:8085/OnlineRestaurant-Service/restaurant-service/products/1 \
          -H 'Content-Type: application/json' \
          -d '{
               "name":"Nevera Lg REF. JDK3-34-343",
               "price":2450000
        }'
    */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") Integer id, Product product) {
        JsonResponse resp;
        if (service.update(id, product)) {
            resp = new JsonResponse(true, "Producto modificado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo modificar el producto", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();

    }

    /*
        Su uso desde consola mediante client url:
        curl -X DELETE http://localhost:8085/Product-Service/product-service/products/1 

     */
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        JsonResponse resp;

        if (service.delete(id)) {
            resp = new JsonResponse(true, "Producto eliminado con éxito", null);

        } else {
            resp = new JsonResponse(false, "No se pudo eliminar el producto", DomainErrors.getErrors());
        }
        service.delete(id);

        return Response.ok().entity(resp).build();

    }
}
