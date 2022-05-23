/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: TipoEntradaSesionEntradaWSDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.services.wsdto
 * Nombre del elemento: TipoEntradaSesionEntradaWSDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.services.wsdto;

import co.gov.supernotariado.bachue.calidaddatos.dto.GenericoDTO;

/**
 * Clase tipo objeto de transferencia de datos para web service (WSDTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y servicios web.
 * <br>
 * Contiene propiedades para representar los datos del objeto Tipo entrada
 * sesion entrada.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class TipoEntradaSesionEntradaWSDTO  extends GenericoDTO 
{

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo de instancia tipo SesionEntradaWSDTO para definir la propiedad
	 * sesion entrada ws.
	 */
	private SesionEntradaWSDTO ise_sesionEntradaWsDto;

	/**
	 * Obtiene el valor para la propiedad sesion entrada ws dto.
	 *
	 * @return El valor de la propiedad sesion entrada ws dto
	 */
	public SesionEntradaWSDTO getIse_sesionEntradaWsDto() {
		return ise_sesionEntradaWsDto;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad sesion entrada ws dto.
	 *
	 * @param ase_sesionEntradaWsDto el nuevo valor para la propiedad sesion entrada
	 *                               ws dto
	 */
	public void setIse_sesionEntradaWsDto(SesionEntradaWSDTO ase_sesionEntradaWsDto) {
		this.ise_sesionEntradaWsDto = ase_sesionEntradaWsDto;
	}


	
}
