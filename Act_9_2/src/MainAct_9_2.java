
/**
 * Programa que servira para crear una excepcion, para luego lanzarla (throw)
 * y capturarla (catch) para mostrar el contenido de esta, viendo el flujo del
 * programa y de la excepcion.
 * Siempre saldra el mensaje de 'Excepcion capturada' ya que siempre es lanzada
 * y despues capturada, si no se lanzase (quitando el 'throw') se generaria un
 * bucle infinito ya que la excepcion no se capturaria y lo seguiria intentando
 * sin poder salir del 'while'.
 * @author 	Gonzalo Vicente Cepeda
 * @version 1.0
 * @since	2019-03-06
 */
public class MainAct_9_2 {

	public static void main(String[] args) {
		
		boolean sw = false;
		
		while (sw == false) {
			
			try {
				System.out.println("Creo un objeto de la clase Exception");
				Exception excepcion = new Exception ("Mensaje de la excepcion creada");
				throw excepcion;
			}
			
			catch (Exception e) {
				System.out.print("Muestro el mensaje de la excepcion lanzada en el try: ");
				System.out.println(e.getMessage());
				sw = true;
			}
			
			finally {
				if (sw == true) {
					System.out.println("Excepcion capturada");
				}
				else {
					System.out.println("Excepcion no capturada");
				}
			}
			
		}
		
	}

}
