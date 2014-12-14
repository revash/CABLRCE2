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
@Table(name = "diagnostic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostic.findAll", query = "SELECT d FROM Diagnostic d"),
    @NamedQuery(name = "Diagnostic.findByDiagnosticid", query = "SELECT d FROM Diagnostic d WHERE d.diagnosticPK.diagnosticid = :diagnosticid"),
    @NamedQuery(name = "Diagnostic.findByEpisodeid", query = "SELECT d FROM Diagnostic d WHERE d.diagnosticPK.episodeid = :episodeid"),
    @NamedQuery(name = "Diagnostic.findByRut", query = "SELECT d FROM Diagnostic d WHERE d.diagnosticPK.rut = :rut"),
    @NamedQuery(name = "Diagnostic.findByDv", query = "SELECT d FROM Diagnostic d WHERE d.diagnosticPK.dv = :dv"),
    @NamedQuery(name = "Diagnostic.findByRecordnumber", query = "SELECT d FROM Diagnostic d WHERE d.diagnosticPK.recordnumber = :recordnumber"),
    @NamedQuery(name = "Diagnostic.findByNationalityid", query = "SELECT d FROM Diagnostic d WHERE d.diagnosticPK.nationalityid = :nationalityid"),
    @NamedQuery(name = "Diagnostic.findByDiagnosticdesc", query = "SELECT d FROM Diagnostic d WHERE d.diagnosticdesc = :diagnosticdesc"),
    @NamedQuery(name = "Diagnostic.findByDiagnosticges", query = "SELECT d FROM Diagnostic d WHERE d.diagnosticges = :diagnosticges")})
public class Diagnostic implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiagnosticPK diagnosticPK;
    @Size(max = 200)
    @Column(name = "diagnosticdesc")
    private String diagnosticdesc;
    @Column(name = "diagnosticges")
    private Short diagnosticges;
    @JoinColumn(name = "statusid", referencedColumnName = "statusid")
    @ManyToOne(optional = false)
    private Status statusid;
    @JoinColumn(name = "pathologieid", referencedColumnName = "pathologieid")
    @ManyToOne(optional = false)
    private Pathologie pathologieid;
    @JoinColumns({
        @JoinColumn(name = "episodeid", referencedColumnName = "episodeid", insertable = false, updatable = false),
        @JoinColumn(name = "rut", referencedColumnName = "rut", insertable = false, updatable = false),
        @JoinColumn(name = "dv", referencedColumnName = "dv", insertable = false, updatable = false),
        @JoinColumn(name = "recordnumber", referencedColumnName = "recordnumber", insertable = false, updatable = false),
        @JoinColumn(name = "nationalityid", referencedColumnName = "nationalityid", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Clinicalepisode clinicalepisode;

    public Diagnostic() {
    }

    public Diagnostic(DiagnosticPK diagnosticPK) {
        this.diagnosticPK = diagnosticPK;
    }

    public Diagnostic(int diagnosticid, int episodeid, int rut, String dv, int recordnumber, int nationalityid) {
        this.diagnosticPK = new DiagnosticPK(diagnosticid, episodeid, rut, dv, recordnumber, nationalityid);
    }

    public DiagnosticPK getDiagnosticPK() {
        return diagnosticPK;
    }

    public void setDiagnosticPK(DiagnosticPK diagnosticPK) {
        this.diagnosticPK = diagnosticPK;
    }

    public String getDiagnosticdesc() {
        return diagnosticdesc;
    }

    public void setDiagnosticdesc(String diagnosticdesc) {
        this.diagnosticdesc = diagnosticdesc;
    }

    public Short getDiagnosticges() {
        return diagnosticges;
    }

    public void setDiagnosticges(Short diagnosticges) {
        this.diagnosticges = diagnosticges;
    }

    public Status getStatusid() {
        return statusid;
    }

    public void setStatusid(Status statusid) {
        this.statusid = statusid;
    }

    public Pathologie getPathologieid() {
        return pathologieid;
    }

    public void setPathologieid(Pathologie pathologieid) {
        this.pathologieid = pathologieid;
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
        hash += (diagnosticPK != null ? diagnosticPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostic)) {
            return false;
        }
        Diagnostic other = (Diagnostic) object;
        if ((this.diagnosticPK == null && other.diagnosticPK != null) || (this.diagnosticPK != null && !this.diagnosticPK.equals(other.diagnosticPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Diagnostic[ diagnosticPK=" + diagnosticPK + " ]";
    }
    
}
