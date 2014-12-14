/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Tipebirths;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface TipebirthsFacadeLocal {

    void create(Tipebirths tipebirths);

    void edit(Tipebirths tipebirths);

    void remove(Tipebirths tipebirths);

    Tipebirths find(Object id);

    List<Tipebirths> findAll();

    List<Tipebirths> findRange(int[] range);

    int count();
    
}
