/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: TipoSalidaObtenerRolesComponenteWSDTO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.services.wsdto
 * Nombre del elemento: TipoSalidaObtenerRolesComponenteWSDTO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.services.wsdto;

import java.math.BigInteger;
import java.util.List;

import co.gov.supernotariado.bachue.calidaddatos.dto.GenericoDTO;

/**
 * Clase tipo objeto de transferencia de datos para web service (WSDTO). <br>
 * Permite transferir y operar con datos entre capas de negocio y servicios web.
 * <br>
 * Contiene propiedades para representar los datos del objeto Tipo salida
 * obtener roles componente.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class TipoSalidaObtenerRolesComponenteWSDTO extends GenericoDTO{
	
		/**
		 * Define la constante serialVersionUID.
		 */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Atributo de instancia tipo entero de gran magnitud para definir la propiedad
		 * codigo mensaje.
		 */
		private BigInteger ibi_codigoMensaje;
		
		/**
		 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
		 * descripcion mensaje.
		 */
	    private String is_descripcionMensaje;
	    
    	/**
		 * Atributo de instancia tipo lista de RolesWSDTO para definir la propiedad
		 * lista roles.
		 */
	    private List<RolesWSDTO> ilr_listaRoles;
	    
		/**
		 * Obtiene el valor para la propiedad codigo mensaje.
		 *
		 * @return El valor de la propiedad codigo mensaje
		 */
		public BigInteger getIbi_codigoMensaje() {
			return ibi_codigoMensaje;
		}
		
		/**
		 * Cambia/actualiza el valor para la propiedad codigo mensaje.
		 *
		 * @param abi_codigoMensaje el nuevo valor para la propiedad codigo mensaje
		 */
		public void setIbi_codigoMensaje(BigInteger abi_codigoMensaje) {
			this.ibi_codigoMensaje = abi_codigoMensaje;
		}
		
		/**
		 * Obtiene el valor para la propiedad descripcion mensaje.
		 *
		 * @return El valor de la propiedad descripcion mensaje
		 */
		public String getIs_descripcionMensaje() {
			return is_descripcionMensaje;
		}
		
		/**
		 * Cambia/actualiza el valor para la propiedad descripcion mensaje.
		 *
		 * @param as_descripcionMensaje el nuevo valor para la propiedad descripcion
		 *                              mensaje
		 */
		public void setIs_descripcionMensaje(String as_descripcionMensaje) {
			this.is_descripcionMensaje = as_descripcionMensaje;
		}
		
		/**
		 * Obtiene el valor para la propiedad lista roles.
		 *
		 * @return El valor de la propiedad lista roles
		 */
		public List<RolesWSDTO> getIlr_listaRoles() {
			return ilr_listaRoles;
		}
		
		/**
		 * Cambia/actualiza el valor para la propiedad lista roles.
		 *
		 * @param alr_listaRoles el nuevo valor para la propiedad lista roles
		 */
		public void setIlr_listaRoles(List<RolesWSDTO> alr_listaRoles) {
			this.ilr_listaRoles = alr_listaRoles;
		}
	
	    
}
