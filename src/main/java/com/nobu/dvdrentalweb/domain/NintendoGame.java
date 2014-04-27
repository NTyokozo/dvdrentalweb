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
public class NintendoGame implements Serializable 
{
    
    private  char speed;
    private final double Tax_Amount = 0.16;

    public NintendoGame() {
    }
   
    private NintendoGame(NintendoGameBuilder build)
    {
        
        speed = build.speed;
    }
    public static class NintendoGameBuilder 
    {
        
        private char speed;
      
        public NintendoGameBuilder()
        {
            
        }
      
        public NintendoGameBuilder speed(char value)
        {
            speed = value;
            return this;   
        }
        public NintendoGameBuilder nintendo(NintendoGame value)
        {
          
           speed = value.getSpeed();
            return this;
        }
        public NintendoGame nin()
        {
            return new NintendoGame(this);
        }
    }
    
   public int quantity()
    {
        int num = 1;
        
        if(num ==1)
          System.out.println("Stock available");
        
       return num;
    }

    public double price(double total)
    {
        double amount = 120 * Tax_Amount;
         total = amount + 120;
        
        return total ;
    }

    public List<String> name() 
    {
        List<String> names = new ArrayList<>();
        names.add("Pool table");
        names.add("Monopoly");
        
        return names;
        
    }

    public char getSpeed() {
        return speed;
    }

  
}
