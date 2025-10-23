/**
 * 
 */
package es.ies.claudiomoyano.dam2.psyp.ejemplosJava;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 */
public class Ejemplo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		Process p = new ProcessBuilder("CMD", "/C", "DIR").start();
		try {

			InputStream is = p.getInputStream();
			//mostramos en pantalla caracter a caracter
			 int c;
			 while ((c = is.read()) != -1) {
				System.out.print((char) c);
			 }
			 is.close();

		
		} catch (Exception e) {
			e.printStackTrace();
		}

		// COMPROBACION DE ERROR - 0 bien - 1 mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			int exitValue = p.exitValue();
			System.out.println("Valor de Salida: " + exitVal);
			System.out.println("Valor de Salida: " + exitValue);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
