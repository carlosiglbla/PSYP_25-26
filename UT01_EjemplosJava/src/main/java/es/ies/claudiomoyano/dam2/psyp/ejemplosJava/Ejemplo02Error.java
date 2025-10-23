/**
 * 
 */
package es.ies.claudiomoyano.dam2.psyp.ejemplosJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author tirori
 *
 */
public class Ejemplo02Error {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Process p;
		try {
			p = new ProcessBuilder("CMD", "/C", "DIRR").start();
		
			InputStream is = p.getInputStream();

			//mostramos en pantalla caracter a caracter
			 int c;
			 while ((c = is.read()) != -1)
				System.out.print((char) c);
			 is.close();
			 
			// COMPROBACION DE ERROR - 0 bien - 1 mal
			int exitVal;
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);

			InputStream er = p.getErrorStream();					
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));
			String liner = null;
			while ((liner = brer.readLine()) != null) {
				System.out.println("ERROR >" + liner);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
