package co.unicauca.onlinerestaurant.commons.domain;

/**
 * Clase abatracta
 *
 * @author soces
 */
public abstract class Consumible {

    private String id;

    private String name;
    private double Price;

    public Consumible(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.Price = price;
    }

    /**
     * Constructor por defecto
     */
    public Consumible() {
    }

    //GETER AND SETTER
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

}
