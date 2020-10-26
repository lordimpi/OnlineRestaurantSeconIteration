package co.unicauca.common.domain.entity;

/**
 * Clase postre
 *
 * @author Camilo Otaya Bravo
 */
public class Dessert {

    /**
     * Identificacion
     */
    private String id_Dish_Dessert;
    /**
     * Nombre
     */
    private String name_Dish_Dessert;
    /**
     * valor
     */
    private int cost_Dish_Dessert;

    /**
     * Constructor parametrizado id del postre nombre del postre costo del
     * postre
     *
     * @param id_Dish_Dessert
     * @param name_Dish_Dessert
     * @param cost_Dish_Dessert
     */
    public Dessert(String id_Dish_Dessert, String name_Dish_Dessert, int cost_Dish_Dessert) {
        this.id_Dish_Dessert = id_Dish_Dessert;
        this.name_Dish_Dessert = name_Dish_Dessert;
        this.cost_Dish_Dessert = cost_Dish_Dessert;
    }

    /**
     * Constructor por defecto
     */
    public Dessert() {
    }

    // getters y setters
    public String getId_Dish_Dessert() {
        return id_Dish_Dessert;
    }

    public void setId_Dish_Dessert(String id_Dish_Dessert) {
        this.id_Dish_Dessert = id_Dish_Dessert;
    }

    public String getName_Dish_Dessert() {
        return name_Dish_Dessert;
    }

    public void setName_Dish_Dessert(String name_Dish_Dessert) {
        this.name_Dish_Dessert = name_Dish_Dessert;
    }

    public int getCost_Dish_Dessert() {
        return cost_Dish_Dessert;
    }

    public void setCost_Dish_Dessert(int cost_Dish_Dessert) {
        this.cost_Dish_Dessert = cost_Dish_Dessert;
    }

}
