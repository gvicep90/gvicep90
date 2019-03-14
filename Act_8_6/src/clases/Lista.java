package clases;

/**
 * Clase Lista en la que guardaremos el nodo que esté en primera posición.
 * Para crear esta clase, el atributo que le doy es del tipo Nodo, por lo que llamaré a los métodos que necesite de esta.
 * @author  Gonzalo Vicente Cepeda
 * @version 1.0
 * @since   2019-02-27 
 */
public class Lista {
	
	private Nodo primero;
	
	/**
	 * Constructor Lista por defecto que pone como primer nodo a nulo.
	 */
	public Lista () {
		this.primero = null;
	}
	
	/**
	 * Método insertarFinal, en el que dado un número entero, creará un nodo para el y lo insertará en última posición,
	 * mirando primero si está la posicion primera vacía y si eso ponerlo ahí; sino, irá avanzando por los nodos hasta llegar 
	 * al que en el Nodo siguiente tenga NULL y lo introduce ahí.
	 * @param n -Número entero que introducir al final de la lista.
	 */
	public void insertarFinal (int n) {
		Nodo nuevoNodo = new Nodo (n);
		if (this.primero == null) {
			this.primero = nuevoNodo;
		}
		else {
			Nodo aux = this.primero;
			while (aux.getSig() != null) {
				aux = aux.getSig();
			}
			aux.setSig(nuevoNodo);
		}
	}
	
	/**
	 * Método insertarPrincipio, en el que insertamos el parámetro que nos da en primer lugar. Si está vacío, lo introduciremos directamente
	 * en la primera posición. Sino le daremos al nuevo nodo creado el valor de siguiente del antiguo primero y en la primera posición,
	 * introduciremos el nuevo nodo.
	 * @param n -Número entero que introducir al principio de la lista.
	 */
	public void insertarPrincipio (int n) {
		Nodo nuevoNodo = new Nodo (n);
		if (this.primero == null) {
			this.primero = nuevoNodo;
		}
		else {
			nuevoNodo.setSig(this.primero);
			this.primero = nuevoNodo;
		}
	}
	
	/**
	 * Método buscarNodo, en el que dado un número lo buscaremos en la lista.
	 * @param n -Número entero a buscar en la lista.
	 * @return -Devuelve un booleano TRUE si ese parámetro está en la lista, y uno FALSE si no está.
	 */
	public boolean buscarNodo (int n) {
		boolean sw = false;
		Nodo aux = this.primero;
		while (aux != null && sw == false) {
			if (aux.getNum() == n) {
				sw = true;
			}
			else {
				aux = aux.getSig();
			}
		}
		return sw;
	}
	
	/**
	 * Método borrarNodo, en el que dado un valor, lo buscamos en la lista y si está lo borraremos.
	 * Al borrar un nodo que esté en primera posición, a la posición del primero le daremos la siguiente; y si está en otra posición,
	 * buscaremos donde está y creando un nodo siguiente que será el de 2 posiciones siguientes, se lo daremos al anterior del cual
	 * queremos borrar.
	 * @param n -Número entero que borrar su nodo en la lista.
	 * @return -Devuelve un booleano TRUE si ese parámetro está en la lista y lo borra, y uno FALSE si no está.
	 */
	public boolean borrarNodo (int n) {
		boolean sw = false;
		if (buscarNodo(n)) {
			sw = true;
			if (this.primero.getNum() == n) {
				this.primero = this.primero.getSig();
			}
			else {
				Nodo aux = this.primero;
				while (aux.getSig().getNum() != n) {
					aux = aux.getSig();
				}
				Nodo siguiente = aux.getSig().getSig();
				aux.setSig(siguiente);
			}
		}
		return sw;
	}
	
	public String toString () {
		String cadena = "LISTA: ";
		Nodo aux = this.primero;
		if (this.primero == null) {
			cadena = cadena + " (vacia)";
		}
		else {
			while (aux != null) {
				cadena = cadena + aux.getNum() + " ";
				aux = aux.getSig();
			}
		}
		return cadena;
	}
	
	

}
