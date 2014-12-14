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
@Table(name = "educationallevel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Educationallevel.findAll", query = "SELECT e FROM Educationallevel e"),
    @NamedQuery(name = "Educationallevel.findByElevelid", query = "SELECT e FROM Educationallevel e WHERE e.elevelid = :elevelid"),
    @NamedQuery(name = "Educationallevel.findByEleveldesc", query = "SELECT e FROM Educationallevel e WHERE e.eleveldesc = :eleveldesc")})
public class Educationallevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "elevelid")
    private Integer elevelid;
    @Size(max = 50)
    @Column(name = "eleveldesc")
    private String eleveldesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elevelid")
    private List<Person> personList;

    public Educationallevel() {
    }

    public Educationallevel(Integer elevelid) {
        this.elevelid = elevelid;
    }

    public Integer getElevelid() {
        return elevelid;
    }

    public void setElevelid(Integer elevelid) {
        this.elevelid = elevelid;
    }

    public String getEleveldesc() {
        return eleveldesc;
    }

    public void setEleveldesc(String eleveldesc) {
        this.eleveldesc = eleveldesc;
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
        hash += (elevelid != null ? elevelid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Educationallevel)) {
            return false;
        }
        Educationallevel other = (Educationallevel) object;
        if ((this.elevelid == null && other.elevelid != null) || (this.elevelid != null && !this.elevelid.equals(other.elevelid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Educationallevel[ elevelid=" + elevelid + " ]";
    }
    
}
