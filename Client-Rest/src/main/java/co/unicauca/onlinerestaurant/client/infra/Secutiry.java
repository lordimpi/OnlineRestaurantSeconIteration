package co.unicauca.onlinerestaurant.client.infra;

import co.unicauca.common.domain.entity.User;
import co.unicauca.onlinerestaurant.client.access.Factory;
import co.unicauca.onlinerestaurant.client.access.IUserAccess;
import co.unicauca.onlinerestaurant.client.domain.services.UserService;

/**
 *
 * @author Santiago Acuña
 */
public class Secutiry {

    private final IUserAccess repo = Factory.getInstance().getUserService();
    private final UserService service = new UserService(repo);
    private User user;

    /**
     * Constructor por defecto
     */
    public Secutiry() {
        this.user = new User();
    }

    // GETTER AND SETTERS
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Valida la existencia de un usuario en la base de datos
     * @param email Usuario a validar
     * @param password Clave a validar
     * @return True si es valido, false de lo contraio
     * @throws Exception 
     */
    public boolean validarUsuario(String email, String password) throws Exception {
        user = service.findUserEmail(email);
        if (user != null) {
            if (user.getEmail().equals(email) && user.getPws().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo encargado de validar que el campo email contega un @
     * @param email Cadena a validar
     * @return True si contiene, false de lo contrario
     */
    public boolean validarEmail(String email){
        return email.contains("@");
    }
}
