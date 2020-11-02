package co.unicauca.onlinerestaurant.access;

import co.unicauca.common.domain.entity.Salad;
import java.util.List;

/**
 * Interfaz de repositorio de Ensalada
 *
 * @author Ximena Gallego
 */
public interface ISaladRepository {

    /**
     * Metodo encargado de listar los objetos Ensalada
     *
     * @return lista de Ensaladas
     */
    public List<Salad> findAllSalad();

    /**
     * Busca una Ensalada por su identificador
     *
     * @param id identificador de Ensalada
     * @return objeto Ensalada
     */
    public Salad findByIdSalad(String id);

    /**
     * metodo encargado de crear una Ensalada
     *
     * @param newSalad objeto Ensalada
     * @return true si pudo crear, false de lo contrario
     */
    public boolean createSalad(Salad newSalad);

    /**
     * Metodo encargado de modificar una Ensalada
     *
     * @param newSalad objeto de tipo Salad
     * @return true si se actualizo correctamente, false de lo contrario
     */
    public boolean updateSalad(Salad newSalad);

    /**
     * Metodo encargado de Eliminar una ensalada
     *
     * @param id identificador de una ensalada
     * @return true si se elimino correctamente, false de lo contrario
     */
    public boolean deleteSalad(String id);

}
