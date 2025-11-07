package es.ies.claudiomoyano.dam2.psp.hilos;

public class EjemploHilo05 extends Thread{
	
	boolean hiloDetenido = false , hiloFinalizado = false;

	@Override
	public void run() {
		while(!hiloFinalizado) {
			if(hiloDetenido)
				System.out.println("Estoy detenido");
			else
				System.out.println("Hilo en ejecución");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void matarHilo() {
		hiloFinalizado = true;
	}
	
	public void pararHilo() {
		hiloDetenido = true;
	}
	
	public void reanudarHilo() {
		hiloDetenido = false;
	}
}
