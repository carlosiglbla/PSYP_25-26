package es.ies.claudiomoyano.dam2.psp.hilos;

public class EjemploHilo00Run implements Runnable{

	
	@Override
	public void run() {
		System.out.println("Estoy dentro del run...");
	}
	
	public static void main(String[] args) {
		EjemploHilo00Run runas = new EjemploHilo00Run();
		new Thread(runas).start();
		
	}


}
