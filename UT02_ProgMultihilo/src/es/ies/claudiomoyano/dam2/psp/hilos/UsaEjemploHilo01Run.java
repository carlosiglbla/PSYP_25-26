package es.ies.claudiomoyano.dam2.psp.hilos;
public class UsaEjemploHilo01Run {

	public static void main(String args[]) {
		EjemploHilo01Run p1 = new EjemploHilo01Run(100, "Carlos"); // Crea un nuevo hilo de ejecución
		EjemploHilo01Run p2 = new EjemploHilo01Run(500, "Manolo"); // Crea un nuevo hilo de ejecución
		EjemploHilo01Run p3 = new EjemploHilo01Run(200, "Juan"); // Crea un nuevo hilo de ejecución
		new Thread(p1).start(); // Arranca el nuevo hilo de ejecuci�n. Ejecuta run
		new Thread(p3).start(); 
		new Thread(p2).start(); 
		System.out.println("Hola desde el hilo principal!");
		System.out.println("Proceso acabando.");
		for(int i = 0; i<100;i++) {
			System.out.println("Estoy en el main");
		}
	}

}
