/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Diagnostic;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface DiagnosticFacadeLocal {

    void create(Diagnostic diagnostic);

    void edit(Diagnostic diagnostic);

    void remove(Diagnostic diagnostic);

    Diagnostic find(Object id);

    List<Diagnostic> findAll();

    List<Diagnostic> findRange(int[] range);

    int count();
    
}
