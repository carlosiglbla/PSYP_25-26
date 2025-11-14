package es.ies.claudiomoyano.dam2.psp.hilos;

public class Ejemplo9Cola {
    private int numero;
    private boolean disponible = false;
    
    public int get(){
        if(disponible){
            disponible = false;
            return numero;
        }
        return -1;//No hay número disponible, cola vacía.
    }
    
    public void put(int valor){
        numero = valor;
        disponible = true;
    }

}
