/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ServicioIntegracionBooleanoDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.dto
 * Nombre del elemento: ServicioIntegracionBooleanoDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.dto;

/**
 * Clase tipo objeto de transferencia de datos (DTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y presentacion.
 * <br>
 * Contiene propiedades para representar los datos del objeto Servicio
 * integracion booleano.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class ServicioIntegracionBooleanoDTO extends ServicioIntegracionDTO {

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	// --- Atributos
	/**
	 * Atributo de instancia tipo verdadero/falso para definir la propiedad activo.
	 */
	private Boolean ib_activo;

	/**
	 * Construye una nueva instancia/objeto de la clase
	 * ServicioIntegracionBooleanoDTO.
	 */
	// --- Constructor
	public ServicioIntegracionBooleanoDTO() {
		 //--- Metodo constructor vacio para modelo DTO
	}

	/**
	 * Construye una nueva instancia/objeto de la clase
	 * ServicioIntegracionBooleanoDTO.
	 *
	 * @param asi_servicioIntegracionDto el parametro servicio integracion dto
	 */
	public ServicioIntegracionBooleanoDTO(ServicioIntegracionDTO asi_servicioIntegracionDto) {
		setIs_id(asi_servicioIntegracionDto.getIs_id());
		setIs_activo(asi_servicioIntegracionDto.getIs_activo());
		setIs_descripcion(asi_servicioIntegracionDto.getIs_descripcion());
		setIs_espacioNombre(asi_servicioIntegracionDto.getIs_espacioNombre());
		setId_fechaCreacion(asi_servicioIntegracionDto.getId_fechaCreacion());
		setId_fechaModificacion(asi_servicioIntegracionDto.getId_fechaModificacion());
		setIs_idUsuarioCreacion(asi_servicioIntegracionDto.getIs_idUsuarioCreacion());
		setIs_idUsuarioModificacion(asi_servicioIntegracionDto.getIs_idUsuarioModificacion());
		setIs_ipCreacion(asi_servicioIntegracionDto.getIs_ipCreacion());
		setIs_ipModificacion(asi_servicioIntegracionDto.getIs_ipModificacion());
		setIs_nombre(asi_servicioIntegracionDto.getIs_nombre());
		setIs_url(asi_servicioIntegracionDto.getIs_url());
		setIs_tiempoFuera(asi_servicioIntegracionDto.getIs_tiempoFuera());
		setIs_nombreServicio(asi_servicioIntegracionDto.getIs_nombreServicio());
	}

	// --- Getters-Setters

	/**
	 * Obtiene el valor para la propiedad activo.
	 *
	 * @return El valor de la propiedad activo
	 */
	public Boolean getIb_activo() {
		return ib_activo;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad activo.
	 *
	 * @param ab_activo el nuevo valor para la propiedad activo
	 */
	public void setIb_activo(Boolean ab_activo) {
		this.ib_activo = ab_activo;
	}

}
