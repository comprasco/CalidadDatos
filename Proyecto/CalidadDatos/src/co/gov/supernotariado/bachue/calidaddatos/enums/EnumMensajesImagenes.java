/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: EnumMensajesImagenes.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.enums
 * Nombre del elemento: EnumMensajesImagenes
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.enums;

/**
 * Enumeracion para definir el grupo de constantes para Mensajes imagenes. <br>
 * Enum que implemtado para mostrar los mensajes de resultado de calidad.
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public enum EnumMensajesImagenes {

	/**
	 * Constante de la enumeracion para definir el item: MENSAJE_MATRICULA_ENCOLADA.
	 */
	MENSAJE_MATRICULA_ENCOLADA(
			"Las inconsistencias de la matricula se encuentran en proceso, podra consultar el resultado mas tarde",
			"images/resultado.png"),

	/**
	 * Constante de la enumeracion para definir el item:
	 * MENSAJE_MATRICULA_ENCOLADA_SIN_PROCESAR.
	 */
	MENSAJE_MATRICULA_ENCOLADA_SIN_PROCESAR(
			"La matricula aun se encuentra esperando para ser procesada, en el transcurso del dia podra consultar el resultado de su matricula inconsistente.\n",
			"images/advertencia.png");

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * mensaje.
	 */
	private String is_mensaje;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * imagen.
	 */
	private String is_imagen;

	/**
	 * Construye una nueva instancia/objeto de la clase EnumMensajesImagenes.
	 *
	 * @param as_mensaje el parametro mensaje
	 * @param as_imagen  el parametro imagen
	 */
	private EnumMensajesImagenes(final String as_mensaje, final String as_imagen) {
		this.is_mensaje = as_mensaje;
		this.is_imagen = as_imagen;
	}

	/**
	 * Obtiene el valor para la propiedad mensaje.
	 *
	 * @return El valor de la propiedad mensaje
	 */
	public String getIs_mensaje() {
		return is_mensaje;
	}


	/**
	 * Obtiene el valor para la propiedad imagen.
	 *
	 * @return El valor de la propiedad imagen
	 */
	public String getIs_imagen() {
		return is_imagen;
	}


}
