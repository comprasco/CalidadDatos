/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: CirculoRegistralBusinessImpl.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless.impl
 * Nombre del elemento: CirculoRegistralBusinessImpl
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.stateless.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.gov.supernotariado.bachue.calidaddatos.dto.CirculoRegistralDTO;
import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.ICirculoRegistralDAO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.helper.CirculoRegistralHelper;
import co.gov.supernotariado.bachue.calidaddatos.stateless.ICirculoRegistralBusiness;


/**
 * Clase tipo EJB (Enterprise Java Bean) de la capa de negocio. <br>
 * Contiene la implementacion logica de las operaciones del recurso Circulo
 * registral. <br>
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Stateless (name = "SdbPgnCirculoRegistralBusinessImpl", mappedName = "SdbPgnCirculoRegistralBusinessImpl")
@LocalBean
public class CirculoRegistralBusinessImpl implements ICirculoRegistralBusiness
{
	
	/**
	 * Atributo de instancia tipo ILCirculoRegistralDAO para definir la propiedad
	 * circulo registral DAO.
	 */
	@EJB
	private ICirculoRegistralDAO iicr_iLCirculoRegistralDao; 

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILCirculoRegistralBusiness#listaCirculoRegistralDTO()
	 */
	@Override
	public List<CirculoRegistralDTO> listaCirculoRegistralDTO() 
	{
		List<CirculoRegistralDTO> llcr_circuloRegistral = CirculoRegistralHelper.listaEntidadSimpleDTO(iicr_iLCirculoRegistralDao.listaCirculoRegistral());	
		return llcr_circuloRegistral;
	}
}