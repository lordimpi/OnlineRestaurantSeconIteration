package co.unicauca.common.domain.entity;

import java.util.Date;

/**
 * Cliente del Restaurante
 *
 * @author Santiago Acuña
 */
public class User {

    /**
     * Password
     */
    protected String pws;
    /**
     * Cedula
     */
    protected String id;
    /**
     * Nombres
     */
    protected String firstName;
    /**
     * Apellidos
     */
    protected String lastName;
    /**
     * Dirección de residencia
     */
    protected String address;
    /**
     * Teléfono Móvil
     */
    protected String mobile;
    /**
     * Email
     */
    protected String email;
    /**
     * Rol
     */
    protected String rol;

    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPws() {
        return pws;
    }

    public void setPws(String pws) {
        this.pws = pws;
    }

    /**
     * Constructor parametrizado
     *
     * @param id cedula
     * @param firstName nombres
     * @param lastName apellidos
     * @param address dirección
     * @param mobile celular
     * @param email email
     * @param rol rol
     */
    public User(String id, String firstName, String lastName, String address, String mobile, String email, String rol, String pws) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.rol = rol;
        this.pws = pws;
    }

    /**
     * Constructor por defecto
     */
    public User() {

    }
}
