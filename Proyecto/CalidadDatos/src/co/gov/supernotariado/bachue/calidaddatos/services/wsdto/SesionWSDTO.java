/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: SesionWSDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.services.wsdto
 * Nombre del elemento: SesionWSDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.services.wsdto;

import co.gov.supernotariado.bachue.calidaddatos.dto.GenericoDTO;

/**
 * Clase tipo objeto de transferencia de datos para web service (WSDTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y servicios web.
 * <br>
 * Contiene propiedades para representar los datos del objeto Sesion.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class SesionWSDTO extends GenericoDTO {

	
	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * codigo.
	 */
	private String is_codigo;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * mensaje.
	 */
    private String is_mensaje;
    
    /**
	 * Atributo de instancia tipo verdadero/falso para definir la propiedad
	 * resultado.
	 */
    private Boolean ib_resultado;
    
    /**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * sesion.
	 */
    private String is_sesion;
    
    
	/**
	 * Obtiene el valor para la propiedad codigo.
	 *
	 * @return El valor de la propiedad codigo
	 */
	public String getIs_codigo() {
		return is_codigo;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad codigo.
	 *
	 * @param as_codigo el nuevo valor para la propiedad codigo
	 */
	public void setIs_codigo(String as_codigo) {
		this.is_codigo = as_codigo;
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
	 * Cambia/actualiza el valor para la propiedad mensaje.
	 *
	 * @param as_mensaje el nuevo valor para la propiedad mensaje
	 */
	public void setIs_mensaje(String as_mensaje) {
		this.is_mensaje = as_mensaje;
	}
	
	/**
	 * Obtiene el valor para la propiedad resultado.
	 *
	 * @return El valor de la propiedad resultado
	 */
	public Boolean getIb_resultado() {
		return ib_resultado;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad resultado.
	 *
	 * @param ab_resultado el nuevo valor para la propiedad resultado
	 */
	public void setIb_resultado(Boolean ab_resultado) {
		this.ib_resultado = ab_resultado;
	}
	
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
