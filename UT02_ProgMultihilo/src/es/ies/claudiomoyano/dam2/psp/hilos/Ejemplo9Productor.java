package es.ies.claudiomoyano.dam2.psp.hilos;

import java.util.ArrayList;

public class Ejemplo9Productor extends Thread {
	private final Ejemplo9Cola cola;

	public Ejemplo9Productor(Ejemplo9Cola cola) {
		this.cola = cola;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			cola.put(i);
			try {
				sleep(100);
			} catch (InterruptedException ex) {
				System.out.println("Interrupción.");
			}
		}
	}
}
