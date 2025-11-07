package es.ies.claudiomoyano.dam2.psp.concurrente;

/**
 * Clase Ratón para ver el funcionamiento de una ejecución concurrente.
 */
public class Raton extends Thread{
	private String nombre;
	private int tiempoAlimentacion;
	
	public Raton(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
		setName(nombre);
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
        
		Raton perez = new Raton("Perez", 4);
		Raton kitty = new Raton("Kitty", 8);
		Raton mickye = new Raton("Mickey", 2);
		Raton teo = new Raton("Teo", 1);
		perez.start();
		kitty.start();
		mickye.start();
		teo.start();
		
		//Imprimir tiempo total
		System.out.println("Tiempo final de la ejecución concurrente: "+(System.currentTimeMillis()-initialTime));
	}

}
