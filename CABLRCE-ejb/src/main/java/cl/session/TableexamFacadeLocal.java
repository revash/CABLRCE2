/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Tableexam;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface TableexamFacadeLocal {

    void create(Tableexam tableexam);

    void edit(Tableexam tableexam);

    void remove(Tableexam tableexam);

    Tableexam find(Object id);

    List<Tableexam> findAll();

    List<Tableexam> findRange(int[] range);

    int count();
    
}
