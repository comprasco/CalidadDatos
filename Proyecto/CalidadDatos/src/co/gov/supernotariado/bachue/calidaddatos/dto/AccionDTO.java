/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: AccionDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.dto
 * Nombre del elemento: AccionDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.dto;

/**
 * Clase tipo objeto de transferencia de datos (DTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y presentacion.
 * <br>
 * Contiene propiedades para representar los datos del objeto Accion.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class AccionDTO extends GenericoBaseDTO {
	
	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * descripcion.
	 */
	private String is_descripcion;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * valor.
	 */
	private String is_valor;

	/**
	 * Construye una nueva instancia/objeto de la clase AccionDTO.
	 */
	// --- Constructor
	public AccionDTO() {
		// Metodo constructor vacio para modelo DTO
	}

	// --- Getters-Setters

	/**
	 * Obtiene el valor para la propiedad descripcion.
	 *
	 * @return El valor de la propiedad descripcion
	 */
	public String getIs_descripcion() {
		return is_descripcion;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad descripcion.
	 *
	 * @param as_descripcion el nuevo valor para la propiedad descripcion
	 */
	public void setIs_descripcion(String as_descripcion) {
		this.is_descripcion = as_descripcion;
	}

	/**
	 * Obtiene el valor para la propiedad valor.
	 *
	 * @return El valor de la propiedad valor
	 */
	public String getIs_valor() {
		return is_valor;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad valor.
	 *
	 * @param as_valor el nuevo valor para la propiedad valor
	 */
	public void setIs_valor(String as_valor) {
		this.is_valor = as_valor;
	}

		
}
