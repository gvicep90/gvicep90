/**
 * Programa en el que pongo un menu para elegir si quieres usar PILA o COLA,
 * y despues de esto te saldra otro menú en el cual podrás mostrarlo (la pila o la cola),
 * añadir un valor (push) comprobando que esta no este llena, recibir un valor (pop) comprobando
 * que esta no este vacia o borrar todos los elementos de la pila o cola.
 * Esto, lo realizare con los distintos métodos de las clases Pila y Cola.
 * 
 * @author 	Gonzalo Vicente Cepeda
 * @version 1.0
 * @since 	2019-02-20 
 */

package main;

import java.util.Scanner;

import clases.Cola;
import clases.Pila;

public class MainAct_8_5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int op, valor;
		
		do {
			System.out.println("ELIJA LA ESTRUCTURA A DEFINIR:");
			System.out.println("1. PILA");
			System.out.println("2. COLA");
			System.out.println("3. FIN");
			op = sc.nextInt();
			System.out.println();
			
			switch (op) {
			
				case 1:
					
					Pila p = new Pila ();
					
					do {
						System.out.println("MENU (PILA):");
						System.out.println("0. MOSTRAR LA PILA");
						System.out.println("1. PUSH");
						System.out.println("2. POP");
						System.out.println("3. DELETE");
						System.out.println("4. FIN");
						op = sc.nextInt();
						System.out.println();
						
						switch (op) {
						
							case 0:
								System.out.println(p);
								System.out.println();
								break;
							case 1:
								if (p.llena()) {
									System.out.println("La pila esta llena, no puedes introducir mas valores");
								}
								else {
									System.out.println("Introduce el valor a introducir:");
									valor = sc.nextInt();
									p.push(valor);
								}
								System.out.println();
								break;
							case 2:
								if (p.vacia()) {
									System.out.println("La pila esta vacia, no puedes sacar ningun valor");
								}
								else {
									valor = p.pop();
									System.out.println("Elemento sacado: " + valor);
								}
								System.out.println();
								break;
							case 3:
								if (p.vacia()) {
									System.out.println("La pila esta vacia, no borrara ningun valor");
								}
								else {
									p.delete();
									System.out.println("Pila borrada");
								}
								System.out.println();
								break;
							case 4:
								System.out.println("FIN PILA");
								System.out.println();
								break;
							default:
								System.out.println("Opcion erronea");
								System.out.println();
						}
						
					} while (op != 4);
					break;
				case 2:

					Cola c = new Cola ();
					
					do {
						System.out.println("MENU (COLA):");
						System.out.println("0. MOSTRAR LA COLA");
						System.out.println("1. ENCOLAR");
						System.out.println("2. DESENCOLAR");
						System.out.println("3. DELETE");
						System.out.println("4. FIN");
						op = sc.nextInt();
						System.out.println();
						
						switch (op) {
						
							case 0:
								System.out.println(c);
								System.out.println();
								break;
							case 1:
								if (c.llena()) {
									System.out.println("La cola esta llena, no puedes introducir mas valores");
								}
								else {
									System.out.println("Introduce el valor a introducir:");
									valor = sc.nextInt();
									c.encolar(valor);
								}
								System.out.println();
								break;
							case 2:
								if (c.vacia()) {
									System.out.println("La cola esta vacia, no puedes sacar ningun valor");
								}
								else {
									valor = c.desencolar();
									System.out.println("Elemento sacado: " + valor);
								}
								System.out.println();
								break;
							case 3:
								if (c.vacia()) {
									System.out.println("La cola esta vacia, no borrara ningun valor");
								}
								else {
									c.delete();
									System.out.println("Cola borrada");
								}
								System.out.println();
								break;
							case 4:
								System.out.println("FIN COLA");
								System.out.println();
								break;
							default:
								System.out.println("Opcion erronea");
								System.out.println();
						}
						
					} while (op != 4);
					break;
				case 3:
					System.out.println("FIN");
					System.out.println();
					break;
				default:
					System.out.println("Opcion erronea");
					System.out.println();
			}
			
		} while (op != 3);
		
		
		sc.close();
		
	}

}
