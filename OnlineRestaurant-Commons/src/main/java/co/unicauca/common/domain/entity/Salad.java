package co.unicauca.common.domain.entity;

/**
 * Clase Ensalada
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
    private Double costSalad;

    public Salad(String idSalad, String nameSalad, Double costSalad) {
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

    public void setNameSalad(String nameSalad) {
        this.nameSalad = nameSalad;
    }

    public Double getCostSalad() {
        return costSalad;
    }

    public void setCostSalad(Double costSalad) {
        this.costSalad = costSalad;
    }
    
    @Override
    public String toString() {
        return "Salad {" + "id=" + idSalad + ", name=" + nameSalad + ", price=" + costSalad + '}';
    }
}
