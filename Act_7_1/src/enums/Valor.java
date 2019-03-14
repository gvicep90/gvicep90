package enums;

/**
* Enumerado Valor donde pondremos el valor de la carta y ademas
* le daremos un valor en puntos para luego con un metodo podamos usar esos
* puntos para calcular los puntos de cada jugador.
* @author  Gonzalo Vicente Cepeda
* @version 1.0
* @since   2019-02-07
*/
public enum Valor {
		 
	UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6),SIETE(7), SOTA(0.5), CABABALLO(0.5), REY(0.5);
	 
	private double puntos;
	
	private Valor (double puntos) {
		this.puntos = puntos;
	}
	
	public double getPuntos() {
		return this.puntos;
	}
	
}