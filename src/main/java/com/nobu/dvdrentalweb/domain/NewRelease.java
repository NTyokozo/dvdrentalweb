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
public class NewRelease implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;
    private  boolean avail;

    public NewRelease() {
    }
    
    
    public NewRelease(NewReleaseBuilder bui)
    {
        Id = bui.Id;
        avail = bui.avail;
    }
    public static class NewReleaseBuilder
    {
        private Long Id;
        private boolean avail;
       
        public NewReleaseBuilder()
        {
         
        }
        public NewReleaseBuilder Id(Long value)
        {
            Id = value;
            return (this);
            
        }
        public NewReleaseBuilder avail(boolean value)
        {
            avail = value;
            return this;
        }
        public NewReleaseBuilder newRelease(NewRelease newr)
        {
            Id = newr.getId();
            avail = newr.getAvail();
            return this;
        }
        public NewReleaseBuilder newRe(NewRelease value)
        {
            Id = value.getId();
            avail = value.getAvail();
            return this;
        }
        public NewRelease newR()
        {
            return new NewRelease(this);
        }

        
    }
    public boolean getAvail()
    {
        return avail;
    }

    public Long getId() {
        return Id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (this.Id != null ? this.Id.hashCode() : 0);
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
        final NewRelease other = (NewRelease) obj;
        return !((this.Id == null) ? (other.Id != null) : !this.Id.equals(other.Id));
    }
    
}
