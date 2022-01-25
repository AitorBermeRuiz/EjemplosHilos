package puertas;

import java.util.logging.Level;
import java.util.logging.Logger;

public class cPrincipal {
    public static void main(String[] args) {
        int numHilos = 20,numPuertas=2;
        cDatos datos = new cDatos();
        datos.setNumPuertas(numPuertas);
        datos.setTotalHilosPorRonda(numHilos);
        
        cHilo h = new cHilo(datos);
        Thread[] hilo = new Thread[numHilos];
        for(int i=0;i<numHilos;++i){
            hilo[i] = new Thread(h);
            hilo[i].start();
        }
        for(int i=0;i<numHilos;++i){
            try {
                hilo[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(cPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
