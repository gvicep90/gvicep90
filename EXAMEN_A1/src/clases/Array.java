package clases;

public class Array {
	
	private int array [] = {14, 17, 13, 1, 2, 23, 40, 9, 7, 2, 5, 11};
	
	public String toString () {
		String cadena = new String ();
		for (int i = 0; i < this.array.length; i++) {
			cadena = cadena + " " + this.array[i];
		}
		return cadena;
	}
	
	public void OrdenarSeleccionDirecta () {
		int i, j, k, posicionMenor, aux;
		//MUESTRO EL ARRAY DESORDENADO
		System.out.println("ARRAY DESORDENADO:");
		for (i = 0; i < this.array.length; i++) {
			System.out.print(this.array[i] + " ");
		}
		System.out.println();
		for (j = 0; j < this.array.length; j++) { //RECORRO EL ARRAY DE IZQ A DCH
			posicionMenor = j; //GUARDO EL VALOR DE LA VARIABLE 'j' EN 'menor' PARA SABER DONDE ESTA EL MENOR NUMERO DEL ARRAY
			for (k = j + 1; k < this.array.length; k++) {
				if (this.array[k] < this.array[posicionMenor]) {
					posicionMenor = k; //SI ES MENOR GUARDO LA POSICION DONDE ESTA
				}
			}
			//CREO UN AUXILIAR PARA DARLE EL VALOR DEL MENOR Y COLOCARLO EN LA POSICION QUE TOQUE
			aux = this.array[posicionMenor];
			this.array[posicionMenor] = this.array[j];
			this.array[j] = aux;
		}
		//MUESTRO EL ARRAY ORDENADO
		System.out.println("ARRAY ORDENADO:");
		for (i = 0; i < this.array.length; i++) {
			System.out.print(this.array[i] + " ");
		}
		System.out.println();
	}
	
	public void OrdenarBurbuja () {
		int i, j, k, aux;
		//MUESTRO EL ARRAY DESORDENADO
		System.out.println("ARRAY DESORDENADO:");
		for (i = 0; i < this.array.length; i++) {
			System.out.print(this.array[i] + " ");
		}
		System.out.println();
		for (j = 0; j < this.array.length - 1; j++) { //RECORRO EL ARRAY DE IZQ A DCH HASTA EL PENULTIMO VALOR
			for (k = this.array.length - 1; k > j; k--) { //RECORRO DESDE EL PENULTIMO HASTA EL VALOR QUE TIENE LA 'j' EN SENTIDO INVERSO
				if (this.array[k - 1] > this.array[k]) { //COMPRUEBO SI EL VALOR DE LA POSICION 'k' ES MENOR QUE EL ANTERIOR Y SI ES ASI LOS INTERCAMBIO
					aux = this.array[k - 1];
					this.array[k - 1] = this.array[k];
					this.array[k] = aux;
				}
			}
		}
		//MUESTRO EL ARRAY ORDENADO
		System.out.println("ARRAY ORDENADO:");
		for (i = 0; i < this.array.length; i++) {
			System.out.print(this.array[i] + " ");
		}
		System.out.println();
	}

}
