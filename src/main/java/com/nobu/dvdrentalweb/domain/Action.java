/*
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
public class Action implements Serializable
{

     private  String name;
     private String type;
     private String pg;

    public Action() {
    }
    
    private Action(ActionBuilder act)
    {
        name = act.name;
        type = act.type;
        pg = act.pg;
    }
    
    public static class ActionBuilder 
    {
       
        private String name;
         private String type;
         private String pg;
      
        
        public ActionBuilder()
        {
        }
       
        public ActionBuilder name(String value)
        {
           this.name = value;
           return this;
        }
        public ActionBuilder type(String value)
        {
           this.type = value;
           return this;
        }
        public ActionBuilder pg(String value)
        {
           this.pg = value;
           return this;
        }
      
        public ActionBuilder action(Action value)
        {
        this.name = value.getName();
           this.type = value.getType();
           this.pg = value.getPg();
           return this;
        }
        public Action acts()
        {
            return new Action(this);
        }
    }
    
    public String getName()
    {
        //return name;
        String name = "if only";
        String producer ="Gil Junger";
        String duration = "63:00";
        
        
        String myObject = (name + producer + duration);
        
        return myObject;
     
        
    }
   
    public String getType()
    {
      //  String type = "action";
        
        return type;
    }
    public String getPg()
    {
      //  String pg = "16";
        
       return pg;
    }


   
}
