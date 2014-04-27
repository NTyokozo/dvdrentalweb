/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.repository;

import com.nobu.dvdrentalweb.app.ConnectionConfig;
import com.nobu.dvdrentalweb.domain.Adult;
import com.nobu.dvdrentalweb.domain.Movie;
import com.nobu.dvdrentalweb.repository.MovieRepository;
import java.util.List;
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
public class MovieRepositoryTest {
    
    public MovieRepositoryTest() {
    }

   
    public static ApplicationContext ctx;
    private Long id;
    
    private MovieRepository repo;
    List <Adult> adult = null ;
    
   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createMovie()
     {
        // List <Adult> adult = null ;
         repo = ctx.getBean(MovieRepository.class);
         Movie c = new Movie.Builder(2000)
                 .director("Leon Schuster")
                 .accounts(adult)
                 .build();
         repo.save(c);
         id = c.getId();
         Assert.assertNotNull(c);
     }
     @Test(dependsOnMethods = "createMovie")
     public void readMovie()
     {
         repo = ctx.getBean(MovieRepository.class);
         Movie c = repo.findOne(id);
         Assert.assertNotEquals(c.getDirector(), "Lazy Tom");
         
     }

     @Test(dependsOnMethods = "readMovie")
     public void updateMovie()
     {
         repo = ctx.getBean(MovieRepository.class);
         Movie c = repo.findOne(id);
           Movie updateMovie = new Movie.Builder(2015)
                  .movie(c)
                 .director("Leon Schuster")
                 .accounts(adult)
                 .build();
                   
         
         repo.save(updateMovie);
         
         Movie newMovie = repo.findOne(id);
         Assert.assertSame(newMovie.getDirector(), "Lazy Tom");
                    
     }
     @Test (dependsOnMethods = "updateMovie")
     public void deleteMovie()
     {
         repo = ctx.getBean(MovieRepository.class);
         Movie c = repo.findOne(id);
         repo.delete(c);
         
          Movie deletedMovie= repo.findOne(id);
         
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
          repo = ctx.getBean(MovieRepository.class);
          repo.deleteAll();
    }
}
