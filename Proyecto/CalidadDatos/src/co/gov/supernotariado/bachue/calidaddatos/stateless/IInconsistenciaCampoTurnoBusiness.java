/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ILInconsistenciaCampoTurnoBusiness.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless
 * Nombre del elemento: ILInconsistenciaCampoTurnoBusiness
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.stateless;

import java.util.List;

import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO;
import co.gov.supernotariado.bachue.calidaddatos.dto.InformacionInconsistenciaDTO;

/**
 * Interface de la capa de negocio. <br>
 * Permite definir las operaciones requeridas del recurso inconsistencia campo
 * turno.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface IInconsistenciaCampoTurnoBusiness {
	
	/**
	 * Metodo que se encarga de consultar las inconsistencias.
	 *
	 * @param aci_consultaInconsistenciasDto el parametro consulta inconsistencias
	 *                                        DTO
	 * @return Resultado para consulta informacion inconsistencia turno retornado
	 *         como una lista de InformacionInconsistenciaDTO
	 */
	public List<InformacionInconsistenciaDTO> consultaInformacionInconsistenciaTurno(
			ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto);

	/**
	 * Metodo que se encarga de llevar la informcion de las inconsistencias para ser
	 * guardada en base de datos.
	 * 
	 * @param aii_InformacionInconsistenciaDto se encarga de llevar la informacion que se
	 *                                  necesita para realizar el guardado el base
	 *                                  de datos.
	 * @return Retorna true o false dependiendo si fue exitoso o no
	 */

	public Boolean guardaInconsistencia(InformacionInconsistenciaDTO aii_InformacionInconsistenciaDto);
}
