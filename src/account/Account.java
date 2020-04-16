/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agis;

import java.util.Objects;

/**
 *
 * @author Lenovo
 */
class Account {
    private long Id;
    private String password;
    private Person person;
    private Position position;

    public Account(long Id, String password, Person person, Position position) {
        this.Id = Id;
        this.password = password;
        this.person = person;
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.person, other.person)) {
            return false;
        }
        if (this.position != other.position) {
            return false;
        }
        return true;
    }
    
    
}
