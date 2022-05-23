/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: EnumExcepcionesServicios.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.enums
 * Nombre del elemento: EnumExcepcionesServicios
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.enums;

import java.io.Serializable;

import co.gov.supernotariado.bachue.calidaddatos.exception.IEnumCatalogoMensajes;

/**
 * Enumeracion para definir el grupo de constantes para Excepciones servicios.
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public enum EnumExcepcionesServicios implements IEnumCatalogoMensajes, Serializable {

	/**
	 * Constante de la enumeracion para definir el item: PROBLEMA_SERVICIO.
	 */
	// Enum que aloja nombre del archivo que contiene las propiedades y un codigo
	// que representa el error existente
	PROBLEMA_SERVICIO("error.fallo"),

	/**
	 * Constante de la enumeracion para definir el item: PROBLEMA_RESPUESTA_NULA.
	 */
	PROBLEMA_RESPUESTA_NULA("error.respuesta.nula"),

	/**
	 * Constante de la enumeracion para definir el item: PROBLEMA_NO_INFO.
	 */
	PROBLEMA_NO_INFO("error.no.info");

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * codigo error.
	 */
	private final String is_codigoError;

	/**
	 * Define la constante NOMBRE_BUNDLE.
	 */
	public static final String NOMBRE_BUNDLE = "excepciones.excepcion_servicios_%s";

	/**
	 * Construye una nueva instancia/objeto de la clase EnumExcepcionesServicios.
	 *
	 * @param as_codigoError el parametro codigo error
	 */
	private EnumExcepcionesServicios(String as_codigoError) {
		this.is_codigoError = as_codigoError;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.gov.supernotariado.bachue.calidaddatos.exception.IEnumCatalogoMensajes#
	 * consultarIs_nombreArchivo()
	 */
	public String consultarIs_nombreArchivo() {
		return NOMBRE_BUNDLE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.gov.supernotariado.bachue.calidaddatos.exception.IEnumCatalogoMensajes#
	 * consultarIs_codigo()
	 */
	public String consultarIs_codigo() {
		return is_codigoError;
	}

}
