package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.client.DishEntryJerseyClient;
import co.unicauca.common.domain.entity.DishEntry;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Interfaz donde se declara un CRUD para platos de Entrada
 *
 * @author Santiago Acuña, Ximena Gallego
 */
public class EntryAccessREST implements IEntryAccess {

    DishEntryJerseyClient jersey;
    Response rta;

    public EntryAccessREST() {
        this.jersey = new DishEntryJerseyClient();
    }

    /**
     * Buscar un plato de entrada consumiendo un API REST mediante un cliente
     * jersey
     *
     * @param id identificado del plato de entrada
     * @return objeto plato de entrada
     * @throws Exception error al buscar un plato de entrada
     */
    @Override
    public DishEntry findEntry(String id) throws Exception {
        DishEntry dishentry = jersey.findById_JSON(DishEntry.class, id);
        return dishentry;
    }

    /**
     * Actualiza un plato de entrada consumiendo un API REST mediante un cliente
     * jersey
     *
     * @param id Identificador del plato de entrada
     * @param name Nombre del plato de entrada
     * @param price Precio del plato de entrada
     * @return objeto plato de entrada
     * @throws Exception error al actualizar el plato de entrada
     */
    @Override
    public boolean updateDishEntry(String id, String name, Double price) throws Exception {
        DishEntry dishentry = findEntry(id);
        if (dishentry == null) {
            return false;
        }
        dishentry.setCostDishEntry(price);
        dishentry.setNameDishEntry(name);
        rta = jersey.edit_JSON(dishentry, id);
        return true;
    }

    /**
     * Elimina un plato de entrada consumiendo un API REST mediante un cliente
     * jersey
     *
     * @param id Identificador del plato de entrada
     * @return true si se elimino correctamente el plato de entrada o false en
     * caso contrario
     * @throws Exception error al actualizar el plato
     */
    @Override
    public boolean deleteDishEntry(String id) throws Exception {
        DishEntry dishentry = findEntry(id);
        if (dishentry == null) {
            return false;
        }
        rta = jersey.delete(id);
        return true;
    }

    /**
     * Crea un plato de entrada consumiendo un API REST mediante un cliente
     * jersey
     *
     * @param dishEntry Plato de entrada del restaurante
     * @return Devuelve el id del plato de entrada creado
     * @throws Exception error crear el plato de entrada
     */
    @Override
    public boolean createDishEntry(DishEntry dishEntry) throws Exception {
        DishEntry entry = findEntry(dishEntry.getIdDishEntry());
        if (entry != null) {
            return false;
        }
        rta = jersey.create_JSON(dishEntry);
        return true;

    }

    /**
     * Lista todos los platos de entrada consumiendo un API REST mediante un
     * cliente jersey
     *
     * @return Lista de platos de entrada
     * @throws java.lang.Exception
     */
    @Override
    public List<DishEntry> list() throws Exception {
        GenericType<List<DishEntry>> listResponseTypeM = new GenericType<List<DishEntry>>() {
        };
        List<DishEntry> dishEntrys = jersey.findAll(listResponseTypeM);
        return dishEntrys;
    }

}
