package co.unicauca.restaurant.access;


import co.unicauca.common.domain.entity.Restaurant;
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
 * @author Camilo Otaya
 */
public class RestaurantRepository implements IRestaurantRepository {

    private Connection conn;

    public RestaurantRepository() {
    }

    @Override
    public List<Restaurant> findAll() {
        Restaurant restaurant = null;
        List<Restaurant> restaurants = new ArrayList<>();
        try {

           String sql = "SELECT * from restaurant";
            PreparedStatement pstmt = conn.prepareStatement(sql);
           
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                restaurant = new Restaurant();
                restaurant.setIdRestaurant(res.getString("idres"));
                restaurant.setNameRestaurant(res.getString("nameres"));
                restaurant.setAddressRestaurant(res.getString("addressres"));
                restaurant.setAddressRestaurant(res.getString("phoneres"));

                restaurants.add(restaurant);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return restaurants;
    }

    @Override
    public Restaurant findById(String id) {
        Restaurant restaurant = null;
        try {

           String sql = "SELECT * from restaurant where id=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                restaurant = new Restaurant();
                restaurant.setIdRestaurant(res.getString("idres"));
                restaurant.setNameRestaurant(res.getString("nameres"));
                restaurant.setAddressRestaurant(res.getString("addressres"));
                restaurant.setAddressRestaurant(res.getString("phoneres"));
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepository.class.getName()).log(Level.SEVERE, "Error al buscar el postre en la base de datos", ex);
        }
        return restaurant;
    }

    @Override
    public boolean create(Restaurant restaurant) {
        String sql = "";
        try {
             this.connect();
            sql = "INSERT INTO Restaurant(idRes, nameres,addressres, phoneres,idmenu) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, restaurant.getIdRestaurant());
            pstmt.setString(2, restaurant.getNameRestaurant());
            pstmt.setString(3, restaurant.getAddressRestaurant());
            pstmt.setString(4, restaurant.getPhone());
 
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
            String sql = "UPDATE restaurant SET nameres=" + "?" + ", addressres=" + "?" + ",phoneres=" + "?" + ", idmenu=" + "?" + "where idres=" + "?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newRestaurant.getNameRestaurant());
            pstmt.setString(2, newRestaurant.getAddressRestaurant());
            pstmt.setString(3, newRestaurant.getPhone());
            pstmt.setString(4, newRestaurant.getIdRestaurant());
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
                    + "WHERE id_restaurant = ?";

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
