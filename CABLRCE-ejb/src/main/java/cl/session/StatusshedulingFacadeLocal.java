/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Statussheduling;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface StatusshedulingFacadeLocal {

    void create(Statussheduling statussheduling);

    void edit(Statussheduling statussheduling);

    void remove(Statussheduling statussheduling);

    Statussheduling find(Object id);

    List<Statussheduling> findAll();

    List<Statussheduling> findRange(int[] range);

    int count();
    
}
