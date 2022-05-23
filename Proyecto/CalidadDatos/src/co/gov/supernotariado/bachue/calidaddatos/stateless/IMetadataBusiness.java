/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ILMetadataBusiness.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless
 * Nombre del elemento: ILMetadataBusiness
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.stateless;

import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.dto.MetadataDTO;


/**
 * Interface de la capa de negocio. <br>
 * Permite definir las operaciones requeridas del recurso L metadata.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface IMetadataBusiness {

	
	/**
	 * Metodo que permite leer la metadata desde de las columnas de una tabla desde oracle.
	 *
	 * @param as_nombreTabla el parametro nombre tabla
	 * @param as_nombreCampo el parametro nombre campo
	 * @return Resultado para metadata retornado como MetadataDTO
	 */
	public MetadataDTO metadata(String as_nombreTabla,String as_nombreCampo);
}
