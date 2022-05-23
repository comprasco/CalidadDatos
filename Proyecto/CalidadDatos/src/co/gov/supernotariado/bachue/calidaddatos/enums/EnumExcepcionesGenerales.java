/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: EnumExcepcionesGenerales.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.enums
 * Nombre del elemento: EnumExcepcionesGenerales
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.enums;

import java.io.Serializable;

import co.gov.supernotariado.bachue.calidaddatos.exception.IEnumCatalogoMensajes;

/**
 * Enumeracion para definir el grupo de constantes para Excepciones generales.
 * <br>
 * Enum que contiene la informacion de las propiedades por codigo de error
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public enum EnumExcepcionesGenerales implements IEnumCatalogoMensajes, Serializable {

	/**
	 * Constante de la enumeracion para definir el item: ERROR_DATOS_ENTRADA.
	 */
	// Enum que aloja nombre del archivo que contiene las propiedades y un codigo
	// que representa el error existente
	ERROR_DATOS_ENTRADA("error.datos.entradas"),

	/**
	 * Constante de la enumeracion para definir el item: ERROR_DATOS_ENTRADA_EE.
	 */
	ERROR_DATOS_ENTRADA_EE("datos.inexistentes.ee"),

	/**
	 * Constante de la enumeracion para definir el item: ERROR_NEGOCIO.
	 */
	ERROR_NEGOCIO("error.negocio"),

	/**
	 * Constante de la enumeracion para definir el item: ERROR_TECNICO.
	 */
	ERROR_TECNICO("error.tecnico"),

	/**
	 * Constante de la enumeracion para definir el item: PERMISO_DENEGADO.
	 */
	PERMISO_DENEGADO("permiso.denegado"),

	/**
	 * Constante de la enumeracion para definir el item: ERROR_BASE_DATOS.
	 */
	ERROR_BASE_DATOS("error.base.datos"),

	/**
	 * Constante de la enumeracion para definir el item: SIN_CODIGO.
	 */
	SIN_CODIGO("sin.codigo"),

	/**
	 * Constante de la enumeracion para definir el item: DATOS_INEXISTENTES.
	 */
	DATOS_INEXISTENTES("datos.inexistentes"),

	/**
	 * Constante de la enumeracion para definir el item: MENSAJE.
	 */
	MENSAJE("mensaje"),

	/**
	 * Constante de la enumeracion para definir el item: ERROR_FORMATO.
	 */
	ERROR_FORMATO("error.formato"),

	/**
	 * Constante de la enumeracion para definir el item: RELACION_NO_EDITABLE.
	 */
	RELACION_NO_EDITABLE("relacion.no.editable"),

	/**
	 * Constante de la enumeracion para definir el item: USUARIO_NO_DISPONIBLE.
	 */
	USUARIO_NO_DISPONIBLE("usuario.no.disponible"),

	/**
	 * Constante de la enumeracion para definir el item: FECHA_NO_CONVERTIDA.
	 */
	FECHA_NO_CONVERTIDA("fecha.no.convertida"),

	/**
	 * Constante de la enumeracion para definir el item: CONTRASENA_EXPIRADA.
	 */
	CONTRASENA_EXPIRADA("contrasena.expirada"),

	/**
	 * Constante de la enumeracion para definir el item: NOMBRE_MODELO_MINUTA.
	 */
	NOMBRE_MODELO_MINUTA("nombre.modelo.existente"),

	/**
	 * Constante de la enumeracion para definir el item:
	 * NUMERO_MATRICULA_NO_ENCONTRADO.
	 */
	NUMERO_MATRICULA_NO_ENCONTRADO("matricula.no.encontrada"),

	/**
	 * Constante de la enumeracion para definir el item: ERROR_ARCHIVO.
	 */
	ERROR_ARCHIVO("archivo.lectura"),

	/**
	 * Constante de la enumeracion para definir el item: ARCHIVO_REQUERIDO.
	 */
	ARCHIVO_REQUERIDO("archivo.requerido"),

	/**
	 * Constante de la enumeracion para definir el item: MENSAJE_GROWL.
	 */
	MENSAJE_GROWL("json.mensaje"),

	/**
	 * Constante de la enumeracion para definir el item: DATOS_SOAP_INCORRECTOS.
	 */
	DATOS_SOAP_INCORRECTOS("datos.soap.incorrectos"),

	/**
	 * Constante de la enumeracion para definir el item: ASOCIACION_INEXISTENTE.
	 */
	ASOCIACION_INEXISTENTE("login.incorrecto.asociacion"),

	/**
	 * Constante de la enumeracion para definir el item: PERFIL_INCORRECTO.
	 */
	PERFIL_INCORRECTO("recuperacion.perfil.incorrecto"),

	/**
	 * Constante de la enumeracion para definir el item: ENVIO_EXITOSO_CORREO.
	 */
	ENVIO_EXITOSO_CORREO("recuperacion.perfil.correo"),

	/**
	 * Constante de la enumeracion para definir el item: DOMINIO_CORREO_INVALIDO.
	 */
	DOMINIO_CORREO_INVALIDO("dominio.correo.invalido"),

	/**
	 * Constante de la enumeracion para definir el item: USUARIO_ADMIN_INVALIDO.
	 */
	USUARIO_ADMIN_INVALIDO("usuario.admin.invalido"),
	
	/**
	 * Constante de la enumeracion para definir el item: ACTUALIZACION_FALLIDA.
	 */
	ACTUALIZACION_FALLIDA("usuario.actualizacion.fallida");

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * codigo error.
	 */
	private final String is_codigoError;

	/**
	 * Define la constante NOMBRE_BUNDLE.
	 */
	public static final String NOMBRE_BUNDLE = "excepcion_%s";

	/**
	 * Consultar enum.
	 *
	 * @param as_nombreEnum el parametro nombre enum
	 * @return Resultado para consultar enum retornado como EnumExcepcionesGenerales
	 */
	public static EnumExcepcionesGenerales consultarEnum(String as_nombreEnum) {
		for (EnumExcepcionesGenerales leeg_excepciones : EnumExcepcionesGenerales.values()) {
			if (as_nombreEnum.equals(leeg_excepciones.name())) {
				return leeg_excepciones;
			}
		}
		return null;
	}

	/**
	 * Consultar enum codigo error.
	 *
	 * @param as_codigoError el parametro codigo error
	 * @return Resultado para consultar enum codigo error retornado como
	 *         EnumExcepcionesGenerales
	 */
	public static EnumExcepcionesGenerales consultarEnumCodigoError(String as_codigoError) {
		for (EnumExcepcionesGenerales leeg_excepciones : EnumExcepcionesGenerales.values()) {
			if (as_codigoError.equals(leeg_excepciones.consultarIs_codigo())) {
				return leeg_excepciones;
			}
		}
		return null;
	}

	/**
	 * Construye una nueva instancia/objeto de la clase EnumExcepcionesGenerales.
	 *
	 * @param as_codigoError el parametro codigo error
	 */
	private EnumExcepcionesGenerales(String as_codigoError) {
		this.is_codigoError = as_codigoError;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.gov.supernotariado.bachue.calidaddatos.exception.IEnumCatalogoMensajes#
	 * consultarIs_nombreArchivo()
	 */
	public String consultarIs_nombreArchivo() {
		return NOMBRE_BUNDLE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.gov.supernotariado.bachue.calidaddatos.exception.IEnumCatalogoMensajes#
	 * consultarIs_codigo()
	 */
	public String consultarIs_codigo() {
		return is_codigoError;
	}

}
