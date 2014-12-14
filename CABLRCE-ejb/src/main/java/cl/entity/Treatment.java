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
@Table(name = "treatment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Treatment.findAll", query = "SELECT t FROM Treatment t"),
    @NamedQuery(name = "Treatment.findByTreatmentid", query = "SELECT t FROM Treatment t WHERE t.treatmentPK.treatmentid = :treatmentid"),
    @NamedQuery(name = "Treatment.findByControlid", query = "SELECT t FROM Treatment t WHERE t.treatmentPK.controlid = :controlid"),
    @NamedQuery(name = "Treatment.findByEpisodeid", query = "SELECT t FROM Treatment t WHERE t.treatmentPK.episodeid = :episodeid"),
    @NamedQuery(name = "Treatment.findByRut", query = "SELECT t FROM Treatment t WHERE t.treatmentPK.rut = :rut"),
    @NamedQuery(name = "Treatment.findByDv", query = "SELECT t FROM Treatment t WHERE t.treatmentPK.dv = :dv"),
    @NamedQuery(name = "Treatment.findByRecordnumber", query = "SELECT t FROM Treatment t WHERE t.treatmentPK.recordnumber = :recordnumber"),
    @NamedQuery(name = "Treatment.findByNationalityid", query = "SELECT t FROM Treatment t WHERE t.treatmentPK.nationalityid = :nationalityid"),
    @NamedQuery(name = "Treatment.findByDate", query = "SELECT t FROM Treatment t WHERE t.date = :date"),
    @NamedQuery(name = "Treatment.findByBody", query = "SELECT t FROM Treatment t WHERE t.body = :body")})
public class Treatment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TreatmentPK treatmentPK;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 2147483647)
    @Column(name = "body")
    private String body;
    @JoinColumns({
        @JoinColumn(name = "controlid", referencedColumnName = "controlid", insertable = false, updatable = false),
        @JoinColumn(name = "episodeid", referencedColumnName = "episodeid", insertable = false, updatable = false),
        @JoinColumn(name = "rut", referencedColumnName = "rut", insertable = false, updatable = false),
        @JoinColumn(name = "dv", referencedColumnName = "dv", insertable = false, updatable = false),
        @JoinColumn(name = "recordnumber", referencedColumnName = "recordnumber", insertable = false, updatable = false),
        @JoinColumn(name = "nationalityid", referencedColumnName = "nationalityid", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Mediccontrol mediccontrol;

    public Treatment() {
    }

    public Treatment(TreatmentPK treatmentPK) {
        this.treatmentPK = treatmentPK;
    }

    public Treatment(int treatmentid, int controlid, int episodeid, int rut, String dv, int recordnumber, int nationalityid) {
        this.treatmentPK = new TreatmentPK(treatmentid, controlid, episodeid, rut, dv, recordnumber, nationalityid);
    }

    public TreatmentPK getTreatmentPK() {
        return treatmentPK;
    }

    public void setTreatmentPK(TreatmentPK treatmentPK) {
        this.treatmentPK = treatmentPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Mediccontrol getMediccontrol() {
        return mediccontrol;
    }

    public void setMediccontrol(Mediccontrol mediccontrol) {
        this.mediccontrol = mediccontrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (treatmentPK != null ? treatmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Treatment)) {
            return false;
        }
        Treatment other = (Treatment) object;
        if ((this.treatmentPK == null && other.treatmentPK != null) || (this.treatmentPK != null && !this.treatmentPK.equals(other.treatmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Treatment[ treatmentPK=" + treatmentPK + " ]";
    }
    
}
