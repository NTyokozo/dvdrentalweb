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
public class BlueRay implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;
    private  boolean status;
    private  final double tax = 0.23;
    private double price;

    public BlueRay() {
    }
 
    
    public BlueRay(BlueRayType blue)
    {
        Id = blue.Id;
        status = blue.status;
        price = blue.price;
    }

    public static class BlueRayType
    {
        private Long Id ;
        private boolean  status ;
        private double price; 
        
        
        public BlueRayType()
        {
        }
        public BlueRayType Id(Long value)
        {
           Id = value;
            return this;
            
        }
        public BlueRayType status(boolean value)
        {
            status = value;
            return this;
        }
         public BlueRayType status(double value)
        {
            price = value;
            return this;
        }
        public BlueRayType blueRay(BlueRay value)
        {
            Id = value.getId();
            status = value.getStatus();
            price = value.getPrice();
            return this;
        }
        public BlueRay blueR()
        {
            return new BlueRay(this);
        }
    }
    public int getlength()
    {
        return 120;
    }

    public boolean getStatus()
    {
         return status;
    }

    public double getPrice()
    {
        double total = 50;
        double fulTotal;
        double amount = total * tax;
        
        fulTotal = amount + total;
        
        return fulTotal;
        
    } 

    public Long getId() {
        return Id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.Id != null ? this.Id.hashCode() : 0);
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
        final BlueRay other = (BlueRay) obj;
        if ((this.Id == null) ? (other.Id != null) : !this.Id.equals(other.Id)) {
            return false;
        }
        return true;
    }
    
}
