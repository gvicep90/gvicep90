package clases;

public class Nodo {
	
	private int num;
	private Nodo sig;
	private Nodo ant;
	
	public Nodo (int n) {
		this.num = n;
		this.sig = null;
		this.ant = null;
	}
	
	public int getNum () {
		return this.num;
	}
	
	public Nodo getSig () {
		return this.sig;
	}
	
	public Nodo getAnt () {
		return this.ant;
	}
	
	public void setNum (int n) {
		this.num = n;
	}
	
	public void setSig (Nodo nodo) {
		this.sig = nodo;
	}
	
	public void setAnt (Nodo nodo) {
		this.ant = nodo;
	}

}
