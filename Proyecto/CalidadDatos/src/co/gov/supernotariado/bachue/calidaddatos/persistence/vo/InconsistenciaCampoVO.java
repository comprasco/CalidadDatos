/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InconsistenciaCampoVO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.persistence.VO
 * Nombre del elemento: InconsistenciaCampoVO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */

package co.gov.supernotariado.bachue.calidaddatos.persistence.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * El elemento Class InconsistenciaCampoVO.<br>
 * Representa un/una inconsistencia campo VO.<br>
 * Clase utlizada para establecer parametros de InconsistenciaCampoVO
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class InconsistenciaCampoVO implements Serializable {
	
	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = -3520670153444120224L;
	
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
	 * Atributo de instancia tipo TipoInconsistenciaVO para definir la propiedad
	 * tipo inconsistencia VO.
	 */
	private TipoInconsistenciaVO itiv_tipoInconsistenciaVO;
	
	/**
	 * Atributo de instancia tipo MetadataVO para definir la propiedad metadato vo.
	 */
	private MetadataVO im_metadatoVo;

	/**
	 * Construye una nueva instancia/objeto de la clase InconsistenciaCampoVO.
	 */
	public InconsistenciaCampoVO() {
		this.setItiv_tipoInconsistenciaVO(new TipoInconsistenciaVO());
	}

	/**
	 * Obtiene el valor para la propiedad id inconsistencia.
	 *
	 * @return El valor de la propiedad id inconsistencia
	 */
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
	 * Obtiene el valor para la propiedad tipo inconsistencia VO.
	 *
	 * @return El valor de la propiedad tipo inconsistencia VO
	 */
	public TipoInconsistenciaVO getItiv_tipoInconsistenciaVO() {
		return itiv_tipoInconsistenciaVO;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad tipo inconsistencia VO.
	 *
	 * @param ativ_tipoInconsistenciaVO el nuevo valor para la propiedad tipo
	 *                                  inconsistencia VO
	 */
	public void setItiv_tipoInconsistenciaVO(TipoInconsistenciaVO ativ_tipoInconsistenciaVO) {
		this.itiv_tipoInconsistenciaVO = ativ_tipoInconsistenciaVO;
	}

	/**
	 * Obtiene el valor para la propiedad metadato vo.
	 *
	 * @return El valor de la propiedad metadato vo
	 */
	public MetadataVO getIm_metadatoVo() {
		return im_metadatoVo;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad metadato vo.
	 *
	 * @param am_metadatoVo el nuevo valor para la propiedad metadato vo
	 */
	public void setIm_metadatoVo(MetadataVO am_metadatoVo) {
		this.im_metadatoVo = am_metadatoVo;
	}

}