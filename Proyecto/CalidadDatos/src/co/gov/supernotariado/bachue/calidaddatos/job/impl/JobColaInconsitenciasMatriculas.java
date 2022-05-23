/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: JobColaInconsitenciasMatriculas.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.job.impl
 * Nombre del elemento: JobColaInconsitenciasMatriculas
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.job.impl;

import org.jboss.logging.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import co.gov.supernotariado.bachue.calidaddatos.utilidades.BeansLocales;

/**
 * El elemento Class JobColaInconsitenciasMatriculas.<br>
 * Representa un/una job cola inconsitencias matriculas.<br>
 * Clase utlizada para trear las inconsistencias encoladas en base de datos
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public class JobColaInconsitenciasMatriculas implements Job {

	/**
	 * Define la constante CD_LOGGER.
	 */
	final static Logger CD_LOGGER = Logger.getLogger(JobColaInconsitenciasMatriculas.class);

	/**
	 * Execute.
	 *
	 * @param context el parametro context
	 * @throws JobExecutionException la excepcion job execution exception
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		CD_LOGGER.info("JobColaInconsitenciasMatriculas:execute:Mensaje: Ejecutando tarea obtener matriculas inconcistentes cola");
		try {

			BeansLocales.obtenerILInconsistenciaCampoBusiness().validarMatriculaEncolada();

		} catch (Exception e) {
			CD_LOGGER.error("Excepcion:JobColaInconsitenciasMatriculas:execute:Mensaje: " + e.getMessage());
			CD_LOGGER.error(e.getMessage(), e);
		}
	}
}
