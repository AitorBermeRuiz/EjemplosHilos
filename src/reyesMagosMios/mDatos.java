
package reyesMagosMios;

import java.util.logging.Level;
import java.util.logging.Logger;


public class mDatos {
    private int rangoMinimoRey, rangoMaximoRey,colaNiños,reyesLibres = 3,niñosAtendidos;
    private boolean reyLibre = true;
    public mDatos(int rangoMinimoRey, int rangoMaximoRey) {
        this.rangoMinimoRey = rangoMinimoRey;
        this.rangoMaximoRey = rangoMaximoRey;
    }

    public int getRangoMinimoRey() {
        return rangoMinimoRey;
    }

    public int getRangoMaximoRey() {
        return rangoMaximoRey;
    }

    public synchronized void setReyesLibres(int reyesLibres) {
        this.reyesLibres += reyesLibres;
    }
    
    public synchronized boolean isReyLibre() {
        if (reyesLibres>0)
            reyLibre=true;
        else
            reyLibre=false;
        return reyLibre;
    }
    
    public synchronized void manejoDeNiños(boolean hiloContinua){
        if(hiloContinua){
            //int tiempoEsperaNuevoNiño =(int) (Math.random() * (rangoMaximoRey-rangoMinimoRey+1) + rangoMinimoRey);
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(mDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            if(colaNiños>0)
                notify();
            
        }
        
    }


    public int getColaNiños() {
        return colaNiños;
    }

    public void setColaNiños(String sumarRestar) {
        if(sumarRestar.equals("+"))
            ++colaNiños;
        else
            --colaNiños;
    }
    

    public int getNiñosAtendidos() {
        return niñosAtendidos;
    }

    public synchronized void setNiñosAtendidos() {
        this.niñosAtendidos++;
    }
    
    
}
