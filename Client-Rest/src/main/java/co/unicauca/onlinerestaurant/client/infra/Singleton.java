package co.unicauca.onlinerestaurant.client.infra;

import co.unicauca.onlinerestaurant.client.presentation.GUICreateUser;
import co.unicauca.onlinerestaurant.client.presentation.GUIModifyUser;
import co.unicauca.onlinerestaurant.client.presentation.GUIShowPedidos;
import javax.swing.JFrame;

/**
 *
 * @author Santiago Acuña
 */
public class Singleton {

    private static JFrame Us;
    
    private static JFrame Usm;
    
    private static JFrame RealizarPedidos;
    
    private Singleton() {

    }

    /**
     * Obtiene la instancia del formulario para crear un usuario
     *
     * @return La instancia del usuario si ya esta creada, de lo contraio la crea
     */
    public static JFrame getInstCreateUser() {
        if (Us == null) {
            Us = new GUICreateUser();
        }
        return Us;
    }

    /**
     * Obtiene la instancia del formulario para modificar un usuario
     *
     * @return La instancia del usuario si ya esta creada, de lo contraio la crea
     */
    public static JFrame getInstModifyUser() {
        if (Usm == null) {
            Usm = new GUIModifyUser();
        }
        return Usm;
    }
    
     /**
     * Obtiene la instancia del formulario para Realizar un pedido
     *
     * @return La instancia del usuario si ya esta creada, de lo contraio la crea
     */
    public static JFrame getInstRealizarPedidos() {
        if (RealizarPedidos == null) {
            RealizarPedidos = new GUIShowPedidos();
        }
        return RealizarPedidos;
    }
}
