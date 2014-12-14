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
public class ProfessionalPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut")
    private int rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "dv")
    private String dv;

    public ProfessionalPK() {
    }

    public ProfessionalPK(int rut, String dv) {
        this.rut = rut;
        this.dv = dv;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rut;
        hash += (dv != null ? dv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfessionalPK)) {
            return false;
        }
        ProfessionalPK other = (ProfessionalPK) object;
        if (this.rut != other.rut) {
            return false;
        }
        if ((this.dv == null && other.dv != null) || (this.dv != null && !this.dv.equals(other.dv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.ProfessionalPK[ rut=" + rut + ", dv=" + dv + " ]";
    }
    
}
