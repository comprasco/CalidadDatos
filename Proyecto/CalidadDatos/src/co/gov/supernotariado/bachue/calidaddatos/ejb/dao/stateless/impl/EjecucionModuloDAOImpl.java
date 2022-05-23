/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: EjecucionModuloDAOImpl.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl
 * Nombre del elemento: EjecucionModuloDAOImpl
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */

package co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.impl;

import java.math.BigDecimal;
import java.sql.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.gov.supernotariado.bachue.calidaddatos.ejb.dao.stateless.IEjecucionModuloDAO;
import co.gov.supernotariado.bachue.calidaddatos.interfaces.IEntityManagerFactory;
import co.gov.supernotariado.bachue.calidaddatos.persistence.vo.EjecucionModuloVO;


/**
 * Clase tipo objeto de acceso a datos (DAO). <br>
 * Permite interactuar con la base de datos manipulando y realizando operaciones
 * <br>
 * sobre el modelo de datos relacionado a los modulos de las inconsistencias.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@Stateless
@LocalBean
public class EjecucionModuloDAOImpl implements IEjecucionModuloDAO 
{
	
	
	/**
	 * Atributo de instancia tipo IEntityManagerFactory para definir la propiedad
	 * entity manager factory.
	 */
	@EJB
	private IEntityManagerFactory iiemf_entityManagerFactory;


	@Override
	public EjecucionModuloVO ejecucionModuloVO(String as_nombreTabla, String as_nombreCampo) 
	{
		EjecucionModuloVO lem_ejecucionModuloVo = new EjecucionModuloVO();
		EntityManager lem_entityManager = iiemf_entityManagerFactory.consultarEntityManager();
		Query lq_sql = lem_entityManager.createNativeQuery("select table_name,column_name,data_type,data_length from all_tab_columns  where table_name = ? and column_name = ?  ");
		lq_sql.setParameter(1, as_nombreTabla);
		lq_sql.setParameter(2, as_nombreCampo);
		Object[] lo_ejecucionModuloVo = (Object[]) lq_sql.getSingleResult();
		if(lo_ejecucionModuloVo!=null)
		{
			lem_ejecucionModuloVo.setIbd_idEjecucion(new BigDecimal(lo_ejecucionModuloVo[0].toString()));
			lem_ejecucionModuloVo.setIs_idCirculo(lo_ejecucionModuloVo[1].toString());
			lem_ejecucionModuloVo.setIbd_idModulo(new BigDecimal(lo_ejecucionModuloVo[2].toString()));
			lem_ejecucionModuloVo.setId_fechaInicio(Date.valueOf(lo_ejecucionModuloVo[3].toString()));
			lem_ejecucionModuloVo.setId_fechaFin(Date.valueOf(lo_ejecucionModuloVo[4].toString()));
			lem_ejecucionModuloVo.setIbd_numRegOk(new BigDecimal(lo_ejecucionModuloVo[5].toString()));
			lem_ejecucionModuloVo.setIbd_numRegIncon(new BigDecimal(lo_ejecucionModuloVo[6].toString()));
			lem_ejecucionModuloVo.setIs_idUsuarioCreacion(lo_ejecucionModuloVo[7].toString());
			lem_ejecucionModuloVo.setId_fechaCreacion(Date.valueOf(lo_ejecucionModuloVo[8].toString()));
			lem_ejecucionModuloVo.setIs_numRegOrigen(lo_ejecucionModuloVo[9].toString());
		}
		return lem_ejecucionModuloVo;
	}
}