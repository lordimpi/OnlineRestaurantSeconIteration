package co.unicauca.common.domain.entity;

/**
 * Clase bebida
 *
 * @author alejo
 */
public class Drink {

    /**
     * Identificador de bebida
     */
    private String id_Drink;
    /**
     * Nombre de bebida
     */
    private String nameDrink;
    /**
     * Precio de la bebida
     */
    private Double drinkPrice;

    /**
     * Constructor por defecto
     *
     * @param id_Drink Identificador de bebida
     * @param nameDrink Nombre de la bebida
     * @param drinkPrice Precio de la bebida
     */
    public Drink(String id_Drink, String nameDrink, Double drinkPrice) {
        this.id_Drink = id_Drink;
        this.nameDrink = nameDrink;
        this.drinkPrice = drinkPrice;
    }

    /**
     * Constructor por defecto
     */
    public Drink() {
    }

    //GETER AND SETTER
    public String getId_Drink() {
        return id_Drink;
    }

    public void setId_Drink(String id_Drink) {
        this.id_Drink = id_Drink;
    }

    public String getNameDrink() {
        return nameDrink;
    }

    public void setNameDrink(String nameDrink) {
        this.nameDrink = nameDrink;
    }

    public Double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(Double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    @Override
    public String toString() {
        return getNameDrink();
    }
}
