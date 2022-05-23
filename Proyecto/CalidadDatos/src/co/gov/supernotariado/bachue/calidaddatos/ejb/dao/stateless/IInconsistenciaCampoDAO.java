/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ILInconsistenciaCampoDAO.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless
 * Nombre del elemento: ILInconsistenciaCampoDAO
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumEstadoProcesoInconsistencias;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.InformacionInconsistenciaVO;

/**
 * Interface para definir operaciones sobre objetos de acceso a datos (DAO) <br>
 * Define operaciones para manipular el modelo de datos inconsistencia campo.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Local
public interface IInconsistenciaCampoDAO {

	/**
	 * Metodo que se encarga de crear un lista de tipo InformacionInconsistenciaVO
	 * para listar las inconsistencias.
	 *
	 * @param aci_consultaInconsistenciasDto el parametro consulta inconsistencias
	 *                                        DTO
	 * @return Resultado para lii informacion inconsistencia vo retornado como una
	 *         lista de InformacionInconsistenciaVO
	 */

	public List<InformacionInconsistenciaVO> lii_informacionInconsistenciaVo (ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto);  

	/**
	 * Metodo que se encarga de guardar las inconsistencias en la tabla de
	 * inconsistencias campo.
	 *
	 * @param aii_informacionInconsistenciaVo el parametro inconstencia campo
	 * @return true si la operacion fue exitosa
	 */
	public Boolean guardaInconsistencia(InformacionInconsistenciaVO aii_informacionInconsistenciaVo);
	
	/**
	 * Metodo que se encarga de validar la inconsistencias que este en estado N.
	 *
	 * @param aci_consultaInconsistenciasDto el parametro consulta inconsistencias
	 *                                        DTO
	 * @return Resultado para conut N retornado como BigDecimal
	 */
	public BigDecimal estadoN(ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto);
	
	/**
	 * Metodo que se encarga de validar las inconsistencias que se encuentren en estado corregido(C) .
	 *
	 * @param aci_consultaInconsistenciasDto el parametro consulta inconsistencias
	 *                                        DTO
	 * @return Resultado para contar inconsistencias con estado corregido(C) retornado como BigDecimal
	 */
	public BigDecimal estadoC(ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto);

	/**
	 * Metodo que valida las matriculas que estan en proceso de ser validadas .
	 *
	 * @return true si la operacion fue exitosa
	 */
	public Boolean validarMatriculaEncolada();
	
	/**
	 * Metodo que ejecuta el SQL que corrige las inconsistencias.
	 *
	 * @param as_circuloRegistral  id del circulo registral
	 * @param as_numeroMatricula numero la matricula
	 */
	public void ejecutarPL(String as_circuloRegistral, String as_numeroMatricula);
	
	/**
	 * Metodo que actualiza el estado en base de datos.
	 *
	 * @param as_circuloRegistral  id del circulo registral
	 * @param as_numeroMatricula numero la matricula
	 */
	public void actualizarEstado(String as_circuloRegistral, String as_numeroMatricula);
	
	/**
	 * Metodo que deshabilita el proceso de correccion de inconsistencias.
	 *
	 * @param as_matriculaInconsistencia numero de la matricula inconsistente
	 */
	public void deshabilitarEstadoProceso(final String as_matriculaInconsistencia);
	
	/**
	 * Metodo que insertar los varlores que seran validados por el SQL.
	 *
	 * @param aci_consultaInconsistenciasDto datos que se guardan en base de datos
	 * @param eepi_estadoProceso              Estado proceso
	 */
	public void insertarMatriculaValidada(final ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto,
			final EnumEstadoProcesoInconsistencias eepi_estadoProceso);
	
	/**
	 * Metodo que se encarga de ejecutar el SQL que pasa las inconsistencias a
	 * corregidas a bachue .
	 *
	 * @param aci_consultaInconsistenciasDto el parametro lc consulta inconsistencias
	 *                                      dto
	 * @return 
	 */

	public String promotorPL(final ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto);

	/**
	 * Metodo que se encarga de validar el estado de la matriculas.
	 *
	 * @param as_numeroMatricula    numero de matricula
	 * @param as_idCirculoRegistral id del circulo registral
	 * @return Resultado para validar estado matricula retornado como String
	 */
	public String validarEstadoMatricula(String as_numeroMatricula, String as_idCirculoRegistral);

	/**
	 * Metodo implementado para ejecutar el validar de inconsistencias de tipo turno.
	 *
	 * @param aci_consultaInconsistenciasDto el parametro lc consulta inconsistencias
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
