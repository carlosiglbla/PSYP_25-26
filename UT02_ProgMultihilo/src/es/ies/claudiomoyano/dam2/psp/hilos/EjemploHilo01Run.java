package es.ies.claudiomoyano.dam2.psp.hilos;

public class EjemploHilo01Run implements Runnable {

	private int x;
	private String nombre;

	public EjemploHilo01Run(int x, String nom) {
		this.x = x;
		this.nombre = nom;
	}

	public void run() {
		for (int i = 0; i < x; i++)
			System.out.printf("Hola desde el hilo %s... itera:%d%n",nombre,i);
	}
}
