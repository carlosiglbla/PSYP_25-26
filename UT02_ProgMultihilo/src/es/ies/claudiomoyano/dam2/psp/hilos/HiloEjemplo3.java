package es.ies.claudiomoyano.dam2.psp.hilos;

public class HiloEjemplo3 extends Thread{

	private int tiempoEscritura;
	public HiloEjemplo3(int tiempoEscritura, String nombre) {
		super();
		setName(nombre);
		this.tiempoEscritura = tiempoEscritura;
	}
	
	public void run() {
		this.escribir();
	}

	private void escribir() {
		System.out.println(getName()+ " ha comenzado.");
		try {
			sleep(this.tiempoEscritura*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getName() + " ha finalizado.");
		
	}

}
