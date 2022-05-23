/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InconsistenciaCampoDAOImpl.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl
 * Nombre del elemento: InconsistenciaCampoDAOImpl
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;

import co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO;
import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IInconsistenciaCampoDAO;
import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IMetadataDAO;
import co.gov.supernotariado.bachue.calidaddatos.enums.EnumEstadoProcesoInconsistencias;
import co.gov.supernotariado.bachue.calidaddatos.interfaces.IEntityManagerFactory;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.InformacionInconsistenciaVO;
import co.gov.supernotariado.bachue.calidaddatos.utilidades.GeneradorGrowlGenerico;
import oracle.jdbc.OracleTypes;
import weblogic.javaee.TransactionTimeoutSeconds;

/**
 * Clase tipo objeto de acceso a datos (DAO). <br>
 * Permite interactuar con la base de datos manipulando y realizando operaciones
 * sobre el modelo de datos Inconsistencia campo.<br>
 * Clase implementada para realizar la consulta de inconsistencia de tipo matricula a la base de datos  
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Stateless
@LocalBean
@TransactionTimeoutSeconds(300)
public class InconsistenciaCampoDAOImpl implements IInconsistenciaCampoDAO {

	/**
	 * Define la constante CD_LOGGER.
	 */
	private final static Logger CD_LOGGER = Logger.getLogger(InconsistenciaCampoDAOImpl.class);


	/**
	 * Atributo de instancia tipo IEntityManagerFactory para definir la propiedad
	 * entity factory.
	 */
	@EJB
	private IEntityManagerFactory iiemf_entityFactory;

	/**
	 * Atributo de instancia tipo ILMetadataDAO para definir la propiedad metadato
	 * dao.
	 */
	@EJB
	private IMetadataDAO iim_metadatoDao;

	/**
	 * Define la constante CS_HEADER.
	 */
	private static final String CS_HEADER = "X-FORWARDED-FOR";

	/**
	 * Define la constante CS_IP_NO_DISPONIBLE.
	 */
	private static final String CS_IP_NO_DISPONIBLE = "IP_NO_DISPONIBLE";

	/**
	 * Define la constante CS_IPVSEIS.
	 */
	private static final String CS_IPVSEIS = "0:0:0:0:0:0:0:1";

	/**
	 * Metodo que consulta las incosistencias y convierte esos datos en una lista
	 * para ser mostrados.
	 *
	 * @param aci_consultaInconsistenciasDto el parametro consulta inconsistencias
	 *                                       dto
	 * @return Resultado para lii informacion inconsistencia vo retornado como una
	 *         lista de InformacionInconsistenciaVO
	 */
	@Override
	public List<InformacionInconsistenciaVO> lii_informacionInconsistenciaVo(
			ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto) {

		List<InformacionInconsistenciaVO> llii_informacionInconsistenciaVo = new ArrayList<>();
		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
		StringBuilder lsb_query = new StringBuilder();
		lsb_query.append("");
		lsb_query.append("select im.ID_MATRICULA NUMERO_MATRICULA,\n");
		lsb_query.append("ii.ID_INCONSISTENCIA NUMERO_INCONSISTENCIA,\n");
		lsb_query.append("ii.ID_MODULO ID_MODULO,\n");
		lsb_query.append("ii.TABLA_DESTINO TABLA,\n");
		lsb_query.append("iic.NOMBRE_CAMPO CAMPO,\n");
		lsb_query.append("iic.VALOR_CAMPO VALOR_ACTUAL,\n");
		lsb_query.append("iic.VALOR_CORRECTO_CAMPO NUEVO_VALOR,\n");
		lsb_query.append("iic.PROCESADA_CAMPO,\n");
		lsb_query.append("iic.OBSERVACIONES_MATRICULA OBSERVACIONES_MATRICULA,\n");
		lsb_query.append("iic.OBSERVACIONES_NO_CORREGIDO OBSERVACIONES_NO_CORREGIDAS,\n");
		lsb_query.append(
				"(select DESCRIPCION from SDB_INC_TIPO_INCONSISTENCIA iti WHERE iti.id_tipo_inconsistencia = iic.id_tipo_inconsistencia) TIPO_INCONSISTENCIA\n");
		lsb_query.append("from SDB_INC_MATRICULA im\n");
		lsb_query.append(
				"inner join SDB_INC_INCONSISTENCIA ii on ii.ID_INCONSISTENCIA = im.ID_INCONSISTENCIA\n");
		lsb_query.append(
				"inner join SDB_INC_INCONSISTENCIA_CAMPO iic on ii.ID_INCONSISTENCIA = iic.ID_INCONSISTENCIA and ii.TABLA_DESTINO = iic.TABLA_DESTINO\n");
		lsb_query.append("inner join SDB_PGN_CIRCULO_REGISTRAL cr on ii.ID_CIRCULO = cr.ID_CIRCULO\n");
		lsb_query.append("where im.ID_MATRICULA =? \n");
		lsb_query.append("and ii.ID_CIRCULO = ? \n");
		lsb_query.append("and iic.PROCESADA_CAMPO != 'P' \n");
		lsb_query.append("ORDER BY  iic.PROCESADA_CAMPO ASC");

		consultarInconsistencias(aci_consultaInconsistenciasDto, llii_informacionInconsistenciaVo, lem_entityManager,
				lsb_query);
		return llii_informacionInconsistenciaVo;
	}

	/**
	 * Consultar inconsistencias.
	 *
	 * @param aci_consultaInconsistenciasDto   el parametro consulta inconsistencias
	 *                                         dto
	 * @param llii_informacionInconsistenciaVo el parametro llii informacion
	 *                                         inconsistencia vo
	 * @param lem_entityManager                el parametro lem entity manager
	 * @param lsb_query                        el parametro lsb query
	 */
	private void consultarInconsistencias(ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto,
			List<InformacionInconsistenciaVO> llii_informacionInconsistenciaVo, EntityManager lem_entityManager,
			StringBuilder lsb_query) {
		try {

			Query lq_query = lem_entityManager.createNativeQuery(lsb_query.toString());

			lq_query.setParameter(1, aci_consultaInconsistenciasDto.getIs_numeroMatricula());
			lq_query.setParameter(2, aci_consultaInconsistenciasDto.getIs_idCirculoRegistral());
			@SuppressWarnings("unchecked")
			List<Object[]> llo_object = lq_query.getResultList();
			InformacionInconsistenciaVO lii_informacionInconsistenciaVo;
			if (!llo_object.isEmpty()) {
				for (Object[] obj : llo_object) {
					lii_informacionInconsistenciaVo = new InformacionInconsistenciaVO();

					if (obj[0] != null) {

						lii_informacionInconsistenciaVo.setIs_numeroMatricula(obj[0].toString());
					}
					if (obj[1] != null) {
						lii_informacionInconsistenciaVo.setIbi_numeroInconsistencia(new BigInteger(obj[1].toString()));

					}
					if (obj[2] != null) {
						lii_informacionInconsistenciaVo.setIi_idModulo(Integer.valueOf(obj[2].toString()));
					}
					if (obj[3] != null) {
						lii_informacionInconsistenciaVo.setIs_tabla(obj[3].toString());
					}
					if (obj[4] != null) {
						lii_informacionInconsistenciaVo.setIs_campo(obj[4].toString());
					}

					if (obj[5] != null) {
						lii_informacionInconsistenciaVo.setIs_valorActual(obj[5].toString());
					}

					if (obj[6] != null) {
						lii_informacionInconsistenciaVo.setIs_nuevoValor(obj[6].toString());
					}

					if (obj[7] != null) {
						lii_informacionInconsistenciaVo.setIs_procesada(obj[7].toString());
					}
					if (obj[10] != null) {
						lii_informacionInconsistenciaVo.setIs_tipoInconsistencia(obj[10].toString());
					}
					if (obj[8] != null) {
						lii_informacionInconsistenciaVo.setIs_observaciones(obj[8].toString());
					}
					if (obj[9] != null) {
						lii_informacionInconsistenciaVo.setIs_observacionesnc(obj[9].toString());
					}

					lii_informacionInconsistenciaVo.setIm_metadataVo(
							this.iim_metadatoDao.metadata(lii_informacionInconsistenciaVo.getIs_tabla(),
									lii_informacionInconsistenciaVo.getIs_campo()));

					llii_informacionInconsistenciaVo.add(lii_informacionInconsistenciaVo);
				}
			}
		} catch (final Exception ae_exception) {
			CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage());

		}
	}


	@Override
	public BigDecimal estadoN(ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto) {
		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
		StringBuilder lsb_query = new StringBuilder();
		lsb_query.append("select COUNT (*)");
		lsb_query.append(fromConsulta());
		lsb_query.append("iic.PROCESADA_CAMPO = ?");
		try {

			Query lq_query = lem_entityManager.createNativeQuery(lsb_query.toString());

			lq_query.setParameter(1, aci_consultaInconsistenciasDto.getIs_numeroMatricula());
			lq_query.setParameter(2, aci_consultaInconsistenciasDto.getIs_idCirculoRegistral());
			lq_query.setParameter(3, 'N');

			BigDecimal llo_object = (BigDecimal) lq_query.getSingleResult();
			return llo_object;
		} catch (final Exception ae_exception) {
			CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage());
			return null;
		}
	}


	@Override
	public BigDecimal estadoC(ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto) {
		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
		StringBuilder lsb_query = new StringBuilder();
		lsb_query.append("select COUNT (*)");
		lsb_query.append(fromConsulta());
		lsb_query.append("iic.PROCESADA_CAMPO = ?");
		try {

			Query lq_query = lem_entityManager.createNativeQuery(lsb_query.toString());

			lq_query.setParameter(1, aci_consultaInconsistenciasDto.getIs_numeroMatricula());
			lq_query.setParameter(2, aci_consultaInconsistenciasDto.getIs_idCirculoRegistral());
			lq_query.setParameter(3, 'C');

			BigDecimal llo_object = (BigDecimal) lq_query.getSingleResult();
			return llo_object;
		} catch (final Exception ae_exception) {
			CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage());
			return null;
		}
	}

	/**
	 * Metodo que consulta el estado de las inconsistencias.
	 *
	 * @return retorna una variable de tipo string con el resultado de la consulta
	 */
	private String fromConsulta() {
		StringBuilder lsb_query = new StringBuilder();
		lsb_query.append("from SDB_INC_MATRICULA im\n");
		lsb_query.append(
				"inner join SDB_INC_INCONSISTENCIA ii on ii.ID_INCONSISTENCIA = im.ID_INCONSISTENCIA\n");
		lsb_query.append(
				"inner join SDB_INC_INCONSISTENCIA_CAMPO iic on ii.ID_INCONSISTENCIA = iic.ID_INCONSISTENCIA and ii.TABLA_DESTINO = iic.TABLA_DESTINO\n");
		lsb_query.append("inner join SDB_PGN_CIRCULO_REGISTRAL cr on ii.ID_CIRCULO = cr.ID_CIRCULO\n");
		lsb_query.append("where im.ID_MATRICULA = ?\n");
		lsb_query.append("and ii.ID_CIRCULO = ?\n");
		lsb_query.append("and ");
		return lsb_query.toString();
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
			CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage());
			return false;
		} finally {
			lem_entityManager.close();
			this.corregirInconsistencias(aii_informacionInconsistenciaVo);
		}
		return true;
	}

	/**
	 * Metodo utilizado para corregir las inconsistencias .
	 *
	 * @param aii_informacionInconsistenciasVo el parametro informacion
	 *                                         inconsistencias vo
	 * @return true si fue exitosa la operacion
	 */
	public Boolean corregirInconsistencias(final InformacionInconsistenciaVO aii_informacionInconsistenciasVo) {

		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
		if (aii_informacionInconsistenciasVo.getId_fecha()!=null) {
			String ls_corregirInconsistencia = String.format(
					"UPDATE %s SET %s = TO_DATE('%s','DD/MM/YYYY') WHERE id_inconsistencia = %s",

					aii_informacionInconsistenciasVo.getIs_tabla(), aii_informacionInconsistenciasVo.getIs_campo(),
					aii_informacionInconsistenciasVo.getIs_nuevoValor(), aii_informacionInconsistenciasVo.getIbi_numeroInconsistencia());
			final Query  lq_actualiza = lem_entityManager.createNativeQuery(ls_corregirInconsistencia);
			lq_actualiza.executeUpdate();
		}else {
			String ls_corregirInconsistencia = String.format(
					"UPDATE %s SET %s = '%s' WHERE id_inconsistencia = %s",

					aii_informacionInconsistenciasVo.getIs_tabla(), aii_informacionInconsistenciasVo.getIs_campo(),
					aii_informacionInconsistenciasVo.getIs_nuevoValor(), aii_informacionInconsistenciasVo.getIbi_numeroInconsistencia());

			try {
				final Query  lq_actualiza = lem_entityManager.createNativeQuery(ls_corregirInconsistencia);
				lq_actualiza.executeUpdate();

			} catch (final Exception ae_exception) {
				CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
				CD_LOGGER.error(ae_exception.getMessage());
				return false;
			} finally {
				lem_entityManager.close();
			}
		}
		return true;
	}


	/* (non-Javadoc)
	 * @see co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.ILInconsistenciaCampoDAO#promotorPL(co.gov.supernotariado.bachue.calidaddatos.dto.ConsultaInconsistenciasDTO)
	 */
	@Override
	public String promotorPL(final ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto) {
		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
		CallableStatement cstmt = null;
		String  ls_resultado = "";
		if (aci_consultaInconsistenciasDto.getIs_numeroMatricula()==null) {
			this.promotorBachueTurnoPL(aci_consultaInconsistenciasDto);

		} else {
			try {

				java.sql.Connection connection = lem_entityManager.unwrap(java.sql.Connection.class);

				cstmt = connection.prepareCall("{call PKG_MIG_PROMOVER.PROC_MGR_PROMOVER_MATRICULA(?, ?, ?)}");
				cstmt.setString(1, aci_consultaInconsistenciasDto.getIs_idCirculoRegistral());
				cstmt.setInt(2, Integer.parseInt(aci_consultaInconsistenciasDto.getIs_numeroMatricula()));
				cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
				cstmt.execute();
				ls_resultado = cstmt.getString(3);
				aci_consultaInconsistenciasDto.setIs_respuesta(ls_resultado);
			} 
			catch (final SQLException e) {
				CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + e.getMessage());
				CD_LOGGER.error(e.getMessage(), e);
			}
			finally {
				try {
					if (cstmt != null) {
						cstmt.close();
					}
				} catch (SQLException e) {
					CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + e.getMessage());
					CD_LOGGER.error(e.getMessage(), e);
				}
				lem_entityManager.close();
			}
		}
		return ls_resultado;

	}


	@Override
	public  void promotorBachueTurnoPL(final ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto) {
		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
		java.sql.Connection connection = lem_entityManager.unwrap(java.sql.Connection.class);
		String  ls_resultado = "";
		CallableStatement cstmt = null;
		try {
			cstmt = connection.prepareCall("{call PKG_MIG_PROMOVER.PROC_MGR_PROMOVER_INCONSISTENCIA_TURNO(?, ?, ?)}");
			cstmt.setString(1, aci_consultaInconsistenciasDto.getIs_idCirculoRegistral());
			cstmt.setInt(2, Integer.parseInt(aci_consultaInconsistenciasDto.getIs_numeroTurno()));
			cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
			cstmt.execute();
			ls_resultado = cstmt.getString(3);
			aci_consultaInconsistenciasDto.setIs_respuesta(ls_resultado);
			cstmt.close();
		} catch (final SQLException e) {
			CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + e.getMessage());
			CD_LOGGER.error(e.getMessage(), e);
		}finally {
			try {
				if (cstmt != null) {
					cstmt.close();
				}
			} catch (SQLException e) {
				CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + e.getMessage());
				CD_LOGGER.error(e.getMessage(), e);
			}
			lem_entityManager.close();
		}
	}





	@Override
	public String validarEstadoMatricula(final String as_numeroMatricula, String as_idCirculoRegistral) {
		String ls_respuesta = "";
		try {
			final EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
			final StringBuilder queryBuilder = new StringBuilder();

			queryBuilder.append(
					"select ID_MATRICULA, HABILITADO from SDB_ACC_CORREGIDO_INCONSISTENCIAS_INCOMPLETAS where ID_MATRICULA = ? and HABILITADO = ? ");

			final Query lq_query = lem_entityManager.createNativeQuery(queryBuilder.toString());

			lq_query.setParameter(1, as_numeroMatricula);
			lq_query.setParameter(2, "S");
			lq_query.executeUpdate();
			lem_entityManager.flush();
		} catch (final Exception e) {
			CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + e.getMessage());
			CD_LOGGER.error(e.getMessage(), e);

		}
		return ls_respuesta;
	}

	@Override
	public Boolean validarMatriculaEncolada() {
		String[] ls_respuesta = new String[2];
		try {
			final EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
			final StringBuilder queryBuilder = new StringBuilder();

			queryBuilder.append(
					"select ID_MATRICULA, ID_CIRCULO, ESTADO, FECHA_CREACION  from SDB_ACC_CORREGIDO_INCONSISTENCIAS_INCOMPLETAS where ESTADO = ? ");
			final Query lq_query = lem_entityManager.createNativeQuery(queryBuilder.toString());
			lq_query.setParameter(1, "En proceso");
			lq_query.executeUpdate();
			lem_entityManager.flush();
			@SuppressWarnings("unchecked")
			List<Object[]> llo_object = lq_query.getResultList();
			if (!llo_object.isEmpty()) {

				Object[] value = llo_object.iterator().next();
				ls_respuesta[0] = value[0].toString();
				ls_respuesta[1] = value[1].toString();

				this.ejecutarPL(ls_respuesta[0], ls_respuesta[1]);
			}
		} catch (final Exception e) {
			CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + e.getMessage());
			CD_LOGGER.error(e.getMessage(), e);
			return false;
		}
		return true;
	}
	@Override
	public  void ejecutarTurnoPL(final ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto) {
		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
		java.sql.Connection connection = lem_entityManager.unwrap(java.sql.Connection.class);
		CallableStatement cstmt = null;
	
		try {

			cstmt = connection
					.prepareCall("{ ? = call PKG_MIG_VALIDACION.Func_Valida_Inconsistente_Turno(?, ?) }");

			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setString(2, aci_consultaInconsistenciasDto.getIs_idCirculoRegistral());
			cstmt.setString(3, aci_consultaInconsistenciasDto.getIs_numeroTurno());
			cstmt.executeUpdate();
			Clob ls_resultado;
			ls_resultado = cstmt.getClob(1);
			BufferedReader br = null;
			StringBuilder sb = new StringBuilder();
			String line;
			try {
				br = new BufferedReader(new InputStreamReader(ls_resultado.getAsciiStream()));
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
			} catch (IOException ae_exception) {
				GeneradorGrowlGenerico.manejadorExcepcionesPresentacion(ae_exception);
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException ae_exception) {
						GeneradorGrowlGenerico.manejadorExcepcionesPresentacion(ae_exception);
					}
				}
			}
			aci_consultaInconsistenciasDto.setIs_respuesta(sb.toString());
			cstmt.close();
		} catch (final SQLException e) {
			CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + e.getMessage());
			CD_LOGGER.error(e.getMessage(), e);
		}finally {
			try {
				if (cstmt != null) {
					cstmt.close();
				}
			} catch (SQLException e) {
				CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + e.getMessage());
				CD_LOGGER.error(e.getMessage(), e);
			}
			lem_entityManager.close();
		}
	}



	@Override
	public void ejecutarPL(String as_circuloRegistral, String as_numeromatricula) {
		ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto= new ConsultaInconsistenciasDTO();
		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
		java.sql.Connection connection = lem_entityManager.unwrap(java.sql.Connection.class);
		CallableStatement cstmt = null;
		try {
			cstmt=connection.prepareCall("{ ? = call PKG_MIG_VALIDACION.Func_Valida_Inconsistente_Matricula(?, ?) }");

			cstmt.registerOutParameter(1, Types.CLOB);
			cstmt.setString(2,as_numeromatricula);
			cstmt.setInt(3, Integer.parseInt(as_circuloRegistral));
			cstmt.execute();
			Clob ls_resultado;
			ls_resultado = cstmt.getClob(1);
			BufferedReader br = null;
			StringBuilder sb = new StringBuilder();
			String line;
			try {
				br = new BufferedReader(new InputStreamReader(ls_resultado.getAsciiStream()));
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
			} catch (IOException ae_exception) {
				GeneradorGrowlGenerico.manejadorExcepcionesPresentacion(ae_exception);
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException ae_exception) {
						GeneradorGrowlGenerico.manejadorExcepcionesPresentacion(ae_exception);
					}
				}
			}
			aci_consultaInconsistenciasDto.setIs_respuesta(sb.toString());
			actualizarEstado(as_numeromatricula, as_circuloRegistral);
		} catch (final SQLException e) {
			CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + e.getMessage());
			CD_LOGGER.error(e.getMessage(), e);
		}finally {
			try {
				if (cstmt != null) {
					cstmt.close();
				}
			} catch (SQLException e) {
				CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + e.getMessage());
				CD_LOGGER.error(e.getMessage(), e);
			}
			lem_entityManager.close();
		}



	}

	@Override
	public void actualizarEstado(final String as_circuloRegistral, String as_numeroMatricula) {
		EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
		String ls_actualizaInconsistenciaCampo = "UPDATE SDB_ACC_CORREGIDO_INCONSISTENCIAS_INCOMPLETAS SET ESTADO= ? WHERE ID_MATRICULA = ? and ID_CIRCULO = ?";
		try {
			Query lq_actualizaInfoTabla = lem_entityManager.createNativeQuery(ls_actualizaInconsistenciaCampo);
			lq_actualizaInfoTabla.setParameter(1, EnumEstadoProcesoInconsistencias.TERMINO.getIs_descripcion());
			lq_actualizaInfoTabla.setParameter(2, as_numeroMatricula);
			lq_actualizaInfoTabla.setParameter(3, as_circuloRegistral);
			lq_actualizaInfoTabla.executeUpdate();
		} catch (final Exception ae_exception) {
			CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + ae_exception.getMessage());
			CD_LOGGER.error(ae_exception.getMessage(),ae_exception);
		} finally {
			lem_entityManager.close();
		}
	}

	public void insertarMatriculaValidada(final ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto,
			final EnumEstadoProcesoInconsistencias estadoProceso) {


		try {

			final EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
			final StringBuilder queryBuilder = new StringBuilder();
			queryBuilder.append(
					"INSERT INTO SDB_ACC_CORREGIDO_INCONSISTENCIAS_INCOMPLETAS"
							+ " (ID_ENCOLADO_MATRICULA_INCONSISTENTE,"
							+ "ID_MATRICULA, HABILITADO, ESTADO, ID_CIRCULO,"
							+ "ID_USUARIO_CREACION, FECHA_CREACION, "
							+ "IP_CREACION)"
							+ "VALUES (SQC_ACC_ACCION.NEXTVAL,?,?,?,?,?,?,?)");
			final Query query = lem_entityManager.createNativeQuery(queryBuilder.toString());

			query.setParameter(1, aci_consultaInconsistenciasDto.getIs_numeroMatricula());
			query.setParameter(2, "S");
			query.setParameter(3, estadoProceso.getIs_descripcion());
			query.setParameter(4, aci_consultaInconsistenciasDto.getIs_idCirculoRegistral());
			query.setParameter(5, EnumEstadoProcesoInconsistencias.USUARIO.getIs_descripcion());
			query.setParameter(6, new Date());
			query.setParameter(7, "11" );
			query.executeUpdate();
		} catch (final Exception e) {
			CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + e.getMessage());
			CD_LOGGER.error(e.getMessage(), e);

		}
	}

	/**
	 * Insertar turno validada.
	 *
	 * @param aci_consultaInconsistenciasDto el parametro consulta inconsistencias
	 *                                       dto
	 * @param estadoProceso                  el parametro estado proceso
	 */
	public void insertarTurnoValidada(final ConsultaInconsistenciasDTO aci_consultaInconsistenciasDto,
			final EnumEstadoProcesoInconsistencias estadoProceso) {

		if (aci_consultaInconsistenciasDto.getIs_numeroMatricula()==null||aci_consultaInconsistenciasDto.getIs_numeroMatricula().isEmpty()) {
			this.insertarTurnoValidada(aci_consultaInconsistenciasDto, estadoProceso);

		}

		String ls_direccionIp;

		try {
			HttpServletRequest lhsr_httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			ls_direccionIp = lhsr_httpServletRequest.getHeader(CS_HEADER);
			if(ls_direccionIp == null) {			
				ls_direccionIp = lhsr_httpServletRequest.getRemoteAddr();

				if(ls_direccionIp.equals(CS_IPVSEIS)) {
					ls_direccionIp = CS_IP_NO_DISPONIBLE; 
				}
			}
			final EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
			final StringBuilder queryBuilder = new StringBuilder();
			queryBuilder.append(
					"INSERT INTO SDB_ACC_CORREGIDO_INCONSISTENCIAS_INCOMPLETAS"
							+ " (ID_ENCOLADO_MATRICULA_INCONSISTENTE,"
							+ "ID_MATRICULA, HABILITADO, ESTADO, ID_CIRCULO,"
							+ "ID_USUARIO_CREACION, FECHA_CREACION, "
							+ "IP_CREACION)"
							+ "VALUES (SQC_ACC_ACCION.NEXTVAL,?,?,?,?,?,?,?)");
			final Query query = lem_entityManager.createNativeQuery(queryBuilder.toString());

			query.setParameter(1, aci_consultaInconsistenciasDto.getIs_numeroMatricula());
			query.setParameter(2, "S");
			query.setParameter(3, estadoProceso.getIs_descripcion());
			query.setParameter(4, aci_consultaInconsistenciasDto.getIs_idCirculoRegistral());
			query.setParameter(5, EnumEstadoProcesoInconsistencias.USUARIO.getIs_descripcion());
			query.setParameter(6, new Date());
			query.setParameter(7, "11" );
			query.executeUpdate();
		} catch (final Exception e) {
			CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + e.getMessage());
			CD_LOGGER.error(e.getMessage(), e);

		}
	}

	/**
	 * Metodo que actualiza el estado de la matricula para deshabilitar el proceso.
	 *
	 * @param as_matriculaInconsistencia el parametro matricula inconsistencia
	 */
	public void deshabilitarEstadoProceso(final String as_matriculaInconsistencia) {
		try {
			final EntityManager lem_entityManager = iiemf_entityFactory.consultarEntityManager();
			final StringBuilder lsb_queryBuilder = new StringBuilder();
			lsb_queryBuilder.append(
					"update SDB_ACC_CORREGIDO_INCONSISTENCIAS_INCOMPLETAS set HABILITADO = ? where ID_MATRICULA = ?");

			final Query query = lem_entityManager.createNativeQuery(lsb_queryBuilder.toString());

			query.setParameter(1, 0);
			query.setParameter(2, as_matriculaInconsistencia);
			query.executeUpdate();

		} catch (final Exception e) {
			CD_LOGGER.error("Excepcion:InconsistenciaCampoDAOImpl:execute:Mensaje: " + e.getMessage());
			CD_LOGGER.error(e.getMessage(), e);

		}
	}
}