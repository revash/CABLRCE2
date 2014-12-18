/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author AndresEduardo
 */
@Entity
@Table(name = "tipebirths")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipebirths.findAll", query = "SELECT t FROM Tipebirths t"),
    @NamedQuery(name = "Tipebirths.findByTipebirthid", query = "SELECT t FROM Tipebirths t WHERE t.tipebirthid = :tipebirthid"),
    @NamedQuery(name = "Tipebirths.findByTipebirthdesc", query = "SELECT t FROM Tipebirths t WHERE t.tipebirthdesc = :tipebirthdesc")})
public class Tipebirths implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipebirthid")
    private Integer tipebirthid;
    @Size(max = 100)
    @Column(name = "tipebirthdesc")
    private String tipebirthdesc;
//    @OneToMany(mappedBy = "tipebirthid")
//    private List<Databirths> databirthsList;

    public Tipebirths() {
    }

    public Tipebirths(Integer tipebirthid) {
        this.tipebirthid = tipebirthid;
    }

    public Integer getTipebirthid() {
        return tipebirthid;
    }

    public void setTipebirthid(Integer tipebirthid) {
        this.tipebirthid = tipebirthid;
    }

    public String getTipebirthdesc() {
        return tipebirthdesc;
    }

    public void setTipebirthdesc(String tipebirthdesc) {
        this.tipebirthdesc = tipebirthdesc;
    }

//    @XmlTransient
//    public List<Databirths> getDatabirthsList() {
//        return databirthsList;
//    }
//
//    public void setDatabirthsList(List<Databirths> databirthsList) {
//        this.databirthsList = databirthsList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipebirthid != null ? tipebirthid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipebirths)) {
            return false;
        }
        Tipebirths other = (Tipebirths) object;
        if ((this.tipebirthid == null && other.tipebirthid != null) || (this.tipebirthid != null && !this.tipebirthid.equals(other.tipebirthid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Tipebirths[ tipebirthid=" + tipebirthid + " ]";
    }
    
}
