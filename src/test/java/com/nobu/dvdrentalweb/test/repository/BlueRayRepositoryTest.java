/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.repository;

import com.nobu.dvdrentalweb.app.ConnectionConfig;
import com.nobu.dvdrentalweb.domain.BlueRay;
import com.nobu.dvdrentalweb.repository.BlueRayRepository;
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
public class BlueRayRepositoryTest {
    
    public BlueRayRepositoryTest() {
    }

    public static ApplicationContext ctx;
    private Long id;
    
    private BlueRayRepository repo;
    
   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createBlue()
     {
         repo = ctx.getBean(BlueRayRepository.class);
         BlueRay c = new BlueRay.BlueRayType()
                 .status(true)
                 .blueR();
         repo.save(c);
         id = c.getId();
         Assert.assertNotNull(c);
     }
     @Test(dependsOnMethods = "createBlue")
     public void readBlue()
     {
         repo = ctx.getBean(BlueRayRepository.class);
         BlueRay c = repo.findOne(id);
         Assert.assertNotEquals(c.getStatus(), true);
         
     }

     @Test(dependsOnMethods = "readBlue")
     public void updateBlue()
     {
         repo = ctx.getBean(BlueRayRepository.class);
         BlueRay c = repo.findOne(id);
           BlueRay updateBlue = new BlueRay.BlueRayType()
                   .blueRay(c)
                 .status(true)
                 .blueR();
                   
         
         repo.save(updateBlue);
         
         BlueRay newCustomer = repo.findOne(id);
         Assert.assertSame(newCustomer.getStatus(), true);
                    
     }
     @Test (dependsOnMethods = "updateBlue")
     public void deleteBlue()
     {
         repo = ctx.getBean(BlueRayRepository.class);
         BlueRay c = repo.findOne(id);
         repo.delete(c);
         
          BlueRay deletedCustomer= repo.findOne(id);
         
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
          repo = ctx.getBean(BlueRayRepository.class);
          repo.deleteAll();
    }
}
