/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entity.Prevision;
import cl.session.BussinesFacade2;
import cl.session.BussinesFacadeLocal2;
import cl.session.PrevisionFacade;
import cl.session.PrevisionFacadeLocal;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
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
public class PrevisionBean {
    @EJB
    private final PrevisionFacadeLocal previsionFacade;
    @EJB
    private final BussinesFacadeLocal2 bussinesFacade2;
    
    private Prevision prevision, selectedPrevision;
    private List<Prevision> previsiones, filterPrevision;
   private boolean botonGuardar;
    
    public PrevisionBean() {
        
        previsionFacade = new PrevisionFacade();
        bussinesFacade2 = new BussinesFacade2();
        
    }
    
      @PostConstruct
    public void myInit() {
        prevision = new Prevision();
        selectedPrevision= new Prevision();
        previsiones  = previsionFacade.findAll();
        botonGuardar = true;
    }
    
    public void createPrevision() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
            if (bussinesFacade2.existePrevisionId(prevision.getPrevid())) {
                previsionFacade.create(prevision);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Prevision guardada", null));
                String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Previsiones.xhtml"));
                extContext.redirect(url);
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "el ID ingresado ya se encuentra registrado", null));
            }
    }
    public void editPrevision() throws IOException{      
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if(!prevision.getPrevdescription().equalsIgnoreCase("")){
            previsionFacade.edit(prevision);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Edicion Guardada", null));
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Previsiones.xhtml"));
            extContext.redirect(url);
        }
        else{
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se deben completar los campos", null));
        }
    }
    
    public void onRowSelect(){
        prevision = selectedPrevision;
        System.out.println("Previsiones " + prevision.getPrevid());
        botonGuardar = false;
    } 
    
    
    
    
    
    //get and set

    public Prevision getPrevision() {
        return prevision;
    }

    public void setPrevision(Prevision prevision) {
        this.prevision = prevision;
    }

    public Prevision getSelectedPrevision() {
        return selectedPrevision;
    }

    public void setSelectedPrevision(Prevision selectedPrevision) {
        this.selectedPrevision = selectedPrevision;
    }

    public List<Prevision> getPrevisiones() {
        return previsiones;
    }

    public void setPrevisiones(List<Prevision> previsiones) {
        this.previsiones = previsiones;
    }

    public List<Prevision> getFilterPrevision() {
        return filterPrevision;
    }

    public void setFilterPrevision(List<Prevision> filterPrevision) {
        this.filterPrevision = filterPrevision;
    }

    public boolean isBotonGuardar() {
        return botonGuardar;
    }

    public void setBotonGuardar(boolean botonGuardar) {
        this.botonGuardar = botonGuardar;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
