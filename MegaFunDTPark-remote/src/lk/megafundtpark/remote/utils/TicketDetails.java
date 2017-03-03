/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.utils;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Janakshi
 */
public class TicketDetails implements Serializable {
    private Integer ticketid;
    private String type;
    private Date issueddate;
    private int price;
    private String adminId;
    private int customerId;

    public TicketDetails() {
    }

    public TicketDetails(String type, Date issueddate, int price, String adminId, int customerId) {
        this.type = type;
        this.issueddate = issueddate;
        this.price = price;
        this.adminId = adminId;
        this.customerId = customerId;
    }
    
    
    
    public TicketDetails(Integer ticketid, String type, Date issueddate, int price, String adminId, int customerId) {
        this.ticketid = ticketid;
        this.type = type;
        this.issueddate = issueddate;
        this.price = price;
        this.adminId = adminId;
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Integer getTicketid() {
        return ticketid;
    }

    public void setTicketid(Integer ticketid) {
        this.ticketid = ticketid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getIssueddate() {
        return issueddate;
    }

    public void setIssueddate(Date issueddate) {
        this.issueddate = issueddate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    
    
    
}
