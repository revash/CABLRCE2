/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entity.Bloodgroup;
import cl.session.BloodgroupFacade;
import cl.session.BloodgroupFacadeLocal;
import cl.session.BussinesFacade2;
import cl.session.BussinesFacadeLocal2;
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
public class BloodGroupBean {
    @EJB
    private final BloodgroupFacadeLocal bloodgroupFacade;
    @EJB
    private final BussinesFacadeLocal2 bussinesFacade2;
   
    private Bloodgroup GrupoSanguineo, SelectedGrupoSanguineo;
    private List<Bloodgroup> GrupoSanguineos, FilterGrupoSanguineo;
   private boolean botonGuardar;
    
    public BloodGroupBean() {
        
       bloodgroupFacade = new BloodgroupFacade();
       bussinesFacade2 = new BussinesFacade2();
    }
    
   @PostConstruct
    public void myInit() {
        GrupoSanguineo = new Bloodgroup() ;
        SelectedGrupoSanguineo = new Bloodgroup();
        GrupoSanguineos = bloodgroupFacade.findAll();
        botonGuardar = true;
    }

public void createGrupoSanguineo() throws IOException {
        
       FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
            if (bussinesFacade2.existeGrupoSanguineoId(GrupoSanguineo.getBgroupid())) {
                bloodgroupFacade.create(GrupoSanguineo);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo Sanguineo guardado", null));
                String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/GrupoSanguineos.xhtml"));
                extContext.redirect(url);
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "el ID ingresado ya se encuentra registrado", null));
            }



}    
        public void editGrupoSanguineo() throws IOException{      
            
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if(!GrupoSanguineo.getBgroupdesc().equalsIgnoreCase("")){
            bloodgroupFacade.edit(GrupoSanguineo);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Edicion Guardada", null));
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/GrupoSanguineos.xhtml"));
            extContext.redirect(url);
        }
        else{
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se deben completar los campos", null));
        }
    }   
    
   
   
  
      public void onRowSelect(){
        GrupoSanguineo = SelectedGrupoSanguineo;
        System.out.println("GrupoSanguineo id " + GrupoSanguineo.getBgroupid());
        botonGuardar = false;
    }  
    
    
    
    
    //gett and setter
    public Bloodgroup getGrupoSanguineo() {
        return GrupoSanguineo;
    }

    public void setGrupoSanguineo(Bloodgroup GrupoSanguineo) {
        this.GrupoSanguineo = GrupoSanguineo;
    }

    public Bloodgroup getSelectedGrupoSanguineo() {
        return SelectedGrupoSanguineo;
    }

    public void setSelectedGrupoSanguineo(Bloodgroup SelectedGrupoSanguineo) {
        this.SelectedGrupoSanguineo = SelectedGrupoSanguineo;
    }

    public List<Bloodgroup> getGrupoSanguineos() {
        return GrupoSanguineos;
    }

    public void setGrupoSanguineos(List<Bloodgroup> GrupoSanguineos) {
        this.GrupoSanguineos = GrupoSanguineos;
    }

    public List<Bloodgroup> getFilterGrupoSanguineo() {
        return FilterGrupoSanguineo;
    }

    public void setFilterGrupoSanguineo(List<Bloodgroup> FilterGrupoSanguineo) {
        this.FilterGrupoSanguineo = FilterGrupoSanguineo;
    }

    public boolean isBotonGuardar() {
        return botonGuardar;
    }

    public void setBotonGuardar(boolean botonGuardar) {
        this.botonGuardar = botonGuardar;
    }
    
    
}
