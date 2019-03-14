/**
 * Clase ArrayOrdenado en la que definimos un atributo de un array y otro de
 * un entero final que será siempre -9 y que le daremos el nombre de NULO.
 * Estarán los métodos para insertar un número en el array (estos se insertarán
 * numericamente ORDENADOS en el array), borrar un numero dado
 * un valor (el priemro que aparezca) y borrar todos los numeros dado un valor.
 * También tendrá el método toString.
 * 
 * @author  Gonzalo Vicente Cepeda
 * @version 1.0
 * @since   2019-02-13 
 */

package clases;

public class ArrayOrdenado {

	private int array [] = new int [0];
	private final int NULO = -9;
	
	/**
	 * Constructor del array en el que inicializa todos sus valores en -9 
	 * o NULO que es como lo hemos llamado en el atributo; dado un tamaño del 
	 * array como parámetro.
	 * 
	 * @param tam
	 */
	public ArrayOrdenado (int tam) {
		int i;
		for (i = 0; i < tam; i++) {
			this.array [i] = this.NULO;
		}
	}
	
	/**
	 * Método insertar, para meter un valor dado por parámetro, el cual se pondrá en la
	 * siguiente posición del array, en la que haya un NULO, si no hubiese más espacio en dicho
	 * array, se agrandaria en tam/4 veces. Después de esto ordenára numericamente en el array.
	 * 
	 * @param valor
	 */
	public void insertar (int valor) {
		int i;
		boolean sw = true, sw_espacio = false;
		for (i = 0; i < this.array.length && sw == true; i++) {
			if (this.array[i] == this.NULO) {
				this.array[i] = valor;
				sw = false;
				sw_espacio = true;
			}
		}
		if (sw_espacio == false) {
			int sumaTam;
			if (this.array.length > 3) {
				sumaTam = this.array.length / 4;
			}
			else {
				sumaTam = 1;
			}
			int array_aux [] = new int [this.array.length + sumaTam];
			for (i = 0; i < array_aux.length; i++) {
				if (i < this.array.length) {
					array_aux[i] = this.array[i];
				}
				else {
					if (i == this.array.length) {
						array_aux[i] = valor;
					}
					else {
						array_aux[i] = this.NULO;
					}
				}
			}
			this.array = array_aux;
		}
		
		//ORDENAR EL ARRAY
		int j, aux;
		for (i = 0; i < this.array.length; i++) {
			for (j = i; j > 0; j--) {
				if (this.array[j] < this.array[j - 1] && this.array[j] != this.NULO) {
					aux = this.array[j];
					this.array[j] = this.array[j - 1];
					this.array[j - 1] = aux;
				}
			}
		}
		
	}
	
	/**
	 * Método borrarValor, que dado un valor como parámetro, borrará su primera aparición en el
	 * array y reorganizará dicho array para que todos los valores NULO(-9), estén al final del
	 * mismo, nos devolverá un booleano siendo true si borra algún valor o false si no encuentra ningún
	 * valor igual al dado por parámetro.
	 * 
	 * @param valor
	 * @return booleano true si borra algún valor y false si no encuentra ese valor en el array.
	 */
	public boolean borrarValor (int valor) {
		boolean sw = false;
		int i, j, aux;
		for (i = 0; i < this.array.length && sw == false; i++) {
			if (this.array[i] == valor) {
				this.array[i] = this.NULO;
				sw = true;
				for (j = i; j < this.array.length - 1; j ++) {
					aux = this.array[j];
					this.array[j] = this.array[j + 1];
					this.array[j + 1] = aux;
				}
			}
		}
		return sw;
	}
	
	/**
	 * Método borrarTodosValor que dado un valor por parámetro, borrará todos los valores coincidentes
	 * en el array, devolviendo el numero de valores borrados.
	 * 
	 * @param valor
	 * @return Número entero haciendo referencia al número de valores borrados.
	 */
	public int borrarTodosValor (int valor) {
		int cantidad = 0, i, cont, j, aux;
		for (i = 0; i < this.array.length; i++) {
			if (this.array[i] == valor) {
				this.array[i] = this.NULO;
				cantidad ++;
			}
		}
		for (cont = cantidad; cont > 0; cont--) {
			for (i = 0; i < this.array.length; i++) {
				if (this.array[i] == this.NULO) {
					for (j = i; j < this.array.length - 1; j ++) {
						aux = this.array[j];
						this.array[j] = this.array[j + 1];
						this.array[j + 1] = aux;
					}
				}
			}
		}
		return cantidad;
	}
	
	/**
	 * Metodo toString de la clase ArrayOrdenado
	 */
	public String toString () {
		String cadena = "ARRAY: ";
		for (int i = 0; i < this.array.length && this.array[i] != this.NULO; i++) {
			cadena = cadena + this.array[i] + "  ";
		}
		return cadena;
	}
	
}