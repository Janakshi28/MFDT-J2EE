/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lk.megafundtpark.remote.utils.PayablesDetails;
import lk.megafundtpark.remote.utils.PayedItemDetails;

/**
 *
 * @author Janakshi
 */
@Entity
@Table(name = "PHOTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photos.findAll", query = "SELECT p FROM Photos p")
    , @NamedQuery(name = "Photos.findByPhotoid", query = "SELECT p FROM Photos p WHERE p.photoid = :photoid")
    , @NamedQuery(name = "Photos.findByIsframed", query = "SELECT p FROM Photos p WHERE p.isframed = :isframed")
    , @NamedQuery(name = "Photos.findByIsenlarged", query = "SELECT p FROM Photos p WHERE p.isenlarged = :isenlarged")
    , @NamedQuery(name = "Photos.findByIsedited", query = "SELECT p FROM Photos p WHERE p.isedited = :isedited")
        , @NamedQuery(name = "Photos.findByBandId", query = "SELECT p FROM Photos p WHERE p.ebands.bandid = :bandid")
})
public class Photos  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PHOTOID")
    private Integer photoid;
    @Column(name = "ISFRAMED")
    private Boolean isframed;
    @Column(name = "ISENLARGED")
    private Boolean isenlarged;
    @Column(name = "ISEDITED")
    private Boolean isedited;
    @Size(max = 40)
    @Column(name = "PIC")
    private String pic;
    @JoinColumn(name = "BANDID", referencedColumnName = "BANDID")
    @ManyToOne
    private Ebands ebands;

    public Photos() {
    }

    public Photos(Integer photoid) {
        this.photoid = photoid;
    }

    public Photos(Integer photoid, Boolean isframed, Boolean isenlarged, Boolean isedited, String pic) {
        this.photoid = photoid;
        this.isframed = isframed;
        this.isenlarged = isenlarged;
        this.isedited = isedited;
        this.pic = pic;
    }

    public Photos(Boolean isframed, Boolean isenlarged, Boolean isedited, String pic) {
        this.isframed = isframed;
        this.isenlarged = isenlarged;
        this.isedited = isedited;
        this.pic = pic;
    }
    
    

    public Photos(Boolean isframed, Boolean isenlarged, Boolean isedited, String pic, Ebands ebands) {
        this.isframed = isframed;
        this.isenlarged = isenlarged;
        this.isedited = isedited;
        this.pic = pic;
        this.ebands = ebands;
    }
    
    

    public Photos(Integer photoid, Boolean isframed, Boolean isenlarged, Boolean isedited, String pic, Ebands ebands) {
        this.photoid = photoid;
        this.isframed = isframed;
        this.isenlarged = isenlarged;
        this.isedited = isedited;
        this.pic = pic;
        this.ebands = ebands;
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


    public Ebands getEbands() {
        return ebands;
    }

    public void setEbands(Ebands ebands) {
        this.ebands = ebands;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (photoid != null ? photoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photos)) {
            return false;
        }
        Photos other = (Photos) object;
        if ((this.photoid == null && other.photoid != null) || (this.photoid != null && !this.photoid.equals(other.photoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.megafundtpark.entities.Photos[ photoid=" + photoid + " ]";
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    
}
