package clases;

/**
 * Clase Jugador de donde solo podremos llamar en el main, por lo tanto para un jugador nos
 * interesa tener un array de sus cartas, un booleano (buenaJuegada), que nos indique si se 
 * ha pasado o no, y un contador de los puntos que lleva.
 * Al solo poder llamar a este metodo y solo necesitar una baraja para todos los jugadores,
 * usaremos un atributo estatico en el cual crearemos la baraja para luego en el main llamarlo
 * solo desde un jugador (la banca).
 * @author  Gonzalo Vicente Cepeda
 * @version 1.0
 * @since   2019-02-07 
 */
public class Jugador {

	private int TAM = 14;
	private Carta [] mano = new Carta[TAM];
	private double puntos;
	private boolean buenaJugada = true;
	public static Baraja baraja;
	
	/**
	 * Constructor Jugador en el que le pondremos el booleano a true, ya que
	 * aun no se ha pasado y los puntos a 0, ya que no tiene cartas aun.
	 */
	public Jugador () {
		this.puntos = 0;
		this.buenaJugada = true;
	}
	
	/**
	 * Metodo para crear la nueva Baraja en la clase Jugador.
	 */
	public void barajaNueva () {
		this.baraja = new Baraja();
	}
	
	public Baraja getBaraja () {
		return this.baraja;
	}
	
	public void setBaraja (Baraja baraja) {
		this.baraja = baraja;
	}
	
	/**
	 * Metodo cogeCarta que en el cual los puntos de un jugador se aumentaran en
	 * funcion del valor de la carta y esta misma cambiara su estado a carta usada.
	 */
	public void cogeCarta () {
		int i;
		for (i = 0; i < this.TAM; i++) {
			if (this.mano[i] == null) {
				this.mano[i] = baraja.getCarta(baraja.getSiguienteCarta());
				puntos = puntos + this.mano[i].getValor().getPuntos(); 
				this.mano[i].setUso();
				break;
			}
		}
	}
	
	/**
	 * Metodo setEstado nos servira para indicar cuando un jugador se ha pasado.
	 */
	public void setEstado () {
		this.buenaJugada = false;
	}
	
	/**
	 * Metodo getEstado nos servira para saber el estado booleano que nos
	 * indica si un jugador se ha pasado o no.
	 * @return - Nos dira el si el jugador se ha pasado o no.
	 */
	public boolean getEstado () {
		return this.buenaJugada;
	}
	
	/**
	 * getPuntos nos dira los puntos que tiene cada jugador.
	 * @return - Los puntos del jugador.
	 */
	public double getPuntos () {
		return this.puntos;
	}
	
	/**
	 * Metodo getCartas que nos indicara las cartas de un jugador al que se lo apliquemos.
	 * @return - Un array con las cartas del jugador.
	 */
	public Carta [] getCartas () {
		return this.mano;
	}
	
}