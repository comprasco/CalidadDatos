/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: MetadataBusinessImpl.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless.impl
 * Nombre del elemento: MetadataBusinessImpl
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.stateless.impl;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.gov.supernotariado.bachue.calidaddatos.dto.MetadataDTO;
import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IMetadataDAO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.helper.MetadataHelper;
import co.gov.supernotariado.bachue.calidaddatos.stateless.IMetadataBusiness;

/**
 * Clase tipo EJB (Enterprise Java Bean) de la capa de negocio. <br>
 * Contiene la implementacion logica de las operaciones del recurso Metadata.
 * <br>
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Stateless (name = "MetadaBusinessImpl", mappedName = "MetadaBusinessImpl")
@LocalBean
public class MetadataBusinessImpl implements IMetadataBusiness {

	/**
	 * Atributo private de tipo ILMetadataDAO que almacena el valor de la variable
	 * ILMetadataDAO.
	 */
	@EJB
	private IMetadataDAO  iLMetadaDAO;

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILMetadataBusiness#metadata(java.lang.String, java.lang.String)
	 */
	@Override
	
	public MetadataDTO metadata(String as_nombreTabla, String as_nombreCampo) {
		MetadataDTO lm_metadaDto;
		lm_metadaDto = MetadataHelper.metadataDTOCompleto(iLMetadaDAO.metadata(as_nombreTabla, as_nombreCampo));
		return lm_metadaDto;
	}
	
}
