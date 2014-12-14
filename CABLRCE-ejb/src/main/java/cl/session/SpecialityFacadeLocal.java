/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Speciality;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface SpecialityFacadeLocal {

    void create(Speciality speciality);

    void edit(Speciality speciality);

    void remove(Speciality speciality);

    Speciality find(Object id);

    List<Speciality> findAll();

    List<Speciality> findRange(int[] range);

    int count();
    
}
