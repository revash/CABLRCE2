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
@Table(name = "pathologie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pathologie.findAll", query = "SELECT p FROM Pathologie p"),
    @NamedQuery(name = "Pathologie.findByPathologieid", query = "SELECT p FROM Pathologie p WHERE p.pathologieid = :pathologieid"),
    @NamedQuery(name = "Pathologie.findByPathologiename", query = "SELECT p FROM Pathologie p WHERE p.pathologiename = :pathologiename")})
public class Pathologie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pathologieid")
    private Integer pathologieid;
    @Size(max = 100)
    @Column(name = "pathologiename")
    private String pathologiename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pathologieid")
    private List<Diagnostic> diagnosticList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pathologieid")
    private List<Maternalpathologies> maternalpathologiesList;

    public Pathologie() {
    }

    public Pathologie(Integer pathologieid) {
        this.pathologieid = pathologieid;
    }

    public Integer getPathologieid() {
        return pathologieid;
    }

    public void setPathologieid(Integer pathologieid) {
        this.pathologieid = pathologieid;
    }

    public String getPathologiename() {
        return pathologiename;
    }

    public void setPathologiename(String pathologiename) {
        this.pathologiename = pathologiename;
    }

    @XmlTransient
    public List<Diagnostic> getDiagnosticList() {
        return diagnosticList;
    }

    public void setDiagnosticList(List<Diagnostic> diagnosticList) {
        this.diagnosticList = diagnosticList;
    }

    @XmlTransient
    public List<Maternalpathologies> getMaternalpathologiesList() {
        return maternalpathologiesList;
    }

    public void setMaternalpathologiesList(List<Maternalpathologies> maternalpathologiesList) {
        this.maternalpathologiesList = maternalpathologiesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pathologieid != null ? pathologieid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pathologie)) {
            return false;
        }
        Pathologie other = (Pathologie) object;
        if ((this.pathologieid == null && other.pathologieid != null) || (this.pathologieid != null && !this.pathologieid.equals(other.pathologieid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Pathologie[ pathologieid=" + pathologieid + " ]";
    }
    
}
