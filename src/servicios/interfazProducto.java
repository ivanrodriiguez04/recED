package servicios;

import java.io.File;
import java.util.List;
import entidades.Productos;
/**
 * 
 * @author irm
 *
 */
public interface interfazProducto {
	/**
	 * 
	 * @param listaProductos
	 * @param archivo
	 *	 
	 *	LLamamos al metodo cogerProdructosAlmacen pasandole por referencia la lista y el archivo
	 *	Este metodo se encarga de quitar las cantidades necesarias al almacen y modificar la lista
	 */
	void cogerProductosAlmacen(List<Productos> listaProductos, File archivo);
	/**
	 * 
	 * @param listaProductos
	 * @param archivo
	 * 
	 * 	Llamamos al metodo verProductosAlmacen pasandole por referencia la lista y el archivo
	 * Este metodo se encarga de mostrar la informacion añadida en la lista
	 */
	void verProductosAlmacen(List<Productos> listaProductos, File archivo);
	/**
	 * 
	 * @param listaProductos
	 * @param archivoProducto
	 * @param archivo
	 * 
	 * 	Llamamos al metodo pedirProductosAlmacen pasandole por referencia la lista y los archivos
	 * 	Este metodo se encarga de pedir al usuario lo que se le va a añadir al almacen
	 */
	void pedirProductosAlmacen(List<Productos> listaProductos, File archivoProducto,File archivo);
	/**
	 * 
	 * @param archivoProducto
	 * @return
	 * Llamamos al metodo leerFichero  y le pasamos por referencia el archivo
	 * Este metodo se encarga de leer el fichero
	 */
	public List<Productos> leerFichero(File archivoProducto);
}
