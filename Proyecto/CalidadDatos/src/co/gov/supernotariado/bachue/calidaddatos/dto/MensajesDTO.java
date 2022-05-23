/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: MensajesDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.dto
 * Nombre del elemento: MensajesDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.dto;

import java.io.Serializable;

import co.gov.supernotariado.bachue.calidaddatos.enums.EnumMensajesImagenes;

/**
 * Clase tipo objeto de transferencia de datos (DTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y presentacion.
 * <br>
 * Contiene propiedades para representar los datos del objeto Mensajes.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class MensajesDTO implements Serializable{
	
	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	// --- Atributos
	/**
	 * Constante de la enumeracion para definir el item: mensaje.
	 */
	private EnumMensajesImagenes mensaje;
	
	/**
	 * Obtiene el valor para la propiedad mensaje.
	 *
	 * @return El valor de la propiedad mensaje
	 */
	// --- Getters-Setters
	public EnumMensajesImagenes getMensaje() {
		return mensaje;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad mensaje.
	 *
	 * @param mensaje el nuevo valor para la propiedad mensaje
	 */
	public void setMensaje(final EnumMensajesImagenes mensaje) {
		this.mensaje = mensaje;
	}
}
