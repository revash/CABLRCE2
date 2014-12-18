/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entity.Clinicalepisode;
import cl.entity.ClinicalepisodePK;
import cl.entity.Databirths;
import cl.entity.DatabirthsPK;
import cl.entity.Mediccontrol;
import cl.entity.MediccontrolPK;
import cl.entity.Obstetricdata;
import cl.entity.ObstetricdataPK;
import cl.entity.Patientrecord;
import cl.entity.Scheduling;
import cl.entity.Statusclinicalepisode;
import cl.entity.Tipebirths;
import cl.session.BussinesFacade;
import cl.session.BussinesFacadeLocal;
import cl.session.ClinicalepisodeFacade;
import cl.session.ClinicalepisodeFacadeLocal;
import cl.session.DatabirthsFacade;
import cl.session.DatabirthsFacadeLocal;
import cl.session.MediccontrolFacade;
import cl.session.MediccontrolFacadeLocal;
import cl.session.ObstetricdataFacade;
import cl.session.ObstetricdataFacadeLocal;
import cl.session.PatientrecordFacade;
import cl.session.PatientrecordFacadeLocal;
import cl.session.SchedulingFacade;
import cl.session.SchedulingFacadeLocal;
import cl.session.TipebirthsFacade;
import cl.session.TipebirthsFacadeLocal;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author AndresEduardo
 */
@ManagedBean
@RequestScoped
public class medicoBean {

    @EJB
    private final TipebirthsFacadeLocal tipebirthsFacade;
    @EJB
    private final DatabirthsFacadeLocal databirthsFacade;
    @EJB
    private final ObstetricdataFacadeLocal obstetricdataFacade;

    @EJB
    private final PatientrecordFacadeLocal patientrecordFacade;

    @EJB
    private final MediccontrolFacadeLocal mediccontrolFacade;
    @EJB
    private final ClinicalepisodeFacadeLocal clinicalepisodeFacade;
    @EJB
    private final BussinesFacadeLocal bussinesFacade;
    @EJB
    private final SchedulingFacadeLocal schedulingFacade;

    /**
     * Creates a new instance of TecnicoParamedicoBean
     */
    private Patientrecord paciente;
    private Scheduling agenda, selectedAgenda;
    private List<Scheduling> ListaDePacientesDiarios, filterListaPacientes;
    private Mediccontrol controlMedico;
    private Clinicalepisode episodioClinico;
    private ClinicalepisodePK cliEpPk;
    private Obstetricdata datosObstetricos;
    private Databirths nacimiento;
    private List<Databirths> nacimientos;
    private List<Tipebirths> tipoNacimientos;

    public medicoBean() {
        schedulingFacade = new SchedulingFacade();
        mediccontrolFacade = new MediccontrolFacade();
        clinicalepisodeFacade = new ClinicalepisodeFacade();
        bussinesFacade = new BussinesFacade();
        patientrecordFacade = new PatientrecordFacade();
        obstetricdataFacade = new ObstetricdataFacade();
        databirthsFacade = new DatabirthsFacade();
        tipebirthsFacade = new TipebirthsFacade();
    }

    @PostConstruct
    public void myInit() {
        ListaDePacientesDiarios = bussinesFacade.getListaPorEstadoMedico();
        paciente = new Patientrecord();
        selectedAgenda = new Scheduling();
        tipoNacimientos = tipebirthsFacade.findAll();
         nacimiento = new Databirths();
         
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        
        if (extContext.getSessionMap().get("agenda") != null) {
            agenda = (Scheduling) extContext.getSessionMap().get("agenda");
        } else {
            agenda = new Scheduling();
        }
        
        if (extContext.getSessionMap().get("episodio") != null) {
            episodioClinico = (Clinicalepisode) extContext.getSessionMap().get("episodio");
        } else {
            episodioClinico = new Clinicalepisode();
        }
        
        episodioClinico = new Clinicalepisode();
        if (extContext.getSessionMap().get("Control") != null) {
            controlMedico = (Mediccontrol) extContext.getSessionMap().get("Control");
           
        } else {
            controlMedico = new Mediccontrol();
        }
        
        if (extContext.getSessionMap().get("datosObstetricos") != null) {
            datosObstetricos = (Obstetricdata) extContext.getSessionMap().get("datosObstetricos");
           //nacimientos = databirthsFacade.findAll();
        } else {
            datosObstetricos = new Obstetricdata();
            //nacimientos = databirthsFacade.findAll();
        }

    }

    public void cargarControlMedico() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        controlMedico = bussinesFacade.getControlMedicoEnCurso(selectedAgenda.getPatientrecord().getPatientrecordPK().getRecordnumber());
        extContext.getSessionMap().put("agenda", selectedAgenda);
        extContext.getSessionMap().put("Control", controlMedico);
        extContext.getSessionMap().put("episodio", controlMedico.getClinicalepisode());
        if (bussinesFacade.existenDatosObstetricos(controlMedico.getMediccontrolPK().getRecordnumber())) {
            System.out.println("dato 1 " + controlMedico.getMediccontrolPK().getRut());
            System.out.println("dato 2 " + controlMedico.getMediccontrolPK().getDv());
            System.out.println("dato 3 " + controlMedico.getMediccontrolPK().getNationalityid());
            System.out.println("dato 4 " + controlMedico.getMediccontrolPK().getRecordnumber());
            ObstetricdataPK obstPK = new ObstetricdataPK(controlMedico.getMediccontrolPK().getRut(), controlMedico.getMediccontrolPK().getDv(),
                    controlMedico.getMediccontrolPK().getNationalityid(), controlMedico.getMediccontrolPK().getRecordnumber());
            datosObstetricos.setObstetricdataPK(obstPK);
            datosObstetricos.setAbortion(0);
            datosObstetricos.setCaesarean(0);
            datosObstetricos.setVaginal(0);
            datosObstetricos.setRnhigherweight(0);
            datosObstetricos.setRnlowerweight(0);
            obstetricdataFacade.create(datosObstetricos);
            extContext.getSessionMap().put("datosObstetricos", datosObstetricos);
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Medico/ControlDatosObstetricos.xhtml"));
            extContext.redirect(url);
        } else {
            datosObstetricos = bussinesFacade.getDatosObstetricos(controlMedico.getMediccontrolPK().getRecordnumber());
            extContext.getSessionMap().put("datosObstetricos", datosObstetricos);
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Medico/ControlMedico.xhtml"));
            extContext.redirect(url);
        }
    }

    //crear tipo de nacimiento
    public void crearTipoNacimiento(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "FormAgregarTipoNacimiento";
        String dialog = "";
        if (nacimiento.getObservations().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Observacion", null));
        } else {
            DatabirthsPK dataPK = new DatabirthsPK(datosObstetricos.getObstetricdataPK().getPersonrut(), datosObstetricos.getObstetricdataPK().getPersondv(),
                    datosObstetricos.getObstetricdataPK().getPersonnationality(), datosObstetricos.getObstetricdataPK().getRecordnumber());
            nacimiento.setDatabirthsPK(dataPK);
            databirthsFacade.create(nacimiento);
            formulario = "FormAgregarTipoNacimiento";
            dialog = "dlg1";
            creado = true;
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos Correctamente Creados", null));
        }
        nacimientos = databirthsFacade.findAll();
        nacimiento = new Databirths();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);

    }

    public Patientrecord getPaciente() {
        return paciente;
    }

    public void setPaciente(Patientrecord paciente) {
        this.paciente = paciente;
    }

    public Scheduling getAgenda() {
        return agenda;
    }

    public void setAgenda(Scheduling agenda) {
        this.agenda = agenda;
    }

    public Scheduling getSelectedAgenda() {
        return selectedAgenda;
    }

    public void setSelectedAgenda(Scheduling selectedAgenda) {
        this.selectedAgenda = selectedAgenda;
    }

    public List<Scheduling> getListaDePacientesDiarios() {
        return ListaDePacientesDiarios;
    }

    public void setListaDePacientesDiarios(List<Scheduling> ListaDePacientesDiarios) {
        this.ListaDePacientesDiarios = ListaDePacientesDiarios;
    }

    public List<Scheduling> getFilterListaPacientes() {
        return filterListaPacientes;
    }

    public void setFilterListaPacientes(List<Scheduling> filterListaPacientes) {
        this.filterListaPacientes = filterListaPacientes;
    }

    public Mediccontrol getControlMedico() {
        return controlMedico;
    }

    public void setControlMedico(Mediccontrol controlMedico) {
        this.controlMedico = controlMedico;
    }

    public Clinicalepisode getEpisodioClinico() {
        return episodioClinico;
    }

    public void setEpisodioClinico(Clinicalepisode episodioClinico) {
        this.episodioClinico = episodioClinico;
    }

    public ClinicalepisodePK getCliEpPk() {
        return cliEpPk;
    }

    public void setCliEpPk(ClinicalepisodePK cliEpPk) {
        this.cliEpPk = cliEpPk;
    }

    public Obstetricdata getDatosObstetricos() {
        return datosObstetricos;
    }

    public void setDatosObstetricos(Obstetricdata datosObstetricos) {
        this.datosObstetricos = datosObstetricos;
    }

    public Databirths getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Databirths nacimiento) {
        this.nacimiento = nacimiento;
    }

    public List<Databirths> getNacimientos() {
        return nacimientos;
    }

    public void setNacimientos(List<Databirths> nacimientos) {
        this.nacimientos = nacimientos;
    }

    public List<Tipebirths> getTipoNacimientos() {
        return tipoNacimientos;
    }

    public void setTipoNacimientos(List<Tipebirths> tipoNacimientos) {
        this.tipoNacimientos = tipoNacimientos;
    }

}
