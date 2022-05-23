/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InconsistenciasDAOImp.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl
 * Nombre del elemento: InconsistenciasDAOImp
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

import co.gov.supernotariado.bachue.calidaddatos.dto.InconsistenciaDTO;
import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IInconsistenciasDAO;

/**
 * Clase tipo objeto de acceso a datos (DAO). <br>
 * Permite interactuar con la base de datos manipulando y realizando operaciones
 * <br>
 * sobre el modelo de datos Inconsistencia.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Stateless
@LocalBean
public class InconsistenciasDAOImpl implements IInconsistenciasDAO 
{	
	/**
	 * Define la constante CD_LOGGER.
	 */
	private final static Logger CD_LOGGER = Logger.getLogger(InconsistenciaCampoDAOImpl.class);
	
	/**
	 * Este metodo permite consulta las inconsitencias.
	 *
	 * @return Resultado para inconsistencia DTO retornado como una lista de
	 *         InconsistenciaDTO
	 */

	@Override
	public List<InconsistenciaDTO> listaInconsistenciaDto() 
	{
		InconsistenciaDTO li_inconsistenciasDto = new InconsistenciaDTO();
		List<InconsistenciaDTO> lli_inconsistenciasDto = new ArrayList<InconsistenciaDTO>();
		try 
		{
			
			lli_inconsistenciasDto.add(li_inconsistenciasDto);
		} 
		catch (Exception ae_exception) 
		{
			CD_LOGGER.error("Excepcion:InconsistenciaDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage());
		}
		return lli_inconsistenciasDto;
	}
}