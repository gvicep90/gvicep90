/**
 * Programa para ordenar un array según el algoritmo de selección directa, por el cual
 * se irá pasando el valor más pequeño a la posicion indicada por un marcador en la primera
 * posición que vaya avanzando de uno en uno.
 * 
 * @author 	Gonzalo Vicente Cepeda
 * @version 1.0
 * @since 	2019-02-13 
 */

public class MainAct_8_2 {

	public static void main(String[] args) {
		
		int i, j, k, menor, aux;
		
		int a [] = {6, 12, 5, 9, 3, 10, 1, 8, 2, 4, 7, 11};
		//MOSTRAR EL ARRAY PRINCIPAL
		System.out.println("ARRAY PRINCIPAL:");
		for (k = 0; k < a.length; k++) {
			System.out.print(a[k] + " ");
		}
		System.out.println();
		System.out.println();
		
		for (i = 0; i < a.length; i++) {
			menor = i;
			for (j = i + 1; j < a.length; j++) {
				if (a[j] < a[menor]) {
					menor = j;
				}
			}
			aux = a[menor];
			a[menor] = a[i];
			a[i] = aux;
			//MOSTRAR EL ARRAY EN CADA PASADA POR EL BUCLE PRINCIPAL
			for (k = 0; k < a.length; k++) {
				System.out.print(a[k] + " ");
			}
			System.out.println();
		}
		
		//MOSTRAR EL ARRAY ORDENADO
		System.out.println();
		System.out.println("ARRAY ORDENADO:");
		for (k = 0; k < a.length; k++) {
			System.out.print(a[k] + " ");
		}
		
	}

}
