package co.unicauca.delivery.access;

import co.unicauca.common.domain.entity.Delivery;
import co.unicauca.common.domain.entity.Menu;
import co.unicauca.common.infra.Utilities;
import co.unicauca.delivery.a.MenuJerseyClient;
import java.sql.Connection;
import java.sql.Date;
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
public class DeliveryRepository implements IDeliveryRepository {

    /**
     * Guarda el string de connexion a la bd
     */
    private Connection conn;

    MenuJerseyClient jersey;

    public DeliveryRepository() {
        this.jersey = new MenuJerseyClient();
    }

    @Override
    public List<Delivery> findAll() {

        List<Delivery> deliveries = new ArrayList<>();
        try {
            String idMenu;
            String sql = "SELECT * FROM delivery";
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                Delivery newDelivery = new Delivery();
                newDelivery.setId_Delivery(Integer.toString(res.getInt("id_delivery")));
                newDelivery.setDescripcion(res.getString("descripcion"));
                newDelivery.setCantidad(res.getInt("cantidad"));
                newDelivery.setDireccionEnvio(res.getString("direccion_envio"));
                newDelivery.setFecha(res.getDate("fecha"));
                idMenu = res.getString("id_menu");
                newDelivery.setMiMenu(jersey.findById_JSON(Menu.class, idMenu));
                deliveries.add(newDelivery);

            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deliveries;
    }

    @Override
    public Delivery findById(String id) {
        Delivery newDelivery = null;
        String idMenu;
        this.connect();
        try {
            String sql = "SELECT * FROM delivery where id_delivery = " + id;
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                newDelivery = new Delivery();
                newDelivery.setId_Delivery(Integer.toString(res.getInt("id_delivery")));
                newDelivery.setDescripcion(res.getString("descripcion"));
                newDelivery.setCantidad(res.getInt("cantidad"));
                newDelivery.setDireccionEnvio(res.getString("direccion_envio"));
                newDelivery.setFecha(res.getDate("fecha"));
                idMenu = res.getString("id_menu");
                newDelivery.setMiMenu(jersey.findById_JSON(Menu.class, idMenu));
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newDelivery;
    }

    @Override
    public boolean create(Delivery delivery) {
        String sql = "";
        try {
            this.connect();
            sql = "INSERT INTO `delivery`(`descripcion`, `cantidad`, `direccion_envio`, `fecha`, `id_menu`) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, delivery.getDescripcion());
            pstmt.setInt(2, delivery.getCantidad());
            pstmt.setString(3, delivery.getDireccionEnvio());
            pstmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
            pstmt.setString(5, delivery.getMiMenu().getId_menu());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryRepository.class.getName()).log(Level.SEVERE, "Error en el insert into: " + sql, ex);
        }
        return false;
    }

    @Override
    public boolean update(Delivery newDelivery) {
        try {
            this.connect();
            String sql = "UPDATE `delivery` SET descripcion=?, cantidad =?, direccion_envio =?, fecha =?, id_menu =? WHERE id_delivery =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newDelivery.getDescripcion());
            pstmt.setInt(2, newDelivery.getCantidad());
            pstmt.setString(3, newDelivery.getDireccionEnvio());
            pstmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
            pstmt.setString(5, newDelivery.getMiMenu().getId_menu());
            pstmt.setInt(6, Integer.parseInt(newDelivery.getId_Delivery()));
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryRepository.class.getName()).log(Level.SEVERE, "Error al actualizar el postre", ex);
        }
        return false;

    }

    @Override
    public boolean delete(String id) {
        try {
            this.connect();

            String sql = "DELETE FROM delivery "
                    + "WHERE id_delivery = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryRepository.class.getName()).log(Level.SEVERE, "Error al eliminar postre", ex);
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
            Logger.getLogger(DeliveryRepository.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DeliveryRepository.class.getName()).log(Level.SEVERE, "Error al cerrar conexión de la base de datos", ex);
        }

    }
}
