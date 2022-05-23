/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: UtilidadExcepciones.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.utilidades
 * Nombre del elemento: UtilidadExcepciones
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.utilidades;

import java.util.MissingFormatArgumentException;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.TransactionRolledbackLocalException;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;

import com.sun.xml.ws.client.ClientTransportException;

import co.gov.supernotariado.bachue.calidaddatos.LenguajeSelector.PropiedadesSelector;
import co.gov.supernotariado.bachue.calidaddatos.dto.ExcepcionGenericaDTO;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumExcepcionesGenerales;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumTipoExcepciones;
import co.gov.supernotariado.bachue.calidaddatos.exception.ExcepcionesDatosEntrada;
import co.gov.supernotariado.bachue.calidaddatos.exception.ExcepcionesNegocio;
import co.gov.supernotariado.bachue.calidaddatos.exception.ExcepcionesTecnicas;
import co.gov.supernotariado.bachue.calidaddatos.exception.IEnumCatalogoMensajes;

/**
 * El elemento Class UtilidadExcepciones.<br>
 * Representa un/una utilidad excepciones.<br>
 * Clase que permite recibir excepciones, consulta los mensajes en los archivos
 * de internacionalizacion y genera estructuras de datos correctas para manejar
 * dichas excepciones
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class UtilidadExcepciones {

	/**
	 * Construye una nueva instancia/objeto de la clase UtilidadExcepciones.
	 */
	private UtilidadExcepciones() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Define la constante CL_LOGGER.
	 */
	private static final Logger CL_LOGGER = Logger.getLogger(UtilidadExcepciones.class);

	/**
	 * Metodo que recibe las excepciones y retorna un modelo con la información de
	 * la excepcion.
	 *
	 * @param ae_excepcion excepción generada en el sistema
	 * @param ao_clase     el parametro clase
	 * @param as_lenguaje  lenguaje del cual se va a consultar el mensaje de error
	 * @return Modelo con la excepcion generada
	 */
	public static ExcepcionGenericaDTO manejadorExcepcionesRespuesta(Exception ae_excepcion, Object ao_clase,
			String as_lenguaje) {

		Logger ll_logger = CL_LOGGER;

		if (ao_clase != null) {
			ll_logger = Logger.getLogger(ao_clase.getClass());
		}

		// Valida si son problemas de datos de entrada
		if (ae_excepcion.getCause() instanceof ExcepcionesDatosEntrada
				|| ae_excepcion instanceof ExcepcionesDatosEntrada) {

			ExcepcionesDatosEntrada lede_excepcinoEspecifica = (ExcepcionesDatosEntrada) (ae_excepcion
					.getCause() == null ? ae_excepcion : ae_excepcion.getCause());
			String ls_mensajePropiedades = consultarExcepcion(lede_excepcinoEspecifica.consultarCatalogo(),
					lede_excepcinoEspecifica.consultarMensajeExcepcion(), as_lenguaje,
					EnumTipoExcepciones.VALIDACION_DATOS_ENTRADA);
			ll_logger.error(ls_mensajePropiedades + lede_excepcinoEspecifica.getMessage());

			return crearModelo(lede_excepcinoEspecifica.consultarCodigoExcepcion(), ls_mensajePropiedades,
					EnumTipoExcepciones.VALIDACION_DATOS_ENTRADA.consultarIs_nombre());
		}
		// Valida si son problemas de Excepciones de negocio
		else if (ae_excepcion.getCause() instanceof ExcepcionesNegocio || ae_excepcion instanceof ExcepcionesNegocio) {

			ExcepcionesNegocio le_excepcionEspecifica = (ExcepcionesNegocio) (ae_excepcion.getCause() == null
					? ae_excepcion
					: ae_excepcion.getCause());
			String ls_mensajePropiedades = consultarExcepcion(le_excepcionEspecifica.consultarCatalogo(),
					le_excepcionEspecifica.consultarMensajeExcepcion(), as_lenguaje,
					EnumTipoExcepciones.VALIDACION_NEGOCIO);
			ll_logger.error(ls_mensajePropiedades + le_excepcionEspecifica.getMessage());

			return crearModelo(le_excepcionEspecifica.consultarCodigoExcepcion(), ls_mensajePropiedades,
					EnumTipoExcepciones.VALIDACION_NEGOCIO.consultarIs_nombre());
		}
		// Valida si son problemas de excepciones tecnicas
		else if (ae_excepcion.getCause() instanceof ExcepcionesTecnicas
				|| ae_excepcion instanceof ExcepcionesTecnicas) {

			ExcepcionesTecnicas le_excepcionEspecifica = (ExcepcionesTecnicas) (ae_excepcion.getCause() == null
					? ae_excepcion
					: ae_excepcion.getCause());
			String ls_mensajePropiedades = consultarExcepcion(le_excepcionEspecifica.consultarCatalogo(),
					le_excepcionEspecifica.consultarMensajeExcepcion(), as_lenguaje,
					EnumTipoExcepciones.VALIDACION_TECNICA);
			ll_logger.error(ls_mensajePropiedades + le_excepcionEspecifica.getMessage());

			return crearModelo(le_excepcionEspecifica.consultarCodigoExcepcion(), ls_mensajePropiedades,
					EnumTipoExcepciones.VALIDACION_TECNICA.consultarIs_nombre());
		} else if (ae_excepcion instanceof TransactionRolledbackLocalException) {

			TransactionRolledbackLocalException ltrle_expcepcion = (TransactionRolledbackLocalException) ae_excepcion;
			String ls_mensajePropiedades = manejadorExcepcionPersistenceEjb(
					(PersistenceException) ltrle_expcepcion.getCause(), as_lenguaje);
			ll_logger.error(ls_mensajePropiedades + ae_excepcion.getMessage());
			return crearModelo(EnumExcepcionesGenerales.ERROR_TECNICO.consultarIs_codigo(), ls_mensajePropiedades,
					EnumTipoExcepciones.VALIDACION_NEGOCIO.consultarIs_nombre());

		} else {
			String ls_mensajePropiedades = consultarExcepcion(EnumExcepcionesGenerales.ERROR_TECNICO,
					new String[] { "" }, as_lenguaje, EnumTipoExcepciones.VALIDACION_TECNICA);
			ll_logger.error(ls_mensajePropiedades + ae_excepcion.getMessage());
			return crearModelo(EnumExcepcionesGenerales.ERROR_TECNICO.consultarIs_codigo(), ls_mensajePropiedades,
					EnumTipoExcepciones.VALIDACION_TECNICA.consultarIs_nombre());
		}

	}

	/**
	 * Manejador excepciones respuestas.
	 *
	 * @param ae_excepcion el parametro excepcion
	 * @param ao_clase     el parametro clase
	 * @param as_lenguaje  el parametro lenguaje
	 * @return Resultado para manejador excepciones respuestas retornado como
	 *         ExcepcionGenericaDTO
	 */
	public static ExcepcionGenericaDTO manejadorExcepcionesRespuestas(Exception ae_excepcion, Object ao_clase,
			String as_lenguaje) {

		Logger ll_logger = CL_LOGGER;

		if (ao_clase != null) {
			ll_logger = Logger.getLogger(ao_clase.getClass());
		}
		if (ae_excepcion instanceof EJBTransactionRolledbackException) {

			EJBTransactionRolledbackException letre_expcepcion = (EJBTransactionRolledbackException) ae_excepcion;
			String ls_mensajePropiedades = manejadorExcepcionTransacionesEjb(letre_expcepcion, as_lenguaje);
			ll_logger.error(ls_mensajePropiedades + ae_excepcion.getMessage());
			return crearModelo(EnumExcepcionesGenerales.ERROR_TECNICO.consultarIs_codigo(), ls_mensajePropiedades,
					EnumTipoExcepciones.VALIDACION_TECNICA.consultarIs_nombre());

		} else {
			String ls_mensajePropiedades = consultarExcepcion(EnumExcepcionesGenerales.ERROR_TECNICO,
					new String[] { "" }, as_lenguaje, EnumTipoExcepciones.VALIDACION_TECNICA);
			ll_logger.error(ls_mensajePropiedades + ae_excepcion.getMessage());
			return crearModelo(EnumExcepcionesGenerales.ERROR_TECNICO.consultarIs_codigo(), ls_mensajePropiedades,
					EnumTipoExcepciones.VALIDACION_TECNICA.consultarIs_nombre());
		}
	}

	/**
	 * Manejador excepciones respuesta.
	 *
	 * @param ae_excepcion el parametro excepcion
	 * @param ao_clase     el parametro clase
	 * @return Resultado para manejador excepciones respuesta retornado como
	 *         ExcepcionGenericaDTO
	 */
	public static ExcepcionGenericaDTO manejadorExcepcionesRespuesta(Exception ae_excepcion, Object ao_clase) {
		return manejadorExcepcionesRespuesta(ae_excepcion, ao_clase, LenguajeUtilidad.consultarIdioma());
	}

	/**
	 * Metodo que genera un modelo de datos que contiene propiedades de una
	 * excepcion.
	 *
	 * @param as_codigoExcepcion  condigo de la excepcion generada
	 * @param as_mensajeExcepcion mensaje de la excepcion
	 * @param as_tipoExcepcion    tipo de excepcion
	 * @return modelo de datos de la excepcion
	 */
	private static ExcepcionGenericaDTO crearModelo(String as_codigoExcepcion, String as_mensajeExcepcion,
			String as_tipoExcepcion) {

		ExcepcionGenericaDTO leg_excepcionDto = new ExcepcionGenericaDTO();

		leg_excepcionDto.actualizarCodigoExcepcion(as_codigoExcepcion);
		leg_excepcionDto.actualizarMensajeExcepcion(as_mensajeExcepcion);
		leg_excepcionDto.actualizarTipoExcepcion(as_tipoExcepcion);

		return leg_excepcionDto;
	}

	/**
	 * Metodo que consulta la excepcion al bundle de mensajes internacionalizados.
	 *
	 * @param aiece_catalogo          catalogo que contiene la información del
	 *                                bundle a consultar
	 * @param as_informacionExcepcion Arreglo que contiene información para insertar
	 *                                en el mensaje base existente en el bundle
	 * @param as_idioma               idioma en el que se requiere el mensaje de
	 *                                error
	 * @param aete_excepcionesDefecto Información de la expcepcion en caso que se
	 *                                genere un problema con la lectura del
	 *                                bundleExcepcion por defecto
	 * @return Retorna el mensaje a mostrar al usuario
	 */
	public static String consultarExcepcion(IEnumCatalogoMensajes aiece_catalogo, String[] as_informacionExcepcion,
			String as_idioma, EnumTipoExcepciones aete_excepcionesDefecto) {

		String ls_mensaje = PropiedadesSelector.consultarPropiedades(
				String.format(aiece_catalogo.consultarIs_nombreArchivo(), as_idioma),
				aiece_catalogo.consultarIs_codigo());
		try {
			ls_mensaje = String.format(ls_mensaje, (Object[]) as_informacionExcepcion);
		} catch (MissingFormatArgumentException e) {
			return aete_excepcionesDefecto.consultarIs_detalleNombre();
		}

		return ls_mensaje;
	}

	/**
	 * Metodo que recibe la excepcion de tipo TransactionRolledbackLocalException y
	 * retorna un mensaje segun la violacion de constraint.
	 * 
	 * @param atrle_excepcion excepción generada en el sistema
	 * @param as_idioma       lenguaje del cual se va a consultar el mensaje de
	 *                        error
	 * @return Mensaje con la excepcion generada
	 */
	private static String manejadorExcepcionPersistenceEjb(PersistenceException atrle_excepcion, String as_idioma) {

		String ls_mensaje = consultarExcepcion(EnumExcepcionesGenerales.ERROR_TECNICO, new String[] {}, as_idioma,
				EnumTipoExcepciones.VALIDACION_TECNICA);
		return ls_mensaje;
	}

	/**
	 * Manejador excepcion T client transport ejb.
	 *
	 * @param as_idioma el parametro idioma
	 * @return Resultado para manejador excepcion T client transport ejb retornado
	 *         como String
	 */
	private static String manejadorExcepcionTClientTransportEjb(String as_idioma) {

		String ls_mensaje;
		ls_mensaje = consultarExcepcion(EnumExcepcionesGenerales.DATOS_SOAP_INCORRECTOS, new String[] {}, as_idioma,
				EnumTipoExcepciones.VALIDACION_TECNICA);
		return ls_mensaje;
	}

	/**
	 * Manejador excepcion transaciones ejb.
	 *
	 * @param atre_excepcion el parametro excepcion
	 * @param as_lenguaje    el parametro lenguaje
	 * @return Resultado para manejador excepcion transaciones ejb retornado como
	 *         String
	 */
	private static String manejadorExcepcionTransacionesEjb(EJBTransactionRolledbackException atre_excepcion,
			String as_lenguaje) {

		String ls_mensajePropiedades = consultarExcepcion(EnumExcepcionesGenerales.ERROR_TECNICO, new String[] {},
				as_lenguaje, EnumTipoExcepciones.VALIDACION_TECNICA);
		if (atre_excepcion.getCause() instanceof PersistenceException) {
			ls_mensajePropiedades = manejadorExcepcionPersistenceEjb((PersistenceException) atre_excepcion.getCause(),
					as_lenguaje);
		} else if (atre_excepcion.getCause() instanceof ClientTransportException) {
			ls_mensajePropiedades = manejadorExcepcionTClientTransportEjb(as_lenguaje);
		}
		return ls_mensajePropiedades;
	}

}
