package clases;

/**
 * Clase Producto, para generar un objeto producto, que se compone de un número de producto, una descripción y su precio.
 * @author  Gonzalo Vicente Cepeda
 * @version 1.0
 * @since   2019-02-28 
 */
public class Producto {

	private int numProducto;
	private String descripcion;
	private float precio;
	
	/**
	 * Constructor Producto por defecto, que le daremos el valor -9 al número de producto, la descripción estará vacia y el precio será 0.
	 */
	public Producto () {
		this.numProducto = -9;
		this.descripcion = "";
		this.precio = 0;
	}
	
	/**
	 * Constructor Producto, para introducir un producto con todos sus datos.
	 * @param num -Número entero que será el código del producto que no se podrá repetir.
	 * @param desc -String con una descripción del producto.
	 * @param p -Número decimal que nos servirá para indicar el precio del producto.
	 */
	public Producto (int num, String desc, float p) {
		this.numProducto = num;
		this.descripcion = desc;
		this.precio = p;
	}
	
	public int getNumProducto () {
		return this.numProducto;
	}
	
	public void setNumProducto (int num) {
		this.numProducto = num;
	}
	
	public String getDescripcion () {
		return this.descripcion;
	}
	
	public void setDescripcion (String desc) {
		this.descripcion = desc;
	}
	
	public float getPrecio () {
		return this.precio;
	}
	
	public void setPrecio (float p) {
		this.precio = p;
	}
	
	public String toString () {
		String cadena = "PRODUCTO: " + this.numProducto + " - DESCRIPCION:" + this.descripcion + " - PRECIO: " + this.precio + " €";
		return cadena;
	}
	
	/**
	 * Método compareTo, que comparará un producto con otro, si el primer codigo del producto es mayor al del segundo nos dará un '1',
	 * si es menor que el segundo nos dará un '-1' y si son iguales nos dará un '0'.
	 * Este método nos servirá para luego al insertar los productos poder compararlos.
	 * @param p -Producto que nos servirá para compararlo con el nuestro.
	 * @return -Nos devolverá un número entero (1, -1 o 0).
	 */
	public int compareTo (Producto p) {
		int i = 0;
		if (this.numProducto != p.numProducto) {
			if (this.numProducto > p.numProducto) {
				i = 1;
			}
			else {
				i = -1;
			}
		}
		return i;
	}
	
	

}
