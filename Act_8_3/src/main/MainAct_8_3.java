/**
 * Programa para comprobar los distintos métodos de ordenación hechos en
 * la clase Array.
 * 
 * @author 	Gonzalo Vicente Cepeda
 * @version 1.0
 * @since 	2019-02-15 
 */

package main;

import clases.Array;

public class MainAct_8_3 {

	public static void main(String[] args) {
		
		Array a1 = new Array ();
		System.out.println("METODO DE SELECCION DIRECTA");
		a1.OrdenarSeleccionDirecta();
		
		System.out.println();
		System.out.println();
		
		Array a2 = new Array ();
		System.out.println("METODO DE LA BURBUJA");
		a2.OrdenarBurbuja();
		
		System.out.println();
		System.out.println();
		
		Array a3 = new Array ();
		System.out.println("METODO DE INSERCCION DIRECTA");
		a3.OrdenarInsercionDirecta();
		
		System.out.println();
		System.out.println();
		
		Array a4 = new Array ();
		System.out.println("METODO DE LA BURBUJA MEJORADO");
		a4.OrdenarBurbujaMejorado();
		
	}

}
