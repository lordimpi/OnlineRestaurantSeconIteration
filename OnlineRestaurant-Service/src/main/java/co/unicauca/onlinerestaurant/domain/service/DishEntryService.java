package co.unicauca.onlinerestaurant.domain.service;

import co.unicauca.common.domain.entity.DishEntry;
import javax.inject.Inject;
import co.unicauca.onlinerestaurant.access.IDishEntryRepository;
import co.unicauca.onlinerestaurant.domain.validators.ValidationError;
import co.unicauca.onlinerestaurant.infra.Error;
import co.unicauca.onlinerestaurant.infra.DomainErrors;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de Platos de Entrada. Es una fachada de acceso al negocio.
 *
 * @author Ximena Gallego
 */
public class DishEntryService {

    /**
     * Dependencia de una abstacción No es algo concreto. No se sabe como será
     * implementado
     */
    @Inject
    private IDishEntryRepository repository;

    /**
     * Busca un producto por su Id
     *
     * @param id id de plato de entrada
     * @return Plato de Entrada, o null, si no lo encuentra
     */
    public DishEntry findById(String id) {
        return repository.findByIdDishEntry(id);
    }

    public void setDishEntryRepository(IDishEntryRepository repository) {
        this.repository = repository;
    }

    /**
     * Busca todos los platos de entrada
     *
     * @return lista de platos de entrada
     */
    public List<DishEntry> findAll() {
        List<DishEntry> dishEntry = repository.findAllDishEntry();
        return dishEntry;
    }

    /**
     * Crea un nuevo plato de entrada
     *
     * @param newDishEntry Plato de entrada
     * @return true si lo crea, false si no
     */
    public boolean createDishEntry(DishEntry newDishEntry) {
        List<Error> errors = validateCreate(newDishEntry);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        //Si pasa las validaciones se graba en la bd
        return repository.createDishEntry(newDishEntry);

    }

    /**
     * Edita o actualiza un plato de Entrada
     *
     * @param id identificador de plato de entrada
     * @param newDishEntry plato de entrada a editar en el sistema
     * @return true si se actualizo correctamente, false de lo contrario
     */
    public boolean updateDishEntry(String id, DishEntry newDishEntry) {
        List<Error> errors = validateUpdate(id, newDishEntry);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        DishEntry dishentryhAux = this.findById(id);
        dishentryhAux.setNameDishEntry(newDishEntry.getNameDishEntry());
        dishentryhAux.setCostDishEntry(newDishEntry.getCostDishEntry());
        repository.updateDishEntry(dishentryhAux);
        return true;
    }

    /**
     * Elimina un plato de Entrada de la base de datos
     *
     * @param id identificador de plato de entrada
     * @return true si se elimino correctamente, false de lo contrario
     */
    public boolean delete(String id) {
        //Validate product
        List<Error> errors = validateDelete(id);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        // Pasada la validación, se puede borrar de la bd
        return repository.deleteDishEntry(id);
    }

    /**
     * Valida que el producto esté correcto antes de grabarlo
     *
     * @param newDishEntry plato de entrada
     * @return lista de errores de negocio
     */
    private List<Error> validateCreate(DishEntry newDishEntry) {
        List<Error> errors = new ArrayList<>();
        //Validate product
        if (newDishEntry.getIdDishEntry() == null || newDishEntry.getIdDishEntry().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Id", "El id del plato de entrada es obligatorio");
            errors.add(error);
        }
        if (newDishEntry.getNameDishEntry() == null || newDishEntry.getNameDishEntry().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre del plato de entrada es obligatorio");
            errors.add(error);
        }
//        if (newDishEntry.getCostDishEntry() == null || newDishEntry.getCostDishEntry() <= 0) {
//            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio del producto es obligatorio");
//            errors.add(error);
//        }

        //Validar que no exista el producto
        if (newDishEntry.getIdDishEntry() != null) {
            if (Integer.parseInt(newDishEntry.getIdDishEntry()) > 0) {
                DishEntry dishentryAux = repository.findByIdDishEntry(newDishEntry.getIdDishEntry());

                if (dishentryAux != null) {
                    // El producto ya existe
                    Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del plato de entrada ya existe");
                    errors.add(error);
                }
            }
        }
        return errors;
    }

    /**
     * Valida que el plato de entrada esté correcto antes de editarlo en la bd
     *
     * @param newDishEntry plato de Entrada
     * @return lista de errores de negocio
     */
    private List<Error> validateUpdate(String id, DishEntry newDishEntry) {
        List<Error> errors = new ArrayList<>();
        //Validate product

        if (newDishEntry.getNameDishEntry() == null || newDishEntry.getNameDishEntry().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre del plato principal es obligatorio");
            errors.add(error);
        }
//        if (newDishEntry.getCostDishEntry() == null || newDishEntry.getCostDishEntry() <= 0) {
//            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio del plato principal es obligatorio");
//            errors.add(error);
//        }

        // Validar que exista el producto
        DishEntry dishEntryAux = repository.findByIdDishEntry(id);

        if (dishEntryAux == null) {
            // El producto no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del plato de Entrada existe");
            errors.add(error);
        }

        return errors;
    }

    private List<Error> validateDelete(String id) {
        List<Error> errors = new ArrayList<>();
        // Validar que exista el producto
        DishEntry dishentryhAux = repository.findByIdDishEntry(id);

        if (dishentryhAux == null) {
            // El producto no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del plato de Entrada no existe");
            errors.add(error);
        }

        return errors;
    }

}
