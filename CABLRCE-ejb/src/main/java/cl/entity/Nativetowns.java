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
@Table(name = "nativetowns")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nativetowns.findAll", query = "SELECT n FROM Nativetowns n"),
    @NamedQuery(name = "Nativetowns.findByNativetownsid", query = "SELECT n FROM Nativetowns n WHERE n.nativetownsid = :nativetownsid"),
    @NamedQuery(name = "Nativetowns.findByNativetownsname", query = "SELECT n FROM Nativetowns n WHERE n.nativetownsname = :nativetownsname")})
public class Nativetowns implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nativetownsid")
    private Integer nativetownsid;
    @Size(max = 100)
    @Column(name = "nativetownsname")
    private String nativetownsname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nativetownsid")
    private List<Person> personList;

    public Nativetowns() {
    }

    public Nativetowns(Integer nativetownsid) {
        this.nativetownsid = nativetownsid;
    }

    public Integer getNativetownsid() {
        return nativetownsid;
    }

    public void setNativetownsid(Integer nativetownsid) {
        this.nativetownsid = nativetownsid;
    }

    public String getNativetownsname() {
        return nativetownsname;
    }

    public void setNativetownsname(String nativetownsname) {
        this.nativetownsname = nativetownsname;
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
        hash += (nativetownsid != null ? nativetownsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nativetowns)) {
            return false;
        }
        Nativetowns other = (Nativetowns) object;
        if ((this.nativetownsid == null && other.nativetownsid != null) || (this.nativetownsid != null && !this.nativetownsid.equals(other.nativetownsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Nativetowns[ nativetownsid=" + nativetownsid + " ]";
    }
    
}
