package co.unicauca.dish.domain.service;

import co.unicauca.common.domain.entity.Dessert;
import co.unicauca.dish.access.IDessertRepository;
import co.unicauca.common.domain.validators.ValidationError;
import co.unicauca.common.infra.Error;
import co.unicauca.common.infra.DomainErrors;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Servicio de Postres. Es una fachada de acceso al negocio. Lo usa la capa de
 * presentación.
 *
 * @author Camilo Otaya
 */
public class DessertService {

    /**
     * Dependencia de una abstacción No es algo concreto. No se sabe como será
     * implementado
     */
    @Inject
    private IDessertRepository repository;

    /**
     * Busca un postre por su Id
     *
     * @param id id del postre
     * @return postre, o null, si no lo encuentra
     */
    public Dessert findById(String id) {
        return repository.findById(id);
    }

    public void setUserRepository(IDessertRepository repository) {
        this.repository = repository;
    }

    /**
     * Busca todos los postres
     *
     * @return lista de postres
     */
    public List<Dessert> findAll() {
        List<Dessert> desserts = repository.findAll();
        return desserts;
    }

    /**
     * Crea un nuevo postre
     *
     * @param newDessert postre a guardar en la base de datos
     * @return true si lo crea, false si no
     */
    public boolean create(Dessert newDessert) {
        List<Error> errors = validateCreate(newDessert);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        //Si pasa las validaciones se graba en la bd
        return repository.create(newDessert);

    }

    /**
     * Edita o actualiza un postre
     *
     * @param id identificador del postre
     * @param newDessert postre a editar en el sistema
     * @return
     */
    public boolean update(String id, Dessert newDessert) {
        List<Error> errors = validateUpdate(id, newDessert);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        Dessert dessertAux = this.findById(id);
        dessertAux.setName_Dish_Dessert(newDessert.getName_Dish_Dessert());
        dessertAux.setCost_Dish_Dessert(newDessert.getCost_Dish_Dessert());

        repository.update(dessertAux);
        return true;
    }

    /**
     * Elimina un postre de la base de datos
     *
     * @param id identificador del postre
     * @return
     */
    public boolean delete(String id) {
        //Validate dessert
        List<Error> errors = validateDelete(id);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        // Pasada la validación, se puede borrar de la bd
        return repository.delete(id);
    }

    /**
     * Valida que el postre esté correcto antes de grabarlo
     *
     * @param newDessert postre
     * @return lista de errores
     */
    private List<Error> validateCreate(Dessert newDessert) {
        List<Error> errors = new ArrayList<>();
        //Validate user
        if (newDessert.getId_Dish_Dessert() == null || newDessert.getId_Dish_Dessert().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Id", "El id del usuario es obligatorio");
            errors.add(error);
        }
        if (newDessert.getName_Dish_Dessert() == null || newDessert.getName_Dish_Dessert().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El  nombre del postre es obligatorio");
            errors.add(error);
        }
        if (newDessert.getCost_Dish_Dessert() == null || newDessert.getCost_Dish_Dessert() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio del postre es obligatorio");
            errors.add(error);
        }

        //Validar que no exista el postre
        if (newDessert.getId_Dish_Dessert() != null) {

            Dessert dessertAux = repository.findById(newDessert.getId_Dish_Dessert());

            if (dessertAux != null) {
                // El postre ya existe
                Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del postre ya existe");
                errors.add(error);
            }
        }

        return errors;
    }

    /**
     * Valida que el postre esté correcto antes de editarlo en la bd
     *
     * @param newDessert postre
     * @return lista de errores
     */
    private List<Error> validateUpdate(String id, Dessert newDessert) {
        List<Error> errors = new ArrayList<>();
        //Validate dessert
        if (newDessert.getName_Dish_Dessert() == null || newDessert.getName_Dish_Dessert().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre del postre es obligatorio");
            errors.add(error);
        }
        if (newDessert.getCost_Dish_Dessert() == null || newDessert.getCost_Dish_Dessert() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio del postre es obligatorio");
            errors.add(error);
        }

        // Validar que exista el postre
        Dessert dessertAux = repository.findById(id);

        if (dessertAux == null) {
            // El usuario no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del postre no existe");
            errors.add(error);
        }

        return errors;
    }

    private List<Error> validateDelete(String id) {
        List<Error> errors = new ArrayList<>();
        // Validar que exista el postre
        Dessert dessertAux = repository.findById(id);

        if (dessertAux == null) {
            // El postre no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del postre no existe");
            errors.add(error);
        }

        return errors;
    }
}
