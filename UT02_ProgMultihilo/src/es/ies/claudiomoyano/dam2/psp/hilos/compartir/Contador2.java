package es.ies.claudiomoyano.dam2.psp.hilos.compartir;

public class Contador2 {
	private int c = 0;
	public Contador2(int c) {
		this.c = c;
	}

	public synchronized void incrementa() {
		c = c + 1;
	}

	public synchronized void decrementa() {
		c = c - 1;
	}

	public int getValor() {
		return c;
	}
}
