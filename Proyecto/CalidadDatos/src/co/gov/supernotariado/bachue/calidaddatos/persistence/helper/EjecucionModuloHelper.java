/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: EjecucionModuloHelper.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.persistence.helper
 * Nombre del elemento: EjecucionModuloHelper
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.persistence.helper;

import co.gov.supernotariado.bachue.calidaddatos.dto.EjecucionModuloDTO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.EjecucionModuloVO;

/**
 * Clase auxiliar(helper) que permite transformar objetos de DTO(Data Transfer
 * Object) a Entidades de persistencia y viceversa. <br>
 * Contiene operaciones de transformacion para el DTO y la entidad Ejecucion
 * modulo. <br>
 * Clase utlizada hacer uso de los helper de ejecucion modulo
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class EjecucionModuloHelper 
{
	
	/**
	 * Construye una nueva instancia/objeto de la clase EjecucionModuloHelper.
	 */
	private  EjecucionModuloHelper()
	{
		//constructor vacio de modelo
	}
	
	/**
	 * Metodo que convierte de voAdto.
	 *
	 * @param aem_ejecucionModuloVo el parametro ejecucion modulo VO
	 * @return Resultado para ejecucion modulo DTO completo retornado como
	 *         EjecucionModuloDTO
	 */
	public static EjecucionModuloDTO ejecucionModuloDTOCompleto(EjecucionModuloVO aem_ejecucionModuloVo)
	{
		EjecucionModuloDTO lem_ejecucionModuloDto = new EjecucionModuloDTO();
		
		lem_ejecucionModuloDto.setIbd_idEjecucion(aem_ejecucionModuloVo.getIbd_idEjecucion());
		lem_ejecucionModuloDto.setIs_idCirculo(aem_ejecucionModuloVo.getIs_idCirculo());
		lem_ejecucionModuloDto.setIbd_idModulo(aem_ejecucionModuloVo.getIbd_idModulo());
		lem_ejecucionModuloDto.setId_fechaInicio(aem_ejecucionModuloVo.getId_fechaInicio());
		lem_ejecucionModuloDto.setId_fechaFin(aem_ejecucionModuloVo.getId_fechaFin());
		lem_ejecucionModuloDto.setIbd_numRegOk(aem_ejecucionModuloVo.getIbd_numRegOk());
		lem_ejecucionModuloDto.setIbd_numRegIncon(aem_ejecucionModuloVo.getIbd_numRegIncon());
		lem_ejecucionModuloDto.setIs_idUsuarioCreacion(aem_ejecucionModuloVo.getIs_idUsuarioCreacion());
		lem_ejecucionModuloDto.setId_fechaCreacion(aem_ejecucionModuloVo.getId_fechaCreacion());
		lem_ejecucionModuloDto.setIs_numRegOrigen(aem_ejecucionModuloVo.getIs_numRegOrigen());
		
		return lem_ejecucionModuloDto;
	}
}


