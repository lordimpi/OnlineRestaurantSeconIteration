package co.unicauca.dish.domain.service;

import co.unicauca.common.domain.entity.Salad;
import javax.inject.Inject;
import co.unicauca.dish.access.ISaladRepository;
import co.unicauca.dish.domain.validators.ValidationError;
import co.unicauca.dish.infra.Error;
import co.unicauca.dish.infra.DomainErrors;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de Ensaladas. Es una fachada de acceso al negocio. Lo usa la capa de
 * presentación.
 *
 * @author Ximena Gallego
 */
public class SaladService {

    /**
     * Dependencia de una abstacción No es algo concreto. No se sabe como será
     * implementado
     */
    @Inject
    private ISaladRepository repository;

    /**
     * Busca una Ensalada por su Id
     *
     * @param id id Ensalada
     * @return ensalada, o null, si no lo encuentra
     */
    public Salad findById(String id) {
        return repository.findById(id);
    }

    /**
     * Hace la inyeccion de dependencias de forma automatica
     *
     * @param repository Guarda la inyeccion de dependecias
     */
    public void setSaladRepository(ISaladRepository repository) {
        this.repository = repository;
    }

    /**
     * Busca todos las Ensaladas en la base de datos
     *
     * @return lista de las ensaladas
     */
    public List<Salad> findAll() {
        List<Salad> salads = repository.findAll();
        return salads;
    }
     /**
     * Crea un nueva Ensalada
     *
     * @param newSalad una ensalada a guardar en la base de datos
     * @return true si lo crea, false si no
     */
    public boolean create(Salad newSalad) {
        List<Error> errors = validateCreate(newSalad);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        //Si pasa las validaciones se graba en la bd
        return repository.create(newSalad);

    }

    /**
     * Edita o actualiza un plato principal
     *
     * @param id identificador del Ensalada
     * @param newSalad Ensalada a editar en el sistema
     * @return True si puedo actualizar, false de lo contrario
     */
    public boolean update(String id, Salad newSalad) {
        List<Error> errors = validateUpdate(id, newSalad);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        Salad saladAux = this.findById(id);
        saladAux.setNameSalad(newSalad.getNameSalad());
        saladAux.setCostSalad(newSalad.getCostSalad());        
        repository.update(saladAux);
        return true;
    }

    /**
     * Elimina una ensalada de la base de datos
     *
     * @param id identificador de ensalada
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
     * Valida que la ensalada esté correcto antes de grabarlo
     *
     * @param newSalad plato principal
     * @return lista de errores de negocio
     */
    private List<Error> validateCreate(Salad newSalad) {
        List<Error> errors = new ArrayList<>();
        //Validate Salad
        if (newSalad.getIdSalad() == null || newSalad.getIdSalad().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Id", "El id de la ensalada es obligatorio");
            errors.add(error);
        }
        if (newSalad.getNameSalad() == null || newSalad.getNameSalad().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre de la ensalada es obligatorio");
            errors.add(error);
        }
        if (newSalad.getCostSalad() == null || newSalad.getCostSalad() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio del plato principal es obligatorio");
            errors.add(error);
        }

        //Validar que no exista el plato principal
        if (newSalad.getIdSalad() != null) {
            if (Integer.parseInt(newSalad.getIdSalad()) > 0) {
                Salad saladhAux = repository.findById(newSalad.getIdSalad());

                if (saladhAux != null) {
                    // El plato principal ya existe
                    Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id de la ensalada ya existe");
                    errors.add(error);
                }
            }
        }
        return errors;
    }

    /**
     * Valida que la ensalada esté correcto antes de editarlo en la bd
     *
     * @param newSalad ensalada
     * @return lista de errores de negocio
     */
    private List<Error> validateUpdate(String id, Salad newSalad) {
        List<Error> errors = new ArrayList<>();
        //Validate MainDish

        if (newSalad.getNameSalad() == null || newSalad.getNameSalad().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre de la ensalada es obligatorio");
            errors.add(error);
        }
        if (newSalad.getCostSalad() == 0 || newSalad.getCostSalad() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio de la ensalada es obligatorio");
            errors.add(error);
        }

        // Validar que exista el plato principal
        Salad saladAux = repository.findById(id);

        if ( saladAux == null) {
            // El plato principal no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id de la ensalada no existe");
            errors.add(error);
        }

        return errors;
    }

    /**
     * Valida que la ensalada exista antes de eliminarlo de la base de
     * datos
     *
     * @param id Identificador a validar
     * @return Lista de errores de negocio
     */
    private List<Error> validateDelete(String id) {
        List<Error> errors = new ArrayList<>();
        // Validar que exista el plato principal
        Salad saladAux = repository.findById(id);

        if (saladAux == null) {
            // El plato principal no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id de la ensalada no existe");
            errors.add(error);
        }

        return errors;
    }

}
