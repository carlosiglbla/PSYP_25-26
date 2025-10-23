package es.ies.claudiomoyano.dam2.psyp.ejemplosJava.auxiliar;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 */
public class EjemploLectura {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String texto;
		try {
			System.out.println("Introduce una cadena....");
			texto = br.readLine();
			System.out.println("Cadena escrita: " + texto);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}