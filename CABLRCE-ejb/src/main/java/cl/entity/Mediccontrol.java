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
import javax.persistence.JoinColumns;
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
@Table(name = "mediccontrol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mediccontrol.findAll", query = "SELECT m FROM Mediccontrol m"),
    @NamedQuery(name = "Mediccontrol.findByControlid", query = "SELECT m FROM Mediccontrol m WHERE m.mediccontrolPK.controlid = :controlid"),
    @NamedQuery(name = "Mediccontrol.findByEpisodeid", query = "SELECT m FROM Mediccontrol m WHERE m.mediccontrolPK.episodeid = :episodeid"),
    @NamedQuery(name = "Mediccontrol.findByRut", query = "SELECT m FROM Mediccontrol m WHERE m.mediccontrolPK.rut = :rut"),
    @NamedQuery(name = "Mediccontrol.findByDv", query = "SELECT m FROM Mediccontrol m WHERE m.mediccontrolPK.dv = :dv"),
    @NamedQuery(name = "Mediccontrol.findByRecordnumber", query = "SELECT m FROM Mediccontrol m WHERE m.mediccontrolPK.recordnumber = :recordnumber"),
    @NamedQuery(name = "Mediccontrol.findByNationalityid", query = "SELECT m FROM Mediccontrol m WHERE m.mediccontrolPK.nationalityid = :nationalityid"),
    @NamedQuery(name = "Mediccontrol.findByDate", query = "SELECT m FROM Mediccontrol m WHERE m.date = :date"),
    @NamedQuery(name = "Mediccontrol.findByWeight", query = "SELECT m FROM Mediccontrol m WHERE m.weight = :weight"),
    @NamedQuery(name = "Mediccontrol.findByBloodpressure", query = "SELECT m FROM Mediccontrol m WHERE m.bloodpressure = :bloodpressure"),
    @NamedQuery(name = "Mediccontrol.findByTemperature", query = "SELECT m FROM Mediccontrol m WHERE m.temperature = :temperature"),
    @NamedQuery(name = "Mediccontrol.findByPulse", query = "SELECT m FROM Mediccontrol m WHERE m.pulse = :pulse"),
    @NamedQuery(name = "Mediccontrol.findBySize", query = "SELECT m FROM Mediccontrol m WHERE m.size = :size"),
    @NamedQuery(name = "Mediccontrol.findByImc", query = "SELECT m FROM Mediccontrol m WHERE m.imc = :imc"),
    @NamedQuery(name = "Mediccontrol.findByPhysicalexamination", query = "SELECT m FROM Mediccontrol m WHERE m.physicalexamination = :physicalexamination"),
    @NamedQuery(name = "Mediccontrol.findByIndications", query = "SELECT m FROM Mediccontrol m WHERE m.indications = :indications"),
    @NamedQuery(name = "Mediccontrol.findByObservations", query = "SELECT m FROM Mediccontrol m WHERE m.observations = :observations"),
    @NamedQuery(name = "Mediccontrol.findByHistory", query = "SELECT m FROM Mediccontrol m WHERE m.history = :history"),
    @NamedQuery(name = "Mediccontrol.findByCorrelativerecipies", query = "SELECT m FROM Mediccontrol m WHERE m.correlativerecipies = :correlativerecipies"),
    @NamedQuery(name = "Mediccontrol.findByCorrelativetreatment", query = "SELECT m FROM Mediccontrol m WHERE m.correlativetreatment = :correlativetreatment")})
public class Mediccontrol implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MediccontrolPK mediccontrolPK;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "weight")
    private Double weight;
    @Column(name = "bloodpressure")
    private Integer bloodpressure;
    @Column(name = "temperature")
    private Double temperature;
    @Column(name = "pulse")
    private Integer pulse;
    @Column(name = "size")
    private Double size;
    @Column(name = "imc")
    private Double imc;
    @Size(max = 2147483647)
    @Column(name = "physicalexamination")
    private String physicalexamination;
    @Size(max = 2147483647)
    @Column(name = "indications")
    private String indications;
    @Size(max = 2147483647)
    @Column(name = "observations")
    private String observations;
    @Size(max = 2147483647)
    @Column(name = "history")
    private String history;
    @Column(name = "correlativerecipies")
    private Integer correlativerecipies;
    @Column(name = "correlativetreatment")
    private Integer correlativetreatment;
    @Column(name = "status")
    private Integer status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediccontrol")
    private List<Recipe> recipeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediccontrol")
    private List<Treatment> treatmentList;
    @JoinColumns({
        @JoinColumn(name = "episodeid", referencedColumnName = "episodeid", insertable = false, updatable = false),
        @JoinColumn(name = "rut", referencedColumnName = "rut", insertable = false, updatable = false),
        @JoinColumn(name = "dv", referencedColumnName = "dv", insertable = false, updatable = false),
        @JoinColumn(name = "recordnumber", referencedColumnName = "recordnumber", insertable = false, updatable = false),
        @JoinColumn(name = "nationalityid", referencedColumnName = "nationalityid", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Clinicalepisode clinicalepisode;

    public Mediccontrol() {
    }

    public Mediccontrol(MediccontrolPK mediccontrolPK) {
        this.mediccontrolPK = mediccontrolPK;
    }

    public Mediccontrol(int controlid, int episodeid, int rut, String dv, int recordnumber, int nationalityid) {
        this.mediccontrolPK = new MediccontrolPK(controlid, episodeid, rut, dv, recordnumber, nationalityid);
    }

    public MediccontrolPK getMediccontrolPK() {
        return mediccontrolPK;
    }

    public void setMediccontrolPK(MediccontrolPK mediccontrolPK) {
        this.mediccontrolPK = mediccontrolPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date2) {
        this.date = date2;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getBloodpressure() {
        return bloodpressure;
    }

    public void setBloodpressure(Integer bloodpressure) {
        this.bloodpressure = bloodpressure;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size2) {
        this.size = size2;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public String getPhysicalexamination() {
        return physicalexamination;
    }

    public void setPhysicalexamination(String physicalexamination) {
        this.physicalexamination = physicalexamination;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Integer getCorrelativerecipies() {
        return correlativerecipies;
    }

    public void setCorrelativerecipies(Integer correlativerecipies) {
        this.correlativerecipies = correlativerecipies;
    }

    public Integer getCorrelativetreatment() {
        return correlativetreatment;
    }

    public void setCorrelativetreatment(Integer correlativetreatment) {
        this.correlativetreatment = correlativetreatment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    

    @XmlTransient
    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @XmlTransient
    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(List<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }

    public Clinicalepisode getClinicalepisode() {
        return clinicalepisode;
    }

    public void setClinicalepisode(Clinicalepisode clinicalepisode) {
        this.clinicalepisode = clinicalepisode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mediccontrolPK != null ? mediccontrolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mediccontrol)) {
            return false;
        }
        Mediccontrol other = (Mediccontrol) object;
        if ((this.mediccontrolPK == null && other.mediccontrolPK != null) || (this.mediccontrolPK != null && !this.mediccontrolPK.equals(other.mediccontrolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Mediccontrol[ mediccontrolPK=" + mediccontrolPK + " ]";
    }
    
}
