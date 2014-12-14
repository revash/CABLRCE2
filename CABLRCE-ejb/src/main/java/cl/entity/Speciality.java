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
@Table(name = "speciality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Speciality.findAll", query = "SELECT s FROM Speciality s"),
    @NamedQuery(name = "Speciality.findBySpecialityid", query = "SELECT s FROM Speciality s WHERE s.specialityid = :specialityid"),
    @NamedQuery(name = "Speciality.findBySpecialityname", query = "SELECT s FROM Speciality s WHERE s.specialityname = :specialityname")})
public class Speciality implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "specialityid")
    private Integer specialityid;
    @Size(max = 50)
    @Column(name = "specialityname")
    private String specialityname;
    @JoinColumn(name = "unitid", referencedColumnName = "unitid")
    @ManyToOne(optional = false)
    private Unit unitid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialityid")
    private List<Professional> professionalList;

    public Speciality() {
    }

    public Speciality(Integer specialityid) {
        this.specialityid = specialityid;
    }

    public Integer getSpecialityid() {
        return specialityid;
    }

    public void setSpecialityid(Integer specialityid) {
        this.specialityid = specialityid;
    }

    public String getSpecialityname() {
        return specialityname;
    }

    public void setSpecialityname(String specialityname) {
        this.specialityname = specialityname;
    }

    public Unit getUnitid() {
        return unitid;
    }

    public void setUnitid(Unit unitid) {
        this.unitid = unitid;
    }

    @XmlTransient
    public List<Professional> getProfessionalList() {
        return professionalList;
    }

    public void setProfessionalList(List<Professional> professionalList) {
        this.professionalList = professionalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specialityid != null ? specialityid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Speciality)) {
            return false;
        }
        Speciality other = (Speciality) object;
        if ((this.specialityid == null && other.specialityid != null) || (this.specialityid != null && !this.specialityid.equals(other.specialityid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Speciality[ specialityid=" + specialityid + " ]";
    }
    
}
