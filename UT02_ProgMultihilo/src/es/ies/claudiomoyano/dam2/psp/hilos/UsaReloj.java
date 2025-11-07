package es.ies.claudiomoyano.dam2.psp.hilos;

public class UsaReloj {

	public static void main(String[] args) throws InterruptedException {
		Reloj tic = new Reloj("TIC");
		Reloj tac = new Reloj("TAC");
		tic.start();
		tac.start();
		Thread.sleep(5000);//espero 5 segundos
		
		tic.parar();
		tac.parar();

	}

}
