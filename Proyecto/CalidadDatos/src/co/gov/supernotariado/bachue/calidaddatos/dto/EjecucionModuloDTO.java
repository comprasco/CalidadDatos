/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: EjecucionModuloDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.dto
 * Nombre del elemento: EjecucionModuloDTO
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
 * Contiene propiedades para representar los datos del objeto Ejecucion modulo.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class EjecucionModuloDTO implements Serializable
{
	
	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 3176065122630214611L;
	// --- Atributos
	/**
	 * Atributo de instancia tipo numero real/decimal de gran magnitud para definir
	 * la propiedad id ejecucion.
	 */
	private BigDecimal ibd_idEjecucion;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad id
	 * circulo.
	 */
	private String is_idCirculo;
	
	/**
	 * Atributo de instancia tipo numero real/decimal de gran magnitud para definir
	 * la propiedad id modulo.
	 */
	private BigDecimal ibd_idModulo;
	
	/**
	 * Atributo de instancia tipo fecha para definir la propiedad fecha inicio.
	 */
	private Date id_fechaInicio;
	
	/**
	 * Atributo de instancia tipo fecha para definir la propiedad fecha fin.
	 */
	private Date id_fechaFin;
	
	/**
	 * Atributo de instancia tipo numero real/decimal de gran magnitud para definir
	 * la propiedad num reg ok.
	 */
	private BigDecimal ibd_numRegOk;
	
	/**
	 * Atributo de instancia tipo numero real/decimal de gran magnitud para definir
	 * la propiedad num reg incon.
	 */
	private BigDecimal ibd_numRegIncon;
	
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
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad num
	 * reg origen.
	 */
	private String is_numRegOrigen;
	
	/**
	 * Obtiene el valor para la propiedad id ejecucion.
	 *
	 * @return El valor de la propiedad id ejecucion
	 */
	// --- Getters-Setters
	public BigDecimal getIbd_idEjecucion() 
	{
		return ibd_idEjecucion;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad id ejecucion.
	 *
	 * @param abd_idEjecucion el nuevo valor para la propiedad id ejecucion
	 */
	public void setIbd_idEjecucion(BigDecimal abd_idEjecucion) 
	{
		this.ibd_idEjecucion = abd_idEjecucion;
	}
	
	/**
	 * Obtiene el valor para la propiedad id circulo.
	 *
	 * @return El valor de la propiedad id circulo
	 */
	public String getIs_idCirculo() 
	{
		return is_idCirculo;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad id circulo.
	 *
	 * @param as_idCirculo el nuevo valor para la propiedad id circulo
	 */
	public void setIs_idCirculo(String as_idCirculo) 
	{
		this.is_idCirculo = as_idCirculo;
	}
	
	/**
	 * Obtiene el valor para la propiedad id modulo.
	 *
	 * @return El valor de la propiedad id modulo
	 */
	public BigDecimal getIbd_idModulo() 
	{
		return ibd_idModulo;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad id modulo.
	 *
	 * @param abd_idModulo el nuevo valor para la propiedad id modulo
	 */
	public void setIbd_idModulo(BigDecimal abd_idModulo) 
	{
		this.ibd_idModulo = abd_idModulo;
	}
	
	/**
	 * Obtiene el valor para la propiedad fecha inicio.
	 *
	 * @return El valor de la propiedad fecha inicio
	 */
	public Date getId_fechaInicio() 
	{
		return id_fechaInicio;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad fecha inicio.
	 *
	 * @param ad_fechaInicio el nuevo valor para la propiedad fecha inicio
	 */
	public void setId_fechaInicio(Date ad_fechaInicio) 
	{
		this.id_fechaInicio = ad_fechaInicio;
	}
	
	/**
	 * Obtiene el valor para la propiedad fecha fin.
	 *
	 * @return El valor de la propiedad fecha fin
	 */
	public Date getId_fechaFin() 
	{
		return id_fechaFin;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad fecha fin.
	 *
	 * @param ad_fechaFin el nuevo valor para la propiedad fecha fin
	 */
	public void setId_fechaFin(Date ad_fechaFin) 
	{
		this.id_fechaFin = ad_fechaFin;
	}
	
	/**
	 * Obtiene el valor para la propiedad num reg ok.
	 *
	 * @return El valor de la propiedad num reg ok
	 */
	public BigDecimal getIbd_numRegOk() 
	{
		return ibd_numRegOk;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad num reg ok.
	 *
	 * @param abd_numRegOk el nuevo valor para la propiedad num reg ok
	 */
	public void setIbd_numRegOk(BigDecimal abd_numRegOk) 
	{
		this.ibd_numRegOk = abd_numRegOk;
	}
	
	/**
	 * Obtiene el valor para la propiedad num reg incon.
	 *
	 * @return El valor de la propiedad num reg incon
	 */
	public BigDecimal getIbd_numRegIncon() 
	{
		return ibd_numRegIncon;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad num reg incon.
	 *
	 * @param abd_numRegIncon el nuevo valor para la propiedad num reg incon
	 */
	public void setIbd_numRegIncon(BigDecimal abd_numRegIncon) 
	{
		this.ibd_numRegIncon = abd_numRegIncon;
	}
	
	/**
	 * Obtiene el valor para la propiedad id usuario creacion.
	 *
	 * @return El valor de la propiedad id usuario creacion
	 */
	public String getIs_idUsuarioCreacion() 
	{
		return is_idUsuarioCreacion;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad id usuario creacion.
	 *
	 * @param as_idUsuarioCreacion el nuevo valor para la propiedad id usuario
	 *                             creacion
	 */
	public void setIs_idUsuarioCreacion(String as_idUsuarioCreacion) 
	{
		this.is_idUsuarioCreacion = as_idUsuarioCreacion;
	}
	
	/**
	 * Obtiene el valor para la propiedad fecha creacion.
	 *
	 * @return El valor de la propiedad fecha creacion
	 */
	public Date getId_fechaCreacion() 
	{
		return id_fechaCreacion;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad fecha creacion.
	 *
	 * @param ad_fechaCreacion el nuevo valor para la propiedad fecha creacion
	 */
	public void setId_fechaCreacion(Date ad_fechaCreacion) 
	{
		this.id_fechaCreacion = ad_fechaCreacion;
	}
	
	/**
	 * Obtiene el valor para la propiedad num reg origen.
	 *
	 * @return El valor de la propiedad num reg origen
	 */
	public String getIs_numRegOrigen() 
	{
		return is_numRegOrigen;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad num reg origen.
	 *
	 * @param as_numRegOrigen el nuevo valor para la propiedad num reg origen
	 */
	public void setIs_numRegOrigen(String as_numRegOrigen) 
	{
		this.is_numRegOrigen = as_numRegOrigen;
	}
}