/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Scheduling;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface SchedulingFacadeLocal {

    void create(Scheduling scheduling);

    void edit(Scheduling scheduling);

    void remove(Scheduling scheduling);

    Scheduling find(Object id);

    List<Scheduling> findAll();

    List<Scheduling> findRange(int[] range);

    int count();
    
}
