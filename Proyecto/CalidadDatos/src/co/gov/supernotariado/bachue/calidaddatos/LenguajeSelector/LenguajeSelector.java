/**
 * Archivo del proyecto Calidad de Datos
 * --------------------------------------
 * Nombre del archivo: LenguajeSelector.java
 * Paquete del archivo: co.gov.supernotariado.bachue.calidaddatos.LenguajeSelector
 * Nombre del elemento: LenguajeSelector
 * @author Smartsoft Solutions S.A.S 
 * @version 1.0
 */
package co.gov.supernotariado.bachue.calidaddatos.LenguajeSelector;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import java.io.Serializable;
import java.util.Locale;

/**
 * El elemento Class LenguajeSelector.<br>
 * Representa un/una lenguaje selector.<br>
 * Clase utlizada para saber el lenguaje
 * 
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 */
@ManagedBean
@SessionScoped
public class LenguajeSelector implements Serializable {

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 2756934361134603857L;

	/**
	 * Atributo de instancia tipo Locale para definir la propiedad locale.
	 */
	private Locale il_locale;

	/**
	 * Construye una nueva instancia/objeto de la clase LenguajeSelector.
	 */
	public LenguajeSelector() {
		this.il_locale = new Locale("es");
	}

	/**
	 * Obtiene el valor para la propiedad locale.
	 *
	 * @return El valor de la propiedad locale
	 */
	public Locale getLocale() {
		return il_locale;
	}

	/**
	 * Obtiene el valor para la propiedad language.
	 *
	 * @return El valor de la propiedad language
	 */
	public String getLanguage() {
		return il_locale.getLanguage();
	}

	/**
	 * Cambiar el idioma segun la seleccion del usuario Por defecto inicia con el
	 * lenguaje espanol (es).
	 *
	 * @param as_lenguaje lenguaje que va a ser asignado
	 */
	public void cambiarLenguaje(String as_lenguaje) {
		il_locale = new Locale(as_lenguaje);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(il_locale);
	}

}