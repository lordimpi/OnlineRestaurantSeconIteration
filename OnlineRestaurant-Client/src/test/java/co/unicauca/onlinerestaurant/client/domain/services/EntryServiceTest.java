//package co.unicauca.onlinerestaurant.client.domain.services;
//
//import co.unicauca.onlinerestaurant.client.access.EntryAccessImplSocket;
//import co.unicauca.onlinerestaurant.client.access.IEntryAccess;
//import co.unicauca.onlinerestaurant.commons.domain.DishEntry;
//
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Mariat Trujillo
// */
//public class EntryServiceTest {
//
//    public EntryServiceTest() {
//    }
//
//    /**
//     * Test of findEntry method, of class EntryService.
//     */
//    @Test
//    public void testFindEntry() throws Exception {
//        System.out.println("findEntry");
//        String id = "3";
//        IEntryAccess instance = new EntryAccessImplSocket();
//        DishEntry expResult = new DishEntry();
//        DishEntry result = instance.findEntry(id);
//
//        expResult.setCostDishEntry(2000);
//        expResult.setNameDishEntry("pan");
//        expResult.setIdDishEntry("3");
//
//        assertEquals(expResult.getNameDishEntry(), result.getNameDishEntry());
//        assertEquals(expResult.getIdDishEntry(), result.getIdDishEntry());
//        assertEquals(Double.toString(expResult.getCostDishEntry()), Double.toString(result.getCostDishEntry()));
//
//    }
//
//}
