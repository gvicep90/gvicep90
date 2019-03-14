/**
 * Clase Pila en la cual defino los atributos del array pila que tendrá un tamaño
 * dado en un atributo final y definiré otro atributo final para llamar NULO (-9) a los
 * elementos del array como si estuvieran vacíos.
 * Realizo un constructor Pila para inicializar el array en nulo (-9) todos sus valores.
 * Realizo los métodos para saber si está llena o vacia la pila, el método push para introducir
 * un elemento, el pop para recoger un elemento, el delete para borrar todos los elementos (ponerlos
 * todos en NULO).
 * También realizaré el métod toString.
 * 
 * @author  Gonzalo Vicente Cepeda
 * @version 1.0
 * @since   2019-02-20 
 */

package clases;

public class Pila {
	
	private final int TAM = 10;
	private int pila [] = new int [this.TAM];
	private final int NULO = -9;
	
	
	/**
	 * Constructor Pila en el cual inicializo todo el array pila a NULO (-9).
	 */
	public Pila () {
		for (int i = 0; i < this.TAM; i++) {
			this.pila [i] = this.NULO; 
		}
	}
	
	
	/**
	 * Método vacia, para comprobar si la pila está o no vacía.
	 * 
	 * @return Nos devuelve un booleano que será true si está vacia o false si no lo está.
	 */
	public boolean vacia () {
		boolean sw = true;
		if (this.pila [0] != this.NULO) {
			sw = false;
		}
		return sw;
	}
	
	
	/**
	 * Método llena, para comprobar si la pila está o no llena.
	 * 
	 * @return Nos devuelve un booleano que será true si está llena o false si no lo está.
	 */
	public boolean llena () {
		boolean sw = true;
		if (this.pila [this.TAM - 1] == this.NULO) {
			sw = false;
		}
		return sw;
	}
	
	
	/**
	 * Método push que a partir de un parámetro (n) nos lo añadirá en el array de
	 * la Pila en primera posición desplazando los demas valores. Se deberá comprobar antes
	 * que el array tiene espacio para un elemento más.
	 * 
	 * @param n Será el número entero que tendremos que introducir.
	 */
	public void push (int n) {
		int i;
		if (this.pila [0] == this.NULO) {
			this.pila [0] = n;
		}
		else {
			for (i = (this.TAM - 1); i >= 0; i--) {
				if (this.pila [i] != this.NULO) {
					this.pila [i + 1] = this.pila [i];
					this.pila [i] = n;
				}
			}
		}
	}
	
	
	/**
	 * Método pop por el cual devolveremos el primer elemento del array, es decir,
	 * el último valor que hemos introducido. Habrá que comprobar que el array no está vacio
	 * antes de usar este método.
	 * 
	 * @return Nos devolverá el número que de la Pila que ha sido introducido en último push.
	 */
	public int pop () {
		int numero = this.NULO, i;
		numero = this.pila [0];
		for (i = 1; i < this.TAM; i++) {
			this.pila [i - 1] = this.pila [i];
			this.pila [i] = this.NULO;
		}
		return numero;
	}
	
	
	/**
	 * Método delete, eliminará todos los elementos, es decir, los pondrá todos a NULO (-9).
	 */
	public void delete () {
		for (int i = 0; i < this.TAM && this.pila [i] != this.NULO; i++) {
			this.pila [i] = this.NULO;
		}
	}
	
	
	public String toString () {
		String cadena = "PILA: ";
		for (int i = 0; i < this.TAM && this.pila[i] != this.NULO; i++) {
			cadena = cadena + this.pila[i] + "  ";
		}
		return cadena;
	}

}
