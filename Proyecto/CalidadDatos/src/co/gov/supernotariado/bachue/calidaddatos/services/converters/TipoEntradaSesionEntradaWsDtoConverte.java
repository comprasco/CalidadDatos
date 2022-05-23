/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: TipoEntradaSesionEntradaWsDtoConverte.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.services.converters
 * Nombre del elemento: TipoEntradaSesionEntradaWsDtoConverte
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.services.converters;

import co.gov.supernotariado.bachue.calidaddatos.dto.ServicioBiometriaDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.SesionEntradaWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoEntradaSesionEntradaWSDTO;
import co.gov.supernotariado.bachue.clientebus.vo.biometrico.SesionEntradaVO;
import co.gov.supernotariado.bachue.clientebus.vo.biometrico.TipoEntradaSesionEntradaVO;

/**
 * Clase auxiliar(converter) que permite transformar un Value Object (VO, objeto
 * que recibe el cliente de servicios) a un objeto WsDto (Objeto de
 * transferencia de datos de servicio web), y viceversa. <br>
 * Contiene operaciones de transformacion para el VO y el WsDto Tipo entrada
 * sesion ws dto. <br>
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class TipoEntradaSesionEntradaWsDtoConverte {
	
	/**
	 * Construye una nueva instancia/objeto de la clase
	 * TipoEntradaSesionEntradaWsDtoConverte.
	 */
	private TipoEntradaSesionEntradaWsDtoConverte() {
		// constructor vacio de modelo
	}

	/**
	 * Metodo que convierte de WSDTO a VO.
	 *
	 * @param atese_tipoEntradaSesionEntradaWsDto el parametro tipo entrada sesion
	 *                                            entrada ws dto
	 * @return Resultado para vo A entidad retornado como TipoEntradaSesionEntradaVO
	 */
	public static TipoEntradaSesionEntradaVO voAEntidad(
			TipoEntradaSesionEntradaWSDTO atese_tipoEntradaSesionEntradaWsDto) {
		TipoEntradaSesionEntradaVO ltese_tipoEntradaSesionEntradaVo = new TipoEntradaSesionEntradaVO();
		ltese_tipoEntradaSesionEntradaVo.setIse_sesionEntradaVo(
				voSesionAEntidad(atese_tipoEntradaSesionEntradaWsDto.getIse_sesionEntradaWsDto()));
		return ltese_tipoEntradaSesionEntradaVo;

	}

	/**
	 * Metodo que convierte de WSDTO a VO.
	 *
	 * @param ase_sesionEntradaVo el parametro sesion entrada vo
	 * @return Resultado para vo sesion A entidad retornado como SesionEntradaVO
	 */
	public static SesionEntradaVO voSesionAEntidad(SesionEntradaWSDTO ase_sesionEntradaVo) {
		SesionEntradaVO lse_sesionEntradaDto = new SesionEntradaVO();
		lse_sesionEntradaDto.setIs_sesion(ase_sesionEntradaVo.getIs_sesion());
		return lse_sesionEntradaDto;
	}


	/**
	 * Metodo que convierte de ServicioBiometricoDTO a SesionEntradaWSDTO.
	 *
	 * @param ase_sesionEntradaWsDto el parametro sesion entrada ws dto
	 * @return Resultado para servicio biometrico A sesion retornado como
	 *         SesionEntradaWSDTO
	 */
	public static SesionEntradaWSDTO servicioBiometricoASesion(ServicioBiometriaDTO ase_sesionEntradaWsDto) {
		SesionEntradaWSDTO lsb_servicioBiometriaDto = new SesionEntradaWSDTO();
		lsb_servicioBiometriaDto.setIs_sesion(ase_sesionEntradaWsDto.getIs_sesion());
		return lsb_servicioBiometriaDto;
	}

}
