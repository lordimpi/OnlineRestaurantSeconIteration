package co.unicauca.menu.domain.service;

import co.unicauca.common.domain.entity.Menu;
import co.unicauca.menu.access.IMenuRepository;
import co.unicauca.menu.domain.validators.ValidationError;
import co.unicauca.menu.infra.Error;
import co.unicauca.menu.infra.DomainErrors;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Servicio de Postres. Es una fachada de acceso al negocio. Lo usa la capa de
 * presentación.
 *
 * @author Julian Rodriguez
 */
public class MenuService {

    /**
     * Dependencia de una abstacción No es algo concreto. No se sabe como será
     * implementado
     */
    @Inject
    private IMenuRepository repository;

    /**
     * Busca un menu por su Id
     *
     * @param id id del menu
     * @return menu, o null, si no lo encuentra
     */
    public Menu findById(String id) {
        return repository.findById(id);
    }

    public void setUserRepository(IMenuRepository repository) {
        this.repository = repository;
    }

    /**
     * Busca todos los menus
     *
     * @return lista de menus
     */
    public List<Menu> findAll() {
        List<Menu> menus = repository.findAll();
        return menus;
    }

    /**
     * Crea un nuevo menu
     *
     * @param newMenu menu a guardar en la base de datos
     * @return true si lo crea, false si no
     */
    public boolean create(Menu newMenu) {
        List<Error> errors = validateCreate(newMenu);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        //Si pasa las validaciones se graba en la bd
        return repository.create(newMenu);

    }

    /**
     * Edita o actualiza un menu
     *
     * @param id identificador del menu
     * @param newMenu menu a editar en el sistema
     * @return
     */
    public boolean update(String id, Menu newMenu) {
        List<Error> errors = validateUpdate(id, newMenu);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        Menu menuAux = this.findById(id);
        menuAux.setDessert(newMenu.getDessert());
        menuAux.setDrink(newMenu.getDrink());
        menuAux.setSalad(newMenu.getSalad());
        menuAux.setEntry(newMenu.getEntry());
        menuAux.setMaindish(newMenu.getMaindish());
       

        repository.update(menuAux);
        return true;
    }

    /**
     * Elimina un menu de la base de datos
     *
     * @param id identificador del menu
     * @return
     */
    public boolean delete(String id) {
        //Validate menu
        List<Error> errors = validateDelete(id);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        // Pasada la validación, se puede borrar de la bd
        return repository.delete(id);
    }

    /**
     * Valida que el menu esté correcto antes de grabarlo
     *
     * @param newMenu menu
     * @return lista de errores
     */
    private List<Error> validateCreate(Menu newMenu) {
        List<Error> errors = new ArrayList<>();
        //Validate user
        if (newMenu.getId_menu() == null || newMenu.getId_menu().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Id", "El id del usuario es obligatorio");
            errors.add(error);
        }

        //Validar que no exista el menu
        if (newMenu.getId_menu() != null) {

            Menu menuAux = repository.findById(newMenu.getId_menu());

            if (menuAux != null) {
                // El menu ya existe
                Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del menu ya existe");
                errors.add(error);
            }
        }

        return errors;
    }

    /**
     * Valida que el menu esté correcto antes de editarlo en la bd
     *
     * @param newMenu menu
     * @return lista de errores
     */
    private List<Error> validateUpdate(String id, Menu newMenu) {
        List<Error> errors = new ArrayList<>();
        //Validate menu
        if (newMenu.getId_menu() == null || newMenu.getId_menu().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Id", "El id del menu es obligatorio");
            errors.add(error);
        }
        // Validar que exista el menu
        Menu menuAux = repository.findById(id);

        if (menuAux == null) {
            // El usuario no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del menu no existe");
            errors.add(error);
        }

        return errors;
    }

    private List<Error> validateDelete(String id) {
        List<Error> errors = new ArrayList<>();
        // Validar que exista el menu
        Menu menuAux = repository.findById(id);

        if (menuAux == null) {
            // El menu no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del menu no existe");
            errors.add(error);
        }

        return errors;
    }
}