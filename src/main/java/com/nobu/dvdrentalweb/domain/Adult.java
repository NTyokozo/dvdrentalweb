/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author nobu
 */
@Entity
public class Adult implements Serializable
{
     private int age;
    private  String id;
    private  String infor;

    public Adult() {
    }
    

   
    private Adult(AdultBuilder adult)
    {
        age = adult.age;
        id = adult.id;
        infor = adult.infor;
    }

   
    public static class AdultBuilder 
    {
        private int age;
        private String id;
        private String infor;
      
        
        public AdultBuilder()
        {
        }
        public AdultBuilder id(String value)
        {
            id = value;
            return(this);
        }
        public AdultBuilder age(int value)
        {
            age = value;
            return(this);
            
        }
        public AdultBuilder infor(String value)
        {
            infor = value;
            return this;
        }
        public AdultBuilder adult(Adult value)
        {
            id = value.getId();
            age = value.getAge();
            infor = value.getinfor();
            return this;
        }
      
        public Adult adul()
        {
            return new Adult(this);
        }
    }
    public int getAge() 
    {
        return age;
    }

    public String getId() {
        return id;
    }
    
    public String getinfor()
    {
       // return infor;
      String[] custInfo = {"Nobubele", "0747444826 ", "235BricStr"};
      //custInfo = {"Nobubele", "0747444826 ", "235 Bric Str"};
      return custInfo[2];
    }


    @Override
    public int hashCode() {
        int hash = 5;
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
        final Adult other = (Adult) obj;
        if (this.age != other.age) {
            return false;
        }
        return true;
    }
    
    
}
