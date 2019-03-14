/**
 * Clase Array en la cual haremos los distintos algoritmos de
 * ordenación para ordenar un array que lo definiremos como atributo.
 * Además en cada métod de ordenación tendrá un contador de asignaciones o
 * otro de comparaciones, para saber cual es más eficiente.
 * 
 * @author  Gonzalo Vicente Cepeda
 * @version 1.0
 * @since   2019-02-15 
 */

package clases;

public class Array {
	
	private int array [] = {6, 12, 5, 9, 3, 10, 1, 8, 2, 4, 7, 11};
	
	public Array () {
		
	}
	
	/**
	 * Método OrdenarSeleccionDirecta, que ordena el array pasando el valor más
	 * pequeño a la posicion indicada por un marcador en la primera posición
	 * que vaya avanzando de uno en uno hasta tener el array completamente ordenado.
	 */
	public void OrdenarSeleccionDirecta () {
		
		int contComparaciones = 0, contAsignaciones = 0, i, j, k, menor, aux;
		
		for (k = 0; k < this.array.length; k++) {
			System.out.print(this.array[k] + " ");
		}
		
		System.out.println();
		
		for (i = 0; i < this.array.length - 1; i++) {
			contAsignaciones ++;
			contComparaciones ++;
			menor = i;
			contAsignaciones ++;
			for (j = i + 1; j < this.array.length; j++) {
				contAsignaciones ++;
				contComparaciones ++;
				if (this.array[j] < this.array[menor]) {
					menor = j;
					contAsignaciones ++;
				}
				contComparaciones ++;
			}
			aux = this.array[menor];
			this.array[menor] = this.array[i];
			this.array[i] = aux;
			contAsignaciones = contAsignaciones + 3;
		}
		
		System.out.println(contComparaciones + " comparaciones");
		System.out.println(contAsignaciones + " asignaciones");
		for (k = 0; k < this.array.length; k++) {
			System.out.print(this.array[k] + " ");
		}
		
	}
	
	/**
	 * Método OrdenarBurbuja, que ordena el array haciendo una pasada por el array
	 * de derecha a izquierda comprobando valor por valor si es menor que el anterior y en ese
	 * caso intercambiarlo. Se realizara este recorrido tantas veces como grande sea el tamaño 
	 * del array a ordenar.
	 */
	public void OrdenarBurbuja () {
		
		int contComparaciones = 0, contAsignaciones = 0, i, j, k, aux;
		
		for (k = 0; k < this.array.length; k++) {
			System.out.print(this.array[k] + " ");
		}
		
		System.out.println();
		
		for (i = 0; i < this.array.length - 1; i++) {
			contAsignaciones ++;
			contComparaciones ++;
			for (j = this.array.length - 1; j > i; j--) {
				contAsignaciones ++;
				contComparaciones ++;
				if (this.array[j - 1] > this.array[j]) {
					aux = this.array[j - 1];
					this.array[j - 1] = this.array[j];
					this.array[j] = aux;
					contAsignaciones = contAsignaciones + 3;
				}
				contComparaciones ++;
			}
		}
		
		System.out.println(contComparaciones + " comparaciones");
		System.out.println(contAsignaciones + " asignaciones");
		for (k = 0; k < this.array.length; k++) {
			System.out.print(this.array[k] + " ");
		}
		
	}
	
	/**
	 * Método OrdenarInserccionDirecta, ordena el array de forma que guardamos
	 * el valor de la segunda posición del array en un auxiliar y si el valor de 
	 * esa posición es menor que el de la posicion anterior lo intercambiará.
	 * Lo repetirá hasta haber recorrido todo el array.
	 */
	public void OrdenarInsercionDirecta () {
		
		int contComparaciones = 0, contAsignaciones = 0, i, j, k, aux;
		
		for (k = 0; k < this.array.length; k++) {
			System.out.print(this.array[k] + " ");
		}
		
		System.out.println();
		
		for (i = 1; i < this.array.length ; i++) {
			contAsignaciones ++;
			contComparaciones ++;
			aux = this.array[i];
			j = i - 1;
			contAsignaciones = contAsignaciones + 2;
			while ((j >= 0) && (aux < this.array[j])) {
				contComparaciones ++;
				this.array[j + 1] = this.array[j];
				j --;
				contAsignaciones = contAsignaciones + 2;
			}
			this.array[j + 1] = aux;
			contAsignaciones ++;
		}
		
		System.out.println(contComparaciones + " comparaciones");
		System.out.println(contAsignaciones + " asignaciones");
		for (k = 0; k < this.array.length; k++) {
			System.out.print(this.array[k] + " ");
		}
		
	}
	
	/**
	 * Método OrdenarBurbujaMejorado, ordena el array mirando a la vez desde la izquierda y la derecha
	 * si los valores son menor que el anterior por la izquierda y por la izquierda; este proceso lo
	 * repetirá hasta que el valor de la izquierda sea mayor o igual que el de la derecha.
	 */
	public void OrdenarBurbujaMejorado () {
		
		int contComparaciones = 0, contAsignaciones = 0, izq, dch, i, j, k, aux;
		
		for (k = 0; k < this.array.length; k++) {
			System.out.print(this.array[k] + " ");
		}
		
		System.out.println();
		
		izq = 1;
		dch = this.array.length - 1;
		j = this.array.length - 1;
		contAsignaciones = contAsignaciones + 3;
		do {
			contComparaciones ++;
			for (i = dch; i >= izq; i--) {
				contAsignaciones ++;
				contComparaciones ++;
				if (this.array[i - 1] > this.array[i]) {
					aux = this.array[i - 1];
					this.array[i - 1] = this.array[i];
					this.array[i] = aux;
					j = i;
					contAsignaciones = contAsignaciones + 4;
				}
				contComparaciones ++;
			}
			izq = j + 1;
			contAsignaciones ++;
			for (i = izq; i <= dch; i++) {
				contAsignaciones ++;
				contComparaciones ++;
				if (this.array[i - 1] > this.array[i]) {
					aux = this.array[i - 1];
					this.array[i - 1] = this.array[i];
					this.array[i] = aux;
					j = i;
					contAsignaciones = contAsignaciones + 4;
				}
				contComparaciones ++;
			}
			dch = j - 1;
			contAsignaciones ++;
		} while (izq < dch);
		
		System.out.println(contComparaciones + " comparaciones");
		System.out.println(contAsignaciones + " asignaciones");
		for (k = 0; k < this.array.length; k++) {
			System.out.print(this.array[k] + " ");
		}
		
	}

}
