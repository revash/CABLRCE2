/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.session;

import cl.entity.Professional;
import cl.entity.ProfessionalPK;
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

}
