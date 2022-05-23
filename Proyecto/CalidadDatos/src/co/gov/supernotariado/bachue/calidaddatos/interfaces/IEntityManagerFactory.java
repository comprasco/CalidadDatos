/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: IEntityManagerFactory.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.interfaces
 * Nombre del elemento: IEntityManagerFactory
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.interfaces;

import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 * Interfaz que define los métodos disponibles para la gestionar el
 * entityFactory
 * 
 * @version 1.0
 * @author Smartsoft Solutions S.A.S
 *
 */
@Local
public interface IEntityManagerFactory {

	/**
	 * Metodo que permite realizar consultar un entityManager.
	 *
	 * @return Resultado para consultar entity manager retornado como EntityManager
	 */
	public EntityManager consultarEntityManager();
}
