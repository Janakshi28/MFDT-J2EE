/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.utils;

import java.io.Serializable;

/**
 *
 * @author Janakshi
 */
public class CustomerDetails implements Serializable {
        private Integer customerid;
        private String name;
        private String email;

    public CustomerDetails() {
    }

    public CustomerDetails(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    
        
    public CustomerDetails(Integer customerid, String name, String email) {
        this.customerid = customerid;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
