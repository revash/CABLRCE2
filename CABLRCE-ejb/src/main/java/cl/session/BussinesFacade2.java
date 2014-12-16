/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MaxiCorp
 */
@Stateless
public class BussinesFacade2 implements BussinesFacadeLocal2{
    @PersistenceContext(unitName = "cl_CABLRCE-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public boolean existeReligionId(Integer id) {
        Query q = em.createQuery("SELECT r FROM Religion r WHERE r.religionid = :id");
        q.setParameter("id", id);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean existeGrupoSanguineoId(Integer id) {
        Query q = em.createQuery("SELECT r FROM Bloodgroup r WHERE r.bgroupid = :id");
        q.setParameter("id", id);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean existeNivelEducacionalId(Integer id) {
        Query q = em.createQuery("SELECT r FROM Educationallevel r WHERE r.elevelid = :id");
        q.setParameter("id", id);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean existePrevisionId(Integer id) {
        Query q = em.createQuery("SELECT r FROM Prevision r WHERE r.previd = :id");
        q.setParameter("id", id);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean existeTipoPrevisionId(Integer id) {
        Query q = em.createQuery("SELECT r FROM Tipeprevision r WHERE r.tipeprevid = :id");
        q.setParameter("id", id);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean existeNacionalidadId(Integer id) {
         Query q = em.createQuery("SELECT r FROM Nationality r WHERE r.nationalityid = :id");
        q.setParameter("id", id);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean existeControlMedicoId(Integer id) {
         Query q = em.createQuery("SELECT r FROM Mediccontrol r WHERE r.controlid = :id");
        q.setParameter("id", id);
        return q.getResultList().isEmpty();
    }
    
    
   
}
