package co.unicauca.onlinerestaurant.access;

import co.unicauca.common.domain.entity.Drink;
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
import javax.enterprise.inject.Default;

/**
 * Es una implementación que tiene libertad de hacer una implementación del
 * contrato. Lo puede hacer con Sqlite, postgres, mysql, u otra tecnología
 *
 * @author Mariat Trujillo
 */
@Default
public class DrinkRepository implements IDrinkRepository {

    private Connection conn;

    public DrinkRepository() {

    }

    @Override
    public List<Drink> findAll() {
        List<Drink> drinks = new ArrayList<>();
        try {

            String sql = "SELECT id_drink, drink_name, drink_price FROM drink";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Drink newDrink = new Drink();
                newDrink.setId_Drink(rs.getString("id_drink"));
                newDrink.setNameDrink(rs.getString("drink_name"));
                newDrink.setDrinkPrice(rs.getDouble("drink_price"));

                drinks.add(newDrink);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(DrinkRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return drinks;
    }

    @Override
    public Drink findById(String id) {
        Drink drink = null;
        try {

            String sql = "SELECT id_drink, drink_name, drink_price FROM drink Where id_drink=" + id;
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                drink = new Drink();
                drink.setId_Drink(rs.getString("id_drink"));
                drink.setNameDrink(rs.getString("drink_name"));
                drink.setDrinkPrice(rs.getDouble("drink_price"));
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(DrinkRepository.class.getName()).log(Level.SEVERE, "Error al buscar la bebida en la base de datos", ex);
        }
        return drink;
    }

    @Override
    public boolean create(Drink newDrink) {
        String sql = "";
        try {
            this.connect();

            sql = "INSERT INTO drink ( id_drink, drink_name, drink_price ) "
                    + "VALUES ( ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newDrink.getId_Drink());
            pstmt.setString(2, newDrink.getNameDrink());
            pstmt.setDouble(3, newDrink.getDrinkPrice());
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DrinkRepository.class.getName()).log(Level.SEVERE, "Error en el insert into: " + sql, ex);
        }
        return false;
    }

    @Override
    public boolean update(Drink newDrink) {
        try {
            this.connect();

            String sql = "UPDATE drink "
                    + "SET drink_name = ?, "
                    + "drink_price = ? "
                    + "WHERE id_drink = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newDrink.getNameDrink());
            pstmt.setDouble(2, newDrink.getDrinkPrice());
            pstmt.setString(3, newDrink.getId_Drink());
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DrinkRepository.class.getName()).log(Level.SEVERE, "Error al actualizar la bebida", ex);
        }
        return false;

    }

    @Override
    public boolean delete(String id) {
        try {
            this.connect();

            String sql = "DELETE FROM drink "
                    + "WHERE id_drink = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DrinkRepository.class.getName()).log(Level.SEVERE, "Error al eliminar bebida", ex);
        }
        return false;
    }

    /**
     * Conectar a la bd
     */
    public void connect() {
        try {
            //Class.forName(Utilities.loadProperty("server.db.driver"));
            //crea una instancia de la controlador de la base de datos
            Utilities ut = new Utilities();
            conn = DriverManager.getConnection(ut.getUrl(), ut.getUsername(), ut.getPwd());
        } catch (SQLException ex) {
            Logger.getLogger(DrinkRepository.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DrinkRepository.class.getName()).log(Level.SEVERE, "Error al cerrar conexión de la base de datos", ex);
        }

    }
}
