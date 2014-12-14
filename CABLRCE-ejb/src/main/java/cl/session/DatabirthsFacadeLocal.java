/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Databirths;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface DatabirthsFacadeLocal {

    void create(Databirths databirths);

    void edit(Databirths databirths);

    void remove(Databirths databirths);

    Databirths find(Object id);

    List<Databirths> findAll();

    List<Databirths> findRange(int[] range);

    int count();
    
}
