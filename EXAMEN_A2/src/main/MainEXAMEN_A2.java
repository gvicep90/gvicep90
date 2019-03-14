package main;

import java.util.Scanner;

import clases.Array;

public class MainEXAMEN_A2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int num;
		
		//CREO UN ARRAY Y LO ORDENO PARA LUEGO REALIZAR LAS BUSQUEDAS
		Array a = new Array ();
		a.OrdenarBurbuja();
		
		System.out.println();
		
		
		System.out.println("Introduce un numero para su BUSQUEDA LINEAL:");
		num = sc.nextInt();
		if (a.busquedaLineal(num)) { //BUSQUEDA LINEAL
			System.out.println("SI esta en el array");
		}
		else {
			System.out.println("NO esta en el array");
		}
		
		System.out.println();
		
		System.out.println("Introduce un numero para su BUSQUEDA DICOTOMICA:");
		num = sc.nextInt();
		if (a.busquedaDicotomica(num)) { //BUSQUEDA DICOTOMICA
			System.out.println("SI esta en el array");
		}
		else {
			System.out.println("NO esta en el array");
		}
		
		sc.close();
	}

}
