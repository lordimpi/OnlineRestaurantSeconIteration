package co.unicauca.common.domain.entity;

/**
 * Clase de plato de Entrada
 *
 * @author alejo, Ximena
 */
public class DishEntry {

    /**
     * Identificador
     */
    private String idDishEntry;
    /**
     * Nombre
     */
    private String nameDishEntry;
    /**
     * valor
     */
    private double costDishEntry;

    /**
     * Constructor por defecto
     */
    public DishEntry() {
    }

    /**
     * Constructor parametrizado
     *
     * @param idDishEntry identificador de plato de entrada
     * @param nameDishEntry nombre del plato entrada
     * @param costDishEntry costo del plato de entrada
     */
    public DishEntry(String idDishEntry, String nameDishEntry, int costDishEntry) {
        this.idDishEntry = idDishEntry;
        this.nameDishEntry = nameDishEntry;
        this.costDishEntry = costDishEntry;
    }

    //GETER AND SETTER
    public String getIdDishEntry() {
        return idDishEntry;
    }

    public void setIdDishEntry(String idDishEntry) {
        this.idDishEntry = idDishEntry;
    }

    public String getNameDishEntry() {
        return nameDishEntry;
    }

    public void setNameDishEntry(String nameDishEntry) {
        this.nameDishEntry = nameDishEntry;
    }

    public double getCostDishEntry() {
        return costDishEntry;
    }

    public void setCostDishEntry(double costDishEntry) {
        this.costDishEntry = costDishEntry;
    }

}
