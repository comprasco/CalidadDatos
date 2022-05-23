/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ILMetadataDAO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless
 * Nombre del elemento: ILMetadataDAO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless;
import javax.ejb.Local;

import co.gov.supernotariado.bachue.clientebus.vo.ClienteIntegracionVO;

/**
 * Interface para definir operaciones sobre objetos de acceso a datos (DAO) <br>
 * Define operaciones para manipular el modelo de datos metadata.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface IUtilidadBusClienteDAO {

	/**
	 * Metodo que permite leer la metadata desde de las columnas de una tabla desde
	 * oracle.
	 *
	 * @return Resultado para metadata retornado como MetadataVO
	 */
	
	public ClienteIntegracionVO consultarUrlDispositivoServicio();

	/**
	 * Metodo que permite leer la metadata desde de las columnas de una tabla desde
	 * oracle.
	 *
	 * @return Resultado para metadata retornado como MetadataVO
	 */
	
	public ClienteIntegracionVO consultarWsdlEspacioNombre();

	/**
	 * Metodo que permite leer la metadata desde de las columnas de una tabla desde
	 * oracle.
	 * 
	 * @return Resultado para metadata retornado como MetadataVO
	 */
	public ClienteIntegracionVO consultarWsdlServicioNombre();
}