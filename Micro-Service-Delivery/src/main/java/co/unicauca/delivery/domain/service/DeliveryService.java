package co.unicauca.delivery.domain.service;

import co.unicauca.common.domain.entity.Delivery;
import co.unicauca.common.domain.validators.ValidationError;
import co.unicauca.common.infra.Error;
import co.unicauca.common.infra.DomainErrors;
import co.unicauca.delivery.access.IDeliveryRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Servicio de Pedidos. Es una fachada de acceso al negocio. Lo usa la capa de
 * presentación. * @author Santiago Acuña
 */
public class DeliveryService {

    /**
     * Dependencia de una abstacción No es algo concreto. No se sabe como será
     * implementado
     */
    @Inject
    private IDeliveryRepository repository;

    /**
     * Busca un pedido por su Id
     *
     * @param id id del pedido
     * @return el pedido, o null, si no lo encuentra
     */
    public Delivery findById(String id) {
        return repository.findById(id);
    }

    /**
     * Hace la inyeccion de dependencias de forma automatica
     *
     * @param repository Guarda la inyeccion de dependecias
     */
    public void setDeliveryRepository(IDeliveryRepository repository) {
        this.repository = repository;
    }

    /**
     * Busca todos los pedidos en la base de datos
     *
     * @return lista de pedidos
     */
    public List<Delivery> findAll() {
        List<Delivery> deliveries = repository.findAll();
        return deliveries;
    }

    /**
     * Crea un nuevo pedido
     *
     * @param newDelivery Pedido a guardar en la base de datos
     * @return true si lo crea, false si no
     */
    public boolean create(Delivery newDelivery) {
        List<Error> errors = validateCreate(newDelivery);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        //Si pasa las validaciones se graba en la bd
        return repository.create(newDelivery);

    }

    /**
     * Edita o actualiza un pedido
     *
     * @param id identificador del pedido
     * @param newDelivery Pedido a editar en el sistema
     * @return True si puedo actualizar, false de lo contrario
     */
    public boolean update(String id, Delivery newDelivery) {
        List<Error> errors = validateUpdate(id, newDelivery);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        Delivery deliveryAux = this.findById(id);
        deliveryAux.setDescripcion(newDelivery.getDescripcion());
        deliveryAux.setCantidad(newDelivery.getCantidad());
        deliveryAux.setDireccionEnvio(newDelivery.getDireccionEnvio());
        deliveryAux.getMiMenu().setId_menu(newDelivery.getMiMenu().getId_menu());
        repository.update(deliveryAux);
        return true;
    }

    /**
     * Elimina un pedido de la base de datos
     *
     * @param id identificador del pedido
     * @return True si puedo eliminar, false de lo contrario
     */
    public boolean delete(String id) {
        //Validate Pedido
        List<Error> errors = validateDelete(id);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        // Pasada la validación, se puede borrar de la bd
        return repository.delete(id);
    }

    /**
     * Valida que el pedido esté correcto antes de grabarlo
     *
     * @param newDelivery Pedido
     * @return lista de errores de negocio
     */
    private List<Error> validateCreate(Delivery newDelivery) {
        List<Error> errors = new ArrayList<>();
        //Validate MainDish
        if (newDelivery.getCantidad() == null || newDelivery.getCantidad() < 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Cantidad", "La cantidad es obligatoria");
            errors.add(error);
        }
        if (newDelivery.getDireccionEnvio() == null || newDelivery.getDireccionEnvio().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Direccion", "El campo direccion es obligatorio");
            errors.add(error);
        }
        if (newDelivery.getMiMenu().getId_menu() == null || newDelivery.getMiMenu().getId_menu().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Id_menu", "El id del menu es obligatorio");
            errors.add(error);
        }

        //Validar que no exista el pedido
        if (newDelivery.getId_Delivery() != null) {
            if (Integer.parseInt(newDelivery.getId_Delivery()) > 0) {
                Delivery deliveryAux = repository.findById(newDelivery.getId_Delivery());

                if (deliveryAux != null) {
                    // El pedido ya existe
                    Error error = new Error(ValidationError.INVALID_FIELD, "Id", "El id del peido ya existe");
                    errors.add(error);
                }
            }
        }
        return errors;
    }

    /**
     * Valida que el pedido esté correcto antes de editarlo en la bd
     *
     * @param newDelivery Pedido
     * @return lista de errores de negocio
     */
    private List<Error> validateUpdate(String id, Delivery newDelivery) {
        List<Error> errors = new ArrayList<>();
        //Validate MainDish

        if (newDelivery.getCantidad() == null || newDelivery.getCantidad() < 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Cantidad", "La cantidad es obligatoria");
            errors.add(error);
        }
        if (newDelivery.getDireccionEnvio() == null || newDelivery.getDireccionEnvio().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Direccion", "El campo direccion es obligatorio");
            errors.add(error);
        }
        if (newDelivery.getMiMenu().getId_menu() == null || newDelivery.getMiMenu().getId_menu().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Id_menu", "El id del menu es obligatorio");
            errors.add(error);
        }

        // Validar que exista el pedido
        Delivery deliveryAux = repository.findById(id);

        if (deliveryAux == null) {
            // El plato principal no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "Id", "El id del pedido no existe");
            errors.add(error);
        }

        return errors;
    }

    /**
     * Valida que el pedido exista antes de eliminarlo de la base de datos
     *
     * @param id Identificador a validar
     * @return Lista de errores de negocio
     */
    private List<Error> validateDelete(String id) {
        List<Error> errors = new ArrayList<>();
        // Validar que exista el pedido
        Delivery deliveryAux = repository.findById(id);

        if (deliveryAux == null) {
            // El pedido no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "Id", "El id del pedido no existe");
            errors.add(error);
        }

        return errors;
    }
}
