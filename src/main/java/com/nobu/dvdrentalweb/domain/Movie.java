/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


/**
 *
 * @author nobu
 */
@Entity
public class Movie implements Serializable
{
    public static final long serialVersionUDI = 1L; 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int yearOfRelease;
    private String director;
    @Embedded
    private Action act;
    @Embedded
    private Comedy comedy;
    @Embedded
    private Horror hor;
    @Embedded
    private Cartoons car;
    @Embedded
    private Romance romance;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    List<Adult> adult;
    @OneToMany
    @JoinColumn(name = "person_id")
    List<Teen> teen;

    

    public Movie() {
    }
    
    private Movie (Builder build)
    {
            id = build.id;
            yearOfRelease = build.yearOfRelease;
            director = build.director;
            act = build.act;
            comedy = build.comedy;
            hor = build.hor;
            car = build.car;
            romance = build.romance;
            adult = build.adult;
            teen = build.teen;
    }
    
   
    public static class Builder
    {
        private Long id;
        private int yearOfRelease;
        private String director;
        private Action act;
        private Comedy comedy;
        private Horror hor;
        private Cartoons car;
        private Romance romance;
        private List<Adult> adult;
        private List<Teen> teen;
                
        

        
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
            this.director=value;
            return this;
        }
          public Builder Action (Action value)
          {
              this.act = value;
              return this;
          }
          public Builder Comedy (Comedy value)
          {
              this.comedy = value;
              return this;
          }
          public Builder Horror (Horror value)
          {
              this.hor = value;
              return this;
          }
          public Builder Cartoons (Cartoons value)
          {
              this.car = value;
              return this;
          }
          public Builder Romance (Romance value)
          {
              this.romance = value;
              return this;
          }
          public Builder accounts(List<Adult> value)
          {
            adult = value;
            return this;
          }

        public Builder clubs(List<Teen> value) 
         {
            teen = value;
            return this;
        }
        public Builder movie(Movie movie)
        {
           id = movie.getId();
           yearOfRelease = movie.getYearOfRelease();
           director = movie.getDirector();
           act = movie.getAction();
           comedy = movie.getComedy();
            hor = movie.getHor();
            car = movie.getCar();
           romance = movie.getRomance();
           adult = movie.getAdult();
           teen = movie.getTeen();
           
          return this;  
        }
          public Movie build()
          {
              return new Movie(this);
          }
          
    }

    public Long getId() {
        return id;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public String getDirector() {
        return director;
    }

    public com.nobu.dvdrentalweb.domain.Action getAction() {
        return act;
    }

    public com.nobu.dvdrentalweb.domain.Comedy getComedy() {
        return comedy;
    }

    public com.nobu.dvdrentalweb.domain.Horror getHor() {
        return hor;
    }

    public com.nobu.dvdrentalweb.domain.Cartoons getCar() {
        return car;
    }

    public com.nobu.dvdrentalweb.domain.Romance getRomance() {
        return romance;
    }

    public com.nobu.dvdrentalweb.domain.Action getAct() {
        return act;
    }

    public List<Adult> getAdult() {
        return adult;
    }

    public List<Teen> getTeen() {
        return teen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Movie other = (Movie) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
