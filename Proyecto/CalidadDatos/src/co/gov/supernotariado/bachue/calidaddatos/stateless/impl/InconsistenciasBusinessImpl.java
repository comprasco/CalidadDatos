/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InconsistenciasBusinessImp.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless.impl
 * Nombre del elemento: InconsistenciasBusinessImp
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.stateless.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

import co.gov.supernotariado.bachue.calidaddatos.dto.InconsistenciaDTO;
import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IInconsistenciasDAO;
import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl.InconsistenciaCampoDAOImpl;
import co.gov.supernotariado.bachue.calidaddatos.stateless.IInconsistenciasBusiness;


/**
 * Clase tipo EJB (Enterprise Java Bean) de la capa de negocio. <br>
 * Contiene la implementacion logica de las operaciones del recurso
 * Inconsistencias. <br>
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Stateless (name = "InconsistenciasBussinesImp", mappedName = "InconsistenciasBussinesImp")
@LocalBean
public class InconsistenciasBusinessImpl implements IInconsistenciasBusiness 
{
	/**
	 * Define la constante CD_LOGGER.
	 */
	private final static Logger CD_LOGGER = Logger.getLogger(InconsistenciaCampoDAOImpl.class);

	/**
	 * Atributo de instancia tipo IInconsistenciasDAO para definir la propiedad
	 * inconsistencias DAO.
	 */
	@EJB
	private IInconsistenciasDAO iii_iInconsistenciasDao;

	
	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciasBusiness#inconsistenciasDTO()
	 */
	public List<InconsistenciaDTO> inconsistenciasDTO() 
	{
		List<InconsistenciaDTO> lli_InconsistenciasDto = null;
		try
		{
			lli_InconsistenciasDto = iii_iInconsistenciasDao.listaInconsistenciaDto();
		}
		catch (Exception ae_exception) 
		{
			CD_LOGGER.error("Excepcion:InconsistenciaBusinessImpl:inconsistenciasDTO:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception);
		}
		return lli_InconsistenciasDto;
	}

}
