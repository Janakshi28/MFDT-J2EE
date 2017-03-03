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
public class PhotoDetails extends PayedItemDetails implements Serializable {
    private Integer photoid;
    private Boolean isframed;
    private Boolean isenlarged;
    private Boolean isedited;
    private String pic;
    private int ebandId;

    public PhotoDetails() {
    }

    public PhotoDetails(Boolean isframed, Boolean isenlarged, Boolean isedited, String pic, int ebandId) {
        this.isframed = isframed;
        this.isenlarged = isenlarged;
        this.isedited = isedited;
        this.pic = pic;
        this.ebandId = ebandId;
    }
    
    
    
    public PhotoDetails(Integer photoid, Boolean isframed, Boolean isenlarged, Boolean isedited, String pic, int ebandId) {
        this.photoid = photoid;
        this.isframed = isframed;
        this.isenlarged = isenlarged;
        this.isedited = isedited;
        this.pic = pic;
        this.ebandId = ebandId;
    }

    public int getEbandId() {
        return ebandId;
    }

    public void setEbandId(int ebandId) {
        this.ebandId = ebandId;
    }

    public Integer getPhotoid() {
        return photoid;
    }

    public void setPhotoid(Integer photoid) {
        this.photoid = photoid;
    }

    public Boolean getIsframed() {
        return isframed;
    }

    public void setIsframed(Boolean isframed) {
        this.isframed = isframed;
    }

    public Boolean getIsenlarged() {
        return isenlarged;
    }

    public void setIsenlarged(Boolean isenlarged) {
        this.isenlarged = isenlarged;
    }

    public Boolean getIsedited() {
        return isedited;
    }

    public void setIsedited(Boolean isedited) {
        this.isedited = isedited;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    
    
    
}
