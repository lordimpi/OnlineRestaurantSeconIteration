package co.unicauca.onlinerestaurant.domain.service;

import co.unicauca.onlinerestaurant.access.IProductRepository;
import co.unicauca.common.domain.entity.Product;
import co.unicauca.onlinerestaurant.domain.validators.ValidationError;
import co.unicauca.onlinerestaurant.infra.Error;
import co.unicauca.onlinerestaurant.infra.DomainErrors;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 * Servicio de productos. Es una fachada de acceso al negocio. Lo usa la capa de
 * presentación.
 *
 * @author Santiago Acuña
 */
@RequestScoped
public class ProductService {

    /**
     * Dependencia de una abstacción No es algo concreto. No se sabe como será
     * implementado
     */
    @Inject
    private IProductRepository repository;

    /**
     * Busca un producto por su Id
     *
     * @param id id del producto
     * @return producto, o null, si no lo encuentra
     */
    public Product findById(int id) {
        return repository.findById(id);
    }
    
    public void setProductRepository(IProductRepository repository){
        this.repository = repository;
    }

    /**
     * Busca todos los productos
     *
     * @return lista de productos
     */
    public List<Product> findAll() {
        List<Product> products = repository.findAll();
        return products;
    }

    /**
     * Una lógica de negocio cualquiera
     *
     * @param product Producto
     * @return impuesto
     */
    public double calculateProductTax(Product product) {

        //Validate product.
        if (product == null) {
            return 0;
        }
        double TAX = 0.19d;
        double productTax = product.getPrice() * TAX;
        return productTax;
    }

    /**
     * Crea un nuevo producto
     *
     * @param newProduct Producto a guardar en la base de datos
     * @return true si lo crea, false si no
     */
    public boolean create(Product newProduct) {
        List<Error> errors = validateCreate(newProduct);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        //Si pasa las validaciones se graba en la bd
        return repository.create(newProduct);

    }

    /**
     * Edita o actualiza un producto
     *
     * @param id identificador del producto
     * @param newProduct producto a editar en el sistema
     * @return
     */
    public boolean update(Integer id, Product newProduct) {
        List<Error> errors = validateUpdate(id, newProduct);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        Product productAux = this.findById(id);
        productAux.setName(newProduct.getName());
        productAux.setPrice(newProduct.getPrice());
        repository.update(productAux);
        return true;
    }

    /**
     * Elimina un producto de la base de datos
     *
     * @param id identificador del producto
     * @return
     */
    public boolean delete(Integer id) {
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
    private List<Error> validateCreate(Product newProduct) {
        List<Error> errors = new ArrayList<>();
        //Validate product
        if (newProduct.getId() == null || newProduct.getId() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Id", "El id del producto es obligatorio");
            errors.add(error);
        }
        if (newProduct.getName() == null || newProduct.getName().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre del producto es obligatorio");
            errors.add(error);
        }
        if (newProduct.getPrice() == null || newProduct.getPrice() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio del producto es obligatorio");
            errors.add(error);
        }

        //Validar que no exista el producto
        if (newProduct.getId() != null) {
            if (newProduct.getId() > 0) {
                Product productAux = repository.findById(newProduct.getId());

                if (productAux != null) {
                    // El producto ya existe
                    Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del producto ya existe");
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
    private List<Error> validateUpdate(Integer id, Product newProduct) {
        List<Error> errors = new ArrayList<>();
        //Validate product

        if (newProduct.getName() == null || newProduct.getName().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Nombre", "El nombre del producto es obligatorio");
            errors.add(error);
        }
        if (newProduct.getPrice() == null || newProduct.getPrice() <= 0) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Precio", "El precio del producto es obligatorio");
            errors.add(error);
        }

        // Validar que exista el producto
        Product productAux = repository.findById(id);

        if (productAux == null) {
            // El producto no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del producto no existe");
            errors.add(error);
        }

        return errors;
    }

    private List<Error> validateDelete(Integer id) {
        List<Error> errors = new ArrayList<>();
        // Validar que exista el producto
        Product productAux = repository.findById(id);

        if (productAux == null) {
            // El producto no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del producto no existe");
            errors.add(error);
        }

        return errors;
    }

}
