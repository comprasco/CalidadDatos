/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: MetadataDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.dto
 * Nombre del elemento: MetadataDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.dto;

import java.io.Serializable;

/**
 * Clase tipo objeto de transferencia de datos (DTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y presentacion.
 * <br>
 * Contiene propiedades para representar los datos del objeto Metadata.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class UtilidadClienteBusDTO implements Serializable{


	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 3980434679425048883L;
	// --- Atributos
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * nombre tabla.
	 */
	private String is_urlWsdlDeviceServices;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * nombre biometria.
	 */
	private String is_webServiceNameBiometria;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * nombre biometria.
	 */
	private String is_nameSpace;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * nombre biometria.
	 */
	public String getIs_urlWsdlDeviceServices() {
		return is_urlWsdlDeviceServices;
	}

	public void setIs_urlWsdlDeviceServices(String is_urlWsdlDeviceServices) {
		this.is_urlWsdlDeviceServices = is_urlWsdlDeviceServices;
	}

	public String getIs_webServiceNameBiometria() {
		return is_webServiceNameBiometria;
	}

	public void setIs_webServiceNameBiometria(String is_webServiceNameBiometria) {
		this.is_webServiceNameBiometria = is_webServiceNameBiometria;
	}

	public String getIs_nameSpace() {
		return is_nameSpace;
	}

	public void setIs_nameSpace(String is_nameSpace) {
		this.is_nameSpace = is_nameSpace;
	}

}
