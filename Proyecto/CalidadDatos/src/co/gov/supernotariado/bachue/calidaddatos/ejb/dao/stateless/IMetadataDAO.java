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

import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.MetadataVO;

/**
 * Interface para definir operaciones sobre objetos de acceso a datos (DAO) <br>
 * Define operaciones para manipular el modelo de datos metadata.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface IMetadataDAO {

	/**
	 * Metodo que permite leer la metadata desde de las columnas de una tabla desde
	 * oracle.
	 *
	 * @param as_nombreTabla el parametro nombre tabla
	 * @param as_nombreCampo el parametro nombre campo
	 * @return Resultado para metadata retornado como MetadataVO
	 */
	
	public MetadataVO metadata(String as_nombreTabla,String as_nombreCampo);
}
	