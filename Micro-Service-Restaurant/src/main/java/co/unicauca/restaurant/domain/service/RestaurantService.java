package co.unicauca.restaurant.domain.service;

import co.unicauca.common.domain.entity.User;
import javax.inject.Inject;
import co.unicauca.common.domain.validators.ValidationError;
import co.unicauca.common.infra.Error;
import co.unicauca.common.infra.DomainErrors;
import co.unicauca.common.domain.entity.Restaurant;
import co.unicauca.restaurant.access.IRestaurantRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Servicio de Restaurantes. Es una fachada de acceso al negocio. Lo usa la capa
 * de presentación.
 *
 * @author Camilo Otaya
 */
public class RestaurantService {

    /**
     * Dependencia de una abstacción No es algo concreto. No se sabe como será
     * implementado
     */
    @Inject
    private IRestaurantRepository repository;

    /**
     * Busca un restaurante por su Id
     *
     * @param id id del restaurante
     * @return restaurante, o null, si no lo encuentra
     */
    public Restaurant findById(String id) {
        return repository.findById(id);
    }

    public void setUserRepository(IRestaurantRepository repository) {
        this.repository = repository;
    }

    /**
     * Busca todos los restaurantes
     *
     * @return lista de restaurantes
     */
    public List<Restaurant> findAll() {
        List<Restaurant> restaurants = repository.findAll();
        return restaurants;
    }

    /**
     * Crea un nuevo restaurante
     *
     * @param newRestaurant restaurante a guardar en la base de datos
     * @return true si lo crea, false si no
     */
    public boolean create(Restaurant newRestaurant) {
        List<Error> errors = validateCreate(newRestaurant);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        //Si pasa las validaciones se graba en la bd
        return repository.create(newRestaurant);

    }

    /**
     * Edita o actualiza un restaurante
     *
     * @param id identificador del restaurante
     * @param newRestaurant restaurante a editar en el sistema
     * @return
     */
    public boolean update(String id, Restaurant newRestaurant) {
        List<Error> errors = validateUpdate(id, newRestaurant);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        Restaurant restaurantAux = this.findById(id);
        restaurantAux.setNameRestaurant(newRestaurant.getNameRestaurant());
        restaurantAux.setAddressRestaurant(newRestaurant.getAddressRestaurant());
        restaurantAux.setPhone(newRestaurant.getPhone());
        repository.update(restaurantAux);
        return true;
    }

    /**
     * Elimina un restaurante de la base de datos
     *
     * @param id identificador del restaurante
     * @return
     */
    public boolean delete(String id) {
        //Validate restaurant
        List<Error> errors = validateDelete(id);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        // Pasada la validación, se puede borrar de la bd
        return repository.delete(id);
    }

    /**
     * Valida que el restaurante esté correcto antes de grabarlo
     *
     * @param newRestaurant restaurante
     * @return lista de errores
     */
    private List<Error> validateCreate(Restaurant newRestaurant) {
        List<Error> errors = new ArrayList<>();
        //Validate user
        if (newRestaurant.getIdRestaurant() == null || newRestaurant.getIdRestaurant().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Id", "El id del usuario es obligatorio");
            errors.add(error);
        }
        if (newRestaurant.getNameRestaurant() == null || newRestaurant.getNameRestaurant().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El  nombre del restaurante es obligatorio");
            errors.add(error);
        }
        if (newRestaurant.getAddressRestaurant() == null || newRestaurant.getAddressRestaurant().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Direccion", "El precio del restaurante es obligatorio");
            errors.add(error);
        }
        if (newRestaurant.getPhone() == null || newRestaurant.getPhone().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Telefono", "El telefono del restaurante es obligatorio");
            errors.add(error);
        }

        //Validar que no exista el restaurante
        if (newRestaurant.getIdRestaurant() != null) {
            Restaurant restaurantAux = repository.findById(newRestaurant.getIdRestaurant());
            if (restaurantAux != null) {
                // El restaurante ya existe
                Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del restaurante ya existe");
                errors.add(error);
            }

        }

        return errors;
    }

    /**
     * Valida que el restaurante esté correcto antes de editarlo en la bd
     *
     * @param newRestaurant restaurante
     * @return lista de errores
     */
    private List<Error> validateUpdate(String id, Restaurant newRestaurant) {
        List<Error> errors = new ArrayList<>();
        //Validate restaurant
        if (newRestaurant.getNameRestaurant() == null || newRestaurant.getNameRestaurant().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre del restaurante es obligatorio");
            errors.add(error);
        }
        if (newRestaurant.getAddressRestaurant() == null || newRestaurant.getAddressRestaurant().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "direccion", "La direccion del restaurante es obligatorio");
            errors.add(error);
        }
        if (newRestaurant.getPhone() == null || newRestaurant.getPhone().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "telefono", "El telefono del restaurante es obligatorio");
            errors.add(error);
        }

        // Validar que exista el restaurante
        Restaurant restaurantAux = repository.findById(id);

        if (restaurantAux == null) {
            // El usuario no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del restaurante no existe");
            errors.add(error);
        }

        return errors;
    }

    private List<Error> validateDelete(String id) {
        List<Error> errors = new ArrayList<>();
        // Validar que exista el restaurante
        Restaurant restaurantAux = repository.findById(id);

        if (restaurantAux == null) {
            // El restaurante no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del restaurante no existe");
            errors.add(error);
        }

        return errors;
    }
}
