package co.unicauca.client;

import co.unicauca.common.domain.entity.Product;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

/**
 * Jersey REST client generated for REST resource:ProductController
 * [/products]<br>
 * USAGE:
 * <pre>
        ProductJerseyClient client = new ProductJerseyClient();
        Object response = client.XXX(...);
        // do whatever with response
        client.close();
 </pre>
 *
 * @author Santiago Acuña
 */
public class ProductJerseyClient {

    private javax.ws.rs.client.WebTarget webTarget;
    private javax.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/OnlineRestaurant-Service/restaurant-service";

    public ProductJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("products");
    }

    public javax.ws.rs.core.Response edit_XML(Object requestEntity, String id) throws javax.ws.rs.ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), javax.ws.rs.core.Response.class);
    }

    public javax.ws.rs.core.Response edit_JSON(Object requestEntity, String id) throws javax.ws.rs.ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), javax.ws.rs.core.Response.class);
    }

    public <T> T findById_XML(Class<T> responseType, String id) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findById_JSON(Class<T> responseType, String id) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public javax.ws.rs.core.Response create_XML(Object requestEntity) throws javax.ws.rs.ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), javax.ws.rs.core.Response.class);
    }

    public javax.ws.rs.core.Response create_JSON(Object requestEntity) throws javax.ws.rs.ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), javax.ws.rs.core.Response.class);
    }

    public <T> T findAll(Class<T> responseType) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> List<Product> findAll(GenericType<List<Product>> responseType) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    public javax.ws.rs.core.Response delete(String id) throws javax.ws.rs.ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete(javax.ws.rs.core.Response.class);
    }

    public void close() {
        client.close();
    }
    
}
