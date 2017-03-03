/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Janakshi
 */
@Entity
@Table(name = "TICKETS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tickets.findAll", query = "SELECT t FROM Tickets t")
    , @NamedQuery(name = "Tickets.findByTicketid", query = "SELECT t FROM Tickets t WHERE t.ticketid = :ticketid")
    , @NamedQuery(name = "Tickets.findByType", query = "SELECT t FROM Tickets t WHERE t.type = :type")
    , @NamedQuery(name = "Tickets.findByIssueddate", query = "SELECT t FROM Tickets t WHERE t.issueddate = :issueddate")
    , @NamedQuery(name = "Tickets.findByPrice", query = "SELECT t FROM Tickets t WHERE t.price = :price")
    , @NamedQuery(name = "Tickets.findByCustomerIdByIssuedDate", query = "SELECT t FROM Tickets t WHERE t.customers.customerid = :customerid AND t.issueddate= :issueddate")    
})
public class Tickets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TICKETID")
    private Integer ticketid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISSUEDDATE")
    @Temporal(TemporalType.DATE)
    private Date issueddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private int price;
    @JoinColumn(name = "ADMINID", referencedColumnName = "USERID")
    @ManyToOne
    private Admins admins;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "CUSTOMERID")
    @ManyToOne
    private Customers customers;
    @OneToMany(mappedBy = "tickets")
    private Collection<Ebands> ebandsCollection;

    public Tickets() {
    }

    public Tickets(Integer ticketid) {
        this.ticketid = ticketid;
    }

    public Tickets(Integer ticketid, String type, Date issueddate, int price) {
        this.ticketid = ticketid;
        this.type = type;
        this.issueddate = issueddate;
        this.price = price;
    }

    public Tickets(String type, Date issueddate, int price) {
        this.type = type;
        this.issueddate = issueddate;
        this.price = price;
    }
    
    

    public Tickets(Integer ticketid, String type, Date issueddate, int price, Admins admins, Customers customers) {
        this.ticketid = ticketid;
        this.type = type;
        this.issueddate = issueddate;
        this.price = price;
        this.admins = admins;
        this.customers = customers;
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

    public Admins getAdmins() {
        return admins;
    }

    public void setAdmins(Admins admins) {
        this.admins = admins;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    @XmlTransient
    public Collection<Ebands> getEbandsCollection() {
        return ebandsCollection;
    }

    public void setEbandsCollection(Collection<Ebands> ebandsCollection) {
        this.ebandsCollection = ebandsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketid != null ? ticketid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tickets)) {
            return false;
        }
        Tickets other = (Tickets) object;
        if ((this.ticketid == null && other.ticketid != null) || (this.ticketid != null && !this.ticketid.equals(other.ticketid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.megafundtpark.entities.Tickets[ ticketid=" + ticketid + " ]";
    }
    
}
