package co.unicauca.common.domain.entity;

/**
 * Clase menu
 *
 * @author soces
 */
public class Menu {

    /**
     * identificador del menu
     */
    private String id_menu;
    /**
     * entrada
     */

    private DishEntry entry;
    /**
     * plato principal
     */

    private MainDish maindish;
    /**
     * ensalada
     */

    private Salad salad;

    /**
     * bebida
     */
    private Drink drink;

    /**
     * postre
     */
    private Dessert dessert;

    public Menu(String id) {
        this.id_menu = id;
    }
    
    public Menu()
    {
        
    }

    //getters y setters
    public String getId_menu() {
        return id_menu;
    }

    public void setId_menu(String id_menu) {
        this.id_menu = id_menu;
    }

    public MainDish getMaindish() {
        return maindish;
    }

    public void setMaindish(MainDish maindish) {
        this.maindish = maindish;
    }

    public DishEntry getEntry() {
        return entry;
    }

    public void setEntry(DishEntry entry) {
        this.entry = entry;
    }

    public Salad getSalad() {
        return salad;
    }

    public void setSalad(Salad salad) {
        this.salad = salad;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert desert) {
        this.dessert = desert;
    }

}
