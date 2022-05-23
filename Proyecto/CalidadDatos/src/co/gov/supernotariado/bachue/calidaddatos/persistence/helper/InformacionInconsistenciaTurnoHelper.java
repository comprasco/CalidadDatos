/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InformacionInconsistenciaTurnoHelper.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.persistence.helper
 * Nombre del elemento: InformacionInconsistenciaTurnoHelper
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.persistence.helper;

import java.util.ArrayList;
import java.util.List;

import co.gov.supernotariado.bachue.calidaddatos.dto.InformacionInconsistenciaDTO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.InformacionInconsistenciaTurnoVO;

/**
 * Clase auxiliar(helper) que permite transformar objetos de DTO(Data Transfer
 * Object) a Entidades de persistencia y viceversa. <br>
 * Contiene operaciones de transformacion para el DTO y la entidad Informacion
 * inconsistencia turno. <br>
 * Clase utlizada hacer uso de los helper de InformacionInconsistenciaTurnoHelper
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class InformacionInconsistenciaTurnoHelper {
	
	/**
	 * Construye una nueva instancia/objeto de la clase
	 * InformacionInconsistenciaTurnoHelper.
	 */
	private  InformacionInconsistenciaTurnoHelper()
	{
		//constructor vacio de modelo
	}
	
	/**
	 * Metodo que convierte de VoADto.
	 *
	 * @param aii_informacionInconsistenciaTurnoVo el parametro informacion
	 *                                             inconsistencia turno vo
	 * @return Resultado para completo informacion inconsistencia DTO retornado como
	 *         InformacionInconsistenciaDTO
	 */
	public static InformacionInconsistenciaDTO completoInformacionInconsistenciaDTO(InformacionInconsistenciaTurnoVO aii_informacionInconsistenciaTurnoVo) {
		InformacionInconsistenciaDTO lii_informacionInconsistenciaDto = new InformacionInconsistenciaDTO();
		
		
		lii_informacionInconsistenciaDto.setIbi_numeroInconsistencia(aii_informacionInconsistenciaTurnoVo.getIbi_numeroInconsistencia());
		lii_informacionInconsistenciaDto.setIbi_numeroTurno(aii_informacionInconsistenciaTurnoVo.getIbi_numeroTurno());
		lii_informacionInconsistenciaDto.setIs_numeroMatricula(aii_informacionInconsistenciaTurnoVo.getIs_numeroMatricula());
		lii_informacionInconsistenciaDto.setIi_idModulo(aii_informacionInconsistenciaTurnoVo.getIi_idModulo());
		lii_informacionInconsistenciaDto.setIm_metadataDto(MetadataHelper.metadataDTOCompleto(aii_informacionInconsistenciaTurnoVo.getIm_metadataVo()));
		lii_informacionInconsistenciaDto.setIs_campo(aii_informacionInconsistenciaTurnoVo.getIs_campo());
		lii_informacionInconsistenciaDto.setIs_nuevoValor(aii_informacionInconsistenciaTurnoVo.getIs_nuevoValor());
		lii_informacionInconsistenciaDto.setIs_procesada(aii_informacionInconsistenciaTurnoVo.getIs_procesada());
		lii_informacionInconsistenciaDto.setIs_tabla(aii_informacionInconsistenciaTurnoVo.getIs_tabla());
		lii_informacionInconsistenciaDto.setIs_tipoInconsistencia(aii_informacionInconsistenciaTurnoVo.getIs_tipoInconsistencia());
		lii_informacionInconsistenciaDto.setIs_valorActual(aii_informacionInconsistenciaTurnoVo.getIs_valorActual());		
		return lii_informacionInconsistenciaDto;
	}
	
	/**
	 * Metodo que convierte de DtoAVo.
	 *
	 * @param aii_informacionInconsistenciaDto el parametro informacion
	 *                                         inconsistencia DTO
	 * @return Resultado para completo informacion inconsistencia VO retornado como
	 *         InformacionInconsistenciaTurnoVO
	 */
	public static InformacionInconsistenciaTurnoVO completoInformacionInconsistenciaVO(InformacionInconsistenciaDTO aii_informacionInconsistenciaDto) {
		
		InformacionInconsistenciaTurnoVO lii_informacionInconsistenciaVo = new InformacionInconsistenciaTurnoVO();
		
		lii_informacionInconsistenciaVo.setIbi_numeroInconsistencia(aii_informacionInconsistenciaDto.getIbi_numeroInconsistencia());
		lii_informacionInconsistenciaVo.setIbi_numeroTurno(aii_informacionInconsistenciaDto.getIbi_numeroTurno());
		lii_informacionInconsistenciaVo.setIs_numeroMatricula(aii_informacionInconsistenciaDto.getIs_numeroMatricula());
		lii_informacionInconsistenciaVo.setIi_idModulo(aii_informacionInconsistenciaDto.getIi_idModulo());
		lii_informacionInconsistenciaVo.setIs_campo(aii_informacionInconsistenciaDto.getIs_campo());
		lii_informacionInconsistenciaVo.setIs_nuevoValor(aii_informacionInconsistenciaDto.getIs_nuevoValor());
		lii_informacionInconsistenciaVo.setIs_procesada(aii_informacionInconsistenciaDto.getIs_procesada());
		lii_informacionInconsistenciaVo.setIs_tabla(aii_informacionInconsistenciaDto.getIs_tabla());
		lii_informacionInconsistenciaVo.setIs_tipoInconsistencia(aii_informacionInconsistenciaDto.getIs_tipoInconsistencia());
		lii_informacionInconsistenciaVo.setIs_valorActual(aii_informacionInconsistenciaDto.getIs_valorActual());
		
		return lii_informacionInconsistenciaVo;
	}
	
	/**
	 * Metodo que convierte una lista dto a una lista de Vo .
	 *
	 * @param alii_informacionInconsistenciaDto el parametro informacion
	 *                                          inconsistencia dto
	 * @return Resultado para lista informacion inconsistencia VO retornado como una
	 *         lista de InformacionInconsistenciaTurnoVO
	 */
	public static List<InformacionInconsistenciaTurnoVO> listaInformacionInconsistenciaVO(List<InformacionInconsistenciaDTO> alii_informacionInconsistenciaDto){
		List<InformacionInconsistenciaTurnoVO> ll_informacionInconsistenciaTurnoVo = new ArrayList<>();
		for(InformacionInconsistenciaDTO obj: alii_informacionInconsistenciaDto) {
			ll_informacionInconsistenciaTurnoVo.add(completoInformacionInconsistenciaVO(obj));
		}
		return ll_informacionInconsistenciaTurnoVo;
	}
	
	/**
	 * Metodo que convierte una lista Vo a una lista de Dto.
	 *
	 * @param alii_informacionInconsistenciaVO el parametro informacion
	 *                                         inconsistencia VO
	 * @return Resultado para lista informacion inconsistencia DTO retornado como
	 *         una lista de InformacionInconsistenciaDTO
	 */
	public static List<InformacionInconsistenciaDTO> listaInformacionInconsistenciaDTO(List<InformacionInconsistenciaTurnoVO> alii_informacionInconsistenciaVO){
		List<InformacionInconsistenciaDTO> ll_informacionInconsistenciaDto = new ArrayList<>();
		for(InformacionInconsistenciaTurnoVO obj: alii_informacionInconsistenciaVO) {
			ll_informacionInconsistenciaDto.add(completoInformacionInconsistenciaDTO(obj));
		}		
		return ll_informacionInconsistenciaDto;
	}
}