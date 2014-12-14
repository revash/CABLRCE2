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
@Table(name = "tipehypothesis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipehypothesis.findAll", query = "SELECT t FROM Tipehypothesis t"),
    @NamedQuery(name = "Tipehypothesis.findByHypothesisid", query = "SELECT t FROM Tipehypothesis t WHERE t.hypothesisid = :hypothesisid"),
    @NamedQuery(name = "Tipehypothesis.findByHypothesisname", query = "SELECT t FROM Tipehypothesis t WHERE t.hypothesisname = :hypothesisname")})
public class Tipehypothesis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "hypothesisid")
    private Integer hypothesisid;
    @Size(max = 100)
    @Column(name = "hypothesisname")
    private String hypothesisname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hypothesisid")
    private List<Medicalhypothesis> medicalhypothesisList;

    public Tipehypothesis() {
    }

    public Tipehypothesis(Integer hypothesisid) {
        this.hypothesisid = hypothesisid;
    }

    public Integer getHypothesisid() {
        return hypothesisid;
    }

    public void setHypothesisid(Integer hypothesisid) {
        this.hypothesisid = hypothesisid;
    }

    public String getHypothesisname() {
        return hypothesisname;
    }

    public void setHypothesisname(String hypothesisname) {
        this.hypothesisname = hypothesisname;
    }

    @XmlTransient
    public List<Medicalhypothesis> getMedicalhypothesisList() {
        return medicalhypothesisList;
    }

    public void setMedicalhypothesisList(List<Medicalhypothesis> medicalhypothesisList) {
        this.medicalhypothesisList = medicalhypothesisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hypothesisid != null ? hypothesisid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipehypothesis)) {
            return false;
        }
        Tipehypothesis other = (Tipehypothesis) object;
        if ((this.hypothesisid == null && other.hypothesisid != null) || (this.hypothesisid != null && !this.hypothesisid.equals(other.hypothesisid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Tipehypothesis[ hypothesisid=" + hypothesisid + " ]";
    }
    
}
