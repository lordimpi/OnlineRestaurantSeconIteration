package co.unicauca.common.domain.entity;

/**
 *
 * @author alejo
 */
public class Salad {

    /**
     * Identificador
     */
    private String idSalad;
    /**
     * Nombre
     */
    private String nameSalad;
    /**
     * valor
     */
    private double costSalad;
    


    public Salad(String idSalad, String nameSalad, int costSalad) {
        this.idSalad = idSalad;
        this.nameSalad = nameSalad;
        this.costSalad = costSalad;
    }

    public Salad() {
    }

    
    //GETER AND SETTER
    public String getIdSalad() {
        return idSalad;
    }

    public void setIdSalad(String idSalad) {
        this.idSalad = idSalad;
    }

    public String getNameSalad() {
        return nameSalad;
    }

    public void setNameDishSalad(String nameSalad) {
        this.nameSalad = nameSalad;
    }

    public double getCostSalad() {
        return costSalad;
    }

    public void setCostSalad(double costSalad) {
        this.costSalad = costSalad;
    }
    
    @Override
    public String toString() {
        return "Salad {" + "id=" + idSalad + ", name=" + nameSalad + ", price=" + costSalad + '}';
    }
}
