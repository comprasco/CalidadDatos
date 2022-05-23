/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InconsistenciaCampoDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.dto
 * Nombre del elemento: InconsistenciaCampoDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase tipo objeto de transferencia de datos (DTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y presentacion.
 * <br>
 * Contiene propiedades para representar los datos del objeto Inconsistencia
 * campo.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class InconsistenciaCampoDTO implements Serializable {

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = -4187174932004254946L;
	// --- Atributos
	/**
	 * Atributo de instancia tipo numero real/decimal de gran magnitud para definir
	 * la propiedad id inconsistencia.
	 */
	private BigDecimal ibd_idInconsistencia;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * tabla destino.
	 */
	private String is_tablaDestino;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * nombre campo.
	 */
	private String is_nombreCampo;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad id
	 * tipo inconsistencia.
	 */
	private String is_idTipoInconsistencia;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * valor campo.
	 */
	private String is_valorCampo;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * valor correcto campo.
	 */
	private String is_valorCorrectoCampo;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * accion.
	 */
	private String is_accion;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * procesada campo.
	 */
	private String is_procesadaCampo;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad id
	 * usuario creacion.
	 */
	private String is_idUsuarioCreacion;
	
	/**
	 * Atributo de instancia tipo fecha para definir la propiedad fecha creacion.
	 */
	private Date id_fechaCreacion;
	
	/**
	 * Atributo de instancia tipo CirculoRegistralDTO para definir la propiedad
	 * circulo registral.
	 */
	private CirculoRegistralDTO icrd_circuloRegistralDTO;
	
	/**
	 * Atributo de instancia tipo InconsistenciaDTO para definir la propiedad
	 * inconsistencia.
	 */
	private InconsistenciaDTO iid_inconsistenciaDTO;
	
	/**
	 * Atributo de instancia tipo TipoInconsistenciaDTO para definir la propiedad
	 * tipo inconsistencia.
	 */
	private TipoInconsistenciaDTO itid_tipoInconsistenciaDTO;
	
	/**
	 * Atributo de instancia tipo MetadataDTO para definir la propiedad metadata.
	 */
	private MetadataDTO im_metadataDTO;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * observaciones.
	 */
	private String is_observaciones;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * observacionesnc.
	 */
	private String is_observacionesnc;
	
	/**
	 * Construye una nueva instancia/objeto de la clase InconsistenciaCampoDTO.
	 */
	// Metodo constructor  InconsistenciaCampoDTO
	public InconsistenciaCampoDTO() {
		this.setIcrd_circuloRegistralDTO(new CirculoRegistralDTO());
		this.setIid_inconsistenciaDTO(new InconsistenciaDTO());
		this.setItid_tipoInconsistenciaDTO(new TipoInconsistenciaDTO());
	}
	
	/**
	 * Obtiene el valor para la propiedad id inconsistencia.
	 *
	 * @return El valor de la propiedad id inconsistencia
	 */
	// --- Getters-Setters
	public BigDecimal getIbd_idInconsistencia() {

		return ibd_idInconsistencia;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad id inconsistencia.
	 *
	 * @param abd_idInconsistencia el nuevo valor para la propiedad id
	 *                             inconsistencia
	 */
	public void setIbd_idInconsistencia(BigDecimal abd_idInconsistencia) {
		this.ibd_idInconsistencia = abd_idInconsistencia;
	}

	/**
	 * Obtiene el valor para la propiedad tabla destino.
	 *
	 * @return El valor de la propiedad tabla destino
	 */
	public String getIs_tablaDestino() {
		return is_tablaDestino;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad tabla destino.
	 *
	 * @param as_tablaDestino el nuevo valor para la propiedad tabla destino
	 */
	public void setIs_tablaDestino(String as_tablaDestino) {
		this.is_tablaDestino = as_tablaDestino;
	}

	/**
	 * Obtiene el valor para la propiedad nombre campo.
	 *
	 * @return El valor de la propiedad nombre campo
	 */
	public String getIs_nombreCampo() {
		return is_nombreCampo;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad nombre campo.
	 *
	 * @param as_nombreCampo el nuevo valor para la propiedad nombre campo
	 */
	public void setIs_nombreCampo(String as_nombreCampo) {
		this.is_nombreCampo = as_nombreCampo;
	}


	/**
	 * Obtiene el valor para la propiedad id tipo inconsistencia.
	 *
	 * @return El valor de la propiedad id tipo inconsistencia
	 */
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
	 * Obtiene el valor para la propiedad valor campo.
	 *
	 * @return El valor de la propiedad valor campo
	 */
	public String getIs_valorCampo() {
		return is_valorCampo;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad valor campo.
	 *
	 * @param as_valorCampo el nuevo valor para la propiedad valor campo
	 */
	public void setIs_valorCampo(String as_valorCampo) {
		this.is_valorCampo = as_valorCampo;
	}

	/**
	 * Obtiene el valor para la propiedad valor correcto campo.
	 *
	 * @return El valor de la propiedad valor correcto campo
	 */
	public String getIs_valorCorrectoCampo() {
		return is_valorCorrectoCampo;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad valor correcto campo.
	 *
	 * @param as_valorCorrectoCampo el nuevo valor para la propiedad valor correcto
	 *                              campo
	 */
	public void setIs_valorCorrectoCampo(String as_valorCorrectoCampo) {
		this.is_valorCorrectoCampo = as_valorCorrectoCampo;
	}

	/**
	 * Obtiene el valor para la propiedad accion.
	 *
	 * @return El valor de la propiedad accion
	 */
	public String getIs_accion() {
		return is_accion;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad accion.
	 *
	 * @param as_accion el nuevo valor para la propiedad accion
	 */
	public void setIs_accion(String as_accion) {
		this.is_accion = as_accion;
	}

	/**
	 * Obtiene el valor para la propiedad procesada campo.
	 *
	 * @return El valor de la propiedad procesada campo
	 */
	public String getIs_procesadaCampo() {
		return is_procesadaCampo;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad procesada campo.
	 *
	 * @param as_procesadaCampo el nuevo valor para la propiedad procesada campo
	 */
	public void setIs_procesadaCampo(String as_procesadaCampo) {
		this.is_procesadaCampo = as_procesadaCampo;
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
	public Date getId_fechaCreacion() {
		return id_fechaCreacion;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad fecha creacion.
	 *
	 * @param ad_fechaCreacion el nuevo valor para la propiedad fecha creacion
	 */
	public void setId_fechaCreacion(Date ad_fechaCreacion) {
		this.id_fechaCreacion = ad_fechaCreacion;
	}

	/**
	 * Obtiene el valor para la propiedad inconsistencia DTO.
	 *
	 * @return El valor de la propiedad inconsistencia DTO
	 */
	public InconsistenciaDTO getIid_inconsistenciaDTO() {
		return iid_inconsistenciaDTO;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad inconsistencia DTO.
	 *
	 * @param aid_inconsistenciaDTO el nuevo valor para la propiedad inconsistencia
	 *                              DTO
	 */
	public void setIid_inconsistenciaDTO(InconsistenciaDTO aid_inconsistenciaDTO) {
		this.iid_inconsistenciaDTO = aid_inconsistenciaDTO;
	}

	/**
	 * Obtiene el valor para la propiedad circulo registral DTO.
	 *
	 * @return El valor de la propiedad circulo registral DTO
	 */
	public CirculoRegistralDTO getIcrd_circuloRegistralDTO() {
		return icrd_circuloRegistralDTO;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad circulo registral DTO.
	 *
	 * @param acrd_circuloRegistralDTO el nuevo valor para la propiedad circulo
	 *                                 registral DTO
	 */
	public void setIcrd_circuloRegistralDTO(CirculoRegistralDTO acrd_circuloRegistralDTO) {
		this.icrd_circuloRegistralDTO = acrd_circuloRegistralDTO;
	}

	/**
	 * Obtiene el valor para la propiedad tipo inconsistencia DTO.
	 *
	 * @return El valor de la propiedad tipo inconsistencia DTO
	 */
	public TipoInconsistenciaDTO getItid_tipoInconsistenciaDTO() {
		return itid_tipoInconsistenciaDTO;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad tipo inconsistencia DTO.
	 *
	 * @param atid_tipoInconsistenciaDTO el nuevo valor para la propiedad tipo
	 *                                   inconsistencia DTO
	 */
	public void setItid_tipoInconsistenciaDTO(TipoInconsistenciaDTO atid_tipoInconsistenciaDTO) {
		this.itid_tipoInconsistenciaDTO = atid_tipoInconsistenciaDTO;
	}

	/**
	 * Obtiene el valor para la propiedad metadata DTO.
	 *
	 * @return El valor de la propiedad metadata DTO
	 */
	public MetadataDTO getIm_metadataDTO() {
		return im_metadataDTO;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad metadata DTO.
	 *
	 * @param am_metadataDTO el nuevo valor para la propiedad metadata DTO
	 */
	public void setIm_metadataDTO(MetadataDTO am_metadataDTO) {
		this.im_metadataDTO = am_metadataDTO;
	}

	/**
	 * Obtiene el valor para la propiedad observaciones.
	 *
	 * @return El valor de la propiedad observaciones
	 */
	public String getIs_observaciones() {
		return is_observaciones;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad observaciones.
	 *
	 * @param as_observaciones el nuevo valor para la propiedad observaciones
	 */
	public void setIs_observaciones(String as_observaciones) {
		this.is_observaciones = as_observaciones;
	}

	/**
	 * Obtiene el valor para la propiedad observacionesnc.
	 *
	 * @return El valor de la propiedad observacionesnc
	 */
	public String getIs_observacionesnc() {
		return is_observacionesnc;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad observacionesnc.
	 *
	 * @param as_observacionesnc el nuevo valor para la propiedad observacionesnc
	 */
	public void setIs_observacionesnc(String as_observacionesnc) {
		this.is_observacionesnc = as_observacionesnc;
	}

}
