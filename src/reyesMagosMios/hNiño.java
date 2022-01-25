package reyesMagosMios;

import java.util.logging.Level;
import java.util.logging.Logger;

public class hNiño implements Runnable{
    mDatos datos;

    public hNiño(mDatos datos) {
        this.datos = datos;
    }
    
    @Override
    public void run() {
        boolean hiloContinua = true;
        while (hiloContinua) {            
            if(datos.isReyLibre()){
                hiloContinua = false;
                int tiempoEsperaNuevoNiño =(int) (Math.random() * (datos.getRangoMaximoRey()-datos.getRangoMinimoRey()+1) + datos.getRangoMinimoRey());
                datos.setReyesLibres(-1);
                try {
                    Thread.sleep(tiempoEsperaNuevoNiño);
                } catch (InterruptedException ex) {
                    Logger.getLogger(hNiño.class.getName()).log(Level.SEVERE, null, ex);
                }
                datos.setReyesLibres(1);
                datos.manejoDeNiños(hiloContinua);
                System.out.println("-->REY LIBRE");
                datos.setNiñosAtendidos();
            } else{
                System.out.println("-->REY OCUPADO");
                datos.setColaNiños("+");
                datos.manejoDeNiños(hiloContinua);
                    datos.setColaNiños("-");

            }

        }
    }
}
