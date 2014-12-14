/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Nativetowns;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface NativetownsFacadeLocal {

    void create(Nativetowns nativetowns);

    void edit(Nativetowns nativetowns);

    void remove(Nativetowns nativetowns);

    Nativetowns find(Object id);

    List<Nativetowns> findAll();

    List<Nativetowns> findRange(int[] range);

    int count();
    
}
