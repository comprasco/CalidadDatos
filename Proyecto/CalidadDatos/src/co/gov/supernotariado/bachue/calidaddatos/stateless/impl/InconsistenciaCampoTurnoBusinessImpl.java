/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InconsistenciaCampoTurnoBusinessImpl.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless.impl
 * Nombre del elemento: InconsistenciaCampoTurnoBusinessImpl
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.stateless.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO;
import co.gov.supernotariado.bachue.calidaddatos.dto.InformacionInconsistenciaDTO;
import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IInconsistenciaCampoTurnoDAO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.helper.InformacionInconsistenciaHelper;
import co.gov.supernotariado.bachue.calidaddatos.persistence.helper.InformacionInconsistenciaTurnoHelper;
import co.gov.supernotariado.bachue.calidaddatos.stateless.IInconsistenciaCampoTurnoBusiness;

/**
 * Clase tipo EJB (Enterprise Java Bean) de la capa de negocio. <br>
 * Contiene la implementacion logica de las operaciones del recurso
 * Inconsistencia campo turno. <br>
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Stateless
@LocalBean
public class InconsistenciaCampoTurnoBusinessImpl implements IInconsistenciaCampoTurnoBusiness {
	
	/**
	 * Atributo private de tipo ILInconsistenciaCampoTurnoDAO que almacena el valor
	 * de la variable ILInconsistenciaCampoTurnoDAO.
	 */
	@EJB
	private IInconsistenciaCampoTurnoDAO iic_iLInconsistenciaCampoTurnoDao;
	
	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoTurnoBusiness#consultaInformacionInconsistenciaTurno(co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO)
	 */
	@Override
	public List<InformacionInconsistenciaDTO> consultaInformacionInconsistenciaTurno(ConsultaInconsistenciasDTO acid_consultaInconsistenciasDTO) {

		List<InformacionInconsistenciaDTO> llic_listaDto  = InformacionInconsistenciaTurnoHelper.listaInformacionInconsistenciaDTO(
				iic_iLInconsistenciaCampoTurnoDao.consultarInformacionInconsistenciaTurnoVO(acid_consultaInconsistenciasDTO));

		return llic_listaDto;
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoTurnoBusiness#guardaInconsistencia(co.gov.supernotariado.bachue.calidaddatos.dto.InformacionInconsistenciaDTO)
	 */
	@Override
	public Boolean guardaInconsistencia(final InformacionInconsistenciaDTO aii_informacionInconsistenciaDto) {
		Boolean lb_guardar = iic_iLInconsistenciaCampoTurnoDao.guardaInconsistencia(
				InformacionInconsistenciaHelper.completoInformacionInconsistenciaVO(aii_informacionInconsistenciaDto));
		return lb_guardar;
	}
	

}
