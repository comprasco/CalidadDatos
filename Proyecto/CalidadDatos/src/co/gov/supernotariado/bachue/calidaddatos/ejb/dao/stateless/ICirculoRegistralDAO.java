/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ILCirculoRegistralDAO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless
 * Nombre del elemento: ILCirculoRegistralDAO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless;

import java.util.List;
import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.CirculoRegistralVO;

/**
 * Interface para definir operaciones sobre objetos de acceso a datos (DAO) <br>
 * Define operaciones para manipular el modelo de datos circulo registral.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface ICirculoRegistralDAO {

	/**
	 * Metodo que selecciona y retorna la lista de tipo orips del circulo registral.
	 *
	 * @return Resultado para lista circulo registral retornado como una lista de
	 *         CirculoRegistralVO
	 */
	public List<CirculoRegistralVO> listaCirculoRegistral();
}
