/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entity.Bloodgroup;
import cl.entity.City;
import cl.entity.Commune;
import cl.entity.Educationallevel;
import cl.entity.Maritalstatus;
import cl.entity.Nationality;
import cl.entity.Nativetowns;
import cl.entity.Person;
import cl.entity.Prevision;
import cl.entity.Region;
import cl.entity.Religion;
import cl.entity.Sex;
import cl.entity.Tipeprevision;
import cl.session.BloodgroupFacade;
import cl.session.BloodgroupFacadeLocal;
import cl.session.BussinesFacade;
import cl.session.BussinesFacadeLocal;
import cl.session.CityFacade;
import cl.session.CityFacadeLocal;
import cl.session.CommuneFacade;
import cl.session.CommuneFacadeLocal;
import cl.session.EducationallevelFacade;
import cl.session.EducationallevelFacadeLocal;
import cl.session.MaritalstatusFacade;
import cl.session.MaritalstatusFacadeLocal;
import cl.session.NationalityFacade;
import cl.session.NationalityFacadeLocal;
import cl.session.NativetownsFacade;
import cl.session.NativetownsFacadeLocal;
import cl.session.PersonFacade;
import cl.session.PersonFacadeLocal;
import cl.session.PrevisionFacade;
import cl.session.PrevisionFacadeLocal;
import cl.session.RegionFacade;
import cl.session.RegionFacadeLocal;
import cl.session.ReligionFacade;
import cl.session.ReligionFacadeLocal;
import cl.session.SexFacade;
import cl.session.SexFacadeLocal;
import cl.session.TipeprevisionFacade;
import cl.session.TipeprevisionFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author AndresEduardo
 */
@ManagedBean
@ViewScoped
public class AdmisionistaBean {
    @EJB
    private final EducationallevelFacadeLocal educationallevelFacade;

    @EJB
    private final ReligionFacadeLocal religionFacade;
    @EJB
    private final SexFacadeLocal sexFacade;
    @EJB
    private final PrevisionFacadeLocal previsionFacade;
    @EJB
    private final CommuneFacadeLocal communeFacade;
    @EJB
    private final CityFacadeLocal cityFacade;
    @EJB
    private final RegionFacadeLocal regionFacade;
    @EJB
    private final NationalityFacadeLocal nationalityFacade;
    @EJB
    private final MaritalstatusFacadeLocal maritalstatusFacade;
    @EJB
    private final NativetownsFacadeLocal nativetownsFacade;
    @EJB
    private final BloodgroupFacadeLocal bloodgroupFacade;
    @EJB
    private final TipeprevisionFacadeLocal tipeprevisionFacade;
    @EJB
    private final PersonFacadeLocal personFacade;
    @EJB
    private final BussinesFacadeLocal bussinesFacade;

    /**
     * Creates a new instance of AdmisionistaBean
     */
    private List<Person> persons, filterPersons;
    private Person person, selectedPerson;
    private String rut;
    private List<Bloodgroup> gurpoSanguineo;
    private List<Religion> religiones;
    private List<Sex> sexos;
    private List<Prevision> previsiones;
    private List<Tipeprevision> tipoPrevisiones;
    private List<Commune> comunas;
    private List<City> ciudades;
    private List<Region> regiones;
    private List<Nationality> nacionalidades;
    private List<Maritalstatus> estadoCivil;
    private List<Nativetowns> pueblosOriginarios;
    private List<Educationallevel> eduLevel;
    private Prevision prevision;
    private Region region;
    private City city;

    public AdmisionistaBean() {
        personFacade = new PersonFacade();
        bussinesFacade = new BussinesFacade();
        religionFacade = new ReligionFacade();
        sexFacade = new SexFacade();
        previsionFacade = new PrevisionFacade();
        communeFacade = new CommuneFacade();
        cityFacade = new CityFacade();
        regionFacade = new RegionFacade();
        nationalityFacade = new NationalityFacade();
        maritalstatusFacade = new MaritalstatusFacade();
        nativetownsFacade = new NativetownsFacade();
        bloodgroupFacade = new BloodgroupFacade();
        tipeprevisionFacade = new TipeprevisionFacade();
        educationallevelFacade = new EducationallevelFacade();

    }

    @PostConstruct
    public void myInit() {
        person = new Person();
        selectedPerson = new Person();
        persons = personFacade.findAll();
        gurpoSanguineo = bloodgroupFacade.findAll();
        religiones = religionFacade.findAll();
        sexos = sexFacade.findAll();
        previsiones = previsionFacade.findAll();
        tipoPrevisiones = tipeprevisionFacade.findAll();
        comunas = communeFacade.findAll();
        ciudades = cityFacade.findAll();
        regiones = regionFacade.findAll();
        nacionalidades = nationalityFacade.findAll();
        estadoCivil = maritalstatusFacade.findAll();
        pueblosOriginarios = nativetownsFacade.findAll();
        eduLevel = educationallevelFacade.findAll();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getFilterPersons() {
        return filterPersons;
    }

    public void setFilterPersons(List<Person> filterPersons) {
        this.filterPersons = filterPersons;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public List<Bloodgroup> getGurpoSanguineo() {
        return gurpoSanguineo;
    }

    public void setGurpoSanguineo(List<Bloodgroup> gurpoSanguineo) {
        this.gurpoSanguineo = gurpoSanguineo;
    }

    public List<Religion> getReligiones() {
        return religiones;
    }

    public void setReligiones(List<Religion> religiones) {
        this.religiones = religiones;
    }

    public List<Sex> getSexos() {
        return sexos;
    }

    public void setSexos(List<Sex> sexos) {
        this.sexos = sexos;
    }

    public List<Prevision> getPrevisiones() {
        return previsiones;
    }

    public void setPrevisiones(List<Prevision> previsiones) {
        this.previsiones = previsiones;
    }

    public List<Tipeprevision> getTipoPrevisiones() {
        return tipoPrevisiones;
    }

    public void setTipoPrevisiones(List<Tipeprevision> tipoPrevisiones) {
        this.tipoPrevisiones = tipoPrevisiones;
    }

    public List<Commune> getComunas() {
        return comunas;
    }

    public void setComunas(List<Commune> comunas) {
        this.comunas = comunas;
    }

    public List<City> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<City> ciudades) {
        this.ciudades = ciudades;
    }

    public List<Region> getRegiones() {
        return regiones;
    }

    public void setRegiones(List<Region> regiones) {
        this.regiones = regiones;
    }

    public List<Nationality> getNacionalidades() {
        return nacionalidades;
    }

    public void setNacionalidades(List<Nationality> nacionalidades) {
        this.nacionalidades = nacionalidades;
    }

    public List<Maritalstatus> getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(List<Maritalstatus> estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<Nativetowns> getPueblosOriginarios() {
        return pueblosOriginarios;
    }

    public void setPueblosOriginarios(List<Nativetowns> pueblosOriginarios) {
        this.pueblosOriginarios = pueblosOriginarios;
    }

    public List<Educationallevel> getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(List<Educationallevel> eduLevel) {
        this.eduLevel = eduLevel;
    }

    public Prevision getPrevision() {
        return prevision;
    }

    public void setPrevision(Prevision prevision) {
        this.prevision = prevision;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    
}
