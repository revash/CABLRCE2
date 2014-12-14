/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "medicalhypothesis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicalhypothesis.findAll", query = "SELECT m FROM Medicalhypothesis m"),
    @NamedQuery(name = "Medicalhypothesis.findByMedicalhypothesisid", query = "SELECT m FROM Medicalhypothesis m WHERE m.medicalhypothesisPK.medicalhypothesisid = :medicalhypothesisid"),
    @NamedQuery(name = "Medicalhypothesis.findByEpisodeid", query = "SELECT m FROM Medicalhypothesis m WHERE m.medicalhypothesisPK.episodeid = :episodeid"),
    @NamedQuery(name = "Medicalhypothesis.findByRut", query = "SELECT m FROM Medicalhypothesis m WHERE m.medicalhypothesisPK.rut = :rut"),
    @NamedQuery(name = "Medicalhypothesis.findByDv", query = "SELECT m FROM Medicalhypothesis m WHERE m.medicalhypothesisPK.dv = :dv"),
    @NamedQuery(name = "Medicalhypothesis.findByRecordnumber", query = "SELECT m FROM Medicalhypothesis m WHERE m.medicalhypothesisPK.recordnumber = :recordnumber"),
    @NamedQuery(name = "Medicalhypothesis.findByNationalityid", query = "SELECT m FROM Medicalhypothesis m WHERE m.medicalhypothesisPK.nationalityid = :nationalityid"),
    @NamedQuery(name = "Medicalhypothesis.findByMedicalhypothesisdesc", query = "SELECT m FROM Medicalhypothesis m WHERE m.medicalhypothesisdesc = :medicalhypothesisdesc")})
public class Medicalhypothesis implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MedicalhypothesisPK medicalhypothesisPK;
    @Size(max = 2147483647)
    @Column(name = "medicalhypothesisdesc")
    private String medicalhypothesisdesc;
    @JoinColumn(name = "hypothesisid", referencedColumnName = "hypothesisid")
    @ManyToOne(optional = false)
    private Tipehypothesis hypothesisid;
    @JoinColumn(name = "statusid", referencedColumnName = "statusid")
    @ManyToOne(optional = false)
    private Status statusid;
    @JoinColumns({
        @JoinColumn(name = "episodeid", referencedColumnName = "episodeid", insertable = false, updatable = false),
        @JoinColumn(name = "rut", referencedColumnName = "rut", insertable = false, updatable = false),
        @JoinColumn(name = "dv", referencedColumnName = "dv", insertable = false, updatable = false),
        @JoinColumn(name = "recordnumber", referencedColumnName = "recordnumber", insertable = false, updatable = false),
        @JoinColumn(name = "nationalityid", referencedColumnName = "nationalityid", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Clinicalepisode clinicalepisode;

    public Medicalhypothesis() {
    }

    public Medicalhypothesis(MedicalhypothesisPK medicalhypothesisPK) {
        this.medicalhypothesisPK = medicalhypothesisPK;
    }

    public Medicalhypothesis(int medicalhypothesisid, int episodeid, int rut, String dv, int recordnumber, int nationalityid) {
        this.medicalhypothesisPK = new MedicalhypothesisPK(medicalhypothesisid, episodeid, rut, dv, recordnumber, nationalityid);
    }

    public MedicalhypothesisPK getMedicalhypothesisPK() {
        return medicalhypothesisPK;
    }

    public void setMedicalhypothesisPK(MedicalhypothesisPK medicalhypothesisPK) {
        this.medicalhypothesisPK = medicalhypothesisPK;
    }

    public String getMedicalhypothesisdesc() {
        return medicalhypothesisdesc;
    }

    public void setMedicalhypothesisdesc(String medicalhypothesisdesc) {
        this.medicalhypothesisdesc = medicalhypothesisdesc;
    }

    public Tipehypothesis getHypothesisid() {
        return hypothesisid;
    }

    public void setHypothesisid(Tipehypothesis hypothesisid) {
        this.hypothesisid = hypothesisid;
    }

    public Status getStatusid() {
        return statusid;
    }

    public void setStatusid(Status statusid) {
        this.statusid = statusid;
    }

    public Clinicalepisode getClinicalepisode() {
        return clinicalepisode;
    }

    public void setClinicalepisode(Clinicalepisode clinicalepisode) {
        this.clinicalepisode = clinicalepisode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicalhypothesisPK != null ? medicalhypothesisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicalhypothesis)) {
            return false;
        }
        Medicalhypothesis other = (Medicalhypothesis) object;
        if ((this.medicalhypothesisPK == null && other.medicalhypothesisPK != null) || (this.medicalhypothesisPK != null && !this.medicalhypothesisPK.equals(other.medicalhypothesisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Medicalhypothesis[ medicalhypothesisPK=" + medicalhypothesisPK + " ]";
    }
    
}
