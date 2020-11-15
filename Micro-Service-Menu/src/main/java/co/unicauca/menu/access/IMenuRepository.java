package co.unicauca.menu.access;


import co.unicauca.common.domain.entity.Menu;
import java.util.List;

/**
 *
 * @author Julian Rodriguez
 */
public interface IMenuRepository {
    
    List<Menu> findAll();

     /**
     * Declaracion del metodo buscar plato
     *
     * @param id Identificador de un menu
     * @return un menu
     */
    
    Menu findById(String id);
    
    /**
     * Declaracion del metodo crear menu
     * @param newMenu
     * @return 
     */

    boolean create(Menu newMenu);

    /**
     * Declaracion del metodo actualizar menu
     * 
     * @param newMenu Menu a actualizar
     * @return 
     */
    boolean update(Menu newMenu);
    
    /**
     * Declaracion del metodo elimar menu
     *
     * @param id identificador del menu
     * @return true si pudo borrar, false de lo contrario
     */

    boolean delete(String id);
       
}
