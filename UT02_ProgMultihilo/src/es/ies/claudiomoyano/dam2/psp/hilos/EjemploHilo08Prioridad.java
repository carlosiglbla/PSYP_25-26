package es.ies.claudiomoyano.dam2.psp.hilos;

public class EjemploHilo08Prioridad extends Thread {
	private int c = 0;
	private boolean stopHilo = false;

	public EjemploHilo08Prioridad(String nombre) {
		super(nombre);
	}

	public int getContador() {
		return c;
	}

	public void pararHilo() {
		stopHilo = true;
	}

	public void run() {
		while (!stopHilo) {
			try {
				Thread.sleep(2);
			} catch (Exception e) {
			}
			c++;
		}
		System.out.println("Fin hilo  " + this.getName());

	}//
	
	public static void main(String args[]) {    
		EjemploHilo08Prioridad h1 = new EjemploHilo08Prioridad("Hilo1");
		EjemploHilo08Prioridad h2 = new EjemploHilo08Prioridad("Hilo2");
	    EjemploHilo08Prioridad h3 = new EjemploHilo08Prioridad("Hilo3");	
		  
		h1.setPriority(Thread.NORM_PRIORITY);
		h2.setPriority(Thread.MAX_PRIORITY);    
		h3.setPriority(Thread.MIN_PRIORITY);   
		
		h1.start();	
		h2.start();
	    h3.start();  	

	   try {
	      Thread.sleep(1000);
	    } catch (Exception e) { }


	    h1.pararHilo() ;
	    h2.pararHilo() ;
		h3.pararHilo() ;
		
	    System.out.println("h2 (Prioridad Maxima): " + h2.getContador());
		System.out.println("h1 (Prioridad Normal): " + h1.getContador());  	
		System.out.println("h3 (Prioridad Minima): " + h3.getContador());

	  }
}
