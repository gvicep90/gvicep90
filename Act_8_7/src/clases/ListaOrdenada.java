package clases;

/**
 * Clase ListaOrdenada en la que guardaremos el nodo que esté en primera posición.
 * Para crear esta clase, el atributo que le doy es del tipo Nodo, por lo que llamaré a los métodos que necesite de esta.
 * @author  Gonzalo Vicente Cepeda
 * @version 1.0
 * @since   2019-02-28
 */
public class ListaOrdenada {
	
	private Nodo primero;
	
	/**
	 * Constructor ListaOrdenada, en el que guardaremos el primer Nodo, este lo iniciaremos a null.
	 */
	public ListaOrdenada () {
		this.primero = null;
	}
	
	/**
	 * Método buscarProducto en el que introduciendo el número del producto por parámetro, lo buscaremos en la lista,
	 * Inicializamos un producto a null, por si no lo encontrase, para que devolviera este y hacemos un Nodo aux para ir recorriendo la
	 * lista, comprobando el número del producto a ver si coincide con alguno; si coincidiese, a ese producto inicinializado a null al
	 * prinicipio le daremos el valor del producto que coincide.
	 * @param numProducto -Introduciremos un número entero como número de producto el que comprobaremos si está en la lista.
	 * @return -Nos devuelve null si no lo encuentra o el producto coincidente si existe alguno con ese mismo número de producto.
	 */
	public Producto buscarProducto (int numProducto) {
		Producto p = null;
		Nodo aux = this.primero;
		while (aux != null && p == null) {
			if (aux.getProducto().getNumProducto() == numProducto) {
				p = aux.getProducto();
			}
			else {
				aux = aux.getSig();
			}
		}
		return p;
	}
	
	/**
	 * Método insertar en el que introduciremos un producto ordenadamente según su número en la lista, si este número ya estuviese,
	 * no lo insertaría porque no puede haber ninguno repetido.
	 * Si puede introducir el producto, devolverá un verdadero y si no poruqe ya está su número devolvera un falso.
	 * @param p -Producto a insertar ordenadamente en la lista.
	 * @return -Booleano que será TRUE si lo inserta en la lista o FALSE si no lo inserta.
	 */
	public boolean insertar (Producto p) {
		boolean sw = true;
		if (buscarProducto(p.getNumProducto()) != null) {
			sw = false;
		}
		else {
			Nodo nuevoNodo = new Nodo (p);
			if (this.primero == null) {
				this.primero = nuevoNodo;
			}
			else {
				if (p.compareTo(this.primero.getProducto()) == -1) {
					nuevoNodo.setSig(this.primero);
					this.primero = nuevoNodo;
				}
				else {
					Nodo aux = this.primero;
					sw = false;
					while (sw == false) {
						if (aux.getSig() == null) {
							aux.setSig(nuevoNodo);
							sw = true;
						}
						else {
							if (p.compareTo(aux.getSig().getProducto()) == -1) {
								nuevoNodo.setSig(aux.getSig());
								aux.setSig(nuevoNodo);
								sw = true;
							}
							else {
								aux = aux.getSig();
							}
						}
					}
				}	
			}
		}
		return sw;
	}
	
	/**
	 * Método borrarProducto, que introducido por parámetro un número de producto, buscará si está o no y después procederá a su borrado.
	 * Teniendo en cuenta en una vez borrado el Producto a eliminar, se mantiene sin romperse la cadena.
	 * @param numProducto -Número entero correspondiente al número de producto a borrar.
	 * @return -Booleano que será TRUE si lo borra de la lista o FALSE si no lo borra (porque no se encuentre).
	 */
	public boolean borrarProducto (int numProducto) {
		boolean sw = false;
		if (buscarProducto(numProducto) != null) {
			sw = true;
			if (this.primero.getProducto().getNumProducto() == numProducto) {
				this.primero = this.primero.getSig();
			}
			else {
				Nodo aux = this.primero;
				while (aux.getSig().getProducto().getNumProducto() != numProducto) {
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
				cadena = cadena + "\n" + aux.getProducto().toString();
				aux = aux.getSig();
			}
		}
		return cadena;
	}
	
	

}

