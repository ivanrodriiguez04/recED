package servicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import entidades.Productos;

public class implementacionFichero implements interfazFichero {
	@Override
	public void escribirFichero(File archivo) 
	{
		FileWriter fichero=null;
		try {
			fichero=new FileWriter(archivo);
			PrintWriter pw=new PrintWriter(fichero);
			pw.println("");
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarFichero(fichero);
		}
		
	}
	
	@Override
	 public void escribirEnFicheroProductos(List<Productos> listaProductos, File archivoProducto) {
	        try (FileWriter fileWriter = new FileWriter(archivoProducto)) {
	        	for (int i = 0; i < listaProductos.size(); i++) {
	            String contenido = "\n"+ listaProductos.get(i).getNombreProducto() + ";" + listaProductos.get(i).getCantidadProducto() + ";" +
	            		listaProductos.get(i).getUnidadMedida();
	            fileWriter.write(contenido);
	        	}
	            System.out.println("Paciente escrito en el archivo correctamente.");
	        } catch (IOException e) {
	            System.out.println("Error al escribir el paciente en el archivo: " + e.getMessage());
	        }
	 }
	
	
	
	 public void cerrarFichero(FileWriter fichero) {
			try {
				//Nos aseguramos de que el fichero no sea nulo y lo cerramos con el .close()
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

}
