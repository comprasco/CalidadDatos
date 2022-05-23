/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ILInconsistenciasBusiness.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless
 * Nombre del elemento: ILInconsistenciasBusiness
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.stateless;

import java.util.List;

import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.dto.InconsistenciaDTO;

/**
 * Interface de la capa de negocio. <br>
 * Permite definir las operaciones requeridas del recurso inconsistencias.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface IInconsistenciasBusiness 
{
	
	/**
	 * Metodo que lista las inconsistencias.
	 *
	 * @return Resultado para inconsistencias DTO retornado como una lista de
	 *         InconsistenciaDTO
	 */
	public List<InconsistenciaDTO> inconsistenciasDTO();
}
