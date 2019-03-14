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
	
	//COPIO EL METODO OrdenarBurbuja PARA ORDENAR EL ARRAY ANTES DE REALIZAR LAS BÚSQUEDA
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
	
	public boolean busquedaLineal (int x) {
		boolean sw = false; //INICIO EL BOOLEANO A false Y LO PONDRE true CUANDO LO ENCUENTRE
		for (int i = 0; i < this.array.length && sw == false; i++) { //RECORRO EL ARRAY HASTA EL FINAL O HASTA QUE LO ENCUENTRE
			if (this.array[i] == x) {
				sw = true;
			}
		}
		return sw; //DEVUELVO true SI ESTA ESE ENTERO Y false SI NO ESTA
	}
	
	public boolean busquedaDicotomica (int x) {
		boolean sw = false;
		int b = (this.array.length - 1), a = 0, posicion; //COJO UN PARAMETRO 'a' PARA MARACAR EL INICIO Y UN 'b' PARA EL FINAL DEL ARRAY
		if (x >= this.array[a] && x <= this.array[b]) { //SI 'x' ESTA ENTRE ESTOS DOS VALORES PARA EL ARRAY, PODRA ESTAR EN EL
			while (a <= b && sw == false) { //HASTA QUE 'a' NO SEA MAYOR QUE 'b' O SE ENCUENTRE EL NUMERO, SEGUIREMOS BUSCANDOLO
				posicion = ((a + b) / 2); //MARCAMOS EL PARAMETRO 'posicion' EN LA MITAD ENTRE 'a' Y 'b'
				if (this.array[posicion] == x || this.array[a] == x || this.array[b] == x) { //COMPRUEBO SI MI NUMERO ES EL DEL PARAMETRO 'posicion' O 'a' O 'b'
					sw = true;
				}
				else { //SINO MIRO SI ESTA A LA IZQUIERDA O A LA DERECHA Y DESCARTO LOS VALORES DONDE NO PUEDE ESTAR (AIGNO A 'a' O 'b' EL VALOR DE 'posicion'
					if (x < this.array[posicion]) {
						b = posicion - 1;
					}
					else {
						a = posicion + 1;
					}
				}
			}
		}
		return sw;
	}
	

}
