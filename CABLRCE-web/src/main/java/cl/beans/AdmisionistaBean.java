/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.beans;

import cl.entity.Person;
import cl.session.BussinesFacade;
import cl.session.BussinesFacadeLocal;
import cl.session.PersonFacade;
import cl.session.PersonFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author AndresEduardo
 */
@ManagedBean
@ViewScoped
public class AdmisionistaBean {
    @EJB
    private final PersonFacadeLocal personFacade;
    @EJB
    private final BussinesFacadeLocal bussinesFacade;

    /**
     * Creates a new instance of AdmisionistaBean
     */
    
    private List<Person> persons, filterPersons;
    private Person person, selectedPerson;
    private String rut;
    
    public AdmisionistaBean() {
        personFacade = new PersonFacade();
        bussinesFacade = new BussinesFacade();
    }
    
    @PostConstruct
    public void myInit(){
        person = new Person();
        selectedPerson = new Person();
        persons = personFacade.findAll();
    }
    
    
    
    

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getFilterPersons() {
        return filterPersons;
    }

    public void setFilterPersons(List<Person> filterPersons) {
        this.filterPersons = filterPersons;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
    
    
    
    
    
    
}
