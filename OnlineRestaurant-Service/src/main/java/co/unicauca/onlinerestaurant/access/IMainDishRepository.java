package co.unicauca.onlinerestaurant.access;

import co.unicauca.common.domain.entity.MainDish;
import java.util.List;

/**
 *
 * @author Santiago Acuña
 */
public interface IMainDishRepository {

    /**
     * Declaracion del metodo listar platos para ser utilizado por la API REST
     * @return Retorna lista de platos principales
     */
    List<MainDish> findAll();

    /**
     * Declaacion del metodo buscar plato por Id para ser utilizado por la API REST
     * @param id Identificador del plato
     * @return Retorna un plato principal
     */
    MainDish findById(String id);

    /**
     * Declaracion del metodo crear plato principal para ser utilizado por la API REST
     * @param newMainDish Objeto de tipo plato principal a crear
     * @return Retorna true si puedo crear el plato, false de lo contrario
     */
    boolean create(MainDish newMainDish);

    /**
     * Declaracion del metodo actualizar plato principal para ser utilizado por la API REST
     * @param newMainDish Objeto de tipo plato principal que sera actualizado
     * @return Retorna true si pido actualizar, false de lo contrario
     */
    boolean update(MainDish newMainDish);

    /**
     * Declaracion del metodo borrar plato principal para ser utilizado por la API REST
     * @param id Identificador del plato principal
     * @return Retorna true si pudo eliminar, false de lo contrario
     */
    boolean delete(String id);
}
