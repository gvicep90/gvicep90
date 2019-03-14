package clases;

public class Lista {
	
	private Nodo primero;
	private Nodo ultimo; //CREO UN NODO ULTIMO PARA QUE ME SEA MAS FACIL INTRODUCIR AL FINAL Y LEER LA LISTA EN ORDEN INVERSO
	
	public Lista () {
		this.primero = null;
		this.ultimo = null;
	}
	
	public void insertarFinal (int n) {
		Nodo nuevoNodo = new Nodo (n);
		if (this.primero == null) { //SI NO HAY NINGUN NODO AUN, A PRIMERO Y A ULTIMO LE DOY EL VALOR DEL NUEVO NODO
			this.primero = nuevoNodo;
			this.ultimo = nuevoNodo;
		}
		else { //SI HAY YA NODOS, CAMBIO EL SIGUIENTE DEL ULTIMO AL NUEVO Y EL ANTERIOR DEL NUEVO AL ULTIMO, SIENDO AHORA EL ULTIMO EL NUEVO
			this.ultimo.setSig(nuevoNodo);
			nuevoNodo.setAnt(this.ultimo);
			this.ultimo = nuevoNodo;
		}
	}
	
	public void insertarPrincipio (int n) {
		Nodo nuevoNodo = new Nodo (n);
		if (this.primero == null) { //SI NO HAY NINGUN NODO AUN, A PRIMERO Y A ULTIMO LE DOY EL VALOR DEL NUEVO NODO
			this.primero = nuevoNodo;
			this.ultimo = nuevoNodo;
		}
		else { //SI HAY YA NODOS, CAMBIO EL ANTERIOR DEL PRIMERO AL NUEVO Y EL SIGUIENTE DEL NUEVO AL PRIMERO, SIENDO AHORA EL PRIMERO EL NUEVO
			this.primero.setAnt(nuevoNodo);
			nuevoNodo.setSig(this.primero);
			this.primero = nuevoNodo;
		}
	}
	
	public boolean buscarNodo (int n) {
		boolean sw = false;
		Nodo aux = this.primero;
		while (aux != null && sw == false) { //VOY BUSCANDO A VER HASTA ENCONTRAR EL NUMERO O HASTA LLEGAR A UN NODO NULO
			if (aux.getNum() == n) {
				sw = true;
			}
			else {
				aux = aux.getSig();
			}
		}
		return sw;
	}
	
	public boolean borrarNodo (int n) {
		boolean sw = false;
		if (buscarNodo(n)) { //SI ESTA EL NODO CONTINUO PARA BORRARLO, SI NO ESTA VOY AL FINAL CON EL VALOR DE 'sw' FALSE
			sw = true; //COMO YA HA ENTRADO CAMBIO EL BOOLEANO A TRUE PORQUE AHORA BORRARA UN NODO
			if (this.primero.getNum() == n) { //BORRO EL PRIMER NODO
				this.primero = this.primero.getSig();
				this.primero.setAnt(null);
			}
			else {
				if (this.ultimo.getNum() == n) { //BORRO EL ULTIMO NODO
					this.ultimo = this.ultimo.getAnt();
					this.ultimo.setSig(null);
				}
				else { //BORRO UN NODO QUE NO SEA NI EL PRIMERO NI EL ULTIMO
					Nodo aux = this.primero;
					while (aux.getSig().getNum() != n) {
						aux = aux.getSig();
					}
					Nodo siguiente = aux.getSig().getSig();
					aux.setSig(siguiente);
					aux = aux.getSig();
					Nodo anterior = aux.getAnt().getAnt();
					aux.setAnt(anterior);
				}
			}
		}
		return sw;
	}
	
	public String toString () {
		String cadena = "LISTA: ";
		Nodo aux = this.primero;
		if (this.primero == null) {
			cadena = cadena + " (aun no hay datos)";
		}
		else {
			while (aux != null) {
				cadena = cadena + aux.getNum() + " ";
				aux = aux.getSig();
			}
		}
		return cadena;
	}
	
	public String mostrarAlReves () { //MOSTRAR AL REVES LA LISTA
		String cadena = "LISTA: ";
		Nodo aux = this.ultimo;
		if (this.primero == null) {
			cadena = cadena + " (aun no hay datos)";
		}
		else {
			while (aux != null) {
				cadena = cadena + aux.getNum() + " ";
				aux = aux.getAnt();
			}
		}
		return cadena;
	}

}
