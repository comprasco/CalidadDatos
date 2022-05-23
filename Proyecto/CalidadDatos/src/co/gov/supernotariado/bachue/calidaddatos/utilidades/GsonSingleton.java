/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: GsonSingleton.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.utilidades
 * Nombre del elemento: GsonSingleton
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.utilidades;

import java.util.Date;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.gov.supernotariado.bachue.clientebus.util.DateDeserializer;
import co.gov.supernotariado.bachue.clientebus.util.DateSerializer;

/**
 * Gson singleton para usar al transformar de JSON a objetos Java y viceversa.
 * Maneja formato de fecha e imprime de forma ordenada el resultado.
 *
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
public final class GsonSingleton {

	/**
	 * Atributo private de tipo static que almacena el valor de la variable cg_gson.
	 */
	private static Gson cg_gson;
	
	/**
	 * Atributo private de tipo static que almacena el valor de la variable
	 * cg_gsonSinImpresion.
	 */
	private static Gson cg_gsonSinImpresion;

	/**
	 * Construye una nueva instancia/objeto de la clase GsonSingleton.
	 */
	private GsonSingleton() {
		// Esta es una clase de utilidad
	}

	/**
	 * Crea un {@link com.google.gson.Gson} Objeto que se puede usar para serializar
	 * y deserializar objetos Java .
	 *
	 * @param ab_impresionOrganizada Si es true el JSON será impreso
	 * @return {@link Gson}
	 */
	private static Gson crearGson(Boolean ab_impresionOrganizada) {
		GsonBuilder lgb_builder = new GsonBuilder();

		registrarTiposAdaptadores(lgb_builder);

		if (ab_impresionOrganizada) {
			lgb_builder.setPrettyPrinting();
		}
		lgb_builder.disableHtmlEscaping();
		return lgb_builder.create();
	}

	/**
	 * Registrar tipos adaptadores.
	 *
	 * @param agb_builder el parametro builder
	 */
	private static void registrarTiposAdaptadores(GsonBuilder agb_builder) {
		// Date serializer and deserializer
		agb_builder.registerTypeAdapter(Date.class, new DateDeserializer());
		agb_builder.registerTypeAdapter(Date.class, new DateSerializer());
	}

	/**
	 * Obtener una instancia de Gson.
	 *
	 * @return El valor de la propiedad gson
	 */
	public static synchronized Gson getGson() {
		if (cg_gson == null) {
			cg_gson = crearGson(true);
		}
		return cg_gson;
	}

	/**
	 * Obtener una instancia de Gson.
	 *
	 * @return El valor de la propiedad gson sin impresion ordenada
	 */
	public static synchronized Gson getGsonSinImpresionOrdenada() {
		if (cg_gsonSinImpresion == null) {
			cg_gsonSinImpresion = crearGson(false);
		}
		return cg_gsonSinImpresion;
	}
}
