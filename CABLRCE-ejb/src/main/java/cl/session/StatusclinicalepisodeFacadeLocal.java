/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Statusclinicalepisode;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface StatusclinicalepisodeFacadeLocal {

    void create(Statusclinicalepisode statusclinicalepisode);

    void edit(Statusclinicalepisode statusclinicalepisode);

    void remove(Statusclinicalepisode statusclinicalepisode);

    Statusclinicalepisode find(Object id);

    List<Statusclinicalepisode> findAll();

    List<Statusclinicalepisode> findRange(int[] range);

    int count();
    
}
