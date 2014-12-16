/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entity.Mediccontrol;
import cl.session.BussinesFacade2;
import cl.session.BussinesFacadeLocal2;
import cl.session.MediccontrolFacade;
import cl.session.MediccontrolFacadeLocal;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author MaxiCorp
 */
@ManagedBean
@RequestScoped
public class MedicControlBean {
    @EJB
    private MediccontrolFacadeLocal mediccontrolFacade;
    @EJB
    private final BussinesFacadeLocal2 bussinesFacade2;

    
    private Mediccontrol controlMedico, SelectedControlMedico;
    private List<Mediccontrol> controlMedicos, filterControlMedico;
    private boolean botonGuardar;
    public MedicControlBean() {
        
        mediccontrolFacade = new MediccontrolFacade();
        bussinesFacade2 = new BussinesFacade2();
       
    }
    
       @PostConstruct
    public void myInit() {
        controlMedico = new Mediccontrol();
        SelectedControlMedico= new Mediccontrol();
        controlMedicos  = mediccontrolFacade.findAll();
        botonGuardar = true;
    }

    
    public void createPrevision() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
           // if (bussinesFacade2.existeControlMedicoId(controlMedico.{
             //   previsionFacade.create(prevision);
               // context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Prevision guardada", null));
               // String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Previsiones.xhtml"));
              //  extContext.redirect(url);
           // } else {
            //    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "el ID ingresado ya se encuentra registrado", null));
     //       }
    }
    
    
    
    
    // get and set
    public Mediccontrol getControlMedico() {
        return controlMedico;
    }

    public void setControlMedico(Mediccontrol controlMedico) {
        this.controlMedico = controlMedico;
    }

    public Mediccontrol getSelectedControlMedico() {
        return SelectedControlMedico;
    }

    public void setSelectedControlMedico(Mediccontrol SelectedControlMedico) {
        this.SelectedControlMedico = SelectedControlMedico;
    }

    public List<Mediccontrol> getControlMedicos() {
        return controlMedicos;
    }

    public void setControlMedicos(List<Mediccontrol> controlMedicos) {
        this.controlMedicos = controlMedicos;
    }

    public List<Mediccontrol> getFilterControlMedico() {
        return filterControlMedico;
    }

    public void setFilterControlMedico(List<Mediccontrol> filterControlMedico) {
        this.filterControlMedico = filterControlMedico;
    }

    public boolean isBotonGuardar() {
        return botonGuardar;
    }

    public void setBotonGuardar(boolean botonGuardar) {
        this.botonGuardar = botonGuardar;
    }
    
    
    
}
