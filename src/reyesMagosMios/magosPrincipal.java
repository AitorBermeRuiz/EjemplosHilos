package reyesMagosMios;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class magosPrincipal {
    public static void main(String[] args) {
        int rangoMinimoHilo = 80,rangoMaximoHilo = 100,rangoMinimoRey = 300,rangoMaximoRey = 320;
        mDatos datos = new mDatos(rangoMinimoRey,rangoMaximoRey);

        hNiño h = new hNiño(datos);
        ArrayList<Thread> hilosNiños = new ArrayList<>();
        
        while ((datos.getNiñosAtendidos()<=100)&&(datos.getColaNiños()<=20)) {    

            hilosNiños.add(new Thread(h));
            hilosNiños.get(hilosNiños.size()-1).start();
            int tiempoEsperaNuevoNiño =(int) (Math.random() * (rangoMaximoHilo-rangoMinimoHilo+1) + rangoMinimoHilo);
            try {
                Thread.sleep(tiempoEsperaNuevoNiño);
            } catch (InterruptedException ex) {
                Logger.getLogger(magosPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Atendidos: "+datos.getNiñosAtendidos());
            System.out.println("Cola: "+datos.getColaNiños());
        }
        for(Thread aux:hilosNiños){
            try {
                aux.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(magosPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Atendidos: "+datos.getNiñosAtendidos());
        System.out.println("Cola: "+datos.getColaNiños());
    }
}
