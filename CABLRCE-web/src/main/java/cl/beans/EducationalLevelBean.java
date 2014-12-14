/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entity.Educationallevel;
import cl.session.BussinesFacade2;
import cl.session.BussinesFacadeLocal2;
import cl.session.EducationallevelFacade;
import cl.session.EducationallevelFacadeLocal;
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
public class EducationalLevelBean {
    @EJB
    private final EducationallevelFacadeLocal educationallevelFacade;
    @EJB
    private final BussinesFacadeLocal2 bussinesFacade2;
    
    private Educationallevel nivelEducacion, selectedNivelEducacion;
    private List<Educationallevel> nivelEducacionales, filterNivelEducacion;
    
    private boolean botonGuardar;
    
  
    
    public EducationalLevelBean() {
        
        bussinesFacade2 = new BussinesFacade2();
        educationallevelFacade  = new EducationallevelFacade();
        
    }
       @PostConstruct
    public void myInit() {
        nivelEducacion = new Educationallevel() ;
        selectedNivelEducacion = new Educationallevel();
        nivelEducacionales = educationallevelFacade.findAll();
        botonGuardar = true;
    }

    
    
    
    
    
    public void createNivelEducacion() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
            if (bussinesFacade2.existeNivelEducacionalId(nivelEducacion.getElevelid())) {
                educationallevelFacade.create(nivelEducacion);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Educacion guardada", null));
                String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/EducationalLevels.xhtml"));
                extContext.redirect(url);
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "el ID ingresado ya se encuentra registrado",null));
            }

         

    }
      public void editNivelEducacion() throws IOException{      
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if(!nivelEducacion.getEleveldesc().equalsIgnoreCase("")){
             educationallevelFacade.edit(nivelEducacion);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Edicion Guardada", null));
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/EducationalLevels.xhtml"));
            extContext.redirect(url);
        }
        else{
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se deben completar los campos", null));
        }
    }
      
    
  
      public void onRowSelect(){
        nivelEducacion = selectedNivelEducacion;
        System.out.println("NivelEducacion id " + nivelEducacion.getElevelid());
        botonGuardar = false;
    } 
    
  
    


    
    // gett and sett
    public Educationallevel getNivelEducacion() {
        return nivelEducacion;
    }

    public void setNivelEducacion(Educationallevel nivelEducacion) {
        this.nivelEducacion = nivelEducacion;
    }

    public Educationallevel getSelectedNivelEducacion() {
        return selectedNivelEducacion;
    }

    public void setSelectedNivelEducacion(Educationallevel selectedNivelEducacion) {
        this.selectedNivelEducacion = selectedNivelEducacion;
    }

    public List<Educationallevel> getNivelEducacionales() {
        return nivelEducacionales;
    }

    public void setNivelEducacionales(List<Educationallevel> nivelEducacionales) {
        this.nivelEducacionales = nivelEducacionales;
    }

    public List<Educationallevel> getFilterNivelEducacion() {
        return filterNivelEducacion;
    }

    public void setFilterNivelEducacion(List<Educationallevel> filterNivelEducacion) {
        this.filterNivelEducacion = filterNivelEducacion;
    }

    public boolean isBotonGuardar() {
        return botonGuardar;
    }

    public void setBotonGuardar(boolean botonGuardar) {
        this.botonGuardar = botonGuardar;
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
