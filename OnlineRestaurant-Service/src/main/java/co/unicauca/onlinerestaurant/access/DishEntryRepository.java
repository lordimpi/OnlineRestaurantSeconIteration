package co.unicauca.onlinerestaurant.access;

import co.unicauca.common.domain.entity.DishEntry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;

/**
 * Repositorio platos de entrada Mysql
 *
 * @author Ximena Gallego
 */
public class DishEntryRepository implements IDishEntryRepository {

    /**
     * Conección con Mysql
     */
    private Connection conn;

    /**
     * Constructor por defecto
     */
    public DishEntryRepository() {

    }

    /**
     * Lista todos los platos de entrada que hay en la base de tados
     *
     * @return Retorna una lista de platos de entrada.
     */
    @Override
    public List<DishEntry> findAllDishEntry() {
        List<DishEntry> DishEntry = new ArrayList<>();
        try {

            String sql = "SELECT idDishEntry, nameDishEntry, costDishEntry from dishentry";
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                DishEntry newDishEntry = new DishEntry();
                newDishEntry.setIdDishEntry(res.getString("idDishEntry"));
                newDishEntry.setNameDishEntry(res.getString("nameDishEntry"));
                newDishEntry.setCostDishEntry((int) res.getDouble("costDishEntry"));
                DishEntry.add(newDishEntry);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(DishEntryRepository.class.getName()).log(Level.SEVERE, "Error al listar los datos de los platos de Entrada en la base de datos", ex);
        }
        return DishEntry;
    }

    /**
     * Metodo encargado de buscar un plato de entrada en BD
     *
     * @param id identificador de plato de entrada
     * @return un objeto de plato de entrada
     */
    @Override
    public DishEntry findByIdDishEntry(String id) {
        DishEntry dishEntry = null;

        this.connect();
        try {
            String sql = "SELECT * from dishentry where idDishEntry=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                dishEntry = new DishEntry();
                dishEntry.setIdDishEntry(res.getString("idDishEntry"));
                dishEntry.setNameDishEntry(res.getString("nameDishEntry"));
                dishEntry.setCostDishEntry((int) res.getDouble("costDishEntry"));

            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(DishEntryRepository.class.getName()).log(Level.SEVERE, "Error al consultar plato de entrada en la base de datos", ex);
        }
        return dishEntry;
    }

    /**
     * Crea un plato de entrada y lo guarda en la base de datos
     *
     * @param newDishEntry Objeto plato de entrada
     * @return Retorna true si puedo crear el plato, false de lo contrario
     */
    @Override
    public boolean createDishEntry(DishEntry newDishEntry) {
        try {

            this.connect();
            String sql = "INSERT INTO dishentry(idDishEntry, nameDishEntry, costDishEntry) VALUES (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newDishEntry.getIdDishEntry());
            pstmt.setString(2, newDishEntry.getNameDishEntry());
            pstmt.setDouble(3, newDishEntry.getCostDishEntry());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DishEntryRepository.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return false;
    }

    /**
     * Actualiza un plato de entrada
     *
     * @param newDishEntry objeto de tipo DishEntry
     * @return true si lo actualizo correctamente, false de lo contrario
     */
    @Override
    public boolean updateDishEntry(DishEntry newDishEntry) {
        try {
            this.connect();

            String sql = "UPDATE dishentry "
                    + "SET nameDishEntry = ?, "
                    + "costDishEntry = ? "
                    + "WHERE idDishEntry = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newDishEntry.getNameDishEntry());
            pstmt.setDouble(2, newDishEntry.getCostDishEntry());
            pstmt.setString(3, newDishEntry.getIdDishEntry());
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DishEntryRepository.class.getName()).log(Level.SEVERE, "Error al actualizar el plato Entrada", ex);
        }
        return false;
    }

    /**
     * Elimina un plato de entrada en la base de datos
     *
     * @param id Identificador del plato de entrada
     * @return Retora true si pudo borrar el plato de entrada, false de lo
     * contrario
     */
    @Override
    public boolean deleteDishEntry(String id) {
        try {

            this.connect();
            String sql = "DELETE FROM dishentry WHERE idDishEntry = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DishEntryRepository.class.getName()).log(Level.SEVERE, "Error al Eliminar el registro", ex);
        }
        return false;
    }

    /**
     * Conectar a la bd
     */
    private void connect() {
        try {
            //Class.forName(Utilities.loadProperty("server.db.driver"));
            //crea una instancia de la controlador de la base de datos
            String url = "jdbc:mysql://localhost:3306/restaurante";
            String username = "lordimpi";
            String pwd = "lordimpi315";
            conn = DriverManager.getConnection(url, username, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(MainDishRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Desconecta de la base de datos
     */
    private void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDishRepository.class.getName()).log(Level.SEVERE, "Error al cerrar conexión de la base de datos", ex);
        }
    }

}
