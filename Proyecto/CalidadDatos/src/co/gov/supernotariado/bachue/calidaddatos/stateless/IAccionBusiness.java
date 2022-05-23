/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: IAccionBusiness.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless
 * Nombre del elemento: IAccionBusiness
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.stateless;

import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.dto.AccionDTO;

/**
 * Interface de la capa de negocio. <br>
 * Permite definir las operaciones requeridas del recurso Accion.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface IAccionBusiness {

	/**
	 * Metodo que permite crear el objeto a una Entidad asociada a la capa DAO.
	 * 
	 * @param accion DTO Accion a convertir.
	 * @return true si la operacion se realiza exitosamente.
	 */
	public Boolean crearAccion(AccionDTO aa_accionDto);
}
