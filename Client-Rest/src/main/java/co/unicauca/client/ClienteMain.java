package co.unicauca.client;

import co.unicauca.common.domain.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

/**
 *
 * @author Santiago Acuña
 */
public class ClienteMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // CREANDO UN PRODUCTO
        ProductJerseyClient jersey = new ProductJerseyClient();
        Response rta = jersey.create_JSON(new Product(53, "Nevera Lg", 4000000d));
        System.out.println("Rta " + rta);

        // BUSCANDO UN PRODUCTO
        Product product = jersey.findById_JSON(Product.class, "53");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());

        // MODIFICANDO PRODUCTO
        product.setName("Licuadora inteligente");
        product.setPrice(350000d);
        rta = jersey.edit_JSON(product, "53");
        System.out.println("Rta " + rta);

        // BORRANDO PRODUCTO
        rta = jersey.delete("53");
        System.out.println("Rta " + rta);

//        //LISTANDO PRODUCTOS
//        List<Product> products = new ArrayList<>();
//        //GenericEntity<List<Product>> myEntity = new GenericEntity<List<Product>>(products) {};
//        products = jersey.findAll(Product.class);
//        for (Product prod : products) {
//            System.out.println("Id: " + prod.getId());
//            System.out.println("Nombre: " + prod.getName());
//            System.out.println("Precio: " + prod.getPrice() + "\n");
//        }

    }
}
