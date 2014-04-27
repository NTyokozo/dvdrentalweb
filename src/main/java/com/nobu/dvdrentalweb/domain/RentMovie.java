/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author nobu
 */
@Entity
public class RentMovie implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;
    private String type;

    public RentMovie() {
    }
  
    private RentMovie(RentMovieBuilder build)
    {
        Id = build.Id;
        type = build.type;
    }
    public static class RentMovieBuilder
    {
        private Long Id;
        private String type;
   
        
        public RentMovieBuilder()
        {
           
        }
        public RentMovieBuilder id(Long value)
        {
          Id = value;
          return this;
        }
        public RentMovieBuilder type(String value)
        {
            type = value;
            return this;
        }
        public RentMovieBuilder rentMovie(RentMovie value)
        {
            Id = value.getId();
            type = value.getType();
            return this;
        }
        public RentMovie rent()
        {
          return new RentMovie(this);    
        }
    }
    public int length() {
        return 60;
    }

    public boolean status() {
       return true;
    }

    public double Price(double total) {
        return 120;
    }

    public String getType()
    {
        String typ;
        typ = "Movie has been rented out";
       return typ;
    }

    public String pg()
    {
      return "18";
    
    }

    public Long getId() {
        return Id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.Id != null ? this.Id.hashCode() : 0);
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
        final RentMovie other = (RentMovie) obj;
        return !((this.Id == null) ? (other.Id != null) : !this.Id.equals(other.Id));
    }
  
    
    
}
