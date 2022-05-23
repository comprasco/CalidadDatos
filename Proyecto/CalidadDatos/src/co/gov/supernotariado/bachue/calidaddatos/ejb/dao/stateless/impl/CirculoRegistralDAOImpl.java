/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: CirculoRegistralDAOImpl.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl
 * Nombre del elemento: CirculoRegistralDAOImpl
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.ICirculoRegistralDAO;
import co.gov.supernotariado.bachue.calidaddatos.interfaces.IEntityManagerFactory;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.CirculoRegistralVO;



/**
 * Clase tipo objeto de acceso a datos (DAO). <br>
 * Permite interactuar con la base de datos manipulando y realizando operaciones
 * <br>
 * sobre el modelo de datos Circulo registral.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Stateless
@LocalBean
public class CirculoRegistralDAOImpl implements ICirculoRegistralDAO
{
	/**
	 * Define la constante CD_LOGGER.
	 */
	private final static Logger CD_LOGGER = Logger.getLogger(InconsistenciaCampoDAOImpl.class);
		
	
	/**
	 * Atributo de instancia tipo IEntityManagerFactory para definir la propiedad
	 * entity factory.
	 */
	@EJB
	private IEntityManagerFactory iiemf_entityFactory;

	@Override
	public List<CirculoRegistralVO> listaCirculoRegistral() 
	{
		List<CirculoRegistralVO> llcr_circuloRegistralVo = new ArrayList<>(); 
		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
		
		String ls_queryConsulta = "SELECT id_circulo, nombre FROM SDB_PGN_CIRCULO_REGISTRAL order by id_circulo ";
		try 
		{
			Query lq_query = lem_entityManager.createNativeQuery(ls_queryConsulta);
			@SuppressWarnings("unchecked")
			List<Object[]> llo_metadata =  lq_query.getResultList();
			if(!llo_metadata.isEmpty()) 
			{
				for(Object[] obj: llo_metadata)
				{
					CirculoRegistralVO lcr_circuloRegistralVo = new CirculoRegistralVO();
					if(obj[0] != null) 
					{
						lcr_circuloRegistralVo.setIs_idCirculo(obj[0].toString());	
					}
					if(obj[1] != null) 
					{
						lcr_circuloRegistralVo.setIs_nombre(obj[1].toString());
					}
					llcr_circuloRegistralVo.add(lcr_circuloRegistralVo);
				}	
			}	
			lem_entityManager.close();
		} 
		catch (Exception ae_exception) 
		{
			CD_LOGGER.error("Excepcion:CirculoRegitralDAOlmpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage());
		}
		return llcr_circuloRegistralVo;	
	}		
}