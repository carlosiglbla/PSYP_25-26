package es.ies.claudiomoyano.dam2.psp.hilos;

public class Ejemplo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        HiloEjemplo8 hilo1 = new HiloEjemplo8("PING\t");
        HiloEjemplo8 hilo2 = new HiloEjemplo8("PONG\n");
        hilo2.start();
        hilo1.start();
	}
}