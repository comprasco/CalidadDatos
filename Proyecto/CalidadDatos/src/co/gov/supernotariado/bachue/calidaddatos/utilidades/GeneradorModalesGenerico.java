/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: GeneradorModalesGenerico.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.utilidades
 * Nombre del elemento: GeneradorModalesGenerico
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.utilidades;

import org.primefaces.PrimeFaces;

import co.gov.supernotariado.bachue.calidaddatos.enums.EnumTipoExcepciones;
import co.gov.supernotariado.bachue.calidaddatos.exception.IEnumCatalogoMensajes;

/**
 * El elemento Class GeneradorModalesGenerico.<br>
 * Representa un/una generador modales generico.<br>
 * Clase que permite generar modals genéricos a partir de un mensaje
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class GeneradorModalesGenerico {

	/**
	 * Construye una nueva instancia/objeto de la clase GeneradorModalesGenerico.
	 */
	private GeneradorModalesGenerico() {
		// contructor vacion de modelo
	}

	/**
	 * Metodo que genera modal sencilla.
	 *
	 * @param as_mensaje el parametro mensaje
	 */
	public static void generarModalSencilla(String as_mensaje) {
		PrimeFaces lpf_current = PrimeFaces.current();
		lpf_current.executeScript(
				"PF('dlgExcepcionBase').show();document.getElementById('formModalBase:msgValidacion').innerText = '"
						+ as_mensaje + "' ");

	}

	/**
	 * Metodo para generar mensaje exitoso.
	 *
	 * @param aiecm_catalogoMensaje enum con mensaje internacionalizado
	 */
	public static void generarModalSencilla(IEnumCatalogoMensajes aiecm_catalogoMensaje) {
		String ls_mensaje = LenguajeUtilidad.consultarMensaje(aiecm_catalogoMensaje,
				EnumTipoExcepciones.VALIDACION_DATOS_ENTRADA);
		PrimeFaces lpf_current = PrimeFaces.current();
		lpf_current.executeScript(
				"PF('dlgExcepcionBase').show();document.getElementById('formModalBase:msgValidacion').innerText = '"
						+ ls_mensaje + "' ");
	}

	/**
	 * Metodo que genera el modal doble.
	 *
	 * @param as_mensaje el parametro mensaje
	 */
	public static void generarModalDoble(String as_mensaje) {
		PrimeFaces lpf_current = PrimeFaces.current();
		lpf_current.executeScript(
				"PF('dlgExcepcionBaseDoble').show();document.getElementById('formModalBaseDoble:msgValidacionDoble').innerText = '"
						+ as_mensaje + "' ");

	}

}
