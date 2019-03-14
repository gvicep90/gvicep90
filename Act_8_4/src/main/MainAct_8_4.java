/**
 * Programa para comprobar los distintos métodos de búsqueda de un valor
 * en un array hechos en la clase Array, el cual ordenaré previamente con los métodos
 * de la actividad 8.3..
 * También probaré el método para fusionar los array de 2 objetos Array, los cuales
 * el primero doy los valores y en el segundo los pido por teclado.
 * 
 * @author 	Gonzalo Vicente Cepeda
 * @version 1.0
 * @since 	2019-02-20 
 */

package main;

import java.util.Scanner;

import clases.Array;

public class MainAct_8_4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int array1 [] = {6, 12, 5, 9, 3, 10, 1, 8, 2, 4, 7, 11};
		int numeroBusqueda;
		
		System.out.println("ACTIVIDAD 8.4.");
		System.out.println();
		Array a1 = new Array (array1);
		a1.OrdenarSeleccionDirecta();
		
		System.out.println();
		System.out.println();
		
		System.out.println("APARTADO A");
		System.out.print("Introduce el valor a buscar en el array: ");
		numeroBusqueda = sc.nextInt();
		System.out.println();
		System.out.println("BUSQUEDA LINEAL");
		if (a1.buscarLineal(numeroBusqueda)) {
			System.out.println("SI esta en el array");
		}
		else {
			System.out.println("NO esta en el array");
		}
		
		System.out.println();
		
		System.out.println("BUSQUEDA DICOTOMICA");
		if (a1.buscarDicotomica(numeroBusqueda)) {
			System.out.println("SI esta en el array");
		}
		else {
			System.out.println("NO esta en el array");
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("APARTADO B");
		int tam, i;
		System.out.print("Introduce el tamaño del nuevo array (para fusionarlo con el principal): ");
		tam = sc.nextInt();
		int array2 [] = new int [tam];
		for (i = 0; i < tam; i++) {
			System.out.print("posicion " + (i + 1) + ": ");
			array2 [i] = sc.nextInt();
		}
		Array a2 = new Array (array2);
		System.out.println();
		
		System.out.println("FUSION DE LOS 2 ARRAYS");
		a1.fusion(a2);
		
		sc.close();
				
	}

}
