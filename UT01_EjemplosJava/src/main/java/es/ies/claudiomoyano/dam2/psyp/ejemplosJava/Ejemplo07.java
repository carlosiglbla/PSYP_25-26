/**
 * 
 */
package es.ies.claudiomoyano.dam2.psyp.ejemplosJava;

import java.io.File;
import java.io.IOException;

/**
 * Redireccionando la entrada y la salida.
 * redirectOutput() y redirectError() redirigen la salida est�ndar y de error a un fichero.
 * El ejemplo ejecuta DIR y env�a la salida a un fichero. 
 * Si hay error, env�a la salida a un fichero de error.
 */
public class Ejemplo07 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    ProcessBuilder pb = new ProcessBuilder("CMD","/C" ,"DIR");
	    
	    File fOut = new File("salida.txt");
	    File fErr = new File("error.txt");
	 
	    pb.redirectOutput(fOut);
	    pb.redirectError(fErr); 
	    try {
			pb.start();
		} catch (IOException e) {
			System.out.println("IOException: error: "+e.getMessage());
		} 
	}

}
