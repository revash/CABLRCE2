/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "obstetricdata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obstetricdata.findAll", query = "SELECT o FROM Obstetricdata o"),
    @NamedQuery(name = "Obstetricdata.findByPersonrut", query = "SELECT o FROM Obstetricdata o WHERE o.obstetricdataPK.personrut = :personrut"),
    @NamedQuery(name = "Obstetricdata.findByPersondv", query = "SELECT o FROM Obstetricdata o WHERE o.obstetricdataPK.persondv = :persondv"),
    @NamedQuery(name = "Obstetricdata.findByPersonnationality", query = "SELECT o FROM Obstetricdata o WHERE o.obstetricdataPK.personnationality = :personnationality"),
    @NamedQuery(name = "Obstetricdata.findByRecordnumber", query = "SELECT o FROM Obstetricdata o WHERE o.obstetricdataPK.recordnumber = :recordnumber"),
    @NamedQuery(name = "Obstetricdata.findByAbortion", query = "SELECT o FROM Obstetricdata o WHERE o.abortion = :abortion"),
    @NamedQuery(name = "Obstetricdata.findByVaginal", query = "SELECT o FROM Obstetricdata o WHERE o.vaginal = :vaginal"),
    @NamedQuery(name = "Obstetricdata.findByCaesarean", query = "SELECT o FROM Obstetricdata o WHERE o.caesarean = :caesarean"),
    @NamedQuery(name = "Obstetricdata.findByLastdatepregnacy", query = "SELECT o FROM Obstetricdata o WHERE o.lastdatepregnacy = :lastdatepregnacy"),
    @NamedQuery(name = "Obstetricdata.findByRnhigherweight", query = "SELECT o FROM Obstetricdata o WHERE o.rnhigherweight = :rnhigherweight"),
    @NamedQuery(name = "Obstetricdata.findByRnlowerweight", query = "SELECT o FROM Obstetricdata o WHERE o.rnlowerweight = :rnlowerweight")})
public class Obstetricdata implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObstetricdataPK obstetricdataPK;
    @Column(name = "abortion")
    private Integer abortion;
    @Column(name = "vaginal")
    private Integer vaginal;
    @Column(name = "caesarean")
    private Integer caesarean;
    @Column(name = "lastdatepregnacy")
    @Temporal(TemporalType.DATE)
    private Date lastdatepregnacy;
    @Column(name = "rnhigherweight")
    private Integer rnhigherweight;
    @Column(name = "rnlowerweight")
    private Integer rnlowerweight;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "obstetricdata")
    private Databirths databirths;

    public Obstetricdata() {
    }

    public Obstetricdata(ObstetricdataPK obstetricdataPK) {
        this.obstetricdataPK = obstetricdataPK;
    }

    public Obstetricdata(int personrut, String persondv, int personnationality, int recordnumber) {
        this.obstetricdataPK = new ObstetricdataPK(personrut, persondv, personnationality, recordnumber);
    }

    public ObstetricdataPK getObstetricdataPK() {
        return obstetricdataPK;
    }

    public void setObstetricdataPK(ObstetricdataPK obstetricdataPK) {
        this.obstetricdataPK = obstetricdataPK;
    }

    public Integer getAbortion() {
        return abortion;
    }

    public void setAbortion(Integer abortion) {
        this.abortion = abortion;
    }

    public Integer getVaginal() {
        return vaginal;
    }

    public void setVaginal(Integer vaginal) {
        this.vaginal = vaginal;
    }

    public Integer getCaesarean() {
        return caesarean;
    }

    public void setCaesarean(Integer caesarean) {
        this.caesarean = caesarean;
    }

    public Date getLastdatepregnacy() {
        return lastdatepregnacy;
    }

    public void setLastdatepregnacy(Date lastdatepregnacy) {
        this.lastdatepregnacy = lastdatepregnacy;
    }

    public Integer getRnhigherweight() {
        return rnhigherweight;
    }

    public void setRnhigherweight(Integer rnhigherweight) {
        this.rnhigherweight = rnhigherweight;
    }

    public Integer getRnlowerweight() {
        return rnlowerweight;
    }

    public void setRnlowerweight(Integer rnlowerweight) {
        this.rnlowerweight = rnlowerweight;
    }

    public Databirths getDatabirths() {
        return databirths;
    }

    public void setDatabirths(Databirths databirths) {
        this.databirths = databirths;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (obstetricdataPK != null ? obstetricdataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obstetricdata)) {
            return false;
        }
        Obstetricdata other = (Obstetricdata) object;
        if ((this.obstetricdataPK == null && other.obstetricdataPK != null) || (this.obstetricdataPK != null && !this.obstetricdataPK.equals(other.obstetricdataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Obstetricdata[ obstetricdataPK=" + obstetricdataPK + " ]";
    }
    
}
