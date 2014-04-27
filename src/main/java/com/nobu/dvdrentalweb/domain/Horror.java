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
public  class Horror implements Serializable
{
     private  List<String> names;
     private  List<String> name;
     private String type;
     private String pg;
     
     

    public Horror() {
    }
    
    public Horror(HorrorBuilder hor)
    {
        names = hor.names;
        type = hor.type;
        pg = hor.pg;
    }
    
   
       public static class HorrorBuilder 
    {
       
        private List<String> names;
         private String type;
         private String pg;
      
        
        public HorrorBuilder()
        {
        }
       
        public HorrorBuilder name(List<String> value)
        {
           this.names = value;
           return this;
        }
        public HorrorBuilder type(String value)
        {
           this.type = value;
           return this;
        }
        public HorrorBuilder pg(String value)
        {
           this.pg = value;
           return this;
        }
      
        public HorrorBuilder action(Cartoons value)
        {
            this.names = value.getNames();
           this.type = value.getType();
           this.pg = value.getPg();
           return this;
        }
        public Horror hor()
        {
            return new Horror(this);
        }
    }
    
  
    public List<String> getNamess()
    {
        List<String> namess = new ArrayList<>();
        namess.add("Sinister");
        namess.add("Conjuring");
        
                return namess;
    }
    public String type()
    {
        String movietype = "Funny Horror";
        
        return movietype;
    }
    public String pg()
    {
        String moviepg = "18 Years";
        
       return moviepg;
    }   
    
}
