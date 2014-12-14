/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Bloodgroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface BloodgroupFacadeLocal {

    void create(Bloodgroup bloodgroup);

    void edit(Bloodgroup bloodgroup);

    void remove(Bloodgroup bloodgroup);

    Bloodgroup find(Object id);

    List<Bloodgroup> findAll();

    List<Bloodgroup> findRange(int[] range);

    int count();
    
}
