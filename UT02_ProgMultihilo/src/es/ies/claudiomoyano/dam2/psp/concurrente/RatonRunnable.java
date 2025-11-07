package es.ies.claudiomoyano.dam2.psp.concurrente;

/**
 * Clase Ratón para ver el funcionamiento de una ejecución concurrente.
 */
public class RatonRunnable implements Runnable{
	private String nombre;
	private int tiempoAlimentacion;
	
	public RatonRunnable(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}

	public void comer() {
		try {
			System.out.printf("El ratón %s, ha comenzado a alimentarse%n", nombre);
			Thread.sleep(tiempoAlimentacion*1000);
			System.out.printf("El ratón %s ha terminado de alimentarse%n", nombre);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.comer();
	}
	
	public static void main(String[] args) {
		// Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        
		RatonRunnable perez = new RatonRunnable("Perez", 4);
		RatonRunnable kitty = new RatonRunnable("Kitty", 8);
		RatonRunnable mickye = new RatonRunnable("Mickey", 2);
		RatonRunnable teo = new RatonRunnable("Teo", 1);
		new Thread(perez).start();
		new Thread(kitty).start();
		new Thread(mickye).start();
		new Thread(teo).start();
		
		//Imprimir tiempo total
		System.out.println("Tiempo final de la ejecución concurrente: "+(System.currentTimeMillis()-initialTime));
	}

}
