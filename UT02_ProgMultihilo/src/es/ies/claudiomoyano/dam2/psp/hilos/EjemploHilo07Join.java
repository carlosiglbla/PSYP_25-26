														/**
 * 
 */
package es.ies.claudiomoyano.dam2.psp.hilos;

/**
 * Clase EjemploHilo07 para ver el funcionamiento de Join.
 */
public class EjemploHilo07Join extends Thread {
	private int n;

	public EjemploHilo07Join(String nom, int n) {
		super(nom);
		this.n = n;
	}

	public void run() {
		for (int i = 1; i <= n; i++) {
			System.out.println(getName() + ": " + i);
			try {
				sleep(1000);
			} catch (InterruptedException ignore) {
			}
		}
		System.out.println("Fin Bucle " + getName());
	}

	public static void main(String[] args) {
		EjemploHilo07Join h1 = new EjemploHilo07Join("Hilo1", 2);
		EjemploHilo07Join h2 = new EjemploHilo07Join("Hilo2", 5);
		EjemploHilo07Join h3 = new EjemploHilo07Join("Hilo3", 7);

		h1.start();
		h2.start();
		h3.start();

		try {
			h1.join();
			h2.join();
			h3.join();
		} catch (InterruptedException e) {
		}

		System.out.println("FINAL DE PROGRAMA");
	}
}//

