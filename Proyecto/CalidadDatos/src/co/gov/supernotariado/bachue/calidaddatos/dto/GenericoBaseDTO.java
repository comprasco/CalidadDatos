/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: GenericoBaseDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.dto
 * Nombre del elemento: GenericoBaseDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.dto;

import java.util.Date;

import co.gov.supernotariado.bachue.calidaddatos.dto.interfaces.IAuditableDTO;

/**
 * Clase tipo objeto de transferencia de datos (DTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y presentacion.
 * <br>
 * Contiene propiedades para representar los datos del objeto Generico base.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class GenericoBaseDTO extends GenericoDTO implements IAuditableDTO {

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	// --- Atributos
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad id.
	 */
	private String is_id;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * activo.
	 */
	private String is_activo;
	
	/**
	 * Atributo de instancia tipo fecha para definir la propiedad fecha
	 * modificacion.
	 */
	private Date id_fechaModificacion;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad ip
	 * modificacion.
	 */
	private String is_ipModificacion;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad id
	 * usuario modificacion.
	 */
	private String is_idUsuarioModificacion;
	
	/**
	 * Atributo de instancia tipo fecha para definir la propiedad fecha creacion.
	 */
	private Date id_fechaCreacion;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad ip
	 * creacion.
	 */
	private String is_ipCreacion;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad id
	 * usuario creacion.
	 */
	private String is_idUsuarioCreacion;
	
	/**
	 * Obtiene el valor para la propiedad id.
	 *
	 * @return El valor de la propiedad id
	 */
	// --- Getters-Setters
	public String getIs_id() {
		return is_id;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad id.
	 *
	 * @param as_id el nuevo valor para la propiedad id
	 */
	public void setIs_id(String as_id) {
		this.is_id = as_id;
	}

	/**
	 * Obtiene el valor para la propiedad activo.
	 *
	 * @return El valor de la propiedad activo
	 */
	public String getIs_activo() {
		return is_activo;
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.dto.interfaces.IAuditableDTO#setIs_activo(java.lang.String)
	 */
	public void setIs_activo(String as_activo) {
		this.is_activo = as_activo;
	}

	/**
	 * Obtiene el valor para la propiedad fecha modificacion.
	 *
	 * @return El valor de la propiedad fecha modificacion
	 */
	public Date getId_fechaModificacion() {
		return id_fechaModificacion;
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.dto.interfaces.IAuditableDTO#setId_fechaModificacion(java.util.Date)
	 */
	@Override
	public void setId_fechaModificacion(Date ad_fechaModificacion) {
		this.id_fechaModificacion = ad_fechaModificacion;
	}

	/**
	 * Obtiene el valor para la propiedad ip modificacion.
	 *
	 * @return El valor de la propiedad ip modificacion
	 */
	public String getIs_ipModificacion() {
		return is_ipModificacion;
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.dto.interfaces.IAuditableDTO#setIs_ipModificacion(java.lang.String)
	 */
	@Override
	public void setIs_ipModificacion(String as_ipModificacion) {
		this.is_ipModificacion = as_ipModificacion;
	}

	/**
	 * Obtiene el valor para la propiedad id usuario modificacion.
	 *
	 * @return El valor de la propiedad id usuario modificacion
	 */
	public String getIs_idUsuarioModificacion() {
		return is_idUsuarioModificacion;
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.dto.interfaces.IAuditableDTO#setIs_idUsuarioModificacion(java.lang.String)
	 */
	@Override
	public void setIs_idUsuarioModificacion(String as_idUsuarioModificacion) {
		this.is_idUsuarioModificacion = as_idUsuarioModificacion;
	}

	
	/**
	 * Obtiene el valor para la propiedad fecha creacion.
	 *
	 * @return El valor de la propiedad fecha creacion
	 */
	public Date getId_fechaCreacion() {
		return id_fechaCreacion;
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.dto.interfaces.IAuditableDTO#setId_fechaCreacion(java.util.Date)
	 */
	@Override
	public void setId_fechaCreacion(Date ad_fechaCreacion) {
		this.id_fechaCreacion = ad_fechaCreacion;
	}

	/**
	 * Obtiene el valor para la propiedad ip creacion.
	 *
	 * @return El valor de la propiedad ip creacion
	 */
	public String getIs_ipCreacion() {
		return is_ipCreacion;
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.dto.interfaces.IAuditableDTO#setIs_ipCreacion(java.lang.String)
	 */
	@Override
	public void setIs_ipCreacion(String as_ipCreacion) {
		this.is_ipCreacion = as_ipCreacion;
	}

	/**
	 * Obtiene el valor para la propiedad id usuario creacion.
	 *
	 * @return El valor de la propiedad id usuario creacion
	 */
	public String getIs_idUsuarioCreacion() {
		return is_idUsuarioCreacion;
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.dto.interfaces.IAuditableDTO#setIs_idUsuarioCreacion(java.lang.String)
	 */
	@Override
	public void setIs_idUsuarioCreacion(String as_idUsuarioCreacion) {
		this.is_idUsuarioCreacion = as_idUsuarioCreacion;
	}


}
