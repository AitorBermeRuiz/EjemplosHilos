
package puertas;

import java.util.logging.Level;
import java.util.logging.Logger;

public class cHilo implements Runnable{
    static cDatos datos;

    public cHilo(cDatos datos) {
        this.datos = datos;
    }
    @Override
    public void run() {
        boolean jugadorContinua = true;
        while (jugadorContinua) { 
            int identificador =datos.getHiloNumeroX();
            int puertaCorrecta = datos.getPuertaCorrecta();
            /*if (identificador==1){//0,Aleatorio *Rango maximo -Minimo+1 y resultado +minimo
                int puertaCorrecta =(int) (Math.random()*(datos.getNumPuertas()-1+1)+1);
                datos.setPuertaCorrecta(puertaCorrecta);
            }*/
            
            int puertaSeleccionada =(int) (Math.random()*(datos.getNumPuertas()-1+1)+1);
            System.out.println("-Puerta seleccionada por hilo "+identificador+": "+puertaSeleccionada);
            if (puertaSeleccionada==puertaCorrecta)
                datos.setHilosQuePasasan(1);
            else{
                jugadorContinua=false;
                datos.setHilosMuertos(1);
            }
            datos.dormir(jugadorContinua);
            //Intentaba hacer todo aqui pero al tener que hacer cosas tembien con los hilos que no habian acertado pues daba muchos problemas, al final la solucion es hecrlos todo en datos
            /*if(datos.getHilosDurmiendo()==datos.getTotalHilosPorRonda()){
                System.out.println("Hilos que han acertado: "+datos.getHilosQuePasasan());
                System.out.println("Porcentaje"+porcentajeAciertosPorRonda());
                System.out.println("======FIN DE RONDA======");
                datos.setTotalHilosPorRonda(datos.getHilosQuePasasan());
                
                datos.despertar();
            }
            else if(jugadorContinua){
                datos.setHilosDurmiendo(1);
                datos.dormir();   
            }*/
            
        }
    }    
}
