/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ConsultarInconsistenciaVO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.persistence.VO
 * Nombre del elemento: ConsultarInconsistenciaVO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.persistence.vo;

import java.io.Serializable;
import java.util.List;

import co.gov.supernotariado.bachue.calidaddatos.dto.CirculoRegistralDTO;

/**
 * El elemento Class ConsultarInconsistenciaVO.<br>
 * Representa un/una consultar inconsistencia VO.<br>
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class ConsultarInconsistenciaVO implements Serializable {

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * numero matricula.
	 */
	private String is_numeroMatricula;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * numero turno.
	 */
	private String is_numeroTurno;

	/**
	 * Atributo de instancia tipo lista de CirculoRegistralDTO para definir la
	 * propiedad circulo registral.
	 */
	private List<CirculoRegistralDTO> ilcr_circuloRegistralDto;

	/**
	 * Obtiene el valor para la propiedad numero matricula.
	 *
	 * @return El valor de la propiedad numero matricula
	 */
	public String getIs_numeroMatricula() {
		return is_numeroMatricula;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad numero matricula.
	 *
	 * @param as_numeroMatricula el nuevo valor para la propiedad numero matricula
	 */
	public void setIs_numeroMatricula(final String as_numeroMatricula) {
		this.is_numeroMatricula = as_numeroMatricula;
	}

	/**
	 * Obtiene el valor para la propiedad numero turno.
	 *
	 * @return El valor de la propiedad numero turno
	 */
	public String getIs_numeroTurno() {
		return is_numeroTurno;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad numero turno.
	 *
	 * @param as_numeroTurno el nuevo valor para la propiedad numero turno
	 */
	public void setIs_numeroTurno(final String as_numeroTurno) {
		this.is_numeroTurno = as_numeroTurno;
	}

	/**
	 * Obtiene el valor para la propiedad orip DTO.
	 *
	 * @return El valor de la propiedad orip DTO
	 */
	public List<CirculoRegistralDTO> getIlo_OripDTO() {
		return ilcr_circuloRegistralDto;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad orip DTO.
	 *
	 * @param alo_OripDTO el nuevo valor para la propiedad orip DTO
	 */
	public void setIlo_OripDTO(final List<CirculoRegistralDTO> alo_OripDTO) {
		this.ilcr_circuloRegistralDto = alo_OripDTO;
	}

}
