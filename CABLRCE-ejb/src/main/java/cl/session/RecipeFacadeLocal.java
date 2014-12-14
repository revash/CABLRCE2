/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Recipe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface RecipeFacadeLocal {

    void create(Recipe recipe);

    void edit(Recipe recipe);

    void remove(Recipe recipe);

    Recipe find(Object id);

    List<Recipe> findAll();

    List<Recipe> findRange(int[] range);

    int count();
    
}
