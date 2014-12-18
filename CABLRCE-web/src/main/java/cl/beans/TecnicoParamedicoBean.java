/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entity.Clinicalepisode;
import cl.entity.ClinicalepisodePK;
import cl.entity.Mediccontrol;
import cl.entity.MediccontrolPK;
import cl.entity.Patientrecord;
import cl.entity.Scheduling;
import cl.entity.Statusclinicalepisode;
import cl.session.BussinesFacade;
import cl.session.BussinesFacadeLocal;
import cl.session.ClinicalepisodeFacade;
import cl.session.ClinicalepisodeFacadeLocal;
import cl.session.MediccontrolFacade;
import cl.session.MediccontrolFacadeLocal;
import cl.session.PatientrecordFacade;
import cl.session.PatientrecordFacadeLocal;
import cl.session.SchedulingFacade;
import cl.session.SchedulingFacadeLocal;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author AndresEduardo
 */
@ManagedBean
@RequestScoped
public class TecnicoParamedicoBean {

    @EJB
    private PatientrecordFacadeLocal patientrecordFacade;

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

    public TecnicoParamedicoBean() {
        schedulingFacade = new SchedulingFacade();
        mediccontrolFacade = new MediccontrolFacade();
        clinicalepisodeFacade = new ClinicalepisodeFacade();
        bussinesFacade = new BussinesFacade();
        patientrecordFacade = new PatientrecordFacade();

    }

    @PostConstruct
    public void myInit() {
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
            System.out.println("Control medico nuevo");
            controlMedico = new Mediccontrol();
        }
        paciente = new Patientrecord();
        selectedAgenda = new Scheduling();
        ListaDePacientesDiarios = bussinesFacade.getListaPorEstadoTecnico();

    }

    public void crearControlMedico() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        System.out.println("agenda paciente record " + selectedAgenda.getPatientrecord().getEpisodecounter());
        if (bussinesFacade.existeEpisodioObstetrico(selectedAgenda.getPatientrecord(),
                selectedAgenda.getProfessional().getSpecialityid().getSpecialityid())) {
            cliEpPk = new ClinicalepisodePK(selectedAgenda.getPatientrecord().getEpisodecounter(),
                    selectedAgenda.getPatientrecord().getPatientrecordPK().getRut(),
                    selectedAgenda.getPatientrecord().getPatientrecordPK().getDv(),
                    selectedAgenda.getPatientrecord().getPatientrecordPK().getRecordnumber(),
                    selectedAgenda.getPatientrecord().getPatientrecordPK().getNationalityid());
            System.out.println("clave episodio creada");
            episodioClinico.setClinicalepisodePK(cliEpPk);
            Statusclinicalepisode estadoEpisodio = bussinesFacade.getEstadoEnCurso(1);
            episodioClinico.setStartdate(new Date());
            episodioClinico.setMediccontrolseq(1);
            episodioClinico.setNutritionalseq(1);
            episodioClinico.setDiabeticcontrolseq(1);
            episodioClinico.setDiagnosticseq(1);
            episodioClinico.setHyphotesisseq(1);
            episodioClinico.setExamreqseq(1);
            episodioClinico.setStatusepisodeid(estadoEpisodio);
            episodioClinico.setSpecialityId(selectedAgenda.getProfessional().getSpecialityid().getSpecialityid());
            System.out.println("clave episodio Asignada");
            clinicalepisodeFacade.create(episodioClinico);
            System.out.println("episodio creado");
            MediccontrolPK medicPk = new MediccontrolPK();
            System.out.println("secuencia episodio");
            medicPk.setControlid(episodioClinico.getMediccontrolseq());
            System.out.println("control id creado");
            medicPk.setRut(selectedAgenda.getPatientrecord().getPatientrecordPK().getRut());
            System.out.println("rut ingresado");
            medicPk.setDv(selectedAgenda.getPatientrecord().getPatientrecordPK().getDv());
            System.out.println("dv ingresado");
            medicPk.setEpisodeid(episodioClinico.getClinicalepisodePK().getEpisodeid());
            System.out.println("episodio ingresado");
            medicPk.setRecordnumber(selectedAgenda.getPatientrecord().getPatientrecordPK().getRecordnumber());
            System.out.println("cargado dato de ficha");
            medicPk.setNationalityid(selectedAgenda.getPatientrecord().getPatientrecordPK().getNationalityid());
            System.out.println("MEDICPK" + medicPk);
            System.out.println("pk control creada");
            //creacion de control
            controlMedico.setStatus(1);
            controlMedico.setMediccontrolPK(medicPk);
            controlMedico.setDate(selectedAgenda.getSchedulingPK().getDate2());
            System.out.println("fecha " + controlMedico.getDate());
            mediccontrolFacade.create(controlMedico);
            episodioClinico.setMediccontrolseq(episodioClinico.getMediccontrolseq() + 1);
            clinicalepisodeFacade.edit(episodioClinico);
            //aumentar id Episodio de ficha
            Patientrecord fichaAux = selectedAgenda.getPatientrecord();
            fichaAux.setEpisodecounter(fichaAux.getEpisodecounter() + 1);
            patientrecordFacade.edit(fichaAux);
            extContext.getSessionMap().put("Control", controlMedico);
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/TecnicoParamedico/ControlMedicoTecnicoParamedico.xhtml"));
            extContext.redirect(url);
        } else {
            System.out.println(" existe episodio");
            episodioClinico = bussinesFacade.getEpisodioObstetrico(selectedAgenda.getPatientrecord(),
                    selectedAgenda.getProfessional().getSpecialityid().getSpecialityid());
            MediccontrolPK medicPk = new MediccontrolPK();
            System.out.println("secuencia episodio");
            medicPk.setControlid(episodioClinico.getMediccontrolseq());
            System.out.println("control id creado");
            medicPk.setRut(selectedAgenda.getPatientrecord().getPatientrecordPK().getRut());
            System.out.println("rut ingresado");
            medicPk.setDv(selectedAgenda.getPatientrecord().getPatientrecordPK().getDv());
            System.out.println("dv ingresado");
            medicPk.setEpisodeid(episodioClinico.getClinicalepisodePK().getEpisodeid());
            System.out.println("episodio ingresado");
            medicPk.setRecordnumber(selectedAgenda.getPatientrecord().getPatientrecordPK().getRecordnumber());
            System.out.println("cargado dato de ficha");
            medicPk.setNationalityid(selectedAgenda.getPatientrecord().getPatientrecordPK().getNationalityid());
            System.out.println("MEDICPK" + medicPk);
            System.out.println("pk control creada");
            //creacion de control
            controlMedico.setStatus(1);
            controlMedico.setCorrelativerecipies(1);
            controlMedico.setCorrelativetreatment(1);
            controlMedico.setMediccontrolPK(medicPk);
            controlMedico.setStatus(1);
            controlMedico.setMediccontrolPK(medicPk);
            controlMedico.setDate(selectedAgenda.getSchedulingPK().getDate2());
            System.out.println("fecha " + controlMedico.getDate());
            mediccontrolFacade.create(controlMedico);
            episodioClinico.setMediccontrolseq(episodioClinico.getMediccontrolseq() + 1);
            clinicalepisodeFacade.edit(episodioClinico);
            selectedAgenda.setStatusshedulingid(bussinesFacade.getEstadoSchudling(2));
            schedulingFacade.edit(selectedAgenda);
            //aumentar id Episodio de ficha
            extContext.getSessionMap().put("agenda", selectedAgenda);
            extContext.getSessionMap().put("Control", controlMedico);
            extContext.getSessionMap().put("episodio", controlMedico.getClinicalepisode());
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/TecnicoParamedico/ControlMedicoTecnicoParamedico.xhtml"));
            extContext.redirect(url);

        }

    }

    public void ingresarSignosVitales() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        System.out.println("fecha y hora " + agenda.getSchedulingPK().getDate2() + " " + agenda.getSchedulingPK().getTime2());
        Scheduling sheaux = agenda;
        sheaux.setStatusshedulingid(bussinesFacade.getEstadoSchudling(2));
        schedulingFacade.edit(sheaux);
        System.out.println("paso");
        controlMedico.setStatus(2);
        mediccontrolFacade.edit(controlMedico);
        ListaDePacientesDiarios = schedulingFacade.findAll();
        extContext.getSessionMap().put("agenda", null);
        extContext.getSessionMap().put("Control", null);
        extContext.getSessionMap().put("episodio", null);
        String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/TecnicoParamedico/ListaAgenda.xhtml"));
        extContext.redirect(url);

    }

    public List<Scheduling> getListaDePacientesDiarios() {
        return ListaDePacientesDiarios;
    }

    public void setListaDePacientesDiarios(List<Scheduling> ListaDePacientesDiarios) {
        this.ListaDePacientesDiarios = ListaDePacientesDiarios;
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

    public Mediccontrol getControlMedico() {
        return controlMedico;
    }

    public void setControlMedico(Mediccontrol controlMedico) {
        this.controlMedico = controlMedico;
    }

    public List<Scheduling> getFilterListaPacientes() {
        return filterListaPacientes;
    }

    public void setFilterListaPacientes(List<Scheduling> filterListaPacientes) {
        this.filterListaPacientes = filterListaPacientes;
    }

    public Clinicalepisode getEpisodioClinico() {
        return episodioClinico;
    }

    public void setEpisodioClinico(Clinicalepisode episodioClinico) {
        this.episodioClinico = episodioClinico;
    }

}
