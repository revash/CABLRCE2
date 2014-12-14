/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Nationality;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface NationalityFacadeLocal {

    void create(Nationality nationality);

    void edit(Nationality nationality);

    void remove(Nationality nationality);

    Nationality find(Object id);

    List<Nationality> findAll();

    List<Nationality> findRange(int[] range);

    int count();
    
}
