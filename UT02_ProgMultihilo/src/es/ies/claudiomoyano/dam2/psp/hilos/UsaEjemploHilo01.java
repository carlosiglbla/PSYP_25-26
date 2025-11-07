package es.ies.claudiomoyano.dam2.psp.hilos;

public class UsaEjemploHilo01 {

	public static void main(String args[]) {
		EjemploHilo01Thread thread = new EjemploHilo01Thread("Carlos");
		thread.start();
	}// main

}