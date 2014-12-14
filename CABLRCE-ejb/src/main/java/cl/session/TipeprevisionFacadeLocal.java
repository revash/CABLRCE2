/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Tipeprevision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface TipeprevisionFacadeLocal {

    void create(Tipeprevision tipeprevision);

    void edit(Tipeprevision tipeprevision);

    void remove(Tipeprevision tipeprevision);

    Tipeprevision find(Object id);

    List<Tipeprevision> findAll();

    List<Tipeprevision> findRange(int[] range);

    int count();
    
}
