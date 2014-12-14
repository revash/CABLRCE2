/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entity.Commune;
import cl.session.BussinesFacade1;
import cl.session.BussinesFacadeLocal1;
import cl.session.CommuneFacade;
import cl.session.CommuneFacadeLocal;
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
public class ComunaBean {
//ejb
    @EJB
    private BussinesFacadeLocal1 bussinesFacade1;
    @EJB
    private CommuneFacadeLocal communeFacade;

    private Commune comuna, selectedcomuna;
    private List<Commune> comunas, filterComunas;

    /**
     * Creates a new instance of ComunaBean
     */
    public ComunaBean() {
        communeFacade = new CommuneFacade();
        bussinesFacade1 = new BussinesFacade1();
    }

    @PostConstruct
    public void MyInit() {
        comuna = new Commune();
        comunas = communeFacade.findAll();
        selectedcomuna = new Commune();
    }

    public void editComuna() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if (!comuna.getCommunename().equalsIgnoreCase("")) {
            communeFacade.edit(comuna);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Comuna Guardada Exitosamente", null));
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Comuna.xhtml"));
            extContext.redirect(url);
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se deben completar los campos", null));
        }
    }

    public void createComuna() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
    //    if (!auxId.equalsIgnoreCase("") && !sexo.getSexdescription().equalsIgnoreCase("")) {
        //     sexo.setSexid(Integer.parseInt(auxId));
        if (bussinesFacade1.existeCommuneid(comuna.getCommuneid())) {
            communeFacade.create(comuna);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Comuna Guardada Exitosamente", null));
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Comuna.xhtml"));
            extContext.redirect(url);
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "el ID ingresado ya se encuentra registrado", null));
        }
    }

    public BussinesFacadeLocal1 getBussinesFacade1() {
        return bussinesFacade1;
    }

    public void setBussinesFacade1(BussinesFacadeLocal1 bussinesFacade1) {
        this.bussinesFacade1 = bussinesFacade1;
    }

    public CommuneFacadeLocal getCommuneFacade() {
        return communeFacade;
    }

    public void setCommuneFacade(CommuneFacadeLocal communeFacade) {
        this.communeFacade = communeFacade;
    }

    public Commune getComuna() {
        return comuna;
    }

    public void setComuna(Commune comuna) {
        this.comuna = comuna;
    }

    public Commune getSelectedcomuna() {
        return selectedcomuna;
    }

    public void setSelectedcomuna(Commune selectedcomuna) {
        this.selectedcomuna = selectedcomuna;
    }

    public List<Commune> getComunas() {
        return comunas;
    }

    public void setComunas(List<Commune> comunas) {
        this.comunas = comunas;
    }

    public List<Commune> getFilterComunas() {
        return filterComunas;
    }

    public void setFilterComunas(List<Commune> filterComunas) {
        this.filterComunas = filterComunas;
    }
    
}
