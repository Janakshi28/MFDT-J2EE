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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Janakshi
 */
@Entity
@Table(name = "PAYEDITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payeditems.findAll", query = "SELECT p FROM Payeditems p")
    , @NamedQuery(name = "Payeditems.findById", query = "SELECT p FROM Payeditems p WHERE p.id = :id")
    , @NamedQuery(name = "Payeditems.findByType", query = "SELECT p FROM Payeditems p WHERE p.type = :type")
    , @NamedQuery(name = "Payeditems.findByAmount", query = "SELECT p FROM Payeditems p WHERE p.amount = :amount")
    , @NamedQuery(name = "Payeditems.findByNoofitems", query = "SELECT p FROM Payeditems p WHERE p.noofitems = :noofitems")
    , @NamedQuery(name = "Payeditems.findByBandId", query = "SELECT p FROM Payeditems p WHERE p.ebands.bandid = :bandid")
})
public class Payeditems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOOFITEMS")
    private int noofitems;
    @JoinColumn(name = "BANDID", referencedColumnName = "BANDID")
    @ManyToOne
    private Ebands ebands;
    @JoinColumn(name = "PAYID", referencedColumnName = "ID")
    @ManyToOne
    private Payables payables;

    public Payeditems() {
    }

    public Payeditems(Integer id) {
        this.id = id;
    }

    public Payeditems(Integer id, String type, int amount, int noofitems) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.noofitems = noofitems;
    }
    
     public Payeditems(String type, int amount, int noofitems) {
        this.type = type;
        this.amount = amount;
        this.noofitems = noofitems;
    }
    
    
    public Payeditems(String type, int amount, int noofitems, Ebands ebands, Payables payables) {
        this.type = type;
        this.amount = amount;
        this.noofitems = noofitems;
        this.ebands = ebands;
        this.payables = payables;
    }
    
    

    public Payeditems(Integer id, String type, int amount, int noofitems, Ebands ebands, Payables payables) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.noofitems = noofitems;
        this.ebands = ebands;
        this.payables = payables;
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

    public Ebands getEbands() {
        return ebands;
    }

    public void setEbands(Ebands ebands) {
        this.ebands = ebands;
    }

    public Payables getPayables() {
        return payables;
    }

    public void setPayables(Payables payables) {
        this.payables = payables;
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
        if (!(object instanceof Payeditems)) {
            return false;
        }
        Payeditems other = (Payeditems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.megafundtpark.entities.Payeditems[ id=" + id + " ]";
    }
    
}
