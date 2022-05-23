/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ExcepcionesTecnicas.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.exception
 * Nombre del elemento: ExcepcionesTecnicas
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.exception;

import co.gov.supernotariado.bachue.calidaddatos.enums.EnumExcepcionesGenerales;

/**
 * Excepcion personalizada para validaciones tecnicas.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class ExcepcionesTecnicas extends Exception implements IExcepcionesGenericas {

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Atributo de instancia tipo IEnumCatalogoMensajes para definir la propiedad
	 * catalogo excepcion.
	 */
	private final transient IEnumCatalogoMensajes iiece_catalogoExcepcion;
	
	/**
	 * Atributo de instancia tipo String[] para definir la propiedad mensajes
	 * excepcion.
	 */
	private String[] is_mensajesExcepcion;
	
	/**
	 * Construye una nueva instancia/objeto de la clase ExcepcionesTecnicas.
	 *
	 * @param aiece_exceptionInfo el parametro exception info
	 */
	public ExcepcionesTecnicas(IEnumCatalogoMensajes aiece_exceptionInfo) {
		super(aiece_exceptionInfo.consultarIs_codigo() + " : " + aiece_exceptionInfo.consultarIs_nombreArchivo());
		this.iiece_catalogoExcepcion = aiece_exceptionInfo;
	}
	
	/**
	 * Construye una nueva instancia/objeto de la clase ExcepcionesTecnicas.
	 *
	 * @param aiece_exceptionInfo el parametro exception info
	 * @param as_extraInfo        el parametro extra info
	 */
	public ExcepcionesTecnicas(IEnumCatalogoMensajes aiece_exceptionInfo, String[] as_extraInfo){
		super(aiece_exceptionInfo.consultarIs_codigo() + " : " + aiece_exceptionInfo.consultarIs_nombreArchivo());
		is_mensajesExcepcion = as_extraInfo;
		this.iiece_catalogoExcepcion = aiece_exceptionInfo;
	}
	
	/**
	 * Construye una nueva instancia/objeto de la clase ExcepcionesTecnicas.
	 *
	 * @param aiece_informacionExcepcion el parametro informacion excepcion
	 * @param as_informacionExtra        el parametro informacion extra
	 * @param ae_excepcionOrigen         el parametro excepcion origen
	 */
	public ExcepcionesTecnicas(IEnumCatalogoMensajes aiece_informacionExcepcion, String[] as_informacionExtra, Exception ae_excepcionOrigen){
		super(ae_excepcionOrigen);
		this.is_mensajesExcepcion = as_informacionExtra;
		this.iiece_catalogoExcepcion = aiece_informacionExcepcion;
	}
	
	/**
	 * Construye una nueva instancia/objeto de la clase ExcepcionesTecnicas.
	 *
	 * @param aiece_informacionExcepcion el parametro informacion excepcion
	 * @param ae_excepcionOrigen         el parametro excepcion origen
	 */
	public ExcepcionesTecnicas(IEnumCatalogoMensajes aiece_informacionExcepcion, Exception ae_excepcionOrigen){
		super(ae_excepcionOrigen);
		this.is_mensajesExcepcion = new String[] {};
		this.iiece_catalogoExcepcion = aiece_informacionExcepcion;
	}

	/**
	 * Construye una nueva instancia/objeto de la clase ExcepcionesTecnicas.
	 *
	 * @param as_mensaje el parametro mensaje
	 */
	public ExcepcionesTecnicas(String as_mensaje) {
		super(as_mensaje);
		this.iiece_catalogoExcepcion = EnumExcepcionesGenerales.ERROR_TECNICO;
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.exception.IExcepcionesGenericas#consultarCodigoExcepcion()
	 */
	@Override
	public String consultarCodigoExcepcion() {
		return iiece_catalogoExcepcion.consultarIs_codigo();
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.exception.IExcepcionesGenericas#consultarCatalogo()
	 */
	@Override
	public IEnumCatalogoMensajes consultarCatalogo() {
		return iiece_catalogoExcepcion;
	}

	/**
	 * Consultar mensaje excepcion.
	 *
	 * @return Resultado para consultar mensaje excepcion retornado como String[]
	 */
	public String[] consultarMensajeExcepcion() {
		return this.is_mensajesExcepcion;
	}
}