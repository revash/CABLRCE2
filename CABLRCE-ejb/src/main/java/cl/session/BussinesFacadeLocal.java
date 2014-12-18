/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.session;

import cl.entity.Clinicalepisode;
import cl.entity.Databirths;
import cl.entity.DatabirthsPK;
import cl.entity.Mediccontrol;
import cl.entity.Obstetricdata;
import cl.entity.Patientrecord;
import cl.entity.Person;
import cl.entity.PersonPK;
import cl.entity.Professional;
import cl.entity.ProfessionalPK;
import cl.entity.Scheduling;
import cl.entity.Statusclinicalepisode;
import cl.entity.Statussheduling;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface BussinesFacadeLocal {

    public Professional getProfessional(Integer rut, String dv, String clave);

    public Professional getProfessionalAgenda(Integer rut);

    public boolean existeRolID(Integer id);

    public boolean existeUnitId(Integer id);

    public boolean existeSpecialityID(Integer id);

    public boolean existeProfesioanlByPK(ProfessionalPK pk);

    public Person getPersona(Integer Rut, String dv);

    public boolean existePaciente(PersonPK personPk);

    public Integer getPK();

    public Patientrecord getPaciente(PersonPK personPk);

    public void agregarPKSeq(Integer dato);

    public Statussheduling getEstadoSchudling(Integer dato);

    public boolean existeEpisodioObstetrico(Patientrecord paciente, Integer idEsp);

    public Statusclinicalepisode getEstadoEnCurso(Integer dato);

    public Patientrecord getFicha(Integer id);

    public Clinicalepisode getEpisodioObstetrico(Patientrecord paciente, Integer idEsp);

    public List<Scheduling> getListaPorEstado(Integer dato);

    public Statussheduling getEstadoAgendado();

    public Statussheduling getEstadoSignos();

    //control medico
    public Mediccontrol getControlMedicoEnCurso(Integer aux);

    public List<Scheduling> getListaPorEstadoMedico();

    public boolean existenDatosObstetricos(Integer dato);

    public Obstetricdata getDatosObstetricos(Integer dato);
    
    public List<Scheduling> getListaPorEstadoTecnico();

}
