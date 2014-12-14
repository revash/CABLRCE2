/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Datarecordobstetric;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface DatarecordobstetricFacadeLocal {

    void create(Datarecordobstetric datarecordobstetric);

    void edit(Datarecordobstetric datarecordobstetric);

    void remove(Datarecordobstetric datarecordobstetric);

    Datarecordobstetric find(Object id);

    List<Datarecordobstetric> findAll();

    List<Datarecordobstetric> findRange(int[] range);

    int count();
    
}
