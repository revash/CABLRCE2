/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "recordcontroldiabetic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recordcontroldiabetic.findAll", query = "SELECT r FROM Recordcontroldiabetic r"),
    @NamedQuery(name = "Recordcontroldiabetic.findByDiabcontrolid", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.recordcontroldiabeticPK.diabcontrolid = :diabcontrolid"),
    @NamedQuery(name = "Recordcontroldiabetic.findByEpisodeid", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.recordcontroldiabeticPK.episodeid = :episodeid"),
    @NamedQuery(name = "Recordcontroldiabetic.findByRut", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.recordcontroldiabeticPK.rut = :rut"),
    @NamedQuery(name = "Recordcontroldiabetic.findByDv", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.recordcontroldiabeticPK.dv = :dv"),
    @NamedQuery(name = "Recordcontroldiabetic.findByRecordnumber", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.recordcontroldiabeticPK.recordnumber = :recordnumber"),
    @NamedQuery(name = "Recordcontroldiabetic.findByNationalityid", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.recordcontroldiabeticPK.nationalityid = :nationalityid"),
    @NamedQuery(name = "Recordcontroldiabetic.findByDiabcontrolid2", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.recordcontroldiabeticPK.diabcontrolid2 = :diabcontrolid2"),
    @NamedQuery(name = "Recordcontroldiabetic.findByDate", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.date = :date"),
    @NamedQuery(name = "Recordcontroldiabetic.findByEg", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.eg = :eg"),
    @NamedQuery(name = "Recordcontroldiabetic.findByWeigth", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.weigth = :weigth"),
    @NamedQuery(name = "Recordcontroldiabetic.findByNutritionalstatus", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.nutritionalstatus = :nutritionalstatus"),
    @NamedQuery(name = "Recordcontroldiabetic.findByPa", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.pa = :pa"),
    @NamedQuery(name = "Recordcontroldiabetic.findByAu", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.au = :au"),
    @NamedQuery(name = "Recordcontroldiabetic.findByInsulin", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.insulin = :insulin"),
    @NamedQuery(name = "Recordcontroldiabetic.findByGlycemiafasting", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.glycemiafasting = :glycemiafasting"),
    @NamedQuery(name = "Recordcontroldiabetic.findByGlycemiapostbreakfast", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.glycemiapostbreakfast = :glycemiapostbreakfast"),
    @NamedQuery(name = "Recordcontroldiabetic.findByGlycemiapostlunch", query = "SELECT r FROM Recordcontroldiabetic r WHERE r.glycemiapostlunch = :glycemiapostlunch")})
public class Recordcontroldiabetic implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecordcontroldiabeticPK recordcontroldiabeticPK;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 100)
    @Column(name = "eg")
    private String eg;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "weigth")
    private Double weigth;
    @Size(max = 2147483647)
    @Column(name = "nutritionalstatus")
    private String nutritionalstatus;
    @Column(name = "pa")
    private Integer pa;
    @Size(max = 100)
    @Column(name = "au")
    private String au;
    @Column(name = "insulin")
    private Integer insulin;
    @Column(name = "glycemiafasting")
    private Integer glycemiafasting;
    @Column(name = "glycemiapostbreakfast")
    private Integer glycemiapostbreakfast;
    @Column(name = "glycemiapostlunch")
    private Integer glycemiapostlunch;
    @JoinColumns({
        @JoinColumn(name = "diabcontrolid", referencedColumnName = "diabcontrolid", insertable = false, updatable = false),
        @JoinColumn(name = "episodeid", referencedColumnName = "episodeid", insertable = false, updatable = false),
        @JoinColumn(name = "rut", referencedColumnName = "rut", insertable = false, updatable = false),
        @JoinColumn(name = "dv", referencedColumnName = "dv", insertable = false, updatable = false),
        @JoinColumn(name = "recordnumber", referencedColumnName = "recordnumber", insertable = false, updatable = false),
        @JoinColumn(name = "nationalityid", referencedColumnName = "nationalityid", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Diabeticcontrol diabeticcontrol;

    public Recordcontroldiabetic() {
    }

    public Recordcontroldiabetic(RecordcontroldiabeticPK recordcontroldiabeticPK) {
        this.recordcontroldiabeticPK = recordcontroldiabeticPK;
    }

    public Recordcontroldiabetic(int diabcontrolid, int episodeid, int rut, String dv, int recordnumber, int nationalityid, int diabcontrolid2) {
        this.recordcontroldiabeticPK = new RecordcontroldiabeticPK(diabcontrolid, episodeid, rut, dv, recordnumber, nationalityid, diabcontrolid2);
    }

    public RecordcontroldiabeticPK getRecordcontroldiabeticPK() {
        return recordcontroldiabeticPK;
    }

    public void setRecordcontroldiabeticPK(RecordcontroldiabeticPK recordcontroldiabeticPK) {
        this.recordcontroldiabeticPK = recordcontroldiabeticPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEg() {
        return eg;
    }

    public void setEg(String eg) {
        this.eg = eg;
    }

    public Double getWeigth() {
        return weigth;
    }

    public void setWeigth(Double weigth) {
        this.weigth = weigth;
    }

    public String getNutritionalstatus() {
        return nutritionalstatus;
    }

    public void setNutritionalstatus(String nutritionalstatus) {
        this.nutritionalstatus = nutritionalstatus;
    }

    public Integer getPa() {
        return pa;
    }

    public void setPa(Integer pa) {
        this.pa = pa;
    }

    public String getAu() {
        return au;
    }

    public void setAu(String au) {
        this.au = au;
    }

    public Integer getInsulin() {
        return insulin;
    }

    public void setInsulin(Integer insulin) {
        this.insulin = insulin;
    }

    public Integer getGlycemiafasting() {
        return glycemiafasting;
    }

    public void setGlycemiafasting(Integer glycemiafasting) {
        this.glycemiafasting = glycemiafasting;
    }

    public Integer getGlycemiapostbreakfast() {
        return glycemiapostbreakfast;
    }

    public void setGlycemiapostbreakfast(Integer glycemiapostbreakfast) {
        this.glycemiapostbreakfast = glycemiapostbreakfast;
    }

    public Integer getGlycemiapostlunch() {
        return glycemiapostlunch;
    }

    public void setGlycemiapostlunch(Integer glycemiapostlunch) {
        this.glycemiapostlunch = glycemiapostlunch;
    }

    public Diabeticcontrol getDiabeticcontrol() {
        return diabeticcontrol;
    }

    public void setDiabeticcontrol(Diabeticcontrol diabeticcontrol) {
        this.diabeticcontrol = diabeticcontrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordcontroldiabeticPK != null ? recordcontroldiabeticPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recordcontroldiabetic)) {
            return false;
        }
        Recordcontroldiabetic other = (Recordcontroldiabetic) object;
        if ((this.recordcontroldiabeticPK == null && other.recordcontroldiabeticPK != null) || (this.recordcontroldiabeticPK != null && !this.recordcontroldiabeticPK.equals(other.recordcontroldiabeticPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Recordcontroldiabetic[ recordcontroldiabeticPK=" + recordcontroldiabeticPK + " ]";
    }
    
}
