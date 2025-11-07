package es.ies.claudiomoyano.dam2.psp.hilos.compartir;

public class HiloA2 extends Thread {
	private Contador contador;

	public HiloA2(String n, Contador c) {
		setName(n);
		contador = c;
	}

	public void run() {
		synchronized (contador) {
			for (int j = 0; j < 300; j++) {
				contador.incrementa();
			}
			System.out.println(getName() + " contador vale " + contador.getValor());
		}

	}

}
