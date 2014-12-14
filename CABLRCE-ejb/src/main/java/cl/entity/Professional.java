/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "professional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professional.findAll", query = "SELECT p FROM Professional p"),
    @NamedQuery(name = "Professional.findByRut", query = "SELECT p FROM Professional p WHERE p.professionalPK.rut = :rut"),
    @NamedQuery(name = "Professional.findByDv", query = "SELECT p FROM Professional p WHERE p.professionalPK.dv = :dv"),
    @NamedQuery(name = "Professional.findByNames", query = "SELECT p FROM Professional p WHERE p.names = :names"),
    @NamedQuery(name = "Professional.findByLastname", query = "SELECT p FROM Professional p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Professional.findBySecondlastname", query = "SELECT p FROM Professional p WHERE p.secondlastname = :secondlastname"),
    @NamedQuery(name = "Professional.findByPhone", query = "SELECT p FROM Professional p WHERE p.phone = :phone"),
    @NamedQuery(name = "Professional.findByCellphone", query = "SELECT p FROM Professional p WHERE p.cellphone = :cellphone"),
    @NamedQuery(name = "Professional.findByEmail", query = "SELECT p FROM Professional p WHERE p.email = :email"),
    @NamedQuery(name = "Professional.findByAddress", query = "SELECT p FROM Professional p WHERE p.address = :address"),
    @NamedQuery(name = "Professional.findByPassword", query = "SELECT p FROM Professional p WHERE p.password = :password")})
public class Professional implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProfessionalPK professionalPK;
    @Size(max = 120)
    @Column(name = "names")
    private String names;
    @Size(max = 50)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 50)
    @Column(name = "secondlastname")
    private String secondlastname;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 9)
    @Column(name = "phone")
    private String phone;
    @Size(max = 9)
    @Column(name = "cellphone")
    private String cellphone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "address")
    private String address;
    @Size(max = 2147483647)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professional")
    private List<Scheduling> schedulingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professional")
    private List<Patientrecord> patientrecordList;
    @JoinColumn(name = "specialityid", referencedColumnName = "specialityid")
    @ManyToOne(optional = false)
    private Speciality specialityid;
    @JoinColumn(name = "roleid", referencedColumnName = "roleid")
    @ManyToOne(optional = false)
    private Role roleid;

    public Professional() {
    }

    public Professional(ProfessionalPK professionalPK) {
        this.professionalPK = professionalPK;
    }

    public Professional(int rut, String dv) {
        this.professionalPK = new ProfessionalPK(rut, dv);
    }

    public ProfessionalPK getProfessionalPK() {
        return professionalPK;
    }

    public void setProfessionalPK(ProfessionalPK professionalPK) {
        this.professionalPK = professionalPK;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondlastname() {
        return secondlastname;
    }

    public void setSecondlastname(String secondlastname) {
        this.secondlastname = secondlastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Scheduling> getSchedulingList() {
        return schedulingList;
    }

    public void setSchedulingList(List<Scheduling> schedulingList) {
        this.schedulingList = schedulingList;
    }

    @XmlTransient
    public List<Patientrecord> getPatientrecordList() {
        return patientrecordList;
    }

    public void setPatientrecordList(List<Patientrecord> patientrecordList) {
        this.patientrecordList = patientrecordList;
    }

    public Speciality getSpecialityid() {
        return specialityid;
    }

    public void setSpecialityid(Speciality specialityid) {
        this.specialityid = specialityid;
    }

    public Role getRoleid() {
        return roleid;
    }

    public void setRoleid(Role roleid) {
        this.roleid = roleid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (professionalPK != null ? professionalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professional)) {
            return false;
        }
        Professional other = (Professional) object;
        if ((this.professionalPK == null && other.professionalPK != null) || (this.professionalPK != null && !this.professionalPK.equals(other.professionalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Professional[ professionalPK=" + professionalPK + " ]";
    }
    
}
