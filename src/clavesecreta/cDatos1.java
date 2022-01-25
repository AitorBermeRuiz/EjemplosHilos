package clavesecreta;

import java.util.ArrayList;

public class cDatos1 {
    private String[] caracter;
    private String contraseña;
    boolean contraseñaEncontrada = false,contraseñaYaAnalizada = false;
    ArrayList<String> contraseñasAnalizadas = new ArrayList<>();
    public String[] getCaracter() {
        return caracter;
    }

    public void setCaracter(String[] caracter) {
        this.caracter = caracter;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public synchronized boolean getContraseñaEncontrada() {
        return contraseñaEncontrada;
    }

    public void setContraseñaEncontrada(boolean contraseñaEncontrada) {
        this.contraseñaEncontrada = contraseñaEncontrada;
    }

}
