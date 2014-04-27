/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.repository;

import com.nobu.dvdrentalweb.app.ConnectionConfig;
import com.nobu.dvdrentalweb.domain.OldRelease;
import com.nobu.dvdrentalweb.repository.OldReleaseRepository;
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
public class OldReleaseRepositoryTest {
    
    public OldReleaseRepositoryTest() {
    }
  public static ApplicationContext ctx;
    private Long id;
    
    private OldReleaseRepository repo;

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createMovie()
     {
        // List <Adult> adult = null ;
         repo = ctx.getBean(OldReleaseRepository.class);
         OldRelease c = new OldRelease.OldReleaseBuilder()
                 .avail(true)
                 .newO();
         repo.save(c);
         id = c.getId();
         Assert.assertNull(c);
     }
     @Test(dependsOnMethods = "createMovie")
     public void readMovie()
     {
         repo = ctx.getBean(OldReleaseRepository.class);
         OldRelease c = repo.findOne(id);
         Assert.assertNotEquals(c.getAvail(), false);
         
     }

     @Test(dependsOnMethods = "readMovie")
     public void updateMovie()
     {
         repo = ctx.getBean(OldReleaseRepository.class);
         OldRelease c = repo.findOne(id);
           OldRelease updateMovie = new OldRelease.OldReleaseBuilder()
                 .oldRelease(c)
                 .avail(false)
                 .newO();
                   
         
         repo.save(updateMovie);
         
         OldRelease newMovie = repo.findOne(id);
         Assert.assertSame(newMovie.getAvail(), true);
                    
     }
     @Test (dependsOnMethods = "updateMovie")
     public void deleteMovie()
     {
         repo = ctx.getBean(OldReleaseRepository.class);
         OldRelease c = repo.findOne(id);
         repo.delete(c);
         
          OldRelease deletedMovie= repo.findOne(id);
         
         Assert.assertNull(deletedMovie);
         
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
          repo = ctx.getBean(OldReleaseRepository.class);
          repo.deleteAll();
    }
}
