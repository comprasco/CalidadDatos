package co.gov.supernotariado.bachue.calidaddatos.exception;

/**
 * Interfaz que define los metodos para acceder a detalles de una excepcion generica
 * 
 * @version 1.0
 * @author Smartsoft Solutions S.A.S 
 */
public interface IExcepcionesGenericas {

	/**
	 * Metodo que permite consultar codigo de excepcion
	 * @return String con el codigo de excepcion
	 */
	public String consultarCodigoExcepcion();

	/**
	 * Metodo que permite consultar catalogos de excepcion
	 * @return Enum que contiene propiedades de los catalogos de excepcion
	 */
	public IEnumCatalogoMensajes consultarCatalogo();
	
}
