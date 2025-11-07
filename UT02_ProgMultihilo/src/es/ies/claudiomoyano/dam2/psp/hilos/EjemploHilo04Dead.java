package es.ies.claudiomoyano.dam2.psp.hilos;


public class EjemploHilo04Dead extends Thread {
	// Variable para poder parar el hilo.
	private boolean stopHilo = false;
	/**
	 * Método para cambiar la variable y parar la ejecución.
	 */
	public void pararHilo() {
		stopHilo = true;
	}

	// metodo run
	public void run() {
		while (!stopHilo) {
			System.out.println("En el Hilo");
		}
	}

	public static void main(String[] args) {
		EjemploHilo04Dead h = new EjemploHilo04Dead();
		h.start();
		for (int i = 0; i < 1000000; i++)
			;// no hago nada
		h.pararHilo();

	}// main
}// fin clase hilo
