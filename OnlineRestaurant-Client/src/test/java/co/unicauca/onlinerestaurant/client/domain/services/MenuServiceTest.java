//package co.unicauca.onlinerestaurant.client.domain.services;
//
//import co.unicauca.onlinerestaurant.client.access.IMenuAccess;
//import co.unicauca.onlinerestaurant.client.access.MenuAccessImplSockets;
//import co.unicauca.onlinerestaurant.commons.domain.Menu;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Mariat Trujillo
// */
//public class MenuServiceTest {
//
//    public MenuServiceTest() {
//    }
//
//    /**
//     * Test of findMenu method, of class MenuService.
//     */
//    @Test
//    public void testFindMenu() throws Exception {
//        System.out.println("findMenu");
//        String id = "1";
//        IMenuAccess instance = new MenuAccessImplSockets();
//        Menu expResult = new Menu();
//
//        expResult.setId_menu("1");
//
//        Menu result = instance.findMenu(id);
//        assertEquals(expResult.getId_menu(), result.getId_menu());
//    }
//
//    /**
//     * Test of findbyMenubyRN method, of class MenuService.
//     */
//    @Test
//    public void testFindbyMenubyRN() throws Exception {
//        System.out.println("findbyMenubyRN");
//        String name = "mister pollo";
//        IMenuAccess instance = new MenuAccessImplSockets();
//        Menu expResult = new Menu();
//
//        expResult.setId_menu("1");
//        Menu result = instance.findMenubyRN(name);
//        assertEquals(expResult.getId_menu(), result.getId_menu());
//    }
//
//    /**
//     * Test of updateMenu method, of class MenuService.
//     */
//    @Test
//    public void testUpdateMenu() throws Exception {
//        System.out.println("updateMenu");
//        String id = "1";
//        String id_dish = "2";
//        String id_drink = "3";
//        String id_entry = "4";
//        String id_salad = "5";
//        String id_dessert = "6";
//        IMenuAccess instance = new MenuAccessImplSockets();
//        boolean expResult = true;
//        boolean result = instance.updateMenu(id, id_dish, id_drink, id_entry, id_salad, id_dessert);
//        assertEquals(expResult, result);
//    }
//
////    /**
////     * Test of deleteMenu method, of class MenuService.
////     */
////    @Test
////    public void testDeleteMenu() throws Exception {
////        System.out.println("deleteMenu");
////        String id = "8";
////        IMenuAccess instance = new MenuAccessImplSockets();
////        boolean expResult = false;
////        boolean result = instance.deleteMenu(id);
////        assertEquals(expResult, result);
////    }
//}
