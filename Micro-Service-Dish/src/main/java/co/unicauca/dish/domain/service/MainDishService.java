package co.unicauca.dish.domain.service;

import co.unicauca.common.domain.entity.MainDish;
import javax.inject.Inject;
import co.unicauca.dish.access.IMainDishRepository;
import co.unicauca.common.domain.validators.ValidationError;
import co.unicauca.common.infra.Error;
import co.unicauca.common.infra.DomainErrors;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de plato principales. Es una fachada de acceso al negocio. Lo usa la
 * capa de presentación.
 *
 * @author Santiago Acuña
 */
public class MainDishService {

    /**
     * Dependencia de una abstacción No es algo concreto. No se sabe como será
     * implementado
     */
    @Inject
    private IMainDishRepository repository;

    /**
     * Busca un plato principal por su Id
     *
     * @param id id del plato principal
     * @return plato principal, o null, si no lo encuentra
     */
    public MainDish findById(String id) {
        return repository.findById(id);
    }

    /**
     * Hace la inyeccion de dependencias de forma automatica
     *
     * @param repository Guarda la inyeccion de dependecias
     */
    public void setMainDishRepository(IMainDishRepository repository) {
        this.repository = repository;
    }

    /**
     * Busca todos los platos principales en la base de datos
     *
     * @return lista de platos principales
     */
    public List<MainDish> findAll() {
        List<MainDish> mainDishes = repository.findAll();
        return mainDishes;
    }

    /**
     * Crea un nuevo plato principal
     *
     * @param newMainDish Plato principal a guardar en la base de datos
     * @return true si lo crea, false si no
     */
    public boolean create(MainDish newMainDish) {
        List<Error> errors = validateCreate(newMainDish);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        //Si pasa las validaciones se graba en la bd
        return repository.create(newMainDish);

    }

    /**
     * Edita o actualiza un plato principal
     *
     * @param id identificador del plato principal
     * @param newMainDish Plato principal a editar en el sistema
     * @return True si puedo actualizar, false de lo contrario
     */
    public boolean update(String id, MainDish newMainDish) {
        List<Error> errors = validateUpdate(id, newMainDish);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        MainDish mainDishAux = this.findById(id);
        mainDishAux.setNameDish(newMainDish.getNameDish());
        mainDishAux.setDishPrice(newMainDish.getDishPrice());
        repository.update(mainDishAux);
        return true;
    }

    /**
     * Elimina un plato principal de la base de datos
     *
     * @param id identificador del plato principal
     * @return True si puedo eliminar, false de lo contrario
     */
    public boolean delete(String id) {
        //Validate MainDish
        List<Error> errors = validateDelete(id);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        // Pasada la validación, se puede borrar de la bd
        return repository.delete(id);
    }

    /**
     * Valida que el plato principal esté correcto antes de grabarlo
     *
     * @param newMainDish plato principal
     * @return lista de errores de negocio
     */
    private List<Error> validateCreate(MainDish newMainDish) {
        List<Error> errors = new ArrayList<>();
        //Validate MainDish
        if (newMainDish.getId_mainDish() == null || newMainDish.getId_mainDish().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Id", "El id del plato principal es obligatorio");
            errors.add(error);
        }
        if (newMainDish.getNameDish() == null || newMainDish.getNameDish().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre del plato principal es obligatorio");
            errors.add(error);
        }
        if (newMainDish.getDishPrice() == null || newMainDish.getDishPrice() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio del plato principal es obligatorio");
            errors.add(error);
        }

        //Validar que no exista el plato principal
        if (newMainDish.getId_mainDish() != null) {
            if (Integer.parseInt(newMainDish.getId_mainDish()) > 0) {
                MainDish mainDishAux = repository.findById(newMainDish.getId_mainDish());

                if (mainDishAux != null) {
                    // El plato principal ya existe
                    Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del plato principal ya existe");
                    errors.add(error);
                }
            }
        }
        return errors;
    }

    /**
     * Valida que el plato principal esté correcto antes de editarlo en la bd
     *
     * @param newMainDish plato principal
     * @return lista de errores de negocio
     */
    private List<Error> validateUpdate(String id, MainDish newMainDish) {
        List<Error> errors = new ArrayList<>();
        //Validate MainDish

        if (newMainDish.getNameDish() == null || newMainDish.getNameDish().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre del plato principal es obligatorio");
            errors.add(error);
        }
        if (newMainDish.getDishPrice() == null || newMainDish.getDishPrice() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio del plato principal es obligatorio");
            errors.add(error);
        }

        // Validar que exista el plato principal
        MainDish mainDishAux = repository.findById(id);

        if (mainDishAux == null) {
            // El plato principal no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del plato principal no existe");
            errors.add(error);
        }

        return errors;
    }

    /**
     * Valida que el plato principal exista antes de eliminarlo de la base de
     * datos
     *
     * @param id Identificador a validar
     * @return Lista de errores de negocio
     */
    private List<Error> validateDelete(String id) {
        List<Error> errors = new ArrayList<>();
        // Validar que exista el plato principal
        MainDish mainDishAux = repository.findById(id);

        if (mainDishAux == null) {
            // El plato principal no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del plato principal no existe");
            errors.add(error);
        }

        return errors;
    }
}
