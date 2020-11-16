package co.unicauca.restaurant.access;

import co.unicauca.common.domain.entity.User;
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
 * @author Camilo Otaya Bravo
 */
public class RestaurantRepository implements IRestaurantRepository {

    /**
     * Guarda la conexion a la base de datos
     */
    private Connection conn;

    /**
     * Lista todos los usuarios de la base de datos
     *
     * @return Lista de usuarios
     */
    @Override
    public List<User> findAll() {

        List<User> users = new ArrayList<>();
        try {

            String sql = "SELECT id_user, first_name, last_name, address, mobile, email, rol, pws FROM user";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User newUser = new User();
                newUser.setId(rs.getString("id_user"));
                newUser.setFirstName(rs.getString("first_name"));
                newUser.setLastName(rs.getString("last_name"));
                newUser.setAddress(rs.getString("address"));
                newUser.setMobile(rs.getString("mobile"));
                newUser.setEmail(rs.getString("email"));
                newUser.setRol(rs.getString("rol"));
                newUser.setPws(rs.getString("pws"));

                users.add(newUser);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    /**
     * Busca un usuario de la base de datos
     *
     * @param id Identificador del usuario
     * @return Objeto de tipo usuario
     */
    @Override
    public User findById(String id) {
        User user = null;
        try {

            String sql = "SELECT id_user, first_name, last_name, address, mobile, email, rol, pws FROM user where id_user=" + id;
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                user = new User();
                user.setId(rs.getString("id_user"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setAddress(rs.getString("address"));
                user.setMobile(rs.getString("mobile"));
                user.setEmail(rs.getString("email"));
                user.setRol(rs.getString("rol"));
                user.setPws(rs.getString("pws"));
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepository.class.getName()).log(Level.SEVERE, "Error al buscar el usuario en la base de datos", ex);
        }
        return user;
    }

    /**
     * Crea un usuario y lo guarda en la base de datos
     *
     * @param newUser Objeto de tipo User a guardar
     * @return True si puedo crear, false de lo contrario
     */
    @Override
    public boolean create(User newUser) {
        String sql = "";
        try {
            this.connect();

            sql = "INSERT INTO user ( id_user, first_name, last_name, address, mobile, email, rol, pws ) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getId());
            pstmt.setString(2, newUser.getFirstName());
            pstmt.setString(3, newUser.getLastName());
            pstmt.setString(4, newUser.getAddress());
            pstmt.setString(5, newUser.getMobile());
            pstmt.setString(6, newUser.getEmail());
            pstmt.setString(7, newUser.getRol());
            pstmt.setString(8, newUser.getPws());
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepository.class.getName()).log(Level.SEVERE, "Error en el insert into: " + sql, ex);
        }
        return false;
    }

    /**
     * Actualiza un usuario en la base de datos
     *
     * @param newUser Objeto de tipo User a actualizar
     * @return True si pudo actualizar, false de lo contrario
     */
    @Override
    public boolean update(User newUser) {
        try {
            this.connect();

            String sql = "UPDATE user "
                    + "SET first_name = ?, "
                    + "last_name = ?, "
                    + "address = ?, "
                    + "mobile = ?, "
                    + "email = ?, "
                    + "rol = ?, "
                    + "pws = ? "
                    + "WHERE id_user = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getFirstName());
            pstmt.setString(2, newUser.getLastName());
            pstmt.setString(3, newUser.getAddress());
            pstmt.setString(4, newUser.getMobile());
            pstmt.setString(5, newUser.getEmail());
            pstmt.setString(6, newUser.getRol());
            pstmt.setString(7, newUser.getPws());
            pstmt.setString(8, newUser.getId());
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepository.class.getName()).log(Level.SEVERE, "Error al actualizar el usuario", ex);
        }
        return false;
    }

    /**
     * Elimina un usuario de la base de datos
     *
     * @param id Identificador del usuario a eliminar
     * @return True si pudo eliminar, false de lo contrario
     */
    @Override
    public boolean delete(String id) {
        try {
            this.connect();

            String sql = "DELETE FROM user "
                    + "WHERE id_user = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepository.class.getName()).log(Level.SEVERE, "Error al eliminar el usuario", ex);
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
