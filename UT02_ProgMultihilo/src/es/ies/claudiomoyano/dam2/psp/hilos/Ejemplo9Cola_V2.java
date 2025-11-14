package es.ies.claudiomoyano.dam2.psp.hilos;

public class Ejemplo9Cola_V2 {
	private int numero;
	private boolean disponible = false;

	public synchronized int get() {
		while (!disponible) {
			try {
				wait();
			} catch (InterruptedException ex) {
				System.out.println("Interrupción.");
			}
		}

		disponible = false;
		notify();
        System.out.println(" Consumidor :" + numero + " consume: " + numero);
		return numero;
	}
	public synchronized void put(int valor) {
		while (disponible) {
			try {
				wait();
			} catch (InterruptedException ex) {
				System.out.println("Interrupción.");
			}
		}
		numero = valor;
		disponible = true;
		System.out.println("EL productor : produce: " + valor);

		notify();
	}

}
