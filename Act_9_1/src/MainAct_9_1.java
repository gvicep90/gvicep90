import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programa para adivinar un número aleatorio generado por el ordenador entre 1 y 500.
 * Cuando se adivine, te dirá el numero de intentos que utilizará el usuario.
 * Para comprobar el intento del usuario, uso un 'try' para recoger los datos y si el
 * dato no es un numero entero con un 'catch' de 'InputMismatchException' dará un mensaje de 
 * que el dato introducido no es del tipo indicado, que debe ser un número entero, este fallo
 * también se contará como error.
 * 
 * @author 	Gonzalo Vicente Cepeda
 * @version 1.0
 * @since 	2019-02-28
 */
public class MainAct_9_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int numAleatorio = (int) (Math.random() * 500) + 1;
		int num = 0, cont = 0;
		
		System.out.println("ADIVINAR EL NUMERO");
		
		while (numAleatorio != num) {
			
			cont ++;
			
			try {
				
				System.out.println("Introduce el numero entero que creas que es (del 1 al 500):");
				num = sc.nextInt();
				if (numAleatorio > num) {
					System.out.println("Fallaste. El numero es mayor.");
				}
				if (numAleatorio < num) {
					System.out.println("Fallaste. El numero es menor.");
				}
				System.out.println();
				
			}
			
			catch (InputMismatchException inputMismatchException) {
				System.out.println("Tipo de dato incorrecto, deben ser numeros enteros.");
				sc.nextLine();
			}
			
		}
		
		System.out.println("ACERTASTE. El juego ha terminado (numero de intentos = " + cont + ").");
		
		sc.close();

	}

}
