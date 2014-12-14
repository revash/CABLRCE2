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
public class RecordcontroldiabeticPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "diabcontrolid")
    private int diabcontrolid;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "diabcontrolid2")
    private int diabcontrolid2;

    public RecordcontroldiabeticPK() {
    }

    public RecordcontroldiabeticPK(int diabcontrolid, int episodeid, int rut, String dv, int recordnumber, int nationalityid, int diabcontrolid2) {
        this.diabcontrolid = diabcontrolid;
        this.episodeid = episodeid;
        this.rut = rut;
        this.dv = dv;
        this.recordnumber = recordnumber;
        this.nationalityid = nationalityid;
        this.diabcontrolid2 = diabcontrolid2;
    }

    public int getDiabcontrolid() {
        return diabcontrolid;
    }

    public void setDiabcontrolid(int diabcontrolid) {
        this.diabcontrolid = diabcontrolid;
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

    public int getDiabcontrolid2() {
        return diabcontrolid2;
    }

    public void setDiabcontrolid2(int diabcontrolid2) {
        this.diabcontrolid2 = diabcontrolid2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) diabcontrolid;
        hash += (int) episodeid;
        hash += (int) rut;
        hash += (dv != null ? dv.hashCode() : 0);
        hash += (int) recordnumber;
        hash += (int) nationalityid;
        hash += (int) diabcontrolid2;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecordcontroldiabeticPK)) {
            return false;
        }
        RecordcontroldiabeticPK other = (RecordcontroldiabeticPK) object;
        if (this.diabcontrolid != other.diabcontrolid) {
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
        if (this.diabcontrolid2 != other.diabcontrolid2) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.RecordcontroldiabeticPK[ diabcontrolid=" + diabcontrolid + ", episodeid=" + episodeid + ", rut=" + rut + ", dv=" + dv + ", recordnumber=" + recordnumber + ", nationalityid=" + nationalityid + ", diabcontrolid2=" + diabcontrolid2 + " ]";
    }
    
}
