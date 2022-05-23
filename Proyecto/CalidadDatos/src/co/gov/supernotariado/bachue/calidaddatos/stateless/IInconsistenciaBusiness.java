/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ILInconsistenciaBusiness.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless
 * Nombre del elemento: ILInconsistenciaBusiness
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.stateless;

import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.dto.InconsistenciaDTO;


@Local
public interface IInconsistenciaBusiness 
{
	
	/**
	 * Metodo que se utiliza para saber el nombre de la tabla y el campo de las
	 * inconsistencias.
	 *
	 * @param as_nombreTabla el parametro nombre tabla
	 * @param as_nombreCampo el parametro nombre campo
	 * @return Resultado para inconsistencia DTO retornado como InconsistenciaDTO
	 */
	public InconsistenciaDTO inconsistenciaDTO(String as_nombreTabla,String as_nombreCampo);
}
