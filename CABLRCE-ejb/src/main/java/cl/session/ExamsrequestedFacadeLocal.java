/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Examsrequested;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface ExamsrequestedFacadeLocal {

    void create(Examsrequested examsrequested);

    void edit(Examsrequested examsrequested);

    void remove(Examsrequested examsrequested);

    Examsrequested find(Object id);

    List<Examsrequested> findAll();

    List<Examsrequested> findRange(int[] range);

    int count();
    
}
