package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.client.MenuJerseyClient;
import co.unicauca.common.domain.entity.Menu;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Santiago Acuña
 */
public class MenuAccessREST implements IMenuAccess {

    MenuJerseyClient jersey;
    Response rta;

    public MenuAccessREST() {
        this.jersey = new MenuJerseyClient();
    }

    @Override
    public Menu findMenu(String id) throws Exception {
        Menu menu = jersey.findById_JSON(Menu.class, id);
        return menu;
    }

    @Override
    public Menu findMenubyRN(String name) throws Exception {
        Menu menu = jersey.findMbyRN_JSON(Menu.class, name);
        return menu;
    }

    @Override
    public boolean updateMenu(String id, String id_dish, String id_drink, String id_entry, String id_salad, String id_dessert) throws Exception {
        Menu menu = findMenu(id);
        if (menu == null) {
            return false;
        }
        menu.getMaindish().setId_mainDish(id_dish);
        menu.getDrink().setId_Drink(id_drink);
        menu.getEntry().setIdDishEntry(id_entry);
        menu.getSalad().setIdSalad(id_salad);
        menu.getDessert().setId_Dish_Dessert(id_dessert);
        rta = jersey.edit_JSON(menu, id);
        return true;
    }

    @Override
    public boolean deleteMenu(String id) throws Exception {
        Menu menu = findMenu(id);
        if (menu == null) {
            return false;
        }
        rta = jersey.delete(id);
        return true;
    }

    @Override
    public boolean createMenu(Menu newMenu) throws Exception {
        Menu menu = findMenu(newMenu.getId_menu());
        if (menu != null) {
            return false;
        }
        rta = jersey.create_JSON(newMenu);
        return true;
    }

        /**
     * Lista todos los menus consumiendo un API REST mediante un cliente jersey
     *
     * @return Lista de menus
     * @throws java.lang.Exception
     */
    @Override
    public List<Menu> list() throws Exception {
        GenericType<List<Menu>> listResponseTypeM = new GenericType<List<Menu>>() {
        };
        List<Menu> menus = jersey.findAll(listResponseTypeM);
        return menus;
    }
    
}
