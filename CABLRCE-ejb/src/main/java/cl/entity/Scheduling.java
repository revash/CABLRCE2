/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "scheduling")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scheduling.findAll", query = "SELECT s FROM Scheduling s"),
    @NamedQuery(name = "Scheduling.findByDate2", query = "SELECT s FROM Scheduling s WHERE s.schedulingPK.date2 = :date2"),
    @NamedQuery(name = "Scheduling.findByTime2", query = "SELECT s FROM Scheduling s WHERE s.schedulingPK.time2 = :time2"),
    @NamedQuery(name = "Scheduling.findByProRut", query = "SELECT s FROM Scheduling s WHERE s.schedulingPK.proRut = :proRut"),
    @NamedQuery(name = "Scheduling.findByProDv", query = "SELECT s FROM Scheduling s WHERE s.schedulingPK.proDv = :proDv")})
public class Scheduling implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SchedulingPK schedulingPK;
    @JoinColumn(name = "statusshedulingid", referencedColumnName = "statusshedulingid")
    @ManyToOne(optional = false)
    private Statussheduling statusshedulingid;
    @JoinColumns({
        @JoinColumn(name = "pro_rut", referencedColumnName = "rut", insertable = false, updatable = false),
        @JoinColumn(name = "pro_dv", referencedColumnName = "dv", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Professional professional;
    @JoinColumns({
        @JoinColumn(name = "rut", referencedColumnName = "rut"),
        @JoinColumn(name = "dv", referencedColumnName = "dv"),
        @JoinColumn(name = "recordnumber", referencedColumnName = "recordnumber"),
        @JoinColumn(name = "nationalityid", referencedColumnName = "nationalityid")})
    @ManyToOne(optional = false)
    private Patientrecord patientrecord;

    public Scheduling() {
    }

    public Scheduling(SchedulingPK schedulingPK) {
        this.schedulingPK = schedulingPK;
    }

    public Scheduling(Date date2, Date time2, int proRut, String proDv) {
        this.schedulingPK = new SchedulingPK(date2, time2, proRut, proDv);
    }

    public SchedulingPK getSchedulingPK() {
        return schedulingPK;
    }

    public void setSchedulingPK(SchedulingPK schedulingPK) {
        this.schedulingPK = schedulingPK;
    }

    public Statussheduling getStatusshedulingid() {
        return statusshedulingid;
    }

    public void setStatusshedulingid(Statussheduling statusshedulingid) {
        this.statusshedulingid = statusshedulingid;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Patientrecord getPatientrecord() {
        return patientrecord;
    }

    public void setPatientrecord(Patientrecord patientrecord) {
        this.patientrecord = patientrecord;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schedulingPK != null ? schedulingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scheduling)) {
            return false;
        }
        Scheduling other = (Scheduling) object;
        if ((this.schedulingPK == null && other.schedulingPK != null) || (this.schedulingPK != null && !this.schedulingPK.equals(other.schedulingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Scheduling[ schedulingPK=" + schedulingPK + " ]";
    }
    
}
