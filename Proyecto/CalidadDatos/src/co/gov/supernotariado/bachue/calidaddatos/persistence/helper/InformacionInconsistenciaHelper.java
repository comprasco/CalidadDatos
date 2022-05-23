/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InformacionInconsistenciaHelper.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.persistence.helper
 * Nombre del elemento: InformacionInconsistenciaHelper
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.persistence.helper;

import java.util.ArrayList;
import java.util.List;

import co.gov.supernotariado.bachue.calidaddatos.dto.InformacionInconsistenciaDTO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.InformacionInconsistenciaVO;

/**
 * Clase auxiliar(helper) que permite transformar objetos de DTO(Data Transfer
 * Object) a Entidades de persistencia y viceversa. <br>
 * Contiene operaciones de transformacion para el DTO y la entidad Informacion
 * inconsistencia. <br>
 * Clase utlizada hacer uso de los helper de Informacion inconsistencia
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class InformacionInconsistenciaHelper {

	/**
	 * Construye una nueva instancia/objeto de la clase
	 * InformacionInconsistenciaHelper.
	 */
	private  InformacionInconsistenciaHelper()
	{
		//constructor vacio de modelo
	}
	
	/**
	 * Metodo que convierte de voAdto.
	 *
	 * @param aii_informacionInconsistenciaVo el parametro informacion
	 *                                        inconsistencia VO
	 * @return Resultado para completo informacion inconsistencia DTO retornado como
	 *         InformacionInconsistenciaDTO
	 */
	public static InformacionInconsistenciaDTO completoInformacionInconsistenciaDTO(InformacionInconsistenciaVO aii_informacionInconsistenciaVo) {
		InformacionInconsistenciaDTO lii_informacionInconsistenciaDto = new InformacionInconsistenciaDTO();
		lii_informacionInconsistenciaDto.setIbi_numeroInconsistencia(aii_informacionInconsistenciaVo.getIbi_numeroInconsistencia());
		lii_informacionInconsistenciaDto.setIs_numeroMatricula(aii_informacionInconsistenciaVo.getIs_numeroMatricula());
		lii_informacionInconsistenciaDto.setIi_idModulo(aii_informacionInconsistenciaVo.getIi_idModulo());
		lii_informacionInconsistenciaDto.setIm_metadataDto(MetadataHelper.metadataDTOCompleto(aii_informacionInconsistenciaVo.getIm_metadataVo()));
		lii_informacionInconsistenciaDto.setIs_campo(aii_informacionInconsistenciaVo.getIs_campo());
		lii_informacionInconsistenciaDto.setIs_nuevoValor(aii_informacionInconsistenciaVo.getIs_nuevoValor());
		lii_informacionInconsistenciaDto.setIs_procesada(aii_informacionInconsistenciaVo.getIs_procesada());
		lii_informacionInconsistenciaDto.setIs_tabla(aii_informacionInconsistenciaVo.getIs_tabla());
		lii_informacionInconsistenciaDto.setIs_tipoInconsistencia(aii_informacionInconsistenciaVo.getIs_tipoInconsistencia());
		lii_informacionInconsistenciaDto.setIs_valorActual(aii_informacionInconsistenciaVo.getIs_valorActual());
		lii_informacionInconsistenciaDto.setIs_observaciones(aii_informacionInconsistenciaVo.getIs_observaciones());
		lii_informacionInconsistenciaDto.setIs_observacionesnc(aii_informacionInconsistenciaVo.getIs_observacionesnc());
		return lii_informacionInconsistenciaDto;
	}
	
	/**
	 * Metodo que convierte de dtoAvo.
	 *
	 * @param aii_informacionInconsistenciaDto el parametro informacion
	 *                                         inconsistencia DTO
	 * @return Resultado para completo informacion inconsistencia VO retornado como
	 *         InformacionInconsistenciaVO
	 */
	public static InformacionInconsistenciaVO completoInformacionInconsistenciaVO(InformacionInconsistenciaDTO aii_informacionInconsistenciaDto) {
		
		InformacionInconsistenciaVO lii_informacionInconsistenciaVo = new InformacionInconsistenciaVO();
		
		lii_informacionInconsistenciaVo.setIbi_numeroInconsistencia(aii_informacionInconsistenciaDto.getIbi_numeroInconsistencia());
		lii_informacionInconsistenciaVo.setIs_numeroMatricula(aii_informacionInconsistenciaDto.getIs_numeroMatricula());
		lii_informacionInconsistenciaVo.setIi_idModulo(aii_informacionInconsistenciaDto.getIi_idModulo());
		lii_informacionInconsistenciaVo.setIs_campo(aii_informacionInconsistenciaDto.getIs_campo());
		lii_informacionInconsistenciaVo.setIs_nuevoValor(aii_informacionInconsistenciaDto.getIs_nuevoValor());
		lii_informacionInconsistenciaVo.setId_fecha(aii_informacionInconsistenciaDto.getId_fechaNueva());
		lii_informacionInconsistenciaVo.setIs_procesada(aii_informacionInconsistenciaDto.getIs_procesada());
		lii_informacionInconsistenciaVo.setIs_tabla(aii_informacionInconsistenciaDto.getIs_tabla());
		lii_informacionInconsistenciaVo.setIs_tipoInconsistencia(aii_informacionInconsistenciaDto.getIs_tipoInconsistencia());
		lii_informacionInconsistenciaVo.setIs_valorActual(aii_informacionInconsistenciaDto.getIs_valorActual());
		lii_informacionInconsistenciaVo.setIs_observaciones(aii_informacionInconsistenciaDto.getIs_observaciones());
		lii_informacionInconsistenciaVo.setIs_observacionesnc(aii_informacionInconsistenciaDto.getIs_observacionesnc());
		lii_informacionInconsistenciaVo.setIm_metadataVo(MetadataHelper.dtoAVo(aii_informacionInconsistenciaDto.getIm_metadataDto()));
		
		return lii_informacionInconsistenciaVo;
	}
	
	/**
	 * Metodo que lista la informacion de la inconsistencias.
	 *
	 * @param alii_informacionInconsistenciaDto el parametro informacion
	 *                                          inconsistencia dto
	 * @return Resultado para listar informacion inconsistencia VO retornado como una
	 *         lista de InformacionInconsistenciaVO
	 */
	public static List<InformacionInconsistenciaVO> listaInformacionInconsistenciaVO(List<InformacionInconsistenciaDTO> alii_informacionInconsistenciaDto){
		List<InformacionInconsistenciaVO> llii_listVo = new ArrayList<>();
		for(InformacionInconsistenciaDTO obj: alii_informacionInconsistenciaDto) {
			llii_listVo.add(completoInformacionInconsistenciaVO(obj));
		}
		return llii_listVo;
	}
	
	/**
	 * Metodo que lista las inconsistencias de tipo InformacionInconsistenciaDTO.
	 *
	 * @param alii_informacionInconsistenciaVo el parametro informacion
	 *                                         inconsistencia VO
	 * @return Resultado para listar informacion inconsistencia DTO retornado como
	 *         una lista de InformacionInconsistenciaDTO
	 */
	public static List<InformacionInconsistenciaDTO> listaInformacionInconsistenciaDTO(List<InformacionInconsistenciaVO> alii_informacionInconsistenciaVo){
		List<InformacionInconsistenciaDTO> llic_listDTo = new ArrayList<>();
		for(InformacionInconsistenciaVO obj: alii_informacionInconsistenciaVo) {
			llic_listDTo.add(completoInformacionInconsistenciaDTO(obj));
		}
		
		return llic_listDTo;
	}
}
