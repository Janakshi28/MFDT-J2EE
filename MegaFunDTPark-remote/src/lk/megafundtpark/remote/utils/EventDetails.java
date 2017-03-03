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
public class EventDetails implements Serializable{
    private Integer id;
    private String title;
    private String park;
    private Date starttime;
    private Date endtime;
    private Date dateadded;
    private String adminId;

    public EventDetails() {
    }

    public EventDetails(String title, String park, Date starttime, Date endtime, Date dateadded, String adminId) {
        this.title = title;
        this.park = park;
        this.starttime = starttime;
        this.endtime = endtime;
        this.dateadded = dateadded;
        this.adminId = adminId;
    }
    
   
    
    public EventDetails(Integer id, String title, String park, Date starttime, Date endtime, Date dateadded, String adminId) {
        this.id = id;
        this.title = title;
        this.park = park;
        this.starttime = starttime;
        this.endtime = endtime;
        this.dateadded = dateadded;
        this.adminId = adminId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }
    
    
    
}
