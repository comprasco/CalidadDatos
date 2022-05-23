/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InconsistenciaDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.dto
 * Nombre del elemento: InconsistenciaDTO
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
 * Contiene propiedades para representar los datos del objeto Inconsistencia.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class InconsistenciaDTO implements Serializable
{

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1082717759156570357L;
	// --- Atributos
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
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * valor tipo dato.
	 */
	private String is_valorTipoDato;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * identificador matricula.
	 */
	private String is_identificadorMatricula;
	
	/**
	 * Obtiene el valor para la propiedad id inconsistencia.
	 *
	 * @return El valor de la propiedad id inconsistencia
	 */
	// --- Getters-Setters
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
	
	/**
	 * Obtiene el valor para la propiedad valor tipo dato.
	 *
	 * @return El valor de la propiedad valor tipo dato
	 */
	public String getIs_valorTipoDato() {
		return is_valorTipoDato;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad valor tipo dato.
	 *
	 * @param as_valorTipoDato el nuevo valor para la propiedad valor tipo dato
	 */
	public void setIs_valorTipoDato(String as_valorTipoDato) {
		this.is_valorTipoDato = as_valorTipoDato;
	}
	
	/**
	 * Obtiene el valor para la propiedad identificador matricula.
	 *
	 * @return El valor de la propiedad identificador matricula
	 */
	public String getIs_identificadorMatricula() {
		return is_identificadorMatricula;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad identificador matricula.
	 *
	 * @param as_identificadorMatricula el nuevo valor para la propiedad
	 *                                  identificador matricula
	 */
	public void setIs_identificadorMatricula(String as_identificadorMatricula) {
		this.is_identificadorMatricula = as_identificadorMatricula;
	}
}
