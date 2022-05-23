/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: CirculoRegistralHelper.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.persistence.helper
 * Nombre del elemento: CirculoRegistralHelper
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.persistence.helper;

import java.util.ArrayList;
import java.util.List;

import co.gov.supernotariado.bachue.calidaddatos.dto.CirculoRegistralDTO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.CirculoRegistralVO;

/**
 * Clase auxiliar(helper) que permite transformar objetos de DTO(Data Transfer
 * Object) a Entidades de persistencia y viceversa. <br>
 * Contiene operaciones de transformacion para el DTO y la entidad Circulo
 * registral. <br>
 * Clase utlizada hacer uso de los helper de circulo registral
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class CirculoRegistralHelper 

{
	
	/**
	 * Construye una nueva instancia/objeto de la clase CirculoRegistralHelper.
	 */
	private  CirculoRegistralHelper()
	{
		//constructor vacio de modelo
	}
	
	/**
	 * Metodo que convierte de entidad a dto.
	 *
	 * @param acr_circuloRegistral el parametro acr
	 * @return Resultado para entidad simple DTO retornado como CirculoRegistralDTO
	 */
	public static CirculoRegistralDTO entidadSimpleDTO(CirculoRegistralVO acr_circuloRegistral) 
	{
		CirculoRegistralDTO lcr_circuloRegistralDto = new CirculoRegistralDTO();
		lcr_circuloRegistralDto.setIs_idCirculo(acr_circuloRegistral.getIs_idCirculo());
		lcr_circuloRegistralDto.setIs_nombre(acr_circuloRegistral.getIs_nombre());
		return lcr_circuloRegistralDto;
	}
	
	/**
	 * Metodo que convierte un lista a dto.
	 *
	 * @param alcr_circuloRegistral el parametro circulo registral
	 * @return Resultado para lista entidad simple DTO retornado como una lista de
	 *         CirculoRegistralDTO
	 */
	public static List<CirculoRegistralDTO> listaEntidadSimpleDTO(List<CirculoRegistralVO> alcr_circuloRegistral) 
	{
		List<CirculoRegistralDTO> llcirculoregistralDto = new ArrayList<>();
		for(CirculoRegistralVO obj : alcr_circuloRegistral) 
		{
			llcirculoregistralDto.add(entidadSimpleDTO(obj));
		}

		return llcirculoregistralDto;
	}
}