/**
 * 
 */
package es.ies.claudiomoyano.dam2.psyp.ejemplosJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 */
public class Ejemplo05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "es.ies.claudiomoyano.dam2.psyp.ejemplosJava.auxiliar.EjemploLectura");

		pb.directory(directorio);

		// se ejecuta el proceso
		Process p;
		try {
			p = pb.start();
		
			// escritura -- envia entrada 
			OutputStream os = p.getOutputStream();
			os.write("Hola caracola\n".getBytes());
			os.flush(); // vac�a el buffer de salida
	
			// lectura -- obtiene la salida
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1)
				System.out.print((char) c);
			is.close();
	
			// COMPROBACION DE ERROR - 0 bien - 1 mal
			int exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);

			InputStream er = p.getErrorStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));
			String liner = null;
			while ((liner = brer.readLine()) != null)
				System.out.println("ERROR >" + liner);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
