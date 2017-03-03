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
import lk.megafundtpark.remote.utils.PayablesDetails;
import lk.megafundtpark.remote.utils.PayedItemDetails;

/**
 *
 * @author Janakshi
 */
@Entity
@Table(name = "ELOCKERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elockers.findAll", query = "SELECT e FROM Elockers e")
    , @NamedQuery(name = "Elockers.findByLockerid", query = "SELECT e FROM Elockers e WHERE e.lockerid = :lockerid")
    , @NamedQuery(name = "Elockers.findBySize", query = "SELECT e FROM Elockers e WHERE e.size = :size")
    , @NamedQuery(name = "Elockers.findByIsoccupied", query = "SELECT e FROM Elockers e WHERE e.isoccupied = :isoccupied")
    , @NamedQuery(name = "Elockers.findByReserved", query = "SELECT e FROM Elockers e WHERE e.isoccupied = :isoccupied")
     , @NamedQuery(name = "Elockers.findByBandByReserved", query = "SELECT e FROM Elockers e WHERE e.isoccupied = :isoccupied AND e.ebands.bandid = :bandid")    
   , @NamedQuery(name = "Elockers.findByNotReserved", query = "SELECT e FROM Elockers e WHERE e.isoccupied = :isoccupied")     
})
public class Elockers  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOCKERID")
    private Integer lockerid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "SIZE")
    private String size;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISOCCUPIED")
    private Boolean isoccupied;
    @JoinColumn(name = "BANDID", referencedColumnName = "BANDID")
    @ManyToOne
    private Ebands ebands;

    public Elockers() {
    }

    public Elockers(Integer lockerid) {
        this.lockerid = lockerid;
    }

    public Elockers(Integer lockerid, String size, Boolean isoccupied) {
        this.lockerid = lockerid;
        this.size = size;
        this.isoccupied = isoccupied;
    }

    public Elockers(String size, Boolean isoccupied, Ebands ebands) {
        this.size = size;
        this.isoccupied = isoccupied;
        this.ebands = ebands;
    }
    
    

    public Elockers(Integer lockerid, String size, Boolean isoccupied, Ebands ebands) {
        this.lockerid = lockerid;
        this.size = size;
        this.isoccupied = isoccupied;
        this.ebands = ebands;
    }
    
    

    public Integer getLockerid() {
        return lockerid;
    }

    public void setLockerid(Integer lockerid) {
        this.lockerid = lockerid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getIsoccupied() {
        return isoccupied;
    }

    public void setIsoccupied(Boolean isoccupied) {
        this.isoccupied = isoccupied;
    }

    public Ebands getEbands() {
        return ebands;
    }

    public void setEbands(Ebands ebands) {
        this.ebands= ebands;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lockerid != null ? lockerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elockers)) {
            return false;
        }
        Elockers other = (Elockers) object;
        if ((this.lockerid == null && other.lockerid != null) || (this.lockerid != null && !this.lockerid.equals(other.lockerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.megafundtpark.entities.Elockers[ lockerid=" + lockerid + " ]";
    }
    
}
