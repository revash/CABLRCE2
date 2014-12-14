/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Tipehypothesis;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface TipehypothesisFacadeLocal {

    void create(Tipehypothesis tipehypothesis);

    void edit(Tipehypothesis tipehypothesis);

    void remove(Tipehypothesis tipehypothesis);

    Tipehypothesis find(Object id);

    List<Tipehypothesis> findAll();

    List<Tipehypothesis> findRange(int[] range);

    int count();
    
}
