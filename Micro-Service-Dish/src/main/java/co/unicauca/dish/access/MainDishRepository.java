package co.unicauca.dish.access;

import co.unicauca.common.domain.entity.MainDish;
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
 * @author Santiago Acuña
 */
public class MainDishRepository implements IMainDishRepository {

    /**
     * Guarda la conexion a la base de datos
     */
    private Connection conn;

    /**
     * Lista todos los platos principales de la base de datos
     *
     * @return Lista de platos principales
     */
    @Override
    public List<MainDish> findAll() {

        List<MainDish> mainDishes = new ArrayList<>();
        try {

            String sql = "SELECT id_dish, dish_name, dish_price FROM maindish";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                MainDish newMainDish = new MainDish();
                newMainDish.setId_mainDish(rs.getString("id_dish"));
                newMainDish.setNameDish(rs.getString("dish_name"));
                newMainDish.setDishPrice(rs.getDouble("dish_price"));

                mainDishes.add(newMainDish);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(MainDishRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mainDishes;
    }

    /**
     * Busca un plato principal de la base de datos
     *
     * @param id Identificador del plato principal
     * @return Objeto de tipo MainDish
     */
    @Override
    public MainDish findById(String id) {
        MainDish mainDish = null;
        try {

            String sql = "SELECT id_dish, dish_name, dish_price FROM maindish Where id_dish=" + id;
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                mainDish = new MainDish();
                mainDish.setId_mainDish(rs.getString("id_dish"));
                mainDish.setNameDish(rs.getString("dish_name"));
                mainDish.setDishPrice(rs.getDouble("dish_price"));
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(MainDishRepository.class.getName()).log(Level.SEVERE, "Error al buscar el plato principal en la base de datos", ex);
        }
        return mainDish;
    }

    /**
     * Crea un plato principal y lo guarda en la base de datos
     *
     * @param newMainDish Objeto de tipo MainDish a guardar
     * @return True si puedo crear, false de lo contrario
     */
    @Override
    public boolean create(MainDish newMainDish) {
        String sql = "";
        try {
            this.connect();

            sql = "INSERT INTO maindish ( id_dish, dish_name, dish_price ) "
                    + "VALUES ( ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newMainDish.getId_mainDish());
            pstmt.setString(2, newMainDish.getNameDish());
            pstmt.setDouble(3, newMainDish.getDishPrice());
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MainDishRepository.class.getName()).log(Level.SEVERE, "Error en el insert into: " + sql, ex);
        }
        return false;
    }

    /**
     * Actualiza un plato principal en la base de datos
     *
     * @param newMainDish Objeto de tipo MainDish a actualizar
     * @return True si pudo actualizar, false de lo contrario
     */
    @Override
    public boolean update(MainDish newMainDish) {
        try {
            this.connect();

            String sql = "UPDATE maindish "
                    + "SET dish_name = ?, "
                    + "dish_price = ? "
                    + "WHERE id_dish = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newMainDish.getNameDish());
            pstmt.setDouble(2, newMainDish.getDishPrice());
            pstmt.setString(3, newMainDish.getId_mainDish());
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MainDishRepository.class.getName()).log(Level.SEVERE, "Error al actualizar el plato principal", ex);
        }
        return false;
    }

    /**
     * Elimina un plato principal de la base de datos
     *
     * @param id Identificador del plato a eliminar
     * @return True si pudo eliminar, false de lo contrario
     */
    @Override
    public boolean delete(String id) {
        try {
            this.connect();

            String sql = "DELETE FROM maindish "
                    + "WHERE id_dish = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MainDishRepository.class.getName()).log(Level.SEVERE, "Error al eliminar plato principal", ex);
        }
        return false;
    }

    /**
     * Conecta a la bd
     */
    public void connect() {
        try {
            //Class.forName(Utilities.loadProperty("server.db.driver"));
            //crea una instancia de la controlador de la base de datos
            Utilities ut = new Utilities();
            conn = DriverManager.getConnection(ut.getUrl(), ut.getUsername(), ut.getPwd());
        } catch (SQLException ex) {
            Logger.getLogger(MainDishRepository.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MainDishRepository.class.getName()).log(Level.SEVERE, "Error al cerrar conexión de la base de datos", ex);
        }
    }
}
