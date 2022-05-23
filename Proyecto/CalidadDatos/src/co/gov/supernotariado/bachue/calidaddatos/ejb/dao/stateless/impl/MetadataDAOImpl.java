/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: MetadataDAOImpl.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl
 * Nombre del elemento: MetadataDAOImpl
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IMetadataDAO;
import co.gov.supernotariado.bachue.calidaddatos.interfaces.IEntityManagerFactory;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.MetadataVO;


/**
 * Clase tipo objeto de acceso a datos (DAO). <br>
 * Permite interactuar con la base de datos manipulando y realizando operaciones
 * <br>
 * sobre el modelo de datos Metadata.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Stateless
@LocalBean
public class MetadataDAOImpl implements IMetadataDAO{


	final static Logger CD_LOGGER = Logger.getLogger(InconsistenciaCampoDAOImpl.class);

	/**
	 * Atributo de instancia tipo IEntityManagerFactory para definir la propiedad
	 * entity factory.
	 */
	@EJB
	private IEntityManagerFactory iiemf_entityFactory;
	

	@Override
	public MetadataVO metadata(String as_nombreTabla, String as_nombreCampo) {
		MetadataVO lm_metadataVo = new MetadataVO();
		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
		try {
			
			Query lq_sql = lem_entityManager.createNativeQuery("select table_name,column_name,data_type,data_length from all_tab_columns  where table_name = ? and column_name = ?  and owner = 'ADM_INCONSISTENTE'");
			lq_sql.setParameter(1, as_nombreTabla);
			lq_sql.setParameter(2, as_nombreCampo);
			Object[] lo_metadata = (Object[]) lq_sql.getSingleResult();
			if(lo_metadata!=null) {
				lm_metadataVo.setIs_nombreTabla(lo_metadata[0].toString().toUpperCase());
				lm_metadataVo.setIs_nombreColumna(lo_metadata[1].toString().toUpperCase());
				lm_metadataVo.setIs_tipoDato(lo_metadata[2].toString().toUpperCase());
				lm_metadataVo.setIs_largoCampo(lo_metadata[3].toString().toUpperCase());	
			}

			
			lem_entityManager.close();
		} catch (Exception ae_exception) {
			CD_LOGGER.error("Excepcion:MetadataDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage());
		}
		return lm_metadataVo;
	}

}
