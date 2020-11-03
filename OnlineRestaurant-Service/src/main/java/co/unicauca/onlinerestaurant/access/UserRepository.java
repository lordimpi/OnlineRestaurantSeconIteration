package co.unicauca.onlinerestaurant.access;

import co.unicauca.common.domain.entity.User;
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
 * * Es una implementación que tiene libertad de hacer una implementación del
 * contrato. Lo puede hacer con Sqlite, postgres, mysql, u otra tecnología
 *
 * @author Camilo Otaya
 */
public class UserRepository implements IUserRepository {

    private Connection conn;

    public UserRepository() {
    }

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
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public User findById(String id) {
        User user = null;
        try {

            String sql = "SELECT id_user, first_name, last_name, address, mobile, email, rol, pws FROM user Where id_user=" + id;
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                user = new User();
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
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, "Error al buscar el usuario en la base de datos", ex);
        }
        return user;
    }

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
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, "Error en el insert into: " + sql, ex);
        }
        return false;
    }

    @Override
    public boolean update(User newUser) {
        try {
            this.connect();

            String sql = "UPDATE `user`"
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
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, "Error al actualizar el usuario", ex);
        }
        return false;

    }

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
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, "Error al eliminar usuario", ex);
        }
        return false;
    }

    /**
     * Conectar a la bd
     */
    public void connect() {
        try {
//            Class.forName(Utilities.loadProperty("server.db.driver"));
            //crea una instancia de la controlador de la base de datos
            String url = "jdbc:mysql://localhost:3306/restaurante";
            String username = "sc";
            String pwd = "1234";
            conn = DriverManager.getConnection(url, username, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, "Error al cerrar conexión de la base de datos", ex);
        }

    }

}
