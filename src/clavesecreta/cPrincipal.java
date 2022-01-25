package clavesecreta;

import java.util.logging.Level;
import java.util.logging.Logger;

public class cPrincipal {

    public static void main(String[] args) {
        creacionHilos();
    }

    private static void creacionHilos() {
        cDatos1 datos = new cDatos1();
        String todosLosCaracteres = "q,w,e,r,t,y,u,i,o,p,a,s,d,f,g,h,j,k,l,ñ,z,x,c,v,b,n,m";
        todosLosCaracteres += "," + todosLosCaracteres.toUpperCase() + ",1,2,3,4,5,6,7,8,9,0";
        String[] caracter = todosLosCaracteres.split(",");
        String contraseña = "";
        for (int i = 0; i < 4; ++i) {
            int aux = (int) (Math.random() * (63 - 0 + 1) + 0);
            contraseña += caracter[aux];
        }
        System.out.println(contraseña);
        datos.setCaracter(caracter);
        datos.setContraseña(contraseña);
        int numHilos = 10;
        int caracteresPorHilo = (int)(caracter.length-1)/numHilos;
        int caracterMinimo=0,caracterMaximo=0;
        
        Thread[] hilos = new Thread[numHilos];
        for (int i = 0; i < numHilos; ++i) {
            crakearContraseña h;
            if(i==(numHilos-1))
                h = new crakearContraseña(datos,caracterMinimo,caracter.length-1);
            else{
                caracterMaximo += caracteresPorHilo;
                h = new crakearContraseña(datos,caracterMinimo,caracterMaximo-1);
                caracterMinimo =caracterMaximo;
            }
            hilos[i] = new Thread(h);
            hilos[i].start();
        }

        for (int i = 0; i < numHilos; ++i) {
            try {
                hilos[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(cPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
