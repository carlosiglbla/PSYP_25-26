package es.ies.claudiomoyano.dam2.psp.hilos;

public class Ejemplo9Consumidor extends Thread{
    private final Ejemplo9Cola cola;

    public Ejemplo9Consumidor(Ejemplo9Cola cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        int valor;
        for (int i = 0; i < 5; i++) {
            valor = cola.get();
            //No hemos puesto pausa, por tanto, el consumidor será más rápido que el productor.
        }
    }
}
