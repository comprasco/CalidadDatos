/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: CorreccionMatriculaDAOImp.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl
 * Nombre del elemento: CorreccionMatriculaDAOImp
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

import co.gov.supernotariado.bachue.calidaddatos.dto.CirculoRegistralDTO;
import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.ICorreccionMatriculaDAO;
import co.gov.supernotariado.bachue.calidaddatos.interfaces.IEntityManagerFactory;

/**
 * Clase tipo objeto de acceso a datos (DAO). <br>
 * Permite interactuar con la base de datos manipulando y realizando operaciones
 * sobre el modelo de datos<br>
 *
 * @author Smartsoft Solutions S.A.S Nota:
 * @version 1.0
 */
@Stateless
@LocalBean
public class CorreccionMatriculaDAOImpl implements ICorreccionMatriculaDAO
{
	/**
	 * Define la constante CD_LOGGER.
	 */
	final static Logger CD_LOGGER = Logger.getLogger(InconsistenciaCampoDAOImpl.class);
	
	/**
	 * Atributo de instancia tipo IEntityManagerFactory para definir la propiedad
	 * entity factory.
	 */
	@EJB
	private IEntityManagerFactory iiemf_entityFactory;
	
	
	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.ICorreccionMatriculaDAO#oripDTO()
	 */
	@Override
	public List<CirculoRegistralDTO> oripDTO() 
	{
		CirculoRegistralDTO lcr_circuloRegistralDto  = null;
		List<CirculoRegistralDTO> llcr_circuloRegistralDto = new ArrayList<CirculoRegistralDTO>();
		try 
		{
			for(int i = 1; i < 5; i++)
			{
				lcr_circuloRegistralDto = new CirculoRegistralDTO();
				lcr_circuloRegistralDto.setIs_nombre("Orip " + i);
				lcr_circuloRegistralDto.setIs_idCirculo(""+i);
				llcr_circuloRegistralDto.add(lcr_circuloRegistralDto);
			}			
		} 
		catch (Exception ae_exception) 
		{
			CD_LOGGER.error("Excepcion:CorrecionMatriculaDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage());
		}
		return llcr_circuloRegistralDto;
	}
}
