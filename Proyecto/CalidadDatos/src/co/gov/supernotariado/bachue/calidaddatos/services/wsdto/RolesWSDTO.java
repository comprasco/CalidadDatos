/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: RolesWSDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.services.wsdto
 * Nombre del elemento: RolesWSDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.services.wsdto;

import co.gov.supernotariado.bachue.calidaddatos.dto.GenericoDTO;

/**
 * Clase tipo objeto de transferencia de datos para web service (WSDTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y servicios web.
 * <br>
 * Contiene propiedades para representar los datos del objeto Roles.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class RolesWSDTO extends GenericoDTO{

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * codigo rol.
	 */
	private String is_codigoRol;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * nombre rol.
	 */
	private String is_nombreRol;

	/**
	 * Obtiene el valor para la propiedad codigo rol.
	 *
	 * @return El valor de la propiedad codigo rol
	 */
	public String getIs_codigoRol() {
		return is_codigoRol;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad codigo rol.
	 *
	 * @param as_codigoRol el nuevo valor para la propiedad codigo rol
	 */
	public void setIs_codigoRol(String as_codigoRol) {
		this.is_codigoRol = as_codigoRol;
	}
	
	/**
	 * Obtiene el valor para la propiedad nombre rol.
	 *
	 * @return El valor de la propiedad nombre rol
	 */
	public String getIs_nombreRol() {
		return is_nombreRol;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad nombre rol.
	 *
	 * @param as_nombreRol el nuevo valor para la propiedad nombre rol
	 */
	public void setIs_nombreRol(String as_nombreRol) {
		this.is_nombreRol = as_nombreRol;
	}
}
