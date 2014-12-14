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
@Table(name = "maternalpathologies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maternalpathologies.findAll", query = "SELECT m FROM Maternalpathologies m"),
    @NamedQuery(name = "Maternalpathologies.findByObservation", query = "SELECT m FROM Maternalpathologies m WHERE m.observation = :observation"),
    @NamedQuery(name = "Maternalpathologies.findByPatologiemid", query = "SELECT m FROM Maternalpathologies m WHERE m.maternalpathologiesPK.patologiemid = :patologiemid"),
    @NamedQuery(name = "Maternalpathologies.findByPersonrut", query = "SELECT m FROM Maternalpathologies m WHERE m.maternalpathologiesPK.personrut = :personrut"),
    @NamedQuery(name = "Maternalpathologies.findByPersondv", query = "SELECT m FROM Maternalpathologies m WHERE m.maternalpathologiesPK.persondv = :persondv"),
    @NamedQuery(name = "Maternalpathologies.findByPersonnationality", query = "SELECT m FROM Maternalpathologies m WHERE m.maternalpathologiesPK.personnationality = :personnationality"),
    @NamedQuery(name = "Maternalpathologies.findByRecordnumber", query = "SELECT m FROM Maternalpathologies m WHERE m.maternalpathologiesPK.recordnumber = :recordnumber"),
    @NamedQuery(name = "Maternalpathologies.findByEpisodenumber", query = "SELECT m FROM Maternalpathologies m WHERE m.maternalpathologiesPK.episodenumber = :episodenumber")})
public class Maternalpathologies implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MaternalpathologiesPK maternalpathologiesPK;
    @Size(max = 2147483647)
    @Column(name = "observation")
    private String observation;
    @JoinColumn(name = "pathologieid", referencedColumnName = "pathologieid")
    @ManyToOne(optional = false)
    private Pathologie pathologieid;
    @JoinColumns({
        @JoinColumn(name = "personrut", referencedColumnName = "personrut", insertable = false, updatable = false),
        @JoinColumn(name = "persondv", referencedColumnName = "persondv", insertable = false, updatable = false),
        @JoinColumn(name = "personnationality", referencedColumnName = "personnationality", insertable = false, updatable = false),
        @JoinColumn(name = "recordnumber", referencedColumnName = "recordnumber", insertable = false, updatable = false),
        @JoinColumn(name = "episodenumber", referencedColumnName = "episodenumber", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Datarecordobstetric datarecordobstetric;

    public Maternalpathologies() {
    }

    public Maternalpathologies(MaternalpathologiesPK maternalpathologiesPK) {
        this.maternalpathologiesPK = maternalpathologiesPK;
    }

    public Maternalpathologies(int patologiemid, int personrut, String persondv, int personnationality, int recordnumber, int episodenumber) {
        this.maternalpathologiesPK = new MaternalpathologiesPK(patologiemid, personrut, persondv, personnationality, recordnumber, episodenumber);
    }

    public MaternalpathologiesPK getMaternalpathologiesPK() {
        return maternalpathologiesPK;
    }

    public void setMaternalpathologiesPK(MaternalpathologiesPK maternalpathologiesPK) {
        this.maternalpathologiesPK = maternalpathologiesPK;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Pathologie getPathologieid() {
        return pathologieid;
    }

    public void setPathologieid(Pathologie pathologieid) {
        this.pathologieid = pathologieid;
    }

    public Datarecordobstetric getDatarecordobstetric() {
        return datarecordobstetric;
    }

    public void setDatarecordobstetric(Datarecordobstetric datarecordobstetric) {
        this.datarecordobstetric = datarecordobstetric;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maternalpathologiesPK != null ? maternalpathologiesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maternalpathologies)) {
            return false;
        }
        Maternalpathologies other = (Maternalpathologies) object;
        if ((this.maternalpathologiesPK == null && other.maternalpathologiesPK != null) || (this.maternalpathologiesPK != null && !this.maternalpathologiesPK.equals(other.maternalpathologiesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Maternalpathologies[ maternalpathologiesPK=" + maternalpathologiesPK + " ]";
    }
    
}
