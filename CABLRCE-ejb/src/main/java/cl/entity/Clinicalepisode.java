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
@Table(name = "clinicalepisode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clinicalepisode.findAll", query = "SELECT c FROM Clinicalepisode c"),
    @NamedQuery(name = "Clinicalepisode.findByEpisodeid", query = "SELECT c FROM Clinicalepisode c WHERE c.clinicalepisodePK.episodeid = :episodeid"),
    @NamedQuery(name = "Clinicalepisode.findByRut", query = "SELECT c FROM Clinicalepisode c WHERE c.clinicalepisodePK.rut = :rut"),
    @NamedQuery(name = "Clinicalepisode.findByDv", query = "SELECT c FROM Clinicalepisode c WHERE c.clinicalepisodePK.dv = :dv"),
    @NamedQuery(name = "Clinicalepisode.findByRecordnumber", query = "SELECT c FROM Clinicalepisode c WHERE c.clinicalepisodePK.recordnumber = :recordnumber"),
    @NamedQuery(name = "Clinicalepisode.findByNationalityid", query = "SELECT c FROM Clinicalepisode c WHERE c.clinicalepisodePK.nationalityid = :nationalityid"),
    @NamedQuery(name = "Clinicalepisode.findByStartdate", query = "SELECT c FROM Clinicalepisode c WHERE c.startdate = :startdate"),
    @NamedQuery(name = "Clinicalepisode.findByEnddate", query = "SELECT c FROM Clinicalepisode c WHERE c.enddate = :enddate"),
    @NamedQuery(name = "Clinicalepisode.findByMediccontrolseq", query = "SELECT c FROM Clinicalepisode c WHERE c.mediccontrolseq = :mediccontrolseq"),
    @NamedQuery(name = "Clinicalepisode.findByDiabeticcontrolseq", query = "SELECT c FROM Clinicalepisode c WHERE c.diabeticcontrolseq = :diabeticcontrolseq"),
    @NamedQuery(name = "Clinicalepisode.findByNutritionalseq", query = "SELECT c FROM Clinicalepisode c WHERE c.nutritionalseq = :nutritionalseq"),
    @NamedQuery(name = "Clinicalepisode.findByDiagnosticseq", query = "SELECT c FROM Clinicalepisode c WHERE c.diagnosticseq = :diagnosticseq"),
    @NamedQuery(name = "Clinicalepisode.findByHyphotesisseq", query = "SELECT c FROM Clinicalepisode c WHERE c.hyphotesisseq = :hyphotesisseq"),
    @NamedQuery(name = "Clinicalepisode.findByExamreqseq", query = "SELECT c FROM Clinicalepisode c WHERE c.examreqseq = :examreqseq")})
public class Clinicalepisode implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClinicalepisodePK clinicalepisodePK;
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Column(name = "mediccontrolseq")
    private Integer mediccontrolseq;
    @Column(name = "diabeticcontrolseq")
    private Integer diabeticcontrolseq;
    @Column(name = "nutritionalseq")
    private Integer nutritionalseq;
    @Column(name = "diagnosticseq")
    private Integer diagnosticseq;
    @Column(name = "hyphotesisseq")
    private Integer hyphotesisseq;
    @Column(name = "examreqseq")
    private Integer examreqseq;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinicalepisode")
    private List<Mediccontrol> mediccontrolList;
    @JoinColumn(name = "statusepisodeid", referencedColumnName = "statusepisodeid")
    @ManyToOne(optional = false)
    private Statusclinicalepisode statusepisodeid;
    @JoinColumns({
        @JoinColumn(name = "rut", referencedColumnName = "rut", insertable = false, updatable = false),
        @JoinColumn(name = "dv", referencedColumnName = "dv", insertable = false, updatable = false),
        @JoinColumn(name = "recordnumber", referencedColumnName = "recordnumber", insertable = false, updatable = false),
        @JoinColumn(name = "nationalityid", referencedColumnName = "nationalityid", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Patientrecord patientrecord;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinicalepisode")
    private List<Medicalhypothesis> medicalhypothesisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinicalepisode")
    private List<Examsrequested> examsrequestedList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinicalepisode")
    private List<Diagnostic> diagnosticList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinicalepisode")
    private List<Diabeticcontrol> diabeticcontrolList;

    public Clinicalepisode() {
    }

    public Clinicalepisode(ClinicalepisodePK clinicalepisodePK) {
        this.clinicalepisodePK = clinicalepisodePK;
    }

    public Clinicalepisode(int episodeid, int rut, String dv, int recordnumber, int nationalityid) {
        this.clinicalepisodePK = new ClinicalepisodePK(episodeid, rut, dv, recordnumber, nationalityid);
    }

    public ClinicalepisodePK getClinicalepisodePK() {
        return clinicalepisodePK;
    }

    public void setClinicalepisodePK(ClinicalepisodePK clinicalepisodePK) {
        this.clinicalepisodePK = clinicalepisodePK;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getMediccontrolseq() {
        return mediccontrolseq;
    }

    public void setMediccontrolseq(Integer mediccontrolseq) {
        this.mediccontrolseq = mediccontrolseq;
    }

    public Integer getDiabeticcontrolseq() {
        return diabeticcontrolseq;
    }

    public void setDiabeticcontrolseq(Integer diabeticcontrolseq) {
        this.diabeticcontrolseq = diabeticcontrolseq;
    }

    public Integer getNutritionalseq() {
        return nutritionalseq;
    }

    public void setNutritionalseq(Integer nutritionalseq) {
        this.nutritionalseq = nutritionalseq;
    }

    public Integer getDiagnosticseq() {
        return diagnosticseq;
    }

    public void setDiagnosticseq(Integer diagnosticseq) {
        this.diagnosticseq = diagnosticseq;
    }

    public Integer getHyphotesisseq() {
        return hyphotesisseq;
    }

    public void setHyphotesisseq(Integer hyphotesisseq) {
        this.hyphotesisseq = hyphotesisseq;
    }

    public Integer getExamreqseq() {
        return examreqseq;
    }

    public void setExamreqseq(Integer examreqseq) {
        this.examreqseq = examreqseq;
    }

    @XmlTransient
    public List<Mediccontrol> getMediccontrolList() {
        return mediccontrolList;
    }

    public void setMediccontrolList(List<Mediccontrol> mediccontrolList) {
        this.mediccontrolList = mediccontrolList;
    }

    public Statusclinicalepisode getStatusepisodeid() {
        return statusepisodeid;
    }

    public void setStatusepisodeid(Statusclinicalepisode statusepisodeid) {
        this.statusepisodeid = statusepisodeid;
    }

    public Patientrecord getPatientrecord() {
        return patientrecord;
    }

    public void setPatientrecord(Patientrecord patientrecord) {
        this.patientrecord = patientrecord;
    }

    @XmlTransient
    public List<Medicalhypothesis> getMedicalhypothesisList() {
        return medicalhypothesisList;
    }

    public void setMedicalhypothesisList(List<Medicalhypothesis> medicalhypothesisList) {
        this.medicalhypothesisList = medicalhypothesisList;
    }

    @XmlTransient
    public List<Examsrequested> getExamsrequestedList() {
        return examsrequestedList;
    }

    public void setExamsrequestedList(List<Examsrequested> examsrequestedList) {
        this.examsrequestedList = examsrequestedList;
    }

    @XmlTransient
    public List<Diagnostic> getDiagnosticList() {
        return diagnosticList;
    }

    public void setDiagnosticList(List<Diagnostic> diagnosticList) {
        this.diagnosticList = diagnosticList;
    }

    @XmlTransient
    public List<Diabeticcontrol> getDiabeticcontrolList() {
        return diabeticcontrolList;
    }

    public void setDiabeticcontrolList(List<Diabeticcontrol> diabeticcontrolList) {
        this.diabeticcontrolList = diabeticcontrolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clinicalepisodePK != null ? clinicalepisodePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clinicalepisode)) {
            return false;
        }
        Clinicalepisode other = (Clinicalepisode) object;
        if ((this.clinicalepisodePK == null && other.clinicalepisodePK != null) || (this.clinicalepisodePK != null && !this.clinicalepisodePK.equals(other.clinicalepisodePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Clinicalepisode[ clinicalepisodePK=" + clinicalepisodePK + " ]";
    }
    
}
