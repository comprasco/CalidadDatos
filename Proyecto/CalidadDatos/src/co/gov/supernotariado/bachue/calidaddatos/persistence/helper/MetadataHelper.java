/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: MetadataHelper.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.persistence.helper
 * Nombre del elemento: MetadataHelper
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */

package co.gov.supernotariado.bachue.calidaddatos.persistence.helper;

import co.gov.supernotariado.bachue.calidaddatos.dto.MetadataDTO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.MetadataVO;

/**
 * Clase auxiliar(helper) que permite transformar objetos de DTO(Data Transfer
 * Object) a Entidades de persistencia y viceversa. <br>
 * Contiene operaciones de transformacion para el DTO y la entidad Metadata.
 * <br>
 * Clase utlizada hacer uso de los helper de MetadataHelper
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class MetadataHelper {

	/**
	 * Metodo constructor vacio para modelo DTO.
	 */
	private MetadataHelper() {
		// Metodo constructor vacio para modelo DTO
	}

	/**
	 * Metodo que convierte un vo a una dto incluyendo relaciones.
	 *
	 * @param am_metadata el parametro metadata
	 * @return Resultado para metadata DTO completo retornado como MetadataDTO
	 */
	public static MetadataDTO metadataDTOCompleto(MetadataVO am_metadata) {
		MetadataDTO lm_metadataDto = new MetadataDTO();
		lm_metadataDto.setIs_nombreTabla(am_metadata.getIs_nombreTabla());
		lm_metadataDto.setIs_nombreColumna(am_metadata.getIs_nombreColumna());
		lm_metadataDto.setIs_largoCampo(am_metadata.getIs_largoCampo());
		lm_metadataDto.setIs_tipoDato(am_metadata.getIs_tipoDato());
		return lm_metadataDto;
	}

	/**
	 * Metodo que convierte un dto a una vo incluyendo relaciones.
	 *
	 * @param am_metadataDto el parametro metadata dto
	 * @return Resultado para dto A vo retornado como MetadataVO
	 */
	public static MetadataVO dtoAVo(MetadataDTO am_metadataDto) {
		MetadataVO lm_metadataVo = new MetadataVO();
		lm_metadataVo.setIs_nombreTabla(am_metadataDto.getIs_nombreTabla());
		lm_metadataVo.setIs_nombreColumna(am_metadataDto.getIs_nombreColumna());
		lm_metadataVo.setIs_largoCampo(am_metadataDto.getIs_largoCampo());
		lm_metadataVo.setIs_tipoDato(am_metadataDto.getIs_tipoDato());
		return lm_metadataVo;
	}

}
