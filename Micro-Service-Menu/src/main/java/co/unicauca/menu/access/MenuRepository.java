package co.unicauca.menu.access;

import co.unicauca.common.domain.entity.Dessert;
import co.unicauca.common.domain.entity.DishEntry;
import co.unicauca.common.domain.entity.Drink;
import co.unicauca.common.domain.entity.MainDish;
import co.unicauca.common.domain.entity.Menu;
import co.unicauca.common.domain.entity.Salad;
import co.unicauca.common.infra.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Es una implementación que tiene libertad de hacer una implementación del
 * contrato. Lo puede hacer con Sqlite, postgres, mysql, u otra tecnología
 *
 * @author Julian Rodriguez
 */
public class MenuRepository implements IMenuRepository {

    private Connection conn;

    public MenuRepository() {
    }

    @Override
    public List<Menu> findAll() {
        List<Menu> menus = new ArrayList<>();
        try {
            MainDish md = null;
            Drink d = null;
            DishEntry de = null;
            Salad s = null;
            Dessert des = null;

            String sql = "SELECT * from menu join maindish on menu.id_maindish=maindish.id_dish  join salad on menu.id_salad=salad.idsalad join dishentry on menu.id_entry=dishentry.idDishEntry  join dessert on menu.id_dessert=dessert.id_dessert   join drink on menu.id_drink=drink.id_drink ";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Menu menu = new Menu();
                md = new MainDish();
                d = new Drink();
                de = new DishEntry();
                s = new Salad();
                des = new Dessert();
                md.setId_mainDish(rs.getString("id_dish"));
                md.setDishPrice(rs.getDouble("dish_price"));
                md.setNameDish(rs.getString("dish_name"));

                d.setDrinkPrice(rs.getDouble("drink_price"));
                d.setId_Drink(rs.getString("id_drink"));
                d.setNameDrink(rs.getString("drink_name"));

                de.setCostDishEntry(rs.getDouble("costDishEntry"));
                de.setIdDishEntry(rs.getString("idDishEntry"));
                de.setNameDishEntry(rs.getString("nameDishEntry"));

                s.setCostSalad(rs.getDouble("pricesalada"));
                s.setIdSalad(rs.getString("idsalad"));
                s.setNameSalad(rs.getString("namesalad"));

                des.setCost_Dish_Dessert(rs.getDouble("dessert_price"));
                des.setId_Dish_Dessert(rs.getString("id_dessert"));
                des.setName_Dish_Dessert(rs.getString("dessert_name"));

                menu.setId_menu(rs.getString("id_menu"));
                menu.setMaindish(md);
                menu.setEntry(de);
                menu.setDrink(d);
                menu.setSalad(s);
                menu.setDessert(des);

                menus.add(menu);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menus;
    }

    @Override
    public Menu findById(String id) {

        MainDish md = null;
        Drink d = null;
        DishEntry de = null;
        Salad s = null;
        Dessert des = null;
        Menu menu = null;
        try {
            this.connect();
            String sql = "SELECT * from menu join maindish on menu.id_maindish=maindish.id_dish  join salad on menu.id_salad=salad.idsalad join dishentry on menu.id_entry=dishentry.idDishEntry  join dessert on menu.id_dessert=dessert.id_dessert   join drink on menu.id_drink=drink.id_drink  where id_menu=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                menu = new Menu();
                md = new MainDish();
                d = new Drink();
                de = new DishEntry();
                s = new Salad();
                des = new Dessert();

                md.setId_mainDish(res.getString("id_dish"));
                md.setDishPrice(res.getDouble("dish_price"));
                md.setNameDish(res.getString("dish_name"));

                d.setDrinkPrice(res.getDouble("drink_price"));
                d.setId_Drink(res.getString("id_drink"));
                d.setNameDrink(res.getString("drink_name"));

                de.setCostDishEntry(res.getDouble("costDishEntry"));
                de.setIdDishEntry(res.getString("idDishEntry"));
                de.setNameDishEntry(res.getString("nameDishEntry"));

                s.setCostSalad(res.getDouble("pricesalada"));
                s.setIdSalad(res.getString("idsalad"));
                s.setNameSalad(res.getString("namesalad"));

                des.setCost_Dish_Dessert(res.getDouble("dessert_price"));
                des.setId_Dish_Dessert(res.getString("id_dessert"));
                des.setName_Dish_Dessert(res.getString("dessert_name"));

                menu.setId_menu(res.getString("id_menu"));
                menu.setMaindish(md);
                menu.setEntry(de);
                menu.setDrink(d);
                menu.setSalad(s);
                menu.setDessert(des);
                return menu;
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, "Error al buscar el menu en la base de datos", ex);
        }
        return menu;
    }

    @Override
    public boolean create(Menu newMenu) {
        String sql = "";
        try {
            this.connect();

            sql = "INSERT INTO menu(id_menu,id_maindish,id_drink, id_entry, id_salad, id_dessert) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newMenu.getId_menu());
            pstmt.setString(2, newMenu.getMaindish().getId_mainDish());
            pstmt.setString(3, newMenu.getDrink().getId_Drink());
            pstmt.setString(4, newMenu.getEntry().getIdDishEntry());
            pstmt.setString(5, newMenu.getSalad().getIdSalad());
            pstmt.setString(6, newMenu.getDessert().getId_Dish_Dessert());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, "Error en el insert into: " + sql, ex);
        }
        return false;
    }

    @Override
    public boolean update(Menu newMenu) {
        this.connect();
        try {
            String sql = "UPDATE menu SET id_maindish=?,id_drink=?, id_entry=?, id_salad=?, id_dessert=? where id_menu=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newMenu.getMaindish().getId_mainDish());
            pstmt.setString(2, newMenu.getDrink().getId_Drink());
            pstmt.setString(3, newMenu.getEntry().getIdDishEntry());
            pstmt.setString(4, newMenu.getSalad().getIdSalad());
            pstmt.setString(5, newMenu.getDessert().getId_Dish_Dessert());
            pstmt.setString(6, newMenu.getId_menu());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, "Error al actualizar Plato de la base de datos", ex);
        }
        return false;

    }

    @Override
    public boolean delete(String id) {
        try {
            this.connect();

            String sql = "DELETE FROM menu "
                    + "WHERE id_menu = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, "Error al eliminar menu", ex);
        }
        return false;
    }

    /**
     * Conectar a la bd
     */
    public void connect() {
        try {
//            //Class.forName(Utilities.loadProperty("server.db.driver"));
            //crea una instancia de la controlador de la base de datos
            Utilities ut = new Utilities();
            conn = DriverManager.getConnection(ut.getUrl(), ut.getUsername(), ut.getPwd());
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Desconecta de la base de datos
     */
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, "Error al cerrar conexión de la base de datos", ex);
        }

    }

    @Override
    public List<Menu> findMbyRN(String resName) {
        List<Menu> menus = new ArrayList<>();
        try {
            MainDish md = null;
            Drink d = null;
            DishEntry de = null;
            Salad s = null;
            Dessert des = null;

            String sql = "SELECT * from menu join maindish on menu.id_maindish=maindish.id_dish join salad on menu.id_salad=salad.idsalad join dishentry on menu.id_entry=dishentry.idDishEntry join dessert on menu.id_dessert=dessert.id_dessert join drink on menu.id_drink=drink.id_drink join restaurant on menu.id_menu=restaurant.id_lu_menu or menu.id_menu=restaurant.id_ma_menu or menu.id_menu=restaurant.id_mi_menu or menu.id_menu=restaurant.id_ju_menu or menu.id_menu=restaurant.id_vi_menu or menu.id_menu=restaurant.id_sa_menu where restaurant.name_restaurant= '" + resName + "' ORDER by menu.id_menu";
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Menu menu = new Menu();
                md = new MainDish();
                d = new Drink();
                de = new DishEntry();
                s = new Salad();
                des = new Dessert();
                md.setId_mainDish(rs.getString("id_dish"));
                md.setDishPrice(rs.getDouble("dish_price"));
                md.setNameDish(rs.getString("dish_name"));

                d.setDrinkPrice(rs.getDouble("drink_price"));
                d.setId_Drink(rs.getString("id_drink"));
                d.setNameDrink(rs.getString("drink_name"));

                de.setCostDishEntry(rs.getDouble("costDishEntry"));
                de.setIdDishEntry(rs.getString("idDishEntry"));
                de.setNameDishEntry(rs.getString("nameDishEntry"));

                s.setCostSalad(rs.getDouble("pricesalada"));
                s.setIdSalad(rs.getString("idsalad"));
                s.setNameSalad(rs.getString("namesalad"));

                des.setCost_Dish_Dessert(rs.getDouble("dessert_price"));
                des.setId_Dish_Dessert(rs.getString("id_dessert"));
                des.setName_Dish_Dessert(rs.getString("dessert_name"));

                menu.setId_menu(rs.getString("id_menu"));
                menu.setMaindish(md);
                menu.setEntry(de);
                menu.setDrink(d);
                menu.setSalad(s);
                menu.setDessert(des);

                menus.add(menu);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menus;
    }
}
