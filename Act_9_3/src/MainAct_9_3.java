
/**
 * Programa que genera un numero aleatorio del 0 al 999, y lanza una excepcion
 * distinta si es par o si es impar; en el 'catch' seguidamente capturará esa
 * excepcion y mostrara el mensaje que tenga dicha excepcion.
 * @author 	Gonzalo Vicente Cepeda
 * @version 1.0
 * @since	2019-03-06
 */
public class MainAct_9_3 {

	public static void main(String[] args) {
		
		int numero = (int) (Math.random()*1000);
		
		System.out.println(numero);
		
		try {
			if (numero % 2 == 0) {
				throw new Exception ("Numero PAR");
			}
			else {
				throw new Exception ("Numero IMPAR");
			}
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
