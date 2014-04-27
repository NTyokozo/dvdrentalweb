/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;


import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nobu
 */
@Entity
public class AddMovie implements Serializable 
{
   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
     private Long Id;
     private String movieName;
     private Object clone;

    public AddMovie() {
    }

      public AddMovie(Builder builder)
      {
          Id = builder.Id;
          movieName = builder.movieName; 
        clone = builder.clone;
          
      }
      public static class Builder
      {
          private Long Id;
          private String movieName;
          private Object clone;
         
          
          public Builder()
          {
              
          }

        public Builder(String movieName)
        {
            this.movieName = movieName;
        }

          public Builder Id(Long value)
          {
              Id= value;
              return this;
          }
          public Builder MovieName(String value)
          {
              movieName = value;
              return this;
          }
          public Builder addMovie(AddMovie value)      
          {
            Id = value.getId();
            movieName = value.getMovieName();
            clone = value.getClone();
            return this;
          }
          
          public AddMovie build()
          {
              return new AddMovie(this);
          }

        
      }

    public String getMovieName() {
        return movieName;
    }
      
    public Long getId() {
        return Id;
    }

    public Object getClone() {
        return clone;
    }
    
      @Override
    public int hashCode()
    {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AddMovie other = (AddMovie) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

}
