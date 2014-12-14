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
 * @author Mauro
 */
@Stateless
public class BussinesFacade1 implements BussinesFacadeLocal1{
    @PersistenceContext(unitName = "cl_CABLRCE-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public boolean existeSexId(Integer id) {
       Query q = em.createQuery("SELECT s FROM Sex s WHERE s.sexid = :id");
       q.setParameter("id", id);
       return q.getResultList().isEmpty();
    }

        public boolean existeCommuneid(Integer id) {
        Query q = em.createQuery("SELECT c FROM Commune c WHERE c.communeid = :id");
        q.setParameter("id", id);
        return q.getResultList().isEmpty();
                
    }
}
