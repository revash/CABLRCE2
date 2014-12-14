/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.session;

import cl.entity.Professional;
import cl.entity.ProfessionalPK;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface BussinesFacadeLocal {
    
    public Professional getProfessional(Integer rut, String dv,String clave);
    public boolean existeRolID(Integer id);
    public boolean existeUnitId(Integer id);
    public boolean existeSpecialityID(Integer id);
    public boolean existeProfesioanlByPK(ProfessionalPK pk);
    
}
