/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "statusclinicalepisode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statusclinicalepisode.findAll", query = "SELECT s FROM Statusclinicalepisode s"),
    @NamedQuery(name = "Statusclinicalepisode.findByStatusepisodeid", query = "SELECT s FROM Statusclinicalepisode s WHERE s.statusepisodeid = :statusepisodeid"),
    @NamedQuery(name = "Statusclinicalepisode.findByStatusepisodename", query = "SELECT s FROM Statusclinicalepisode s WHERE s.statusepisodename = :statusepisodename")})
public class Statusclinicalepisode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "statusepisodeid")
    private Integer statusepisodeid;
    @Size(max = 20)
    @Column(name = "statusepisodename")
    private String statusepisodename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusepisodeid")
    private List<Clinicalepisode> clinicalepisodeList;

    public Statusclinicalepisode() {
    }

    public Statusclinicalepisode(Integer statusepisodeid) {
        this.statusepisodeid = statusepisodeid;
    }

    public Integer getStatusepisodeid() {
        return statusepisodeid;
    }

    public void setStatusepisodeid(Integer statusepisodeid) {
        this.statusepisodeid = statusepisodeid;
    }

    public String getStatusepisodename() {
        return statusepisodename;
    }

    public void setStatusepisodename(String statusepisodename) {
        this.statusepisodename = statusepisodename;
    }

    @XmlTransient
    public List<Clinicalepisode> getClinicalepisodeList() {
        return clinicalepisodeList;
    }

    public void setClinicalepisodeList(List<Clinicalepisode> clinicalepisodeList) {
        this.clinicalepisodeList = clinicalepisodeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusepisodeid != null ? statusepisodeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statusclinicalepisode)) {
            return false;
        }
        Statusclinicalepisode other = (Statusclinicalepisode) object;
        if ((this.statusepisodeid == null && other.statusepisodeid != null) || (this.statusepisodeid != null && !this.statusepisodeid.equals(other.statusepisodeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Statusclinicalepisode[ statusepisodeid=" + statusepisodeid + " ]";
    }
    
}
