//package co.unicauca.onlinerestaurant.client.domain.services;
//
//import co.unicauca.onlinerestaurant.client.access.DrinkAccessImplSockets;
//import co.unicauca.onlinerestaurant.client.access.IDrinkAccess;
//import co.unicauca.onlinerestaurant.commons.domain.Drink;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Mariat Trujillo
// */
//public class DrinkServiceTest {
//
//    /**
//     * Test of findDrink method, of class DrinkService.
//     */
//    @Test
//    public void testFindDrink() throws Exception {
//        System.out.println("findDrink");
//        String id = "1";
//
//        IDrinkAccess instance = new DrinkAccessImplSockets();
//
//        Drink expResult = new Drink();
//        Drink result = instance.findDrink(id);
//
//        expResult.setNameDrink("cerveza poker");
//        expResult.setId_Drink("1");
//        expResult.setDrinkPrice(2500);
//
//        assertEquals(expResult.getId_Drink(), result.getId_Drink());
//        assertEquals(Double.toString(expResult.getDrinkPrice()), Double.toString(result.getDrinkPrice()));
//        assertEquals(expResult.getNameDrink(), result.getNameDrink());
//    }
//
//}
