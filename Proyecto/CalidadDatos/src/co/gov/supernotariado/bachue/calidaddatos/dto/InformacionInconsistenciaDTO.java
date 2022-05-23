/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InformacionInconsistenciaDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.dto
 * Nombre del elemento: InformacionInconsistenciaDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.dto;

import java.math.BigInteger;
import java.util.Date;

/**
 * Clase tipo objeto de transferencia de datos (DTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y presentacion.
 * <br>
 * Contiene propiedades para representar los datos del objeto Informacion
 * inconsistencia.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class InformacionInconsistenciaDTO {
	// --- Atributos
	/**
	 * Atributo de instancia tipo String para definir la propiedad numero turno.
	 */
	private String ibi_numeroTurno;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * numero matricula.
	 */
	private String is_numeroMatricula;
	
	/**
	 * Atributo de instancia tipo entero de gran magnitud para definir la propiedad
	 * numero inconsistencia.
	 */
	private BigInteger ibi_numeroInconsistencia;
	
	/**
	 * Atributo de instancia tipo entero para definir la propiedad id modulo.
	 */
	private Integer ii_idModulo;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * tabla.
	 */
	private String is_tabla;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * campo.
	 */
	private String is_campo;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * valor actual.
	 */
	private String is_valorActual;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * nuevo valor.
	 */
	private String is_nuevoValor;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * procesada.
	 */
	private String is_procesada;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * tipo inconsistencia.
	 */
	private String is_tipoInconsistencia;
	
	/**
	 * Atributo de instancia tipo MetadataDTO para definir la propiedad metadata.
	 */
	private MetadataDTO im_metadataDto;
	
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
	 * Atributo de instancia tipo verdadero/falso para definir la propiedad
	 * correccion.
	 */
	private Boolean ib_correccion;
	
	/**
	 * Atributo de instancia tipo fecha para definir la propiedad fecha nueva.
	 */
	private Date id_fechaNueva;
	
	/**
	 * Atributo para definir la propiedad is circulo registral.
	 */
	private String is_circulo_registral;
	
	/**
	 * Atributo para definir la propiedad id fecha matricula.
	 */
	private Date id_fecha_Matricula;
	
	/**
	 * Obtiene el valor para la propiedad fecha matricula.
	 *
	 * @return El valor de la propiedad fecha matricula
	 */
	// --- Getters-Setters
	public Date getId_fecha_Matricula() {
		return id_fecha_Matricula;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad fecha matricula.
	 *
	 * @param ad_fecha_Matricula el nuevo valor para la propiedad fecha matricula
	 */
	public void setId_fecha_Matricula(Date ad_fecha_Matricula) {
		this.id_fecha_Matricula = ad_fecha_Matricula;
	}

	/**
	 * Obtiene el valor para la propiedad numero matricula.
	 *
	 * @return El valor de la propiedad numero matricula
	 */
	public String getIs_numeroMatricula() {
		return is_numeroMatricula;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad numero matricula.
	 *
	 * @param as_numeroMatricula el nuevo valor para la propiedad numero matricula
	 */
	public void setIs_numeroMatricula(String as_numeroMatricula) {
		this.is_numeroMatricula = as_numeroMatricula;
	}

	/**
	 * Obtiene el valor para la propiedad circulo registral.
	 *
	 * @return El valor de la propiedad circulo registral
	 */
	public String getIs_circulo_registral() {
		return is_circulo_registral;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad circulo registral.
	 *
	 * @param as_circulo_registral el nuevo valor para la propiedad circulo
	 *                             registral
	 */
	public void setIs_circulo_registral(String as_circulo_registral) {
		this.is_circulo_registral = as_circulo_registral;
	}

	/**
	 * Obtiene el valor para la propiedad numero turno.
	 *
	 * @return El valor de la propiedad numero turno
	 */
	public String getIbi_numeroTurno() {
		return ibi_numeroTurno;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad numero turno.
	 *
	 * @param abi_numeroTurno el nuevo valor para la propiedad numero turno
	 */
	public void setIbi_numeroTurno(String abi_numeroTurno) {
		this.ibi_numeroTurno = abi_numeroTurno;
	}
	

	/**
	 * Obtiene el valor para la propiedad numero inconsistencia.
	 *
	 * @return El valor de la propiedad numero inconsistencia
	 */
	public BigInteger getIbi_numeroInconsistencia() {
		return ibi_numeroInconsistencia;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad numero inconsistencia.
	 *
	 * @param abi_numeroInconsistencia el nuevo valor para la propiedad numero
	 *                                 inconsistencia
	 */
	public void setIbi_numeroInconsistencia(BigInteger abi_numeroInconsistencia) {
		this.ibi_numeroInconsistencia = abi_numeroInconsistencia;
	}

	/**
	 * Obtiene el valor para la propiedad id modulo.
	 *
	 * @return El valor de la propiedad id modulo
	 */
	public Integer getIi_idModulo() {
		return ii_idModulo;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad id modulo.
	 *
	 * @param ai_idModulo el nuevo valor para la propiedad id modulo
	 */
	public void setIi_idModulo(Integer ai_idModulo) {
		this.ii_idModulo = ai_idModulo;
	}

	/**
	 * Obtiene el valor para la propiedad tabla.
	 *
	 * @return El valor de la propiedad tabla
	 */
	public String getIs_tabla() {
		return is_tabla;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad tabla.
	 *
	 * @param as_tabla el nuevo valor para la propiedad tabla
	 */
	public void setIs_tabla(String as_tabla) {
		this.is_tabla = as_tabla;
	}

	/**
	 * Obtiene el valor para la propiedad campo.
	 *
	 * @return El valor de la propiedad campo
	 */
	public String getIs_campo() {
		return is_campo;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad campo.
	 *
	 * @param as_campo el nuevo valor para la propiedad campo
	 */
	public void setIs_campo(String as_campo) {
		this.is_campo = as_campo;
	}

	/**
	 * Obtiene el valor para la propiedad valor actual.
	 *
	 * @return El valor de la propiedad valor actual
	 */
	public String getIs_valorActual() {
		return is_valorActual;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad valor actual.
	 *
	 * @param as_valorActual el nuevo valor para la propiedad valor actual
	 */
	public void setIs_valorActual(String as_valorActual) {
		this.is_valorActual = as_valorActual;
	}

	/**
	 * Obtiene el valor para la propiedad procesada.
	 *
	 * @return El valor de la propiedad procesada
	 */
	public String getIs_procesada() {
		return is_procesada;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad procesada.
	 *
	 * @param as_procesada el nuevo valor para la propiedad procesada
	 */
	public void setIs_procesada(String as_procesada) {
		this.is_procesada = as_procesada;
	}


	/**
	 * Obtiene el valor para la propiedad tipo inconsistencia.
	 *
	 * @return El valor de la propiedad tipo inconsistencia
	 */
	public String getIs_tipoInconsistencia() {
		return is_tipoInconsistencia;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad tipo inconsistencia.
	 *
	 * @param as_tipoInconsistencia el nuevo valor para la propiedad tipo
	 *                              inconsistencia
	 */
	public void setIs_tipoInconsistencia(String as_tipoInconsistencia) {
		this.is_tipoInconsistencia = as_tipoInconsistencia;
	}

	/**
	 * Obtiene el valor para la propiedad metadata dto.
	 *
	 * @return El valor de la propiedad metadata dto
	 */
	public MetadataDTO getIm_metadataDto() {
		return im_metadataDto;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad metadata dto.
	 *
	 * @param am_metadataDto el nuevo valor para la propiedad metadata dto
	 */
	public void setIm_metadataDto(MetadataDTO am_metadataDto) {
		this.im_metadataDto = am_metadataDto;
	}

	/**
	 * Obtiene el valor para la propiedad nuevo valor.
	 *
	 * @return El valor de la propiedad nuevo valor
	 */
	public String getIs_nuevoValor() {
		return is_nuevoValor;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad nuevo valor.
	 *
	 * @param as_nuevoValor el nuevo valor para la propiedad nuevo valor
	 */
	public void setIs_nuevoValor(String as_nuevoValor) {
		this.is_nuevoValor = as_nuevoValor;
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

	/**
	 * Obtiene el valor para la propiedad correccion.
	 *
	 * @return El valor de la propiedad correccion
	 */
	public Boolean getIb_correccion() {
		return ib_correccion;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad correccion.
	 *
	 * @param ab_correccion el nuevo valor para la propiedad correccion
	 */
	public void setIb_correccion(Boolean ab_correccion) {
		this.ib_correccion = ab_correccion;
	}

	/**
	 * Obtiene el valor para la propiedad fecha nueva.
	 *
	 * @return El valor de la propiedad fecha nueva
	 */
	public Date getId_fechaNueva() {
		return id_fechaNueva;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad fecha nueva.
	 *
	 * @param ad_fechaNueva el nuevo valor para la propiedad fecha nueva
	 */
	public void setId_fechaNueva(Date ad_fechaNueva) {
		this.id_fechaNueva = ad_fechaNueva;
	}
	
	
}
