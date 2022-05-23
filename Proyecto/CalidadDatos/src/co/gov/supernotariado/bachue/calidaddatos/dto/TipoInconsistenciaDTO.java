/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: TipoInconsistenciaDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.dto
 * Nombre del elemento: TipoInconsistenciaDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase tipo objeto de transferencia de datos (DTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y presentacion.
 * <br>
 * Contiene propiedades para representar los datos del objeto Tipo
 * inconsistencia.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class TipoInconsistenciaDTO implements Serializable
{
	
	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1848854264700429137L;
	// --- Atributos
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad id
	 * tipo inconsistencia.
	 */
	private String is_idTipoInconsistencia;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * descripcion.
	 */
	private String is_descripcion;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * activo.
	 */
	private String is_activo;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad id
	 * usuario creacion.
	 */
	private String is_idUsuarioCreacion;
	
	/**
	 * Atributo de instancia tipo Date para definir la propiedad fecha creacion.
	 */
	private Date is_fechaCreacion;
	
	/**
	 * Obtiene el valor para la propiedad id tipo inconsistencia.
	 *
	 * @return El valor de la propiedad id tipo inconsistencia
	 */
	// --- Getters-Setters
	public String getIs_idTipoInconsistencia() {
		return is_idTipoInconsistencia;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad id tipo inconsistencia.
	 *
	 * @param as_idTipoInconsistencia el nuevo valor para la propiedad id tipo
	 *                                inconsistencia
	 */
	public void setIs_idTipoInconsistencia(String as_idTipoInconsistencia) {
		this.is_idTipoInconsistencia = as_idTipoInconsistencia;
	}
	
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
	 * Obtiene el valor para la propiedad activo.
	 *
	 * @return El valor de la propiedad activo
	 */
	public String getIs_activo() {
		return is_activo;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad activo.
	 *
	 * @param as_activo el nuevo valor para la propiedad activo
	 */
	public void setIs_activo(String as_activo) {
		this.is_activo = as_activo;
	}
	
	/**
	 * Obtiene el valor para la propiedad id usuario creacion.
	 *
	 * @return El valor de la propiedad id usuario creacion
	 */
	public String getIs_idUsuarioCreacion() {
		return is_idUsuarioCreacion;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad id usuario creacion.
	 *
	 * @param as_idUsuarioCreacion el nuevo valor para la propiedad id usuario
	 *                             creacion
	 */
	public void setIs_idUsuarioCreacion(String as_idUsuarioCreacion) {
		this.is_idUsuarioCreacion = as_idUsuarioCreacion;
	}
	
	/**
	 * Obtiene el valor para la propiedad fecha creacion.
	 *
	 * @return El valor de la propiedad fecha creacion
	 */
	public Date getIs_fechaCreacion() {
		return is_fechaCreacion;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad fecha creacion.
	 *
	 * @param as_fechaCreacion el nuevo valor para la propiedad fecha creacion
	 */
	public void setIs_fechaCreacion(Date as_fechaCreacion) {
		this.is_fechaCreacion = as_fechaCreacion;
	}


}
