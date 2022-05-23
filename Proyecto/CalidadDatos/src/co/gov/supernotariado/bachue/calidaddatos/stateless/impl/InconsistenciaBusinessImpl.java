/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InconsistenciaBusinessImpl.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless.impl
 * Nombre del elemento: InconsistenciaBusinessImpl
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.stateless.impl;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.gov.supernotariado.bachue.calidaddatos.dto.InconsistenciaDTO;
import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IInconsistenciaDAO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.helper.InconsistenciaHelper;
import co.gov.supernotariado.bachue.calidaddatos.stateless.IInconsistenciaBusiness;


/**
 * Clase tipo EJB (Enterprise Java Bean) de la capa de negocio. <br>
 * Contiene la implementacion logica de las operaciones del recurso
 * Inconsistencia. <br>
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Stateless (name = "InconsistenciaBusinessImpl", mappedName = "InconsistenciaBusinessImpl")
@LocalBean
public class InconsistenciaBusinessImpl implements IInconsistenciaBusiness
{
	
	/**
	 * Atributo private de tipo ILInconsistenciaDAO que almacena el valor de la
	 * variable ILInconsistenciaDAO.
	 */
	@EJB
	private IInconsistenciaDAO iLInconsistenciaDAO;
	
	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaBusiness#inconsistenciaDTO(java.lang.String, java.lang.String)
	 */
	@Override
	public InconsistenciaDTO inconsistenciaDTO(String as_nombreTabla, String as_nombreCampo) 
	{
		InconsistenciaDTO li_inconsistenciaDto;
		li_inconsistenciaDto = InconsistenciaHelper.inconsistenciaDTOCompleto(iLInconsistenciaDAO.inconsistenciaVO(as_nombreTabla, as_nombreCampo));
		return li_inconsistenciaDto;
	}
}