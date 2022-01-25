package puertas;

import java.util.logging.Level;
import java.util.logging.Logger;

public class cDatos {
    private int numPuertas,puertaCorrecta,totalHilosPorRonda=0,hilosQuePasasan = 0,hiloNumeroX = 0,wHilosDurmiendo = 0,hilosMuertos = 0;
    private boolean wPuertaYaestablecida = false;

    /*public boolean getPuertaYaestablecida() {
        return puertaYaestablecida;
    }*/
    public synchronized int getPuertaCorrecta() {
        if (!wPuertaYaestablecida){
            this.puertaCorrecta=(int) (Math.random()*(numPuertas-1+1)+1);
            System.out.println("---PUERTA CORRECTA: "+this.puertaCorrecta);
            wPuertaYaestablecida=true;
        }
        return puertaCorrecta;
    }

    /*public synchronized void setPuertaCorrecta(int puertaCorrecta) {
        if(!puertaYaestablecida){
            this.puertaCorrecta = puertaCorrecta;
            puertaYaestablecida=true;
            System.out.println("---PUERTA CORRECTA: "+this.puertaCorrecta);
        }
    }*/

    public void setTotalHilosPorRonda(int totalHilosPorRonda) {
        this.totalHilosPorRonda = totalHilosPorRonda;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
    public synchronized void setHilosQuePasasan(int hilosQuePasasan) {
        this.hilosQuePasasan += hilosQuePasasan;
    }

    public synchronized int getHiloNumeroX() {
        this.hiloNumeroX+=1;
        //if(this.hiloNumeroX==this.totalHilosPorRonda+1)
            //hiloNumeroX=1;
        return hiloNumeroX;
    }
    public synchronized void dormir(boolean hiloDuerme){
        if(hiloDuerme)
            ++wHilosDurmiendo;
        int hilosSobrevividos = totalHilosPorRonda-hilosMuertos;
        if (wHilosDurmiendo==hilosSobrevividos){
            int porcentajeAciertos= (int) (100* hilosQuePasasan/ totalHilosPorRonda);
            System.out.println("Hilos que han acertado: "+hilosQuePasasan);
            System.out.println("Porcentaje"+porcentajeAciertos);
            System.out.println("======FIN DE RONDA======");
            restablecerVariables();
            notifyAll();
        }else{
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(cDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void restablecerVariables(){
        totalHilosPorRonda=hilosQuePasasan;
        hilosMuertos =0;
        wPuertaYaestablecida=false;
        hiloNumeroX = 0;
        wHilosDurmiendo = 0;
        hilosQuePasasan = 0;
    }


    public  synchronized void setHilosMuertos(int hilosMuertos) {
        this.hilosMuertos += hilosMuertos;
    }  
}
