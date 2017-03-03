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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Janakshi
 */
@Entity
@Table(name = "PAYABLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payables.findAll", query = "SELECT p FROM Payables p")
    , @NamedQuery(name = "Payables.findById", query = "SELECT p FROM Payables p WHERE p.id = :id")
    , @NamedQuery(name = "Payables.findByType", query = "SELECT p FROM Payables p WHERE p.type = :type")
    , @NamedQuery(name = "Payables.findByTitle", query = "SELECT p FROM Payables p WHERE p.title = :title")
    , @NamedQuery(name = "Payables.findByFee", query = "SELECT p FROM Payables p WHERE p.fee = :fee")
    , @NamedQuery(name = "Payables.findByTypeByTitle", query = "SELECT p FROM Payables p WHERE p.type = :type AND p.title = :title")
})
public class Payables implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TYPE")
    private String type;
    @Size(max = 25)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEE")
    private int fee;
    @OneToMany(mappedBy = "payables")
    private Collection<Payeditems> payeditemsCollection;

    public Payables() {
    }

    public Payables(Integer id) {
        this.id = id;
    }

    public Payables(Integer id, String type, int fee) {
        this.id = id;
        this.type = type;
        this.fee = fee;
    }

    public Payables(String type, String title, int fee) {
        this.type = type;
        this.title = title;
        this.fee = fee;
    }
    
    

    public Payables(Integer id, String type, String title, int fee) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.fee = fee;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @XmlTransient
    public Collection<Payeditems> getPayeditemsCollection() {
        return payeditemsCollection;
    }

    public void setPayeditemsCollection(Collection<Payeditems> payeditemsCollection) {
        this.payeditemsCollection = payeditemsCollection;
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
        if (!(object instanceof Payables)) {
            return false;
        }
        Payables other = (Payables) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.megafundtpark.entities.Payables[ id=" + id + " ]";
    }
    
}
