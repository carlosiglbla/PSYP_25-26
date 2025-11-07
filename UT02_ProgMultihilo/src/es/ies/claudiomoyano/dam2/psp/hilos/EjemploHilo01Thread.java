package es.ies.claudiomoyano.dam2.psp.hilos;

public class EjemploHilo01Thread extends Thread {
	
	private String nombre;
	
	public EjemploHilo01Thread(String nombre) {
		this.nombre = nombre;
	}
	
	public void run() {
		for(int i = 0; i<100; i++) {
			System.out.println("Estoy en el run y soy: "+nombre);
		}
	}

}
