package servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entidades.Productos;

public class implementacionProducto implements interfazProducto {
	interfazFichero iF = new implementacionFichero();

	@Override
	public void pedirProductosAlmacen(List<Productos> listaProductos, File archivoProducto,File archivo) {
		try {
			// Creamos un scanner para la recogida de informacion
			Scanner sc = new Scanner(System.in);
			// Le pedimos al usuario la informacion necesaria
			System.out.println("Que material necesita pedir:");
			String nombreProducto = sc.next();
			System.out.println("Que cantidad de producto necesita:");
			int cantidadProducto = sc.nextInt();
			System.out.println("Que unidad de medida utiliza el material");
			String unidadMedida = sc.next();
			// Creamos un objeto para guardar la informacion
			Productos productos = new Productos(nombreProducto, cantidadProducto, unidadMedida);
			// Añadimos la informacion a la lista
			listaProductos.add(productos);
			iF.escribirEnFicheroProductos(listaProductos, archivoProducto);
			
		} catch (InputMismatchException e) {
			iF.escribirFichero(archivo);
		} catch (Exception e) {
			System.out.println("Se produjo un error" + e.getMessage());
		}
	}

	@Override
	public void cogerProductosAlmacen(List<Productos> listaProductos,File archivoProducto) {
		// Creamos un scanner para la recogida de informacion
		Scanner sc = new Scanner(System.in);
		// Le pedimos al usuario la informacion necesaria
		System.out.println("Que material necesita pedir:");
		String nombreProducto = sc.next();
		System.out.println("Que cantidad de producto necesita:");
		int cantidadProducto = sc.nextInt();


		for (int i = 0; i < listaProductos.size(); i++) {
	        if (nombreProducto.equals(listaProductos.get(i).getNombreProducto())) {
	            int cantidadActual = listaProductos.get(i).getCantidadProducto();
	            int nuevaCantidad = cantidadActual - cantidadProducto;
	            listaProductos.get(i).setCantidadProducto(nuevaCantidad);
	        }
	    }	
	}

	@Override
	public void verProductosAlmacen(List<Productos> listaProductos, File archivoProducto) {
		try {
			leerFichero(archivoProducto);
			if (!listaProductos.isEmpty()) {
				for (int i = 0; i < listaProductos.size(); i++) {
					System.out.println(listaProductos.get(i).toString());
				}
				iF.escribirEnFicheroProductos(listaProductos, archivoProducto);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<Productos> leerFichero(File archivoProducto) 
	{
		List<Productos> listaProductos = new ArrayList<>();

	    try (FileReader fR = new FileReader(archivoProducto);
	         BufferedReader bF = new BufferedReader(fR)) {

	        String linea;
	        while ((linea = bF.readLine()) != null) {
	        	String[] datos = linea.split(";");
	            if (datos.length == 5) {
	                String nombreProducto = datos[0];
	                int cantidadProducto =Integer.parseInt( datos[1]);
	                String unidadMedida = datos[2];
	                Productos productos = new Productos(nombreProducto,cantidadProducto,unidadMedida);
	                listaProductos.add(productos);
	            }
	            System.out.println(linea);
	        }
	            
	        
	        System.out.println("Datos de pacientes cargados desde el archivo.");
	    } catch (FileNotFoundException e) {
	        System.out.println("El archivo de pacientes no existe.");
	    }   catch (IOException e) {
	        System.out.println("Error al leer el archivo: " + e.getMessage());
	    
	    } catch (Exception e) {
	        System.out.println("Error al leer los datos de pacientes del archivo: " + e.getMessage());    
	    }
	    return listaProductos;
	}

}
