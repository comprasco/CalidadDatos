/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: JmsConnectionFactory.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.impl
 * Nombre del elemento: JmsConnectionFactory
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.impl;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * El elemento Class JmsConnectionFactory.<br>
 * Representa un/una jms connection factory.<br>
 * Clase implementada para realizar la conexion con del job
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */

public class JmsConnectionFactoryimpl implements Serializable{


	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo para definir la propiedad connection factory.
	 */
	@Resource(mappedName = "jms/CalidadDatosConnectionFactory")
	/**
	 * Atributo private de tipo ConnectionFactory que almacena el valor de la
	 * variable connectionFactory
	 */
	private transient ConnectionFactory connectionFactory;

	/**
	 * Metodo que se utiliza para realizar la conexion de base de datos.
	 *
	 * @return connection
	 * @throws JMSException la excepcion JMS exception
	 */
	@Produces
	public Connection getConnection() throws JMSException {
		Connection connection = connectionFactory.createConnection();
		try {
			connection.start();
			return connection;
		} finally {
			connection.close();
		}
	}

	/**
	 * Obtiene el valor para la propiedad session.
	 *
	 * @param connection el parametro connection
	 * @return El valor de la propiedad session
	 * @throws JMSException la excepcion JMS exception
	 */
	@Produces
	public Session getSession(final Connection connection) throws JMSException {
		return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	}

	/**
	 * Cierra la session.
	 *
	 * @param session el parametro session
	 * @throws JMSException la excepcion JMS exception
	 */
	public void closeSession(@Disposes final Session session) throws JMSException {
		session.close();
	}

	/**
	 * Cierra la conexion.
	 *
	 * @param connection el parametro connection
	 * @throws JMSException la excepcion JMS exception
	 */
	public void closeConnection(@Disposes final Connection connection) throws JMSException {
		connection.close();
	}

}
