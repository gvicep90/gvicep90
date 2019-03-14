package main;

import clases.Array;

public class MainEXAMEN_A1 {

	public static void main(String[] args) {
		
		System.out.println("ORDENACION POR EL METODO DE SELECCION DIRECTA");
		//CREO EL OBJETO ARRAY
		Array a = new Array ();
		//ORDENO EL ARRAY
		a.OrdenarSeleccionDirecta();
		
		System.out.println();
		
		System.out.println("ORDENACION POR EL METODO DE BURBUJA");
		//CREO EL OBJETO ARRAY
		Array b = new Array ();
		//ORDENO EL ARRAY
		b.OrdenarBurbuja();

	}

}
