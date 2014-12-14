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
@Table(name = "sex")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sex.findAll", query = "SELECT s FROM Sex s"),
    @NamedQuery(name = "Sex.findBySexid", query = "SELECT s FROM Sex s WHERE s.sexid = :sexid"),
    @NamedQuery(name = "Sex.findBySexdescription", query = "SELECT s FROM Sex s WHERE s.sexdescription = :sexdescription")})
public class Sex implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexid")
    private Integer sexid;
    @Size(max = 50)
    @Column(name = "sexdescription")
    private String sexdescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sexid")
    private List<Person> personList;

    public Sex() {
    }

    public Sex(Integer sexid) {
        this.sexid = sexid;
    }

    public Integer getSexid() {
        return sexid;
    }

    public void setSexid(Integer sexid) {
        this.sexid = sexid;
    }

    public String getSexdescription() {
        return sexdescription;
    }

    public void setSexdescription(String sexdescription) {
        this.sexdescription = sexdescription;
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
        hash += (sexid != null ? sexid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sex)) {
            return false;
        }
        Sex other = (Sex) object;
        if ((this.sexid == null && other.sexid != null) || (this.sexid != null && !this.sexid.equals(other.sexid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Sex[ sexid=" + sexid + " ]";
    }
    
}
