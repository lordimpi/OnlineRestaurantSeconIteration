package co.unicauca.restaurant.access;

import co.unicauca.common.domain.entity.Dessert;
import co.unicauca.common.domain.entity.DishEntry;
import co.unicauca.common.domain.entity.Drink;
import co.unicauca.common.domain.entity.MainDish;
import co.unicauca.common.domain.entity.Menu;
import co.unicauca.common.domain.entity.Restaurant;
import co.unicauca.common.domain.entity.Salad;
import co.unicauca.restaurant.infra.Utilities;
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
public class RestaurantRepository implements IRestaurantRepository {

    private Connection conn;

    public RestaurantRepository() {
    }

    @Override
    public List<Restaurant> findAll() {

        Restaurant newrestaurant = new Restaurant();

        List<Restaurant> restaurants = new ArrayList<>();
        try {

            String sql = "SELECT * FROM restaurant ";
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                newrestaurant.setIdRestaurant(res.getString("idres"));
                newrestaurant.setNameRestaurant(res.getString("name_restaurant"));
                newrestaurant.setAddressRestaurant(res.getString("address_restaurant"));
                newrestaurant.setPhone(res.getString("phone"));     

                restaurants.add(newrestaurant);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return restaurants;
    }

    @Override
    public Restaurant findById(String id) {
        Restaurant newrestaurant = new Restaurant();


        this.connect();
        try {
            String sql = "SELECT * FROM restaurant where idres=" + id;
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                newrestaurant.setIdRestaurant(res.getString("idres"));
                newrestaurant.setNameRestaurant(res.getString("name_restaurant"));
                newrestaurant.setAddressRestaurant(res.getString("address_restaurant"));
                newrestaurant.setPhone(res.getString("phone"));
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newrestaurant;
    }

    @Override
    public boolean create(Restaurant restaurant) {
        String sql = "";
        try {
            this.connect();
            sql = "INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_lu_menu`, `id_ma_menu`, `id_mi_menu`, `id_ju_menu`, `id_vi_menu`, `id_sa_menu`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, restaurant.getIdRestaurant());
            pstmt.setString(2, restaurant.getNameRestaurant());
            pstmt.setString(3, restaurant.getAddressRestaurant());
            pstmt.setString(4, restaurant.getPhone());
            pstmt.setString(5, restaurant.getIdmenuLu());          
            pstmt.setString(6, restaurant.getIdmenuMa());          
            pstmt.setString(7, restaurant.getIdmenuMi());           
            pstmt.setString(8, restaurant.getIdmenuJu());       
            pstmt.setString(9, restaurant.getIdmenuVi());
            pstmt.setString(10, restaurant.getIdmenuSa());

            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepository.class.getName()).log(Level.SEVERE, "Error en el insert into: " + sql, ex);
        }
        return false;
    }

    @Override
    public boolean update(Restaurant newRestaurant) {
        try {
            String sql = "UPDATE `restaurant` SET `name_restaurant`=?,`address_restaurant`=?,`phone`=?,`id_lu_menu`=?,`id_ma_menu`=?,`id_mi_menu`=?,`id_ju_menu`=?,`id_vi_menu`=?,`id_sa_menu`=? WHERE `idres`=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newRestaurant.getNameRestaurant());
            pstmt.setString(2, newRestaurant.getAddressRestaurant());
            pstmt.setString(3, newRestaurant.getPhone());
            pstmt.setString(4,newRestaurant.getIdmenuLu());          
            pstmt.setString(5, newRestaurant.getIdmenuMa());          
            pstmt.setString(6, newRestaurant.getIdmenuMi());           
            pstmt.setString(7, newRestaurant.getIdmenuJu());       
            pstmt.setString(8, newRestaurant.getIdmenuVi());
            pstmt.setString(9, newRestaurant.getIdmenuSa());
            pstmt.setString(10, newRestaurant.getIdRestaurant());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepository.class.getName()).log(Level.SEVERE, "Error al actualizar el postre", ex);
        }
        return false;

    }

    @Override
    public boolean delete(String id) {
        try {
            this.connect();

            String sql = "DELETE FROM restaurant "
                    + "WHERE idres = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepository.class.getName()).log(Level.SEVERE, "Error al eliminar postre", ex);
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
            Logger.getLogger(RestaurantRepository.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RestaurantRepository.class.getName()).log(Level.SEVERE, "Error al cerrar conexión de la base de datos", ex);
        }

    }
}
