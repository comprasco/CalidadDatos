/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: TipoSalidaSesionSalidaWSDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.services.wsdto
 * Nombre del elemento: TipoSalidaSesionSalidaWSDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.services.wsdto;


import co.gov.supernotariado.bachue.calidaddatos.dto.GenericoDTO;

/**
 * Clase tipo objeto de transferencia de datos para web service (WSDTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y servicios web.
 * <br>
 * Contiene propiedades para representar los datos del objeto Tipo salida sesion
 * salida.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class TipoSalidaSesionSalidaWSDTO extends GenericoDTO {

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo de instancia tipo SesionVO para definir la propiedad sesion vo.
	 */
	private SesionWSDTO is_sesionVo;
	
	/**
	 * Obtiene el valor para la propiedad sesion vo.
	 *
	 * @return El valor de la propiedad sesion vo
	 */
	
	public SesionWSDTO getIs_sesionVo() {
		return is_sesionVo;
	}
	/**
	 * Cambia/actualiza el valor para la propiedad sesion vo.
	 *
	 * @param as_sesionVo el nuevo valor para la propiedad sesion vo
	 */

	public void setIs_sesionVo(SesionWSDTO is_sesionVo) {
		this.is_sesionVo = is_sesionVo;
	}



	
}
