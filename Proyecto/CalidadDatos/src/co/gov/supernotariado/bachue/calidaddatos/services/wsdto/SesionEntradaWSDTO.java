/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: SesionEntradaWSDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.services.wsdto
 * Nombre del elemento: SesionEntradaWSDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.services.wsdto;

import co.gov.supernotariado.bachue.calidaddatos.dto.GenericoDTO;

/**
 * Clase tipo objeto de transferencia de datos para web service (WSDTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y servicios web.
 * <br>
 * Contiene propiedades para representar los datos del objeto Sesion entrada.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class SesionEntradaWSDTO  extends GenericoDTO{

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
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

