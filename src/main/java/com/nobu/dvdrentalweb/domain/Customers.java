/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;




/**
 *
 * @author nobu
 */
@Entity 
public class Customers implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;
    private String address;
    @Column(unique = true)
    private int tellNum;
   @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "customer_id")
    List<RentalAgreement> rentalAgree;
    @OneToMany
  @JoinColumn(name = "customer_id")
    List<RentMovie> rentalMovie;
   
   

    public Customers() {
    }
 
    public Long getId() {
        return id;
    }
    
    private Customers(Builder build)
    {
        id = build.id;
        fullName = build.fullName;
        address = build.address;
        tellNum = build.tellNum;
        
    }
   
    
    public static class Builder
    {
        private Long id;
        private String fullName;
        private String address;
        private int tellNum;
        List<RentalAgreement> rentalAgree;
        List<RentMovie> rentalMovie;
        
        public Builder(int tellNum)
        {
            this.tellNum = tellNum;
        }
        public Builder id(Long value)
        {
            id = value;
            return this;
        }
        public Builder fullName(String value)
        {
            fullName = value;
            return this;
        }
        public Builder address(String value)
        {
            address = value;
            return this;
        }
        public Builder tellNum(int value)
        {
            tellNum = value;
            return this;
        }
        public Builder accounts(List<RentalAgreement> value) {
            rentalAgree = value;
            return this;
        }

        public Builder clubs(List<RentMovie> value) {
            rentalMovie = value;
            return this;
        }
        public Builder customer(Customers customer)
        {
            id = customer.getId();
            fullName = customer.getFullName();
            tellNum = customer.getTellNum();
            address = customer.getAddress();
            rentalMovie = customer.getRentals();
            rentalAgree = customer.getRental();
            
            
            
            return this;
        }
        public Customers build()
        {
            return new Customers(this);
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public int getTellNum() {
        return tellNum;
    }

    public List<RentalAgreement> getRental() {
        return rentalAgree;
    }

    public List<RentMovie> getRentals() {
        return rentalMovie;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Customers other = (Customers) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
    
}
