/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: EnumServiciosWs.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.enums
 * Nombre del elemento: EnumServiciosWs
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.enums;

/**
 * Enumeracion para definir el grupo de constantes para Servicios ws.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0 Enum con el numero de la operaciones del servicio de CA
 */
public enum EnumServiciosWs {

	/**
	 * Constante de la enumeracion para definir el item: CONSULTAR_SESION.
	 */
	CONSULTAR_SESION("ConsultarSesion"),

	/**
	 * Constante de la enumeracion para definir el item: OBTENER_ROLES_COMPONENTES.
	 */
	OBTENER_ROLES_COMPONENTES("ObtenerRolesComponentes");

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * operacion.
	 */
	private String is_operacion;

	/**
	 * Construye una nueva instancia/objeto de la clase EnumServiciosWs.
	 *
	 * @param as_operacion el parametro operacion
	 */
	private EnumServiciosWs(final String as_operacion) {
		this.is_operacion = as_operacion;
	}


	/**
	 * Obtiene el valor para la propiedad operacion.
	 *
	 * @return El valor de la propiedad operacion
	 */
	public String getIs_operacion() {
		return is_operacion;
	}

	
}
