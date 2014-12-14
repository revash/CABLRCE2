/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.beans;

import cl.entity.Role;
import cl.session.BussinesFacade;
import cl.session.BussinesFacadeLocal;
import cl.session.RoleFacade;
import cl.session.RoleFacadeLocal;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author AndresEduardo
 */
@ManagedBean
@RequestScoped
public class RoleBean {
    @EJB
    private final BussinesFacadeLocal bussinesFacade;
    @EJB
    private final RoleFacadeLocal roleFacade;
    
    private Role rol,selectedRol;
    private List<Role> roles, filterRoles;
    String auxID;
    private boolean botonGuardar;
    public RoleBean() {
        
        roleFacade = new RoleFacade();
        bussinesFacade = new BussinesFacade();
    }
    
    @PostConstruct
    public void myInit(){
        rol = new Role();
        selectedRol = new Role();
        roles = roleFacade.findAll();
        botonGuardar = true;
        
    }
    //crear Rol
    public void createRol() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if(!auxID.equalsIgnoreCase("") && !rol.getRolename().equalsIgnoreCase("")){
            rol.setRoleid(Integer.parseInt(auxID));
            if(bussinesFacade.existeRolID(rol.getRoleid())){
            roleFacade.create(rol);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Rol Guardado Exitosamente", null));
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Roles.xhtml"));
            extContext.redirect(url);
            }
            else{
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "el ID ingresado ya se encuentra registrado", null));
            }
            
        }
        else{
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se deben completar los campos", null));
        }
    }
    
    public void editRol() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if(!rol.getRolename().equalsIgnoreCase("")){
            roleFacade.edit(rol);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Rol Guardado Exitosamente", null));
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Roles.xhtml"));
            extContext.redirect(url);
        }
        else{
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se deben completar los campos", null));
        }
    }
    
    
    
    public String redirectEdit()throws IOException{
        System.out.println("entro");
        return "RolUpdate.xhtml";
    }
    
    public void onRowSelect(){
        rol = selectedRol;
        System.out.println("rol id " + rol.getRoleid());
        botonGuardar = false;
    }
    
    //get y set
    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    public Role getSelectedRol() {
        return selectedRol;
    }

    public void setSelectedRol(Role selectedRol) {
        this.selectedRol = selectedRol;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getFilterRoles() {
        return filterRoles;
    }

    public void setFilterRoles(List<Role> filterRoles) {
        this.filterRoles = filterRoles;
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
