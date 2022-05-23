/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: IJmsManagerFactory.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.interfaces
 * Nombre del elemento: IJmsManagerFactory
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.interfaces;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * El elemento Interface IJmsManagerFactory.<br>
 * Representa un/una Interfaz jms manager factory.<br>
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */

public interface IJmsManagerFactory {

	/**
	 * Metodo que permite realizar la conexion.
	 *
	 * @return Connection
	 * @throws JMSException la excepcion JMS exception
	 */
	Connection getConnection() throws JMSException;

	/**
	 * Metodo que obtiene la sesion.
	 *
	 * @param connection el parametro connection
	 * @return El valor de la propiedad session
	 * @throws JMSException la excepcion JMS exception
	 */
	Session getSession(final Connection connection) throws JMSException;

	/**
	 * Metodo que cierra la sesion.
	 *
	 * @param session el parametro session
	 * @throws JMSException la excepcion JMS exception
	 */
	void closeSession(final Session session) throws JMSException;

	/**
	 * Metodo que cierra la conexion.
	 *
	 * @param connection el parametro connection
	 * @throws JMSException la excepcion JMS exception
	 */
	void closeConnection(final Connection connection) throws JMSException;
}
