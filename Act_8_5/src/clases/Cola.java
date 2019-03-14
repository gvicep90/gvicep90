/**
 * Clase Cola en la cual defino los atributos del array cola que tendrá un tamaño
 * dado en un atributo final y definiré otro atributo final para llamar NULO (-9) a los
 * elementos del array como si estuvieran vacíos.
 * Realizo un constructor Cola para inicializar el array en nulo (-9) todos sus valores.
 * Realizo los métodos para saber si está llena o vacia la cola, el método push para introducir
 * un elemento, el pop para recoger un elemento, el delete para borrar todos los elementos (ponerlos
 * todos en NULO).
 * También realizaré el métod toString.
 * 
 * @author  Gonzalo Vicente Cepeda
 * @version 1.0
 * @since   2019-02-20 
 */

package clases;

public class Cola {
	
	private final int TAM = 10;
	private int cola [] = new int [this.TAM];
	private final int NULO = -9;
	
	
	/**
	 * Constructor Cola en el cual inicializo todo el array pila a NULO (-9).
	 */
	public Cola () {
		for (int i = 0; i < this.TAM; i++) {
			this.cola [i] = this.NULO; 
		}
	}
	
	
	/**
	 * Método vacia, para comprobar si la cola está o no vacía.
	 * 
	 * @return Nos devuelve un booleano que será true si está vacia o false si no lo está.
	 */
	public boolean vacia () {
		boolean sw = true;
		if (this.cola [0] != this.NULO) {
			sw = false;
		}
		return sw;
	}
	
	
	/**
	 * Método llena, para comprobar si la cola está o no llena.
	 * 
	 * @return Nos devuelve un booleano que será true si está llena o false si no lo está.
	 */
	public boolean llena () {
		boolean sw = true;
		if (this.cola [this.TAM - 1] == this.NULO) {
			sw = false;
		}
		return sw;
	}
	
	
	/**
	 * Método encolar que a partir de un parámetro (n) nos lo añadirá en el array dela Cola en
	 * última posición. Se deberá comprobar antes que el array tiene espacio para un elemento más.
	 * 
	 * @param n Será el número entero que tendremos que introducir.
	 */
	public void encolar (int n) {
		int i;
		boolean sw = false;
		if (this.cola [0] == this.NULO) {
			this.cola [0] = n;
		}
		else {
			for (i = 1; i < this.TAM && sw == false; i++) {
				if (this.cola [i] == this.NULO) {
					this.cola [i] = n;
					sw = true;
				}
			}
		}
	}
	
	
	/**
	 * Método desencolar por el cual devolveremos el primer elemento del array, es decir,
	 * el primer valor que hemos introducido. Habrá que comprobar que el array no está vacio
	 * antes de usar este método.
	 * 
	 * @return Nos devolverá el número que de la Cola que ha sido introducido en el push más antiguo
	 * 		   que aún esté en la Cola.
	 */
	public int desencolar () {
		int numero = this.NULO, i;
		numero = this.cola [0];
		for (i = 1; i < this.TAM; i++) {
			this.cola [i - 1] = this.cola [i];
			this.cola [i] = this.NULO;
		}
		return numero;
	}
	
	
	/**
	 * Método delete, eliminará todos los elementos, es decir, los pondrá todos a NULO (-9).
	 */
	public void delete () {
		for (int i = 0; i < this.TAM && this.cola [i] != this.NULO; i++) {
			this.cola [i] = this.NULO;
		}
	}
	
	
	public String toString () {
		String cadena = "COLA: ";
		for (int i = 0; i < this.TAM && this.cola[i] != this.NULO; i++) {
			cadena = cadena + this.cola[i] + "  ";
		}
		return cadena;
	}

}
