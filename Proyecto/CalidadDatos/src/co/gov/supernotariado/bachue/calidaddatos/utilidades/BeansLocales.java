/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: BeansLocales.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.utilidades
 * Nombre del elemento: BeansLocales
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.utilidades;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;

import co.gov.supernotariado.bachue.calidaddatos.stateless.IInconsistenciaCampoBusiness;
import co.gov.supernotariado.bachue.calidaddatos.stateless.IServicioIntegracionBusiness;


/**
 * El elemento Class BeansLocales.<br>
 * Representa utilidades para los beans locales.<br>
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class BeansLocales {
	
	/**
	 * Define la constante CL_LOGGER.
	 */
	final static Logger CD_LOGGER = Logger.getLogger(BeansLocales.class);

	/**
	 * Construye una nueva instancia/objeto de la clase BeansLocales.
	 */
	private BeansLocales() {
		//contructor vacion de modelo
	}

	/**
	 * Obtener IL inconsistencia campo business.
	 *
	 * @return Resultado para obtener IL inconsistencia campo business retornado
	 *         como ILInconsistenciaCampoBusiness
	 */
	public static IInconsistenciaCampoBusiness obtenerILInconsistenciaCampoBusiness() {
		InitialContext lic_contexto = null;
		try {
			lic_contexto = new InitialContext();
			IInconsistenciaCampoBusiness liurb_usuarioRolBusiness;
			liurb_usuarioRolBusiness = (IInconsistenciaCampoBusiness) lic_contexto.lookup(crearRutaEJB(
					"InconsistenciaCampoBusinessImpl!co.gov.supernotariado.bachue.calidaddatos.stateless.impl.InconsistenciaCampoBusinessImpl",
					lic_contexto));
			return liurb_usuarioRolBusiness;
		} catch (Exception ae_excepcion) {
			CD_LOGGER.error("Excepcion:BeansLocales:obtenerILInconsistenciaCampoBusiness:Mensaje: " + ae_excepcion.getMessage());
			CD_LOGGER.error(ae_excepcion.getMessage(), ae_excepcion);
			return (IInconsistenciaCampoBusiness) lic_contexto;
		}
	}
	
	/**
	 * Metodo que crea la ruta del ejb.
	 *
	 * @param as_nameJndi el parametro name jndi
	 * @param ai_contexto el parametro contexto
	 * @return ls_rutaEJB
	 * @throws NamingException la excepcion naming exception
	 */
	private static String crearRutaEJB(String as_nameJndi, InitialContext ai_contexto) throws NamingException {

		String ls_moduleName = (String) ai_contexto.lookup("java:module/ModuleName");
		String ls_applicationName = (String) ai_contexto.lookup("java:app/AppName");
		String ls_rutaEJB;
		ls_rutaEJB = "java:global." + ls_applicationName + "."
				+ (ls_moduleName.equals(ls_applicationName) ? "" : ls_moduleName + ".") + as_nameJndi;
		return ls_rutaEJB;

	}
	
	/**
	 * Metodo para generar EJB fuera del contexto.
	 *
	 * @return Resultado para consultar servicio integracion retornado como
	 *         IServicioIntegracionBusiness
	 */
	public static IServicioIntegracionBusiness consultarServicioIntegracion() {

		try {

			InitialContext lic_contexto = new InitialContext();
			IServicioIntegracionBusiness lisib_servicioIntegracionBusiness;
			lisib_servicioIntegracionBusiness = (IServicioIntegracionBusiness) lic_contexto.lookup(crearRutaEJB(
					"ServicioIntegracionBusiness!co.gov.supernotariado.bachue.calidaddatos.stateless.impl.BiometriaConsultarSesionBusinessImpl",
					lic_contexto));

			return lisib_servicioIntegracionBusiness;
		} catch (Exception ae_excepcion) {
			CD_LOGGER.error("Excepcion:BeansLocales:consultarServicioIntegracion:Mensaje: " + ae_excepcion.getMessage());
			CD_LOGGER.error(ae_excepcion.getMessage());
			IServicioIntegracionBusiness lic_contexto = null;
			return lic_contexto;
		}
	}
}
