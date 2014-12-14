/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Sex;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface SexFacadeLocal {

    void create(Sex sex);

    void edit(Sex sex);

    void remove(Sex sex);

    Sex find(Object id);

    List<Sex> findAll();

    List<Sex> findRange(int[] range);

    int count();
    
}
