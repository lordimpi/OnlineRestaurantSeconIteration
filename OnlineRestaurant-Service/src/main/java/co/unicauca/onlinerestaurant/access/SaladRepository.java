package co.unicauca.onlinerestaurant.access;

import co.unicauca.common.domain.entity.Salad;
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
 *Es una implementación que tiene libertad de hacer una implementación del
 * contrato. Lo puede hacer con Sqlite, postgres, mysql, u otra tecnología
 * @author Ximena Gallego
 */
public class SaladRepository implements ISaladRepository {
     /**
     * Guarda la conexion a la base de datos
     */
    private Connection conn;

    /**
     * Lista todos las Ensaladas de la base de datos
     *
     * @return Lista ensaladas
     */
    @Override
    public List<Salad> findAll() {
       
        List<Salad> salad = new ArrayList<>();
        try {

            String sql = "SELECT idsalad, namesalad, pricesalada FROM salad";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Salad newSalad = new Salad();
                newSalad.setIdSalad(rs.getString("idsalad"));
                newSalad.setNameDishSalad(rs.getString("namesalad"));
                newSalad.setCostSalad(rs.getDouble("pricesalada"));               
                
                salad.add(newSalad);              
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(SaladRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salad;
    }
      /**
     * Busca una Ensalada de la base de datos
     *
     * @param id Identificador de Ensalada
     * @return Objeto de tipo Salad
     */
    @Override
    public Salad findById(String id) {
      Salad salad = null;
        try {

            String sql = "SELECT idsalad, namesalad, pricesalada FROM salad Where idsalad=" + id;
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                salad = new Salad();
                salad.setIdSalad(rs.getString("idsalad"));
                salad.setNameDishSalad(rs.getString("namesalad"));
                salad.setCostSalad(rs.getDouble("pricesalada"));               
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(SaladRepository.class.getName()).log(Level.SEVERE, "Error al buscar ensalada en la base de datos", ex);
        }
        return salad;
    }
    /**
     * Crea una ensalada y lo guarda en la base de datos
     *
     * @param newMSalad Objeto de tipo salad a guardar
     * @return True si puedo crear, false de lo contrario
     */
    @Override
    public boolean create(Salad newSalad) {
        String sql = "";
        try {
            this.connect();

            sql = "INSERT INTO salad ( idsalad, namesalad, pricesalada ) "
                    + "VALUES ( ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newSalad.getIdSalad());
            pstmt.setString(2, newSalad.getNameSalad());
            pstmt.setDouble(3, newSalad.getCostSalad());            
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SaladRepository.class.getName()).log(Level.SEVERE, "Error en el insert into: " + sql, ex);
        }
        return false;
    }
     /**
     * Actualiza una Ensalada en la base de datos
     *
     * @param newSalad Objeto de tipo Salad a actualizar
     * @return True si pudo actualizar, false de lo contrario
     */
    @Override
    public boolean update(Salad newSalad) {
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
            Logger.getLogger(SaladRepository.class.getName()).log(Level.SEVERE, "Error al actualizar ensalada principal", ex);
        }
        return false;
    }
     
    /**
     * Elimina una ensalada de la base de datos
     *
     * @param id Identificador de ensalada a eliminar
     * @return True si pudo eliminar, false de lo contrario
     */
    @Override
    public boolean delete(String id) {
         try {
            this.connect();

            String sql = "DELETE FROM salad "
                    + "WHERE idsalad = ?"+id;

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SaladRepository.class.getName()).log(Level.SEVERE, "Error al eliminar Ensalada", ex);
        }
        return false;
    }

     /**
     * Conecta a la bd
     */
    private void connect() {
         try {
            //Class.forName(Utilities.loadProperty("server.db.driver"));
            //crea una instancia de la controlador de la base de datos
            Utilities ut = new Utilities();
            conn = DriverManager.getConnection(ut.getUrl(), ut.getUsername(), ut.getPwd());
        } catch (SQLException ex) {
            Logger.getLogger(SaladRepository.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SaladRepository.class.getName()).log(Level.SEVERE, "Error al cerrar conexión de la base de datos", ex);
        }
    }

}
