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
@Table(name = "bloodgroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bloodgroup.findAll", query = "SELECT b FROM Bloodgroup b"),
    @NamedQuery(name = "Bloodgroup.findByBgroupid", query = "SELECT b FROM Bloodgroup b WHERE b.bgroupid = :bgroupid"),
    @NamedQuery(name = "Bloodgroup.findByBgroupdesc", query = "SELECT b FROM Bloodgroup b WHERE b.bgroupdesc = :bgroupdesc")})
public class Bloodgroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bgroupid")
    private Integer bgroupid;
    @Size(max = 50)
    @Column(name = "bgroupdesc")
    private String bgroupdesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bgroupid")
    private List<Person> personList;

    public Bloodgroup() {
    }

    public Bloodgroup(Integer bgroupid) {
        this.bgroupid = bgroupid;
    }

    public Integer getBgroupid() {
        return bgroupid;
    }

    public void setBgroupid(Integer bgroupid) {
        this.bgroupid = bgroupid;
    }

    public String getBgroupdesc() {
        return bgroupdesc;
    }

    public void setBgroupdesc(String bgroupdesc) {
        this.bgroupdesc = bgroupdesc;
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
        hash += (bgroupid != null ? bgroupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bloodgroup)) {
            return false;
        }
        Bloodgroup other = (Bloodgroup) object;
        if ((this.bgroupid == null && other.bgroupid != null) || (this.bgroupid != null && !this.bgroupid.equals(other.bgroupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Bloodgroup[ bgroupid=" + bgroupid + " ]";
    }
    
}
