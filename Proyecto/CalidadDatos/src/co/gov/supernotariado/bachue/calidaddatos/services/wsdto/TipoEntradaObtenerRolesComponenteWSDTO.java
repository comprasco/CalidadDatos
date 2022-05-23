/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: TipoEntradaObtenerRolesComponenteWSDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.services.wsdto
 * Nombre del elemento: TipoEntradaObtenerRolesComponenteWSDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.services.wsdto;

import co.gov.supernotariado.bachue.calidaddatos.dto.GenericoDTO;

/**
 * Clase tipo objeto de transferencia de datos para web service (WSDTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y servicios web.
 * <br>
 * Contiene propiedades para representar los datos del objeto Tipo entrada
 * obtener roles componente.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class TipoEntradaObtenerRolesComponenteWSDTO extends GenericoDTO {

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * login usuario.
	 */
	private String is_loginUsuario;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * componente.
	 */
	private String is_componente;


	/**
	 * Obtiene el valor para la propiedad login usuario.
	 *
	 * @return El valor de la propiedad login usuario
	 */
	public String getIs_loginUsuario() {
		return is_loginUsuario;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad login usuario.
	 *
	 * @param as_loginUsuario el nuevo valor para la propiedad login usuario
	 */
	public void setIs_loginUsuario(String as_loginUsuario) {
		this.is_loginUsuario = as_loginUsuario;
	}
	
	/**
	 * Obtiene el valor para la propiedad componente.
	 *
	 * @return El valor de la propiedad componente
	 */
	public String getIs_componente() {
		return is_componente;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad componente.
	 *
	 * @param as_componente el nuevo valor para la propiedad componente
	 */
	public void setIs_componente(String as_componente) {
		this.is_componente = as_componente;
	}
}
