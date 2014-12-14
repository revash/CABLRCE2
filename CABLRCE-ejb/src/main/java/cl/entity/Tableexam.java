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
@Table(name = "tableexam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tableexam.findAll", query = "SELECT t FROM Tableexam t"),
    @NamedQuery(name = "Tableexam.findByExamid", query = "SELECT t FROM Tableexam t WHERE t.examid = :examid"),
    @NamedQuery(name = "Tableexam.findByExamname", query = "SELECT t FROM Tableexam t WHERE t.examname = :examname"),
    @NamedQuery(name = "Tableexam.findByExamindications", query = "SELECT t FROM Tableexam t WHERE t.examindications = :examindications")})
public class Tableexam implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "examid")
    private Integer examid;
    @Size(max = 100)
    @Column(name = "examname")
    private String examname;
    @Size(max = 2147483647)
    @Column(name = "examindications")
    private String examindications;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examid")
    private List<Examsrequested> examsrequestedList;

    public Tableexam() {
    }

    public Tableexam(Integer examid) {
        this.examid = examid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname;
    }

    public String getExamindications() {
        return examindications;
    }

    public void setExamindications(String examindications) {
        this.examindications = examindications;
    }

    @XmlTransient
    public List<Examsrequested> getExamsrequestedList() {
        return examsrequestedList;
    }

    public void setExamsrequestedList(List<Examsrequested> examsrequestedList) {
        this.examsrequestedList = examsrequestedList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examid != null ? examid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tableexam)) {
            return false;
        }
        Tableexam other = (Tableexam) object;
        if ((this.examid == null && other.examid != null) || (this.examid != null && !this.examid.equals(other.examid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Tableexam[ examid=" + examid + " ]";
    }
    
}
