/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nobu
 */
@Entity
public class Gaming implements Serializable 
{
      public static final long serialVersionUDI = 1L; 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int yearOfRelease;
    private String maker;
    @Embedded
    private NintendoGame nin;
    @Embedded
    private PsPGame psp;
  

    

    public Gaming() {
    }
    
    private Gaming (Builder build)
    {
            id = build.id;
            yearOfRelease = build.yearOfRelease;
            maker = build.maker;
            nin = build.nin;
            psp = build.psp;
         
    }
    
   
    public static class Builder
    {
        private Long id;
        private int yearOfRelease;
        private String maker;
        private NintendoGame nin;
        private PsPGame psp;
       
                
        

        
        public Builder(int yearOfRelease)
        {
            this.yearOfRelease = yearOfRelease;
        }
        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }
         public Builder yearOfRelease(int value)
        {
            this.yearOfRelease=value;
            return this;
        }
          public Builder director(String value)
        {
            this.maker=value;
            return this;
        }
          public Builder nintendoGame (NintendoGame value)
          {
              this.nin = value;
              return this;
          }
          public Builder psPGame (PsPGame value)
          {
              this.psp = value;
              return this;
          }
          
        public Builder games(Gaming game)
        {
           id = game.getId();
           yearOfRelease = game.getYearOfRelease();
           maker = game.getDirector();
           nin = game.getNin();
           psp = game.getPsp();
           
          return this;  
        }
          public Gaming build()
          {
              return new Gaming(this);
          }
          
    }

    public Long getId() {
        return id;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public String getDirector() {
        return maker;
    }

    public NintendoGame getNin() {
        return nin;
    }

    public PsPGame getPsp() {
        return psp;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Gaming other = (Gaming) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    

}
