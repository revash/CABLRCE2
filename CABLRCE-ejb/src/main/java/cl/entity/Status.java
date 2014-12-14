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
@Table(name = "status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s"),
    @NamedQuery(name = "Status.findByStatusid", query = "SELECT s FROM Status s WHERE s.statusid = :statusid"),
    @NamedQuery(name = "Status.findByStatusname", query = "SELECT s FROM Status s WHERE s.statusname = :statusname")})
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "statusid")
    private Integer statusid;
    @Size(max = 30)
    @Column(name = "statusname")
    private String statusname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusid")
    private List<Medicalhypothesis> medicalhypothesisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusid")
    private List<Diagnostic> diagnosticList;

    public Status() {
    }

    public Status(Integer statusid) {
        this.statusid = statusid;
    }

    public Integer getStatusid() {
        return statusid;
    }

    public void setStatusid(Integer statusid) {
        this.statusid = statusid;
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }

    @XmlTransient
    public List<Medicalhypothesis> getMedicalhypothesisList() {
        return medicalhypothesisList;
    }

    public void setMedicalhypothesisList(List<Medicalhypothesis> medicalhypothesisList) {
        this.medicalhypothesisList = medicalhypothesisList;
    }

    @XmlTransient
    public List<Diagnostic> getDiagnosticList() {
        return diagnosticList;
    }

    public void setDiagnosticList(List<Diagnostic> diagnosticList) {
        this.diagnosticList = diagnosticList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusid != null ? statusid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.statusid == null && other.statusid != null) || (this.statusid != null && !this.statusid.equals(other.statusid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Status[ statusid=" + statusid + " ]";
    }
    
}
