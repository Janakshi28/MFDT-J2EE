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
public class PayedItemDetails extends PayablesDetails implements Serializable {
    private Integer id;
    private String type;
    private int amount; 
    private int noofitems;
    private int ebandId;
    private int payablesId;

    public PayedItemDetails() {
    }

    public PayedItemDetails(String type, int amount, int noofitems, int ebandId, int payablesId) {
        this.type = type;
        this.amount = amount;
        this.noofitems = noofitems;
        this.ebandId = ebandId;
        this.payablesId = payablesId;
    }
    
    
    
     public PayedItemDetails(Integer id, String type, int amount, int noofitems, int ebandId, int payablesId) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.noofitems = noofitems;
        this.ebandId = ebandId;
        this.payablesId = payablesId;
    }

    public int getPayablesId() {
        return payablesId;
    }

    public void setPayablesId(int payablesId) {
        this.payablesId = payablesId;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getNoofitems() {
        return noofitems;
    }

    public void setNoofitems(int noofitems) {
        this.noofitems = noofitems;
    }

    public int getEbandId() {
        return ebandId;
    }

    public void setEbandId(int ebandId) {
        this.ebandId = ebandId;
    }
     
     
    
}
