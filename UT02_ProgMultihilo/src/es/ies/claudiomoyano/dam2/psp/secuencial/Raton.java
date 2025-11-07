package es.ies.claudiomoyano.dam2.psp.secuencial;

/**
 * Clase Ratón para ver el funcionamiento de una ejecución secuencial.
 */
public class Raton {
	private String nombre;
	private int tiempoAlimentacion;
	
	public Raton(String nombre, int tiempoAlimentacion) {
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
	
	public static void main(String[] args) {
		// Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

		Raton perez = new Raton("Perez", 4);
		Raton kitty = new Raton("Kitty", 8);
		Raton mickye = new Raton("Mickey", 2);
		Raton teo = new Raton("Teo", 1);
		perez.comer();
		kitty.comer();
		mickye.comer();
		teo.comer();
		
		//Imprimir el tiempo total
		//Imprimir tiempo total
		System.out.println("Tiempo final de la ejecución secuencial: "+
				(System.currentTimeMillis()-initialTime));
		
	}

}
