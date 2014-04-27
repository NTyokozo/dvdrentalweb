/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.repository;

import com.nobu.dvdrentalweb.app.ConnectionConfig;
import com.nobu.dvdrentalweb.domain.Customers;
import com.nobu.dvdrentalweb.repository.CustomerRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author nobu
 */
public class CustomerRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    
    private CustomerRepository repo;
    
    public CustomerRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createCustomer()
     {
         repo = ctx.getBean(CustomerRepository.class);
         Customers c = new Customers.Builder(012)
                 .fullName("Nobu Tyo")
                 .address("16 Station road")
                 .build();
         repo.save(c);
         id = c.getId();
         Assert.assertNull(c);
     }
     @Test(dependsOnMethods = "createCustomer")
     public void readCustomer()
     {
         repo = ctx.getBean(CustomerRepository.class);
         Customers c = repo.findOne(id);
         Assert.assertEquals(c.getFullName(), "Nobu Tyo");
         
     }

     @Test(dependsOnMethods = "readCustomer")
     public void updateCustomer()
     {
         repo = ctx.getBean(CustomerRepository.class);
         Customers c = repo.findOne(id);
         Customers updateCustomer = new Customers.Builder(012)
                   .customer(c)
                    .address("17 Station Road")
                    .fullName("Rose Tyo")
                    .build();
         
         repo.save(updateCustomer);
         
         Customers newCustomer = repo.findOne(id);
         Assert.assertEquals(newCustomer.getFullName(), "Rose Tyo");
                    
     }
     @Test (dependsOnMethods = "updateCustomer")
     public void deleteCustomer()
     {
         repo = ctx.getBean(CustomerRepository.class);
         Customers c = repo.findOne(id);
         repo.delete(c);
         
          Customers deletedCustomer= repo.findOne(id);
         
         Assert.assertNull(deletedCustomer);
         
     }
    @BeforeClass
    public  void setUpClass() throws Exception 
    {
         ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
         //repo = ()ctx.getBean("et");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
          repo = ctx.getBean(CustomerRepository.class);
          repo.deleteAll();
    }
}
