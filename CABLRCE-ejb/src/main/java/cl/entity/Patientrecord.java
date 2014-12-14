/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "patientrecord")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patientrecord.findAll", query = "SELECT p FROM Patientrecord p"),
    @NamedQuery(name = "Patientrecord.findByRecordnumber", query = "SELECT p FROM Patientrecord p WHERE p.patientrecordPK.recordnumber = :recordnumber"),
    @NamedQuery(name = "Patientrecord.findByRut", query = "SELECT p FROM Patientrecord p WHERE p.patientrecordPK.rut = :rut"),
    @NamedQuery(name = "Patientrecord.findByDv", query = "SELECT p FROM Patientrecord p WHERE p.patientrecordPK.dv = :dv"),
    @NamedQuery(name = "Patientrecord.findByNationalityid", query = "SELECT p FROM Patientrecord p WHERE p.patientrecordPK.nationalityid = :nationalityid"),
    @NamedQuery(name = "Patientrecord.findByCreationdate", query = "SELECT p FROM Patientrecord p WHERE p.creationdate = :creationdate"),
    @NamedQuery(name = "Patientrecord.findByDatelow", query = "SELECT p FROM Patientrecord p WHERE p.datelow = :datelow"),
    @NamedQuery(name = "Patientrecord.findByEpisodecounter", query = "SELECT p FROM Patientrecord p WHERE p.episodecounter = :episodecounter")})
public class Patientrecord implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PatientrecordPK patientrecordPK;
    @Column(name = "creationdate")
    @Temporal(TemporalType.DATE)
    private Date creationdate;
    @Column(name = "datelow")
    @Temporal(TemporalType.DATE)
    private Date datelow;
    @Column(name = "episodecounter")
    private Integer episodecounter;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientrecord")
    private List<Scheduling> schedulingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientrecord")
    private List<Clinicalepisode> clinicalepisodeList;
    @JoinColumns({
        @JoinColumn(name = "pro_rut", referencedColumnName = "rut"),
        @JoinColumn(name = "pro_dv", referencedColumnName = "dv")})
    @ManyToOne(optional = false)
    private Professional professional;
    @JoinColumns({
        @JoinColumn(name = "rut", referencedColumnName = "rut", insertable = false, updatable = false),
        @JoinColumn(name = "dv", referencedColumnName = "dv", insertable = false, updatable = false),
        @JoinColumn(name = "nationalityid", referencedColumnName = "nationalityid", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Person person;

    public Patientrecord() {
    }

    public Patientrecord(PatientrecordPK patientrecordPK) {
        this.patientrecordPK = patientrecordPK;
    }

    public Patientrecord(int recordnumber, int rut, String dv, int nationalityid) {
        this.patientrecordPK = new PatientrecordPK(recordnumber, rut, dv, nationalityid);
    }

    public PatientrecordPK getPatientrecordPK() {
        return patientrecordPK;
    }

    public void setPatientrecordPK(PatientrecordPK patientrecordPK) {
        this.patientrecordPK = patientrecordPK;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getDatelow() {
        return datelow;
    }

    public void setDatelow(Date datelow) {
        this.datelow = datelow;
    }

    public Integer getEpisodecounter() {
        return episodecounter;
    }

    public void setEpisodecounter(Integer episodecounter) {
        this.episodecounter = episodecounter;
    }

    @XmlTransient
    public List<Scheduling> getSchedulingList() {
        return schedulingList;
    }

    public void setSchedulingList(List<Scheduling> schedulingList) {
        this.schedulingList = schedulingList;
    }

    @XmlTransient
    public List<Clinicalepisode> getClinicalepisodeList() {
        return clinicalepisodeList;
    }

    public void setClinicalepisodeList(List<Clinicalepisode> clinicalepisodeList) {
        this.clinicalepisodeList = clinicalepisodeList;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientrecordPK != null ? patientrecordPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientrecord)) {
            return false;
        }
        Patientrecord other = (Patientrecord) object;
        if ((this.patientrecordPK == null && other.patientrecordPK != null) || (this.patientrecordPK != null && !this.patientrecordPK.equals(other.patientrecordPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Patientrecord[ patientrecordPK=" + patientrecordPK + " ]";
    }
    
}
