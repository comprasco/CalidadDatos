/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: TipoSalidaSesionSalidaWsDtoConverte.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.services.converters
 * Nombre del elemento: TipoSalidaSesionSalidaWsDtoConverte
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.services.converters;

import co.gov.supernotariado.bachue.calidaddatos.dto.ServicioBiometriaDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.SesionEntradaWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.SesionWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoEntradaSesionEntradaWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoSalidaSesionSalidaWSDTO;
import co.gov.supernotariado.bachue.clientebus.vo.biometrico.SesionEntradaVO;
import co.gov.supernotariado.bachue.clientebus.vo.biometrico.SesionVO;
import co.gov.supernotariado.bachue.clientebus.vo.biometrico.TipoEntradaSesionEntradaVO;
import co.gov.supernotariado.bachue.clientebus.vo.biometrico.TipoSalidaSesionSalidaVO;

/**
 * Clase auxiliar(converter) que permite transformar un Value Object (VO, objeto
 * que recibe el cliente de servicios) a un objeto WsDto (Objeto de
 * transferencia de datos de servicio web), y viceversa. <br>
 * Contiene operaciones de transformacion para el VO y el WsDto Tipo salida
 * sesion salida ws dto. <br>
 * Implementa los converter del servicio de consultar sesion
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class TipoSalidaSesionSalidaWsDtoConverte {

	/**
	 * Construye una nueva instancia/objeto de la clase
	 * TipoSalidaSesionSalidaWsDtoConverte.
	 */
	private TipoSalidaSesionSalidaWsDtoConverte() {
		// constructor vacio de modelo
	}

	/**
	 * Metodo que convierte de WSDTO a entidad VO.
	 *
	 * @param atese_tipoEntradaSesionEntradaWsDto el parametro tipo entrada sesion
	 *                                            entrada ws dto
	 * @return Resultado para ws dto A vo retornado como TipoEntradaSesionEntradaVO
	 */
	public static TipoEntradaSesionEntradaVO wsDtoAVo(
			TipoEntradaSesionEntradaWSDTO atese_tipoEntradaSesionEntradaWsDto) {
		TipoEntradaSesionEntradaVO ltese_tipoEntradaSesionEntradaVo = new TipoEntradaSesionEntradaVO();
		ltese_tipoEntradaSesionEntradaVo.setIse_sesionEntradaVo(
				voSesionAEntidad(atese_tipoEntradaSesionEntradaWsDto.getIse_sesionEntradaWsDto()));
		return ltese_tipoEntradaSesionEntradaVo;

	}

	/**
	 * Metodo que convierte de WSDTO a entidad VO.
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
	 * Metodo que convierte de VO a entidad WSDTO.
	 *
	 * @param atsss_tipoSalidaSesionSalidaVo el parametro tipo salida sesion salida
	 *                                       vo
	 * @return Resultado para vo A ws dto retornado como TipoSalidaSesionSalidaWSDTO
	 */
	public static TipoSalidaSesionSalidaWSDTO voAWsDto(TipoSalidaSesionSalidaVO atsss_tipoSalidaSesionSalidaVo) {
		TipoSalidaSesionSalidaWSDTO ltsss_tipoSalidaSesionSalidaWsDto = new TipoSalidaSesionSalidaWSDTO();
		ltsss_tipoSalidaSesionSalidaWsDto.setIs_sesionVo(VoAWsdto(atsss_tipoSalidaSesionSalidaVo.getIs_sesionVo()));
		return ltsss_tipoSalidaSesionSalidaWsDto;

	}
	
	public static SesionWSDTO VoAWsdto (SesionVO ase_sesionEntradaVo)
	{
		SesionWSDTO ls_sesionWsdto = new SesionWSDTO();
		ls_sesionWsdto.setIs_sesion(ase_sesionEntradaVo.getIs_sesion());
		ls_sesionWsdto.setIb_resultado(ase_sesionEntradaVo.getIb_resultado());
		ls_sesionWsdto.setIs_codigo(ase_sesionEntradaVo.getIs_codigo());
		ls_sesionWsdto.setIs_mensaje(ase_sesionEntradaVo.getIs_mensaje());
		return ls_sesionWsdto;
	}

	/**
	 * Metodo que convierte de ServicioBiometriaDTO a SesionEntradaWSDTO.
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
