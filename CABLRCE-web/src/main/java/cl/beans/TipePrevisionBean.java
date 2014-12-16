/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entity.Prevision;
import cl.entity.Tipeprevision;
import cl.entity.Tipeprevision_;
import cl.session.BussinesFacade;
import cl.session.BussinesFacade2;
import cl.session.BussinesFacadeLocal2;
import cl.session.PrevisionFacade;
import cl.session.PrevisionFacadeLocal;
import cl.session.TipeprevisionFacade;
import cl.session.TipeprevisionFacadeLocal;
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
public class TipePrevisionBean {
    @EJB
    private PrevisionFacadeLocal previsionFacade;
    @EJB
    private final TipeprevisionFacadeLocal tipeprevisionFacade;
    @EJB
    private final BussinesFacadeLocal2 bussinesFacade2;
    
    

    private Tipeprevision TipoPrevision, selectedTipoPrevision , newTipePrevision;
    private List<Tipeprevision> TipoPrevisiones, filterTipoPrevision;
    private boolean botonGuardar;
    private List<Prevision> Previsiones;
 
    public TipePrevisionBean() {
        
        tipeprevisionFacade = new TipeprevisionFacade();
        bussinesFacade2 = new BussinesFacade2();
        previsionFacade = new PrevisionFacade();
        
    }
    
      @PostConstruct
    public void myInit() {
        TipoPrevision = new Tipeprevision();
        selectedTipoPrevision = new Tipeprevision();
        TipoPrevisiones = tipeprevisionFacade.findAll();
        botonGuardar = true;
        Previsiones = previsionFacade.findAll();
        newTipePrevision = new Tipeprevision();
        
        
        
        
    }

     public void createTipoPrevision() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
            if (bussinesFacade2.existeTipoPrevisionId(TipoPrevision.getTipeprevid())) {
                tipeprevisionFacade.create(TipoPrevision);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo Prevision guardada", null));
                String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/TipePrevisiones.xhtml"));
                extContext.redirect(url);
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "el ID ingresado ya se encuentra registrado", null));
            }

         

    }
    
     public void editTipoPrevisiones() throws IOException{      
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if(!TipoPrevision.getTipeprevdesc().equalsIgnoreCase("")){
            tipeprevisionFacade.edit(TipoPrevision);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Edicion Guardada", null));
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Nacionalidades.xhtml"));
            extContext.redirect(url);
        }
        else{
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se deben completar los campos", null));
        }
    }

    
    
    
    
    
    
    
    //get and set
    public Tipeprevision getTipoPrevision() {
        return TipoPrevision;
    }

    public void setTipoPrevision(Tipeprevision TipoPrevision) {
        this.TipoPrevision = TipoPrevision;
    }

    public Tipeprevision getSelectedTipoPrevision() {
        return selectedTipoPrevision;
    }

    public void setSelectedTipoPrevision(Tipeprevision selectedTipoPrevision) {
        this.selectedTipoPrevision = selectedTipoPrevision;
    }

    public List<Tipeprevision> getTipoPrevisiones() {
        return TipoPrevisiones;
    }

    public void setTipoPrevisiones(List<Tipeprevision> TipoPrevisiones) {
        this.TipoPrevisiones = TipoPrevisiones;
    }

    public List<Tipeprevision> getFilterTipoPrevision() {
        return filterTipoPrevision;
    }

    public void setFilterTipoPrevision(List<Tipeprevision> filterTipoPrevision) {
        this.filterTipoPrevision = filterTipoPrevision;
    }


    public boolean isBotonGuardar() {
        return botonGuardar;
    }

    public void setBotonGuardar(boolean botonGuardar) {
        this.botonGuardar = botonGuardar;
    }

    public List<Prevision> getPrevisiones() {
        return Previsiones;
    }

    public void setPrevisiones(List<Prevision> Previsiones) {
        this.Previsiones = Previsiones;
    }
    
    
    
    
}
