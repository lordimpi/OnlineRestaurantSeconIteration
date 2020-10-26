//package co.unicauca.onlinerestaurant.client.domain.services;
//
//import co.unicauca.onlinerestaurant.client.access.ISaladAccess;
//import co.unicauca.onlinerestaurant.client.access.SaladAccessImplSockets;
//import co.unicauca.onlinerestaurant.commons.domain.Salad;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Mariat Trujillo
// */
//public class SaladServiceTest {
//
//    public SaladServiceTest() {
//    }
//
//    /**
//     * Test of findSalad method, of class SaladService.
//     */
//    @Test
//    public void testFindSalad() throws Exception {
//        System.out.println("findSalad");
//        String id = "1";
//
//        ISaladAccess res = new SaladAccessImplSockets();
//        SaladService instance = new SaladService(res);
//        Salad expResult = new Salad();
//
//        expResult.setNameDishSalad("ensalada cesar");
//        expResult.setIdhSalad("1");
//        expResult.setCostSalad(1000);
//
//        Salad result = instance.findSalad(id);
//        assertEquals(expResult.getNameSalad(), result.getNameSalad());
//        assertEquals(expResult.getIdSalad(), result.getIdSalad());
//    }
//
//}
