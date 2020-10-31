package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.client.MainDishJerseyClient;
import co.unicauca.common.domain.entity.MainDish;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Interfaz donde se declara un CRUD para platos principales
 *
 * @author Santiago Acuña
 */
public class MainDishAccessREST implements IMainDishAccess {

    MainDishJerseyClient jersey;
    Response rta;

    public MainDishAccessREST() {
        this.jersey = new MainDishJerseyClient();
    }

    /**
     * Buscar un plato consumiendo un API REST mediante un cliente jersey
     *
     * @param id identificado del plato principal
     * @return objeto plato
     * @throws Exception error al buscar un plato
     */
    @Override
    public MainDish findMainDish(String id) throws Exception {
        MainDish maindish = jersey.findById_JSON(MainDish.class, id);
        return maindish;
    }

    /**
     * Actualiza un plato consumiendo un API REST mediante un cliente jersey
     *
     * @param id Identificador del plato
     * @param name Nombre del plato
     * @param price Precio del plato
     * @return objeto plato
     * @throws Exception error al actualizar el plato
     */
    @Override
    public boolean updateMainDish(String id, String name, Double price) throws Exception {
        MainDish mainDish = findMainDish(id);
        if (mainDish == null) {
            return false;
        }
        mainDish.setDishPrice(price);
        mainDish.setNameDish(name);
        rta = jersey.edit_JSON(mainDish, id);
        return true;
    }

    /**
     * Elimina un plato consumiendo un API REST mediante un cliente jersey
     *
     * @param id Identificador del plato
     * @return true si se elimino correctamente el plato o false en caso
     * contrario
     * @throws Exception error al actualizar el plato
     */
    @Override
    public boolean deleteMainDish(String id) throws Exception {
        MainDish mainDish = findMainDish(id);
        if (mainDish == null) {
            return false;
        }
        rta = jersey.delete(id);
        return true;
    }

    /**
     * Crea un plato consumiendo un API REST mediante un cliente jersey
     *
     * @param mainDish Plato del restaurante
     * @return Devuelve el id del plato creado
     * @throws Exception error crear el plato
     */
    @Override
    public boolean createMainDish(MainDish mainDish) throws Exception {
        MainDish dish = findMainDish(mainDish.getId_mainDish());
        if (dish != null) {
            return false;
        }
        rta = jersey.create_JSON(mainDish);
        return true;
    }

    /**
     * Lista todos los platos consumiendo un API REST mediante un cliente jersey
     *
     * @return Lista de platos
     * @throws java.lang.Exception
     */
    @Override
    public List<MainDish> list() throws Exception {
        GenericType<List<MainDish>> listResponseTypeM = new GenericType<List<MainDish>>() {
        };
        List<MainDish> mainDishes = jersey.findAll(listResponseTypeM);
        return mainDishes;
    }

}
