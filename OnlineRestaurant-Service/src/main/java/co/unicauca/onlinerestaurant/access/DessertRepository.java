package co.unicauca.onlinerestaurant.access;

import co.unicauca.common.domain.entity.Dessert;
import co.unicauca.onlinerestaurant.infra.Utilities;
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
public class DessertRepository implements IDessertRepository {

    private Connection conn;

    public DessertRepository() {
    }

    @Override
    public List<Dessert> findAll() {
        List<Dessert> desserts = new ArrayList<>();
        try {

            String sql = "SELECT id_dessert, dessert_name, dessert_price FROM dessert";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Dessert newDessert = new Dessert();
                newDessert.setId_Dish_Dessert(rs.getString("id_dessert"));
                newDessert.setName_Dish_Dessert(rs.getString("dessert_name"));
                newDessert.setCost_Dish_Dessert(rs.getInt("dessert_price"));

                desserts.add(newDessert);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(DessertRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return desserts;
    }

    @Override
    public Dessert findById(String id) {
        Dessert dessert = null;
        try {

            String sql = "SELECT id_dessert, dessert_name, dessert_price FROM dessert Where id_dessert=" + id;
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                dessert = new Dessert();
                dessert.setName_Dish_Dessert(rs.getString("dessert_name"));
                dessert.setCost_Dish_Dessert(rs.getInt("dessert_price"));
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(DessertRepository.class.getName()).log(Level.SEVERE, "Error al buscar el postre en la base de datos", ex);
        }
        return dessert;
    }

    @Override
    public boolean create(Dessert newDessert) {
        String sql = "";
        try {
            this.connect();

            sql = "INSERT INTO dessert ( id_dessert, dessert_name, dessert_price ) "
                    + "VALUES ( ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newDessert.getId_Dish_Dessert());
            pstmt.setString(2, newDessert.getName_Dish_Dessert());
            pstmt.setInt(3, newDessert.getCost_Dish_Dessert());
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DessertRepository.class.getName()).log(Level.SEVERE, "Error en el insert into: " + sql, ex);
        }
        return false;
    }

    @Override
    public boolean update(Dessert newDessert) {
        try {
            this.connect();

            String sql = "UPDATE dessert "
                    + "SET dessert_name = ?, "
                    + "dessert_price = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newDessert.getName_Dish_Dessert());
            pstmt.setInt(2, newDessert.getCost_Dish_Dessert());
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DessertRepository.class.getName()).log(Level.SEVERE, "Error al actualizar el postre", ex);
        }
        return false;

    }

    @Override
    public boolean delete(String id) {
        try {
            this.connect();

            String sql = "DELETE FROM dessert "
                    + "WHERE id_dessert = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DessertRepository.class.getName()).log(Level.SEVERE, "Error al eliminar postre", ex);
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
            Logger.getLogger(DessertRepository.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DessertRepository.class.getName()).log(Level.SEVERE, "Error al cerrar conexión de la base de datos", ex);
        }

    }
}
