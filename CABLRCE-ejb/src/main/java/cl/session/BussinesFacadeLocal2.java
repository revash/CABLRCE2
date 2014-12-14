/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.session;

import javax.ejb.Local;

/**
 *
 * @author MaxiCorp
 */
@Local
public interface BussinesFacadeLocal2 {
    public boolean existeReligionId(Integer id);
    public boolean existeGrupoSanguineoId(Integer id);
    public boolean existeNivelEducacionalId(Integer id);
}
