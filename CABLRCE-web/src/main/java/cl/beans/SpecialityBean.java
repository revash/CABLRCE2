/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entity.Speciality;
import cl.entity.Unit;
import cl.session.BussinesFacade;
import cl.session.BussinesFacadeLocal;
import cl.session.SpecialityFacade;
import cl.session.SpecialityFacadeLocal;
import cl.session.UnitFacade;
import cl.session.UnitFacadeLocal;
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
public class SpecialityBean {

    @EJB
    private BussinesFacadeLocal bussinesFacade;
    @EJB
    private final SpecialityFacadeLocal specialityFacade;
    @EJB
    private final UnitFacadeLocal unitFacade;

    private List<Speciality> specialities, filterSpecialities;
    private Speciality speciality, selectedSpeciality;
    private List<Unit> units;

    public SpecialityBean() {
        specialityFacade = new SpecialityFacade();
        unitFacade = new UnitFacade();
        bussinesFacade = new BussinesFacade();
    }

    @PostConstruct
    public void myInit() {
        speciality = new Speciality();
        selectedSpeciality = new Speciality();
        units = unitFacade.findAll();
        specialities = specialityFacade.findAll();
    }

    public void createSpeciality() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if (bussinesFacade.existeSpecialityID(speciality.getSpecialityid())) {
            specialityFacade.create(speciality);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Especialidad Guardado Exitosamente", null));
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Specialities.xhtml"));
            extContext.redirect(url);
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "el ID ingresado ya se encuentra registrado", null));
        }
    }
    
     public void editSpeciality() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        specialityFacade.edit(speciality);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Especialidad Guardado Exitosamente", null));
        String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Specialities.xhtml"));
        extContext.redirect(url);
    }

    //get and set
    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }

    public List<Speciality> getFilterSpecialities() {
        return filterSpecialities;
    }

    public void setFilterSpecialities(List<Speciality> filterSpecialities) {
        this.filterSpecialities = filterSpecialities;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Speciality getSelectedSpeciality() {
        return selectedSpeciality;
    }

    public void setSelectedSpeciality(Speciality selectedSpeciality) {
        this.selectedSpeciality = selectedSpeciality;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

}
