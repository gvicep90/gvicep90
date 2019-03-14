package clases;

/**
 * Clase Nodo por el cual haremos un atributo en el que pondremos lo que contendrá el nodo, en este
 * caso un numero entero, que será el dato. Y otro atributo que será de la clase Nodo, guardando en este
 * el siguiente Nodo y así sucesivamente.
 * @author  Gonzalo Vicente Cepeda
 * @version 1.0
 * @since   2019-02-27 
 */
public class Nodo {
	
	private int num;
	private Nodo sig;
	
	/**
	 * Constructor Nodo en el que le damos un valor como parámetro y al Nodo que contiene dentro
	 * de si mismo lo inicializamos a nulo.
	 * @param n -Sera un número entero.
	 */
	public Nodo (int n) {
		this.num = n;
		this.sig = null;
	}
	
	public int getNum () {
		return this.num;
	}
	
	public Nodo getSig () {
		return this.sig;
	}
	
	public void setNum (int n) {
		this.num = n;
	}
	
	public void setSig (Nodo nodo) {
		this.sig = nodo;
	}

}
