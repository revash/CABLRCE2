/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByRut", query = "SELECT p FROM Person p WHERE p.personPK.rut = :rut"),
    @NamedQuery(name = "Person.findByDv", query = "SELECT p FROM Person p WHERE p.personPK.dv = :dv"),
    @NamedQuery(name = "Person.findByNationalityid", query = "SELECT p FROM Person p WHERE p.personPK.nationalityid = :nationalityid"),
    @NamedQuery(name = "Person.findByNames", query = "SELECT p FROM Person p WHERE p.names = :names"),
    @NamedQuery(name = "Person.findByLastname", query = "SELECT p FROM Person p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Person.findBySecondlastname", query = "SELECT p FROM Person p WHERE p.secondlastname = :secondlastname"),
    @NamedQuery(name = "Person.findByPhone", query = "SELECT p FROM Person p WHERE p.phone = :phone"),
    @NamedQuery(name = "Person.findByCellphone", query = "SELECT p FROM Person p WHERE p.cellphone = :cellphone"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByAddress", query = "SELECT p FROM Person p WHERE p.address = :address"),
    @NamedQuery(name = "Person.findByBirthdate", query = "SELECT p FROM Person p WHERE p.birthdate = :birthdate")})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonPK personPK;
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
    @Size(max = 120)
    @Column(name = "address")
    private String address;
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @JoinColumn(name = "tipeprevid", referencedColumnName = "tipeprevid")
    @ManyToOne(optional = false)
    private Tipeprevision tipeprevid;
    @JoinColumn(name = "sexid", referencedColumnName = "sexid")
    @ManyToOne(optional = false)
    private Sex sexid;
    @JoinColumn(name = "religionid", referencedColumnName = "religionid")
    @ManyToOne(optional = false)
    private Religion religionid;
    @JoinColumn(name = "nativetownsid", referencedColumnName = "nativetownsid")
    @ManyToOne(optional = false)
    private Nativetowns nativetownsid;
    @JoinColumn(name = "nationalityid", referencedColumnName = "nationalityid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nationality nationality;
    @JoinColumn(name = "maritalstatusid", referencedColumnName = "maritalstatusid")
    @ManyToOne(optional = false)
    private Maritalstatus maritalstatusid;
    @JoinColumn(name = "elevelid", referencedColumnName = "elevelid")
    @ManyToOne(optional = false)
    private Educationallevel elevelid;
    @JoinColumn(name = "communeid", referencedColumnName = "communeid")
    @ManyToOne(optional = false)
    private Commune communeid;
    @JoinColumn(name = "bgroupid", referencedColumnName = "bgroupid")
    @ManyToOne(optional = false)
    private Bloodgroup bgroupid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Patientrecord> patientrecordList;

    public Person() {
    }

    public Person(PersonPK personPK) {
        this.personPK = personPK;
    }

    public Person(int rut, String dv, int nationalityid) {
        this.personPK = new PersonPK(rut, dv, nationalityid);
    }

    public PersonPK getPersonPK() {
        return personPK;
    }

    public void setPersonPK(PersonPK personPK) {
        this.personPK = personPK;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Tipeprevision getTipeprevid() {
        return tipeprevid;
    }

    public void setTipeprevid(Tipeprevision tipeprevid) {
        this.tipeprevid = tipeprevid;
    }

    public Sex getSexid() {
        return sexid;
    }

    public void setSexid(Sex sexid) {
        this.sexid = sexid;
    }

    public Religion getReligionid() {
        return religionid;
    }

    public void setReligionid(Religion religionid) {
        this.religionid = religionid;
    }

    public Nativetowns getNativetownsid() {
        return nativetownsid;
    }

    public void setNativetownsid(Nativetowns nativetownsid) {
        this.nativetownsid = nativetownsid;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Maritalstatus getMaritalstatusid() {
        return maritalstatusid;
    }

    public void setMaritalstatusid(Maritalstatus maritalstatusid) {
        this.maritalstatusid = maritalstatusid;
    }

    public Educationallevel getElevelid() {
        return elevelid;
    }

    public void setElevelid(Educationallevel elevelid) {
        this.elevelid = elevelid;
    }

    public Commune getCommuneid() {
        return communeid;
    }

    public void setCommuneid(Commune communeid) {
        this.communeid = communeid;
    }

    public Bloodgroup getBgroupid() {
        return bgroupid;
    }

    public void setBgroupid(Bloodgroup bgroupid) {
        this.bgroupid = bgroupid;
    }

    @XmlTransient
    public List<Patientrecord> getPatientrecordList() {
        return patientrecordList;
    }

    public void setPatientrecordList(List<Patientrecord> patientrecordList) {
        this.patientrecordList = patientrecordList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personPK != null ? personPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personPK == null && other.personPK != null) || (this.personPK != null && !this.personPK.equals(other.personPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Person[ personPK=" + personPK + " ]";
    }
    
}
