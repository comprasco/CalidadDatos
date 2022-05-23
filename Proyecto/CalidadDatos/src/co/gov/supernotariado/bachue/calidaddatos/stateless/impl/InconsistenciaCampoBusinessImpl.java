/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InconsistenciaCampoBusinessImpl.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless.impl
 * Nombre del elemento: InconsistenciaCampoBusinessImpl
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */

package co.gov.supernotariado.bachue.calidaddatos.stateless.impl;

import java.math.BigDecimal;

import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;

import org.jboss.logging.Logger;
import co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO;
import co.gov.supernotariado.bachue.calidaddatos.dto.InformacionInconsistenciaDTO;
import co.gov.supernotariado.bachue.calidaddatos.dto.ServicioBiometriaDTO;
import co.gov.supernotariado.bachue.calidaddatos.dto.UtilidadClienteBusDTO;
import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IInconsistenciaCampoDAO;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumEstadoProcesoInconsistencias;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumExcepcionesGenerales;
import co.gov.supernotariado.bachue.calidaddatos.exception.ExcepcionesDatosEntrada;
import co.gov.supernotariado.bachue.calidaddatos.persistence.helper.InformacionInconsistenciaHelper;
import co.gov.supernotariado.bachue.calidaddatos.services.converters.TipoEntradaSesionEntradaWsDtoConverte;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoEntradaSesionEntradaWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoSalidaSesionSalidaWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.stateless.IBiometriaConsultarSesion;
import co.gov.supernotariado.bachue.calidaddatos.stateless.IInconsistenciaCampoBusiness;


/**
 * Clase tipo EJB (Enterprise Java Bean) de la capa de negocio. <br>
 * Contiene la implementacion logica de las operaciones del recurso
 * Inconsistencia campo. <br>
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Stateless
@LocalBean
public class InconsistenciaCampoBusinessImpl implements IInconsistenciaCampoBusiness{

	/**
	 * Define la constante CL_LOGGER.
	 */
	private final static Logger CD_LOGGER = Logger.getLogger(InconsistenciaCampoBusinessImpl.class);

	/**
	 * Atributo de instancia tipo IInconsistenciaCampoDAO para definir la propiedad
	 * inconsistencia campo dao.
	 */
	@EJB
	/**
	 * Atributo private de tipo IInconsistenciaCampoDAO que almacena el valor de la variable IInconsistenciaCampoDao
	 */
	private IInconsistenciaCampoDAO iic_iInconsistenciaCampoDao;
	
	/**
	 * Atributo private de tipo IBiometriaConsultarSesion que almacena el valor de
	 * la variable IBiometriaConsultarSesion.
	 */
	 
	@EJB
	private IBiometriaConsultarSesion iibcs_ibiometriaConsultarSesion;
	
	@ManagedProperty(value = "#{txt_bioclient}")
	private transient ResourceBundle irb_bundleTxtBioclient;

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoBusiness#consultarInformacionInconsistenciaMatricula(co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO)
	 */
	@Override
	public List<InformacionInconsistenciaDTO> consultarInformacionInconsistenciaMatricula(
			ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto) {
		List<InformacionInconsistenciaDTO> llii_listaDto;
		llii_listaDto = InformacionInconsistenciaHelper.listaInformacionInconsistenciaDTO(
				iic_iInconsistenciaCampoDao.lii_informacionInconsistenciaVo(aci_consultaInconsistenciasDto));
		return llii_listaDto;
	}


	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoBusiness#guardaInconsistencia(co.gov.supernotariado.bachue.calidaddatos.dto.InformacionInconsistenciaDTO)
	 */
	@Override
	public Boolean guardaInconsistencia(final InformacionInconsistenciaDTO aii_informacionInconsistenciaDto) {
		Boolean lb_actualiza = iic_iInconsistenciaCampoDao.guardaInconsistencia(InformacionInconsistenciaHelper.completoInformacionInconsistenciaVO(aii_informacionInconsistenciaDto));
		return lb_actualiza;
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoBusiness#validarMatriculaEncolada(java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean validarMatriculaEncolada(final String as_matricula, String as_circulo) {
		final String ls_estadoMatricula = iic_iInconsistenciaCampoDao.validarEstadoMatricula(as_matricula, as_circulo);
		if (ls_estadoMatricula.equals(EnumEstadoProcesoInconsistencias.EN_PROCESO.getIs_descripcion())) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoBusiness#validarMatriculaProcesada(java.lang.String, java.lang.String)
	 */
	public Boolean validarMatriculaProcesada(final String as_matricula, String as_idCirculoRegistral) {
		final String ls_estadoMatricula = iic_iInconsistenciaCampoDao.validarEstadoMatricula(as_matricula, as_idCirculoRegistral);
		if (ls_estadoMatricula.equals(EnumEstadoProcesoInconsistencias.EN_PROCESO.getIs_descripcion())) {
			return true;
		}
		return false;

	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoBusiness#deshabilitarEstadoProceso(java.lang.String)
	 */
	public void deshabilitarEstadoProceso(final String as_matriculaValidar) {
		iic_iInconsistenciaCampoDao.deshabilitarEstadoProceso(as_matriculaValidar);
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoBusiness#encolaMatriculasInconsistentes(co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO)
	 */
	public Boolean encolaMatriculasInconsistentes(final ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto) {
		try {
			iic_iInconsistenciaCampoDao
					.deshabilitarEstadoProceso(aci_consultaInconsistenciasDto.getIs_numeroMatricula());
			iic_iInconsistenciaCampoDao.insertarMatriculaValidada(aci_consultaInconsistenciasDto, EnumEstadoProcesoInconsistencias.EN_PROCESO);
			CD_LOGGER.debug("La matricula " + aci_consultaInconsistenciasDto.getIs_numeroMatricula()
					+ " fue encolada con exito");
		} catch (final Exception e) {
			CD_LOGGER.error("Excepcion:InconsistenciaCampoBusinessImpl:encolaMatriculasInconsistentes:Mensaje: " + e.getMessage());
			iic_iInconsistenciaCampoDao
					.deshabilitarEstadoProceso(aci_consultaInconsistenciasDto.getIs_numeroMatricula());
			
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoBusiness#conutN(co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO)
	 */
	@Override
	public BigDecimal estadoN (ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto){
		BigDecimal lbd_estadoN = iic_iInconsistenciaCampoDao.estadoN(aci_consultaInconsistenciasDto);
		return lbd_estadoN;
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoBusiness#conutC(co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO)
	 */
	@Override
	public BigDecimal estadoC (ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto)
	{
		BigDecimal lb_estadoC = iic_iInconsistenciaCampoDao.estadoC(aci_consultaInconsistenciasDto);
		return lb_estadoC;
	}

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoBusiness#obtenerSesion(co.gov.supernotariado.bachue.calidaddatos.dto.ServicioBiometriaDTO)
	 */
	@Override
	public TipoSalidaSesionSalidaWSDTO obtenerSesion (ServicioBiometriaDTO asb_servicioBiometriaDto, UtilidadClienteBusDTO utilidadClienteBusDto) 
	{
		TipoSalidaSesionSalidaWSDTO ltsss_TipoSalidaSesionSalidaWsDto = new TipoSalidaSesionSalidaWSDTO();
		TipoEntradaSesionEntradaWSDTO ltese_tipoEntradaSesionEntradaWsDto = new TipoEntradaSesionEntradaWSDTO();
		ltese_tipoEntradaSesionEntradaWsDto.setIse_sesionEntradaWsDto(TipoEntradaSesionEntradaWsDtoConverte.servicioBiometricoASesion(asb_servicioBiometriaDto));
		
//		
		
		try {
			CD_LOGGER.info("Importante:InconsistenciaCampoBusinessImpl:obtenerSesion:Mensaje: Entrada consultarSesion:" + ltese_tipoEntradaSesionEntradaWsDto);
			ltsss_TipoSalidaSesionSalidaWsDto=iibcs_ibiometriaConsultarSesion.consultarSesion(ltese_tipoEntradaSesionEntradaWsDto, utilidadClienteBusDto);
		} catch (Exception ae_excepcion) {
			CD_LOGGER.error("Excepcion:InconsistenciaCampoBusinessImpl:obtenerSesion:Excepcion: " + ae_excepcion.getMessage());
			CD_LOGGER.error("Excepcion:InconsistenciaCampoBusinessImpl:obtenerSesion:Entrada: " + ltese_tipoEntradaSesionEntradaWsDto);
			throw new ExcepcionesDatosEntrada(EnumExcepcionesGenerales.ERROR_TECNICO, ae_excepcion);
		}


		return ltsss_TipoSalidaSesionSalidaWsDto; 
	}
	
//	public ResourceBundle getIrb_bundleTxtBioclient() {
//		return irb_bundleTxtBioclient;
//	}
//
//
//	public void setIrb_bundleTxtBioclient(ResourceBundle irb_bundleTxtBioclient) {
//		this.irb_bundleTxtBioclient = irb_bundleTxtBioclient;
//	}


	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoBusiness#promotorPL(co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO)
	 */
	@Override
	public String promotorPL(final ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto) {
		return iic_iInconsistenciaCampoDao.promotorPL(aci_consultaInconsistenciasDto);
	}
	
	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoBusiness#ejecutarTurnoPL(co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO)
	 */
	@Override
	public void ejecutarTurnoPL(final ConsultaInconsistenciasDTO ac_consultaInconsistenciasDto) {
		iic_iInconsistenciaCampoDao.ejecutarTurnoPL(ac_consultaInconsistenciasDto);
	}
	

	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoBusiness#validarMatriculaEncolada()
	 */
	@Override
	public Boolean validarMatriculaEncolada() {
		iic_iInconsistenciaCampoDao.validarMatriculaEncolada();
		return true;
	}
	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.stateless.ILInconsistenciaCampoBusiness#promotorBachueTurnoPL()
	 */
	@Override
	public void promotorBachueTurnoPL(ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto) {
		iic_iInconsistenciaCampoDao.promotorBachueTurnoPL(aci_consultaInconsistenciasDto);
		
	}

	/**
	 * Obtiene el valor para la propiedad i biometria consultar sesion.
	 *
	 * @return El valor de la propiedad i biometria consultar sesion
	 */
	public IBiometriaConsultarSesion getIbcs_iBiometriaConsultarSesion() {
		return iibcs_ibiometriaConsultarSesion;
	}
	
	/**
	 * Cambia/actualiza el valor para la propiedad i biometria consultar sesion.
	 *
	 * @param abcs_iBiometriaConsultarSesion el nuevo valor para la propiedad i
	 *                                       biometria consultar sesion
	 */
	public void setIbcs_iBiometriaConsultarSesion(IBiometriaConsultarSesion abcs_iBiometriaConsultarSesion) {
		this.iibcs_ibiometriaConsultarSesion = abcs_iBiometriaConsultarSesion;
	}


	


}
