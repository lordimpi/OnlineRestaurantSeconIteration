package co.unicauca.onlinerestaurant.access;

import co.unicauca.common.domain.entity.Salad;
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
 * Repositorio Ensalada Mysql
 *
 * @author Ximena Gallego
 */
public class SaladRepository implements ISaladRepository {

    /**
     * Conección con Mysql
     */
    private Connection conn;

    /**
     * Constructor por defecto
     */
    public SaladRepository() {

    }

    /**
     * Lista todas las Ensaladas que hay en la base de tados
     *
     * @return Retorna una lista de Ensaladas.
     */
    @Override
    public List<Salad> findAllSalad() {
        List<Salad> salad = new ArrayList<>();
        try {

            String sql = "SELECT idsalad, namesalad, pricesalada FROM salad";
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                Salad newSalad = new Salad();
                newSalad.setIdhSalad(res.getString("idsalad"));
                newSalad.setNameDishSalad(res.getString("namesalad"));
                newSalad.setCostSalad(res.getDouble("pricesalada"));
                
                salad.add(newSalad);               
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(SaladRepository.class.getName()).log(Level.SEVERE, "Error al listar las Ensalas de la base de datos", ex);
        }
        return salad;
    }

    /**
     * Metodo encargado de buscar una Ensalada en BD
     *
     * @param id identificador de una ensalada
     * @return un objeto Ensalada
     */
    @Override
    public Salad findByIdSalad(String id) {
        Salad salad = null;

        this.connect();
        try {
            String sql = "SELECT * from salad where idsalad=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                salad = new Salad();
                salad.setIdhSalad(res.getString("idsalad"));
                salad.setNameDishSalad(res.getString("namesalad"));
                salad.setCostSalad(res.getDouble("pricesalada"));

            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SaladRepository.class.getName()).log(Level.SEVERE, "Error al consultar Ensalada en la base de datos", ex);
        }
        return salad;
    }

    /**
     * Crea una Ensalada y la guarda en la base de datos
     *
     * @param newSalad Objeto Ensalada
     * @return Retorna true si puedo crear ensalada, false de lo contrario
     */
    @Override
    public boolean createSalad(Salad newSalad) {
        String sql = "";
        try {
             
            this.connect();
            sql = "INSERT INTO salad(idsalad, namesalad, pricesalada)"+" VALUES (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newSalad.getIdSalad());
            pstmt.setString(2, newSalad.getNameSalad());
            pstmt.setDouble(3, newSalad.getCostSalad());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SaladRepository.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return false;
    }

    /**
     * Actualiza una Ensalada
     *
     * @param newSalad objeto de tipo Ensalada
     * @return true si lo actualizo correctamente, false de lo contrario
     */
    @Override
    public boolean updateSalad(Salad newSalad) {
        try {
            this.connect();

            String sql = "UPDATE salad "
                    + "SET namesalad = ?, "
                    + "pricesalada = ? "
                    + "WHERE idsalad = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newSalad.getNameSalad());
            pstmt.setDouble(2, newSalad.getCostSalad());
            pstmt.setString(3, newSalad.getIdSalad());
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SaladRepository.class.getName()).log(Level.SEVERE, "Error al actualizar la Ensalada", ex);
        }
        return false;
    }

    /**
     * Elimina una Ensalada en la base de datos
     *
     * @param id Identificador de una Ensalada
     * @return Retora true si pudo borrar, false de lo contrario
     */
    @Override
    public boolean deleteSalad(String id) {
        try {

            this.connect();
            String sql = "DELETE FROM salad WHERE idsalad = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SaladRepository.class.getName()).log(Level.SEVERE, "Error al Eliminar el registro", ex);
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
