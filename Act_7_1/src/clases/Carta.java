package clases;

import enums.Palo;
import enums.Valor;

/**
* La clase Carta esta realizada para construir las cartas de la baraja a partir de
* los dos enumerados (Valor y Palo). Ademas le añadire el atributo 'uso' con un booleano
* para saber si la carta esta usada o no.
* @author  Gonzalo Vicente Cepeda
* @version 1.0
* @since   2019-02-07 
*/
public class Carta {


	private Valor valor;
	private Palo palo;
	private boolean uso;
	
	public Carta () {
	}
	
	/**
	 * Constructor de una carta a partir de los parametros valor y palo.
	 * @param valor -
	 * @param palo -
	 */
	public Carta (Valor valor, Palo palo) {
		this.valor = valor;
		this.palo = palo;
		this.uso = true;
	}
	
	public String toString () {
		String carta = "";
		carta = this.valor.name() + " DE " + this.palo.name();
		return carta;
	}
	
	/**
	 * Metodo getUso para saber si una carta esta usada, me servira en el main
	 * para contar las cartas de la baraja que estan usadas y las que no.
	 * @return - Nos dira si la carta esta usada no con un booleano.
	 */
	public boolean getUso() {
		return this.uso;
	}
	
	/**
	 * Metodo setUso me servira para cada vez que
	 * reparta una carta que esta se marque como ya usada.
	 */
	public void setUso() {
		this.uso = false;
	}
	
	public Valor getValor() {
		return this.valor;
	}
	
	public Palo getPalo() {
		return this.palo;
	}
	
	/**
	 * Metodo getPuntos me servira para poder saber los puntos que vale una carta.
	 * @return - Nos devolvera el valor de la carta dirigiendose al enumerado Valor.
	 */
	public double getPuntos () {
		return this.getValor().getPuntos();
	}
	
}