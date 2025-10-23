package es.ies.claudiomoyano.dam2.psyp.ejemplosJava;

import java.io.IOException;

/**
 * Creación de procesos con ProcessBuilder. *
 */
public class Ejemplo01 {

	/**
	 * Método main.
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder("NOTEPAD");
		try {
			Process process = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
