/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AndresEduardo
 */
@Embeddable
public class PersonPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut")
    private int rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "dv")
    private String dv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nationalityid")
    private int nationalityid;

    public PersonPK() {
    }

    public PersonPK(int rut, String dv, int nationalityid) {
        this.rut = rut;
        this.dv = dv;
        this.nationalityid = nationalityid;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public int getNationalityid() {
        return nationalityid;
    }

    public void setNationalityid(int nationalityid) {
        this.nationalityid = nationalityid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rut;
        hash += (dv != null ? dv.hashCode() : 0);
        hash += (int) nationalityid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonPK)) {
            return false;
        }
        PersonPK other = (PersonPK) object;
        if (this.rut != other.rut) {
            return false;
        }
        if ((this.dv == null && other.dv != null) || (this.dv != null && !this.dv.equals(other.dv))) {
            return false;
        }
        if (this.nationalityid != other.nationalityid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.PersonPK[ rut=" + rut + ", dv=" + dv + ", nationalityid=" + nationalityid + " ]";
    }
    
}
