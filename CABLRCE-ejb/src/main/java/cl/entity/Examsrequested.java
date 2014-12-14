/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "examsrequested")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examsrequested.findAll", query = "SELECT e FROM Examsrequested e"),
    @NamedQuery(name = "Examsrequested.findByExamreqid", query = "SELECT e FROM Examsrequested e WHERE e.examsrequestedPK.examreqid = :examreqid"),
    @NamedQuery(name = "Examsrequested.findByEpisodeid", query = "SELECT e FROM Examsrequested e WHERE e.examsrequestedPK.episodeid = :episodeid"),
    @NamedQuery(name = "Examsrequested.findByRut", query = "SELECT e FROM Examsrequested e WHERE e.examsrequestedPK.rut = :rut"),
    @NamedQuery(name = "Examsrequested.findByDv", query = "SELECT e FROM Examsrequested e WHERE e.examsrequestedPK.dv = :dv"),
    @NamedQuery(name = "Examsrequested.findByRecordnumber", query = "SELECT e FROM Examsrequested e WHERE e.examsrequestedPK.recordnumber = :recordnumber"),
    @NamedQuery(name = "Examsrequested.findByNationalityid", query = "SELECT e FROM Examsrequested e WHERE e.examsrequestedPK.nationalityid = :nationalityid"),
    @NamedQuery(name = "Examsrequested.findByDate", query = "SELECT e FROM Examsrequested e WHERE e.date = :date"),
    @NamedQuery(name = "Examsrequested.findByStatus", query = "SELECT e FROM Examsrequested e WHERE e.status = :status"),
    @NamedQuery(name = "Examsrequested.findByDatabinary", query = "SELECT e FROM Examsrequested e WHERE e.databinary = :databinary"),
    @NamedQuery(name = "Examsrequested.findByDataname", query = "SELECT e FROM Examsrequested e WHERE e.dataname = :dataname"),
    @NamedQuery(name = "Examsrequested.findByDataweight", query = "SELECT e FROM Examsrequested e WHERE e.dataweight = :dataweight"),
    @NamedQuery(name = "Examsrequested.findByDatatype", query = "SELECT e FROM Examsrequested e WHERE e.datatype = :datatype")})
public class Examsrequested implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExamsrequestedPK examsrequestedPK;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "status")
    private Short status;
    @Column(name = "databinary")
    private Character databinary;
    @Size(max = 200)
    @Column(name = "dataname")
    private String dataname;
    @Size(max = 100)
    @Column(name = "dataweight")
    private String dataweight;
    @Size(max = 20)
    @Column(name = "datatype")
    private String datatype;
    @JoinColumn(name = "examid", referencedColumnName = "examid")
    @ManyToOne(optional = false)
    private Tableexam examid;
    @JoinColumns({
        @JoinColumn(name = "episodeid", referencedColumnName = "episodeid", insertable = false, updatable = false),
        @JoinColumn(name = "rut", referencedColumnName = "rut", insertable = false, updatable = false),
        @JoinColumn(name = "dv", referencedColumnName = "dv", insertable = false, updatable = false),
        @JoinColumn(name = "recordnumber", referencedColumnName = "recordnumber", insertable = false, updatable = false),
        @JoinColumn(name = "nationalityid", referencedColumnName = "nationalityid", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Clinicalepisode clinicalepisode;

    public Examsrequested() {
    }

    public Examsrequested(ExamsrequestedPK examsrequestedPK) {
        this.examsrequestedPK = examsrequestedPK;
    }

    public Examsrequested(int examreqid, int episodeid, int rut, String dv, int recordnumber, int nationalityid) {
        this.examsrequestedPK = new ExamsrequestedPK(examreqid, episodeid, rut, dv, recordnumber, nationalityid);
    }

    public ExamsrequestedPK getExamsrequestedPK() {
        return examsrequestedPK;
    }

    public void setExamsrequestedPK(ExamsrequestedPK examsrequestedPK) {
        this.examsrequestedPK = examsrequestedPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Character getDatabinary() {
        return databinary;
    }

    public void setDatabinary(Character databinary) {
        this.databinary = databinary;
    }

    public String getDataname() {
        return dataname;
    }

    public void setDataname(String dataname) {
        this.dataname = dataname;
    }

    public String getDataweight() {
        return dataweight;
    }

    public void setDataweight(String dataweight) {
        this.dataweight = dataweight;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public Tableexam getExamid() {
        return examid;
    }

    public void setExamid(Tableexam examid) {
        this.examid = examid;
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
        hash += (examsrequestedPK != null ? examsrequestedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examsrequested)) {
            return false;
        }
        Examsrequested other = (Examsrequested) object;
        if ((this.examsrequestedPK == null && other.examsrequestedPK != null) || (this.examsrequestedPK != null && !this.examsrequestedPK.equals(other.examsrequestedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Examsrequested[ examsrequestedPK=" + examsrequestedPK + " ]";
    }
    
}
