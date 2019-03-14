package main;

import java.util.Scanner;

import clases.ListaOrdenada;
import clases.Producto;

/**
 * Programa en el que hago un menú para hacer una lista ordenada mediante nodos, en la cual puedo insertar productos ordenadamente, buscar
 * si está o no un producto, borrar un producto si se encuentra en la lista y mostrar la lista de productos ordenados que tenemos en
 * cualquier momento.
 * Para esto, llamaré a la Clase ListaOrdenada para las distintas acciones del menú, llamando a sus diferentes métodos. También llamaré a
 * la Clase Producto para poder construir los productos que introducirá el usuario por teclado.
 * @author 	Gonzalo Vicente Cepeda
 * @version 1.0
 * @since 	2019-02-28 
 */
public class MainAct_8_7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int op, numProducto;
		float precio;
		String descripcion;
		
		ListaOrdenada lista = new ListaOrdenada ();
		
		do {
			System.out.println("MENU:");
			System.out.println("1. INSERTAR UN PRODUCTO");
			System.out.println("2. BORRAR UN PRODUCTO");
			System.out.println("3. BUSCAR UN PRODUCTO");
			System.out.println("4. MOSTRAR LA LISTA");
			System.out.println("5. FIN");
			op = sc.nextInt();
			System.out.println();
			
			switch (op) {
			
				case 1:
					System.out.println("Introduzca el numero del producto:");
					numProducto = sc.nextInt();
					System.out.println("Introduzca la descripcion del producto");
					sc.nextLine();
					descripcion = sc.nextLine();
					System.out.println("Introduce el precio:");
					precio = sc.nextFloat();
					Producto p = new Producto (numProducto, descripcion, precio);
					if (lista.insertar(p)) {
						System.out.println("Producto insertado.");
					}
					else {
						System.out.println("Producto no insertado, coincide su numero de producto.");
					}
					System.out.println();
					break;
				case 2:
					System.out.println("Introduzca el numero del producto:");
					numProducto = sc.nextInt();
					if (lista.borrarProducto(numProducto)) {
						System.out.println("Producto borrado.");
					}
					else {
						System.out.println("No existe ningun producto con ese numero de producto.");
					}
					System.out.println();
					break;
				case 3:
					System.out.println("Introduzca el numero del producto:");
					numProducto = sc.nextInt();
					if (lista.buscarProducto(numProducto) != null) {
						System.out.println(lista.buscarProducto(numProducto));
					}
					else {
						System.out.println("No existe ningun producto con ese numero de producto.");
					}
					System.out.println();
					break;
				case 4:
					System.out.println(lista);
					System.out.println();
					break;
				case 5:
					System.out.println("FIN");
					System.out.println();
					break;
				default:
					System.out.println("Opcion erronea");
					System.out.println();
			}
			
		} while (op != 5);
		
		
		sc.close();

	}

}
