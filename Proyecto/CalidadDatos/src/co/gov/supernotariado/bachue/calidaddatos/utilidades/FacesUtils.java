package co.gov.supernotariado.bachue.calidaddatos.utilidades;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jboss.logging.Logger;

public class FacesUtils implements Serializable {
	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Define la constante CL_LOGGER. */
	private static final Logger CL_LOGGER = Logger.getLogger(FacesUtils.class);

	/**
	 * Retorna el valor de boolean faces parameter.
	 *
	 * @param as_parameterName correspondiente al valor del tipo de objeto String
	 * @return el valor de boolean faces parameter
	 */
	public static Boolean getBooleanFacesParameter(String as_parameterName) {
		return BooleanUtils.toBooleanObject(getStringFacesParameter(as_parameterName));
	}

	/**
	 * Retorna el valor de boolean value faces parameter.
	 *
	 * @param as_parameterName correspondiente al valor del tipo de objeto String
	 * @return el valor de boolean value faces parameter
	 */
	public static boolean getBooleanValueFacesParameter(String as_parameterName) {
		return BooleanUtils.toBoolean(getBooleanFacesParameter(as_parameterName));
	}
	

	/**
	 * Retorna el valor de external context.
	 *
	 * @return el valor de external context
	 */
	public static ExternalContext getExternalContext() {
		FacesContext lfc_context;

		lfc_context = getFacesContext();

		return (lfc_context == null) ? null : lfc_context.getExternalContext();
	}

	/**
	 * Retorna el valor de faces context.
	 *
	 * @return el valor de faces context
	 */
	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Retorna el valor de faces parameter.
	 *
	 * @param as_parameterName correspondiente al valor del tipo de objeto String
	 * @return el valor de faces parameter
	 */
	public static Object getFacesParameter(String as_parameterName) {
		ExternalContext lec_context;
		Object lo_parameter;

		lec_context = getExternalContext();

		lo_parameter = (lec_context != null)
				? (StringUtils.isNotBlank(as_parameterName) ? lec_context.getRequestParameterMap().get(as_parameterName)
						: null)
				: null;

		return lo_parameter;
	}

	/**
	 * Retorna el valor de int faces parameter.
	 *
	 * @param as_parameterName correspondiente al valor del tipo de objeto String
	 * @return el valor de int faces parameter
	 */
	public static int getIntFacesParameter(String as_parameterName) {
		return getIntegerFacesParameter(as_parameterName).intValue();
	}

	/**
	 * Retorna el valor de integer faces parameter.
	 *
	 * @param as_parameterName correspondiente al valor del tipo de objeto String
	 * @return el valor de integer faces parameter
	 */
	public static Integer getIntegerFacesParameter(String as_parameterName) {
		return Integer.valueOf(NumberUtils.toInt(getStringFacesParameter(as_parameterName), -1));
	}

	/**
	 * Retorna el valor de long faces parameter.
	 *
	 * @param as_parameterName correspondiente al valor del tipo de objeto String
	 * @return el valor de long faces parameter
	 */
	public static long getLongFacesParameter(String as_parameterName) {
		return getLongWrapperFacesParameter(as_parameterName).longValue();
	}

	/**
	 * Retorna el valor de long wrapper faces parameter.
	 *
	 * @param as_parameterName correspondiente al valor del tipo de objeto String
	 * @return el valor de long wrapper faces parameter
	 */
	public static Long getLongWrapperFacesParameter(String as_parameterName) {
		return Long.valueOf(NumberUtils.toLong(getStringFacesParameter(as_parameterName), -1L));
	}

	/**
	 * Retorna el valor de parameter.
	 *
	 * @param as_parameter correspondiente al valor del tipo de objeto String
	 * @return el valor de parameter
	 */
	public static String getParameter(String as_parameter) {
		HttpServletRequest lhsr_request;

		lhsr_request = getRequest();

		return (lhsr_request != null) ? lhsr_request.getParameter(as_parameter) : null;
	}

	/**
	 * Retorna el valor de request.
	 *
	 * @return el valor de request
	 */
	public static HttpServletRequest getRequest() {
		Object lo_request;

		{
			ExternalContext lec_context;

			lec_context = getExternalContext();
			lo_request = (lec_context == null) ? null : lec_context.getRequest();
		}

		return ((lo_request != null) && lo_request instanceof HttpServletRequest) ? (HttpServletRequest) lo_request
				: null;
	}

	/**
	 * Retorna el valor de response.
	 *
	 * @return el valor de response
	 */
	public static HttpServletResponse getResponse() {
		Object lo_response;

		{
			ExternalContext lec_context;

			lec_context = getExternalContext();
			lo_response = (lec_context == null) ? null : lec_context.getResponse();
		}

		return ((lo_response != null) && lo_response instanceof HttpServletResponse) ? (HttpServletResponse) lo_response
				: null;
	}

	/**
	 * Retorna el valor de session.
	 *
	 * @return el valor de session
	 */
	public static HttpSession getSession() {
		return getSession(true);
	}

	/**
	 * Retorna Objeto o variable de valor session.
	 *
	 * @param ab_crearSesion de ab crear sesion
	 * @return el valor de session
	 */
	public static HttpSession getSession(boolean ab_crearSesion) {
		HttpServletRequest lhsr_request;

		lhsr_request = getRequest();

		return (lhsr_request != null) ? lhsr_request.getSession(ab_crearSesion) : null;
	}

	/**
	 * Retorna el valor de session attribute.
	 *
	 * @param as_name correspondiente al valor del tipo de objeto String
	 * @return el valor de session attribute
	 */
	public static Object getSessionAttribute(String as_name) {
		HttpSession lhs_session;

		lhs_session = getSession();

		return (lhs_session != null) ? lhs_session.getAttribute(as_name) : null;
	}

	/**
	 * Retorna el valor de session attribute as string.
	 *
	 * @param as_name correspondiente al valor del tipo de objeto String
	 * @return el valor de session attribute as string
	 */
	public static String getSessionAttributeAsString(String as_name) {
		Object lo_attribute;

		lo_attribute = getSessionAttribute(as_name);

		return (lo_attribute != null) ? lo_attribute.toString() : null;
	}

	/**
	 * Retorna el valor de session map.
	 *
	 * @return el valor de session map
	 */
	public static Map<String, Object> getSessionMap() {
		ExternalContext lec_context;

		lec_context = getExternalContext();

		return (lec_context == null) ? null : lec_context.getSessionMap();
	}

	/**
	 * Retorna el valor de string faces parameter.
	 *
	 * @param as_parameterName correspondiente al valor del tipo de objeto String
	 * @return el valor de string faces parameter
	 */
	public static String getStringFacesParameter(String as_parameterName) {
		Object lo_parameter;

		lo_parameter = getFacesParameter(as_parameterName);

		return (lo_parameter == null) ? null : lo_parameter.toString();
	}

	/**
	 * Retorna el valor de user.
	 *
	 * @return el valor de user
	 */
	public static String getUser() {
		ExternalContext lec_context;

		lec_context = getExternalContext();

		return (lec_context == null) ? null : lec_context.getRemoteUser();
	}

	/**
	 * Valida la propiedad user in role.
	 *
	 * @param as_roleName correspondiente al valor del tipo de objeto String
	 * @return verdadero si se cumple la condicion, de lo contario retorna falso en
	 *         user in role
	 */
	public static boolean isUserInRole(String as_roleName) {
		ExternalContext lec_context;

		lec_context = getExternalContext();

		return (lec_context != null) ? lec_context.isUserInRole(as_roleName) : false;
	}

	/**
	 * Download file.
	 *
	 * @param as_fileName    correspondiente al valor del tipo de objeto String
	 * @param aba_file       correspondiente al valor del tipo de objeto byte[]
	 * @param as_contentType correspondiente al valor del tipo de objeto String
	 */
	public static void downloadFile(String as_fileName, byte[] aba_file, String as_contentType) {
		if (StringUtils.isNotBlank(as_fileName) && (aba_file != null)) {
			try {
				HttpServletResponse lhsr_response;

				lhsr_response = getResponse();

				if (lhsr_response != null) {
					ServletOutputStream lsos_output;

					lsos_output = lhsr_response.getOutputStream();

					lhsr_response.setContentLength(aba_file.length);

					if (StringUtils.isNotBlank(as_contentType))
						lhsr_response.setContentType(as_contentType);

					lhsr_response.setDateHeader("Expires", 0);
					lhsr_response.setHeader("cache-control", "private, must-revalidate");
					lhsr_response.setHeader("Content-Disposition", "inline; filename=" + as_fileName);
					lhsr_response.setHeader("Content-Transfer-Encoding", "Binary");
					lhsr_response.setHeader("Pragma", "no-cache");
					lhsr_response.setHeader("Pragma", "private");

					lsos_output.write(aba_file);
					lsos_output.flush();
					lsos_output.close();

					lhsr_response.flushBuffer();

					FacesContext.getCurrentInstance().responseComplete();
				}
			} catch (IOException lioe_e) {
				CL_LOGGER.error("downloadFile", lioe_e);
			}
		}
	}

}
