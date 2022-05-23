/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: BiometriaConsultarSesionBusiness.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless.impl
 * Nombre del elemento: BiometriaConsultarSesionBusiness
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.stateless.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;

import org.jboss.logging.Logger;

import co.gov.supernotariado.bachue.calidaddatos.dto.UtilidadClienteBusDTO;
import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IUtilidadBusClienteDAO;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumOperacionesWs;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumServiciosWs;
import co.gov.supernotariado.bachue.calidaddatos.jsf.bean.BeanCorregirInconsistencias;
import co.gov.supernotariado.bachue.calidaddatos.services.converters.TipoEntradaObtenerRolesComponenteWsDtoConverter;
import co.gov.supernotariado.bachue.calidaddatos.services.converters.TipoSalidaSesionSalidaWsDtoConverte;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoEntradaObtenerRolesComponenteWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoEntradaSesionEntradaWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoSalidaObtenerRolesComponenteWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoSalidaSesionSalidaWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.stateless.IBiometriaConsultarSesion;
import co.gov.supernotariado.bachue.calidaddatos.utilidades.UtilidadBusCliente;
import co.gov.supernotariado.bachue.clientebus.vo.biometrico.SesionVO;
import co.gov.supernotariado.bachue.clientebus.vo.biometrico.TipoEntradaSesionEntradaVO;
import co.gov.supernotariado.bachue.clientebus.vo.getionusuarios.TipoEntradaObtenerRolesComponenteVO;
import co.gov.supernotariado.bachue.clientebus.vo.getionusuarios.TipoSalidaObtenerRolesComponenteVO;

/**
 * Clase tipo EJB (Enterprise Java Bean) de la capa de negocio. <br>
 * Contiene la implementacion logica de las operaciones del recurso Biometria
 * consultar sesion. <br>
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Stateless(name = "BiometriaConsultarSesionBusiness", mappedName = "BiometriaConsultarSesionBusiness")
@LocalBean
public class BiometriaConsultarSesionBusinessImpl implements IBiometriaConsultarSesion {

	/**
	 * Define la constante CL_LOGGER.
	 */
	private final static Logger CD_LOGGER = Logger.getLogger(BiometriaConsultarSesionBusinessImpl.class);
	
	@EJB
	private IUtilidadBusClienteDAO utilidadBusClienteDao;
	
	/**
	 * Atributo de instancia tipo BeanCertificadoEspecial para definir la propiedad
	 * bean certificado especial.
	 */
	@ManagedProperty(value = "#{beanCorregirInconsistencias}")
	private BeanCorregirInconsistencias ibci_beanCorregirInconsistencias;

	/**
	 * Metodo que consulta a la base de datos el valor de la constante de url servicio para biometria
	 * 
	 * @return String con el valor de la url del servicio de biometria
	 */
	public String consultarUrlWsdlServicio() {
		return utilidadBusClienteDao.consultarUrlDispositivoServicio().getIs_url();
	}

	/**
	 * Metodo que consulta a la base de datos el valor de la constante de espacio nombre servicio para biometria
	 * 
	 * @return String con el valor de espacio nombre del servicio de biometria
	 */
	public String consultarWsdlEspacioNombre() {
		return utilidadBusClienteDao.consultarWsdlEspacioNombre().getIs_espacioNombre();
	}
	
	/**
	 * Metodo que consulta a la base de datos el valor de la constante de servicio nombre para biometria
	 * 
	 * @return String con el valor de servicio nombre del servicio de biometria
	 */
	public String consultarWsdlServicioNombre() {
		return utilidadBusClienteDao.consultarWsdlServicioNombre().getIs_nombreServicioSoap();
	}
	
	@ManagedProperty(value = "#{txt_bioclient}")
	public transient ResourceBundle irb_bundleTxtBioclient;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.gov.supernotariado.bachue.calidaddatos.stateless.IBiometriaConsultarSesion
	 * #consultarSesion(co.gov.supernotariado.bachue.calidaddatos.services.wsdto.
	 * TipoEntradaSesionEntradaWSDTO)
	 */
	@Override
	public TipoSalidaSesionSalidaWSDTO consultarSesion(
			TipoEntradaSesionEntradaWSDTO atese_tipoEntradaSesionEntradaWsDto, UtilidadClienteBusDTO utilidadClienteBusDto) throws FileNotFoundException, IOException {
		TipoEntradaSesionEntradaVO ltese_tipoEntradaSesionEntradaVo = TipoSalidaSesionSalidaWsDtoConverte
				.wsDtoAVo(atese_tipoEntradaSesionEntradaWsDto);
		
		ltese_tipoEntradaSesionEntradaVo.getIse_sesionEntradaVo().setIs_url(utilidadClienteBusDto.getIs_urlWsdlDeviceServices());
		ltese_tipoEntradaSesionEntradaVo.getIse_sesionEntradaVo().setIs_espacioNombre(utilidadClienteBusDto.getIs_nameSpace());
		ltese_tipoEntradaSesionEntradaVo.getIse_sesionEntradaVo().setIs_nombreServicioSoap(utilidadClienteBusDto.getIs_webServiceNameBiometria());

		SesionVO ltsss_tipoSalidaSesionSalidaVo = (SesionVO) UtilidadBusCliente.consultarServicio(
				EnumServiciosWs.CONSULTAR_SESION, EnumOperacionesWs.CONSULTAR_SESION,
				ltese_tipoEntradaSesionEntradaVo.getIse_sesionEntradaVo());

		TipoSalidaSesionSalidaWSDTO ltsss_tipoSalidaSesionSalidaWsDto = new TipoSalidaSesionSalidaWSDTO();
		ltsss_tipoSalidaSesionSalidaWsDto
				.setIs_sesionVo(TipoSalidaSesionSalidaWsDtoConverte.VoAWsdto(ltsss_tipoSalidaSesionSalidaVo));

		CD_LOGGER.debug("DEBUG:BiometriaConsultarSesionBusinessImpl:consultarSesion:tipoSalidaSesionSalidaWsDto");
		CD_LOGGER.debug(ltsss_tipoSalidaSesionSalidaWsDto);

		return ltsss_tipoSalidaSesionSalidaWsDto;
	}

	public ResourceBundle getIrb_bundleTxtBioclient() {
		return irb_bundleTxtBioclient;
	}

	public void setIrb_bundleTxtBioclient(ResourceBundle irb_bundleTxtBioclient) {
		this.irb_bundleTxtBioclient = irb_bundleTxtBioclient;
	}

	public BeanCorregirInconsistencias getIbci_beanCorregirInconsistencias() {
		return ibci_beanCorregirInconsistencias;
	}

	public void setIbci_beanCorregirInconsistencias(BeanCorregirInconsistencias ibci_beanCorregirInconsistencias) {
		this.ibci_beanCorregirInconsistencias = ibci_beanCorregirInconsistencias;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.gov.supernotariado.bachue.calidaddatos.stateless.IBiometriaConsultarSesion
	 * #obtenerComponente(co.gov.supernotariado.bachue.calidaddatos.services.wsdto.
	 * TipoEntradaObtenerRolesComponenteWSDTO)
	 */
	@Override
	public TipoSalidaObtenerRolesComponenteWSDTO obtenerComponente(
			TipoEntradaObtenerRolesComponenteWSDTO atese_tipoSalidaObtenerRolesComponenteWsDto) {
		TipoEntradaObtenerRolesComponenteVO lteorc_TipoEntradaObtenerRolesComponenteVo = TipoEntradaObtenerRolesComponenteWsDtoConverter
				.voAEntidad(atese_tipoSalidaObtenerRolesComponenteWsDto);
		
		lteorc_TipoEntradaObtenerRolesComponenteVo.setIs_url(consultarUrlWsdlServicio());
		lteorc_TipoEntradaObtenerRolesComponenteVo.setIs_espacioNombre(consultarWsdlEspacioNombre());
		lteorc_TipoEntradaObtenerRolesComponenteVo.setIs_nombreServicioSoap(consultarWsdlServicioNombre());
		
		TipoSalidaObtenerRolesComponenteVO ltsorc_tipoSalidaObtenerRolesComponenteVO = (TipoSalidaObtenerRolesComponenteVO) UtilidadBusCliente
				.consultarServicio(EnumServiciosWs.OBTENER_ROLES_COMPONENTES,
						EnumOperacionesWs.OBTENER_ROLES_COMPONENTES, lteorc_TipoEntradaObtenerRolesComponenteVo);
		TipoSalidaObtenerRolesComponenteWSDTO ltsorc_tipoSalidaObtenerRolesComponenteWsDto;
		ltsorc_tipoSalidaObtenerRolesComponenteWsDto = TipoEntradaObtenerRolesComponenteWsDtoConverter
				.entidadAVo(ltsorc_tipoSalidaObtenerRolesComponenteVO);

		return ltsorc_tipoSalidaObtenerRolesComponenteWsDto;
	}
}