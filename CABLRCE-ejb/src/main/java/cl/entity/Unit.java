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
@Table(name = "unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u"),
    @NamedQuery(name = "Unit.findByUnitid", query = "SELECT u FROM Unit u WHERE u.unitid = :unitid"),
    @NamedQuery(name = "Unit.findByUnitname", query = "SELECT u FROM Unit u WHERE u.unitname = :unitname")})
public class Unit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "unitid")
    private Integer unitid;
    @Size(max = 50)
    @Column(name = "unitname")
    private String unitname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitid")
    private List<Speciality> specialityList;

    public Unit() {
    }

    public Unit(Integer unitid) {
        this.unitid = unitid;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    @XmlTransient
    public List<Speciality> getSpecialityList() {
        return specialityList;
    }

    public void setSpecialityList(List<Speciality> specialityList) {
        this.specialityList = specialityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unitid != null ? unitid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unit)) {
            return false;
        }
        Unit other = (Unit) object;
        if ((this.unitid == null && other.unitid != null) || (this.unitid != null && !this.unitid.equals(other.unitid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Unit[ unitid=" + unitid + " ]";
    }
    
}
