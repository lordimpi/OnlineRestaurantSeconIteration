//package co.unicauca.onlinerestaurant.client.domain.services;
//
//import co.unicauca.onlinerestaurant.client.access.DessertAccessImplSockets;
//import co.unicauca.onlinerestaurant.client.access.IDessertAccess;
//import co.unicauca.onlinerestaurant.commons.domain.Dessert;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Mariat Trujillo
// */
//public class DessertServiceTest {
//
//    /**
//     * Test of findDessert method, of class DessertService.
//     */
//    @Test
//    public void testFindDessert() throws Exception {
//        System.out.println("findDessert");
//        String id = "1";
//        IDessertAccess instance = new DessertAccessImplSockets();
//        Dessert expResult = new Dessert();
//
//        expResult.setName_Dish_Dessert("fresas");
//        expResult.setId_Dish_Dessert("1");
//        expResult.setCost_Dish_Dessert(2000);
//
//        Dessert result = instance.findDessert(id);
//
//        assertEquals(expResult.getId_Dish_Dessert(), result.getId_Dish_Dessert());
//        assertEquals(expResult.getName_Dish_Dessert(), result.getName_Dish_Dessert());
//        assertEquals(expResult.getCost_Dish_Dessert(), result.getCost_Dish_Dessert());
//
//    }
//}