/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: EnumOperacionesWs.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.enums
 * Nombre del elemento: EnumOperacionesWs
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.enums;

/**
 * Enumeracion para definir el grupo de constantes para Operaciones ws. <br>
 * Enum que tiene todas las operaciones de servicios, agrupadas por el servicio
 * que las utiliza
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public enum EnumOperacionesWs {

	/**
	 * Constante de la enumeracion para definir el item: CONSULTAR_SESION.
	 */
	CONSULTAR_SESION(EnumServiciosWs.CONSULTAR_SESION, "consultarSesion"),

	/**
	 * Constante de la enumeracion para definir el item: OBTENER_ROLES_COMPONENTES.
	 */
	OBTENER_ROLES_COMPONENTES(EnumServiciosWs.OBTENER_ROLES_COMPONENTES, "ObtenerRolesComponentes");

	/**
	 * Atributo de instancia tipo EnumServiciosWs para definir la propiedad enum
	 * servicio ws.
	 */
	private final EnumServiciosWs iesw_enumServicioWs;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * nombre servicio.
	 */
	private final String is_nombreServicio;

	/**
	 * Construye una nueva instancia/objeto de la clase EnumOperacionesWs.
	 *
	 * @param aesw_enumServicioWs el parametro enum servicio ws
	 * @param as_nombreParametro  el parametro nombre parametro
	 */
	private EnumOperacionesWs(EnumServiciosWs aesw_enumServicioWs, String as_nombreParametro) {
		this.iesw_enumServicioWs = aesw_enumServicioWs;
		this.is_nombreServicio = as_nombreParametro;
	}

	/**
	 * Obtiene el valor para la propiedad nombre servicio.
	 *
	 * @return El valor de la propiedad nombre servicio
	 */
	public String getIs_nombreServicio() {
		return is_nombreServicio;
	}

	/**
	 * Obtiene el valor para la propiedad enum servicio ws.
	 *
	 * @return El valor de la propiedad enum servicio ws
	 */
	public EnumServiciosWs getIesw_enumServicioWs() {
		return iesw_enumServicioWs;
	}

}
