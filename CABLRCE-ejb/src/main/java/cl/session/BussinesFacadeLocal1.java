/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import javax.ejb.Local;

/**
 *
 * @author Mauro
 */
@Local
public interface BussinesFacadeLocal1 {
    public boolean existeSexId(Integer id);
    public boolean existeCommuneid(Integer id);
    
}
