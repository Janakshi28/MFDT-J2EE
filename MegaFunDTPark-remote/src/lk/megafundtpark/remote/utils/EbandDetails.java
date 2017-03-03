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
public class EbandDetails implements Serializable {
    private Integer bandid;
    private int total;
    private int ticketId;

    public EbandDetails() {
    }

    public EbandDetails(int total, int ticketId) {
        this.total = total;
        this.ticketId = ticketId;
    }
    
    
    
    public EbandDetails(Integer bandid, int total, int ticketId) {
        this.bandid = bandid;
        this.total = total;
        this.ticketId = ticketId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getBandid() {
        return bandid;
    }

    public void setBandid(Integer bandid) {
        this.bandid = bandid;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
}
