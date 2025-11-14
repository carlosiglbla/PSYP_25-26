package es.ies.claudiomoyano.dam2.psp.hilos;

import java.lang.Thread.State;
import java.util.HashSet;
import java.util.Set;

public class Ejemplo4 {

	public static void main(String[] args) {
		HiloEjemplo3 escritor = new HiloEjemplo3(8,"Carlos");
		Set<Thread.State> estados = new HashSet<Thread.State>();
		
		estados.add(escritor.getState());
		
		escritor.start();
		while(escritor.getState()!= Thread.State.TERMINATED) {
			estados.add(escritor.getState());
		}
		
		estados.add(escritor.getState());
		System.out.println("Los estados son: ");
		for (State state : estados) {
			System.out.println(state);
		}
		
	}

}
