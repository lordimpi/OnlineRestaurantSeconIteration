package co.unicauca.common.domain.entity;

/**
 * Clase plato principal
 *
 * @author Santiago Acuña
 */
public class MainDish {

    /**
     * Identificador del plato principal
     */
    private String id_mainDishe;
    /**
     * Nombre del plato principal
     */
    private String nameDishe;

    /**
     * Precio del plato principal
     */
    private double dishPrice;

    /**
     * Constructor parametrizado
     *
     * @param id_mainDishe Identificador del plato principal
     * @param nameDishe Nombre del plato principal
     * @param dishPrice Precio del plato prinicipal
     */
    public MainDish(String id_mainDishe, String nameDishe, double dishPrice) {
        this.id_mainDishe = id_mainDishe;
        this.nameDishe = nameDishe;
        this.dishPrice = dishPrice;
    }

    /**
     * Constructor por defecto
     */
    public MainDish() {
    }

    //GETER AND SETTER
    public String getId_mainDishe() {
        return id_mainDishe;
    }

    public void setId_mainDishe(String id_mainDishe) {
        this.id_mainDishe = id_mainDishe;
    }

    public String getNameDishe() {
        return nameDishe;
    }

    public void setNameDishe(String nameDishe) {
        this.nameDishe = nameDishe;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

}
