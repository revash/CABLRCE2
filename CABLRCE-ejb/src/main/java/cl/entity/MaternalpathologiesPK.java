/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AndresEduardo
 */
@Embeddable
public class MaternalpathologiesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "patologiemid")
    private int patologiemid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "personrut")
    private int personrut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "persondv")
    private String persondv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "personnationality")
    private int personnationality;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recordnumber")
    private int recordnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "episodenumber")
    private int episodenumber;

    public MaternalpathologiesPK() {
    }

    public MaternalpathologiesPK(int patologiemid, int personrut, String persondv, int personnationality, int recordnumber, int episodenumber) {
        this.patologiemid = patologiemid;
        this.personrut = personrut;
        this.persondv = persondv;
        this.personnationality = personnationality;
        this.recordnumber = recordnumber;
        this.episodenumber = episodenumber;
    }

    public int getPatologiemid() {
        return patologiemid;
    }

    public void setPatologiemid(int patologiemid) {
        this.patologiemid = patologiemid;
    }

    public int getPersonrut() {
        return personrut;
    }

    public void setPersonrut(int personrut) {
        this.personrut = personrut;
    }

    public String getPersondv() {
        return persondv;
    }

    public void setPersondv(String persondv) {
        this.persondv = persondv;
    }

    public int getPersonnationality() {
        return personnationality;
    }

    public void setPersonnationality(int personnationality) {
        this.personnationality = personnationality;
    }

    public int getRecordnumber() {
        return recordnumber;
    }

    public void setRecordnumber(int recordnumber) {
        this.recordnumber = recordnumber;
    }

    public int getEpisodenumber() {
        return episodenumber;
    }

    public void setEpisodenumber(int episodenumber) {
        this.episodenumber = episodenumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) patologiemid;
        hash += (int) personrut;
        hash += (persondv != null ? persondv.hashCode() : 0);
        hash += (int) personnationality;
        hash += (int) recordnumber;
        hash += (int) episodenumber;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaternalpathologiesPK)) {
            return false;
        }
        MaternalpathologiesPK other = (MaternalpathologiesPK) object;
        if (this.patologiemid != other.patologiemid) {
            return false;
        }
        if (this.personrut != other.personrut) {
            return false;
        }
        if ((this.persondv == null && other.persondv != null) || (this.persondv != null && !this.persondv.equals(other.persondv))) {
            return false;
        }
        if (this.personnationality != other.personnationality) {
            return false;
        }
        if (this.recordnumber != other.recordnumber) {
            return false;
        }
        if (this.episodenumber != other.episodenumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.MaternalpathologiesPK[ patologiemid=" + patologiemid + ", personrut=" + personrut + ", persondv=" + persondv + ", personnationality=" + personnationality + ", recordnumber=" + recordnumber + ", episodenumber=" + episodenumber + " ]";
    }
    
}
