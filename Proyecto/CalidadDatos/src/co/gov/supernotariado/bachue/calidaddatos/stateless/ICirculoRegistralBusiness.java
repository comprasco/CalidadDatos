/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ILCirculoRegistralBusiness.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless
 * Nombre del elemento: ILCirculoRegistralBusiness
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.stateless;

import java.util.List;

import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.dto.CirculoRegistralDTO;

/**
 * Interface de la capa de negocio. <br>
 * Permite definir las operaciones requeridas del recurso L circulo registral.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface ICirculoRegistralBusiness 
{
	
	/**
	 * Metodo que lista todas la orips.
	 *
	 * @return Resultado para lista circulo registral DTO retornado como una lista
	 *         de CirculoRegistralDTO
	 */
	public List<CirculoRegistralDTO> listaCirculoRegistralDTO();
}
