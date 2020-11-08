package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.client.SaladJerseyClient;
import co.unicauca.common.domain.entity.Salad;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Interfaz donde se declara un CRUD para ensaladas
 *
 * @author Ximena Gallego
 */
public class SaladAccessREST implements ISaladAccess {

    SaladJerseyClient jersey;
    Response rta;

    public SaladAccessREST() {
        this.jersey = new SaladJerseyClient();
    }

    /**
     * Buscar una ensalada consumiendo un API REST mediante un cliente jersey
     *
     * @param id identificador de la ensalada principal
     * @return objeto ensalada
     * @throws Exception error al buscar una ensalada
     */
    @Override
    public Salad findSalad(String id) throws Exception {
        Salad salad = jersey.findById_JSON(Salad.class, id);
        return salad;
    }

    /**
     * Actualiza una ensalada consumiendo un API REST mediante un cliente jersey
     *
     * @param id Identificador de la ensalada
     * @param name Nombre de la ensalada
     * @param price Precio de la ensalada
     * @return objeto ensalada
     * @throws Exception error al actualizar la ensalada
     */
    @Override
    public boolean updateSalad(String id, String name, Double price) throws Exception {
        Salad salad = findSalad(id);
        if (salad == null) {
            return false;
        }
        salad.setCostSalad(price);
        salad.setNameSalad(name);
        rta = jersey.edit_JSON(salad, id);
        return true;
    }

    /**
     * Elimina una ensalada consumiendo un API REST mediante un cliente jersey
     *
     * @param id Identificador de la ensalada
     * @return true si se elimino correctamente la ensalada o false en caso
     * contrario
     * @throws Exception error al actualizar la ensalada
     */
    @Override
    public boolean deleteSalad(String id) throws Exception {
        Salad salad = findSalad(id);
        if (salad == null) {
            return false;
        }
        rta = jersey.delete(id);
        return true;
    }

    /**
     * Crea una ensalada consumiendo un API REST mediante un cliente jersey
     *
     * @param salad ensalada del restaurante
     * @return Devuelve el id de la ensalada
     * @throws Exception error crear la ensalada
     */
    @Override
    public boolean createSalad(Salad salad) throws Exception {
        Salad dish = findSalad(salad.getIdSalad());
        if (dish != null) {
            return false;
        }
        rta = jersey.create_JSON(salad);
        return true;
    }

    /**
     * Lista todos las ensaladas consumiendo un API REST mediante un cliente
     * jersey
     *
     * @return Lista de ensaladas
     * @throws java.lang.Exception
     */
    @Override
    public List<Salad> list() throws Exception {
        GenericType<List<Salad>> listResponseTypeM = new GenericType<List<Salad>>() {
        };
        List<Salad> salads = jersey.findAll(listResponseTypeM);
        return salads;
    }

}
