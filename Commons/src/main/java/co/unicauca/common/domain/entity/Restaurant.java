package co.unicauca.common.domain.entity;

/**
 *
 * @author Ximena y Julian Rodriguez
 */
public class Restaurant {

    /**
     * identificador del restaurante
     */
    private String idRestaurant;
    /**
     * Nombre del restaurante
     */
    private String NameRestaurant;
    /**
     * direccion del restaurante
     */
    private String addressRestaurant;
    /**
     * telefono del restaurante
     */
    private String phone;
    /**
    *  id del menu lunes
    */
    private String id_menu_lu;
    /**
     * id del menu
     */
    private String id_menu_ma;
    /**
     * id del menu
     */
    private String id_menu_mi;
    /**
     * id del menu
     */
    private String id_menu_ju;
    /**
     * id del menu
     */
    private String id_menu_vi;
    /**
     *  id del menu
     */
    private String id_menu_sa;

   /**
     * Constructor parametrizado
     *
     * @param idRestaurant identificador del restaurante
     * @param NameRestaurant nombre del restaurante
     * @param addressRestaurant direccion
     * @param phone telefono
     * @param id_menu_lu menu lunes
     * @param id_menu_ma menu martes
     * @param id_menu_mi menu miercoles
     * @param id_menu_ju menu jueves
     * @param id_menu_vi menu viernes
     * @param id_menu_sa menu sabado
     */
 public Restaurant(String idRestaurant, String NameRestaurant, String addressRestaurant, String phone,String id_menu_lu,String id_menu_ma,String id_menu_mi,String id_menu_ju,String id_menu_vi,String id_menu_sa) {
        this.idRestaurant = idRestaurant;
        this.NameRestaurant = NameRestaurant;
        this.addressRestaurant = addressRestaurant;
        this.phone = phone;
        this.id_menu_lu=id_menu_lu;
        this.id_menu_ma=id_menu_lu;
        this.id_menu_mi=id_menu_lu;
        this.id_menu_ju=id_menu_lu;
        this.id_menu_vi=id_menu_lu;
        this.id_menu_sa=id_menu_lu;
    }

    /**
     * Constructor por defecto
     */
    public Restaurant() {
    }

    /**
     * Getters and seters
     *
     * @return
     */
    public String getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getNameRestaurant() {
        return NameRestaurant;
    }

    public void setNameRestaurant(String NameRestaurant) {
        this.NameRestaurant = NameRestaurant;
    }

    public String getAddressRestaurant() {
        return addressRestaurant;
    }

    public void setAddressRestaurant(String addressRestaurant) {
        this.addressRestaurant = addressRestaurant;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdmenuLu() {
        return id_menu_lu;
    }

    public void setIdmenuLu(String id_menu_lu) {
        this.id_menu_lu = id_menu_lu;
    }

    public String getIdmenuMa() {
        return id_menu_ma;
    }

    public void setIdmenuMa(String id_menu_lu) {
        this.id_menu_ma = id_menu_lu;
    }

    public String getIdmenuMi() {
        return id_menu_mi;
    }

    public void setIdmenuMi(String id_menu_lu) {
        this.id_menu_mi = id_menu_lu;
    }

    public String getIdmenuJu() {
        return id_menu_ju;
    }

    public void setIdmenuJu(String id_menu_lu) {
        this.id_menu_ju = id_menu_lu;
    }

    public String getIdmenuVi() {
        return id_menu_vi;
    }

    public void setIdmenuVi(String id_menu_lu) {
        this.id_menu_vi = id_menu_lu;
    }

    public String getIdmenuSa() {
        return id_menu_sa;
    }

    public void setIdmenuSa(String id_menu_lu) {
        this.id_menu_sa = id_menu_lu;
    }

    @Override
    public String toString() {
        return getNameRestaurant();
    }
}
