/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InconsistenciaVO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.persistence.VO
 * Nombre del elemento: InconsistenciaVO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */

package co.gov.supernotariado.bachue.calidaddatos.persistence.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * El elemento Class InconsistenciaVO.<br>
 * Representa un/una inconsistencia VO.<br>
 * Clase utlizada para establecer parametros de InconsistenciaVO
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class InconsistenciaVO implements Serializable 
{

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = -4334851942618889613L;
	
	/**
	 * Atributo de instancia tipo entero para definir la propiedad id
	 * inconsistencia.
	 */
	private int ii_idInconsistencia;
	
	/**
	 * Atributo de instancia tipo entero para definir la propiedad id ejecucion.
	 */
	private int ii_idEjecucion;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad id
	 * circulo.
	 */
	private String is_idCirculo;
	
	/**
	 * Atributo de instancia tipo entero para definir la propiedad id modulo.
	 */
	private int ii_idModulo;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * tabla destino.
	 */
	private String is_tablaDestino;
	
	/**
	 * Atributo de instancia tipo entero para definir la propiedad procesado
	 * registro.
	 */
	private int ii_procesadoRegistro;
	
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
	 * Obtiene el valor para la propiedad id inconsistencia.
	 *
	 * @return El valor de la propiedad id inconsistencia
	 */
	public int getIi_idInconsistencia() 
	{
		return ii_idInconsistencia;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad id inconsistencia.
	 *
	 * @param ai_idInconsistencia el nuevo valor para la propiedad id inconsistencia
	 */
	public void setIi_idInconsistencia(int ai_idInconsistencia) 
	{
		this.ii_idInconsistencia = ai_idInconsistencia;
	}
	
	/**
	 * Obtiene el valor para la propiedad id ejecucion.
	 *
	 * @return El valor de la propiedad id ejecucion
	 */
	public int getIi_idEjecucion() 
	{
		return ii_idEjecucion;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad id ejecucion.
	 *
	 * @param ai_idEjecucion el nuevo valor para la propiedad id ejecucion
	 */
	public void setIi_idEjecucion(int ai_idEjecucion) 
	{
		this.ii_idEjecucion = ai_idEjecucion;
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
	public int getIi_idModulo() 
	{
		return ii_idModulo;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad id modulo.
	 *
	 * @param ai_idModulo el nuevo valor para la propiedad id modulo
	 */
	public void setIi_idModulo(int ai_idModulo) 
	{
		this.ii_idModulo = ai_idModulo;
	}
	
	/**
	 * Obtiene el valor para la propiedad tabla destino.
	 *
	 * @return El valor de la propiedad tabla destino
	 */
	public String getIs_tablaDestino() 
	{
		return is_tablaDestino;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad tabla destino.
	 *
	 * @param as_tablaDestino el nuevo valor para la propiedad tabla destino
	 */
	public void setIs_tablaDestino(String as_tablaDestino) 
	{
		this.is_tablaDestino = as_tablaDestino;
	}

	/**
	 * Obtiene el valor para la propiedad procesado registro.
	 *
	 * @return El valor de la propiedad procesado registro
	 */
	public int getIi_procesadoRegistro() 
	{
		return ii_procesadoRegistro;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad procesado registro.
	 *
	 * @param ai_procesadoRegistro el nuevo valor para la propiedad procesado
	 *                             registro
	 */
	public void setIi_procesadoRegistro(int ai_procesadoRegistro) 
	{
		this.ii_procesadoRegistro = ai_procesadoRegistro;
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
}
