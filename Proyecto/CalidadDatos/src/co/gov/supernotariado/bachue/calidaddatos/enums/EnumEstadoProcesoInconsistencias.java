/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: EnumEstadoProcesoInconsistencias.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.enums
 * Nombre del elemento: EnumEstadoProcesoInconsistencias
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.enums;

/**
 * Enumeracion para definir el grupo de constantes para Estado proceso
 * inconsistencias. <br>
 * Enum implementado para manejar mensajes de front
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public enum EnumEstadoProcesoInconsistencias {

	/**
	 * Constante de la enumeracion para definir el item: EN_PROCESO.
	 */
	EN_PROCESO("En proceso"),

	/**
	 * Constante de la enumeracion para definir el item: USUARIO.
	 */
	USUARIO("Calidad"),
	
	/**
	 * Constante de la enumeracion para definir el item: CALIDAD_DE_DATOS.
	 */
	CALIDAD_DE_DATOS("Calidad de Datos"),
	
	

	/**
	 * Constante de la enumeracion para definir el item: ESTADOC.
	 */
	ESTADOC("C"),

	/**
	 * Constante de la enumeracion para definir el item: ESTADON.
	 */
	ESTADON("N"),

	/**
	 * Constante de la enumeracion para definir el item: FALLIDO.
	 */
	FALLIDO("Fallido"),

	/**
	 * Constante de la enumeracion para definir el item: TERMINO.
	 */
	TERMINO("Termino"),

	/**
	 * Constante de la enumeracion para definir el item:
	 * CORREGIDO_INCONSISTENCIAS_INCOMPLETAS.
	 */
	CORREGIDO_INCONSISTENCIAS_INCOMPLETAS("Corregido inconsistencias incompletas"),
	
	/**
	 * Constante de la enumeracion para definir el item: CAMPOS_VACIOS.
	 */
	CAMPOS_VACIOS("Debe ingresar usuario"),
	
	/**
	 * Constante de la enumeracion para definir el item: MATRICULA_TURNO.
	 */
	MATRICULA_TURNO("Debe ingresar una matricula o un turno"),
	
	/**
	 * Constante de la enumeracion para definir el item: MATRICULA_TURNO_ERROR.
	 */
	MATRICULA_TURNO_ERROR("Solo puede ingresar una combinacion  (Matricula o Turno)"),

	/**
	 * Constante de la enumeracion para definir el item: CAMPOS_ERROR.
	 */
	CAMPOS_ERROR("Contraseña incorrecta"),
	/**
	 * Constante de la enumeracion para definir el item: PROCEDIMIENTO_EXITOSO.
	 */
	PROCEDIMIENTO_EXITOSO("Procedimiento termino exitoso"),
	/**
	 * Constante de la enumeracion para definir el item: CAMPOS_REQUERIDOS.
	 */
	CAMPOS_REQUERIDOS("Los campos son obligatorios"),
	/**
	 * Constante de la enumeracion para definir el item: CAMPOS_GUARDADOS.
	 */
	CAMPOS_GUARDADOS("Informacion guardada de manera exitosa"),

	/**
	 * Constante de la enumeracion para definir el item: ORIPTURNO.
	 */
	ORIPTURNO("Solo puede ingresar una combinacion  (Matricula o Turno)"),

	/**
	 * Constante de la enumeracion para definir el item: ORIPMATRICULA.
	 */
	ORIPMATRICULA("Debe ingresar o una matricula o un turno"),

	/**
	 * Constante de la enumeracion para definir el item: ORIP.
	 */
	ORIP("Debe seleccionar una ORIP\\n"),

	/**
	 * Constante de la enumeracion para definir el item:
	 * CORREGIDO_INCONSISTENCIAS_COMPLETAS.
	 */
	CORREGIDO_INCONSISTENCIAS_COMPLETAS("Corregido inconsistencias completas");

	// --- Atributos
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * descripcion.
	 */
	private String is_descripcion;

	/**
	 * Construye una nueva instancia/objeto de la clase
	 * EnumEstadoProcesoInconsistencias.
	 *
	 * @param is_descripcion el parametro descripcion
	 */
	private EnumEstadoProcesoInconsistencias(final String is_descripcion) {
		this.is_descripcion = is_descripcion;
	}


	/**
	 * Obtiene el valor para la propiedad descripcion.
	 *
	 * @return El valor de la propiedad descripcion
	 */
	// --- Getters-Setters
	public String getIs_descripcion() {
		return is_descripcion;
	}



}
