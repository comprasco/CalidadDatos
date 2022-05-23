/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: TipoInconsistenciaHelper.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.persistence.helper
 * Nombre del elemento: TipoInconsistenciaHelper
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.persistence.helper;

import java.util.ArrayList;
import java.util.List;

import co.gov.supernotariado.bachue.calidaddatos.dto.TipoInconsistenciaDTO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.TipoInconsistenciaVO;

/**
 * Clase auxiliar(helper) que permite transformar objetos de DTO(Data Transfer
 * Object) a Entidades de persistencia y viceversa. <br>
 * Contiene operaciones de transformacion para el DTO y la entidad Tipo
 * inconsistencia. <br>
 * Clase utlizada hacer uso de los helper de TipoInconsistenciaHelper
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class TipoInconsistenciaHelper {
	
	/**
	 * Construye una nueva instancia/objeto de la clase TipoInconsistenciaHelper.
	 */
	private  TipoInconsistenciaHelper()
	{
		//constructor vacio de modelo
	}
	
	/**
	 * Metodo que convierte un Vo a una Dto incluyendo relaciones.
	 *
	 * @param ati_tipoInconsistenciaVo el parametro tipo inconsistencia vo
	 * @return Resultado para completo tipo inconsistencia DTO retornado como
	 *         TipoInconsistenciaDTO
	 */
	public static TipoInconsistenciaDTO completoTipoInconsistenciaDTO(TipoInconsistenciaVO ati_tipoInconsistenciaVo) {
		TipoInconsistenciaDTO lti_tipoInconsistenciaDto = new TipoInconsistenciaDTO();
		lti_tipoInconsistenciaDto.setIs_idTipoInconsistencia(ati_tipoInconsistenciaVo.getIs_idTipoInconsistencia());
		lti_tipoInconsistenciaDto.setIs_descripcion(ati_tipoInconsistenciaVo.getIs_descripcion());
		lti_tipoInconsistenciaDto.setIs_activo(ati_tipoInconsistenciaVo.getIs_activo());
		
		return lti_tipoInconsistenciaDto;
	} 
	
	/**
	 * Metodo que convierte una lista Vo a una lista de Dto.
	 *
	 * @param alti_tipoInconsistencia el parametro tipo inconsistencia
	 * @return Resultado para lista tipo inconsistencia DTO retornado como una lista
	 *         de TipoInconsistenciaDTO
	 */
	public static List<TipoInconsistenciaDTO> listaTipoInconsistenciaDTO(List<TipoInconsistenciaVO> alti_tipoInconsistencia){
		List<TipoInconsistenciaDTO> llti_tipoInconsistenciaDto = new ArrayList<>();
		for(TipoInconsistenciaVO obj: alti_tipoInconsistencia) {
			llti_tipoInconsistenciaDto.add(completoTipoInconsistenciaDTO(obj));
		}
		return llti_tipoInconsistenciaDto;
	}
}
