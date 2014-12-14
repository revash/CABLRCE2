/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Tipehypothesis;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AndresEduardo
 */
@Stateless
public class TipehypothesisFacade extends AbstractFacade<Tipehypothesis> implements TipehypothesisFacadeLocal {
    @PersistenceContext(unitName = "cl_CABLRCE-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipehypothesisFacade() {
        super(Tipehypothesis.class);
    }
    
}
