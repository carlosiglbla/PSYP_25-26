package es.ies.claudiomoyano.dam2.psp.hilos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Ejemplo10 {

	final static int numeroDeProbadores = 5;
	final static int numeroDeClientes = 100;

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(numeroDeProbadores);
		
		List<Ejemplo10Hilos> clientes = new ArrayList<Ejemplo10Hilos>();
		for (int i = 0; i < numeroDeClientes; i++)
			clientes.add(new Ejemplo10Hilos(i + 1));

		Ejemplo10Hilos.setSemaforo(semaforo);

		for (Ejemplo10Hilos cliente : clientes)
			cliente.start();

		for (Ejemplo10Hilos cliente : clientes)
			try {
				cliente.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		System.out.println("TODOS LOS CLIENTES SE HAN PROBADO LA ROPA");
	}
}
