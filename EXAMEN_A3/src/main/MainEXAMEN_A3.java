package main;

import java.util.Scanner;

import clases.Lista;

public class MainEXAMEN_A3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int op, num;
		
		Lista lista = new Lista ();
		
		do {
			System.out.println();
			System.out.println("1. INSERTAR NODO PRINCIPIO");
			System.out.println("2. INSERTAR NODO FINAL");
			System.out.println("3. BORRAR NODO");
			System.out.println("4. BUSCAR NODO");
			System.out.println("5. MOSTRAR LISTA");
			System.out.println("6. MOSTRAR LISTA EN ORDEN INVERSO");
			System.out.println("7. FIN");
			op = sc.nextInt();
			System.out.println();
			
			switch (op) {
				
				case 1:
					System.out.println("Introduce el numero:");
					num = sc.nextInt();
					lista.insertarPrincipio(num);
					break;
					
				case 2:
					System.out.println("Introduce el numero:");
					num = sc.nextInt();
					lista.insertarFinal(num);
					break;
					
				case 3:
					System.out.println("Introduce el numero:");
					num = sc.nextInt();
					if (lista.borrarNodo(num)) {
						System.out.println("Nodo borrado");
					}
					else {
						System.out.println("No hay ningun nodo con ese numero");
					}
					break;
					
				case 4:
					System.out.println("Introduce el numero:");
					num = sc.nextInt();
					if (lista.buscarNodo(num)) {
						System.out.println("El Nodo con ese numero SI esta en la lista");
					}
					else {
						System.out.println("El Nodo con ese numero NO esta en la lista");
					}
					break;
					
				case 5:
					System.out.println(lista.toString());
					break;
					
				case 6:
					System.out.println(lista.mostrarAlReves());
					break;
					
				case 7:
					System.out.println("FIN");
					break;
					
				default:
					System.out.println("Opcion erronea");
					break;
					
			}
			
		} while (op != 7);
		
		sc.close();
		
	}

}
