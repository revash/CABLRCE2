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
@Table(name = "recipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r"),
    @NamedQuery(name = "Recipe.findByControlid", query = "SELECT r FROM Recipe r WHERE r.recipePK.controlid = :controlid"),
    @NamedQuery(name = "Recipe.findByEpisodeid", query = "SELECT r FROM Recipe r WHERE r.recipePK.episodeid = :episodeid"),
    @NamedQuery(name = "Recipe.findByRut", query = "SELECT r FROM Recipe r WHERE r.recipePK.rut = :rut"),
    @NamedQuery(name = "Recipe.findByDv", query = "SELECT r FROM Recipe r WHERE r.recipePK.dv = :dv"),
    @NamedQuery(name = "Recipe.findByRecordnumber", query = "SELECT r FROM Recipe r WHERE r.recipePK.recordnumber = :recordnumber"),
    @NamedQuery(name = "Recipe.findByNationalityid", query = "SELECT r FROM Recipe r WHERE r.recipePK.nationalityid = :nationalityid"),
    @NamedQuery(name = "Recipe.findByRecipeid", query = "SELECT r FROM Recipe r WHERE r.recipePK.recipeid = :recipeid"),
    @NamedQuery(name = "Recipe.findByDate", query = "SELECT r FROM Recipe r WHERE r.date = :date"),
    @NamedQuery(name = "Recipe.findByBody", query = "SELECT r FROM Recipe r WHERE r.body = :body")})
public class Recipe implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecipePK recipePK;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 2147483647)
    @Column(name = "body")
    private String body;
    @JoinColumns({
        @JoinColumn(name = "controlid", referencedColumnName = "controlid", insertable = false, updatable = false),
        @JoinColumn(name = "episodeid", referencedColumnName = "episodeid", insertable = false, updatable = false),
        @JoinColumn(name = "rut", referencedColumnName = "rut", insertable = false, updatable = false),
        @JoinColumn(name = "dv", referencedColumnName = "dv", insertable = false, updatable = false),
        @JoinColumn(name = "recordnumber", referencedColumnName = "recordnumber", insertable = false, updatable = false),
        @JoinColumn(name = "nationalityid", referencedColumnName = "nationalityid", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Mediccontrol mediccontrol;

    public Recipe() {
    }

    public Recipe(RecipePK recipePK) {
        this.recipePK = recipePK;
    }

    public Recipe(int controlid, int episodeid, int rut, String dv, int recordnumber, int nationalityid, int recipeid) {
        this.recipePK = new RecipePK(controlid, episodeid, rut, dv, recordnumber, nationalityid, recipeid);
    }

    public RecipePK getRecipePK() {
        return recipePK;
    }

    public void setRecipePK(RecipePK recipePK) {
        this.recipePK = recipePK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Mediccontrol getMediccontrol() {
        return mediccontrol;
    }

    public void setMediccontrol(Mediccontrol mediccontrol) {
        this.mediccontrol = mediccontrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipePK != null ? recipePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.recipePK == null && other.recipePK != null) || (this.recipePK != null && !this.recipePK.equals(other.recipePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Recipe[ recipePK=" + recipePK + " ]";
    }
    
}
