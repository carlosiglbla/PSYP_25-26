/**
 * 
 */
package es.ies.claudiomoyano.dam2.psyp.ejemplosJava;

import java.io.File;
import java.io.IOException;

/**
 */
public class Ejemplo08_02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("CMD");	
		
		File fBat = new File(".\\src\\main\\resources\\fichero.bat");
	    File fOut = new File("salida.txt");
	    File fErr = new File("error.txt");
	    
		pb.redirectInput(ProcessBuilder.Redirect.from(fBat));
		pb.redirectOutput(ProcessBuilder.Redirect.to(fOut));
		pb.redirectError(ProcessBuilder.Redirect.to(fErr)); 
		    
		try {
			pb.start();
		} catch (IOException e) {
			System.out.println("IOException: error: "+e.getMessage());	
		}
	}

}
