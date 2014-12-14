/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Maternalpathologies;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface MaternalpathologiesFacadeLocal {

    void create(Maternalpathologies maternalpathologies);

    void edit(Maternalpathologies maternalpathologies);

    void remove(Maternalpathologies maternalpathologies);

    Maternalpathologies find(Object id);

    List<Maternalpathologies> findAll();

    List<Maternalpathologies> findRange(int[] range);

    int count();
    
}
