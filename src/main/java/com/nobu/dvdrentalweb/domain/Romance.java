/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Embeddable;

/**
 *
 * @author nobu
 */
@Embeddable
public class Romance implements Serializable {
       
     private  Set<String> names;
     private String type;
     private String pg;

    public Romance() {
    }
     
    
    public Romance(RomanceBuilder rom)
    {
             names = rom.names;
            type = rom.type;
            pg = rom.pg;
    }
    
    public static class RomanceBuilder 
    {
          private Set<String> names;
         private String type;
         private String pg;
      
        
       public RomanceBuilder()
        {
        }
       
        public RomanceBuilder name(Set<String> value)
        {
           this.names = value;
           return this;
        }
        public RomanceBuilder type(String value)
        {
           this.type = value;
           return this;
        }
        public RomanceBuilder pg(String value)
        {
           this.pg = value;
           return this;
        }
      
        public RomanceBuilder action(Cartoons value)
        {
            this.names = (Set<String>) value.getNames();
           this.type = value.getType();
           this.pg = value.getPg();
           return this;
        }
        public Romance romm()
        {
            return new Romance(this);
        }
    }
    
    public Set<String> getNames()
    {
        List<String> name = new ArrayList<>();
      //  Set<String> namess = new HashMap<String>();
        name.add("Rush Hour");
        name.add("Interns");
        name.add("Interns");
        
         
          Set<String> nam = new HashSet<>(name);
                return nam;
    }
    public String type()
    {
        String type = "romentic";
        
        return type;
    }
    public String pg()
    {
        String pg = "16";
        
       return pg;
    }

    
}
