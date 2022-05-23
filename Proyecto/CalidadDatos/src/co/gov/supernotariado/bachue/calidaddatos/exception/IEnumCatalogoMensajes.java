package co.gov.supernotariado.bachue.calidaddatos.exception;

/**
 * Interfaz que define los metodos que permite acceder a las propiedades 
 * para acceder a los mensajes en los properties internacionalizados
 * 
 * @version 1.0
 * @author Smartsoft Solutions S.A.S 
 */
public interface IEnumCatalogoMensajes {

	/**
	 * Metodo que permite acceder al nombre del archivo
	 * @return String con el nombre del archivo bundle
	 */
	public String consultarIs_nombreArchivo();
	
	/**
	 * Metodo que permite acceder al codigo de error
	 * @return String con el codigo de error
	 */
	public String consultarIs_codigo();
	
}
