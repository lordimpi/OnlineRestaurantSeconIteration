package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.client.DessertJerseyClient;
import co.unicauca.common.domain.entity.Dessert;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Interfaz donde se declara un CRUD para postres
 *
 * @author Camilo Otaya
 */
public class DessertAccessREST implements IDessertAccess {

    DessertJerseyClient jersey;
    Response rta;

    public DessertAccessREST() {
        this.jersey = new DessertJerseyClient();
    }

    /**
     * Buscar un postre consumiendo un API REST mediante un cliente jersey
     *
     * @param id identificado del postre
     * @return objeto postre
     * @throws Exception error al buscar un postre
     */
    @Override
    public Dessert findDessert(String id) throws Exception {
        Dessert dessert = jersey.findById_JSON(Dessert.class, id);
        return dessert;
    }

    /**
     * Actualiza un postre consumiendo un API REST mediante un cliente jersey
     *
     * @param id Identificador del postre
     * @param name Nombre del postre
     * @param cost Precio del postre
     * @return objeto plato
     * @throws Exception error al actualizar el plato
     */
    @Override
    public boolean updateDessert(String id, String name, Double cost) throws Exception {
        Dessert dessert = findDessert(id);
        if (dessert == null) {
            return false;
        }
        dessert.setCost_Dish_Dessert(cost);
        dessert.setName_Dish_Dessert(name);
        rta = jersey.edit_JSON(dessert, id);
        return true;
    }

    /**
     * Elimina un postre consumiendo un API REST mediante un cliente jersey
     *
     * @param id Identificador del postre
     * @return true si se elimino correctamente el postre o false en caso
     * contrario
     * @throws Exception error al actualizar el postre
     */
    @Override
    public boolean deleteDessert(String id) throws Exception {
        Dessert dessert = findDessert(id);
        if (dessert == null) {
            return false;
        }
        rta = jersey.delete(id);
        return true;
    }

    /**
     * Crea un postre consumiendo un API REST mediante un cliente jersey
     *
     * @param dessert postre del restaurante
     * @return Devuelve el id del postre creado
     * @throws Exception error crear el postre
     */
    @Override
    public boolean createDessert(Dessert dessert) throws Exception {
        Dessert dish = findDessert(dessert.getId_Dish_Dessert());
        if (dish != null) {
            return false;
        }
        rta = jersey.create_JSON(dessert);
        return true;
    }

    /**
     * Lista todos los platos consumiendo un API REST mediante un cliente jersey
     *
     * @return Lista de platos
     * @throws java.lang.Exception
     */
    @Override
    public List<Dessert> list() throws Exception {
        GenericType<List<Dessert>> listResponseTypeM = new GenericType<List<Dessert>>() {
        };
        List<Dessert> dessert = jersey.findAll(listResponseTypeM);
        return dessert;
    }

}
