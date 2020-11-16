package co.unicauca.dish.access;

import co.unicauca.common.domain.entity.Salad;
import java.util.List;

/**
 * Interfaz de repositorio de ensalada
 *
 * @author Ximena Gallego
 */
public interface ISaladRepository {

    /**
     * Declaracion del metodo listar Ensalada para ser utilizado por la API REST
     *
     * @return Retorna lista de Ensaladas
     */
    List<Salad> findAll();

    /**
     * Declaacion del metodo buscar Ensalada por Id para ser utilizado por la
     * API REST
     *
     * @param id Identificador de Ensalada
     * @return Retorna una Ensalada
     */
    Salad findById(String id);

    /**
     * Declaracion del metodo crear Ensalada para ser utilizado por la API REST
     *
     * @param newSalad Objeto de tipo Ensalada a crear
     * @return Retorna true si puedo crear la Ensalada, false de lo contrario
     */
    boolean create(Salad newSalad);

    /**
     * Declaracion del metodo actualizar Ensalada para ser utilizado por la API
     * REST
     *
     * @param newSalad Objeto de tipo Ensalada que sera actualizado
     * @return Retorna true si pido actualizar, false de lo contrario
     */
    boolean update(Salad newSalad);

    /**
     * Declaracion del metodo borrar Ensalada para ser utilizado por la API REST
     *
     * @param id Identificador de Ensalada
     * @return Retorna true si pudo eliminar, false de lo contrario
     */
    boolean delete(String id);
}
