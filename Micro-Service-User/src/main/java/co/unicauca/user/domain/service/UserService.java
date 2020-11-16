package co.unicauca.user.domain.service;

import co.unicauca.common.domain.entity.User;
import javax.inject.Inject;
import co.unicauca.user.access.IUserRepository;
import co.unicauca.common.domain.validators.ValidationError;
import co.unicauca.common.infra.Error;
import co.unicauca.common.infra.DomainErrors;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de usuario. Es una fachada de acceso al negocio. Lo usa la capa de
 * presentación.
 *
 * @author Camilo Otaya
 */
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

    /**
     * Busca un usuario por su Email
     *
     * @param email email del usuario
     * @return usuario, o null, si no lo encuentra
     */
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    /**
     * Hace la inyeccion de dependencias de forma automatica
     *
     * @param repository Guarda la inyeccion de dependecias
     */
    public void setUserRepository(IUserRepository repository) {
        this.repository = repository;
    }

    /**
     * Busca todos los usuarios en la base de datos
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
     * @param newUser usuario a guardar en la base de datos
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
     * @return True si puedo actualizar, false de lo contrario
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
     * Elimina un usuario de la base de datos
     *
     * @param id identificador del usuario
     * @return True si pudo eliminar, false de lo contrario
     */
    public boolean delete(String id) {
        //Validate User
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
     * @return lista de errores de negocio
     */
    private List<Error> validateCreate(User newUser) {
        List<Error> errors = new ArrayList<>();
        //Validate User
        if (newUser.getId() == null || newUser.getId().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Id", "El id del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getFirstName() == null || newUser.getFirstName().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getLastName() == null || newUser.getLastName().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Apellido", "El apellido del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getAddress() == null || newUser.getAddress().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Dirección", "La dirección del usuario es obligatoria");
            errors.add(error);
        }
        if (newUser.getMobile() == null || newUser.getMobile().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Telefono", "El telefono del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getEmail() == null || newUser.getEmail().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Email", "El email del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getRol() == null || newUser.getRol().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Rol", "El rol del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getPws() == null || newUser.getPws().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Contraseña", "La contraseña del usuario es obligatoria");
            errors.add(error);
        }

        //Validar que no exista el usuario
        if (newUser.getId() != null) {
            if (Integer.parseInt(newUser.getId()) > 0) {
                User userAux = repository.findById(newUser.getId());

                if (userAux != null) {
                    // El plato usuario ya existe
                    Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del usuario ya existe");
                    errors.add(error);
                }
            }
        }
        return errors;
    }

    /**
     * Valida que el usuario esté correcto antes de editarlo en la bd
     *
     * @param newUser usuario
     * @return lista de errores de negocio
     */
    private List<Error> validateUpdate(String id, User newUser) {
        List<Error> errors = new ArrayList<>();
        //Validate User

        if (newUser.getFirstName() == null || newUser.getFirstName().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getLastName() == null || newUser.getLastName().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Apellido", "El apellido del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getAddress() == null || newUser.getAddress().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Dirección", "La dirección del usuario es obligatoria");
            errors.add(error);
        }
        if (newUser.getMobile() == null || newUser.getMobile().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Telefono", "El telefono del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getEmail() == null || newUser.getEmail().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "email", "El email del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getRol() == null || newUser.getRol().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Rol", "El rol del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getPws() == null || newUser.getPws().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "contraseña", "La contraseña del usuario es obligatoria");
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

    /**
     * Valida que el usuario exista antes de eliminarlo de la base de datos
     *
     * @param id Identificador a validar
     * @return Lista de errores de negocio
     */
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