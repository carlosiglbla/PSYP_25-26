package es.ies.claudiomoyano.dam2.psp.hilos;

public class HiloEjemplo8 extends Thread {

	String textoAImprimir;
	

	public HiloEjemplo8(String textoAImprimir) {
		this.textoAImprimir = textoAImprimir;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.print(textoAImprimir);
		}
	}
}
