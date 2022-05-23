/**
 * 
 */
package co.gov.supernotariado.bachue.calidaddatos.dto;

import java.io.Serializable;

/**
 * Clase tipo objeto de transferencia de datos (DTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y presentacion.
 * <br>
 * Contiene propiedades para representar los datos del objeto Consulta
 * inconsistencias.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class ConsultaInconsistenciasDTO implements Serializable{

	/**
	 * Define la constante serialVersionUID.
	 */
	// --- Atributos
	private static final long serialVersionUID = -3385601737471327589L;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * numero turno.
	 */
	private String is_numeroTurno;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * numero matricula.
	 */
	private String is_numeroMatricula;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad id
	 * circulo registral.
	 */
	private String is_idCirculoRegistral;
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad respuesta
	 */
	private String is_respuesta;

	/**
	 * Obtiene el valor para la propiedad numero matricula.
	 *
	 * @return El valor de la propiedad numero matricula
	 */
	// --- Getters-Setters
	public String getIs_numeroMatricula() {
		return is_numeroMatricula;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad numero matricula.
	 *
	 * @param as_numeroMatricula el nuevo valor para la propiedad numero matricula
	 */
	public void setIs_numeroMatricula(String as_numeroMatricula) {
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
	public void setIs_numeroTurno(String as_numeroTurno) {
		this.is_numeroTurno = as_numeroTurno;
	}

	/**
	 * Obtiene el valor para la propiedad id circulo registral.
	 *
	 * @return El valor de la propiedad id circulo registral
	 */
	public String getIs_idCirculoRegistral() {
		return is_idCirculoRegistral;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad id circulo registral.
	 *
	 * @param as_idCirculoRegistral el nuevo valor para la propiedad id circulo
	 *                              registral
	 */
	public void setIs_idCirculoRegistral(String as_idCirculoRegistral) {
		this.is_idCirculoRegistral = as_idCirculoRegistral;
	}
	/**
	 * Obtiene el valor para la propiedad respuesta
	 *
	 * @return El valor de la propiedad respuesta
	 */
	public String getIs_respuesta() {
		return is_respuesta;
	}
	/**
	 * Cambia/actualiza el valor para la propiedad respuesta.
	 *
	 * @param as_respuesta el nuevo valor para la propiedad respuesta
	 */
	public void setIs_respuesta(String as_respuesta) {
		this.is_respuesta = as_respuesta;
	}
}
