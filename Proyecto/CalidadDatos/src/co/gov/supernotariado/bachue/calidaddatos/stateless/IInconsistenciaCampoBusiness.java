/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ILInconsistenciaCampoBusiness.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.stateless
 * Nombre del elemento: ILInconsistenciaCampoBusiness
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */

package co.gov.supernotariado.bachue.calidaddatos.stateless;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO;
import co.gov.supernotariado.bachue.calidaddatos.dto.InformacionInconsistenciaDTO;
import co.gov.supernotariado.bachue.calidaddatos.dto.ServicioBiometriaDTO;
import co.gov.supernotariado.bachue.calidaddatos.dto.UtilidadClienteBusDTO;
import co.gov.supernotariado.bachue.calidaddatos.services.wsdto.TipoSalidaSesionSalidaWSDTO;

/**
 * Interface de la capa de negocio. <br>
 * Permite definir las operaciones requeridas del recurso inconsistencia campo.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface IInconsistenciaCampoBusiness {

	/**
	 * Metodo que se encarga de consultar las inconsistencias.
	 *
	 * @param acid_consultaInconsistenciasDto el parametro consulta inconsistencias
	 *                                        DTO
	 * @return Resultado para consultar informacion inconsistencia matricula
	 *         retornado como una lista de InformacionInconsistenciaDTO
	 */

	public List<InformacionInconsistenciaDTO> consultarInformacionInconsistenciaMatricula(
			ConsultaInconsistenciasDTO acid_consultaInconsistenciasDto);

	/**
	 * Metodo que se encarga de llevar la informci�n de las inconsistencias para ser
	 * guardada en base de datos.
	 * 
	 * @param aic_inconstenciaCampoDto se encarga de llevar la informacion que se
	 *                                  necesita para realizar el guardado el base
	 *                                  de datos.
	 * @return Retorna 0 o 1 dependiendo si fue exitoso o no
	 */

	public Boolean guardaInconsistencia(InformacionInconsistenciaDTO aic_inconstenciaCampoDto);

	/**
	 * Metodo que se encarga de pasar los parametros solicitados para ejecutar el
	 * PLSQL y validar si son correctos o no .
	 *
	 * @param aci_consultaInconsistenciasDto Lleva los parametros que solicita el
	 *                                        plsql
	 * @return Retorna false o true dependiendo si fue exitoso o no
	 */

	public Boolean encolaMatriculasInconsistentes(ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto);

	/**
	 * Metodo que se encarga de consulta que inconsistencias no estan corregidas.
	 *
	 * @param aci_consultaInconsistenciasDto Guarda lo parametros de la consulta
	 * @return Retorna el resultado de la consulta.
	 */

	public BigDecimal estadoN(ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto);

	/**
	 * Metodo que se encarga de consulta que inconsistencias estan corregidas.
	 *
	 * @param aci_consultaInconsistenciasDto Guarda lo parametros de la consulta
	 * @return Retorna el resultado de la consulta.
	 */

	public BigDecimal estadoC(ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto);

	/**
	 * Metodo que valida si la matricula se encuentra en el preceso de validacion.
	 * 
	 * @param as_matriculaValidar Parametro utilizado para consulta.
	 * @param as_circulo          Parametro utilizado para consulta.
	 * @return Retorna una variabale boolean donde TRUE significa que se encuentra
	 *         en proceso y FALSE que va ingresar a ser procesada.
	 */

	public Boolean validarMatriculaEncolada(final String as_matriculaValidar, String as_circulo);

	/**
	 * Metodo que informa al usuario que la matricula ya fue procesa para evitar que
	 * no se vuelva a enviar.
	 *
	 * @param as_matriculaValidar   Parametro utilizado para consulta.
	 * @param as_idCirculoRegistral Parametro utilizado para consulta.
	 * @return Retorna una variabale boolean donde TRUE significa ya fue procesada y
	 *         FALSE que aun no ha sido procesada.
	 */

	public Boolean validarMatriculaProcesada(final String as_matriculaValidar, String as_idCirculoRegistral);

	/**
	 * Metodo que ejecuta la funcion del promotor al esquema de bachue de las
	 * matriculas.
	 *
	 * @param aci_consultaInconsistenciasDto el parametro consulta inconsistencias
	 *                                      dto
	 */

	public String promotorPL(final ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto);

	/**
	 * Metodo que cancela el proceso de la matricula escogida.
	 *
	 * @param as_matriculaValidar el parametro matricula validar
	 */

	public void deshabilitarEstadoProceso(final String as_matriculaValidar);

	/**
	 * Metodo que implementa el servicio de Biometria.
	 *
	 * @param asb_servicioBiometriaDto el parametro servicio biometria dto
	 * @return Resultado para obtener sesion retornado como
	 *         TipoSalidaSesionSalidaWSDTO
	 */
	public TipoSalidaSesionSalidaWSDTO obtenerSesion(ServicioBiometriaDTO asb_servicioBiometriaDto, UtilidadClienteBusDTO utilidadClienteBusDto);

	/**
	 * Metodo que valida las matriculas que estan en proceso de ser validadas .
	 *
	 * @return true, si se cumple o la accion se realiza exitosamente, false en caso
	 *         contrario.
	 */
	public Boolean validarMatriculaEncolada();

	/**
	 * Metodo que ejecuta la funcion del promotor al esquema de bachue de los
	 * turnos.
	 *
	 * @param aci_consultaInconsistenciasDto el parametro consulta inconsistencias
	 *                                      dto
	 */
	public void ejecutarTurnoPL(ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto);

	/**
	 *  Metodo que se encarga de ejecutar el SQL que pasa las inconsistencias a
	 * corregidas a bachue .
	 * 
	 * @param aci_consultaInconsistenciasDto el parametro lc consulta inconsistencias
	 *                                      dto
	 */
	public void promotorBachueTurnoPL(ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto);


}
