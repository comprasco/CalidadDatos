package co.gov.supernotariado.bachue.calidaddatos.LenguajeSelector;

import java.util.Enumeration;
import java.util.ResourceBundle;
/**
 * @author Smartsoft Solutions S.A.S
 * @version 1.0
 * Clase utlizada para saber las propiedades del selector de lenguajes
 */
public class PropiedadesSelector {

	private PropiedadesSelector() {
		// Metodo constructor vacio para modelo
	}
	/**
	 * Metodo que se implementa para saber la propiedades de lenguaje
	 * @param as_nombreBundlePropiedades
	 * @param as_nombrePropiedad
	 * @return ls_propiedad
	 */
	public static String consultarPropiedades(String as_nombreBundlePropiedades, String as_nombrePropiedad) {

		ResourceBundle lrb_origenBundle = ResourceBundle.getBundle("resources." + as_nombreBundlePropiedades);
		Enumeration <String> les_llaves = lrb_origenBundle.getKeys();
		String ls_propiedad = "";

		while (les_llaves.hasMoreElements()) {
			String ls_llave = les_llaves.nextElement();
			ls_propiedad = lrb_origenBundle.getString(ls_llave);
			if (ls_llave.equals(as_nombrePropiedad)) {
				return ls_propiedad;
			} 
		}

		return ls_propiedad;		
	}

}
