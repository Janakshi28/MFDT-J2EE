/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Janakshi
 */
@Entity
@Table(name = "EBANDS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ebands.findAll", query = "SELECT e FROM Ebands e")
    , @NamedQuery(name = "Ebands.findByBandid", query = "SELECT e FROM Ebands e WHERE e.bandid = :bandid")
    , @NamedQuery(name = "Ebands.findByTotal", query = "SELECT e FROM Ebands e WHERE e.total = :total")
    , @NamedQuery(name = "Ebands.findByTicketId", query = "SELECT e FROM Ebands e WHERE e.tickets.ticketid = :ticketid")     
})
public class Ebands implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BANDID")
    private Integer bandid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private int total;
    @OneToMany(mappedBy = "ebands")
    private Collection<Photos> photosCollection;
    @OneToMany(mappedBy = "ebands")
    private Collection<Elockers> elockersCollection;
    @OneToMany(mappedBy = "ebands")
    private Collection<Payeditems> payeditemsCollection;
    @JoinColumn(name = "TICKETID", referencedColumnName = "TICKETID")
    @ManyToOne
    private Tickets tickets;

    public Ebands() {
    }

    public Ebands(Integer bandid) {
        this.bandid = bandid;
    }

    public Ebands(Integer bandid, int total) {
        this.bandid = bandid;
        this.total = total;
    }
    
     public Ebands(int total) {
        this.total = total;
    }

    public Ebands(int total, Tickets tickets) {
        this.total = total;
        this.tickets = tickets;
    }
    

    public Ebands(Integer bandid, int total, Tickets tickets) {
        this.bandid = bandid;
        this.total = total;
        this.tickets= tickets;
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

    @XmlTransient
    public Collection<Photos> getPhotosCollection() {
        return photosCollection;
    }

    public void setPhotosCollection(Collection<Photos> photosCollection) {
        this.photosCollection = photosCollection;
    }

    @XmlTransient
    public Collection<Elockers> getElockersCollection() {
        return elockersCollection;
    }

    public void setElockersCollection(Collection<Elockers> elockersCollection) {
        this.elockersCollection = elockersCollection;
    }

    @XmlTransient
    public Collection<Payeditems> getPayeditemsCollection() {
        return payeditemsCollection;
    }

    public void setPayeditemsCollection(Collection<Payeditems> payeditemsCollection) {
        this.payeditemsCollection = payeditemsCollection;
    }

    public Tickets getTickets() {
        return tickets;
    }

    public void setTicketscb005871(Tickets tickets) {
        this.tickets = tickets;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bandid != null ? bandid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ebands)) {
            return false;
        }
        Ebands other = (Ebands) object;
        if ((this.bandid == null && other.bandid != null) || (this.bandid != null && !this.bandid.equals(other.bandid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.megafundtpark.entities.Ebands[ bandid=" + bandid + " ]";
    }
    
}
