package es.ies.claudiomoyano.dam2.psp.hilos.compartir;

public class CompartirInformacion2 {
	public static void main(String[] args) {
		Contador cont = new Contador(100);
		HiloA2 a = new HiloA2("HiloA", cont);
		HiloB2 b = new HiloB2("HiloB", cont);
		a.start();		
		b.start();
		//si probamos primero el b y luego el a serán -200 y 100 
		//a.start();
		
	}
}
