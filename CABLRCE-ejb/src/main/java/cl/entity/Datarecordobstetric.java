/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "datarecordobstetric")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datarecordobstetric.findAll", query = "SELECT d FROM Datarecordobstetric d"),
    @NamedQuery(name = "Datarecordobstetric.findByEpisodenumber", query = "SELECT d FROM Datarecordobstetric d WHERE d.datarecordobstetricPK.episodenumber = :episodenumber"),
    @NamedQuery(name = "Datarecordobstetric.findByPersonrut", query = "SELECT d FROM Datarecordobstetric d WHERE d.datarecordobstetricPK.personrut = :personrut"),
    @NamedQuery(name = "Datarecordobstetric.findByPersondv", query = "SELECT d FROM Datarecordobstetric d WHERE d.datarecordobstetricPK.persondv = :persondv"),
    @NamedQuery(name = "Datarecordobstetric.findByPersonnationality", query = "SELECT d FROM Datarecordobstetric d WHERE d.datarecordobstetricPK.personnationality = :personnationality"),
    @NamedQuery(name = "Datarecordobstetric.findByRecordnumber", query = "SELECT d FROM Datarecordobstetric d WHERE d.datarecordobstetricPK.recordnumber = :recordnumber"),
    @NamedQuery(name = "Datarecordobstetric.findByCreatedate", query = "SELECT d FROM Datarecordobstetric d WHERE d.createdate = :createdate"),
    @NamedQuery(name = "Datarecordobstetric.findByAntecedent", query = "SELECT d FROM Datarecordobstetric d WHERE d.antecedent = :antecedent"),
    @NamedQuery(name = "Datarecordobstetric.findByFur", query = "SELECT d FROM Datarecordobstetric d WHERE d.fur = :fur"),
    @NamedQuery(name = "Datarecordobstetric.findByFurop", query = "SELECT d FROM Datarecordobstetric d WHERE d.furop = :furop"),
    @NamedQuery(name = "Datarecordobstetric.findByFpp", query = "SELECT d FROM Datarecordobstetric d WHERE d.fpp = :fpp"),
    @NamedQuery(name = "Datarecordobstetric.findByEcoEarly", query = "SELECT d FROM Datarecordobstetric d WHERE d.ecoEarly = :ecoEarly"),
    @NamedQuery(name = "Datarecordobstetric.findByEg", query = "SELECT d FROM Datarecordobstetric d WHERE d.eg = :eg"),
    @NamedQuery(name = "Datarecordobstetric.findByEgSem", query = "SELECT d FROM Datarecordobstetric d WHERE d.egSem = :egSem"),
    @NamedQuery(name = "Datarecordobstetric.findByAccording", query = "SELECT d FROM Datarecordobstetric d WHERE d.according = :according"),
    @NamedQuery(name = "Datarecordobstetric.findByParentname", query = "SELECT d FROM Datarecordobstetric d WHERE d.parentname = :parentname"),
    @NamedQuery(name = "Datarecordobstetric.findByReasonderivation", query = "SELECT d FROM Datarecordobstetric d WHERE d.reasonderivation = :reasonderivation"),
    @NamedQuery(name = "Datarecordobstetric.findByAu", query = "SELECT d FROM Datarecordobstetric d WHERE d.au = :au"),
    @NamedQuery(name = "Datarecordobstetric.findByLfc", query = "SELECT d FROM Datarecordobstetric d WHERE d.lfc = :lfc"),
    @NamedQuery(name = "Datarecordobstetric.findByDu", query = "SELECT d FROM Datarecordobstetric d WHERE d.du = :du"),
    @NamedQuery(name = "Datarecordobstetric.findByVaginalexamination", query = "SELECT d FROM Datarecordobstetric d WHERE d.vaginalexamination = :vaginalexamination"),
    @NamedQuery(name = "Datarecordobstetric.findByErasure", query = "SELECT d FROM Datarecordobstetric d WHERE d.erasure = :erasure"),
    @NamedQuery(name = "Datarecordobstetric.findByDilatation", query = "SELECT d FROM Datarecordobstetric d WHERE d.dilatation = :dilatation"),
    @NamedQuery(name = "Datarecordobstetric.findByScorebishop", query = "SELECT d FROM Datarecordobstetric d WHERE d.scorebishop = :scorebishop"),
    @NamedQuery(name = "Datarecordobstetric.findByPosition", query = "SELECT d FROM Datarecordobstetric d WHERE d.position = :position"),
    @NamedQuery(name = "Datarecordobstetric.findByConsistency", query = "SELECT d FROM Datarecordobstetric d WHERE d.consistency = :consistency"),
    @NamedQuery(name = "Datarecordobstetric.findByMembrane", query = "SELECT d FROM Datarecordobstetric d WHERE d.membrane = :membrane"),
    @NamedQuery(name = "Datarecordobstetric.findByControlcarop", query = "SELECT d FROM Datarecordobstetric d WHERE d.controlcarop = :controlcarop"),
    @NamedQuery(name = "Datarecordobstetric.findByReasoncontrolcarop", query = "SELECT d FROM Datarecordobstetric d WHERE d.reasoncontrolcarop = :reasoncontrolcarop"),
    @NamedQuery(name = "Datarecordobstetric.findByNormalweight", query = "SELECT d FROM Datarecordobstetric d WHERE d.normalweight = :normalweight"),
    @NamedQuery(name = "Datarecordobstetric.findByCurrentweight", query = "SELECT d FROM Datarecordobstetric d WHERE d.currentweight = :currentweight"),
    @NamedQuery(name = "Datarecordobstetric.findBySize", query = "SELECT d FROM Datarecordobstetric d WHERE d.size = :size"),
    @NamedQuery(name = "Datarecordobstetric.findByPlano", query = "SELECT d FROM Datarecordobstetric d WHERE d.plano = :plano"),
    @NamedQuery(name = "Datarecordobstetric.findByPathologieseq", query = "SELECT d FROM Datarecordobstetric d WHERE d.pathologieseq = :pathologieseq")})
public class Datarecordobstetric implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DatarecordobstetricPK datarecordobstetricPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdate")
    @Temporal(TemporalType.DATE)
    private Date createdate;
    @Size(max = 2147483647)
    @Column(name = "antecedent")
    private String antecedent;
    @Column(name = "fur")
    @Temporal(TemporalType.DATE)
    private Date fur;
    @Column(name = "furop")
    @Temporal(TemporalType.DATE)
    private Date furop;
    @Column(name = "fpp")
    @Temporal(TemporalType.DATE)
    private Date fpp;
    @Column(name = "eco_early")
    private Short ecoEarly;
    @Column(name = "eg")
    private Integer eg;
    @Column(name = "eg_sem")
    private Integer egSem;
    @Column(name = "according")
    private Short according;
    @Size(max = 150)
    @Column(name = "parentname")
    private String parentname;
    @Size(max = 2147483647)
    @Column(name = "reasonderivation")
    private String reasonderivation;
    @Column(name = "au")
    private Integer au;
    @Column(name = "lfc")
    private Integer lfc;
    @Size(max = 100)
    @Column(name = "du")
    private String du;
    @Column(name = "vaginalexamination")
    private Integer vaginalexamination;
    @Size(max = 100)
    @Column(name = "erasure")
    private String erasure;
    @Column(name = "dilatation")
    private Integer dilatation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "scorebishop")
    private Double scorebishop;
    @Size(max = 20)
    @Column(name = "POSITION")
    private String position;
    @Size(max = 20)
    @Column(name = "consistency")
    private String consistency;
    @Column(name = "membrane")
    private Short membrane;
    @Column(name = "controlcarop")
    private Short controlcarop;
    @Size(max = 2147483647)
    @Column(name = "reasoncontrolcarop")
    private String reasoncontrolcarop;
    @Column(name = "normalweight")
    private Double normalweight;
    @Column(name = "currentweight")
    private Double currentweight;
    @Column(name = "size")
    private Integer size;
    @Size(max = 2147483647)
    @Column(name = "plano")
    private String plano;
    @Column(name = "pathologieseq")
    private Integer pathologieseq;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datarecordobstetric")
    private List<Maternalpathologies> maternalpathologiesList;

    public Datarecordobstetric() {
    }

    public Datarecordobstetric(DatarecordobstetricPK datarecordobstetricPK) {
        this.datarecordobstetricPK = datarecordobstetricPK;
    }

    public Datarecordobstetric(DatarecordobstetricPK datarecordobstetricPK, Date createdate) {
        this.datarecordobstetricPK = datarecordobstetricPK;
        this.createdate = createdate;
    }

    public Datarecordobstetric(int episodenumber, int personrut, String persondv, int personnationality, int recordnumber) {
        this.datarecordobstetricPK = new DatarecordobstetricPK(episodenumber, personrut, persondv, personnationality, recordnumber);
    }

    public DatarecordobstetricPK getDatarecordobstetricPK() {
        return datarecordobstetricPK;
    }

    public void setDatarecordobstetricPK(DatarecordobstetricPK datarecordobstetricPK) {
        this.datarecordobstetricPK = datarecordobstetricPK;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getAntecedent() {
        return antecedent;
    }

    public void setAntecedent(String antecedent) {
        this.antecedent = antecedent;
    }

    public Date getFur() {
        return fur;
    }

    public void setFur(Date fur) {
        this.fur = fur;
    }

    public Date getFurop() {
        return furop;
    }

    public void setFurop(Date furop) {
        this.furop = furop;
    }

    public Date getFpp() {
        return fpp;
    }

    public void setFpp(Date fpp) {
        this.fpp = fpp;
    }

    public Short getEcoEarly() {
        return ecoEarly;
    }

    public void setEcoEarly(Short ecoEarly) {
        this.ecoEarly = ecoEarly;
    }

    public Integer getEg() {
        return eg;
    }

    public void setEg(Integer eg) {
        this.eg = eg;
    }

    public Integer getEgSem() {
        return egSem;
    }

    public void setEgSem(Integer egSem) {
        this.egSem = egSem;
    }

    public Short getAccording() {
        return according;
    }

    public void setAccording(Short according) {
        this.according = according;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public String getReasonderivation() {
        return reasonderivation;
    }

    public void setReasonderivation(String reasonderivation) {
        this.reasonderivation = reasonderivation;
    }

    public Integer getAu() {
        return au;
    }

    public void setAu(Integer au) {
        this.au = au;
    }

    public Integer getLfc() {
        return lfc;
    }

    public void setLfc(Integer lfc) {
        this.lfc = lfc;
    }

    public String getDu() {
        return du;
    }

    public void setDu(String du) {
        this.du = du;
    }

    public Integer getVaginalexamination() {
        return vaginalexamination;
    }

    public void setVaginalexamination(Integer vaginalexamination) {
        this.vaginalexamination = vaginalexamination;
    }

    public String getErasure() {
        return erasure;
    }

    public void setErasure(String erasure) {
        this.erasure = erasure;
    }

    public Integer getDilatation() {
        return dilatation;
    }

    public void setDilatation(Integer dilatation) {
        this.dilatation = dilatation;
    }

    public Double getScorebishop() {
        return scorebishop;
    }

    public void setScorebishop(Double scorebishop) {
        this.scorebishop = scorebishop;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getConsistency() {
        return consistency;
    }

    public void setConsistency(String consistency) {
        this.consistency = consistency;
    }

    public Short getMembrane() {
        return membrane;
    }

    public void setMembrane(Short membrane) {
        this.membrane = membrane;
    }

    public Short getControlcarop() {
        return controlcarop;
    }

    public void setControlcarop(Short controlcarop) {
        this.controlcarop = controlcarop;
    }

    public String getReasoncontrolcarop() {
        return reasoncontrolcarop;
    }

    public void setReasoncontrolcarop(String reasoncontrolcarop) {
        this.reasoncontrolcarop = reasoncontrolcarop;
    }

    public Double getNormalweight() {
        return normalweight;
    }

    public void setNormalweight(Double normalweight) {
        this.normalweight = normalweight;
    }

    public Double getCurrentweight() {
        return currentweight;
    }

    public void setCurrentweight(Double currentweight) {
        this.currentweight = currentweight;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public Integer getPathologieseq() {
        return pathologieseq;
    }

    public void setPathologieseq(Integer pathologieseq) {
        this.pathologieseq = pathologieseq;
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
        hash += (datarecordobstetricPK != null ? datarecordobstetricPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datarecordobstetric)) {
            return false;
        }
        Datarecordobstetric other = (Datarecordobstetric) object;
        if ((this.datarecordobstetricPK == null && other.datarecordobstetricPK != null) || (this.datarecordobstetricPK != null && !this.datarecordobstetricPK.equals(other.datarecordobstetricPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Datarecordobstetric[ datarecordobstetricPK=" + datarecordobstetricPK + " ]";
    }
    
}
