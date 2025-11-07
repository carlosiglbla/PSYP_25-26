package es.ies.claudiomoyano.dam2.psp.hilos.compartir;

public class HiloB2 extends Thread {
	private Contador contador;

	public HiloB2(String n, Contador c) {
		setName(n);
		contador = c;
	}

	public void run() {
		synchronized (contador) {
			for (int j = 0; j < 300; j++) {
				contador.decrementa();
			}
			System.out.println(getName() + " contador vale " + contador.getValor());
		}
	}

}
