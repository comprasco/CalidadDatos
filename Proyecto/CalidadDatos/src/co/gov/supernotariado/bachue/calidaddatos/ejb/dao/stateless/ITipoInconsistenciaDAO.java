/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ILTipoInconsistenciaDAO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless
 * Nombre del elemento: ILTipoInconsistenciaDAO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */

package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless;

import java.util.List;

import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.TipoInconsistenciaVO;

/**
 * Interface para definir operaciones sobre objetos de acceso a datos (DAO) <br>
 * Define operaciones para manipular el modelo de datos tipo inconsistencia.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public interface ITipoInconsistenciaDAO {
	
	/**
	 * Este metodo es el encargado de consultar los tipos de incosistencias a la
	 * base de datos.
	 *
	 * @return Resultado para tipo inconsinsistencia retornado como una lista de
	 *         TipoInconsistenciaVO
	 */

	public List<TipoInconsistenciaVO> tipoInconsinsistencia(); 
}
