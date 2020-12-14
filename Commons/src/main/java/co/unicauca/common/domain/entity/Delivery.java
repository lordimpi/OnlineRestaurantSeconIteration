package co.unicauca.common.domain.entity;

import java.util.Date;

/**
 *
 * @author Santiago Acuña
 */
public class Delivery {

    /**
     * Identificador del pedido a entregar
     */
    private String id_Delivery;
    /**
     * Descripcion del pedido a entregar
     */
    private String descripcion;
    /**
     * Cantidad del pedido a entregar
     */
    private Integer cantidad;
    /**
     * Direccion de envio del pedido a entregar
     */
    private String direccionEnvio;
    /**
     * Fecha de la creacion del pedido
     */
    private Date fecha;
    /**
     * Guarda la instancia de un menu para un pedido a entregar
     */
    private Menu miMenu;

    /**
     * Constructor por defecto
     */
    public Delivery() {

    }

    /**
     * Constructor parametrizado
     *
     * @param id_Delivery Identificador del pedido
     * @param descripcion Pequeña descripcion del pedido
     * @param cantidad Cantidad de menus
     * @param direccionEnvio Direccion donde se va a enviar el pedido
     * @param fecha Fecha de creacion del pedido
     * @param miMenu Objeto de tipo menu
     */
    public Delivery(String id_Delivery, String descripcion, Integer cantidad, String direccionEnvio, Date fecha, Menu miMenu) {
        this.id_Delivery = id_Delivery;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.direccionEnvio = direccionEnvio;
        this.fecha = fecha;
        this.miMenu = miMenu;
    }

    // GETTERS AND SETTERS
    public String getId_Delivery() {
        return id_Delivery;
    }

    public void setId_Delivery(String id_Delivery) {
        this.id_Delivery = id_Delivery;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Menu getMiMenu() {
        return miMenu;
    }

    public void setMiMenu(Menu miMenu) {
        this.miMenu = miMenu;
    }

}
