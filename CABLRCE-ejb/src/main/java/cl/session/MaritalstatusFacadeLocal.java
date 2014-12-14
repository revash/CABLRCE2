/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Maritalstatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface MaritalstatusFacadeLocal {

    void create(Maritalstatus maritalstatus);

    void edit(Maritalstatus maritalstatus);

    void remove(Maritalstatus maritalstatus);

    Maritalstatus find(Object id);

    List<Maritalstatus> findAll();

    List<Maritalstatus> findRange(int[] range);

    int count();
    
}
