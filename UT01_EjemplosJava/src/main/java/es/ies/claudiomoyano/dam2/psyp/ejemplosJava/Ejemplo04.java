/**
 * 
 */
package es.ies.claudiomoyano.dam2.psyp.ejemplosJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 */
public class Ejemplo04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Process p;
		try {
			p = new ProcessBuilder("CMD", "/C", "DATE").start();
			// escritura -- envia entrada a DATE
			OutputStream os = p.getOutputStream();
			os.write("01-12-25".getBytes());
			os.flush(); // vac�a el buffer de salida

			// lectura -- obtiene la salida de DATE
			InputStream is = p.getInputStream();		
			 int c;
			 while ((c = is.read()) != -1)
				System.out.print((char) c);
			 is.close();
			 
			// COMPROBACION DE ERROR - 0 bien - 1 mal
			int exitVal;
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
			if(exitVal==1) {
				InputStream er = p.getErrorStream();					
				BufferedReader brer = new BufferedReader(new InputStreamReader(er));
				String liner = null;
				while ((liner = brer.readLine()) != null) {
					System.out.println("ERROR >" + liner);
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
