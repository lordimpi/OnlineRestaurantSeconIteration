package co.unicauca.onlinerestaurant.domain.service;

import co.unicauca.common.domain.entity.User;
import co.unicauca.onlinerestaurant.access.IUserRepository;
import co.unicauca.onlinerestaurant.domain.validators.ValidationError;
import co.unicauca.onlinerestaurant.infra.Error;
import co.unicauca.onlinerestaurant.infra.DomainErrors;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Servicio de Usuarios. Es una fachada de acceso al negocio. Lo usa la capa de
 * presentación.
 *
 * @author Camilo Otaya
 */
@RequestScoped
public class UserService {

    /**
     * Dependencia de una abstacción No es algo concreto. No se sabe como será
     * implementado
     */
    @Inject
    private IUserRepository repository;

    /**
     * Busca un usuario por su Id
     *
     * @param id id del usuario
     * @return usuario, o null, si no lo encuentra
     */
    public User findById(String id) {
        return repository.findById(id);
    }

    public void setUserRepository(IUserRepository repository) {
        this.repository = repository;
    }

    /**
     * Busca todos los usuarios
     *
     * @return lista de usuarios
     */
    public List<User> findAll() {
        List<User> users = repository.findAll();
        return users;
    }

    /**
     * Crea un nuevo usuario
     *
     * @param newUser Usuario a guardar en la base de datos
     * @return true si lo crea, false si no
     */
    public boolean create(User newUser) {
        List<Error> errors = validateCreate(newUser);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        //Si pasa las validaciones se graba en la bd
        return repository.create(newUser);

    }

    /**
     * Edita o actualiza un usuario
     *
     * @param id identificador del usuario
     * @param newUser usuario a editar en el sistema
     * @return
     */
    public boolean update(String id, User newUser) {
        List<Error> errors = validateUpdate(id, newUser);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        User userAux = this.findById(id);
        userAux.setFirstName(newUser.getFirstName());
        userAux.setLastName(newUser.getLastName());
        userAux.setAddress(newUser.getAddress());
        userAux.setMobile(newUser.getMobile());
        userAux.setEmail(newUser.getEmail());
        userAux.setRol(newUser.getRol());
        userAux.setPws(newUser.getPws());

        repository.update(userAux);
        return true;
    }

    /**
     * Elimina un Usuario de la base de datos
     *
     * @param id identificador del usuario
     * @return
     */
    public boolean delete(String id) {
        //Validate user
        List<Error> errors = validateDelete(id);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        // Pasada la validación, se puede borrar de la bd
        return repository.delete(id);
    }

    /**
     * Valida que el usuario esté correcto antes de grabarlo
     *
     * @param newUser usuario
     * @return lista de errores
     */
    private List<Error> validateCreate(User newUser) {
        List<Error> errors = new ArrayList<>();
        //Validate user
        if (newUser.getId() == null || newUser.getId().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "id_user", "El id del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getFirstName() == null || newUser.getFirstName().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "First_Name", "El primer nombre del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getLastName() == null || newUser.getLastName().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Last_Name", "El apellido del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getAddress() == null || newUser.getAddress().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Address", "La dirección del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getMobile() == null || newUser.getMobile().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Mobile", "El número de telefono del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getEmail() == null || newUser.getEmail().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "email", "El email del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getRol() == null || newUser.getRol().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "rol", "El rol del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getPws() == null || newUser.getPws().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Contraseña", "La contraseña del usuario es obligatoria");
            errors.add(error);
        }

        //Validar que no exista el usuario
        if (newUser.getId() != null) {

            User userAux = repository.findById(newUser.getId());

            if (userAux != null) {
                // El usuario ya existe
                Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del usuario ya existe");
                errors.add(error);
            }
        }

        return errors;
    }

    /**
     * Valida que el usuario esté correcto antes de editarlo en la bd
     *
     * @param newUser usuario
     * @return lista de errores
     */
    private List<Error> validateUpdate(String id, User newUser) {
        List<Error> errors = new ArrayList<>();
        //Validate user
        if (newUser.getFirstName() == null || newUser.getFirstName().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Primer Nombre", "El primer nombre del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getLastName() == null || newUser.getLastName().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Apellido", "El apellido del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getAddress() == null || newUser.getAddress().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Dirección", "La dirección del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getMobile() == null || newUser.getMobile().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "telefono", "El número de telefono del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getEmail() == null || newUser.getEmail().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "email", "El email del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getRol() == null || newUser.getRol().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "rol", "El rol del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getPws() == null || newUser.getPws().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Contraseña", "La contraseña del usuario es obligatoria");
            errors.add(error);
        }

        // Validar que exista el usuario
        User userAux = repository.findById(id);

        if (userAux == null) {
            // El usuario no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del usuario no existe");
            errors.add(error);
        }

        return errors;
    }

    private List<Error> validateDelete(String id) {
        List<Error> errors = new ArrayList<>();
        // Validar que exista el usuario
        User userAux = repository.findById(id);

        if (userAux == null) {
            // El usuario no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del usuario no existe");
            errors.add(error);
        }

        return errors;
    }

}
