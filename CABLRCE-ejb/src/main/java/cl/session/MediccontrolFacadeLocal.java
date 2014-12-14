/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Mediccontrol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface MediccontrolFacadeLocal {

    void create(Mediccontrol mediccontrol);

    void edit(Mediccontrol mediccontrol);

    void remove(Mediccontrol mediccontrol);

    Mediccontrol find(Object id);

    List<Mediccontrol> findAll();

    List<Mediccontrol> findRange(int[] range);

    int count();
    
}
