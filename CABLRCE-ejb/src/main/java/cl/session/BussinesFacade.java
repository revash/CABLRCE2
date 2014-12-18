/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.session;

import cl.entity.Clinicalepisode;
import cl.entity.Mediccontrol;
import cl.entity.Obstetricdata;
import cl.entity.Patientrecord;
import cl.entity.Person;
import cl.entity.PersonPK;
import cl.entity.Professional;
import cl.entity.ProfessionalPK;
import cl.entity.Scheduling;
import cl.entity.Statusclinicalepisode;
import cl.entity.Statussheduling;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AndresEduardo
 */
@Stateless
public class BussinesFacade implements BussinesFacadeLocal {

    @PersistenceContext(unitName = "cl_CABLRCE-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Professional getProfessional(Integer rut, String dv, String clave) {
        Query query = em.createQuery("SELECT p FROM Professional p WHERE p.professionalPK.rut = :rut and p.professionalPK.dv = :dv and p.password = :clave");
        query.setParameter("rut", rut);
        query.setParameter("dv", dv);
        query.setParameter("clave", clave);
        if (!query.getResultList().isEmpty()) {
            return (Professional) query.getResultList().get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean existeRolID(Integer id) {
        Query q = em.createQuery("SELECT r FROM Role r WHERE r.roleid = :id");
        q.setParameter("id", id);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean existeUnitId(Integer id) {
        Query q = em.createQuery("SELECT u FROM Unit u WHERE u.unitid = :id");
        q.setParameter("id", id);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean existeSpecialityID(Integer id) {
        Query q = em.createQuery("SELECT u FROM Speciality u WHERE u.specialityid = :id");
        q.setParameter("id", id);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean existeProfesioanlByPK(ProfessionalPK pk) {
        Query q = em.createQuery("SELECT p FROM Professional p WHERE p.professionalPK.rut = :rut and p.professionalPK.dv = :dv");
        q.setParameter("rut",pk.getRut());
        q.setParameter("dv", pk.getDv());
        return q.getResultList().isEmpty();
    }

    @Override
    public Person getPersona(Integer Rut, String dv) {
        Query q = em.createQuery("SELECT p FROM Person p WHERE p.personPK.rut =:rut and p.personPK.dv = :dv");
        q.setParameter("rut", Rut);
        q.setParameter("dv", dv);
        if(!q.getResultList().isEmpty()){
            return (Person) q.getResultList().get(0);
        }else{
            System.out.println("dato query nulla");
            return null;
        }
        
    }

    @Override
    public boolean existePaciente(PersonPK personPk) {
        Query q = em.createQuery("SELECT p FROM Patientrecord p WHERE p.patientrecordPK.rut = :rut and p.patientrecordPK.dv = :dv and p.patientrecordPK.nationalityid = :nac");
        q.setParameter("rut", personPk.getRut());
        q.setParameter("dv", personPk.getDv());
        q.setParameter("nac", personPk.getNationalityid());
        return q.getResultList().isEmpty();
    }

    @Override
    public Integer getPK( ) {
       Query q = em.createNativeQuery("SELECT seq_number from sequence_table where seq_name ='FICHAS'");
       return (Integer) q.getSingleResult();
    }

    @Override
    public Patientrecord getPaciente(PersonPK personPk) {
        Query q = em.createQuery("SELECT p FROM Patientrecord p WHERE p.patientrecordPK.rut = :rut and p.patientrecordPK.dv = :dv and p.patientrecordPK.nationalityid = :nac");
        q.setParameter("rut", personPk.getRut());
        q.setParameter("dv", personPk.getDv());
        q.setParameter("nac", personPk.getNationalityid());
        return (Patientrecord) q.getResultList().get(0);
    }

    @Override
    public void agregarPKSeq(Integer dato) {
        Query q = em.createNativeQuery("UPDATE sequence_table  SET seq_number = "+dato+" where seq_name ='FICHAS'");
        q.executeUpdate();
    }
    
   @Override
    public Statussheduling getEstadoSchudling(Integer dato){
        Query q = em.createQuery("SELECT s FROM Statussheduling s WHERE s.statusshedulingid = :dato");
        q.setParameter("dato", dato);
        return (Statussheduling) q.getResultList().get(0);
        
    }
    @Override
    public Professional getProfessionalAgenda(Integer rut) {
        Query query = em.createQuery("SELECT p FROM Professional p WHERE p.professionalPK.rut = :rut");
        query.setParameter("rut", rut);
        if (!query.getResultList().isEmpty()) {
            return (Professional) query.getResultList().get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean existeEpisodioObstetrico(Patientrecord paciente, Integer idEsp){
        Query q = em.createQuery("SELECT e FROM Clinicalepisode e WHERE e.clinicalepisodePK.recordnumber = :numeroFicha and e.SpecialityId = :idEsp");
        q.setParameter("numeroFicha", paciente.getPatientrecordPK().getRecordnumber());
        q.setParameter("idEsp", idEsp);
        return q.getResultList().isEmpty();
    }
    
    @Override
    public Statusclinicalepisode getEstadoEnCurso(Integer dato){
        Query q = em.createQuery("SELECT s FROM Statusclinicalepisode s WHERE s.statusepisodeid = :dato");
        q.setParameter("dato", dato);
        return (Statusclinicalepisode) q.getResultList().get(0);
    
    }
    
    @Override
    public Statussheduling getEstadoAgendado(){
        Query q = em.createQuery("SELECT s FROM Statussheduling s WHERE s.statusshedulingid = 1");
        return (Statussheduling) q.getResultList();
    }
    @Override
    public Statussheduling getEstadoSignos(){
        Query q = em.createQuery("SELECT s FROM Statussheduling s WHERE s.statusshedulingid = 2");
        return (Statussheduling) q.getResultList();
    }
    
    @Override
    public Patientrecord getFicha(Integer id){
        Query q = em.createQuery("SELECT f FROM Patientrecord f WHERE f.patientrecordPK.recordnumber = :id");
        q.setParameter("id", id);
        return (Patientrecord) q.getResultList().get(0);
    }
    
    @Override
    public Clinicalepisode getEpisodioObstetrico(Patientrecord paciente, Integer idEsp){
        Query q = em.createQuery("SELECT e FROM Clinicalepisode e WHERE e.clinicalepisodePK.recordnumber = :numeroFicha and e.SpecialityId = :idEsp AND e.statusepisodeid.statusepisodeid = 1");
        q.setParameter("numeroFicha", paciente.getPatientrecordPK().getRecordnumber());
        q.setParameter("idEsp", idEsp);
        return (Clinicalepisode) q.getResultList().get(0);
    }
    
    @Override
    public List<Scheduling> getListaPorEstado(Integer dato){
        Query q = em.createQuery("SELECT s FROM Scheduling s WHERE s.statusshedulingid.statusshedulingid = :dato");
        q.setParameter("dato", dato);
        return  q.getResultList();
    }
    
    ///control medico
    @Override
    public Mediccontrol getControlMedicoEnCurso(Integer aux){
        Query q = em.createQuery("SELECT m FROM Mediccontrol m WHERE m.mediccontrolPK.recordnumber = :ficha and m.status = 2");
        q.setParameter("ficha", aux);
        if(!q.getResultList().isEmpty()){
            return (Mediccontrol) q.getResultList().get(0);
        }else{
            return null;
        }
    
    }
    
    @Override
    public List<Scheduling> getListaPorEstadoMedico(){
        Query q = em.createQuery("SELECT s FROM Scheduling s WHERE s.statusshedulingid.statusshedulingid = 2");
        return  q.getResultList();
    }
    
    @Override
    public List<Scheduling> getListaPorEstadoTecnico(){
        Query q = em.createQuery("SELECT s FROM Scheduling s WHERE s.statusshedulingid.statusshedulingid = 1 AND s.schedulingPK.date2 = :date");
        q.setParameter("date", new Date());
        return  q.getResultList();
    }
   
    
    @Override
    public boolean existenDatosObstetricos(Integer dato){
        Query q = em.createQuery("SELECT d FROM Obstetricdata d WHERE d.obstetricdataPK.recordnumber = :id");
        q.setParameter("id", dato);
        return q.getResultList().isEmpty();
    }

    @Override
    public Obstetricdata getDatosObstetricos(Integer dato){
        Query q = em.createQuery("SELECT o FROM Obstetricdata o WHERE o.obstetricdataPK.recordnumber = :dato");
        q.setParameter("dato", dato);
        if(!q.getResultList().isEmpty()){
            return (Obstetricdata) q.getResultList().get(0);
        }else{
            return null;
        }
    }
}
