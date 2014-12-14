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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "databirths")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Databirths.findAll", query = "SELECT d FROM Databirths d"),
    @NamedQuery(name = "Databirths.findByPersonrut", query = "SELECT d FROM Databirths d WHERE d.databirthsPK.personrut = :personrut"),
    @NamedQuery(name = "Databirths.findByPersondv", query = "SELECT d FROM Databirths d WHERE d.databirthsPK.persondv = :persondv"),
    @NamedQuery(name = "Databirths.findByPersonnationality", query = "SELECT d FROM Databirths d WHERE d.databirthsPK.personnationality = :personnationality"),
    @NamedQuery(name = "Databirths.findByRecordnumber", query = "SELECT d FROM Databirths d WHERE d.databirthsPK.recordnumber = :recordnumber"),
    @NamedQuery(name = "Databirths.findByObservations", query = "SELECT d FROM Databirths d WHERE d.observations = :observations")})
public class Databirths implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DatabirthsPK databirthsPK;
    @Size(max = 2147483647)
    @Column(name = "observations")
    private String observations;
    @JoinColumn(name = "tipebirthid", referencedColumnName = "tipebirthid")
    @ManyToOne
    private Tipebirths tipebirthid;
    @JoinColumns({
        @JoinColumn(name = "personrut", referencedColumnName = "personrut", insertable = false, updatable = false),
        @JoinColumn(name = "persondv", referencedColumnName = "persondv", insertable = false, updatable = false),
        @JoinColumn(name = "personnationality", referencedColumnName = "personnationality", insertable = false, updatable = false),
        @JoinColumn(name = "recordnumber", referencedColumnName = "recordnumber", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Obstetricdata obstetricdata;

    public Databirths() {
    }

    public Databirths(DatabirthsPK databirthsPK) {
        this.databirthsPK = databirthsPK;
    }

    public Databirths(int personrut, String persondv, int personnationality, int recordnumber) {
        this.databirthsPK = new DatabirthsPK(personrut, persondv, personnationality, recordnumber);
    }

    public DatabirthsPK getDatabirthsPK() {
        return databirthsPK;
    }

    public void setDatabirthsPK(DatabirthsPK databirthsPK) {
        this.databirthsPK = databirthsPK;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Tipebirths getTipebirthid() {
        return tipebirthid;
    }

    public void setTipebirthid(Tipebirths tipebirthid) {
        this.tipebirthid = tipebirthid;
    }

    public Obstetricdata getObstetricdata() {
        return obstetricdata;
    }

    public void setObstetricdata(Obstetricdata obstetricdata) {
        this.obstetricdata = obstetricdata;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (databirthsPK != null ? databirthsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Databirths)) {
            return false;
        }
        Databirths other = (Databirths) object;
        if ((this.databirthsPK == null && other.databirthsPK != null) || (this.databirthsPK != null && !this.databirthsPK.equals(other.databirthsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Databirths[ databirthsPK=" + databirthsPK + " ]";
    }
    
}
