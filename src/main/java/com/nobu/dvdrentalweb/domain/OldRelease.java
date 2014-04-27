/*
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
public class OldRelease implements Serializable 
{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private  Long Id;
   private  boolean avail;

    public OldRelease() {
    }
    
    
    public OldRelease(OldReleaseBuilder bui)
    {
        Id = bui.Id;
        avail = bui.avail;
    }
    public static class OldReleaseBuilder
    {
        private Long Id;
        private boolean avail;
      
        
        public OldReleaseBuilder()
        {
         
        }
        public OldReleaseBuilder Id(Long value)
        {
            Id = value;
            return (this);
            
        }
        public OldReleaseBuilder avail(boolean value)
        {
            avail = value;
            return this;
        }
        public OldReleaseBuilder oldRelease(OldRelease oldR)
        {
            Id = oldR.getId();
            avail = oldR.getAvail();
            return this;
        }
      
        public OldRelease newO()
        {
            return new OldRelease(this);
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
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.Id);
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
        final OldRelease other = (OldRelease) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }
    
}
