/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Clinicalepisode;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface ClinicalepisodeFacadeLocal {

    void create(Clinicalepisode clinicalepisode);

    void edit(Clinicalepisode clinicalepisode);

    void remove(Clinicalepisode clinicalepisode);

    Clinicalepisode find(Object id);

    List<Clinicalepisode> findAll();

    List<Clinicalepisode> findRange(int[] range);

    int count();
    
}
