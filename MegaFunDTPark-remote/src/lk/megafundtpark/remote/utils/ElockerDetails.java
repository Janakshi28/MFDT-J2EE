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
public class ElockerDetails extends PayedItemDetails implements Serializable{
    
    private Integer lockerid;
    private String size;
    private Boolean isoccupied;
    private int ebandId;

    public ElockerDetails() {
    }

    public ElockerDetails(String size, Boolean isoccupied, int ebandId) {
        this.size = size;
        this.isoccupied = isoccupied;
        this.ebandId = ebandId;
    }
    
     public ElockerDetails(Integer lockerid, String size, Boolean isoccupied) {
        this.lockerid = lockerid;
        this.size = size;
        this.isoccupied = isoccupied;
    }
    
    
    public ElockerDetails(Integer lockerid, String size, Boolean isoccupied, int ebandId) {
        this.lockerid = lockerid;
        this.size = size;
        this.isoccupied = isoccupied;
        this.ebandId = ebandId;
    }

    public int getEbandId() {
        return ebandId;
    }

    public void setEbandId(int ebandId) {
        this.ebandId = ebandId;
    }

    public Integer getLockerid() {
        return lockerid;
    }

    public void setLockerid(Integer lockerid) {
        this.lockerid = lockerid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getIsoccupied() {
        return isoccupied;
    }

    public void setIsoccupied(Boolean isoccupied) {
        this.isoccupied = isoccupied;
    }
    
    
    
}
