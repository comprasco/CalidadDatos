/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: BeanCorregirInconsistencias.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.jsf.bean
 * Nombre del elemento: BeanCorregirInconsistencias
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.jsf.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;
import org.primefaces.PrimeFaces;

import co.gov.supernotariado.bachue.calidaddatos.dto.CirculoRegistralDTO;
import co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO;
import co.gov.supernotariado.bachue.calidaddatos.dto.InformacionInconsistenciaDTO;
import co.gov.supernotariado.bachue.calidaddatos.dto.MensajesDTO;
import co.gov.supernotariado.bachue.calidaddatos.dto.ServicioBiometriaDTO;
import co.gov.supernotariado.bachue.calidaddatos.dto.UtilidadClienteBusDTO;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumEstadoProcesoInconsistencias;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumExcepcionesGenerales;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumMensajesImagenes;
import co.gov.supernotariado.bachue.calidaddatos.exception.ExcepcionesNegocio;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.SesionWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoSalidaSesionSalidaWSDTO;
import co.gov.supernotariado.bachue.calidaddatos.stateless.ICirculoRegistralBusiness;
import co.gov.supernotariado.bachue.calidaddatos.stateless.IInconsistenciaBusiness;
import co.gov.supernotariado.bachue.calidaddatos.stateless.IInconsistenciaCampoBusiness;
import co.gov.supernotariado.bachue.calidaddatos.stateless.IInconsistenciaCampoTurnoBusiness;
import co.gov.supernotariado.bachue.calidaddatos.stateless.IMetadataBusiness;
import co.gov.supernotariado.bachue.calidaddatos.utilidades.FacesUtils;
import co.gov.supernotariado.bachue.calidaddatos.utilidades.GeneradorGrowlGenerico;
import weblogic.javaee.TransactionTimeoutSeconds;

/**
 * Clase tipo managed bean de la capa de UI (User Interface). <br>
 * Manipula operaciones y propiedades que permiten manejar <br>
 * la visualizacion de componentes JSF para Corregir inconsistencias.<br>
 * Implementada para realizar validacion de vista y pasar parametros a metodo de
 * consulta
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@ManagedBean(name = "beanCorregirInconsistencias")
@ViewScoped
@TransactionTimeoutSeconds(300)
public class BeanCorregirInconsistencias implements Serializable {

	/**
	 * Define la constante CL_LOGGER.
	 */
	final static Logger CL_LOGGER = Logger.getLogger(BeanCorregirInconsistencias.class);

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = -7888751341198905641L;
	
	/** Constante para sesion remote user loguin */
	public static final String SESION_REMOTE_USER = "remoteUser";
	
	/** Constante para sesion nombre usuario */
	public static final String SESION_NOMBRE_USUARIO = "nombreusuario";
	
	/** Constante para  id sesion */
	public static final String SESION_ID = "idsesion";

	/** Constante para data del usuario en sesion */
	public static final String SESION_USER_DATA = "sesionUserData";
	
	@ManagedProperty(value = "#{txt_bioclient}")
	public transient ResourceBundle irb_bundleTxtBioclient;

	

	// Atributo que recibe los parametros de de consulta de las inconsistencias
	/**
	 * Atributo de instancia tipo ConsultaInconsistenciasDTO para definir la
	 * propiedad consulta inconsistencias.
	 */
	private ConsultaInconsistenciasDTO icid_consultaInconsistenciasDTO;
	// Atributo tipo lista que contiene la informacion de las inconsistencias
	// encontradas
	/**
	 * Atributo de instancia tipo lista de InformacionInconsistenciaDTO para definir
	 * la propiedad informacion inconsistencia.
	 */
	private transient List<InformacionInconsistenciaDTO> ilii_informacionInconsistenciaDto;
	// Atributo que tiene los circulos registrales
	/**
	 * Atributo de instancia tipo lista de CirculoRegistralDTO para definir la
	 * propiedad circulo registral.
	 */
	private List<CirculoRegistralDTO> ilcr_circuloRegistralDto;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * msg.
	 */
	private String is_msg;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * archivo.
	 */
	private String is_archivo;

	/**
	 * Atributo de instancia tipo ICirculoRegistralBusiness para definir la
	 * propiedad circulo registral business.
	 */
	@EJB
	private ICirculoRegistralBusiness iicrb_iLCirculoRegistralBusiness;

	/**
	 * Atributo de instancia tipo IMetadataBusiness para definir la propiedad
	 * metada business.
	 */
	@EJB
	private IMetadataBusiness iimb_iLMetadaBusiness;

	/**
	 * Atributo de instancia tipo IInconsistenciaCampoBusiness para definir la
	 * propiedad inconsistencia campo business.
	 */
	@EJB
	private IInconsistenciaCampoBusiness iicb_iLInconsistenciaCampoBusiness;

	/**
	 * Atributo de instancia tipo IInconsistenciaCampoTurnoBusiness para definir la
	 * propiedad incosistencias campo turno bussines.
	 */
	@EJB
	private IInconsistenciaCampoTurnoBusiness iictb_incosistenciasCampoTurnoBussines;

	/**
	 * Atributo de instancia tipo IInconsistenciaBusiness para definir la propiedad
	 * inconsistencias bussines.
	 */
	@EJB
	private IInconsistenciaBusiness iib_iInconsistenciasBussines;

	/**
	 * Atributo para definir la propiedad mensajes dto.
	 */
	private MensajesDTO mensajesDto;
	
	/**
	 * Atributo para definir la propiedad mensajes dto.
	 */
	private UtilidadClienteBusDTO utilidadClienteBusDto;

	/**
	 * tributo para definir la propiedad servicio biometria dto.
	 */
	private ServicioBiometriaDTO isb_servicioBiometriaDto;


	/**
	 * Atributo de instancia tipo BigDecimal para definir la propiedad resultado
	 * inconsitencias.
	 */
	private BigDecimal ib_resultadoInconsitencias;

	/**
	 * Atributo de instancia tipo BigDecimal para definir la propiedad
	 * inconsistenciasnocorregidas.
	 */
	private BigDecimal ib_inconsistenciasnocorregidas;

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad
	 * estado.
	 */
	private String is_estado;

	/**
	 * Atributo de instancia tipo verdadero/falso para definir la propiedad
	 * corregido.
	 */
	private Boolean ib_corregido;

	/**
	 * Atributo de instancia tipo verdadero/falso para definir la propiedad
	 * resultado.
	 */
	private Boolean ib_resultado;

	/**
	 * Atributo de instancia tipo verdadero/falso para definir la propiedad
	 * nocorregido.
	 */
	private Boolean ib_nocorregido;

	/**
	 * Atributo de instancia tipo verdadero/falso <br>
	 * Se usar para definir si ya hay un usuario logueado corretamente o no, contra el segundo factor de autenticacino/biometria 
	 */
	private Boolean ib_usuario;


	/**
	 * Atributo de instancia tipo Random para definir la propiedad random.
	 * Permite generar identificadores de sesion
	 */
	private static Random ir_random = new Random();

	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad de nombre de usuario.<br>
	 * Se usa para obtener y setear nombre de usuario que va a utilizar la aplicacion.
	 */
	private String is_nombreUsuario;
	
	/**
	 * Atributo de instancia tipo cadena de caracteres para definir la propiedad session <br> 
	 * Representacion string de un random que identifica la sesion contra el segundo factor de autenticacino/biometria
	 */
	private String is_sesion;
	
	/**
	 * Atributo para almacenar la data del usuario en sesion
	 */
	private Map<String,String> im_sesionUserData;

	/**
	 * Inicializa el objeto.
	 */
	@PostConstruct
	public void init() {
		this.listarCirculoRegistral();
		this.ib_usuario=false;
		isb_servicioBiometriaDto= new ServicioBiometriaDTO();
		utilidadClienteBusDto = new UtilidadClienteBusDTO();
		urlVariable();
		
		initOrValidateSessionData();
		
	}
	
	private void initOrValidateSessionData() {
		CL_LOGGER.info("Info:BeanCorregirInconsistencias:initOrValidateSessionData:Mensaje: Inicia validacion de informacion de sesion");
	
		HttpSession https_sesion = FacesUtils.getSession(false);
		HttpServletRequest https_request = FacesUtils.getRequest();
		HttpServletResponse https_response = FacesUtils.getResponse();
		
		boolean lb_superoSegundoFactor = false;
		boolean lb_expiroLogin = false;
		
		String ls_remoteUser = null;
		String ls_nombreUsuario = null;
		String ls_idSesion = null;
		
		Map <String, String> lm_sesionUserData = new LinkedHashMap<String, String>();
		
		if ((https_sesion != null) && (StringUtils.isNotBlank((String) https_sesion.getAttribute(SESION_NOMBRE_USUARIO))
				|| StringUtils.isNotBlank(https_request.getRemoteUser()))) {

			ls_remoteUser = https_request.getRemoteUser();
			CL_LOGGER.info("Info:BeanCorregirInconsistencias:logSessionInfoState: Remote user: " + String.valueOf(ls_remoteUser));
			
			ls_nombreUsuario = (String) https_sesion.getAttribute(SESION_NOMBRE_USUARIO);
			ls_idSesion = (String) https_sesion.getAttribute(SESION_ID);
			
			if(StringUtils.isNotBlank(ls_remoteUser))
			{
				//Actualiza remoteUser solo si existe si no, usa el que tenga el atributo atado a la sesion del request http (remoto o local)
				lm_sesionUserData.put(SESION_REMOTE_USER, String.valueOf(ls_remoteUser));
				ls_nombreUsuario = ls_remoteUser;
			}
			
			this.is_nombreUsuario = ls_nombreUsuario;
			this.is_sesion = ls_idSesion;
			
			lm_sesionUserData.put(SESION_NOMBRE_USUARIO, String.valueOf(ls_nombreUsuario));
			lm_sesionUserData.put(SESION_ID, String.valueOf(ls_idSesion));
			
		}
		this.setIm_sesionUserData(lm_sesionUserData);
		logSessionInfoState();
	}
	
	public UtilidadClienteBusDTO urlVariable() {
		
		utilidadClienteBusDto.setIs_urlWsdlDeviceServices(irb_bundleTxtBioclient.getString("Bioclient.URL_WSDL_DEVICE_SERVICES"));
		utilidadClienteBusDto.setIs_webServiceNameBiometria(irb_bundleTxtBioclient.getString("Bioclient.WEBSERVICE_NAME_BIOMETRIA"));
		utilidadClienteBusDto.setIs_nameSpace(irb_bundleTxtBioclient.getString("Bioclient.WSDL_NAMESPACE"));
		
		return utilidadClienteBusDto;
		
	}

	private void logSessionInfoState() {
		
		
		Map <String, String> sessionInfo = new LinkedHashMap<String, String>();
		sessionInfo.put("ir_random", String.valueOf(ir_random));
		sessionInfo.put("is_nombreUsuario", String.valueOf(is_nombreUsuario));
		sessionInfo.put("is_sesion", String.valueOf(is_sesion));
		sessionInfo.put("ib_usuario", String.valueOf(ib_usuario));
		sessionInfo.put("is_estado", String.valueOf(is_estado));
		
		CL_LOGGER.info("Info:BeanCorregirInconsistencias:logSessionInfoState: Informacion de sesion del bean");
		String mensaje = "";
		for (String key: sessionInfo.keySet()) {
			mensaje += key + ": " + String.valueOf(sessionInfo.get(key)) + "\n";
		}
		CL_LOGGER.info(mensaje);
		
		CL_LOGGER.info("Info:BeanCorregirInconsistencias:logSessionInfoState: Informacion de sesion atada a la peticion");
		mensaje = "";
		for (String key: im_sesionUserData.keySet()) {
			mensaje += key + ": " + String.valueOf(im_sesionUserData.get(key)) + "\n";
		}
		CL_LOGGER.info(mensaje);
	}

	/**
	 * Metodo que realiza la consulta de los circulos registrales o ORIP.
	 */
	private void listarCirculoRegistral() {
		ilcr_circuloRegistralDto = iicrb_iLCirculoRegistralBusiness.listaCirculoRegistralDTO();
		icid_consultaInconsistenciasDTO = new ConsultaInconsistenciasDTO();
		mensajesDto = new MensajesDTO();
	}

	/**
	 * Metodo que realiza la consulta de las inconsistencias.
	 */
	public void consultaInconsistencias() {
		try {
			boolean lb_validacionDatos = validacionesEntrada();

			if (lb_validacionDatos) {
				if (icid_consultaInconsistenciasDTO.getIs_numeroTurno() != null
						&& !icid_consultaInconsistenciasDTO.getIs_numeroTurno().equals("")) {
					ilii_informacionInconsistenciaDto = iictb_incosistenciasCampoTurnoBussines
							.consultaInformacionInconsistenciaTurno(icid_consultaInconsistenciasDTO);
				}
				if (icid_consultaInconsistenciasDTO.getIs_numeroMatricula() != null
						&& !icid_consultaInconsistenciasDTO.getIs_numeroMatricula().equals("")) {
					ilii_informacionInconsistenciaDto = iicb_iLInconsistenciaCampoBusiness
							.consultarInformacionInconsistenciaMatricula(icid_consultaInconsistenciasDTO);
				}
				if (icid_consultaInconsistenciasDTO.getIs_numeroMatricula() != null
						&& !icid_consultaInconsistenciasDTO.getIs_numeroMatricula().isEmpty()) {
					is_estado = "Numero de matricula: ";
				} else {
					is_estado = "Numero turno: ";
				}
				if (this.ilii_informacionInconsistenciaDto.isEmpty()) {
					throw new ExcepcionesNegocio(EnumExcepcionesGenerales.DATOS_INEXISTENTES);
				} else {
					moverWizard(true);

				}
				moverWizard(true);
			}
		} catch (final Exception ae_exception) {
			GeneradorGrowlGenerico.manejadorExcepcionesPresentacion(ae_exception);
		}
	}
	/**
	 * Metodo que obtiene/inicia una sesion de segundo factor de autenticacion/biometria.<br>
	 * Hace set del identificador de la sesion en el dto del servicio de biometria
	 */

	public void validarUsuarioBiometria() 
	{
		CL_LOGGER.info("Importante:BeanCorregirInconsistencias:validarUsuarioBiometria:Mensaje: Inicia una validacion de segundo factor");
		String ls_excepcion =EnumEstadoProcesoInconsistencias.CAMPOS_VACIOS.getIs_descripcion();
				
		try {

			if (StringUtils.isBlank(is_nombreUsuario)) {
				GeneradorGrowlGenerico.generarMensajeInformacionInconsistencia(ls_excepcion);
			}else {
				
				// TODO Revisar si existe sesion en el sesionUserData para ver si es reutilzable (Mejora)
				is_sesion = Integer.toString(ir_random.nextInt());
				
				isb_servicioBiometriaDto.setIs_sesion(is_sesion);
				TipoSalidaSesionSalidaWSDTO ltsss_TipoSalidaSesionSalidaWsDto = this.iicb_iLInconsistenciaCampoBusiness.obtenerSesion(isb_servicioBiometriaDto, utilidadClienteBusDto); 
				
				CL_LOGGER.info("Importante:BeanCorregirInconsistencias:validarUsuarioBiometria:Mensaje: Salida ObtenerSesion:" + ltsss_TipoSalidaSesionSalidaWsDto);
				
				this.validarUser();

			}

		} catch (Exception ae_exception) {
			CL_LOGGER.error("Importante:BeanCorregirInconsistencias:validarUsuarioBiometria:Excepcion:" + ae_exception.getMessage());
			GeneradorGrowlGenerico.manejadorExcepcionesPresentacion(ae_exception);
		}
		
		logSessionInfoState();
		
		CL_LOGGER.info("Importante:BeanCorregirInconsistencias:validarUsuarioBiometria:Mensaje: Termina una validacion de segundo factor");
	}

	/**
	 * Metodo implementado para validar los usuarios de segundo factor de autenticacion/biometria.<br>
	 * Envia el evento de coneccion y verify al servicio de biometria, por medio de websocket con biocliente local.
	 */

	public void validarUser()
	{ 		
		CL_LOGGER.info("Importante:BeanCorregirInconsistencias:validarUser:Mensaje: Inicia validacion usuario");
		
		//Trama que se va a a enviar al bioclient para verificar por segundo factor de autenticacion
		String ls_userid = "bachue://verify@"+is_sesion+"@" + is_nombreUsuario + "";
		
		CL_LOGGER.info("Importante:BeanCorregirInconsistencias:validarUser:Mensaje: Trama=" + ls_userid);
		
		isb_servicioBiometriaDto.setIs_sesion(is_sesion);
		PrimeFaces.current().executeScript("connect('"+ls_userid+"');");
		isb_servicioBiometriaDto.setIs_sesion(is_sesion);
		logSessionInfoState();
		
		CL_LOGGER.info("Importante:BeanCorregirInconsistencias:validarUser:Mensaje: Termina validacion usuario");
	}
	
	/**
	 * Valida que exista una sesion de segundo factor de autenticacion creada (la obtiene) y
	 * cambia el flag que autoriza al usuario a moverse a la siguiente pantalla de la aplicacion 
	 */
	public void validarUsuarioServicios()
	{ 	
		CL_LOGGER.info("Importante:BeanCorregirInconsistencias:validarUsuarioServicios:Mensaje: Inicia una validacion de segundo factor");
		
		isb_servicioBiometriaDto.setIs_sesion(is_sesion);

		SesionWSDTO ls_sesionWsdto = this.iicb_iLInconsistenciaCampoBusiness.obtenerSesion(isb_servicioBiometriaDto, utilidadClienteBusDto).getIs_sesionVo();
		CL_LOGGER.info(ls_sesionWsdto);
		
		ib_usuario=ls_sesionWsdto.getIb_resultado();
		
		if (ls_sesionWsdto.getIb_resultado()==false) {
			String ls_excepcion =EnumEstadoProcesoInconsistencias.CAMPOS_ERROR.getIs_descripcion();
			GeneradorGrowlGenerico.generarMensajeInformacionInconsistencia(ls_excepcion);
		}
		else {			
			//Se ata a la sesion la informacion que fue validada exitoramente con segundo factor de autenticacion
			HttpSession        lhs_httpSession     = FacesUtils.getSession(false); //False no recrea sesion
			lhs_httpSession.setAttribute(SESION_NOMBRE_USUARIO, is_nombreUsuario);
			lhs_httpSession.setAttribute(SESION_ID, is_sesion);
			
			// Objeto mutable que representa info de la sesion util para logs y par contrastar
			Map <String, String> lm_sesionUserData = new LinkedHashMap<String, String>();
			lm_sesionUserData.put(SESION_REMOTE_USER, String.valueOf(is_nombreUsuario));
			lm_sesionUserData.put(SESION_NOMBRE_USUARIO, String.valueOf(is_nombreUsuario));
			lm_sesionUserData.put(SESION_ID, String.valueOf(is_sesion));
			
			this.setIm_sesionUserData(lm_sesionUserData);
		}
		logSessionInfoState();
		CL_LOGGER.info("Importante:BeanCorregirInconsistencias:validarUsuarioServicios:Mensaje: Termina una validacion de segundo factor");

	}	

	/**
	 * Metodo que valida los parametros de entrada.
	 *
	 * @return true, si se cumple o la accion se realiza exitosamente, false en caso
	 *         contrario.
	 */

	public boolean validacionesEntrada() {
		String ls_mensaje = "";
		String ls_matricula = "";
		Boolean lb_valida = true;
		try {
			if (icid_consultaInconsistenciasDTO.getIs_idCirculoRegistral() == null
					|| icid_consultaInconsistenciasDTO.getIs_idCirculoRegistral().equals("")) {
				lb_valida &= false;
				ls_mensaje += EnumEstadoProcesoInconsistencias.ORIP.getIs_descripcion();
			}

			if ((icid_consultaInconsistenciasDTO.getIs_numeroTurno() == null
					|| icid_consultaInconsistenciasDTO.getIs_numeroTurno().equals(""))
					&& (icid_consultaInconsistenciasDTO.getIs_numeroMatricula() == null
					|| icid_consultaInconsistenciasDTO.getIs_numeroMatricula().equals(""))) {
				lb_valida &= false;
				ls_matricula +=  EnumEstadoProcesoInconsistencias.MATRICULA_TURNO.getIs_descripcion();
			}

			if ((icid_consultaInconsistenciasDTO.getIs_numeroTurno() != null
					&& !icid_consultaInconsistenciasDTO.getIs_numeroTurno().equals(""))
					&& (icid_consultaInconsistenciasDTO.getIs_numeroMatricula() != null
					&& !icid_consultaInconsistenciasDTO.getIs_numeroMatricula().equals(""))) {
				lb_valida &= false;
				ls_matricula += EnumEstadoProcesoInconsistencias.MATRICULA_TURNO_ERROR.getIs_descripcion();
			}
			if (!StringUtils.isEmpty(ls_mensaje)) {
				GeneradorGrowlGenerico.generarMensajeInformacionInconsistencia(ls_mensaje);
			}
			if (!StringUtils.isEmpty(ls_matricula)) {
				GeneradorGrowlGenerico.generarMensajeInformacionMatricula(ls_matricula);		
			}

		} catch (Exception ae_exception) {
			GeneradorGrowlGenerico.manejadorExcepcionesPresentacion(ae_exception);
		}
		return lb_valida;
	}

	/**
	 * Metodo que realiza el cambio de las pestanas del wizard.
	 *
	 * @return id de la siguente pestana capturada por el evento
	 */

	public void llamarFuncionValidador() {
		ib_nocorregido = false;
		if (iicb_iLInconsistenciaCampoBusiness.validarMatriculaEncolada(
				icid_consultaInconsistenciasDTO.getIs_numeroMatricula(),
				icid_consultaInconsistenciasDTO.getIs_idCirculoRegistral())) {
			this.mensajesDto.setMensaje(EnumMensajesImagenes.MENSAJE_MATRICULA_ENCOLADA_SIN_PROCESAR);
			ib_resultado = false;

			moverWizard(true);
		} else {
			this.iicb_iLInconsistenciaCampoBusiness.encolaMatriculasInconsistentes(icid_consultaInconsistenciasDTO);
			this.mensajesDto.setMensaje(EnumMensajesImagenes.MENSAJE_MATRICULA_ENCOLADA);
			ib_resultado = false;
			moverWizard(true);
		}
	}

	/**
	 * Metodo que optiene la cantidad de matriculas corregidas.
	 */
	public void obtenerRespuestaMatricula() {
		ib_resultadoInconsitencias = this.iicb_iLInconsistenciaCampoBusiness.estadoC(icid_consultaInconsistenciasDTO);
		if (ib_resultadoInconsitencias != null) {
			ib_corregido = true;
		} else {
			ib_corregido = false;
		}
		ib_inconsistenciasnocorregidas = this.iicb_iLInconsistenciaCampoBusiness
				.estadoN(icid_consultaInconsistenciasDTO);
		if (ib_inconsistenciasnocorregidas != null) {
			ib_nocorregido = true;
		} else {
			ib_nocorregido = false;
		}
	}

	/**
	 * Metodo que guarda la infomacion en DB de cada una de la inconsistencias.
	 *
	 * @param aii_informacionInconsistenciasDto guarda los parametros que necesita
	 *                                          la funcion Guardar
	 */

	public void guardarInconsistencia(InformacionInconsistenciaDTO aii_informacionInconsistenciasDto) {
		try {

			if (aii_informacionInconsistenciasDto.getId_fechaNueva() != null && (aii_informacionInconsistenciasDto
					.getIm_metadataDto().getIs_tipoDato().equals("DATE")
					|| aii_informacionInconsistenciasDto.getIm_metadataDto().getIs_tipoDato().equals("TIMESTAMP"))) {
				SimpleDateFormat lsdf_formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				aii_informacionInconsistenciasDto.setIs_nuevoValor(
						lsdf_formatoFecha.format(aii_informacionInconsistenciasDto.getId_fechaNueva()));
			}

			if (aii_informacionInconsistenciasDto.getIs_nuevoValor() == null
					|| aii_informacionInconsistenciasDto.getIs_nuevoValor().isEmpty()
					|| aii_informacionInconsistenciasDto.getIs_observaciones().isEmpty()) {
				String ls_mensaje =EnumEstadoProcesoInconsistencias.CAMPOS_ERROR.getIs_descripcion();
				GeneradorGrowlGenerico.generarMensajeInformacionInconsistencia(ls_mensaje);		
			}
			else {
				this.iicb_iLInconsistenciaCampoBusiness.guardaInconsistencia(aii_informacionInconsistenciasDto);
				String ls_mensajeInf =EnumEstadoProcesoInconsistencias.CAMPOS_GUARDADOS.getIs_descripcion();
				GeneradorGrowlGenerico.generarMensajeInformacionInconsistencia(ls_mensajeInf);	

			}
		} catch (Exception ae_exception) {
			GeneradorGrowlGenerico.manejadorExcepcionesPresentacion(ae_exception);
		}
	}


	/**
	 * Metodo que mueve el Wizard.
	 *
	 * @param ab_siguiente el parametro siguiente
	 */
	public void moverWizard(final Boolean ab_siguiente) {
		if (ab_siguiente) // mover wizard
		{
			PrimeFaces.current().executeScript("PF('wizardGenerico').next();");
		} else {
			PrimeFaces.current().executeScript("PF('wizardGenerico').back();");
		}
	}


	/**
	 * Metodo que realiza el llamdo del promotor de bachue.
	 */
	public void llamarPromotorBachue()  {
		try {
			if (icid_consultaInconsistenciasDTO.getIs_numeroMatricula() != null) {
				this.iicb_iLInconsistenciaCampoBusiness.promotorPL(getIcid_consultaInconsistenciasDTO());
				if (icid_consultaInconsistenciasDTO.getIs_respuesta()!=null) {
					GeneradorGrowlGenerico.generarMensajeInformacionInconsistencia(icid_consultaInconsistenciasDTO.getIs_respuesta());		
				}else {
					String ls_prueba  =EnumEstadoProcesoInconsistencias.PROCEDIMIENTO_EXITOSO.getIs_descripcion();
					GeneradorGrowlGenerico.generarMensajeInformacionInconsistencia(ls_prueba);
				}
			}else {
				this.iicb_iLInconsistenciaCampoBusiness.promotorBachueTurnoPL(getIcid_consultaInconsistenciasDTO());
			}

		} 
		catch (Exception ae_exception) {
			GeneradorGrowlGenerico.manejadorExcepcionesPresentacion(ae_exception);
		}

	}




	// ****** GETTERS AND SETTERS ******

	/**
	 * Obtiene el valor para la propiedad msg.
	 *
	 * @return El valor de la propiedad msg
	 */
	public String getIs_msg() {
		return is_msg;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad msg.
	 *
	 * @param as_msg el nuevo valor para la propiedad msg
	 */
	public void setIs_msg(String as_msg) {
		this.is_msg = as_msg;
	}

	/**
	 * Obtiene el valor para la propiedad circulo registral DTO.
	 *
	 * @return El valor de la propiedad circulo registral DTO
	 */
	public List<CirculoRegistralDTO> getIlcrd_circuloRegistralDTO() {
		return ilcr_circuloRegistralDto;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad circulo registral DTO.
	 *
	 * @param alcrd_circuloRegistralDTO el nuevo valor para la propiedad circulo
	 *                                  registral DTO
	 */
	public void setIlcrd_circuloRegistralDTO(List<CirculoRegistralDTO> alcrd_circuloRegistralDTO) {
		this.ilcr_circuloRegistralDto = alcrd_circuloRegistralDTO;
	}

	/**
	 * Obtiene el valor para la propiedad archivo.
	 *
	 * @return El valor de la propiedad archivo
	 */
	public String getIs_archivo() {
		return is_archivo;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad archivo.
	 *
	 * @param as_archivo el nuevo valor para la propiedad archivo
	 */
	public void setIs_archivo(String as_archivo) {
		this.is_archivo = as_archivo;
	}

	/**
	 * Obtiene el valor para la propiedad consulta inconsistencias DTO.
	 *
	 * @return El valor de la propiedad consulta inconsistencias DTO
	 */
	public ConsultaInconsistenciasDTO getIcid_consultaInconsistenciasDTO() {
		return icid_consultaInconsistenciasDTO;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad consulta inconsistencias DTO.
	 *
	 * @param acid_consultaInconsistenciasDTO el nuevo valor para la propiedad
	 *                                        consulta inconsistencias DTO
	 */
	public void setIcid_consultaInconsistenciasDTO(ConsultaInconsistenciasDTO acid_consultaInconsistenciasDTO) {
		this.icid_consultaInconsistenciasDTO = acid_consultaInconsistenciasDTO;
	}

	/**
	 * Obtiene el valor para la propiedad informacion inconsistencia DTO.
	 *
	 * @return El valor de la propiedad informacion inconsistencia DTO
	 */
	public List<InformacionInconsistenciaDTO> getIlic_informacionInconsistenciaDTO() {
		return ilii_informacionInconsistenciaDto;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad informacion inconsistencia DTO.
	 *
	 * @param aic_informacionInconsistenciaDTO el nuevo valor para la propiedad
	 *                                         informacion inconsistencia DTO
	 */
	public void setIlic_informacionInconsistenciaDTO(
			List<InformacionInconsistenciaDTO> aic_informacionInconsistenciaDTO) {
		this.ilii_informacionInconsistenciaDto = aic_informacionInconsistenciaDTO;
	}

	/**
	 * Obtiene el valor para la propiedad resultado inconsitencias.
	 *
	 * @return El valor de la propiedad resultado inconsitencias
	 */
	public BigDecimal getIs_resultadoInconsitencias() {
		return ib_resultadoInconsitencias;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad resultado inconsitencias.
	 *
	 * @param as_resultadoInconsitencias el nuevo valor para la propiedad resultado
	 *                                   inconsitencias
	 */
	public void setIs_resultadoInconsitencias(BigDecimal as_resultadoInconsitencias) {
		this.ib_resultadoInconsitencias = as_resultadoInconsitencias;
	}

	/**
	 * Obtiene el valor para la propiedad inconsistenciasnocorregidas.
	 *
	 * @return El valor de la propiedad inconsistenciasnocorregidas
	 */
	public BigDecimal getIs_inconsistenciasnocorregidas() {
		return ib_inconsistenciasnocorregidas;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad inconsistenciasnocorregidas.
	 *
	 * @param as_inconsistenciasnocorregidas el nuevo valor para la propiedad
	 *                                       inconsistenciasnocorregidas
	 */
	public void setIs_inconsistenciasnocorregidas(BigDecimal as_inconsistenciasnocorregidas) {
		this.ib_inconsistenciasnocorregidas = as_inconsistenciasnocorregidas;
	}

	/**
	 * Obtiene el valor para la propiedad corregido.
	 *
	 * @return El valor de la propiedad corregido
	 */
	public Boolean getIs_corregido() {
		return ib_corregido;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad corregido.
	 *
	 * @param as_corregido el nuevo valor para la propiedad corregido
	 */
	public void setIs_corregido(Boolean as_corregido) {
		this.ib_corregido = as_corregido;
	}

	/**
	 * Obtiene el valor para la propiedad nocorregido.
	 *
	 * @return El valor de la propiedad nocorregido
	 */
	public Boolean getIs_nocorregido() {
		return ib_nocorregido;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad nocorregido.
	 *
	 * @param as_nocorregido el nuevo valor para la propiedad nocorregido
	 */
	public void setIs_nocorregido(Boolean as_nocorregido) {
		this.ib_nocorregido = as_nocorregido;
	}

	/**
	 * Obtiene el valor para la propiedad estado.
	 *
	 * @return El valor de la propiedad estado
	 */
	public String getIs_estado() {
		return is_estado;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad estado.
	 *
	 * @param as_estado el nuevo valor para la propiedad estado
	 */
	public void setIs_estado(String as_estado) {
		this.is_estado = as_estado;
	}

	/**
	 * Obtiene el valor para la propiedad mensajes dto.
	 *
	 * @return El valor de la propiedad mensajes dto
	 */
	public MensajesDTO getMensajesDto() {
		return mensajesDto;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad mensajes dto.
	 *
	 * @param mensajesDto el nuevo valor para la propiedad mensajes dto
	 */
	public void setMensajesDto(final MensajesDTO mensajesDto) {
		this.mensajesDto = mensajesDto;
	}

	/**
	 * Obtiene el valor para la propiedad resultado.
	 *
	 * @return El valor de la propiedad resultado
	 */
	public Boolean getIs_resultado() {
		return ib_resultado;
	}

	/**
	 * Cambia/actualiza el valor para la propiedad resultado.
	 *
	 * @param as_resultado el nuevo valor para la propiedad resultado
	 */
	public void setIs_resultado(final Boolean as_resultado) {
		this.ib_resultado = as_resultado;
	}


	/**
	 * Cambia/actualiza el valor para la propiedad servicio biometrico.
	 *
	 *  el nuevo valor para la propiedad servicio biometria
	 *                      
	 */
	public ServicioBiometriaDTO getIsb_servicioBiometriaDto() {
		return isb_servicioBiometriaDto;
	}
	/**
	 * Cambia/actualiza el valor para la propiedad servicio biometrico.
	 *
	 * @param asb_servicioBiometriaDto el nuevo valor para la propiedad servicio biometria
	 *                      
	 */
	public void setIsb_servicioBiometriaDto(ServicioBiometriaDTO asb_servicioBiometriaDto) {
		this.isb_servicioBiometriaDto = asb_servicioBiometriaDto;
	}
	/**
	 * Cambia/actualiza el valor para la propiedad Ib_usuario.
	 *
	 */

	public Boolean getIb_usuario() {
		return ib_usuario;
	}


	/**
	 * Cambia/actualiza el valor para la propiedad ab_usuario.
	 *
	 */
	public void setIb_usuario(Boolean ab_usuario) {
		this.ib_usuario = ab_usuario;
	}

	public String getIs_nombreUsuario() {
		return is_nombreUsuario;
	}

	public void setIs_nombreUsuario(String as_nombreUsuario) {
		this.is_nombreUsuario = as_nombreUsuario;
	}

	public String getIs_sesion() {
		return is_sesion;
	}

	public void setIs_sesion(String as_sesion) {
		this.is_sesion = as_sesion;
	}

	public Map<String,String> getIm_sesionUserData() {
		return im_sesionUserData;
	}
	
	public ResourceBundle getIrb_bundleTxtBioclient() {
		return irb_bundleTxtBioclient;
	}

	public void setIrb_bundleTxtBioclient(ResourceBundle irb_bundleTxtBioclient) {
		this.irb_bundleTxtBioclient = irb_bundleTxtBioclient;
	}

	public void setIm_sesionUserData(Map<String,String> am_sesionUserData) {
		
		if(am_sesionUserData != null)
		{
			String ls_remoteUser = am_sesionUserData.get(SESION_REMOTE_USER);
			String ls_nombreUsuario = am_sesionUserData.get(SESION_NOMBRE_USUARIO);
			String ls_idSesion = am_sesionUserData.get(SESION_ID);
			
			HttpSession        lhs_httpSession     = FacesUtils.getSession(false); //False no recrea sesion
			HttpServletRequest https_request       = FacesUtils.getRequest();
			
			if(StringUtils.isBlank(ls_remoteUser)) // Si la propiedad de remoteUser del map esta en blanco, valida por si acaso si hay algo en la sesion CA administrad por weblogic con getRemoteUser
			{
				ls_remoteUser = https_request.getRemoteUser();
				
				if (StringUtils.isNotBlank(ls_remoteUser)) {
					ls_nombreUsuario = ls_remoteUser;
					this.is_nombreUsuario = ls_remoteUser;
				}
			}
			if (StringUtils.isBlank(ls_idSesion)) // Si la propiedad de sesion del map esta en blanco, valida por si acaso si hay algo en la sesion atada al request
			{
				ls_idSesion = (String) lhs_httpSession.getAttribute(SESION_ID);
				if (StringUtils.isNotBlank(ls_idSesion)) {
					this.is_sesion =  ls_idSesion;
				}
			}
			//Refresca id/nombre de usuario en la data de sesion
			am_sesionUserData.put(SESION_REMOTE_USER, ls_remoteUser);
			am_sesionUserData.put(SESION_NOMBRE_USUARIO, ls_nombreUsuario);
			am_sesionUserData.put(SESION_ID, ls_idSesion);
				
			lhs_httpSession.setAttribute(SESION_USER_DATA, am_sesionUserData);
			
			
		}
		this.im_sesionUserData = am_sesionUserData;
	}

	public UtilidadClienteBusDTO getUtilidadClienteBusDto() {
		return utilidadClienteBusDto;
	}

	public void setUtilidadClienteBusDto(UtilidadClienteBusDTO utilidadClienteBusDto) {
		this.utilidadClienteBusDto = utilidadClienteBusDto;
	}





}