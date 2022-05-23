/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: EnumUrl.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.enums
 * Nombre del elemento: EnumUrl
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.enums;

/**
 * Enumeracion para definir el grupo de constantes para Url.
 *
 * @author Smartsoft Solutions S.A.S Nota: Enum de url Enum que contiene la url
 *         de calida de datos
 * @version 1.0
 */
public enum EnumUrl {

	/**
	 * Constante de la enumeracion para definir el item: INICIO_SESION_USUARIO.
	 */
	INICIO_SESION_USUARIO("/pages/corregir/calidad_de_datos.jsf");

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad url
	 * inicio sesion.
	 */
	private final String is_urlInicioSesion;

	/**
	 * Construye una nueva instancia/objeto de la clase EnumUrl.
	 *
	 * @param as_urlInicioSesion el parametro url inicio sesion
	 */
	private EnumUrl(String as_urlInicioSesion) {

		this.is_urlInicioSesion = as_urlInicioSesion;

	}

	/**
	 * Metodo para consultar enum por nombre.
	 *
	 * @param as_nombreEnum el parametro nombre enum
	 * @return Resultado para consultar enum nombre retornado como EnumUrl
	 */
	public static EnumUrl consultarEnumNombre(String as_nombreEnum) {
		for (EnumUrl leis_enumInicio : EnumUrl.values()) {
			if (leis_enumInicio.name().equals(as_nombreEnum)) {
				return leis_enumInicio;
			}
		}
		return null;
	}

	/**
	 * Obtiene el valor para la propiedad url inicio sesion.
	 *
	 * @return El valor de la propiedad url inicio sesion
	 */
	public String getIs_urlInicioSesion() {
		return is_urlInicioSesion;
	}
}
