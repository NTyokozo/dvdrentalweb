/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author nobu
 */
public class CustomersNGTest {
    
    public CustomersNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getId method, of class Customers.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Customers instance = new Customers();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSerialVersionUID method, of class Customers.
     */
    @Test
    public void testGetSerialVersionUID() {
        System.out.println("getSerialVersionUID");
        long expResult = 0L;
        long result = Customers.getSerialVersionUID();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFullName method, of class Customers.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        Customers instance = new Customers();
        String expResult = "";
        String result = instance.getFullName();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Customers.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Customers instance = new Customers();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTellNum method, of class Customers.
     */
    @Test
    public void testGetTellNum() {
        System.out.println("getTellNum");
        Customers instance = new Customers();
        int expResult = 0;
        int result = instance.getTellNum();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Customers.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Customers instance = new Customers();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Customers.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Customers instance = new Customers();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
