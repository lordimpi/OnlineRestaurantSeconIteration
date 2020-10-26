//package co.unicauca.onlinerestaurant.client.domain.services;
//
//import co.unicauca.onlinerestaurant.client.access.IRestaurantAccess;
//import co.unicauca.onlinerestaurant.client.access.RestaurantAccessImplSockets;
//import co.unicauca.onlinerestaurant.commons.domain.Restaurant;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Mariat Trujillo
// *
// */
//public class RestaurantServiceTest {
//
//    public RestaurantServiceTest() {
//    }
//
//    /**
//     * Test of listRestaurants method, of class RestaurantService.
//     */
//    @Test
//    public void testListRestaurants() throws Exception {
//        System.out.println("listRestaurants");
//        IRestaurantAccess res = new RestaurantAccessImplSockets();
//        RestaurantService instance = new RestaurantService(res);
//
//        List<Restaurant> Restaurants = new ArrayList<>();
//        List<Restaurant> Resperado = new ArrayList<>();
//        Restaurants.add(new Restaurant("1", "mister pollo", "calle 50", "312333222", "1"));
//        Restaurants.add(new Restaurant("7", "Andres carne de res", "carrera 12 con calle 10", "312333222", "7"));
//        Resperado = instance.listRestaurants();
//
//        assertEquals(Resperado.get(0).getIdRestaurant(), Restaurants.get(0).getIdRestaurant());
//        assertEquals(Resperado.get(0).getNameRestaurant(), Restaurants.get(0).getNameRestaurant());
//        assertEquals(Resperado.get(0).getAddressRestaurant(), Restaurants.get(0).getAddressRestaurant());
//        assertEquals(Resperado.get(0).getPhone(), Restaurants.get(0).getPhone());
//        assertEquals(Resperado.get(0).getIdmenu(), Restaurants.get(0).getIdmenu());
//
//        assertEquals(Resperado.get(Resperado.size() - 1).getIdRestaurant(), Restaurants.get(Restaurants.size() - 1).getIdRestaurant());
//        assertEquals(Resperado.get(Resperado.size() - 1).getNameRestaurant(), Restaurants.get(Restaurants.size() - 1).getNameRestaurant());
//        assertEquals(Resperado.get(Resperado.size() - 1).getAddressRestaurant(), Restaurants.get(Restaurants.size() - 1).getAddressRestaurant());
//        assertEquals(Resperado.get(Resperado.size() - 1).getPhone(), Restaurants.get(Restaurants.size() - 1).getPhone());
//        assertEquals(Resperado.get(Resperado.size() - 1).getIdmenu(), Restaurants.get(Restaurants.size() - 1).getIdmenu());
//
//    }
//
//}
