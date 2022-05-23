/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: UtilidadBusCliente.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.utilidades
 * Nombre del elemento: UtilidadBusCliente
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.utilidades;

import java.util.ResourceBundle;

import javax.faces.bean.ManagedProperty;

import org.apache.log4j.Logger;

import co.gov.supernotariado.bachue.calidaddatos.enums.EnumExcepcionesServicios;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumOperacionesWs;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumServiciosWs;
import co.gov.supernotariado.bachue.calidaddatos.exception.ExcepcionesNegocio;
import co.gov.supernotariado.bachue.clientebus.fabrica.IServicioWeb;
import co.gov.supernotariado.bachue.clientebus.fabrica.SSLUtilities;
import co.gov.supernotariado.bachue.clientebus.fabrica.ServicioWebFactory;
import co.gov.supernotariado.bachue.clientebus.vo.ClienteIntegracionVO;

/**
 * El elemento Class UtilidadBusCliente.<br>
 * Representa un/una utilidad bus cliente.<br>
 * Clase con utilidades para ClienteBus
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class UtilidadBusCliente {

//	------------------------------------------------------------------------
//	Constantes para conexion a servicios de segundo factor de autenticacion
//	------------------------------------------------------------------------
	/**
	 * Nombre de usuario.
	 */	
	private static final String SERVICE_NAME = "BiometriaWS";
	/**
	 * Valor del timeout (en segundos) para la ejecucion del servicio.
	 */
	private static final String SERVICES_TIMEOUT = "10";

	static {
		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
	}

	static final Logger CL_LOGGER = Logger.getLogger(UtilidadBusCliente.class);

	private UtilidadBusCliente() {
		// Metodo vacio
	}

	/**
	 * Metodo que permite consultar un servicio al bus.
	 *
	 * @param aess_enumServiciosSoap   el parametro enum servicios soap
	 * @param aeop_enumOperacionesWs   el parametro enum operaciones ws
	 * @param aci_clienteIntegracionVo el parametro cliente integracion VO
	 * @return Resultado para consultar servicio retornado como ClienteIntegracionVO
	 */
	public static ClienteIntegracionVO consultarServicio(EnumServiciosWs aess_enumServiciosSoap,
			EnumOperacionesWs aeop_enumOperacionesWs, ClienteIntegracionVO aci_clienteIntegracionVo) {
		ServicioWebFactory lswf_servicioWebFactory = new ServicioWebFactory();

		aci_clienteIntegracionVo.setIs_url(aci_clienteIntegracionVo.getIs_url());
		aci_clienteIntegracionVo.setIs_nombreServicioSoap(aci_clienteIntegracionVo.getIs_nombreServicioSoap());
		aci_clienteIntegracionVo.setIs_espacioNombre(aci_clienteIntegracionVo.getIs_espacioNombre());
		aci_clienteIntegracionVo.setIs_nombre(SERVICE_NAME);
		aci_clienteIntegracionVo.setIs_tiempoFuera(SERVICES_TIMEOUT);

		IServicioWeb lisw_iServicioWeb;
		try {
			lisw_iServicioWeb = lswf_servicioWebFactory.getServicioWeb(aci_clienteIntegracionVo);
		} catch (Exception ae_excepcion) {
			CL_LOGGER.error("Excepcion:UtilidadBusCliente:consultarServicio:Mensaje1: " + ae_excepcion.getMessage());
			throw new ExcepcionesNegocio(EnumExcepcionesServicios.PROBLEMA_SERVICIO, ae_excepcion);
		}

		ClienteIntegracionVO lci_clienteIntegracionVo;

		try {
			lci_clienteIntegracionVo = lisw_iServicioWeb.ejecutar(aci_clienteIntegracionVo,
					aeop_enumOperacionesWs.getIs_nombreServicio(), CL_LOGGER);
		} catch (Exception ae_excepcion) {
			CL_LOGGER.error("Excepcion:UtilidadBusCliente:consultarServicio:Mensaje2: " + ae_excepcion.getMessage());
			throw new ExcepcionesNegocio(EnumExcepcionesServicios.PROBLEMA_SERVICIO, ae_excepcion);
		}

		return lci_clienteIntegracionVo;

	}
}