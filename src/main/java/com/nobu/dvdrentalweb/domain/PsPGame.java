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
public class PsPGame implements Serializable 
{
 
    private  int speed;
    private final double Tax_Amount = 0.16;

    public PsPGame() {
    }
   
    private PsPGame(PsPGameBuilder build)
    {
      
        speed = build.speed;
    }
    public static class PsPGameBuilder 
    {
     
        private int speed;
      
        
        public PsPGameBuilder()
        {
            
        }
       
        public PsPGameBuilder speed(int value)
        {
            speed = value;
            return this;   
        }
        public PsPGameBuilder psP(PsPGame value)
        {
            
            speed = value.getSpeed();
            return this;
        }
        public PsPGame psp()
        {
            return new PsPGame(this);
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
        List<String> names = new ArrayList<String>();
        names.add("Quatum Physics");
        names.add("Applied Physics");
        
        return names;
        
    }

   
    public int getSpeed() {
        return speed;
    }

    
    
    
}
