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
@Table(name = "nationality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nationality.findAll", query = "SELECT n FROM Nationality n"),
    @NamedQuery(name = "Nationality.findByNationalityid", query = "SELECT n FROM Nationality n WHERE n.nationalityid = :nationalityid"),
    @NamedQuery(name = "Nationality.findByNationalityname", query = "SELECT n FROM Nationality n WHERE n.nationalityname = :nationalityname")})
public class Nationality implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nationalityid")
    private Integer nationalityid;
    @Size(max = 50)
    @Column(name = "nationalityname")
    private String nationalityname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nationality")
    private List<Person> personList;

    public Nationality() {
    }

    public Nationality(Integer nationalityid) {
        this.nationalityid = nationalityid;
    }

    public Integer getNationalityid() {
        return nationalityid;
    }

    public void setNationalityid(Integer nationalityid) {
        this.nationalityid = nationalityid;
    }

    public String getNationalityname() {
        return nationalityname;
    }

    public void setNationalityname(String nationalityname) {
        this.nationalityname = nationalityname;
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
        hash += (nationalityid != null ? nationalityid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nationality)) {
            return false;
        }
        Nationality other = (Nationality) object;
        if ((this.nationalityid == null && other.nationalityid != null) || (this.nationalityid != null && !this.nationalityid.equals(other.nationalityid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Nationality[ nationalityid=" + nationalityid + " ]";
    }
    
}
