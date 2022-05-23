/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ServicioIntegracionDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.dto
 * Nombre del elemento: ServicioIntegracionDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.dto;

/**
 * Clase tipo objeto de transferencia de datos (DTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y presentacion.
 * <br>
 * Contiene propiedades para representar los datos del objeto Servicio
 * integracion.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class ServicioIntegracionDTO extends GenericoBaseDTO {

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	// --- Atributos
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * descripcion.
	 */
	private String is_descripcion;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * espacio nombre.
	 */
	private String is_espacioNombre;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * nombre.
	 */
	private String is_nombre;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * url.
	 */
	private String is_url;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * tiempo fuera.
	 */
	private String is_tiempoFuera;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * nombre servicio.
	 */
	private String is_nombreServicio;


	/**
	 * Construye una nueva instancia/objeto de la clase ServicioIntegracionDTO.
	 */
	public ServicioIntegracionDTO() {
		// Metodo constructor vacio para modelo DTO
	}
	
	/**
	 * Obtiene el valor para la propiedad descripcion.
	 *
	 * @return El valor de la propiedad descripcion
	 */
	// --- Getters-Setters
	public String getIs_descripcion() {
		return this.is_descripcion;
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
	 * Obtiene el valor para la propiedad espacio nombre.
	 *
	 * @return El valor de la propiedad espacio nombre
	 */
	public String getIs_espacioNombre() {
		return this.is_espacioNombre;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad espacio nombre.
	 *
	 * @param as_espacioNombre el nuevo valor para la propiedad espacio nombre
	 */
	public void setIs_espacioNombre(String as_espacioNombre) {
		this.is_espacioNombre = as_espacioNombre;
	}

	/**
	 * Obtiene el valor para la propiedad nombre.
	 *
	 * @return El valor de la propiedad nombre
	 */
	public String getIs_nombre() {
		return this.is_nombre;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad nombre.
	 *
	 * @param as_nombre el nuevo valor para la propiedad nombre
	 */
	public void setIs_nombre(String as_nombre) {
		this.is_nombre = as_nombre;
	}

	/**
	 * Obtiene el valor para la propiedad url.
	 *
	 * @return El valor de la propiedad url
	 */
	public String getIs_url() {
		return this.is_url;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad url.
	 *
	 * @param as_url el nuevo valor para la propiedad url
	 */
	public void setIs_url(String as_url) {
		this.is_url = as_url;
	}

	/**
	 * Obtiene el valor para la propiedad tiempo fuera.
	 *
	 * @return El valor de la propiedad tiempo fuera
	 */
	public String getIs_tiempoFuera() {
		return is_tiempoFuera;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad tiempo fuera.
	 *
	 * @param as_tiempoFuera el nuevo valor para la propiedad tiempo fuera
	 */
	public void setIs_tiempoFuera(String as_tiempoFuera) {
		this.is_tiempoFuera = as_tiempoFuera;
	}

	/**
	 * Obtiene el valor para la propiedad nombre servicio.
	 *
	 * @return El valor de la propiedad nombre servicio
	 */
	public String getIs_nombreServicio() {
		return is_nombreServicio;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad nombre servicio.
	 *
	 * @param as_nombreServicio el nuevo valor para la propiedad nombre servicio
	 */
	public void setIs_nombreServicio(String as_nombreServicio) {
		this.is_nombreServicio = as_nombreServicio;
	}
	
	
}
