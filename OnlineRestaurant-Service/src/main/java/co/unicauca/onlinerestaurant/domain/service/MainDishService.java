package co.unicauca.onlinerestaurant.domain.service;

import co.unicauca.common.domain.entity.MainDish;
import javax.inject.Inject;
import co.unicauca.onlinerestaurant.access.IMainDishRepository;
import co.unicauca.onlinerestaurant.domain.validators.ValidationError;
import co.unicauca.onlinerestaurant.infra.Error;
import co.unicauca.onlinerestaurant.infra.DomainErrors;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de productos. Es una fachada de acceso al negocio. Lo usa la capa de
 * presentación. * @author Santiago Acuña
 *
 */
public class MainDishService {

    /**
     * Dependencia de una abstacción No es algo concreto. No se sabe como será
     * implementado
     */
    @Inject
    private IMainDishRepository repository;

    /**
     * Busca un producto por su Id
     *
     * @param id id del producto
     * @return producto, o null, si no lo encuentra
     */
    public MainDish findById(String id) {
        return repository.findById(id);
    }

    public void setMainDishRepository(IMainDishRepository repository) {
        this.repository = repository;
    }

    /**
     * Busca todos los productos
     *
     * @return lista de productos
     */
    public List<MainDish> findAll() {
        List<MainDish> mainDishes = repository.findAll();
        return mainDishes;
    }

    /**
     * Crea un nuevo producto
     *
     * @param newMainDish Producto a guardar en la base de datos
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
     * Edita o actualiza un producto
     *
     * @param id identificador del producto
     * @param newMainDish producto a editar en el sistema
     * @return
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
     * Elimina un producto de la base de datos
     *
     * @param id identificador del producto
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
        return repository.delete(id);
    }

    /**
     * Valida que el producto esté correcto antes de grabarlo
     *
     * @param newProduct prodcuto
     * @return lista de errores de negocio
     */
    private List<Error> validateCreate(MainDish newMainDish) {
        List<Error> errors = new ArrayList<>();
        //Validate product
        if (newMainDish.getId_mainDish() == null || newMainDish.getId_mainDish().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Id", "El id del plato principal es obligatorio");
            errors.add(error);
        }
        if (newMainDish.getNameDish() == null || newMainDish.getNameDish().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre del producto es obligatorio");
            errors.add(error);
        }
        if (newMainDish.getDishPrice() == null || newMainDish.getDishPrice() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio del producto es obligatorio");
            errors.add(error);
        }

        //Validar que no exista el producto
        if (newMainDish.getId_mainDish() != null) {
            if (Integer.parseInt(newMainDish.getId_mainDish()) > 0) {
                MainDish mainDishAux = repository.findById(newMainDish.getId_mainDish());

                if (mainDishAux != null) {
                    // El producto ya existe
                    Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del plato principal ya existe");
                    errors.add(error);
                }
            }
        }
        return errors;
    }

    /**
     * Valida que el producto esté correcto antes de editarlo en la bd
     *
     * @param newProduct prodcuto
     * @return lista de errores de negocio
     */
    private List<Error> validateUpdate(String id, MainDish newMainDish) {
        List<Error> errors = new ArrayList<>();
        //Validate product

        if (newMainDish.getNameDish()== null || newMainDish.getNameDish().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre del plato principal es obligatorio");
            errors.add(error);
        }
        if (newMainDish.getDishPrice() == null || newMainDish.getDishPrice() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio del plato principal es obligatorio");
            errors.add(error);
        }

        // Validar que exista el producto
        MainDish mainDishAux = repository.findById(id);

        if (mainDishAux == null) {
            // El producto no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del plato principal no existe");
            errors.add(error);
        }

        return errors;
    }

    private List<Error> validateDelete(String id) {
        List<Error> errors = new ArrayList<>();
        // Validar que exista el producto
        MainDish mainDishAux = repository.findById(id);

        if (mainDishAux == null) {
            // El producto no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del plato principal no existe");
            errors.add(error);
        }

        return errors;
    }
}
