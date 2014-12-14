/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Patientrecord;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface PatientrecordFacadeLocal {

    void create(Patientrecord patientrecord);

    void edit(Patientrecord patientrecord);

    void remove(Patientrecord patientrecord);

    Patientrecord find(Object id);

    List<Patientrecord> findAll();

    List<Patientrecord> findRange(int[] range);

    int count();
    
}
