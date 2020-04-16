/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agis;

/**
 *
 * @author Lenovo
 */
public class Person {
    private long Id;
    private String FirstName;
    private String LastName;

    public Person(long Id, String FirstName, String LastName) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public long getId() {
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    @Override
    public String toString() {
        return "Person{" + "Id=" + Id + ", FirstName=" + FirstName + ", LastName=" + LastName + '}';
    }
    
    
    
}
