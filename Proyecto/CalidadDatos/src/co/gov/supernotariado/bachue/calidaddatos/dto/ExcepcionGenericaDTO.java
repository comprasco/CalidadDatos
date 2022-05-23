/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ExcepcionGenericaDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.dto
 * Nombre del elemento: ExcepcionGenericaDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.dto;

import java.io.Serializable;

import co.gov.supernotariado.bachue.calidaddatos.enums.EnumTipoExcepciones;

/**
 * Clase tipo objeto de transferencia de datos (DTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y presentacion.
 * <br>
 * Contiene propiedades para representar los datos del objeto Excepcion
 * generica.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class ExcepcionGenericaDTO  implements Serializable {

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * tipo excepcion.
	 */
	protected String is_tipoExcepcion;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * mensaje excepcion.
	 */
	protected String is_mensajeExcepcion;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * codigo excepcion.
	 */
	protected String is_codigoExcepcion;

	/**
	 * Construye una nueva instancia/objeto de la clase ExcepcionGenericaDTO.
	 */
	public ExcepcionGenericaDTO() {
		// Constructor vacio para serializacion
	}
	
	/**
	 * Construye una nueva instancia/objeto de la clase ExcepcionGenericaDTO.
	 *
	 * @param aete_tipoExcepcion el parametro tipo excepcion
	 */
	public ExcepcionGenericaDTO(EnumTipoExcepciones aete_tipoExcepcion) {
		super();
		this.is_tipoExcepcion = aete_tipoExcepcion.consultarIs_detalleNombre();
		this.is_mensajeExcepcion = is_mensajeExcepcion != null ? is_mensajeExcepcion
				: aete_tipoExcepcion.consultarIs_detalleNombre();
	}
	
	/**
	 * Construye una nueva instancia/objeto de la clase ExcepcionGenericaDTO.
	 *
	 * @param aete_tipoExcepcion  el parametro tipo excepcion
	 * @param as_mensajeExcepcion el parametro mensaje excepcion
	 */
	public ExcepcionGenericaDTO(EnumTipoExcepciones aete_tipoExcepcion, String as_mensajeExcepcion) {
		super();
		this.is_tipoExcepcion = aete_tipoExcepcion.consultarIs_detalleNombre();
		this.is_mensajeExcepcion = as_mensajeExcepcion;
	}
	
	/**
	 * Construye una nueva instancia/objeto de la clase ExcepcionGenericaDTO.
	 *
	 * @param aete_tipoExcepcion  el parametro tipo excepcion
	 * @param as_mensajeExcepcion el parametro mensaje excepcion
	 * @param as_codigoExcepcion  el parametro codigo excepcion
	 */
	public ExcepcionGenericaDTO(EnumTipoExcepciones aete_tipoExcepcion, String as_mensajeExcepcion,
			String as_codigoExcepcion) {
		super();
		this.is_tipoExcepcion = aete_tipoExcepcion.consultarIs_detalleNombre();
		this.is_mensajeExcepcion = as_mensajeExcepcion != null ? as_mensajeExcepcion
				: aete_tipoExcepcion.consultarIs_detalleNombre();
		this.is_codigoExcepcion = as_codigoExcepcion;
	}
	
	/**
	 * Consultar tipo excepcion.
	 *
	 * @return Resultado para consultar tipo excepcion retornado como String
	 */
	// --- Getters-Setters
	public String consultarTipoExcepcion() {
		return is_tipoExcepcion;
	}

	/**
	 * Actualizar tipo excepcion.
	 *
	 * @param aeet_tipoExcepcion el parametro tipo excepcion
	 */
	public void actualizarTipoExcepcion(String aeet_tipoExcepcion) {
		this.is_tipoExcepcion = aeet_tipoExcepcion;
	}

	/**
	 * Consultar mensaje excepcion.
	 *
	 * @return Resultado para consultar mensaje excepcion retornado como String
	 */
	public String consultarMensajeExcepcion() {
		return is_mensajeExcepcion;
	}

	/**
	 * Actualizar mensaje excepcion.
	 *
	 * @param as_mensajeExcepcion el parametro mensaje excepcion
	 */
	public void actualizarMensajeExcepcion(String as_mensajeExcepcion) {
		this.is_mensajeExcepcion = as_mensajeExcepcion;
	}

	/**
	 * Consultar codigo excepcion.
	 *
	 * @return Resultado para consultar codigo excepcion retornado como String
	 */
	public String consultarCodigoExcepcion() {
		return is_codigoExcepcion;
	}

	/**
	 * Actualizar codigo excepcion.
	 *
	 * @param as_codigoExcepcion el parametro codigo excepcion
	 */
	public void actualizarCodigoExcepcion(String as_codigoExcepcion) {
		this.is_codigoExcepcion = as_codigoExcepcion;
	}

}
