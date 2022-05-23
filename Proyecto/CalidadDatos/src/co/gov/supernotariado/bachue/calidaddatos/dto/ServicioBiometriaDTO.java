/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ServicioBiometriaDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.dto
 * Nombre del elemento: ServicioBiometriaDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.dto;

import java.io.Serializable;

/**
 * Clase tipo objeto de transferencia de datos (DTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y presentacion.
 * <br>
 * Contiene propiedades para representar los datos del objeto Servicio
 * biometria.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class ServicioBiometriaDTO implements Serializable
{
	
	/**
	 * Define la constante serialVersionUID.
	 */
	// --- Atributos
	private static final long serialVersionUID = 9071114478560854720L;	
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * sesion.
	 */
	private String is_sesion;
	
	/**
	 * Obtiene el valor para la propiedad sesion.
	 *
	 * @return El valor de la propiedad sesion
	 */
	// --- Getters-Setters
	public String getIs_sesion() {
		return is_sesion;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad sesion.
	 *
	 * @param as_sesion el nuevo valor para la propiedad sesion
	 */
	public void setIs_sesion(String as_sesion) {
		this.is_sesion = as_sesion;
	}
}