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
@Table(name = "religion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Religion.findAll", query = "SELECT r FROM Religion r"),
    @NamedQuery(name = "Religion.findByReligionid", query = "SELECT r FROM Religion r WHERE r.religionid = :religionid"),
    @NamedQuery(name = "Religion.findByReligionname", query = "SELECT r FROM Religion r WHERE r.religionname = :religionname")})
public class Religion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "religionid")
    private Integer religionid;
    @Size(max = 50)
    @Column(name = "religionname")
    private String religionname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "religionid")
    private List<Person> personList;

    public Religion() {
    }

    public Religion(Integer religionid) {
        this.religionid = religionid;
    }

    public Integer getReligionid() {
        return religionid;
    }

    public void setReligionid(Integer religionid) {
        this.religionid = religionid;
    }

    public String getReligionname() {
        return religionname;
    }

    public void setReligionname(String religionname) {
        this.religionname = religionname;
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
        hash += (religionid != null ? religionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Religion)) {
            return false;
        }
        Religion other = (Religion) object;
        if ((this.religionid == null && other.religionid != null) || (this.religionid != null && !this.religionid.equals(other.religionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Religion[ religionid=" + religionid + " ]";
    }
    
}
