/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InconsistenciaHelper.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.persistence.helper
 * Nombre del elemento: InconsistenciaHelper
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.persistence.helper;

import co.gov.supernotariado.bachue.calidaddatos.dto.InconsistenciaDTO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.InconsistenciaVO;

/**
 * Clase auxiliar(helper) que permite transformar objetos de DTO(Data Transfer
 * Object) a Entidades de persistencia y viceversa. <br>
 * Contiene operaciones de transformacion para el DTO y la entidad
 * Inconsistencia. <br>
 * Clase utlizada hacer uso de los helper de inconsistencia
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class InconsistenciaHelper 
{
	
	/**
	 * Construye una nueva instancia/objeto de la clase InconsistenciaHelper.
	 */
	private InconsistenciaHelper()
	{
		//constructor vacio de modelo
	}
	
	/**
	 * Metodo que convierte de voAdto.
	 *
	 * @param ai_inconsistenciaVo el parametro inconsistencia VO
	 * @return Resultado para inconsistencia DTO completo retornado como
	 *         InconsistenciaDTO
	 */
	public static InconsistenciaDTO inconsistenciaDTOCompleto(InconsistenciaVO ai_inconsistenciaVo)
	{
		InconsistenciaDTO li_inconsistenciaDto = new InconsistenciaDTO();
		
		li_inconsistenciaDto.setIi_idInconsistencia(ai_inconsistenciaVo.getIi_idInconsistencia());
		li_inconsistenciaDto.setIi_idEjecucion(ai_inconsistenciaVo.getIi_idEjecucion());
		li_inconsistenciaDto.setIs_idCirculo(ai_inconsistenciaVo.getIs_idCirculo());
		li_inconsistenciaDto.setIi_idModulo(ai_inconsistenciaVo.getIi_idModulo());
		li_inconsistenciaDto.setIs_tablaDestino(ai_inconsistenciaVo.getIs_tablaDestino());
		li_inconsistenciaDto.setIi_procesadoRegistro(ai_inconsistenciaVo.getIi_procesadoRegistro());
		li_inconsistenciaDto.setIs_idUsuarioCreacion(ai_inconsistenciaVo.getIs_idUsuarioCreacion());
		li_inconsistenciaDto.setId_fechaCreacion(ai_inconsistenciaVo.getId_fechaCreacion());
		
		return li_inconsistenciaDto;
	}
}