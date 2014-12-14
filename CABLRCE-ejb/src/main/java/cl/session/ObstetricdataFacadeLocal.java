/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Obstetricdata;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface ObstetricdataFacadeLocal {

    void create(Obstetricdata obstetricdata);

    void edit(Obstetricdata obstetricdata);

    void remove(Obstetricdata obstetricdata);

    Obstetricdata find(Object id);

    List<Obstetricdata> findAll();

    List<Obstetricdata> findRange(int[] range);

    int count();
    
}
