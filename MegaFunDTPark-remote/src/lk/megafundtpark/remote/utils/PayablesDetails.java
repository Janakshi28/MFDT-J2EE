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
public class PayablesDetails implements Serializable {
    private Integer id;
    private String type;
    private String title;
    private int fee;

    public PayablesDetails() {
    }

    public PayablesDetails(String type, String title, int fee) {
        this.type = type;
        this.title = title;
        this.fee = fee;
    }
    
    
      
     public PayablesDetails(Integer id, String type, String title, int fee) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.fee = fee;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
     
     
    
}
