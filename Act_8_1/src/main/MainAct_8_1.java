/**
 * Programa de un menú que nos da opciones sobre un array desordenado, en el que lo podremos
 * mostrar, insertar algún valor, borrar algun elemento dado su valor (el primero que encuentre) y
 * borrar todos los elementos de dado su valor.
 * Todo esto lo hará a partir de la clase ArrayDesordenado.
 * 
 * @author  Gonzalo Vicente Cepeda
 * @version 1.0
 * @since   2019-02-13 
 */

package main;

import java.util.Scanner;

import clases.ArrayDesordenado;

public class MainAct_8_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int tam = 0, op, valor;
		
		ArrayDesordenado array = new ArrayDesordenado (tam);
		
		do {
			System.out.println("MENU (ARRAY DESORDENADO):");
			System.out.println("0. MOSTRAR LOS ELEMENTOS NO NULOS DEL ARRAY");
			System.out.println("1. INSERTAR UN VALOR");
			System.out.println("2. BORRAR ELEMENTO DADO SU VALOR");
			System.out.println("3. BORRAR TODOS LOS ELEMENTOS DADO SU VALOR");
			System.out.println("4. FIN");
			op = sc.nextInt();
			System.out.println();
			
			switch (op) {
			
				case 0:
					System.out.println(array);
					System.out.println();
					break;
				case 1:
					System.out.println("Introduce valor (debe ser entero y positivo):");
					valor = sc.nextInt();
					while (valor < 1) {
						System.out.println("Valor erroneo, debe ser positivo; introducelo de nuevo:");
						valor = sc.nextInt();
					}
					array.insertar(valor);
					System.out.println();
					break;
				case 2:
					System.out.println("Introduce el valor (si hay varios borrara solo el primero de ellos):");
					valor = sc.nextInt();
					if (array.borrarValor(valor) == true) {
						System.out.println("Elemento borrado");
					}
					else {
						System.out.println("No hay elementos con ese valor");
					}
					System.out.println();
					break;
				case 3:
					System.out.println("Introduce el valor:");
					valor = sc.nextInt();
					System.out.println("Ha borrado " + array.borrarTodosValor(valor) + " elementos");
					System.out.println();
					break;
				case 4:
					System.out.println("FIN");
					System.out.println();
					break;
				default:
					System.out.println("Opcion erronea");
					System.out.println();
			}
			
		} while (op != 4);

		sc.close();
		
	}

}
