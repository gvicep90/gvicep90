package clases;

import java.util.Random;

import enums.Palo;
import enums.Valor;

/**
 * Clase Baraja nos servira para crear una baraja ordenada aleatoriamente, ademas
 * creo un atributo siguienteCarta con el que a la hora de repartir estas a los jugadores,
 * vaya avanzando en el array de Cartas que sera la baraja.
 * @author  Gonzalo Vicente Cepeda
 * @version 1.0
 * @since   2019-02-07 
 */
public class Baraja {
	
	private Carta [] barajaCartas = new Carta[40];
	private int siguienteCarta = 0;
	
	
	/**
	 * Constructor Baraja que creo una baraja ordenada y despues usare Random para
	 * desordenar la misma. 
	 */
	public Baraja () {
		Palo palos[] = Palo.values();
		Valor valores[] = Valor.values();
		
		this.barajaCartas = new Carta [40];
		for (int i = 0; i < this.barajaCartas.length; i++) {
			this.barajaCartas [i] = new Carta (valores [i % 10], palos [i / 10]);
		}
		
		Random rand = new Random ();
		for (int i = 0; i < this.barajaCartas.length; i++) {
			int j = rand.nextInt(40);
			Carta aux = this.barajaCartas[i];
			this.barajaCartas[i] = this.barajaCartas[j];
			this.barajaCartas[j] = aux;
		}
	}
	
	public Carta [] getCartas () {
		return this.barajaCartas;
	}
	
	public int getSiguienteCarta() {
		return this.siguienteCarta;
	}
	
	/**
	 * Metodo getCarta para repartir una carta de esta baraja, en el cual
	 * sumaremos 1 a la posicion de siguienteCarta.
	 * @param carta - Posicion del array de una Carta.
	 * @return - Nos dara la carta de la posicion dada.
	 */
	public Carta getCarta (int carta) {
		this.siguienteCarta = this.siguienteCarta + 1;
		return this.barajaCartas [carta];
	}
	
}