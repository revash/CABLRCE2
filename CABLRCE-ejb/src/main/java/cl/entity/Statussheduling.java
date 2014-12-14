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
@Table(name = "statussheduling")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statussheduling.findAll", query = "SELECT s FROM Statussheduling s"),
    @NamedQuery(name = "Statussheduling.findByStatusshedulingid", query = "SELECT s FROM Statussheduling s WHERE s.statusshedulingid = :statusshedulingid"),
    @NamedQuery(name = "Statussheduling.findByStatusshedulingname", query = "SELECT s FROM Statussheduling s WHERE s.statusshedulingname = :statusshedulingname")})
public class Statussheduling implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "statusshedulingid")
    private Integer statusshedulingid;
    @Size(max = 20)
    @Column(name = "statusshedulingname")
    private String statusshedulingname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusshedulingid")
    private List<Scheduling> schedulingList;

    public Statussheduling() {
    }

    public Statussheduling(Integer statusshedulingid) {
        this.statusshedulingid = statusshedulingid;
    }

    public Integer getStatusshedulingid() {
        return statusshedulingid;
    }

    public void setStatusshedulingid(Integer statusshedulingid) {
        this.statusshedulingid = statusshedulingid;
    }

    public String getStatusshedulingname() {
        return statusshedulingname;
    }

    public void setStatusshedulingname(String statusshedulingname) {
        this.statusshedulingname = statusshedulingname;
    }

    @XmlTransient
    public List<Scheduling> getSchedulingList() {
        return schedulingList;
    }

    public void setSchedulingList(List<Scheduling> schedulingList) {
        this.schedulingList = schedulingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusshedulingid != null ? statusshedulingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statussheduling)) {
            return false;
        }
        Statussheduling other = (Statussheduling) object;
        if ((this.statusshedulingid == null && other.statusshedulingid != null) || (this.statusshedulingid != null && !this.statusshedulingid.equals(other.statusshedulingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Statussheduling[ statusshedulingid=" + statusshedulingid + " ]";
    }
    
}
