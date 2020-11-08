package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.client.DrinkJerseyClient;
import co.unicauca.common.domain.entity.Drink;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *Interfaz donde se declara un CRUD para las bebidas
 * 
 * @author Mariat Trujillo
 */
public class DrinkAccessREST implements IDrinkAccess {
    
    DrinkJerseyClient jersey;
    Response rta;

    public DrinkAccessREST() {
        this.jersey = new DrinkJerseyClient();
    }

    /**
    * Buscar una bebida consumiendo un API REST mediante un cliente jersey
     *
     * @param id identificado de la bebida
     * @return objeto bebida
     * @throws Exception error al buscar una bebida
     */
    @Override
    public Drink findDrink(String id) throws Exception {
        Drink drink = jersey.findById_JSON(Drink.class, id);
        return drink;
    }
    
     /**
     * Actualiza una bebida consumiendo un API REST mediante un cliente jersey
     *
     * @param id Identificador de la bebida
     * @param name Nombre de la bebida
     * @param price Precio de la bebida
     * @return objeto bebida
     * @throws Exception error al actualizar la bebida
     */
     @Override
    public boolean updateDrink(String id, String name, Double price) throws Exception {
        Drink drink = findDrink(id);
        if (drink == null) {
            return false;
        }
        drink.setDrinkPrice(price);
        drink.setNameDrink(name);
        rta = jersey.edit_JSON(drink, id);
        return true;
    }

     /**
     * Elimina una bebida consumiendo un API REST mediante un cliente jersey
     *
     * @param id Identificador de la bebida
     * @return true si se elimino correctamente la bebida o false en caso
     * contrario
     * @throws Exception error al actualizar la bebida
     */
    @Override
    public boolean deleteDrink(String id) throws Exception {
        Drink drink = findDrink(id);
        if (drink == null) {
            return false;
        }
        rta = jersey.delete(id);
        return true;
    }

    /**
     * Crea una bebida consumiendo un API REST mediante un cliente jersey
     *
     * @param drink Bebida del restaurante
     * @return Devuelve el id de la bebida creada
     * @throws Exception error crear la bebida
     */
    @Override
    public boolean createDrink(Drink drink) throws Exception {
        Drink dish = findDrink(drink.getId_Drink());
        if (dish != null) {
            return false;
        }
        rta = jersey.create_JSON(drink);
        return true;
    }
    
     /**
     * Lista todos las bebidas consumiendo un API REST mediante un cliente jersey
     *
     * @return Lista de bebidas
     * @throws java.lang.Exception
     */
    @Override
    public List<Drink> list() throws Exception {
        GenericType<List<Drink>> listResponseTypeM = new GenericType<List<Drink>>() {
        };
        List<Drink> mainDishes = jersey.findAll(listResponseTypeM);
        return mainDishes;
    }

}
