/**
 * Antes de ver la solucion pienso que el numero que la salida
 * que va a generar es 1 o 3, porque el 2 solo se generara si 
 * se lanza la excepcion y en este caso al ser 1 el numero no
 * entrara en el 'if', por lo que no lanzara la excepcion.
 * Pero al haber 2 return no se si se ejecutaran los dos, el
 * primero que tiene ya que esta fuera del 'if' o el ultimo,
 * ya que esta en el 'finally' y se ejecuta siempre.
 */


public class MainAct_9_4 {

	public static int devuelveNumero (int num) {
		try {
			if (num % 2 == 0) {
				throw new Exception ("Lanzando excepcion");
			}
			return 1;
		}
		catch (Exception ex) {
			return 2;
		}
		finally {
			return 3;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(devuelveNumero(1));
		
	}
	
	/**
	 * Una vez ejecutado el programa veo que la salida es 3, supongo
	 * que sera el ultimo return que se ejecuta en el metodo y que
	 * probando a quitar el finally la salida por pantalla es 1.
	 */

}
