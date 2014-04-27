/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embeddable;

/**
 *
 * @author nobu
 */
@Embeddable
public class Cartoons implements Serializable
{
    
     private  List<String> name;
     private String type;
     private String pg;
     
    public Cartoons() {
    }
 
    
    private Cartoons(CartoonsBuilder comm)
    {
         name = comm.name;
        type = comm.type;
        pg = comm.pg;
    }
    
    public static class CartoonsBuilder 
    {
       
        private List<String> name;
         private String type;
         private String pg;
      
        
        public CartoonsBuilder()
        {
        }
       
        public CartoonsBuilder name(List<String> value)
        {
           this.name = value;
           return this;
        }
        public CartoonsBuilder type(String value)
        {
           this.type = value;
           return this;
        }
        public CartoonsBuilder pg(String value)
        {
           this.pg = value;
           return this;
        }
      
        public CartoonsBuilder action(Cartoons value)
        {
            this.name = value.getNames();
           this.type = value.getType();
           this.pg = value.getPg();
           return this;
        }
        public Cartoons car()
        {
            return new Cartoons(this);
        }
    }
    
    

    public List<String> getNames()
    {
        List<String> namess = new ArrayList<>();
        namess.add("Air Bander");
        namess.add("Dragon Balls");
        
                return namess;
    }
    public String getType()
    {
        //String type = "Action Catoons";
        
        return type;
    }
    public String getPg()
    {
        //String pg = "All";
        
       return pg;
    }

   
    
}
