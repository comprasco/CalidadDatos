/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: TipoEntradaObtenerRolesComponenteWsDtoConverter.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.services.converters
 * Nombre del elemento: TipoEntradaObtenerRolesComponenteWsDtoConverter
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.services.converters;

import java.util.ArrayList;
import java.util.List;

import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.RolesWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoEntradaObtenerRolesComponenteWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoSalidaObtenerRolesComponenteWSDTO;
import co.gov.supernotariado.bachue.clientebus.vo.getionusuarios.RolVO;
import co.gov.supernotariado.bachue.clientebus.vo.getionusuarios.TipoEntradaObtenerRolesComponenteVO;
import co.gov.supernotariado.bachue.clientebus.vo.getionusuarios.TipoSalidaObtenerRolesComponenteVO;

/**
 * Clase auxiliar(converter) que permite transformar un Value Object (VO, objeto
 * que recibe el cliente de servicios) a un objeto WsDto (Objeto de
 * transferencia de datos de servicio web), y viceversa. <br>
 * Contiene operaciones de transformacion para el VO y el WsDto Tipo entrada
 * obtener roles componente ws dto. <br>
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class TipoEntradaObtenerRolesComponenteWsDtoConverter {

	/**
	 * Construye una nueva instancia/objeto de la clase
	 * TipoEntradaObtenerRolesComponenteWsDtoConverter.
	 */
	private TipoEntradaObtenerRolesComponenteWsDtoConverter() {
		// constructor vacio de modelo
	}

	/**
	 * Metodo que convierte de WSDTO entidad VO.
	 *
	 * @param ateorc_tipoEntradaObtenerRolesComponenteWsDto el parametro tipo
	 *                                                      entrada obtener roles
	 *                                                      componente ws dto
	 * @return Resultado para vo A entidad retornado como
	 *         TipoEntradaObtenerRolesComponenteVO
	 */
	public static TipoEntradaObtenerRolesComponenteVO voAEntidad(
			TipoEntradaObtenerRolesComponenteWSDTO ateorc_tipoEntradaObtenerRolesComponenteWsDto) {
		TipoEntradaObtenerRolesComponenteVO lteorc_tipoEntradaObtenerRolesComponenteVo = new TipoEntradaObtenerRolesComponenteVO();
		lteorc_tipoEntradaObtenerRolesComponenteVo
				.setIs_componente(ateorc_tipoEntradaObtenerRolesComponenteWsDto.getIs_componente());

		return lteorc_tipoEntradaObtenerRolesComponenteVo;
	}

	/**
	 * Metodo que convierte de entidad VO a WSDTO.
	 *
	 * @param atsorc_tipoSalidaObtenerRolesComponenteVo el parametro tipo salida
	 *                                                  obtener roles componente vo
	 * @return Resultado para entidad A vo retornado como
	 *         TipoSalidaObtenerRolesComponenteWSDTO
	 */
	public static TipoSalidaObtenerRolesComponenteWSDTO entidadAVo(
			TipoSalidaObtenerRolesComponenteVO atsorc_tipoSalidaObtenerRolesComponenteVo) {
		TipoSalidaObtenerRolesComponenteWSDTO ltsorc_tipoSalidaObtenerRolesComponenteWSDto = new TipoSalidaObtenerRolesComponenteWSDTO();
		ltsorc_tipoSalidaObtenerRolesComponenteWSDto
				.setIbi_codigoMensaje(atsorc_tipoSalidaObtenerRolesComponenteVo.getIbi_codigoMensaje());
		ltsorc_tipoSalidaObtenerRolesComponenteWSDto
				.setIs_descripcionMensaje(atsorc_tipoSalidaObtenerRolesComponenteVo.getIs_descripcionMensaje());
		ltsorc_tipoSalidaObtenerRolesComponenteWSDto.setIlr_listaRoles(TipoEntradaObtenerRolesComponenteWsDtoConverter
				.listaEntidadAListaRolVo(atsorc_tipoSalidaObtenerRolesComponenteVo.getIlr_listaRol()));
		return ltsorc_tipoSalidaObtenerRolesComponenteWSDto;
	}

	/**
	 * Metodo que convierte de entidad VO a WSDTO. Se encarga de transformar los
	 * datos de la aplicacion en datos que se usan para el servicios web
	 * ObtenerRolesComponente.
	 *
	 * @param ar_RolVo el parametro rol vo
	 * @return Resultado para entidad A vo retornado como RolesWSDTO
	 */
	public static RolesWSDTO entidadAVo(RolVO ar_RolVo) {
		RolesWSDTO lr_rolesWsDto = new RolesWSDTO();
		lr_rolesWsDto.setIs_codigoRol(ar_RolVo.getIs_codigoRol());
		lr_rolesWsDto.setIs_nombreRol(ar_RolVo.getIs_componente());
		return lr_rolesWsDto;
	}

	/**
	 * Metodo que convierte de lista entidad VO a lista WSDTO. Metodo que se encarga
	 * de transformar los datos de la aplicacion en datos que se usan para el
	 * servicios web ObtenerRolesComponente.
	 *
	 * @param alr_RolVo el parametro rol vo
	 * @return Resultado para lista entidad A lista rol vo retornado como una lista
	 *         de RolesWSDTO
	 */
	public static List<RolesWSDTO> listaEntidadAListaRolVo(List<RolVO> alr_RolVo) {
		List<RolesWSDTO> llr_rolesVo = new ArrayList<>();
		for (RolVO lr_rolVo : alr_RolVo) {
			llr_rolesVo.add(entidadAVo(lr_rolVo));
		}

		return llr_rolesVo;

	}
}
