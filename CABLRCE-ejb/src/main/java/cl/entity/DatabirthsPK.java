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
public class DatabirthsPK implements Serializable {
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

    public DatabirthsPK() {
    }

    public DatabirthsPK(int personrut, String persondv, int personnationality, int recordnumber) {
        this.personrut = personrut;
        this.persondv = persondv;
        this.personnationality = personnationality;
        this.recordnumber = recordnumber;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personrut;
        hash += (persondv != null ? persondv.hashCode() : 0);
        hash += (int) personnationality;
        hash += (int) recordnumber;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatabirthsPK)) {
            return false;
        }
        DatabirthsPK other = (DatabirthsPK) object;
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
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.DatabirthsPK[ personrut=" + personrut + ", persondv=" + persondv + ", personnationality=" + personnationality + ", recordnumber=" + recordnumber + " ]";
    }
    
}
