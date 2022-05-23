/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: LenguajeUtilidad.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.utilidades
 * Nombre del elemento: LenguajeUtilidad
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.utilidades;

import java.util.MissingFormatArgumentException;

import co.gov.supernotariado.bachue.calidaddatos.LenguajeSelector.LenguajeSelector;
import co.gov.supernotariado.bachue.calidaddatos.LenguajeSelector.PropiedadesSelector;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumTipoExcepciones;
import co.gov.supernotariado.bachue.calidaddatos.exception.IEnumCatalogoMensajes;


/**
 * El elemento Class LenguajeUtilidad.<br>
 * Representa un/una lenguaje utilidad.<br>
 * Clase con utilidades para consultar el idioma
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class LenguajeUtilidad {
	
	/**
	 * Construye una nueva instancia/objeto de la clase LenguajeUtilidad.
	 */
	private LenguajeUtilidad() {}

	/**
	 * Metodo que entrega idioma configurado.
	 *
	 * @return Codigo del idioma
	 */
	public static String consultarIdioma() {
		LenguajeSelector lls_lenguaje = new LenguajeSelector();			
		String ls_idioma;
		ls_idioma = lls_lenguaje.getLocale().toString();
		return ls_idioma;
	}

	/**
	 * Metodo que permite consultar los properties mensajes internacionalizados.
	 *
	 * @param aiece_iEnumCatalogoMensaje catalogo de de excepciones
	 * @param as_informacionExcepcion    informacion extra de mensaje
	 * @param aete_enumTipoExcepciones   excepcion por defecto
	 * @return Mensaje internacionalizado
	 */
	public static String consultarMensaje(IEnumCatalogoMensajes aiece_iEnumCatalogoMensaje, String[] as_informacionExcepcion, EnumTipoExcepciones aete_enumTipoExcepciones) {

		String ls_mensaje = PropiedadesSelector.consultarPropiedades(String.format(aiece_iEnumCatalogoMensaje.consultarIs_nombreArchivo(), consultarIdioma()) , aiece_iEnumCatalogoMensaje.consultarIs_codigo());

		try {
			ls_mensaje = String.format(ls_mensaje, (Object[]) as_informacionExcepcion);
		} catch (MissingFormatArgumentException amgae_excepcion) {
			return aete_enumTipoExcepciones.consultarIs_detalleNombre();
		}

		return ls_mensaje;
	}

	/**
	 * Metodo que permite consultar los properties mensajes internacionalizados.
	 *
	 * @param aiece_catalogo          catalogo de de excepciones
	 * @param aete_excepcionesDefecto excepcion por defecto
	 * @return Mensaje internacionalizado
	 */
	public static String consultarMensaje(IEnumCatalogoMensajes aiece_catalogo, EnumTipoExcepciones aete_excepcionesDefecto) {
		return consultarMensaje(aiece_catalogo, aete_excepcionesDefecto);
	}
	
	/**
	 * Metodo que permite consultar los properties mensajes internacionalizados.
	 *
	 * @param aiece_catalogo catalogo de de excepciones
	 * @return Mensaje internacionalizado
	 */
	public static String consultarMensaje(IEnumCatalogoMensajes aiece_catalogo) {
		return consultarMensaje(aiece_catalogo,EnumTipoExcepciones.VALIDACION_NEGOCIO);
	}



}
