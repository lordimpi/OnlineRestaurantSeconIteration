package co.unicauca.client;

import co.unicauca.common.domain.entity.MainDish;
import co.unicauca.common.domain.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
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
        System.out.println(product.toString());

        // MODIFICANDO PRODUCTO
        product.setName("Licuadora inteligente");
        product.setPrice(350000d);
        rta = jersey.edit_JSON(product, "53");
        System.out.println("Rta " + rta);

        // BORRANDO PRODUCTO
        rta = jersey.delete("53");
        System.out.println("Rta " + rta);

        //LISTANDO PRODUCTOS
        GenericType<List<Product>> listResponseType = new GenericType<List<Product>>() {};
        List<Product> products = jersey.findAll(listResponseType);

        for (Product prod : products) {
            System.out.println(prod.toString());
        }

        // CREANDO UN PLATO PRINCIPAL
        MainDishJerseyClient jerseyDish = new MainDishJerseyClient();
        rta = jerseyDish.create_JSON(new MainDish("101", "Pizza de pollo familiar", 45000d));
        System.out.println("Rta " + rta);

        // BUSCANDO UN PLATO PRINCIPAL
        MainDish maindish = jerseyDish.findById_JSON(MainDish.class, "101");
        System.out.println(maindish.toString());

        // MODIFICANDO PLATO PRINCIPAL
        maindish.setNameDish("Lechona tolimence");
        maindish.setDishPrice(15000d);
        rta = jerseyDish.edit_JSON(maindish, "101");
        System.out.println("Rta " + rta);

        // BORRANDO PLATO PRINCIPAL
        rta = jerseyDish.delete("101");
        System.out.println("Rta " + rta);

        //LISTANDO PLATOS PRINCIPALES
        GenericType<List<MainDish>> listResponseTypeM = new GenericType<List<MainDish>>() {};
        List<MainDish> mainDishes = jerseyDish.findAll(listResponseTypeM);

        for (MainDish mDish : mainDishes) {
            System.out.println(mDish.toString());
        }
        
    }
}
