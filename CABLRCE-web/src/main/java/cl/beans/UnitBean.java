/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entity.Unit;
import cl.session.BussinesFacade;
import cl.session.BussinesFacadeLocal;
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
public class UnitBean {

    @EJB
    private final BussinesFacadeLocal bussinesFacade;
    @EJB
    private final UnitFacadeLocal unitFacade;
    private List<Unit> units, filterUnit;
    private Unit selectedUnit, unit;
    private String id;
    private boolean bntGuardar;

    public UnitBean() {
        unitFacade = new UnitFacade();
        bussinesFacade = new BussinesFacade();
    }

    @PostConstruct
    public void myInit() {
        unit = new Unit();
        selectedUnit = new Unit();
        units = unitFacade.findAll();
        bntGuardar = true;
    }

    //metodos
    public void actBtnGuardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            Integer aux = Integer.parseInt(id);
            bntGuardar = false;
        } catch (Exception e) {

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se deben ingresar Solo Numeros en el ID", null));
        }
    }

    public void createUnits() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if (!id.equalsIgnoreCase("") && !unit.getUnitname().equalsIgnoreCase("")) {
            unit.setUnitid(Integer.parseInt(id));
            if (bussinesFacade.existeUnitId(unit.getUnitid())) {
                unitFacade.create(unit);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Unidad Guardada Exitosamente", null));
                String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Units.xhtml"));
                extContext.redirect(url);
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "el ID ingresado ya se encuentra registrado", null));
            }

        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se deben completar los campos", null));
        }
    }

    public void editUnits() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if (!unit.getUnitname().equalsIgnoreCase("")) {
            unitFacade.edit(unit);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Unidad Guardada Exitosamente", null));
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Units.xhtml"));
            extContext.redirect(url);
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se deben completar los campos", null));
        }
    }

    //get y set
    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public List<Unit> getFilterUnit() {
        return filterUnit;
    }

    public void setFilterUnit(List<Unit> filterUnit) {
        this.filterUnit = filterUnit;
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isBntGuardar() {
        return bntGuardar;
    }

    public void setBntGuardar(boolean bntGuardar) {
        this.bntGuardar = bntGuardar;
    }

}
