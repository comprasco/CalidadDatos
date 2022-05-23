/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: InconsistenciaDAOImpl.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl
 * Nombre del elemento: InconsistenciaDAOImpl
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl;

import java.sql.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IInconsistenciaDAO;
import co.gov.supernotariado.bachue.calidaddatos.interfaces.IEntityManagerFactory;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.InconsistenciaVO;


/**
 * Clase tipo objeto de acceso a datos (DAO). <br>
 * Permite interactuar con la base de datos manipulando y realizando operaciones
 * <br>
 * sobre el modelo de datos Inconsistencia.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Stateless
@LocalBean
public class InconsistenciaDAOImpl implements IInconsistenciaDAO
{	
	
	
	/**
	 * Atributo de instancia tipo IEntityManagerFactory para definir la propiedad
	 * entity manager factory.
	 */
	@EJB
	private IEntityManagerFactory iiemf_entityManagerFactory;
		
	
	@Override
	public InconsistenciaVO inconsistenciaVO(String as_nombreTabla, String as_nombreCampo) 
	{
		InconsistenciaVO li_inconsistenciaVo = new InconsistenciaVO();
		EntityManager lem_entityManager = iiemf_entityManagerFactory.consultarEntityManager();
		Query lq_sql = lem_entityManager.createNativeQuery("select table_name,column_name,data_type,data_length from all_tab_columns  where table_name = ? and column_name = ?  ");
		lq_sql.setParameter(1, as_nombreTabla);
		lq_sql.setParameter(2, as_nombreCampo);
		Object[] lo_inconsistenciaVo = (Object[]) lq_sql.getSingleResult();
		if(lo_inconsistenciaVo!=null)
		{
			li_inconsistenciaVo.setIi_idInconsistencia(Integer.parseInt(lo_inconsistenciaVo[0].toString()));
			li_inconsistenciaVo.setIi_idEjecucion(Integer.parseInt(lo_inconsistenciaVo[1].toString()));
			li_inconsistenciaVo.setIs_idCirculo(lo_inconsistenciaVo[2].toString());
			li_inconsistenciaVo.setIi_idModulo(Integer.parseInt(lo_inconsistenciaVo[3].toString()));
			li_inconsistenciaVo.setIs_tablaDestino(lo_inconsistenciaVo[4].toString());
			li_inconsistenciaVo.setIi_procesadoRegistro(Integer.parseInt(lo_inconsistenciaVo[6].toString()));
			li_inconsistenciaVo.setIs_idUsuarioCreacion(lo_inconsistenciaVo[7].toString());
			li_inconsistenciaVo.setId_fechaCreacion(Date.valueOf(lo_inconsistenciaVo[8].toString()));
		}
		return li_inconsistenciaVo;
	}
}