package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.common.domain.entity.Drink;

/**
 * Interface que define los servicios de persistencia de Drink del restaurante
 *
 * @author Mariat Trujillo
 */
public interface IDrinkAccess {

    /**
     * Buscar una bebida utilizando un socket
     *
     * @param id identificado de la bebida principal
     * @return objeto bebida
     * @throws Exception error al buscar un bebida
     */
    public Drink findDrink(String id) throws Exception;

    /**
     * Elimina una bebida
     *
     * @param id identificador de la bebida principal
     * @return tru si el objeto fue elimido correctamente o false en caso
     * contrario
     * @throws Exception error al Eliminar una bebida
     */
    public boolean deleteDrink(String id) throws Exception;

    /**
     * Crea una bebida
     *
     * @param drink bebida del restaurante
     * @return devuelve el id de la bebida creada
     * @throws Exception error crear el plato
     */
    public boolean createDrink(Drink drink) throws Exception;

    /**
     * Actualiza un plato consumiendo un API REST
     *
     * @param id Identificador de la bebida
     * @param name Nombre de la bebida
     * @param price Precio de la bebida
     * @return objeto bebida
     * @throws Exception error al actualizar la bebida
     */
    public boolean updateDrink(String id, String name, Double price) throws Exception;

    /**
     * Lista todos las bebidas consumiendo un API REST
     *
     * @return Lista de bebidas
     * @throws java.lang.Exception
     */
    public java.util.List<Drink> list() throws Exception;

}
