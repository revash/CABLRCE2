/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Professional;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface ProfessionalFacadeLocal {

    void create(Professional professional);

    void edit(Professional professional);

    void remove(Professional professional);

    Professional find(Object id);

    List<Professional> findAll();

    List<Professional> findRange(int[] range);

    int count();
    
}
