/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Janakshi
 */
@Entity
@Table(name = "EVENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Events.findAll", query = "SELECT e FROM Events e")
    , @NamedQuery(name = "Events.findById", query = "SELECT e FROM Events e WHERE e.id = :id")
    , @NamedQuery(name = "Events.findByTitle", query = "SELECT e FROM Events e WHERE e.title = :title")
    , @NamedQuery(name = "Events.findByPark", query = "SELECT e FROM Events e WHERE e.park = :park")
    , @NamedQuery(name = "Events.findByStarttime", query = "SELECT e FROM Events e WHERE e.starttime = :starttime")
    , @NamedQuery(name = "Events.findByEndtime", query = "SELECT e FROM Events e WHERE e.endtime = :endtime")
    , @NamedQuery(name = "Events.findByDateadded", query = "SELECT e FROM Events e WHERE e.dateadded = :dateadded")
    , @NamedQuery(name = "Events.findByTitleByAdminId", query = "SELECT e FROM Events e WHERE e.title = :title AND e.admins.userid = :adminId")
})
public class Events implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 20)
    @Column(name = "PARK")
    private String park;
    @Column(name = "STARTTIME")
    @Temporal(TemporalType.TIME)
    private Date starttime;
    @Column(name = "ENDTIME")
    @Temporal(TemporalType.TIME)
    private Date endtime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.DATE)
    private Date dateadded;
    @JoinColumn(name = "ADMINID", referencedColumnName = "USERID")
    @ManyToOne
    private Admins admins;

    public Events() {
    }

    public Events(Integer id) {
        this.id = id;
    }

    public Events(Integer id, String title, Date dateadded) {
        this.id = id;
        this.title = title;
        this.dateadded = dateadded;
    }

    public Events(Integer id, String title, String park, Date starttime, Date endtime, Date dateadded) {
        this.id = id;
        this.title = title;
        this.park = park;
        this.starttime = starttime;
        this.endtime = endtime;
        this.dateadded = dateadded;
    }

    public Events(String title, String park, Date starttime, Date endtime, Date dateadded) {
        this.title = title;
        this.park = park;
        this.starttime = starttime;
        this.endtime = endtime;
        this.dateadded = dateadded;
    }
    
    

    public Events(String title, String park, Date starttime, Date endtime, Date dateadded, Admins admins) {
        this.title = title;
        this.park = park;
        this.starttime = starttime;
        this.endtime = endtime;
        this.dateadded = dateadded;
        this.admins = admins;
    }
    
    

    public Events(Integer id, String title, String park, Date starttime, Date endtime, Date dateadded, Admins admins) {
        this.id = id;
        this.title = title;
        this.park = park;
        this.starttime = starttime;
        this.endtime = endtime;
        this.dateadded = dateadded;
        this.admins = admins;
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

    public Admins getAdmins() {
        return admins;
    }

    public void setAdmins(Admins admins) {
        this.admins = admins;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Events)) {
            return false;
        }
        Events other = (Events) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.megafundtpark.entities.Events[ id=" + id + " ]";
    }
    
}
