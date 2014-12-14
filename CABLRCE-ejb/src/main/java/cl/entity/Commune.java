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
@Table(name = "commune")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commune.findAll", query = "SELECT c FROM Commune c"),
    @NamedQuery(name = "Commune.findByCommuneid", query = "SELECT c FROM Commune c WHERE c.communeid = :communeid"),
    @NamedQuery(name = "Commune.findByCommunename", query = "SELECT c FROM Commune c WHERE c.communename = :communename")})
public class Commune implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "communeid")
    private Integer communeid;
    @Size(max = 50)
    @Column(name = "communename")
    private String communename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "communeid")
    private List<Person> personList;
    @JoinColumn(name = "cityid", referencedColumnName = "cityid")
    @ManyToOne(optional = false)
    private City cityid;

    public Commune() {
    }

    public Commune(Integer communeid) {
        this.communeid = communeid;
    }

    public Integer getCommuneid() {
        return communeid;
    }

    public void setCommuneid(Integer communeid) {
        this.communeid = communeid;
    }

    public String getCommunename() {
        return communename;
    }

    public void setCommunename(String communename) {
        this.communename = communename;
    }

    @XmlTransient
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public City getCityid() {
        return cityid;
    }

    public void setCityid(City cityid) {
        this.cityid = cityid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (communeid != null ? communeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commune)) {
            return false;
        }
        Commune other = (Commune) object;
        if ((this.communeid == null && other.communeid != null) || (this.communeid != null && !this.communeid.equals(other.communeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Commune[ communeid=" + communeid + " ]";
    }
    
}
