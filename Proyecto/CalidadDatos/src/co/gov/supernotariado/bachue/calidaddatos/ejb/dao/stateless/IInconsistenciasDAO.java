package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless;

import java.util.List;

import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.dto.InconsistenciaDTO;
/**
*
* @version 1.0
* @author Smartsoft Solutions S.A.S Nota: Interface para la capa
* interfaz para implementacion de IInconsistenciasDAO
*/
@Local
public interface IInconsistenciasDAO 
{
	/**
	 * Metodo que se encarga de realizar un lista de tipo InconsistenciaDTO
	 * @return List<InconsistenciaDTO>
	 */
	public List<InconsistenciaDTO> listaInconsistenciaDto();
}
