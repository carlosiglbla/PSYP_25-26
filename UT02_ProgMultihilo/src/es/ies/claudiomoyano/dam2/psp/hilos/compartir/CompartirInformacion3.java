package es.ies.claudiomoyano.dam2.psp.hilos.compartir;

public class CompartirInformacion3 {
	public static void main(String[] args) throws InterruptedException {
		
		// Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        
		Contador2 cont = new Contador2(100);
		HiloA3 a = new HiloA3("HiloA", cont);
		HiloB3 b = new HiloB3("HiloB", cont);
		a.start();		
		b.start();
		//si probamos primero el b y luego el a serán -200 y 100 
		//a.start();
		
		a.join();
		b.join();
		
		//Imprimir tiempo total
		System.out.println("Tiempo final: "+(System.currentTimeMillis()-initialTime));
		
	}
}
