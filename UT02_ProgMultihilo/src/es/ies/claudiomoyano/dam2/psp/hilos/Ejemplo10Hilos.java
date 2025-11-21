package es.ies.claudiomoyano.dam2.psp.hilos;

import java.util.concurrent.Semaphore;

public class Ejemplo10Hilos extends Thread {

	private int tiempoNecesitado;
	private static Semaphore semaforo;
	int id;

	public Ejemplo10Hilos(int id) {
		this.tiempoNecesitado = (int) (Math.random() * 2000 + 1000);
		this.id = id;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			usarProbador();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		semaforo.release();
	}

	private void usarProbador() {
		System.out.println("Soy el cliente " + id + " y voy a usar un probador.");
		try {
			sleep(tiempoNecesitado);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Soy el cliente " + id + " y salgo del probador.");
	}

	public static void setSemaforo(Semaphore semaforo) {
		Ejemplo10Hilos.semaforo = semaforo;
	}
}
