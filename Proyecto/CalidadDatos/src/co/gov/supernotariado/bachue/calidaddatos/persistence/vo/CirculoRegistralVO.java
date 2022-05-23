/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: CirculoRegistralVO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.persistence.VO
 * Nombre del elemento: CirculoRegistralVO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.persistence.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * El elemento Class CirculoRegistralVO.<br>
 * Representa un/una circulo registral VO.<br>
 * Clase utlizada para establecer parametros de CirculoRegistralVO
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class CirculoRegistralVO implements Serializable {

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 4020209220476781807L;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad id
	 * circulo.
	 */
	private String is_idCirculo;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * nombre.
	 */
	private String is_nombre;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * nit.
	 */
	private String is_nit;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * cobra impuesto.
	 */
	private String is_cobraImpuesto;

	/**
	 * Atributo de instancia tipo numero real/decimal de gran magnitud para definir
	 * la propiedad ultimo id matricula.
	 */
	private BigDecimal ibd_ultimoIdMatricula;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad id
	 * oficina origen.
	 */
	private String is_idOficinaOrigen;

	/**
	 * Atributo de instancia tipo numero real/decimal de gran magnitud para definir
	 * la propiedad version.
	 */
	private BigDecimal ibd_version;

	/**
	 * Atributo de instancia tipo fecha para definir la propiedad fecha produccion.
	 */
	private Date id_fechaProduccion;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * sistema origen.
	 */
	private String is_sistemaOrigen;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * activo.
	 */
	private String is_activo;

	/**
	 * Atributo de instancia tipo fecha para definir la propiedad fecha produccion
	 * bachue.
	 */
	private Date id_fechaProduccionBachue;

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
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad id
	 * regional.
	 */
	private String is_idRegional;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * tipo oficina.
	 */
	private String is_tipoOficina;

	/**
	 * Atributo de instancia tipo numero real/decimal de gran magnitud para definir
	 * la propiedad tope maximo reparto.
	 */
	private BigDecimal ibd_topeMaximoReparto;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad ip
	 * creacion.
	 */
	private String is_ipCreacion;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad id
	 * usuario modificacion.
	 */
	private String is_idUsuarioModificacion;

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
	 * gobernacion.
	 */
	private String is_idGobernacion;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * consecutivo relacion aprovacion.
	 */
	private String is_consecutivoRelacionAprovacion;

	/**
	 * Obtiene el valor para la propiedad id circulo.
	 *
	 * @return El valor de la propiedad id circulo
	 */
	public String getIs_idCirculo() {
		return is_idCirculo;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad id circulo.
	 *
	 * @param as_idCirculo el nuevo valor para la propiedad id circulo
	 */
	public void setIs_idCirculo(String as_idCirculo) {
		this.is_idCirculo = as_idCirculo;
	}

	/**
	 * Obtiene el valor para la propiedad nombre.
	 *
	 * @return El valor de la propiedad nombre
	 */
	public String getIs_nombre() {
		return is_nombre;
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
	 * Obtiene el valor para la propiedad nit.
	 *
	 * @return El valor de la propiedad nit
	 */
	public String getIs_nit() {
		return is_nit;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad nit.
	 *
	 * @param as_nit el nuevo valor para la propiedad nit
	 */
	public void setIs_nit(String as_nit) {
		this.is_nit = as_nit;
	}

	/**
	 * Obtiene el valor para la propiedad cobra impuesto.
	 *
	 * @return El valor de la propiedad cobra impuesto
	 */
	public String getIs_cobraImpuesto() {
		return is_cobraImpuesto;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad cobra impuesto.
	 *
	 * @param as_cobraImpuesto el nuevo valor para la propiedad cobra impuesto
	 */
	public void setIs_cobraImpuesto(String as_cobraImpuesto) {
		this.is_cobraImpuesto = as_cobraImpuesto;
	}

	/**
	 * Obtiene el valor para la propiedad ultimo id matricula.
	 *
	 * @return El valor de la propiedad ultimo id matricula
	 */
	public BigDecimal getIbd_ultimoIdMatricula() {
		return ibd_ultimoIdMatricula;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad ultimo id matricula.
	 *
	 * @param abd_ultimoIdMatricula el nuevo valor para la propiedad ultimo id
	 *                              matricula
	 */
	public void setIbd_ultimoIdMatricula(BigDecimal abd_ultimoIdMatricula) {
		this.ibd_ultimoIdMatricula = abd_ultimoIdMatricula;
	}

	/**
	 * Obtiene el valor para la propiedad id oficina origen.
	 *
	 * @return El valor de la propiedad id oficina origen
	 */
	public String getIs_idOficinaOrigen() {
		return is_idOficinaOrigen;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad id oficina origen.
	 *
	 * @param as_idOficinaOrigen el nuevo valor para la propiedad id oficina origen
	 */
	public void setIs_idOficinaOrigen(String as_idOficinaOrigen) {
		this.is_idOficinaOrigen = as_idOficinaOrigen;
	}

	/**
	 * Obtiene el valor para la propiedad version.
	 *
	 * @return El valor de la propiedad version
	 */
	public BigDecimal getIbd_version() {
		return ibd_version;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad version.
	 *
	 * @param abd_version el nuevo valor para la propiedad version
	 */
	public void setIbd_version(BigDecimal abd_version) {
		this.ibd_version = abd_version;
	}

	/**
	 * Obtiene el valor para la propiedad fecha produccion.
	 *
	 * @return El valor de la propiedad fecha produccion
	 */
	public Date getId_fechaProduccion() {
		return id_fechaProduccion;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad fecha produccion.
	 *
	 * @param ad_fechaProduccion el nuevo valor para la propiedad fecha produccion
	 */
	public void setId_fechaProduccion(Date ad_fechaProduccion) {
		this.id_fechaProduccion = ad_fechaProduccion;
	}

	/**
	 * Obtiene el valor para la propiedad sistema origen.
	 *
	 * @return El valor de la propiedad sistema origen
	 */
	public String getIs_sistemaOrigen() {
		return is_sistemaOrigen;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad sistema origen.
	 *
	 * @param as_sistemaOrigen el nuevo valor para la propiedad sistema origen
	 */
	public void setIs_sistemaOrigen(String as_sistemaOrigen) {
		this.is_sistemaOrigen = as_sistemaOrigen;
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
	 * Obtiene el valor para la propiedad fecha produccion bachue.
	 *
	 * @return El valor de la propiedad fecha produccion bachue
	 */
	public Date getId_fechaProduccionBachue() {
		return id_fechaProduccionBachue;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad fecha produccion bachue.
	 *
	 * @param ad_fechaProduccionBachue el nuevo valor para la propiedad fecha
	 *                                 produccion bachue
	 */
	public void setId_fechaProduccionBachue(Date ad_fechaProduccionBachue) {
		this.id_fechaProduccionBachue = ad_fechaProduccionBachue;
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
	 * Obtiene el valor para la propiedad id regional.
	 *
	 * @return El valor de la propiedad id regional
	 */
	public String getIs_idRegional() {
		return is_idRegional;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad id regional.
	 *
	 * @param as_idRegional el nuevo valor para la propiedad id regional
	 */
	public void setIs_idRegional(String as_idRegional) {
		this.is_idRegional = as_idRegional;
	}

	/**
	 * Obtiene el valor para la propiedad tipo oficina.
	 *
	 * @return El valor de la propiedad tipo oficina
	 */
	public String getIs_tipoOficina() {
		return is_tipoOficina;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad tipo oficina.
	 *
	 * @param as_tipoOficina el nuevo valor para la propiedad tipo oficina
	 */
	public void setIs_tipoOficina(String as_tipoOficina) {
		this.is_tipoOficina = as_tipoOficina;
	}

	/**
	 * Obtiene el valor para la propiedad tope maximo reparto.
	 *
	 * @return El valor de la propiedad tope maximo reparto
	 */
	public BigDecimal getIbd_topeMaximoReparto() {
		return ibd_topeMaximoReparto;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad tope maximo reparto.
	 *
	 * @param abd_topeMaximoReparto el nuevo valor para la propiedad tope maximo
	 *                              reparto
	 */
	public void setIbd_topeMaximoReparto(BigDecimal abd_topeMaximoReparto) {
		this.ibd_topeMaximoReparto = abd_topeMaximoReparto;
	}

	/**
	 * Obtiene el valor para la propiedad ip creacion.
	 *
	 * @return El valor de la propiedad ip creacion
	 */
	public String getIs_ipCreacion() {
		return is_ipCreacion;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad ip creacion.
	 *
	 * @param as_ipCreacion el nuevo valor para la propiedad ip creacion
	 */
	public void setIs_ipCreacion(String as_ipCreacion) {
		this.is_ipCreacion = as_ipCreacion;
	}

	/**
	 * Obtiene el valor para la propiedad id usuario modificacion.
	 *
	 * @return El valor de la propiedad id usuario modificacion
	 */
	public String getIs_idUsuarioModificacion() {
		return is_idUsuarioModificacion;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad id usuario modificacion.
	 *
	 * @param as_idUsuarioModificacion el nuevo valor para la propiedad id usuario
	 *                                 modificacion
	 */
	public void setIs_idUsuarioModificacion(String as_idUsuarioModificacion) {
		this.is_idUsuarioModificacion = as_idUsuarioModificacion;
	}

	/**
	 * Obtiene el valor para la propiedad fecha modificacion.
	 *
	 * @return El valor de la propiedad fecha modificacion
	 */
	public Date getId_fechaModificacion() {
		return id_fechaModificacion;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad fecha modificacion.
	 *
	 * @param ad_fechaModificacion el nuevo valor para la propiedad fecha
	 *                             modificacion
	 */
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

	/**
	 * Cambia/actualiza el valor para la propiedad ip modificacion.
	 *
	 * @param as_ipModificacion el nuevo valor para la propiedad ip modificacion
	 */
	public void setIs_ipModificacion(String as_ipModificacion) {
		this.is_ipModificacion = as_ipModificacion;
	}

	/**
	 * Obtiene el valor para la propiedad id gobernacion.
	 *
	 * @return El valor de la propiedad id gobernacion
	 */
	public String getIs_idGobernacion() {
		return is_idGobernacion;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad id gobernacion.
	 *
	 * @param as_idGobernacion el nuevo valor para la propiedad id gobernacion
	 */
	public void setIs_idGobernacion(String as_idGobernacion) {
		this.is_idGobernacion = as_idGobernacion;
	}

	/**
	 * Obtiene el valor para la propiedad consecutivo relacion aprovacion.
	 *
	 * @return El valor de la propiedad consecutivo relacion aprovacion
	 */
	public String getIs_consecutivoRelacionAprovacion() {
		return is_consecutivoRelacionAprovacion;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad consecutivo relacion aprovacion.
	 *
	 * @param as_consecutivoRelacionAprovacion el nuevo valor para la propiedad
	 *                                         consecutivo relacion aprovacion
	 */
	public void setIs_consecutivoRelacionAprovacion(String as_consecutivoRelacionAprovacion) {
		this.is_consecutivoRelacionAprovacion = as_consecutivoRelacionAprovacion;
	}
}