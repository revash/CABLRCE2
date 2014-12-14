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
@Table(name = "maritalstatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maritalstatus.findAll", query = "SELECT m FROM Maritalstatus m"),
    @NamedQuery(name = "Maritalstatus.findByMaritalstatusid", query = "SELECT m FROM Maritalstatus m WHERE m.maritalstatusid = :maritalstatusid"),
    @NamedQuery(name = "Maritalstatus.findByMaritalstatusname", query = "SELECT m FROM Maritalstatus m WHERE m.maritalstatusname = :maritalstatusname")})
public class Maritalstatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "maritalstatusid")
    private Integer maritalstatusid;
    @Size(max = 50)
    @Column(name = "maritalstatusname")
    private String maritalstatusname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maritalstatusid")
    private List<Person> personList;

    public Maritalstatus() {
    }

    public Maritalstatus(Integer maritalstatusid) {
        this.maritalstatusid = maritalstatusid;
    }

    public Integer getMaritalstatusid() {
        return maritalstatusid;
    }

    public void setMaritalstatusid(Integer maritalstatusid) {
        this.maritalstatusid = maritalstatusid;
    }

    public String getMaritalstatusname() {
        return maritalstatusname;
    }

    public void setMaritalstatusname(String maritalstatusname) {
        this.maritalstatusname = maritalstatusname;
    }

    @XmlTransient
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maritalstatusid != null ? maritalstatusid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maritalstatus)) {
            return false;
        }
        Maritalstatus other = (Maritalstatus) object;
        if ((this.maritalstatusid == null && other.maritalstatusid != null) || (this.maritalstatusid != null && !this.maritalstatusid.equals(other.maritalstatusid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Maritalstatus[ maritalstatusid=" + maritalstatusid + " ]";
    }
    
}
