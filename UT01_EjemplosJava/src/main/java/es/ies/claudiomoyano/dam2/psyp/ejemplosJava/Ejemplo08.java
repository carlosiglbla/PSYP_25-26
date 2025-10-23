/**
 * 
 */
package es.ies.claudiomoyano.dam2.psyp.ejemplosJava;

import java.io.File;
import java.io.IOException;

/**
 * Redireccionando la entrada y la salida
 * redirectOutput(), redirectError() y redirectInput()
 * El ejemplo ejecuta varios comandos de MS-DOS que est�n ubicados en un fichero .bat.
 * Con redirectInput() le diremos que la entrada al proceso es desde fichero.
 * Es decir, la entrada al comando CMD es el fichero.bat
 * La salida ir� a ficheroSalida.txt
 * Los errores a ficheroError.txt
 *
 */
public class Ejemplo08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	    ProcessBuilder pb = new ProcessBuilder("CMD");
	    
	    
	    File ficheroBatEntrada = new File("./src/main/resources/fichero.bat");
//	    ClassLoader classLoader = Ejemplo08.class.getClassLoader();
//	    if(classLoader.getResource("fichero.bat")!=null) {
//	    	ficheroBatEntrada = new File(classLoader.getResource("fichero.bat").getFile());
//	    	System.out.println(ficheroBatEntrada.getAbsolutePath());
//	    }
	    File ficheroSalida = new File("salida.txt");
	    File ficheroError = new File("error.txt");
	 
	    pb.redirectInput(ficheroBatEntrada);
	    pb.redirectOutput(ficheroSalida);
	    pb.redirectError(ficheroError); 
	    try {
			pb.start();
		} catch (IOException e) {
			System.out.println("IOException: error: "+e.getMessage());	
		} 
	}

}
