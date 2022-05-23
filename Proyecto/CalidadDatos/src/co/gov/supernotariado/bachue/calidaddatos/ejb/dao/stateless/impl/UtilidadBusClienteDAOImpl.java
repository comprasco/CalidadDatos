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

import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IUtilidadBusClienteDAO;
import co.gov.supernotariado.bachue.calidaddatos.interfaces.IEntityManagerFactory;
import co.gov.supernotariado.bachue.clientebus.vo.ClienteIntegracionVO;

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
public class UtilidadBusClienteDAOImpl implements IUtilidadBusClienteDAO {

	private final static Logger CD_LOGGER = Logger.getLogger(UtilidadBusClienteDAOImpl.class);

	/**
	 * Atributo de instancia tipo IEntityManagerFactory para definir la propiedad
	 * entity factory.
	 */
	@EJB
	private IEntityManagerFactory iiemf_entityFactory;

	@Override
	public ClienteIntegracionVO consultarUrlDispositivoServicio() {

		ClienteIntegracionVO lm_clienteIntegracionVo = new ClienteIntegracionVO();

		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();

		try {

			Query lq_sql = lem_entityManager.createNativeQuery(
					"SELECT CARACTER FROM SDB_PGN_CONSTANTES WHERE ID_CONSTANTE = 'CONSULTAR_SESION_ENDPOINT'");
			Object Resultado = lq_sql.getSingleResult();
			lm_clienteIntegracionVo.setIs_url(Resultado.toString());

			lem_entityManager.close();

		} catch (Exception ae_exception) {
			CD_LOGGER.error("Excepcion:UtilidadBusClienteDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage());
		}
		return lm_clienteIntegracionVo;
	}

	@Override
	public ClienteIntegracionVO consultarWsdlEspacioNombre() {

		ClienteIntegracionVO lm_clienteIntegracionVo = new ClienteIntegracionVO();

		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();

		try {

			Query lq_sql = lem_entityManager.createNativeQuery(
					"SELECT CARACTER FROM SDB_PGN_CONSTANTES WHERE ID_CONSTANTE = 'NOMBRE_ESPACIO_BIOMETRICO'");
			Object Resultado = lq_sql.getSingleResult();
			lm_clienteIntegracionVo.setIs_espacioNombre(Resultado.toString());

			lem_entityManager.close();

		} catch (Exception ae_exception) {
			CD_LOGGER.error("Excepcion:UtilidadBusClienteDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage());
		}
		return lm_clienteIntegracionVo;
	}
	
	@Override
	public ClienteIntegracionVO consultarWsdlServicioNombre() {

		ClienteIntegracionVO lm_clienteIntegracionVo = new ClienteIntegracionVO();

		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();

		try {

			Query lq_sql = lem_entityManager.createNativeQuery(
					"SELECT CARACTER FROM SDB_PGN_CONSTANTES WHERE ID_CONSTANTE = 'NOMBRE_SERVICIO_BIOMETRICO'");
			Object Resultado = lq_sql.getSingleResult();
			lm_clienteIntegracionVo.setIs_nombreServicioSoap(Resultado.toString());

			lem_entityManager.close();

		} catch (Exception ae_exception) {
			CD_LOGGER.error("Excepcion:UtilidadBusClienteDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage());
		}
		return lm_clienteIntegracionVo;
	}
}