package main;

import java.util.Scanner;

import clases.Jugador;

/**
 * El programa del juego, solo podemos construir objetos a partir de
 * la clase Jugador, a partir de ahi realizo mi programa creando 
 * el array 'partida' que contendra a la banca en la primera posicion del mismo y 
 * a los jugadores (de 1 a 5) en las siguientes posiciones del array.
 * @author  Gonzalo Vicente Cepeda
 * @version 1.0
 * @since   2019-02-07 
 */
public class MainAct_7_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int numeroJugadores, i, j, turno = 1, cartasSinUsar = 0;
		double puntosPrimeraPosicion = 0, puntosGanador = 0;
		
		System.out.println("JUEGO: LAS SIETE Y MEDIA");
		System.out.println("------------------------");
		System.out.println();
		
		//INTRODUZCO EL NUMERO DE JUGADORES Y LO VALIDO PARA QUE VAYA DE 1 A 5
		System.out.println("Introduce el numero de jugadores (1-5):");
		numeroJugadores = sc.nextInt();
		while (numeroJugadores > 5 || numeroJugadores < 1) {
			System.out.println("Numero de jugadores incorrecto (debe ser de 1 a 5), introduce el numero de nuevo:");
			numeroJugadores = sc.nextInt();
		}
		
		//CREO EL ARRAY PARTIDA, QUE CONTENDRA A LA BANCA Y LOS DIFERENTES JUGADORES
		//PARA EL JUGADOR DE LA POSICION '0' DE LA PARTIDA, CREO LA PARTIDA QUE SERA UN ATRIBUTO ESTATICO DEL METODO Jugador
		Jugador partida [] = new Jugador [numeroJugadores + 1];
		for (i = 0; i < numeroJugadores + 1; i++) {
			if (i == 0) {
				partida[i] = new Jugador();
				partida[i].barajaNueva();
				partida[i].cogeCarta();
			}
			else {
				partida[i] = new Jugador();
				partida[i].setBaraja(partida[0].getBaraja());
				partida[i].cogeCarta();
			}
		}
		
		System.out.println();
		
		//REPARTO Y MUESTRO UNA CARTA A CADA JUGADOR DE LA PARTIDA, INCLUIDO A LA BANCA
		for (i = 0; i < numeroJugadores + 1; i++) {
			if (i == 0) {
				System.out.println("Banca:");
			}
			else{
				System.out.println("Jugador " + i + ":");
			}
			for (j = 0; partida[i].getCartas()[j] != null; j++) {	
				if (partida[i].getCartas() != null) {
					System.out.println(partida[i].getCartas()[j]);
				}
				else {
					break;	
				}
			}
			//CUANTOS PUNTOS TIENE CADA JUGADOR/BANCA
			System.out.println(partida[i].getPuntos() + " PUNTOS");
			System.out.println();
		}
		
		System.out.println();
		
		//PARTIENDO DE TURNO 1 (JUGADOR 1), JUEGAN TODOS LOS JUGADORES SU PARTIDA
		while (turno < numeroJugadores + 1) {
			System.out.println();
			System.out.println("Jugador " + turno + ":");
			//MUESTRO LAS CARTAS DEL JUGADOR
			for (i = 0; partida[turno].getCartas()[i] != null; i++) {
				if (partida[turno].getCartas() != null) {
					System.out.println(partida[turno].getCartas()[i]);
				}
				else {
					break;	
				}
			}
			System.out.println(partida[turno].getPuntos() + " PUNTOS");
			//JUEGO (BUCLE HASTA QUE SE PASE DE 7.5 O NO QUIERA MAS CARTAS)
			String plantarse = "NO";
			j = 1;
			while (plantarse.equals("NO") && partida[turno].getEstado()) {
				//PREGUNTO SI QUIERE PLANTARSE Y VALIDO SI SE CONTESTA CORRECTAMENTE 'SI' o 'NO'
				System.out.println("Quieres plantarte?");
				plantarse = sc.next().toUpperCase();
				while (plantarse.compareTo("SI") != 0 && plantarse.compareTo("NO") != 0) {
					System.out.println("Respuesta invalida (debe ser SI o NO). Quieres plantarte?");
					plantarse = sc.next().toUpperCase();
				}
				//SI NO SE QUIERE PLANTAR, LE REPARTIRE UNA CARTA Y LA MOSTRARE, JUNTO CON LOS PUNTOS QUE TIENE AHORA
				if (plantarse.equals("NO")) {
					partida[turno].cogeCarta();	
					System.out.println(partida[turno].getCartas()[j]);
					System.out.println(partida[turno].getPuntos() + " PUNTOS");
					//COMPROBAR SI SE PASA
					if (partida[turno].getPuntos() > 7.5) {
						partida[turno].setEstado();
					}	
					j++;
				}
				else {
					break;
				}
				
				//SI SE PASA NO LE DEJO CONTINUAR JUGANDO
				if (partida[turno].getEstado() == false) {
					System.out.println("Te has pasado, no puedes robar mas cartas. JUGADOR " + turno + " ELIMINADO");
					break;
				}
			}
			
			//VOY GUARDANDO LA MAXIMA PUNTUACION DE LOS JUGADORES QUE NO SE HAYAN PASADO
			if (partida[turno].getEstado() && puntosPrimeraPosicion < partida[turno].getPuntos()) {
				puntosPrimeraPosicion = partida[turno].getPuntos();
			}
			turno ++;
		}
		
		//VEO SI QUEDA ALGUN JUGADOR O SI TODOS SE HAN PASADO
		boolean algunJugador = false;
		for (i = 1; i < numeroJugadores + 1 && algunJugador == false; i++) {
			if (partida[i].getEstado()) {
				algunJugador = true;
			}
		}
		
		int posiblesCartasBanca = 0;
		//SI QUEDAN JUGADORES LA BANCA EMPEZARA A JUGAR, SINO GANARA DIRECTAMENTE
		if (algunJugador == true) {
			
			//PRIMERO VEO LAS CARTAS SIN USAR DE LA BARAJA Y CUANTAS PODRIA USAR LA BANCA PARA SUPERAR LA MAXIMA PUNTUACION DE LOS JUGADORES QUE NO SE HAN PASADO, SIN PASARSE
			for (i = 0; i < 40; i++) {
				if (partida[0].getBaraja().getCartas()[i].getUso()){
					cartasSinUsar ++;
					if ((partida[0].getBaraja().getCartas()[i].getValor().getPuntos() + partida[0].getPuntos()) > puntosPrimeraPosicion) {
						posiblesCartasBanca ++;
					}
				}	
			}
			//COMPRUEBO SI LA POSIBILIDAD DE PASARSE ES MAYOR AL 50%
			while (posiblesCartasBanca  <= (cartasSinUsar * 0.5) && partida[0].getEstado()) {
				partida[0].cogeCarta();
				if (partida[0].getPuntos() > 7.5) {
					partida[0].setEstado();
					System.out.println("La BANCA se ha pasado.");
					break;
				}
				else {
					if (puntosPrimeraPosicion < partida[0].getPuntos()) {
						puntosPrimeraPosicion = partida[0].getPuntos();
					}
					//SI SIGUE SIN SUPERAR LA MAXIMA POSICION LO VOLVERA A HACER DE NUEVO
					cartasSinUsar = 0;
					posiblesCartasBanca = 0;
					for (i = 0; i < 40; i++) {
						if (partida[0].getBaraja().getCartas()[i].getUso()){
							cartasSinUsar ++;
							if ((partida[0].getBaraja().getCartas()[i].getValor().getPuntos() + partida[0].getPuntos()) > puntosPrimeraPosicion) {
								posiblesCartasBanca ++;
							}
						}	
					}
				}
			}
			System.out.println();
			//MUESTRO LA MANO DE LA BANCA
			System.out.println("BANCA:");
			for (i = 0; i < partida[0].getCartas().length; i++) {
				if (partida[0].getCartas()[i] != null) {
					System.out.println(partida[0].getCartas()[i]);
				}
				else {
					break;	
				}
			}
			System.out.println(partida[0].getPuntos() + " PUNTOS");
	
			//SI LA BANCA HA OBTENIDO LA MAYOR PUNTUACION SIN PASARSE O IGUAL A LA DEL MEJOR JUGADOR GANARA
			if (partida[0].getPuntos() >= puntosPrimeraPosicion && partida[0].getPuntos() <= 7.5) {
				System.out.println("BANCA GANADOR");
			}
			//SI NO BUSCAMOS GANADOR
			else {
				for (i = 1; i < partida.length; i++) {
					if (partida[i].getEstado() && puntosGanador < partida[i].getPuntos()) {
						puntosGanador = partida[i].getPuntos();
					}
				}
			
				System.out.println();
				System.out.println("PUNTUACION MAXIMA: " + puntosGanador + " PUNTOS");
				System.out.println("Ganador:");
			
				for (i = 0; i < partida.length; i++) {
					if (partida[i].getEstado() && puntosGanador == partida[i].getPuntos()) {
						System.out.println("JUGADOR " + i);
						break;
					}
				}
			}
		}
		else {
			System.out.println();
			System.out.println("Ganador: LA BANCA (todos los jugadores se han pasado)");
		}
		
		sc.close();
		
	}

}
