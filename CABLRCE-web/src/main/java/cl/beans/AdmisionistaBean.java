/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.Aplications.appBean;
import cl.entity.Bloodgroup;
import cl.entity.City;
import cl.entity.Commune;
import cl.entity.Educationallevel;
import cl.entity.Maritalstatus;
import cl.entity.Nationality;
import cl.entity.Nativetowns;
import cl.entity.Patientrecord;
import cl.entity.Person;
import cl.entity.PersonPK;
import cl.entity.Prevision;
import cl.entity.Professional;
import cl.entity.Region;
import cl.entity.Religion;
import cl.entity.Scheduling;
import cl.entity.SchedulingPK;
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
import cl.session.PatientrecordFacadeLocal;
import cl.session.PersonFacade;
import cl.session.PersonFacadeLocal;
import cl.session.PrevisionFacade;
import cl.session.PrevisionFacadeLocal;
import cl.session.ProfessionalFacade;
import cl.session.ProfessionalFacadeLocal;
import cl.session.RegionFacade;
import cl.session.RegionFacadeLocal;
import cl.session.ReligionFacade;
import cl.session.ReligionFacadeLocal;
import cl.session.SchedulingFacade;
import cl.session.SchedulingFacadeLocal;
import cl.session.SequenceTableFacade;
import cl.session.SequenceTableFacadeLocal;
import cl.session.SexFacade;
import cl.session.SexFacadeLocal;
import cl.session.TipeprevisionFacade;
import cl.session.TipeprevisionFacadeLocal;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author AndresEduardo
 */
@ManagedBean
@ViewScoped
public class AdmisionistaBean {
    
    @EJB
    private final ProfessionalFacadeLocal professionalFacade;

    @EJB
    private final SequenceTableFacadeLocal sequenceTableFacade;

    @EJB
    private PatientrecordFacadeLocal patientrecordFacade;
    @EJB
    private final SchedulingFacadeLocal schedulingFacade;

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
    private String dv;
    private Date fecha, hora;
    private List<Professional> profesionales;
    private Scheduling schudling;
    private Patientrecord paciente;
    private Professional profesionalSeleccionado;
    private Integer rutPro;
    private List<Scheduling> ListaAgenda; 

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
        schedulingFacade = new SchedulingFacade();
        sequenceTableFacade = new SequenceTableFacade();
        professionalFacade = new ProfessionalFacade();

    }

    @PostConstruct
    public void myInit() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if (extContext.getSessionMap().get("pacienteAgendar") != null) {
            person = (Person) extContext.getSessionMap().get("pacienteAgendar");
        } else {
            person = new Person();
        }
        if (extContext.getSessionMap().get("paciente") != null) {
            paciente = (Patientrecord) extContext.getSessionMap().get("paciente");
        } else {
            paciente = new Patientrecord();
        }
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
        profesionales = professionalFacade.findAll();
        schudling = new Scheduling();
        ListaAgenda = schedulingFacade.findAll();
    }

    public void createPersona() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        rut = rut.replace("-", "");
        rut = rut.replace(".", "");
        String rut1 = rut.substring(0, rut.length() - 1);
        String dv2 = rut.charAt(rut.length() - 1) + "";
        PersonPK personPk = new PersonPK(Integer.parseInt(rut1), dv2, person.getNationality().getNationalityid());
        person.setPersonPK(personPk);
        System.out.println("ciudad " + person.getCommuneid().getCommunename() + " " + person.getCommuneid().getCommuneid());
        personFacade.create(person);
        String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Admisionista/Persona/PersonaCreate.xhtml"));
        extContext.redirect(url);

    }

    public void onValidaRut() {
        rut = rut.replace("-", "");
        rut = rut.replace(".", "");
        String rut1 = rut.substring(0, rut.length() - 1);
        dv = rut.charAt(rut.length() - 1) + "";
        if (!appBean.validarRut(rut1, dv)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Rut Invalido", "Rut Invalido"));
        }
    }

    public void onFormateaRut() {

        this.setRut(appBean.FormateaRut(rut));

    }

    public void cargarDatosPersona() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        rut = rut.replace("-", "");
        rut = rut.replace(".", "");
        String rut1 = rut.substring(0, rut.length() - 1);
        String dv2 = rut.charAt(rut.length() - 1) + "";
        System.out.println("rut " + rut1 + " dv: " + dv2);
        this.person = bussinesFacade.getPersona(Integer.parseInt(rut1), dv2);
        if (person == null) {
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Admisionista/Persona/PersonaCreate.xhtml"));
            extContext.redirect(url);
        } else {
            if (bussinesFacade.existePaciente(person.getPersonPK())) {
                //crear paciente
                Integer seq = bussinesFacade.getPK();
                Professional professional = (Professional) extContext.getSessionMap().get("UsuarioSistema");
                Patientrecord patientrecordAux = new Patientrecord(seq, person.getPersonPK().getRut(), person.getPersonPK().getDv(), person.getPersonPK().getNationalityid());
                patientrecordAux.setCreationdate(new Date());
                patientrecordAux.setEpisodecounter(1);
                patientrecordAux.setProfessional(professional);
                patientrecordFacade.create(patientrecordAux);
                extContext.getSessionMap().put("paciente", patientrecordAux);
                extContext.getSessionMap().put("pacienteAgendar", person);
                System.out.println("seq " + seq);
                seq = seq + 1;
                bussinesFacade.agregarPKSeq(seq);
                String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Admisionista/Persona/AgendarPaciente.xhtml"));
                extContext.redirect(url);

            } else {
                this.paciente = bussinesFacade.getPaciente(person.getPersonPK());
                extContext.getSessionMap().put("paciente", this.paciente);
                extContext.getSessionMap().put("pacienteAgendar", person);
                String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Admisionista/Persona/AgendarPaciente.xhtml"));
                extContext.redirect(url);

            }

        }

    }

    public void agendarPaciente() throws IOException {
        System.out.println("entra " + rutPro);
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        Professional professional = bussinesFacade.getProfessionalAgenda(rutPro);
        System.out.println("cargo profesional");
        System.out.println("nombre pro" + professional);
        SchedulingPK schuAuxPk = new SchedulingPK(fecha, hora, professional.getProfessionalPK().getRut(), professional.getProfessionalPK().getDv());
        System.out.println("ingreso pk agenda");
        schudling.setSchedulingPK(schuAuxPk);
        System.out.println("seteo paramaetro 1");
        schudling.setPatientrecord(paciente);
        System.out.println("seteo paramaetro 2");
        schudling.setProfessional(professional);
        System.out.println("seteo paramaetro 3");
        schudling.setStatusshedulingid(bussinesFacade.getEstadoSchudling(1));
        System.out.println("seteo paramaetro 4");
        schedulingFacade.create(schudling);
        System.out.println("seteo Guardo 1");
        String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Admisionista/Persona/ListaAgenda.xhtml"));
        extContext.redirect(url);

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

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public Scheduling getSchudling() {
        return schudling;
    }

    public void setSchudling(Scheduling schudling) {
        this.schudling = schudling;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public List<Professional> getProfesionales() {
        return profesionales;
    }

    public void setProfesionales(List<Professional> profesionales) {
        this.profesionales = profesionales;
    }

    public Professional getProfesionalSeleccionado() {
        return profesionalSeleccionado;
    }

    public void setProfesionalSeleccionado(Professional profesionalSeleccionado) {
        this.profesionalSeleccionado = profesionalSeleccionado;
    }

    public Integer getRutPro() {
        return rutPro;
    }

    public void setRutPro(Integer rutPro) {
        this.rutPro = rutPro;
    }

    public List<Scheduling> getListaAgenda() {
        return ListaAgenda;
    }

    public void setListaAgenda(List<Scheduling> ListaAgenda) {
        this.ListaAgenda = ListaAgenda;
    }

    

}
