package es.ies.claudiomoyano.dam2.psp.concurrente;

/**
 * Clase Ratón para ver el funcionamiento de una ejecución concurrente.
 */
public class RatonSimpleRunnable implements Runnable{
	private String nombre;
	private int tiempoAlimentacion;
	private int alimentoConsumido;
	
	public RatonSimpleRunnable(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}

	public void comer() {
		try {
			System.out.printf("El ratón %s, ha comenzado a alimentarse%n", nombre);
			Thread.sleep(tiempoAlimentacion*1000);
			alimentoConsumido++;
			System.out.printf("El ratón %s ha terminado de alimentarse y lleva %d%n", 
					nombre, alimentoConsumido);
			System.out.println();
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
        
		RatonSimpleRunnable perez = new RatonSimpleRunnable("Perez", 4);
		RatonSimpleRunnable kitty = new RatonSimpleRunnable("Kitty", 8);
		RatonSimpleRunnable mickye = new RatonSimpleRunnable("Mickey", 2);
		RatonSimpleRunnable teo = new RatonSimpleRunnable("Teo", 1);
		new Thread(perez).start();
//		new Thread(kitty).start();
//		new Thread(mickye).start();
//		new Thread(teo).start();
		new Thread(perez).start();
		new Thread(perez).start();
		new Thread(perez).start();
		
		
		//Imprimir tiempo total
		System.out.println("Tiempo final de la ejecución concurrente: "+(System.currentTimeMillis()-initialTime));
	}

}
