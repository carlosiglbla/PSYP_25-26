package es.ies.claudiomoyano.dam2.psp.hilos;

public class EjemploHilo06Interrup extends Thread {
	public void run() {
		try {
			while (!isInterrupted()) {
				System.out.println("En el Hilo");
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			System.out.println("HA OCURRIDO UNA EXCEPCIÓN: "+e.getMessage());
		}

		System.out.println("FIN HILO");
	}// run

	public void interrumpir() {
		interrupt();
	}// interrumpir

	public static void main(String[] args) {
		EjemploHilo06Interrup h = new EjemploHilo06Interrup();
		h.start();
		for (int i = 0; i < 2000000000; i++)
			;// no hago nada
		h.interrumpir();
	}//
}//
