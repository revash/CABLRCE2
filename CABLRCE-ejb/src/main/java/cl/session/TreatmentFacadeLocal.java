/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Treatment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface TreatmentFacadeLocal {

    void create(Treatment treatment);

    void edit(Treatment treatment);

    void remove(Treatment treatment);

    Treatment find(Object id);

    List<Treatment> findAll();

    List<Treatment> findRange(int[] range);

    int count();
    
}
