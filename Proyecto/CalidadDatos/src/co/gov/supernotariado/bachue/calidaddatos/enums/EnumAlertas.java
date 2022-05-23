package co.gov.supernotariado.bachue.calidaddatos.enums;
/**
 * Enumeracion para definir el grupo de constantes para Alertas.<br>
 * Enum que contiene los datos enviados a js para mostrar las alertas
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public enum EnumAlertas {


		/**
		 * Constante de la enumeracion para definir el item: ERROR.
		 */
		ERROR("ERROR"),

		/**
		 * Constante de la enumeracion para definir el item: CONFIRMACION.
		 */
		CONFIRMACION("CONFIRMACION"),

		/**
		 * Constante de la enumeracion para definir el item: INFORMACION.
		 */
		INFORMACION("INFORMACION"),

		/**
		 * Constante de la enumeracion para definir el item: ALERTAR.
		 */
		ALERTAR("alertar('%s', '%s')");

		/**
		 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
		 * criterio.
		 */
		private String is_criterio;

		/**
		 * Construye una nueva instancia/objeto de la clase EnumAlertas.
		 *
		 * @param as_criterio el parametro criterio
		 */
		private EnumAlertas(String as_criterio) {
			this.is_criterio = as_criterio;
		}

		/**
		 * Obtiene el valor para la propiedad criterio.
		 *
		 * @return El valor de la propiedad criterio
		 */
		public String getIs_criterio() {
			return is_criterio;
		}

	}

