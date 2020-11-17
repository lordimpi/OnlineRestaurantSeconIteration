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
    public List<Menu> findMenubyRN(String name) throws Exception {
        GenericType<List<Menu>> listResponseTypeM = new GenericType<List<Menu>>() {
        };
        List<Menu> menus = jersey.findMbyRN_JSON(listResponseTypeM, name);
        return menus;
    }

    @Override
    public boolean updateMenu(String id, Menu newMenu) throws Exception {
        Menu menu = findMenu(id);
        if (menu == null) {
            return false;
        }
        menu = newMenu;
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
