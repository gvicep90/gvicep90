package clases;

/**
 * Clase Nodo por el cual haremos un atributo en el que pondremos lo que contendrá el nodo, en este
 * caso un objeto Producto, que será el dato. Y otro atributo que será de la clase Nodo, guardando en este
 * el siguiente Nodo y así sucesivamente.
 * @author  Gonzalo Vicente Cepeda
 * @version 1.0
 * @since   2019-02-28 
 */
public class Nodo {
	
	private Producto producto;
	private Nodo sig;
	
	/**
	 * Constructor Nodo por defecto.
	 */
	public Nodo () {
		this.sig = null;
	}
	
	/**
	 * Constructor Nodo en el que introduciremos un Producto dado por parámetro y al siguiente Nodo lo pondremos en null.
	 * @param p -Producto que introduciremos en el main por teclado.
	 */
	public Nodo (Producto p) {
		this.producto = p;
		this.sig = null;
	}
	
	public Producto getProducto () {
		return this.producto;
	}
	
	public Nodo getSig () {
		return this.sig;
	}
	
	public void setProducto (Producto producto) {
		this.producto = producto;
	}
	
	public void setSig (Nodo nodo) {
		this.sig = nodo;
	}
 
}
