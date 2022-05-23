/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ILEjecucionModuloDAO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless
 * Nombre del elemento: ILEjecucionModuloDAO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless;

import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.EjecucionModuloVO;

/**
 * Interface para definir operaciones sobre objetos de acceso a datos (DAO) <br>
 * Define operaciones para manipular el modelo de datos realacionado al modulo de la inconsistencias.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface IEjecucionModuloDAO 
{
	
	/**
	 * Metodo que se utiliza para consultar los modulos de la inconsistencias.
	 *
	 * @param as_nombreTabla nombre de la tabla
	 * @param as_nombreCampo nombre del campo
	 * @return Resultado para ejecucion modulo VO retornado como EjecucionModuloVO
	 */
	public EjecucionModuloVO ejecucionModuloVO(String as_nombreTabla,String as_nombreCampo);
}
