/*
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
public  class RentalAgreement implements Serializable   
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id ;
    private  int timer;

    public RentalAgreement() {
    }
    
    private RentalAgreement(RentalBuilds build)
    {
        Id = build.Id;
        timer = build.timer;
    }
    public static class RentalBuilds
    {
        private Long Id;
        private int timer;
   
        
        public RentalBuilds()
        {
        }
        public RentalBuilds id(Long value)
        {
            Id = value;
            return this;
        }
        public RentalBuilds timer(int value )
        {
            timer = value;
            return this;
        }
        public RentalBuilds rental(RentalAgreement value)
        {
            Id = value.getId();
            timer = value.getTimer();
            return this;
        }
        public RentalAgreement rent()
        {
            return new RentalAgreement(this);
        }
        
    }

    public Long getId() {
        return Id;
    }

    public int getTimer() {
        return timer;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.Id != null ? this.Id.hashCode() : 0);
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
        final RentalAgreement other = (RentalAgreement) obj;
        if ((this.Id == null) ? (other.Id != null) : !this.Id.equals(other.Id)) {
            return false;
        }
        return true;
    }
    
}
