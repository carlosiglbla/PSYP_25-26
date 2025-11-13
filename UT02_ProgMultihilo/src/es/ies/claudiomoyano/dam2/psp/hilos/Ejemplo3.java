package es.ies.claudiomoyano.dam2.psp.hilos;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Ejemplo3 {

	public static void main(String[] args) {
		// Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        
		List<HiloEjemplo3> escritores = new ArrayList<HiloEjemplo3>();
		escritores.add(new HiloEjemplo3(8, "Luis"));
		escritores.add(new HiloEjemplo3(5, "Juan"));
		escritores.add(new HiloEjemplo3(10, "Gloria"));
		escritores.add(new HiloEjemplo3(9, "Maria"));
		escritores.add(new HiloEjemplo3(7, "Alex"));

		for (HiloEjemplo3 escritor : escritores) {
			escritor.start();
		}

		// Tiempo final de referencia
        long finalTime = System.currentTimeMillis();
		System.out.println("Tiempo final: "+(finalTime-initialTime)); 
	}
}