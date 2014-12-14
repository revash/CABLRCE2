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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tipeprevision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipeprevision.findAll", query = "SELECT t FROM Tipeprevision t"),
    @NamedQuery(name = "Tipeprevision.findByTipeprevid", query = "SELECT t FROM Tipeprevision t WHERE t.tipeprevid = :tipeprevid"),
    @NamedQuery(name = "Tipeprevision.findByTipeprevdesc", query = "SELECT t FROM Tipeprevision t WHERE t.tipeprevdesc = :tipeprevdesc")})
public class Tipeprevision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipeprevid")
    private Integer tipeprevid;
    @Size(max = 50)
    @Column(name = "tipeprevdesc")
    private String tipeprevdesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipeprevid")
    private List<Person> personList;
    @JoinColumn(name = "previd", referencedColumnName = "previd")
    @ManyToOne(optional = false)
    private Prevision previd;

    public Tipeprevision() {
    }

    public Tipeprevision(Integer tipeprevid) {
        this.tipeprevid = tipeprevid;
    }

    public Integer getTipeprevid() {
        return tipeprevid;
    }

    public void setTipeprevid(Integer tipeprevid) {
        this.tipeprevid = tipeprevid;
    }

    public String getTipeprevdesc() {
        return tipeprevdesc;
    }

    public void setTipeprevdesc(String tipeprevdesc) {
        this.tipeprevdesc = tipeprevdesc;
    }

    @XmlTransient
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Prevision getPrevid() {
        return previd;
    }

    public void setPrevid(Prevision previd) {
        this.previd = previd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipeprevid != null ? tipeprevid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipeprevision)) {
            return false;
        }
        Tipeprevision other = (Tipeprevision) object;
        if ((this.tipeprevid == null && other.tipeprevid != null) || (this.tipeprevid != null && !this.tipeprevid.equals(other.tipeprevid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Tipeprevision[ tipeprevid=" + tipeprevid + " ]";
    }
    
}
