package es.ies.claudiomoyano.dam2.psp.hilos.compartir;

public class HiloB3 extends Thread {
		private Contador2 contador;
		public HiloB3(String n, Contador2 c) {
			setName(n);
			contador = c;
		}
		public void run() {
			for (int j = 0; j < 300; j++) {
				contador.decrementa();
//				try {
//					sleep(10);
//				} catch (InterruptedException e) {}
			}
			System.out.println(getName() + " contador vale " + contador.getValor());
		}
}
