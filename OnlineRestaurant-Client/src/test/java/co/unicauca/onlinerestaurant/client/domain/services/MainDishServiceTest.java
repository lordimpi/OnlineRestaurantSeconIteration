//package co.unicauca.onlinerestaurant.client.domain.services;
//
//import co.unicauca.onlinerestaurant.client.access.IMainDishAccess;
//import co.unicauca.onlinerestaurant.client.access.MainDishAccessImplSockets;
//import co.unicauca.onlinerestaurant.commons.domain.MainDish;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Mariat Trujillo
// */
//public class MainDishServiceTest {
//
//    public MainDishServiceTest() {
//    }
//
//    /**
//     * Test of createMainDish method, of class MainDishService.
//     */
//    @Test
//    public void testCreateMainDish() throws Exception {
//        System.out.println("createMainDish");
//        MainDish mainDish = new MainDish();
//
//        mainDish.setId_mainDishe("10");
//        mainDish.setDishPrice(2000);
//        mainDish.setNameDishe("pruebas");
//
//        IMainDishAccess instance = new MainDishAccessImplSockets();
//
//        boolean expResult = true;
//        boolean result = instance.createMainDish(mainDish);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of findMainDish method, of class MainDishService.
//     */
//    @Test
//    public void testFindMainDish() throws Exception {
//        System.out.println("findMainDish");
//        String id = "1";
//
//        MainDish exp = new MainDish();
//
//        exp.setDishPrice(2000);
//        exp.setId_mainDishe(id);
//        exp.setNameDishe("papitas");
//        MainDish expResult = exp;
//        IMainDishAccess instance = new MainDishAccessImplSockets();
//        MainDish result = instance.findMainDish(id);
//        assertEquals(expResult.getId_mainDishe(), result.getId_mainDishe());
//
//    }
//
//    /**
//     * Test of updateMainDish method, of class MainDishService.
//     */
//    @Test
//    public void testUpdateMainDish() throws Exception {
//        System.out.println("updateMainDish");
//        String id = "4";
//        String name = "rabano";
//        double value = 2000;
//
//        String price = Double.toString(value);
//        IMainDishAccess instance = new MainDishAccessImplSockets();
//        MainDish result = instance.updateMainDish(id, name, price);
//        MainDish expResult = new MainDish();
//
//        expResult.setDishPrice(2000);
//        expResult.setId_mainDishe(id);
//        expResult.setNameDishe(name);
//        assertEquals(expResult.getId_mainDishe(), result.getId_mainDishe());
//    }
//
//    /**
//     * Test of deleteMainDish method, of class MainDishService.
//     */
//    @Test
//    public void testDeleteMainDish() throws Exception {
//        System.out.println("deleteMainDish");
//        String id = "10";
//        IMainDishAccess instance = new MainDishAccessImplSockets();
//        boolean expResult = true;
//        boolean result = instance.deleteMainDish(id);
//        assertEquals(expResult, result);
//    }
//}
