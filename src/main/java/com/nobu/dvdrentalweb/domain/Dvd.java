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
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nobu
 */
@Entity 
public class Dvd implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;
    private final double tax = 0.14;
    private int lengths; 
    public Dvd() {
    }
    
    public Dvd(DvdType dvd)
    {
        Id = dvd.Id;
        lengths = dvd.lengths;
    }

    public static class DvdType
    {
        private Long Id ;
        private boolean status ;
        private int lengths;
     
        
        public DvdType()
        {
        }
        public DvdType Id(Long value)
        {
           Id = value;
            return this;
            
        }
        public DvdType status(boolean value)
        {
            status = value;
            return this;
        }
        public DvdType length(int value)
        {
            lengths = value;
            return this;
        }
        public DvdType dvD(Dvd dv)
        {
            status = dv.status();
            Id = dv.getId();
            lengths = dv.getlength();
            return this;
        }

        public Dvd dvd()
        {
            return new Dvd(this);
        }
    }
    public int getlength()
    {
        return lengths;
    }

    public boolean status()
    {
        return false;
    }

    public double price(double fulTotal)
    {
        double total = 50;
        
        double amount = total * tax;
        
         fulTotal = amount + total;
        
        return fulTotal;
        
    } 

    public Long getId() {
        return Id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.Id);
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
        final Dvd other = (Dvd) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

    
    
}
