package controladores;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entidades.Productos;
import servicios.implementacionFichero;
import servicios.implementacionMenu;
import servicios.implementacionProducto;
import servicios.interfazFichero;
import servicios.interfazMenu;
import servicios.interfazProducto;

public class menu {

	public static void main(String[] args) {
		// Variables
		int opcion;
		Boolean ok = false;
		// Interfaces
		interfazMenu iM = new implementacionMenu();
		interfazProducto iP =new implementacionProducto();
		interfazFichero iF=new implementacionFichero();
		// Scanner, List, Ficheros
		Scanner sc = new Scanner(System.in);
		List<Productos> listaProductos=new ArrayList();
		File archivo = new File("bin/archivo.txt");
		File archivoProducto = new File("bin/archivoProductos.txt");
		iP.leerFichero(archivoProducto);
		
		try {
			while (!ok) {
				iM.mostrarMenu();
				opcion = sc.nextInt();

				switch (opcion) {
				case 1:
					//Pedir productos
					iP.pedirProductosAlmacen(listaProductos, archivoProducto,archivo);
					break;
				case 2:
					//Coger productos
					iP.cogerProductosAlmacen(listaProductos,archivoProducto);
					break;
				case 3:
					//Listar productos
					iP.verProductosAlmacen(listaProductos,archivoProducto);
					break;
				case 4:
					System.out.println("Saliendo del programa");
					ok = true;
					break;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Error: Opción inválida. Por favor, introduce un número válido.");
		} catch (InputMismatchException e) {
			//mandara mensaje segun que suceda
			iF.escribirFichero(archivo);
		} catch (Exception e) {
			System.out.println("Se produjo un error" + e.getMessage());
		}

	}
}
