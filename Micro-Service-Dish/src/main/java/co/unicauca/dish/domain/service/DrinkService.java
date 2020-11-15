package co.unicauca.dish.domain.service;

import co.unicauca.common.domain.entity.Drink;
import co.unicauca.dish.access.IDrinkRepository;
import co.unicauca.dish.domain.validators.ValidationError;
import co.unicauca.dish.infra.Error;
import co.unicauca.dish.infra.DomainErrors;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Servicio de bebidas. Es una fachada de acceso al negocio. Lo usa la capa de
 * presentación.
 *
 * @author Maria Teresa Trujillo
 */
public class DrinkService {

    /**
     * Dependencia de una abstacción No es algo concreto. No se sabe como será
     * implementado
     */
    @Inject
    private IDrinkRepository repository;

    /**
     * Busca una bebida por su Id
     *
     * @param id id de la bebida
     * @return bebida, o null, si no lo encuentra
     */
    public Drink findById(String id) {
        return repository.findById(id);
    }

    /**
     * Hace la inyeccion de dependencias de forma automatica
     *
     * @param repository Guarda la inyeccion de dependecias
     */
    public void setDrinkRepository(IDrinkRepository repository) {
        this.repository = repository;
    }

    /**
     * Busca todos las bebidas en la base de datos
     *
     * @return lista de las bebidas
     */
    public List<Drink> findAll() {
        List<Drink> drinks = repository.findAll();
        return drinks;
    }

    /**
     * Crea una nueva bebida
     *
     * @param newDrink Bebida a guardar en la base de datos
     * @return true si lo crea, false si no
     */
    public boolean create(Drink newDrink) {
        List<Error> errors = validateCreate(newDrink);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        //Si pasa las validaciones se graba en la bd
        return repository.create(newDrink);

    }

    /**
     * Edita o actualiza una bebida
     *
     * @param id identificador de la bebida
     * @param newDrink Bebida a editar en el sistema
     * @return True si puedo actualizar, false de lo contrario
     */
    public boolean update(String id, Drink newDrink) {
        List<Error> errors = validateUpdate(id, newDrink);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        Drink drinkAux = this.findById(id);
        drinkAux.setNameDrink(newDrink.getNameDrink());
        drinkAux.setDrinkPrice(newDrink.getDrinkPrice());
        repository.update(drinkAux);
        return true;
    }

    /**
     * Elimina una bebida de la base de datos
     *
     * @param id identificador de la bebida
     * @return True si puedo eliminar, false de lo contrario
     */
    public boolean delete(String id) {
        //Validate Drink
        List<Error> errors = validateDelete(id);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        // Pasada la validación, se puede borrar de la bd
        return repository.delete(id);
    }

    /**
     * Valida que la bebida esté correcto antes de grabarlo
     *
     * @param newDrink bebida
     * @return lista de errores de negocio
     */
    private List<Error> validateCreate(Drink newDrink) {
        List<Error> errors = new ArrayList<>();
        //Validate MainDish
        if (newDrink.getId_Drink() == null || newDrink.getId_Drink().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Id", "El id de la bebida es obligatorio");
            errors.add(error);
        }
        if (newDrink.getNameDrink() == null || newDrink.getNameDrink().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre de la bebida es obligatorio");
            errors.add(error);
        }
        if (newDrink.getDrinkPrice() == null || newDrink.getDrinkPrice() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio de la bebida es obligatorio");
            errors.add(error);
        }

        //Validar que no exista la bebida
        if (newDrink.getId_Drink() != null) {
            if (Integer.parseInt(newDrink.getId_Drink()) > 0) {
                Drink drinkAux = repository.findById(newDrink.getId_Drink());

                if (drinkAux != null) {
                    // La bebida ya existe
                    Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id de la bebida ya existe");
                    errors.add(error);
                }
            }
        }
        return errors;
    }

    /**
     * Valida que la bebida esté correcta antes de editarlo en la bd
     *
     * @param newDrink bebida
     * @return lista de errores de negocio
     */
    private List<Error> validateUpdate(String id, Drink newDrink) {
        List<Error> errors = new ArrayList<>();
        //Validate Drink

        if (newDrink.getNameDrink() == null || newDrink.getNameDrink().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre de la bebida es obligatorio");
            errors.add(error);
        }
        if (newDrink.getDrinkPrice() == null || newDrink.getDrinkPrice() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio de la bebida es obligatorio");
            errors.add(error);
        }

        // Validar que exista el plato principal
        Drink drinkAux = repository.findById(id);

        if (drinkAux == null) {
            // El plato principal no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id de la bebida no existe");
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
        // Validar que exista la bebida
        Drink drinkAux = repository.findById(id);

        if (drinkAux == null) {
            // La bebida no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id de la bebida no existe");
            errors.add(error);
        }

        return errors;
    }

}
