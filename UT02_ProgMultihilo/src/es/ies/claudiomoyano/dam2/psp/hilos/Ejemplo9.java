package es.ies.claudiomoyano.dam2.psp.hilos;

public class Ejemplo9 {

	public static void main(String[] args) {
		Ejemplo9Cola cola = new Ejemplo9Cola();
        
        Ejemplo9Productor productor = new Ejemplo9Productor(cola);
        Ejemplo9Consumidor consumidor = new Ejemplo9Consumidor(cola);
        
        productor.start();
        consumidor.start();
	}
}
