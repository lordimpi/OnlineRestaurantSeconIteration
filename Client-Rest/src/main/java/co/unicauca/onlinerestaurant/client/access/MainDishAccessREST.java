package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.client.MainDishJerseyClient;
import co.unicauca.common.domain.entity.MainDish;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Santiago Acuña
 */
public class MainDishAccessREST implements IMainDishAccess {

    MainDishJerseyClient jersey;
    Response rta;

    public MainDishAccessREST() {
        this.jersey = new MainDishJerseyClient();
    }

    @Override
    public MainDish findMainDish(String id) throws Exception {
        MainDish maindish = jersey.findById_JSON(MainDish.class, id);
        return maindish;
    }

    @Override
    public boolean updateMainDish(String id, String name, Double price) throws Exception {
        MainDish mainDish = findMainDish(id);
        if (mainDish == null) {
            return false;
        }
        mainDish.setDishPrice(price);
        mainDish.setNameDish(name);
        rta = jersey.edit_JSON(mainDish, id);
        return true;
    }

    @Override
    public boolean deleteMainDish(String id) throws Exception {
        MainDish mainDish = findMainDish(id);
        if (mainDish == null) {
            return false;
        }
        rta = jersey.delete(id);
        return true;
    }

    @Override
    public boolean createMainDish(MainDish mainDish) throws Exception {
        MainDish dish = findMainDish(mainDish.getId_mainDish());
        if (dish != null) {
            return false;
        }
        rta = jersey.create_JSON(mainDish);
        return true;
    }

    @Override
    public List<MainDish> list() throws Exception {
        GenericType<List<MainDish>> listResponseTypeM = new GenericType<List<MainDish>>() {
        };
        List<MainDish> mainDishes = jersey.findAll(listResponseTypeM);
        return mainDishes;
    }

}
