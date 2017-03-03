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
public class AdminDetails implements Serializable {
        private String userid;
        private String password;
        private String name;
        private short role;

    public AdminDetails() {
    }
    
    public AdminDetails(String userid, String password, String name, short role) {
        this.userid = userid;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public short getRole() {
        return role;
    }


    public void setRole(short role) {
        this.role = role;
    }
        
    
    
    
}
