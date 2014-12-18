/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.Aplications.appBean;
import static cl.Aplications.appBean.sha256;
import cl.entity.Professional;
import cl.entity.ProfessionalPK;
import cl.entity.Role;
import cl.entity.Speciality;
import cl.entity.Unit;
import cl.session.BussinesFacade;
import cl.session.ProfessionalFacade;
import cl.session.ProfessionalFacadeLocal;
import cl.session.RoleFacade;
import cl.session.RoleFacadeLocal;
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
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author AndresEduardo
 */
@ManagedBean
@RequestScoped
public class ProfessionalBean {

    @EJB
    private final RoleFacadeLocal roleFacade;
    @EJB
    private final SpecialityFacadeLocal specialityFacade;
    @EJB
    private final UnitFacadeLocal unitFacade;

    @EJB
    private final ProfessionalFacadeLocal professionalFacade;
    @EJB
    private final cl.session.BussinesFacadeLocal bussinesFacade;
    private String dv, rut, rut2, clave;
    private Professional professional, selectedProfessional, newProfesioanl;
    private List<Professional> professionals, filterProfessionals;
    private List<Role> roles;
    private List<Unit> units;
    private List<Speciality> specialities;
    private boolean btnGuardar;
    private ProfessionalPK profPk;
    public ProfessionalBean() {
        bussinesFacade = new BussinesFacade();
        professionalFacade = new ProfessionalFacade();
        unitFacade = new UnitFacade();
        specialityFacade = new SpecialityFacade();
        roleFacade = new RoleFacade();
        rut = "";

    }

    @PostConstruct
    public void myInit() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        if (extContext.getSessionMap().get("UsuarioSistema") != null) {
            professional = (Professional) extContext.getSessionMap().get("UsuarioSistema");
        } else {
            professional = new Professional();
        }
        selectedProfessional = new Professional();
        professionals = professionalFacade.findAll();
        units = unitFacade.findAll();
        roles = roleFacade.findAll();
        specialities = specialityFacade.findAll();
        newProfesioanl = new Professional();
        btnGuardar = true;
        rut = "";

    }

    public void login() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        rut = rut.replace("-", "");
        rut = rut.replace(".", "");
        String rut1 = rut.substring(0, rut.length() - 1);
        String dv2 = rut.charAt(rut.length() - 1) + "";
        clave = sha256(clave);
        Professional professionalAux = bussinesFacade.getProfessional(Integer.parseInt(rut1), dv2, clave);
        if (professionalAux == null) {
            System.out.println("null");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en Credenciales1", "Datos Invalidos"));
        } else {
            if (professionalAux.getPassword().equals(clave)) {
                ExternalContext extContext = context.getExternalContext();
                extContext.getSessionMap().put("UsuarioSistema", professionalAux);
                if (professionalAux.getRoleid().getRoleid() == 1) {
                    System.out.println("1");
                    String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/layouts/administrador.xhtml"));
                    extContext.redirect(url);
                }
                if (professionalAux.getRoleid().getRoleid() == 2) {
                    String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/layouts/admisionista.xhtml"));
                    extContext.redirect(url);
                }
                if (professionalAux.getRoleid().getRoleid() == 3) {
                    String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/layouts/tecnicoParamedico.xhtml"));
                    extContext.redirect(url);
                }
                if (professionalAux.getRoleid().getRoleid() == 5) {
                    String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/layouts/medico.xhtml"));
                    extContext.redirect(url);
                }
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en Credenciales2", "Datos Invalidos"));
            }
        }
    }

    public void onValidaRut() {
        rut = rut.replace("-", "");
        rut = rut.replace(".", "");
        String rut1 = rut.substring(0, rut.length() - 1);
        dv = rut.charAt(rut.length() - 1) + "";
        if (!appBean.validarRut(rut1, dv)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Rut Invalido", "Rut Invalido"));
        }
    }

    public void onFormateaRut() {
        this.setRut(appBean.FormateaRut(rut));
    }

    public void checkRutProExist() {
        rut = rut.replace("-", "");
        rut = rut.replace(".", "");
        String rut1 = rut.substring(0, rut.length() - 1);
        dv = rut.charAt(rut.length() - 1) + "";
        ProfessionalPK aux = new ProfessionalPK(Integer.parseInt(rut1), dv);
        if (!bussinesFacade.existeProfesioanlByPK(aux)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Rut ya Registrado", "Rut Invalido"));
        }
    }
    //Crear Profesional

    public void crearProfesioanl() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        rut = rut.replace("-", "");
        rut = rut.replace(".", "");
        String rut1 = rut.substring(0, rut.length() - 1);
        String dv2 = rut.charAt(rut.length() - 1) + "";
        clave = sha256(newProfesioanl.getPassword());
        newProfesioanl.setPassword(clave);
        newProfesioanl.setAddress("");
        profPk = new ProfessionalPK(Integer.parseInt(rut1), dv2);
        newProfesioanl.setProfessionalPK(profPk);
        if (appBean.validarRut(rut1, dv2)) {
            if (bussinesFacade.existeProfesioanlByPK(profPk)) {
                professionalFacade.create(newProfesioanl);
                professionals = professionalFacade.findAll();
                String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Professionals.xhtml"));
                extContext.redirect(url);
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Rut ya Registrado", "Rut Invalido"));
            }
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Rut no valido", "Rut Invalido"));
        }
    }

    public void editarProfesioanl() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        rut = rut.replace("-", "");
        rut = rut.replace(".", "");
        String rut1 = rut.substring(0, rut.length() - 1);
        String dv2 = rut.charAt(rut.length() - 1) + "";
        clave = sha256(newProfesioanl.getPassword());
        newProfesioanl.setPassword(clave);
        newProfesioanl.setAddress("");
        profPk = new ProfessionalPK(Integer.parseInt(rut1), dv2);
        newProfesioanl.setProfessionalPK(profPk);
        professionalFacade.edit(newProfesioanl);
        professionals = professionalFacade.findAll();
        String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Mantenedores/CABL/Professionals.xhtml"));
        extContext.redirect(url);
            
    }
    
     public void logOut() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        session.invalidate();
        RequestContext context = RequestContext.getCurrentInstance();
        appBean appBean = new appBean();
        context.addCallbackParam("url2", appBean.getBaseUrl2() + "/login.xhtml");
    }

//get y set
    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Professional getSelectedProfessional() {
        return selectedProfessional;
    }

    public void setSelectedProfessional(Professional selectedProfessional) {
        this.selectedProfessional = selectedProfessional;
    }

    public List<Professional> getProfessionals() {
        return professionals;
    }

    public void setProfessionals(List<Professional> professionals) {
        this.professionals = professionals;
    }

    public List<Professional> getFilterProfessionals() {
        return filterProfessionals;
    }

    public void setFilterProfessionals(List<Professional> filterProfessionals) {
        this.filterProfessionals = filterProfessionals;
    }

    public Professional getNewProfesioanl() {
        return newProfesioanl;
    }

    public void setNewProfesioanl(Professional newProfesioanl) {
        this.newProfesioanl = newProfesioanl;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }

    public boolean isBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(boolean btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public String getRut2() {
        return rut2;
    }

    public void setRut2(String rut2) {
        this.rut2 = rut2;
    }

    public ProfessionalPK getProfPk() {
        return profPk;
    }

    public void setProfPk(ProfessionalPK profPk) {
        this.profPk = profPk;
    }

}
