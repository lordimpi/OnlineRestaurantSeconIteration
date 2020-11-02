package co.unicauca.onlinerestaurant.domain.service;

import co.unicauca.common.domain.entity.Salad;
import javax.inject.Inject;
import co.unicauca.onlinerestaurant.access.ISaladRepository;
import co.unicauca.onlinerestaurant.domain.validators.ValidationError;
import co.unicauca.onlinerestaurant.infra.Error;
import co.unicauca.onlinerestaurant.infra.DomainErrors;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de Ensalada. Es una fachada de acceso al negocio.
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
     * @param id id de plato de entrada
     * @return Ensalada, o null, si no lo encuentra
     */
    public Salad findById(String id) {
        return repository.findByIdSalad(id);
    }

    public void setSaladRepository(ISaladRepository repository) {
        this.repository = repository;
    }
    /**
     * Busca todos las Ensaladas
     *
     * @return lista de Ensaladas
     */
    public List<Salad> findAll() {
        List<Salad> salad = repository.findAllSalad();
        return salad;
    }
    /**
     * Crea una nueva Ensalda
     *
     * @param newSalad Producto a guardar en la base de datos
     * @return true si lo crea, false si no
     */
    public boolean createSalad(Salad newSalad) {
        List<Error> errors = validateCreate(newSalad);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        //Si pasa las validaciones se graba en la bd
        return repository.createSalad(newSalad);

    }
    /**
     * Edita o actualiza una Ensalada
     *
     * @param id identificador de la Ensalada
     * @param newSalad Ensalada a editar en el sistema
     * @return true si se actualizo correctamente, false de lo contrariio 
     */
 
       public boolean update(String id, Salad newSalad) {
        List<Error> errors = validateUpdate(id, newSalad);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        Salad saladAux = this.findById(id);
        saladAux.setNameDishSalad(newSalad.getNameSalad());
        saladAux.setCostSalad(newSalad.getCostSalad());       
        repository.updateSalad(saladAux);
        return true;
    }

    /**
     * Elimina una Ensalada de la base de datos
     *
     * @param id identificador la Ensalada
     * @return
     */
    public boolean delete(String id) {
        //Validate product
        List<Error> errors = validateDelete(id);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        // Pasada la validación, se puede borrar de la bd
        return repository.deleteSalad(id);
    }

    /**
     * Valida que la Ensalada esté correcta antes de grabarlo
     *
     * @param newSalad Ensalada
     * @return lista de errores de negocio
     */
    private List<Error> validateCreate(Salad newSalad) {
        List<Error> errors = new ArrayList<>();
        //Validate product
        if (newSalad.getIdSalad() == null || newSalad.getIdSalad().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Id", "El id de la Ensalada es obligatorio");
            errors.add(error);
        }
        if (newSalad.getNameSalad() == null || newSalad.getNameSalad().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre de la Ensalada es obligatorio");
            errors.add(error);
        }
        if (newSalad.getCostSalad() == 0 || newSalad.getCostSalad() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio de la Ensalada es obligatorio");
            errors.add(error);
        }

        //Validar que no exista el producto
        if (newSalad.getIdSalad() != null) {
            if (Integer.parseInt(newSalad.getIdSalad()) > 0) {
                Salad saladAux = repository.findByIdSalad(newSalad.getIdSalad());
                
                if (saladAux != null) {
                    // El producto ya existe
                    Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id de la Ensalada ya existe");
                    errors.add(error);
                }
            }
        }
        return errors;
    }

    /**
     * Valida que la ensalada esté correcta antes de editarlo en la bd
     *
     * @param newSalad Ensalada
     * @return lista de errores de negocio
     */
    private List<Error> validateUpdate(String id, Salad newSalad) {
        List<Error> errors = new ArrayList<>();
        //Validate product

        if (newSalad.getNameSalad() == null || newSalad.getNameSalad().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre de la Ensalada es obligatorio");
            errors.add(error);
        }
        if (newSalad.getCostSalad() == 0 || newSalad.getCostSalad() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio de la Ensalada es obligatorio");
            errors.add(error);
        }

        // Validar que exista el producto
        Salad saladAux = repository.findByIdSalad(id);

        if (saladAux == null) {
            // El producto no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id de la Ensalada no existe");
            errors.add(error);
        }

        return errors;
    }

    private List<Error> validateDelete(String id) {
        List<Error> errors = new ArrayList<>();
        // Validar que exista el producto
        Salad saladAux = repository.findByIdSalad(id);

        if (saladAux == null) {
            // El producto no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id de la Ensalada no existe");
            errors.add(error);
        }

        return errors;
    }
}
