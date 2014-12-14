/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entity.Sex;
import cl.session.BussinesFacade1;
import cl.session.BussinesFacadeLocal1;
import cl.session.SexFacade;
import cl.session.SexFacadeLocal;
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
 * @author Mauro
 */
@ManagedBean
@RequestScoped
public class SexoBean {

    @EJB
    private final SexFacadeLocal sexFacade;
    @EJB
    private final BussinesFacadeLocal1 bussinesFacade1;

    private Sex sexo, selectedsexo;
    private List<Sex> sexos, filterSexos;
    String auxId;
    private boolean botonGuardar;

    public SexoBean() {
        sexFacade = new SexFacade();
        bussinesFacade1 = new BussinesFacade1();
    }
    
    @PostConstruct
    public void MyInit() {
        sexo = new Sex();
        selectedsexo = new Sex();
        sexos = sexFacade.findAll();
        botonGuardar= true;

    }

    /**
     * Creates a new instance of SexoBean
     * @throws java.io.IOException
     */


    public void editSexo() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if (!sexo.getSexdescription().equalsIgnoreCase("")) {
            sexFacade.edit(sexo);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sexo Guardado Exitosamente", null));
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Sexo.xhtml"));
            extContext.redirect(url);
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se deben completar los campos", null));
        }
    }

    

public void onRowSelect(){
       sexo = selectedsexo;
        System.out.println("Sexo id " + sexo.getSexid());
        botonGuardar = false;
    }

    

       public void createSexo() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
    //    if (!auxId.equalsIgnoreCase("") && !sexo.getSexdescription().equalsIgnoreCase("")) {
       //     sexo.setSexid(Integer.parseInt(auxId));
            if (bussinesFacade1.existeSexId(sexo.getSexid())) {
                sexFacade.create(sexo);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sexo Guardado Exitosamente", null));
                String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Sexo.xhtml"));
                extContext.redirect(url);
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "el ID ingresado ya se encuentra registrado", null));
            }
        }

    /*  {
    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se deben completar los campos", null));
    }
    }*/
    public Sex getSexo() {
        return sexo;
    }

    public void setSexo(Sex sexo) {
        this.sexo = sexo;
    }

    public Sex getSelectedsexo() {
        return selectedsexo;
    }

    public void setSelectedsexo(Sex selectedsexo) {
        this.selectedsexo = selectedsexo;
    }

    public List<Sex> getSexos() {
        return sexos;
    }

    public void setSexos(List<Sex> sexos) {
        this.sexos = sexos;
    }

    public List<Sex> getFilterSexos() {
        return filterSexos;
    }

    public void setFilterSexos(List<Sex> filterSexos) {
        this.filterSexos = filterSexos;
    }

    public String getAuxId() {
        return auxId;
    }

    public void setAuxId(String auxId) {
        this.auxId = auxId;
    }

    public boolean isBotonGuardar() {
        return botonGuardar;
    }

    public void setBotonGuardar(boolean botonGuardar) {
        this.botonGuardar = botonGuardar;
    }
       
       
}
