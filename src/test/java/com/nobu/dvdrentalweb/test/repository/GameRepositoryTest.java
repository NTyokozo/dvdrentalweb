/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.repository;

import com.nobu.dvdrentalweb.app.ConnectionConfig;
import com.nobu.dvdrentalweb.domain.Gaming;
import com.nobu.dvdrentalweb.domain.NintendoGame;
import com.nobu.dvdrentalweb.repository.GameRepository;
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
public class GameRepositoryTest {

     public static ApplicationContext ctx;
    private Long id;
     private GameRepository repo;
    NintendoGame g = new NintendoGame();
   // private GameRepository repo;
    public GameRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
      //
     @Test
     public void createGames()
     {
         repo = ctx.getBean(GameRepository.class);
         NintendoGame g = null;
         Gaming  c = new Gaming.Builder(012)
                 .director("Mr Makwakwa")
                 .yearOfRelease(2000)
                 .nintendoGame(g)
                 .build();
         repo.save(c);
         id = c.getId();
         Assert.assertNull(c);
         Assert.assertNotNull(g);
     }
     @Test(dependsOnMethods = "createGames")
     public void readGames()
     {
         repo = ctx.getBean(GameRepository.class);
         Gaming c = repo.findOne(id);
         Assert.assertNotSame(c.getYearOfRelease(), 2014);
         
     }

     @Test(dependsOnMethods = "readGames")
     public void updateGames()
     {
         repo = ctx.getBean(GameRepository.class);
         Gaming c = repo.findOne(id);
         Gaming updateGames = new Gaming.Builder(012)
                   .games(c)
                  .director("Mr Smith")
                 .yearOfRelease(2014)
                 .nintendoGame(g)
                 .build();
         
         repo.save(updateGames);
         
         Gaming newGames = repo.findOne(id);
         Assert.assertEquals(newGames.getYearOfRelease(), 2014);
                    
     }
     @Test (dependsOnMethods = "updateGames")
     public void deleteGames()
     {
         repo = ctx.getBean(GameRepository.class);
         Gaming c = repo.findOne(id);
         repo.delete(c);
         
          Gaming deletedCustomer= repo.findOne(id);
         
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
          repo = ctx.getBean(GameRepository.class);
          repo.deleteAll();
}
}
