/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Educationallevel;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface EducationallevelFacadeLocal {

    void create(Educationallevel educationallevel);

    void edit(Educationallevel educationallevel);

    void remove(Educationallevel educationallevel);

    Educationallevel find(Object id);

    List<Educationallevel> findAll();

    List<Educationallevel> findRange(int[] range);

    int count();
    
}
