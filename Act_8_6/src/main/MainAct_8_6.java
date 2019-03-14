package main;

import java.util.Scanner;

import clases.Lista;

/**
 * Programa en el que hago un menú para hacer una lista mediante nodos, en la cual puedo insertar al principio o al final, buscar
 * si está o no un nodo, borrar un nodo si se encuentra en la lista y mostrar la lista que tenemos en cualquier momento.
 * Para esto, llamaré a la Clase Lista para las distintas acciones del menú, llamando a sus diferentes métodos.
 * @author 	Gonzalo Vicente Cepeda
 * @version 1.0
 * @since 	2019-02-27 
 */
public class MainAct_8_6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int op, valor;
		
		Lista lista = new Lista ();
		
		do {
			System.out.println("MENU:");
			System.out.println("1. INSERTAR NODO PRINCIPIO");
			System.out.println("2. INSERTAR NODO FINAL");
			System.out.println("3. BORRAR UN NODO");
			System.out.println("4. BUSCAR UN NODO");
			System.out.println("5. MOSTRAR LA LISTA");
			System.out.println("6. FIN");
			op = sc.nextInt();
			System.out.println();
			
			switch (op) {
			
				case 1:
					System.out.println("Introduce el valor:");
					valor = sc.nextInt();
					lista.insertarPrincipio(valor);
					System.out.println();
					break;
				case 2:
					System.out.println("Introduce el valor:");
					valor = sc.nextInt();
					lista.insertarFinal(valor);
					System.out.println();
					break;
				case 3:
					System.out.println("Introduce el valor:");
					valor = sc.nextInt();
					if (lista.borrarNodo(valor)) {
						System.out.println("Nodo borrado");
					}
					else {
						System.out.println("No hay ningun nodo con ese valor");
					}
					System.out.println();
					break;
				case 4:
					System.out.println("Introduce el valor:");
					valor = sc.nextInt();
					if (lista.buscarNodo(valor)) {
						System.out.println("Nodo encontrado");
					}
					else {
						System.out.println("No hay ningun nodo con ese valor");
					}
					System.out.println();
					break;
				case 5:
					System.out.println(lista);
					System.out.println();
					break;
				case 6:
					System.out.println("FIN");
					System.out.println();
					break;
				
				default:
					System.out.println("Opcion erronea");
					System.out.println();
			}
			
		} while (op != 6);
		
		
		sc.close();

	}

}
