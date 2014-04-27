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
import javax.persistence.Embeddable;

/**
 *
 * @author nobu
 */
@Embeddable
public class Comedy implements Serializable 
{   
    private String name; 
    private String type;
    private String pg;

    public Comedy() {
    }
    public Comedy(ComedyBuilder comm)
    {
       
        name = comm.name;
        type = comm.type;
        pg = comm.pg;
    }
    
    public static class ComedyBuilder 
    {
       
        private String name;
        private String type;
        private String pg;
        
       
        
        public ComedyBuilder()
        {
        }
        public ComedyBuilder type(String value)
        {
            this.type = value;
           return this;
        }
        public ComedyBuilder name(String value)
        {
            this.name = value;
            return this;
        }
        public Comedy coom()
        {
            return new Comedy(this);
        }
           public ComedyBuilder comedy(Comedy value)
        {
            
            name = value.getName();
            type = value.getType();
            pg = value.getPg();
            return this;
        }
    }
    
    public String getName()
    {
        String movieName = "Your Country needs you";
        String producer ="leon Schuster";
        String duration = "100:00";
        
        
        String myObject = (movieName + producer + duration);
        
        return myObject;
     
        
    }
           
    
    public String getType()
    {
       // String type = "romentic Comedy";
        
        return type;
    }
    public String getPg()
    {
        //String pg = "All";
        
       return pg;
    }

    

 
    
}
