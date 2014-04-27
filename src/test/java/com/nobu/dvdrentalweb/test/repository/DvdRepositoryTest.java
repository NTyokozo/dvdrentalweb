/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.repository;

import com.nobu.dvdrentalweb.app.ConnectionConfig;
import com.nobu.dvdrentalweb.domain.Dvd;
import com.nobu.dvdrentalweb.repository.DvdRepository;
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
public class DvdRepositoryTest {
    
    public DvdRepositoryTest() {
    }

   public static ApplicationContext ctx;
    private Long id;
    
    private DvdRepository repo;
    
   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createDvd()
     {
         repo = ctx.getBean(DvdRepository.class);
         Dvd c = new Dvd.DvdType()
                 .length(90)
                 .status(true)
                 .dvd();
         repo.save(c);
         id = c.getId();
         Assert.assertNotNull(c);
     }
     @Test(dependsOnMethods = "createDvd")
     public void readDvd()
     {
         repo = ctx.getBean(DvdRepository.class);
         Dvd c = repo.findOne(id);
         Assert.assertNotEquals(c.price(200.00), 200.00);
         
     }

     @Test(dependsOnMethods = "readDvd")
     public void updateDvd()
     {
         repo = ctx.getBean(DvdRepository.class);
         Dvd c = repo.findOne(id);
           Dvd updateDvd = new Dvd.DvdType()
                 .status(true)
                 .dvd();
                   
         
         repo.save(updateDvd);
         
         Dvd newDvd = repo.findOne(id);
         Assert.assertSame(newDvd.price(2000.00), 2000.00);
                    
     }
     @Test (dependsOnMethods = "updateDvd")
     public void deleteDvd()
     {
         repo = ctx.getBean(DvdRepository.class);
         Dvd c = repo.findOne(id);
         repo.delete(c);
         
          Dvd deletedDvd= repo.findOne(id);
         
         Assert.assertNull(deletedDvd);
         
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
          repo = ctx.getBean(DvdRepository.class);
          repo.deleteAll();
    }

   
}
