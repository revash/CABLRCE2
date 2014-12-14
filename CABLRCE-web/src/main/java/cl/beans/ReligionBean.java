/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.beans;

import cl.entity.Religion;
import cl.session.BussinesFacade2;
import cl.session.BussinesFacadeLocal2;
import cl.session.ReligionFacade;
import cl.session.ReligionFacadeLocal;
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
 * @author AndresEduardo
 */
@ManagedBean
@RequestScoped
public class ReligionBean {
    @EJB
    private final ReligionFacadeLocal religionFacade;
    @EJB
    private final BussinesFacadeLocal2 bussinesFacade2;
    
    private Religion religion, selectedReligion;
    private List<Religion> religiones, filterReligiones;
    String auxID;
    private boolean botonGuardar;
    
    public ReligionBean() {
        religionFacade = new ReligionFacade();
        bussinesFacade2 = new BussinesFacade2();
        
    }
    
    @PostConstruct
    public void myInit() {
        religion = new Religion();
        selectedReligion = new Religion();
        religiones = religionFacade.findAll();
        botonGuardar = true;
    }
    
    public void createReligion() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
            if (bussinesFacade2.existeReligionId(religion.getReligionid())) {
                religionFacade.create(religion);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "religion guardada", null));
                String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Religiones.xhtml"));
                extContext.redirect(url);
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "el ID ingresado ya se encuentra registrado", null));
            }

         

    }
    
  public void editReligion() throws IOException{      
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if(!religion.getReligionname().equalsIgnoreCase("")){
            religionFacade.edit(religion);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Edicion Guardada", null));
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Religion.xhtml"));
            extContext.redirect(url);
        }
        else{
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se deben completar los campos", null));
        }
    }
  
      public void onRowSelect(){
        religion = selectedReligion;
        System.out.println("religion id " + religion.getReligionid());
        botonGuardar = false;
    } 

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Religion getSelectedReligion() {
        return selectedReligion;
    }

    public void setSelectedReligion(Religion selectedReligion) {
        this.selectedReligion = selectedReligion;
    }

    public List<Religion> getReligiones() {
        return religiones;
    }

    public void setReligiones(List<Religion> religiones) {
        this.religiones = religiones;
    }

    public List<Religion> getFilterReligiones() {
        return filterReligiones;
    }

    public void setFilterReligiones(List<Religion> filterReligiones) {
        this.filterReligiones = filterReligiones;
    }

    public String getAuxID() {
        return auxID;
    }

    public void setAuxID(String auxID) {
        this.auxID = auxID;
    }

    public boolean isBotonGuardar() {
        return botonGuardar;
    }

    public void setBotonGuardar(boolean botonGuardar) {
        this.botonGuardar = botonGuardar;
    }
      
      
    
}
