/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Recordcontroldiabetic;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface RecordcontroldiabeticFacadeLocal {

    void create(Recordcontroldiabetic recordcontroldiabetic);

    void edit(Recordcontroldiabetic recordcontroldiabetic);

    void remove(Recordcontroldiabetic recordcontroldiabetic);

    Recordcontroldiabetic find(Object id);

    List<Recordcontroldiabetic> findAll();

    List<Recordcontroldiabetic> findRange(int[] range);

    int count();
    
}
