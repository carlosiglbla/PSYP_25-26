/**
 * 
 */
package es.ies.claudiomoyano.dam2.psyp.ejemplosJava;

import java.io.File;
import java.io.InputStream;

/**
 *
 */
public class Ejemplo03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//creamos objeto File al directorio donde esta Ejemplo02
		File directorio = new File(".\\bin");
		
		//El proceso a ejecutar es Ejemplo2			
		ProcessBuilder pb = new ProcessBuilder("java", "es.ies.claudiomoyano.dam2.psyp.ejemplosJava.Ejemplo02");

	    //se establece el directorio donde se encuentra el ejecutable
	    pb.directory(directorio);
	        
		System.out.printf("Directorio de trabajo: %s%n",pb.directory());

		try {
			//se ejecuta el proceso
			Process p = pb.start();
		
			//obtener la salida devuelta por el proceso
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1)
				System.out.print((char) c);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
