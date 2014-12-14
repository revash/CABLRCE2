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
public class MedicalhypothesisPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "medicalhypothesisid")
    private int medicalhypothesisid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "episodeid")
    private int episodeid;
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
    @Column(name = "recordnumber")
    private int recordnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nationalityid")
    private int nationalityid;

    public MedicalhypothesisPK() {
    }

    public MedicalhypothesisPK(int medicalhypothesisid, int episodeid, int rut, String dv, int recordnumber, int nationalityid) {
        this.medicalhypothesisid = medicalhypothesisid;
        this.episodeid = episodeid;
        this.rut = rut;
        this.dv = dv;
        this.recordnumber = recordnumber;
        this.nationalityid = nationalityid;
    }

    public int getMedicalhypothesisid() {
        return medicalhypothesisid;
    }

    public void setMedicalhypothesisid(int medicalhypothesisid) {
        this.medicalhypothesisid = medicalhypothesisid;
    }

    public int getEpisodeid() {
        return episodeid;
    }

    public void setEpisodeid(int episodeid) {
        this.episodeid = episodeid;
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

    public int getRecordnumber() {
        return recordnumber;
    }

    public void setRecordnumber(int recordnumber) {
        this.recordnumber = recordnumber;
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
        hash += (int) medicalhypothesisid;
        hash += (int) episodeid;
        hash += (int) rut;
        hash += (dv != null ? dv.hashCode() : 0);
        hash += (int) recordnumber;
        hash += (int) nationalityid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicalhypothesisPK)) {
            return false;
        }
        MedicalhypothesisPK other = (MedicalhypothesisPK) object;
        if (this.medicalhypothesisid != other.medicalhypothesisid) {
            return false;
        }
        if (this.episodeid != other.episodeid) {
            return false;
        }
        if (this.rut != other.rut) {
            return false;
        }
        if ((this.dv == null && other.dv != null) || (this.dv != null && !this.dv.equals(other.dv))) {
            return false;
        }
        if (this.recordnumber != other.recordnumber) {
            return false;
        }
        if (this.nationalityid != other.nationalityid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.MedicalhypothesisPK[ medicalhypothesisid=" + medicalhypothesisid + ", episodeid=" + episodeid + ", rut=" + rut + ", dv=" + dv + ", recordnumber=" + recordnumber + ", nationalityid=" + nationalityid + " ]";
    }
    
}
