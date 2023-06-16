package servicios;

import java.io.File;
import java.util.List;

import entidades.Productos;
/**
 * 
 * @author irm
 *
 */
public interface interfazFichero {
	/**
	 * 
	 * @param archivo
	 * Llamamos al metodo escribirFichero y le pasamos por referencia el archivo
	 * Este metodo se encarga de escribir los errores dentro del archivo
	 */
	void escribirFichero(File archivo);
	/**
	 * 
	 * @param listaProductos
	 * @param archivo
	 * Llamamos al metodo escribir FicheroProductos y le pasamos por referencia la lista y el archivo 
	 * Este metodo se encarga de escribir la informacion guardada en el archivo
	 */
	void escribirEnFicheroProductos(List<Productos> listaProductos, File archivo);

}
