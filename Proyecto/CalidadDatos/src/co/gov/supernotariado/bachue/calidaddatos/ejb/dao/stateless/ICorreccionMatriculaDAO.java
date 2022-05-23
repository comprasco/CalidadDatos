/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ICorreccionMatriculaDAO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless
 * Nombre del elemento: ICorreccionMatriculaDAO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless;

import java.util.List;

import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.dto.CirculoRegistralDTO;

/**
 * Interface para definir operaciones sobre objetos de acceso a datos (DAO) <br>
 * Define operaciones para manipular el modelo de datos Correccion matricula.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface ICorreccionMatriculaDAO 
{  
	
	/**
	 * Metodo que se encarga de crear un lista de orips.
	 *
	 * @return Resultado para orip DTO retornado como lista de CirculoRegistralDTO
	 */
	public List<CirculoRegistralDTO> oripDTO();	
}
