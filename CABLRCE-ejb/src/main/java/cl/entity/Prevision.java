/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "prevision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prevision.findAll", query = "SELECT p FROM Prevision p"),
    @NamedQuery(name = "Prevision.findByPrevid", query = "SELECT p FROM Prevision p WHERE p.previd = :previd"),
    @NamedQuery(name = "Prevision.findByPrevdescription", query = "SELECT p FROM Prevision p WHERE p.prevdescription = :prevdescription")})
public class Prevision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "previd")
    private Integer previd;
    @Size(max = 50)
    @Column(name = "prevdescription")
    private String prevdescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "previd")
    private List<Tipeprevision> tipeprevisionList;

    public Prevision() {
    }

    public Prevision(Integer previd) {
        this.previd = previd;
    }

    public Integer getPrevid() {
        return previd;
    }

    public void setPrevid(Integer previd) {
        this.previd = previd;
    }

    public String getPrevdescription() {
        return prevdescription;
    }

    public void setPrevdescription(String prevdescription) {
        this.prevdescription = prevdescription;
    }

    @XmlTransient
    public List<Tipeprevision> getTipeprevisionList() {
        return tipeprevisionList;
    }

    public void setTipeprevisionList(List<Tipeprevision> tipeprevisionList) {
        this.tipeprevisionList = tipeprevisionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (previd != null ? previd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prevision)) {
            return false;
        }
        Prevision other = (Prevision) object;
        if ((this.previd == null && other.previd != null) || (this.previd != null && !this.previd.equals(other.previd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Prevision[ previd=" + previd + " ]";
    }
    
}
