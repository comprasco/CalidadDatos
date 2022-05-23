/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: IIconsistenciasDAO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless
 * Nombre del elemento: IIconsistenciasDAO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless;

import java.util.List;

import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.dto.InconsistenciaDTO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.InconsistenciaVO;

/**
 * Interface para definir operaciones sobre objetos de acceso a datos (DAO) <br>
 * Define operaciones para manipular el modelo de datos Iconsistencias.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface IIconsistenciasDAO 
{
	
	/**
	 * Metodo que se encarga de realizar un lista de tipo InconsistenciaDTO.
	 *
	 * @return Resultado para inconsistencia DTO retornado como una lista de
	 *         InconsistenciaDTO
	 */
	public List<InconsistenciaDTO> inconsistenciaDTO();
	
	/**
	 * Metodo que se implementa para saber las inconsistencias.
	 *
	 * @param as_nombreTabla nombre de la tabla
	 * @param as_nombreCampo nombre del campo
	 * @return Resultado para inconsistencia VO retornado como InconsistenciaVO
	 */
	public InconsistenciaVO inconsistenciaVO(String as_nombreTabla,String as_nombreCampo);
	
}
