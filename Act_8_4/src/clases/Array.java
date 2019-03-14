/**
 * Clase Array he utilizado los distintos métodos de ordenación usados
 * en la actividad 8.3. pero en el array he puesto los atributos del tamaño y 
 * de un array.
 * Además he añadido el método de buscarLineal de un valor y buscarDicotomica
 * de un valor (para dichos métodos debemos ordenar el array anteriormente).
 * Tambié tendrá un método para fusionar 2 arrays y ordenarlos.
 * 
 * @author  Gonzalo Vicente Cepeda
 * @version 1.0
 * @since   2019-02-20 
 */

package clases;

public class Array {
	
	
	private int tam;
	private int array [] = new int [tam];
	
	
	public Array () {
		this.tam = 0;
	}
	
	public Array (int a[]) {
		this.tam = a.length;
		this.array = a;
	}

	
	/**
	 * Método OrdenarSeleccionDirecta, que ordena el array pasando el valor más
	 * pequeño a la posicion indicada por un marcador en la primera posición
	 * que vaya avanzando de uno en uno hasta tener el array completamente ordenado.
	 */
	public void OrdenarSeleccionDirecta () {
		
		int i, j, k, menor, aux;
		
		for (k = 0; k < this.array.length; k++) {
			System.out.print(this.array[k] + " ");
		}
		
		System.out.println();
		
		for (i = 0; i < this.array.length; i++) {
			menor = i;
			for (j = i + 1; j < this.array.length; j++) {
				if (this.array[j] < this.array[menor]) {
					menor = j;
				}
			}
			aux = this.array[menor];
			this.array[menor] = this.array[i];
			this.array[i] = aux;
		}
		
		System.out.println("(ordenar...)");
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
		
		int i, j, k, aux;
		
		for (k = 0; k < this.array.length; k++) {
			System.out.print(this.array[k] + " ");
		}
		
		System.out.println();
		
		for (i = 0; i < this.array.length - 1; i++) {
			for (j = this.array.length - 1; j > i; j--) {
				if (this.array[j - 1] > this.array[j]) {
					aux = this.array[j - 1];
					this.array[j - 1] = this.array[j];
					this.array[j] = aux;
				}
			}
		}
		
		System.out.println("(ordenar...)");
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
		
		int i, j, k, aux;
		
		for (k = 0; k < this.array.length; k++) {
			System.out.print(this.array[k] + " ");
		}
		
		System.out.println();
		
		for (i = 1; i < this.array.length ; i++) {
			aux = this.array[i];
			j = i - 1;
			while ((j >= 0) && (aux < this.array[j])) {
				this.array[j + 1] = this.array[j];
				j --;
			}
			this.array[j + 1] = aux;
		}
		

		System.out.println("(ordenar...)");
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
		
		int izq, dch, i, j, k, aux;
		
		for (k = 0; k < this.array.length; k++) {
			System.out.print(this.array[k] + " ");
		}
		
		System.out.println();
		
		izq = 1;
		dch = this.array.length - 1;
		j = this.array.length - 1;
		do {
			for (i = dch; i >= izq; i--) {
				if (this.array[i - 1] > this.array[i]) {
					aux = this.array[i - 1];
					this.array[i - 1] = this.array[i];
					this.array[i] = aux;
					j = i;
				}
			}
			izq = j + 1;
			for (i = izq; i <= dch; i++) {
				if (this.array[i - 1] > this.array[i]) {
					aux = this.array[i - 1];
					this.array[i - 1] = this.array[i];
					this.array[i] = aux;
					j = i;
				}
			}
			dch = j - 1;
		} while (izq < dch);
		
		System.out.println("(ordenar...)");
		for (k = 0; k < this.array.length; k++) {
			System.out.print(this.array[k] + " ");
		}
		
	}
	
	
	/**
	 * Método buscarLineal, en el cual dado un valor para un array ordenado, diremos
	 * si este se encuentra en el array o no, buscándolo de izquierda a derecha.
	 * Añadiré un contador de comparaciones para comtrastarlo con el otro método de búsqueda.
	 * 
	 * @param x (valor que vamos a buscar en el array)
	 * @return Nos devolverá un booleano verdadero si se encuentra en el array dicho valor,
	 * 		   o falso si este no está en el array.
	 */
	public boolean buscarLineal (int x) {
		boolean sw = false;
		int i, contComparaciones = 0;
		for (i = 0; i < this.array.length && sw == false; i++) {
			contComparaciones ++;
			if (this.array[i] == x) {
				sw = true;
			}
			contComparaciones ++;
		}
		
		System.out.println(contComparaciones + " comparaciones");
		
		return sw;
	}
	
	
	/**
	 * Método buscarDicotomica, que dado un valor un 'x' como parámetro, nos dirá si está o
	 * no en el array; buscando dicotómicamente este, es decir, añadiendo un pivote en mitad
	 * del array, y mirando si puede estar a un lado o al otro de este, eliminando la mitad de 
	 * las números donde no pueda estar y así sucesivamente.
	 * Añadiré un contador de comparaciones para comtrastarlo con el otro método de búsqueda.
	 * 
	 * @param x (valor que vamos a buscar en el array)
	 * @return Nos devolverá un booleano verdadero si se encuentra en el array dicho valor,
	 * 		   o falso si este no está en el array.
	 */
	public boolean buscarDicotomica (int x) {
		boolean sw = false;
		int dch = (this.array.length - 1), izq = 0, pivote, contComparaciones = 0;
		
		if (x >= this.array[izq] && x < this.array[dch]) {
			while (izq <= dch && sw == false) {
				contComparaciones ++;
				pivote = ((izq + dch) / 2);
				if (this.array[pivote] == x) {
					sw = true;
				}
				else {
					if (x < this.array[pivote]) {
						dch = pivote - 1;
					}
					else {
						izq = pivote + 1;
					}
					contComparaciones ++;
				}
				contComparaciones ++;
			}
		}
		contComparaciones ++;
		
		System.out.println(contComparaciones + " comparaciones");
		
		return sw;
	}
	
	
	/**
	 * Método fusion, por el cual mezclaremos 2 arrays uno el que tenemos en el objeto
	 * y el otro el que está en otro objeto, que lo cogeremos ccomo parámetro.
	 * Mezclará los array y los devolverá.
	 * 
	 * @param a2 (Objeto Array para mezclarlo con el que usemos el método)
	 * @return Nos devolverá otro objeto Array (a) el cual contendrá el array mezclado de los 2 y ordenado.
	 */
	public Array fusion (Array a2) {
		int t, i, j;
		t = this.tam + a2.tam;
		int nuevoArray [] = new int [t];
		for (i = 0; i < this.tam; i++) {
			nuevoArray [i] = this.array [i];
		}
		for (i = this.tam, j = 0; i < nuevoArray.length; i++, j++) {
			nuevoArray [i] = a2.array [j];
		}
		Array a = new Array (nuevoArray);
		a.OrdenarSeleccionDirecta();
		return a;
	}
	
	
}
