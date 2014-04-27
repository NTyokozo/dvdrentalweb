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
public class Teen implements Serializable 
{
   private  int age;
    private  String id;
    private String infor;

   
    private Teen(TeenBuilder teen)
    {
        age = teen.age;
        id = teen.id;
        infor = teen.infor;
    }

   
    public static class TeenBuilder 
    {
        private int age;
        private String id;
        private String infor;
        
        
        
        public TeenBuilder()
        {
        }
        public TeenBuilder id(String value)
        {
            id = value;
            return(this);
        }
        public TeenBuilder age(int value)
        {
            age = value;
            return(this);
            
        }
        public TeenBuilder infor(String value)
        {
            infor = value;
            return this;
        }
       
        public TeenBuilder teen(Teen value)
        {
            age = value.getAge();
            id = value.getId();
            infor = value.getInfor();
            return this;
        }
        public Teen ten()
        {
            return new Teen(this);
        }
    }
    public int getAge() 
    { 
        int year = 1996;
        if(age > year )
            age = 18;
        System.out.println("Can't rent in this section");
        return age;
        
    }

    public String getId() {
        return id;
    }
    
    public String getInfor()
    {
      return infor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.age;
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
        final Teen other = (Teen) obj;
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

 
    
}

 
//    public String infor()
//    {
//      String[] custInfo = {"Aza", "0747444826 ", "235BricStr"};
//      //custInfo = {"Nobubele", "0747444826 ", "235 Bric Str"};
//      return custInfo[2];
//    }

