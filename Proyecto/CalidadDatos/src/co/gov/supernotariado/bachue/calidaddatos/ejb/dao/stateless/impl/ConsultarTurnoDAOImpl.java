/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: ConsultarTurnoDAOImpl.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl
 * Nombre del elemento: ConsultarTurnoDAOImpl
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO;
import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IInconsistenciaCampoTurnoDAO;
import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IMetadataDAO;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumEstadoProcesoInconsistencias;
import co.gov.supernotariado.bachue.calidaddatos.interfaces.IEntityManagerFactory;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.InformacionInconsistenciaTurnoVO;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.InformacionInconsistenciaVO;

/**
 * Clase tipo objeto de acceso a datos (DAO). <br>
 * Permite interactuar con la base de datos manipulando y realizando operaciones
 * sobre el modelo de datos relacionado a los turnos. <br>
 * Implementada para realizar la consulta de inconsistencia de tipo turno a la
 * base de datos
 *
 * @author Smartsoft Solutions S.A.S Nota:
 * @version 1.0
 */
@Stateless
@LocalBean
public class ConsultarTurnoDAOImpl  implements IInconsistenciaCampoTurnoDAO {

	/**
	 * Atributo de instancia tipo IEntityManagerFactory para definir la propiedad
	 * entity factory.
	 */
	@EJB
	private IEntityManagerFactory iiemf_entityFactory;

	/**
	 * Define la constante CD_LOGGER.
	 */
	private final static Logger CD_LOGGER = Logger.getLogger(InconsistenciaCampoDAOImpl.class);

	/**
	 * Atributo private de tipo ILMetadataDAO que almacena el valor de la variable
	 * iilm_metadatoDao.
	 */
	@EJB
	private IMetadataDAO iilm_metadatoDao;


	@Override
	public List<InformacionInconsistenciaTurnoVO> consultarInformacionInconsistenciaTurnoVO(
			ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto) {

		List<InformacionInconsistenciaTurnoVO> lliit_informacionInconsistenciaTurnoVo = new ArrayList<>();
		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
		StringBuilder lsb_query = new StringBuilder();
		lsb_query.append("");
		lsb_query.append("select r.ID_TURNO NUMERO_TURNO,\n");
		lsb_query.append("ii.ID_INCONSISTENCIA NUMERO_INCONSISTENCIA,\n");
		lsb_query.append("ii.ID_MODULO ID_MODULO,\n");
		lsb_query.append("ii.TABLA_DESTINO TABLA,\n");
		lsb_query.append("iic.NOMBRE_CAMPO CAMPO,\n");
		lsb_query.append("iic.VALOR_CAMPO VALOR_ACTUAL,\n");
		lsb_query.append("iic.VALOR_CORRECTO_CAMPO NUEVO_VALOR,\n");
		lsb_query.append("iic.PROCESADA_CAMPO\n");
		lsb_query.append("iic.OBSERVACIONES_MATRICULA OBSERVACIONES_MATRICULA,\n");
		lsb_query.append("iic.OBSERVACIONES_NO_CORREGIDO OBSERVACIONES_NO_CORREGIDAS,\n");
		lsb_query.append(
				",(select DESCRIPCION from SDB_INC_TIPO_INCONSISTENCIA iti WHERE iti.id_tipo_inconsistencia = iic.id_tipo_inconsistencia) TIPO_INCONSISTENCIA\n");
		lsb_query.append("from SDB_INC_TURNO r\n");
		lsb_query.append("inner join SDB_INC_INCONSISTENCIA ii on ii.ID_INCONSISTENCIA = r.ID_INCONSISTENCIA\n");
		lsb_query.append(
				"inner join SDB_INC_INCONSISTENCIA_CAMPO iic on ii.ID_INCONSISTENCIA = iic.ID_INCONSISTENCIA and ii.TABLA_DESTINO = iic.TABLA_DESTINO\n");
		lsb_query.append("inner join SDB_PGN_CIRCULO_REGISTRAL cr on ii.ID_CIRCULO = cr.ID_CIRCULO\n");
		lsb_query.append("where r.ID_TURNO = ?\n");
		lsb_query.append("and ii.ID_CIRCULO = ?\n");

		consultarInconsistenciasTurno(aci_consultaInconsistenciasDto, lliit_informacionInconsistenciaTurnoVo,
				lem_entityManager, lsb_query);
		return lliit_informacionInconsistenciaTurnoVo;
	}
	/**
	 * Consultar inconsistencias.
	 * 
	 * @param aci_consultaInconsistenciasDto   el parametro consulta inconsistencias
	 *                                         dto
	 * @param lliit_informacionInconsistenciaTurnoVo el parametro llii informacion
	 *                                         inconsistencia turno vo
	 * @param lem_entityManager                el parametro lem entity manager
	 * @param lsb_query                        el parametro lsb query
	 */
	private void consultarInconsistenciasTurno(ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto,
			List<InformacionInconsistenciaTurnoVO> lliit_informacionInconsistenciaTurnoVo,
			EntityManager lem_entityManager, StringBuilder lsb_query) {
		try {

			Query lq_query = lem_entityManager.createNativeQuery(lsb_query.toString());

			lq_query.setParameter(1, aci_consultaInconsistenciasDto.getIs_numeroTurno());
			lq_query.setParameter(2, aci_consultaInconsistenciasDto.getIs_idCirculoRegistral());

			@SuppressWarnings("unchecked")
			List<Object[]> llo_object = lq_query.getResultList();
			InformacionInconsistenciaTurnoVO liit_informacionInconsistenciaVo;
			if (!llo_object.isEmpty()) {
				for (Object[] obj : llo_object) {
					liit_informacionInconsistenciaVo = new InformacionInconsistenciaTurnoVO();

					if (obj[0] != null) {

						liit_informacionInconsistenciaVo.setIbi_numeroTurno(obj[0].toString());						
					}

					if (obj[1] != null) {

						liit_informacionInconsistenciaVo.setIbi_numeroInconsistencia(new BigInteger(obj[1].toString()));						
					}
					if (obj[2] != null) {						

						liit_informacionInconsistenciaVo.setIi_idModulo(Integer.valueOf(obj[2].toString()));
					}
					if (obj[3] != null) {
						liit_informacionInconsistenciaVo.setIs_tabla(obj[3].toString());
					}
					if (obj[4] != null) {
						liit_informacionInconsistenciaVo.setIs_campo(obj[4].toString());
					}

					if (obj[5] != null) {
						liit_informacionInconsistenciaVo.setIs_valorActual(obj[5].toString());
					}

					if (obj[6] != null) {
						liit_informacionInconsistenciaVo.setIs_nuevoValor(obj[6].toString());
					}

					if (obj[7] != null) {
						liit_informacionInconsistenciaVo.setIs_procesada(obj[7].toString());
					}


					if (obj[8] != null) {
						liit_informacionInconsistenciaVo.setIs_tipoInconsistencia(obj[8].toString());
					}

					liit_informacionInconsistenciaVo.setIm_metadataVo(
							this.iilm_metadatoDao.metadata(liit_informacionInconsistenciaVo.getIs_tabla(),
									liit_informacionInconsistenciaVo.getIs_campo()));

					lliit_informacionInconsistenciaTurnoVo.add(liit_informacionInconsistenciaVo);
				}

			}
		} catch (Exception ae_exception) {
			CD_LOGGER.error("Excepcion:ConsultarTurnoDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage());
		}
	}

	@Override
	public Boolean guardaInconsistencia(final InformacionInconsistenciaVO aii_informacionInconsistenciaVo) {
		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
		String ls_guardarInconsistenciaCampo = "UPDATE SDB_INC_INCONSISTENCIA_CAMPO set VALOR_CORRECTO_CAMPO = ?, OBSERVACIONES_MATRICULA = ? , OBSERVACIONES_NO_CORREGIDO = ?  where ID_INCONSISTENCIA = ? AND NOMBRE_CAMPO LIKE  ?";

		try {

			Query lq_actualiza = lem_entityManager.createNativeQuery(ls_guardarInconsistenciaCampo);
			lq_actualiza.setParameter(1, aii_informacionInconsistenciaVo.getIs_nuevoValor());
			lq_actualiza.setParameter(2, aii_informacionInconsistenciaVo.getIs_observaciones());
			lq_actualiza.setParameter(3, aii_informacionInconsistenciaVo.getIs_observacionesnc());
			lq_actualiza.setParameter(4, aii_informacionInconsistenciaVo.getIbi_numeroInconsistencia());
			lq_actualiza.setParameter(5, aii_informacionInconsistenciaVo.getIs_campo() + "%");
			lq_actualiza.executeUpdate();
			lem_entityManager.flush();
		} catch (final Exception ae_exception) {
			CD_LOGGER.error("Excepcion:ConsultarTurnoDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage());
			return false;
		} finally {
			lem_entityManager.close();
			this.corregirInconsistencias(aii_informacionInconsistenciaVo);
		}
		return true;
	}

	/**
	 * Metodo utilizado para corregir inconsistencias .
	 *
	 * @param aii_informacionInconsistenciaVo parametros para guardar en base de datos
	 * @return true si la operacion fue exitosa
	 */
	public Boolean corregirInconsistencias(final InformacionInconsistenciaVO aii_informacionInconsistenciaVo) {

		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
		String ls_corregirInconsistencias = String.format(
				"UPDATE %s SET %s = '%s' WHERE id_inconsistencia = %s",
				aii_informacionInconsistenciaVo.getIs_tabla(), aii_informacionInconsistenciaVo.getIs_campo(),
				aii_informacionInconsistenciaVo.getIs_nuevoValor(), aii_informacionInconsistenciaVo.getIbi_numeroInconsistencia());

		try {
			Query lq_actualiza = lem_entityManager.createNativeQuery(ls_corregirInconsistencias);
			lq_actualiza.executeUpdate();
		} catch (final Exception ae_exception) {
			CD_LOGGER.error("Excepcion:ConsultarTurnoDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage());
			return false;
		} finally {
			lem_entityManager.close();
		}
		return true;
	}


	/**
	 * Metodo que se utiliza para insertar las matriculas validadas.
	 *
	 * @param aci_consultaInconsistenciasDto parametros que se guardan en base de
	 *                                       datos
	 * @param estadoProceso                  en que estado se encuentra el proceso
	 */
	public void insertarMatriculaValidada(final ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto,
			final EnumEstadoProcesoInconsistencias estadoProceso) {
		try {
			final EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
			final StringBuilder queryBuilder = new StringBuilder();
			queryBuilder.append(
					"INSERT INTO SDB_ACC_CORREGIDO_INCONSISTENCIAS_INCOMPLETAS (ID_ENCOLADO_MATRICULA_INCONSISTENTE"

							+ ",ID_MATRICULA, HABILITADO, CIRCULO_REGISTRAL, ESTADO, USUARIO_CREACION,FECHA_CREACION) VALUES (SQC_ACC_ACCION.NEXTVAL,?,?,?,?,?,?)");
			final Query query = lem_entityManager.createNativeQuery(queryBuilder.toString());

			query.setParameter(1, aci_consultaInconsistenciasDto.getIs_numeroTurno());
			query.setParameter(2, 1);
			query.setParameter(3, aci_consultaInconsistenciasDto.getIs_idCirculoRegistral());
			query.setParameter(4, estadoProceso.getIs_descripcion());
			query.setParameter(5, EnumEstadoProcesoInconsistencias.USUARIO.getIs_descripcion());
			query.setParameter(6, new Date());
			query.executeUpdate();
		} catch (final Exception e) {
			CD_LOGGER.error("Excepcion:ConsultarTurnoDAOImpl:execute:Mensaje: " + e.getMessage());
			CD_LOGGER.error(e.getMessage(), e);

		}
	}
}