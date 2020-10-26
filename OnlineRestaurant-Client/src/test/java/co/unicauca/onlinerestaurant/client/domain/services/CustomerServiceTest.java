//package co.unicauca.onlinerestaurant.client.domain.services;
//
//import co.unicauca.onlinerestaurant.client.access.CustomerAccessImplSockets;
//import co.unicauca.onlinerestaurant.client.access.ICustomerAccess;
//import co.unicauca.onlinerestaurant.commons.domain.Customer;
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
//public class CustomerServiceTest {
//
//    public CustomerServiceTest() {
//    }
//
//    /**
//     * Test of createCustomer method, of class CustomerService.
//     */
//    @Test
//    public void testCreateCustomer() throws Exception {
//        System.out.println("createCustomer");
//        Customer customer = new Customer();
//        customer.setId("12");
//        customer.setRol("user");
//        customer.setPws("123");
//        customer.setMobile("123445");
//        customer.setFirstName("marco");
//        customer.setLastName("polo");
//        customer.setEmail("aja@ja");
//        customer.setAddress("direction");
//
//        ICustomerAccess instance = new CustomerAccessImplSockets();
//        boolean expResult = true;
//        boolean result = instance.createCustomer(customer);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of findCustomer method, of class CustomerService.
//     */
//    @Test
//    public void testFindCustomer_String() throws Exception {
//        System.out.println("findCustomer");
//        String id = "12";
//        ICustomerAccess instance = new CustomerAccessImplSockets();
//        Customer result = instance.findCustomer(id);
//        Customer expResult = new Customer();
//
//        expResult.setId("12");
//        expResult.setFirstName("marco");
//        expResult.setRol("user");
//        expResult.setPws("123");
//
//        assertEquals(expResult.getRol(), result.getRol());
//        assertEquals(expResult.getFirstName(), result.getFirstName());
//        assertEquals(expResult.getPws(), result.getPws());
//        assertEquals(expResult.getId(), result.getId());
//    }
//
//    /**
//     * Test of findCustomer method, of class CustomerService.
//     */
//    @Test
//    public void testFindCustomer_String_String() throws Exception {
//        System.out.println("find by password Customer");
//        String name = "marco";
//        String pws = "123";
//        ICustomerAccess instance = new CustomerAccessImplSockets();
//        Customer result = instance.findCustomer(name, pws);
//        Customer expResult = new Customer();
//
//        expResult.setId("12");
//        expResult.setFirstName("marco");
//        expResult.setRol("user");
//        expResult.setPws("123");
//
//        assertEquals(expResult.getRol(), result.getRol());
//        assertEquals(expResult.getFirstName(), result.getFirstName());
//        assertEquals(expResult.getPws(), result.getPws());
//        assertEquals(expResult.getId(), result.getId());
//    }
//}
