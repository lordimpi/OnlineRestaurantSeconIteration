package co.unicauca.onlinerestaurant.access;

import co.unicauca.common.domain.entity.DishEntry;
import java.util.List;

/**
 * Interfaz de repositorio de plato de entrada
 *
 * @author Ximena Gallego
 */
public interface IDishEntryRepository {

    /**
     * Metodo encargado de listar los objetos platos de entrada
     *
     * @return lista de platos de entrada
     */
    public List<DishEntry> findAllDishEntry();

    /**
     * Busca un plato de entrada por su identificador
     *
     * @param id identificador de plato de entrada
     * @return objeto de tipo entrada
     */
    public DishEntry findByIdDishEntry(String id);

    /**
     * metodo encargado de crear un plato de entrada
     *
     * @param newDishEntry entrada
     * @return true si pudo crear, false de lo contrario
     */
    public boolean createDishEntry(DishEntry newDishEntry);

    /**
     * Metodo encargado de modificar un plato de entrada
     *
     * @param newDishEntry objeto de tipo DishEntry
     * @return true si se actualizo correctamente, false de lo contrario
     */
    public boolean updateDishEntry(DishEntry newDishEntry);

    /**
     * Metodo encargado de Eliminar un plato de entrada
     *
     * @param id identificador del plato de entrada
     * @return true si se elimino correctamente, false de lo contrario
     */
    public boolean deleteDishEntry(String id);
}
