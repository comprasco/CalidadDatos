/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: IBiometriaConsultarSesion.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless
 * Nombre del elemento: IBiometriaConsultarSesion
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.stateless;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.dto.UtilidadClienteBusDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoEntradaObtenerRolesComponenteWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoEntradaSesionEntradaWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoSalidaObtenerRolesComponenteWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoSalidaSesionSalidaWSDTO;

/**
 * Interface de la capa de negocio. <br>
 * Permite definir las operaciones requeridas del recurso Biometria <br>
 * Contiene operaciones para consumir los servicio de Biometria
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface IBiometriaConsultarSesion {
	/**
	 * Metodo que realiza el llamado de la operacion Consultar Sesion
	 * 
	 * @param atese_tipoEntradaSesionEntradaWsDto
	 * @return Si la sesion fue exitosa o no 
	 * @throws FileNotFoundException 
	 */
	public TipoSalidaSesionSalidaWSDTO consultarSesion(
			TipoEntradaSesionEntradaWSDTO atese_tipoEntradaSesionEntradaWsDto, UtilidadClienteBusDTO utilidadClienteBusDto) throws FileNotFoundException, IOException;

	/**
	 * Metodo que realiza el llamado de la operacion de obtener componentes del
	 * servicio de CA
	 * 
	 * @param atese_tipoSalidaObtenerRolesComponenteWsDto
	 * @return Los componentes del usuario logueado 
	 */
	public TipoSalidaObtenerRolesComponenteWSDTO obtenerComponente(
			TipoEntradaObtenerRolesComponenteWSDTO atese_tipoSalidaObtenerRolesComponenteWsDto);

}
