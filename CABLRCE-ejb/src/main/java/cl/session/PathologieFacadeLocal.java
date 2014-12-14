/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Pathologie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface PathologieFacadeLocal {

    void create(Pathologie pathologie);

    void edit(Pathologie pathologie);

    void remove(Pathologie pathologie);

    Pathologie find(Object id);

    List<Pathologie> findAll();

    List<Pathologie> findRange(int[] range);

    int count();
    
}
