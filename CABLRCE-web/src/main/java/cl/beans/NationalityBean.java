/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.converters.nationalityConverter;
import cl.entity.Nationality;
import cl.session.BussinesFacade2;
import cl.session.BussinesFacadeLocal2;
import cl.session.NationalityFacade;
import cl.session.NationalityFacadeLocal;
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
public class NationalityBean {
    @EJB
    private NationalityFacadeLocal nationalityFacade;
    @EJB
    private final BussinesFacadeLocal2 bussinesFacade2;

    
    
    private Nationality nacionalidad, SelectedNacionalidad;
    private List<Nationality> nacionalidades, filterNacionalidad;
    private boolean botonGuardar;
    
            
    public NationalityBean() {
        
        bussinesFacade2 = new BussinesFacade2();
        nationalityFacade  = new NationalityFacade();
     
    }
    
    @PostConstruct
    public void myInit() {
        nacionalidad = new Nationality();
        SelectedNacionalidad= new Nationality();
        nacionalidades  = nationalityFacade.findAll();
        botonGuardar = true;
   }
    
     public void createNacionalidad() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
            if (bussinesFacade2.existeNacionalidadId(nacionalidad.getNationalityid())) {
                nationalityFacade.create(nacionalidad);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nacionalidad guardada", null));
                String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Nacionalidades.xhtml"));
                extContext.redirect(url);
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "el ID ingresado ya se encuentra registrado", null));
            }
    }

        public void editNacionalidad() throws IOException{      
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if(!nacionalidad.getNationalityname().equalsIgnoreCase("")){
            nationalityFacade.edit(nacionalidad);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Edicion Guardada", null));
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Nacionalidades.xhtml"));
            extContext.redirect(url);
        }
        else{
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se deben completar los campos", null));
        }
    }
        
      public void onRowSelect(){
        nacionalidad = SelectedNacionalidad;
        System.out.println("Nacionalidad " + nacionalidad.getNationalityid());
        botonGuardar = false;
    }       
    
    
    //get and sett
    

    public Nationality getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nationality nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Nationality getSelectedNacionalidad() {
        return SelectedNacionalidad;
    }

    public void setSelectedNacionalidad(Nationality SelectedNacionalidad) {
        this.SelectedNacionalidad = SelectedNacionalidad;
    }

    public List<Nationality> getNacionalidades() {
        return nacionalidades;
    }

    public void setNacionalidades(List<Nationality> nacionalidades) {
        this.nacionalidades = nacionalidades;
    }

    public List<Nationality> getFilterNacionalidad() {
        return filterNacionalidad;
    }

    public void setFilterNacionalidad(List<Nationality> filterNacionalidad) {
        this.filterNacionalidad = filterNacionalidad;
    }

    public boolean isBotonGuardar() {
        return botonGuardar;
    }

    public void setBotonGuardar(boolean botonGuardar) {
        this.botonGuardar = botonGuardar;
    }
    
    
    
    
    
}
