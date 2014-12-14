/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Medicalhypothesis;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface MedicalhypothesisFacadeLocal {

    void create(Medicalhypothesis medicalhypothesis);

    void edit(Medicalhypothesis medicalhypothesis);

    void remove(Medicalhypothesis medicalhypothesis);

    Medicalhypothesis find(Object id);

    List<Medicalhypothesis> findAll();

    List<Medicalhypothesis> findRange(int[] range);

    int count();
    
}
