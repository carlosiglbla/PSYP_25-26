/**
 * 
 */
package es.ies.claudiomoyano.dam2.psyp.ejemplosJava;

import java.io.IOException;

/**
 * Redireccionando la entrada y la salida
 * Redirect.INHERIT
 * El ejemplo mostrar� la salida del comando DIR por consola
 *
 */
public class Ejemplo09 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");

		//la salida a consola
		pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);	    
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	
	}

}
