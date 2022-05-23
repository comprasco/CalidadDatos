/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ILInconsistenciaCampoTurnoDAO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless
 * Nombre del elemento: ILInconsistenciaCampoTurnoDAO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless;

import java.util.List;

import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.InformacionInconsistenciaTurnoVO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.InformacionInconsistenciaVO;

/**
 * Interface para definir operaciones sobre objetos de acceso a datos (DAO) <br>
 * Define operaciones para manipular el modelo de datos inconsistencia campo
 * turno.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface IInconsistenciaCampoTurnoDAO {

	/**
	 * Consultar informacion inconsistencia turno VO(Value Object).
	 *
	 * @param acid_consultaInconsistenciasDTO el parametro consulta inconsistencias
	 *                                        DTO
	 * @return Resultado para consultar informacion inconsistencia turno VO
	 *         retornado como una lista de InformacionInconsistenciaTurnoVO
	 */

	public List<InformacionInconsistenciaTurnoVO> consultarInformacionInconsistenciaTurnoVO(ConsultaInconsistenciasDTO acid_consultaInconsistenciasDTO ); 
	
	/**
	 * Metodo que guarda la informacion ingresada por el usuario para resolver las
	 * incidencias.
	 *
	 * @param informacionInconsistenciaVO el parametro informacion inconsistencia VO
	 * @return true, si se cumple o la accion se realiza exitosamente, false en caso
	 *         contrario.
	 */
	  public Boolean guardaInconsistencia(InformacionInconsistenciaVO informacionInconsistenciaVO);


}


