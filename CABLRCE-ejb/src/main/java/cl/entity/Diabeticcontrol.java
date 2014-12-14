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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "diabeticcontrol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diabeticcontrol.findAll", query = "SELECT d FROM Diabeticcontrol d"),
    @NamedQuery(name = "Diabeticcontrol.findByDiabcontrolid", query = "SELECT d FROM Diabeticcontrol d WHERE d.diabeticcontrolPK.diabcontrolid = :diabcontrolid"),
    @NamedQuery(name = "Diabeticcontrol.findByEpisodeid", query = "SELECT d FROM Diabeticcontrol d WHERE d.diabeticcontrolPK.episodeid = :episodeid"),
    @NamedQuery(name = "Diabeticcontrol.findByRut", query = "SELECT d FROM Diabeticcontrol d WHERE d.diabeticcontrolPK.rut = :rut"),
    @NamedQuery(name = "Diabeticcontrol.findByDv", query = "SELECT d FROM Diabeticcontrol d WHERE d.diabeticcontrolPK.dv = :dv"),
    @NamedQuery(name = "Diabeticcontrol.findByRecordnumber", query = "SELECT d FROM Diabeticcontrol d WHERE d.diabeticcontrolPK.recordnumber = :recordnumber"),
    @NamedQuery(name = "Diabeticcontrol.findByNationalityid", query = "SELECT d FROM Diabeticcontrol d WHERE d.diabeticcontrolPK.nationalityid = :nationalityid"),
    @NamedQuery(name = "Diabeticcontrol.findByDateexam", query = "SELECT d FROM Diabeticcontrol d WHERE d.dateexam = :dateexam"),
    @NamedQuery(name = "Diabeticcontrol.findByAntdiabfamily", query = "SELECT d FROM Diabeticcontrol d WHERE d.antdiabfamily = :antdiabfamily"),
    @NamedQuery(name = "Diabeticcontrol.findByDiagentry", query = "SELECT d FROM Diabeticcontrol d WHERE d.diagentry = :diagentry"),
    @NamedQuery(name = "Diabeticcontrol.findByDiagnosticexamdiab", query = "SELECT d FROM Diabeticcontrol d WHERE d.diagnosticexamdiab = :diagnosticexamdiab"),
    @NamedQuery(name = "Diabeticcontrol.findByResultexam", query = "SELECT d FROM Diabeticcontrol d WHERE d.resultexam = :resultexam"),
    @NamedQuery(name = "Diabeticcontrol.findByTipetreatment", query = "SELECT d FROM Diabeticcontrol d WHERE d.tipetreatment = :tipetreatment"),
    @NamedQuery(name = "Diabeticcontrol.findByHospitalization", query = "SELECT d FROM Diabeticcontrol d WHERE d.hospitalization = :hospitalization"),
    @NamedQuery(name = "Diabeticcontrol.findByExclusiveregime", query = "SELECT d FROM Diabeticcontrol d WHERE d.exclusiveregime = :exclusiveregime"),
    @NamedQuery(name = "Diabeticcontrol.findByOthers", query = "SELECT d FROM Diabeticcontrol d WHERE d.others = :others"),
    @NamedQuery(name = "Diabeticcontrol.findByAttribute13", query = "SELECT d FROM Diabeticcontrol d WHERE d.attribute13 = :attribute13")})
public class Diabeticcontrol implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiabeticcontrolPK diabeticcontrolPK;
    @Column(name = "dateexam")
    @Temporal(TemporalType.DATE)
    private Date dateexam;
    @Size(max = 2147483647)
    @Column(name = "antdiabfamily")
    private String antdiabfamily;
    @Size(max = 2147483647)
    @Column(name = "diagentry")
    private String diagentry;
    @Size(max = 2147483647)
    @Column(name = "diagnosticexamdiab")
    private String diagnosticexamdiab;
    @Size(max = 2147483647)
    @Column(name = "resultexam")
    private String resultexam;
    @Size(max = 2147483647)
    @Column(name = "tipetreatment")
    private String tipetreatment;
    @Column(name = "hospitalization")
    private Short hospitalization;
    @Size(max = 2147483647)
    @Column(name = "exclusiveregime")
    private String exclusiveregime;
    @Size(max = 2147483647)
    @Column(name = "others")
    private String others;
    @Column(name = "attribute_13")
    private Integer attribute13;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diabeticcontrol")
    private List<Recordcontroldiabetic> recordcontroldiabeticList;
    @JoinColumns({
        @JoinColumn(name = "episodeid", referencedColumnName = "episodeid", insertable = false, updatable = false),
        @JoinColumn(name = "rut", referencedColumnName = "rut", insertable = false, updatable = false),
        @JoinColumn(name = "dv", referencedColumnName = "dv", insertable = false, updatable = false),
        @JoinColumn(name = "recordnumber", referencedColumnName = "recordnumber", insertable = false, updatable = false),
        @JoinColumn(name = "nationalityid", referencedColumnName = "nationalityid", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Clinicalepisode clinicalepisode;

    public Diabeticcontrol() {
    }

    public Diabeticcontrol(DiabeticcontrolPK diabeticcontrolPK) {
        this.diabeticcontrolPK = diabeticcontrolPK;
    }

    public Diabeticcontrol(int diabcontrolid, int episodeid, int rut, String dv, int recordnumber, int nationalityid) {
        this.diabeticcontrolPK = new DiabeticcontrolPK(diabcontrolid, episodeid, rut, dv, recordnumber, nationalityid);
    }

    public DiabeticcontrolPK getDiabeticcontrolPK() {
        return diabeticcontrolPK;
    }

    public void setDiabeticcontrolPK(DiabeticcontrolPK diabeticcontrolPK) {
        this.diabeticcontrolPK = diabeticcontrolPK;
    }

    public Date getDateexam() {
        return dateexam;
    }

    public void setDateexam(Date dateexam) {
        this.dateexam = dateexam;
    }

    public String getAntdiabfamily() {
        return antdiabfamily;
    }

    public void setAntdiabfamily(String antdiabfamily) {
        this.antdiabfamily = antdiabfamily;
    }

    public String getDiagentry() {
        return diagentry;
    }

    public void setDiagentry(String diagentry) {
        this.diagentry = diagentry;
    }

    public String getDiagnosticexamdiab() {
        return diagnosticexamdiab;
    }

    public void setDiagnosticexamdiab(String diagnosticexamdiab) {
        this.diagnosticexamdiab = diagnosticexamdiab;
    }

    public String getResultexam() {
        return resultexam;
    }

    public void setResultexam(String resultexam) {
        this.resultexam = resultexam;
    }

    public String getTipetreatment() {
        return tipetreatment;
    }

    public void setTipetreatment(String tipetreatment) {
        this.tipetreatment = tipetreatment;
    }

    public Short getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(Short hospitalization) {
        this.hospitalization = hospitalization;
    }

    public String getExclusiveregime() {
        return exclusiveregime;
    }

    public void setExclusiveregime(String exclusiveregime) {
        this.exclusiveregime = exclusiveregime;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public Integer getAttribute13() {
        return attribute13;
    }

    public void setAttribute13(Integer attribute13) {
        this.attribute13 = attribute13;
    }

    @XmlTransient
    public List<Recordcontroldiabetic> getRecordcontroldiabeticList() {
        return recordcontroldiabeticList;
    }

    public void setRecordcontroldiabeticList(List<Recordcontroldiabetic> recordcontroldiabeticList) {
        this.recordcontroldiabeticList = recordcontroldiabeticList;
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
        hash += (diabeticcontrolPK != null ? diabeticcontrolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diabeticcontrol)) {
            return false;
        }
        Diabeticcontrol other = (Diabeticcontrol) object;
        if ((this.diabeticcontrolPK == null && other.diabeticcontrolPK != null) || (this.diabeticcontrolPK != null && !this.diabeticcontrolPK.equals(other.diabeticcontrolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Diabeticcontrol[ diabeticcontrolPK=" + diabeticcontrolPK + " ]";
    }
    
}
