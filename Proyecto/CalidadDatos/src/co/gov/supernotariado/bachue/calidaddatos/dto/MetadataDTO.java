/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: MetadataDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.dto
 * Nombre del elemento: MetadataDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.dto;

import java.io.Serializable;

/**
 * Clase tipo objeto de transferencia de datos (DTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y presentacion.
 * <br>
 * Contiene propiedades para representar los datos del objeto Metadata.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class MetadataDTO implements Serializable{


	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 3980434679425048883L;
	// --- Atributos
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * nombre tabla.
	 */
	private String is_nombreTabla;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * nombre columna.
	 */
	private String is_nombreColumna;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * tipo dato.
	 */
	private String is_tipoDato;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * largo campo.
	 */
	private String is_largoCampo;
	
	/**
	 * Obtiene el valor para la propiedad nombre tabla.
	 *
	 * @return El valor de la propiedad nombre tabla
	 */
	// --- Getters-Setters
	public String getIs_nombreTabla() {
		return is_nombreTabla;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad nombre tabla.
	 *
	 * @param as_nombreTabla el nuevo valor para la propiedad nombre tabla
	 */
	public void setIs_nombreTabla(String as_nombreTabla) {
		this.is_nombreTabla = as_nombreTabla;
	}
	
	/**
	 * Obtiene el valor para la propiedad nombre columna.
	 *
	 * @return El valor de la propiedad nombre columna
	 */
	public String getIs_nombreColumna() {
		return is_nombreColumna;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad nombre columna.
	 *
	 * @param as_nombreColumna el nuevo valor para la propiedad nombre columna
	 */
	public void setIs_nombreColumna(String as_nombreColumna) {
		this.is_nombreColumna = as_nombreColumna;
	}
	
	/**
	 * Obtiene el valor para la propiedad tipo dato.
	 *
	 * @return El valor de la propiedad tipo dato
	 */
	public String getIs_tipoDato() {
		return is_tipoDato;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad tipo dato.
	 *
	 * @param as_tipoDato el nuevo valor para la propiedad tipo dato
	 */
	public void setIs_tipoDato(String as_tipoDato) {
		this.is_tipoDato = as_tipoDato;
	}
	
	/**
	 * Obtiene el valor para la propiedad largo campo.
	 *
	 * @return El valor de la propiedad largo campo
	 */
	public String getIs_largoCampo() {
		return is_largoCampo;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad largo campo.
	 *
	 * @param as_largoCampo el nuevo valor para la propiedad largo campo
	 */
	public void setIs_largoCampo(String as_largoCampo) {
		this.is_largoCampo = as_largoCampo;
	}
    
}
