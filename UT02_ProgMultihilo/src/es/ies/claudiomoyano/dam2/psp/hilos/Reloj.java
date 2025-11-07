package es.ies.claudiomoyano.dam2.psp.hilos;

public class Reloj extends Thread{
	
	private boolean parar = false;
	public Reloj(String nom) {
		setName(nom);
	}
	public void run() {
		while(!parar) {
			try {
				System.out.println(getName());
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void parar() {
		this.parar = true;
	}
}
