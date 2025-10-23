package es.ies.claudiomoyano.dam2.psyp.ejemplosJava;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * En el siguiente ejemplo vamos a usar m�todos de la clase ProcessBuilder 
 * environment()
 * command(): sin par�metros y con par�metros
 */
public class Ejemplo06 {
	/**bb�'  
	 * Método main.
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		ProcessBuilder test = new ProcessBuilder("java", "es.ies.claudiomoyano.dam2.psyp.ejemplosJava.auxiliar.LeerNombre", "Maria Jesus");		
		Map<String, String> entorno = test.environment();
		System.out.println("Variables de entorno:");
		System.out.println(entorno);	
		
		// devuelve el nombre del proceso y sus argumentos
		List<String> l = test.command();
		Iterator<String> iter = l.iterator();
		System.out.println("\nArgumentos del comando:");
		while (iter.hasNext())
			System.out.println(iter.next());

		// ejecutamos el comando DIR
		//test = test.command("CMD", "/C", "DIR");
		try {
			Process p = test.start();
			InputStream is = p.getInputStream();

			// mostramos en pantalla caracter a caracter
			 int c;
			 while ((c = is.read()) != -1)
				System.out.print((char) c);
			 is.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
