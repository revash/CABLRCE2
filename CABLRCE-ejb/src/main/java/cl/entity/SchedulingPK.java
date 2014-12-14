/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AndresEduardo
 */
@Embeddable
public class SchedulingPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "date2")
    @Temporal(TemporalType.DATE)
    private Date date2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time2")
    @Temporal(TemporalType.TIME)
    private Date time2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_rut")
    private int proRut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "pro_dv")
    private String proDv;

    public SchedulingPK() {
    }

    public SchedulingPK(Date date2, Date time2, int proRut, String proDv) {
        this.date2 = date2;
        this.time2 = time2;
        this.proRut = proRut;
        this.proDv = proDv;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getTime2() {
        return time2;
    }

    public void setTime2(Date time2) {
        this.time2 = time2;
    }

    public int getProRut() {
        return proRut;
    }

    public void setProRut(int proRut) {
        this.proRut = proRut;
    }

    public String getProDv() {
        return proDv;
    }

    public void setProDv(String proDv) {
        this.proDv = proDv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (date2 != null ? date2.hashCode() : 0);
        hash += (time2 != null ? time2.hashCode() : 0);
        hash += (int) proRut;
        hash += (proDv != null ? proDv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchedulingPK)) {
            return false;
        }
        SchedulingPK other = (SchedulingPK) object;
        if ((this.date2 == null && other.date2 != null) || (this.date2 != null && !this.date2.equals(other.date2))) {
            return false;
        }
        if ((this.time2 == null && other.time2 != null) || (this.time2 != null && !this.time2.equals(other.time2))) {
            return false;
        }
        if (this.proRut != other.proRut) {
            return false;
        }
        if ((this.proDv == null && other.proDv != null) || (this.proDv != null && !this.proDv.equals(other.proDv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.SchedulingPK[ date2=" + date2 + ", time2=" + time2 + ", proRut=" + proRut + ", proDv=" + proDv + " ]";
    }
    
}
