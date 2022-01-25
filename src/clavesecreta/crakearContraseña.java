package clavesecreta;

public class crakearContraseña implements Runnable{
    cDatos1 datos;
    int caracterMinimo,caracterMaximo;

    public crakearContraseña(cDatos1 datos,int caracterMinimo,int caracterMaximo) {
        this.datos = datos;
        this.caracterMinimo=caracterMinimo;
        this.caracterMaximo = caracterMaximo;
    }    
    @Override
    public void run() {
        System.out.println(caracterMinimo+"  --  "+caracterMaximo);
        String intentoContraseña = "";
        boolean contraseñaEncontrada = false;
        String[] caracteres = datos.getCaracter();
        //int aux = (int) (Math.random()*(caracterMaximo-caracterMinimo+1)+caracterMinimo);
        //intentoContraseña+=caracteres[aux];
        for(int i = caracterMinimo;i<=caracterMaximo;++i){
            intentoContraseña+=caracteres[i];
            for(int x = 0;x<64;++x){
                for(int e = 0;e<64;++e){
                    for(int h = 0;h<64;++h){
                        if(datos.getContraseñaEncontrada()){
                           h=100;e=100;x=100;i=100; 
                        }else{
                            intentoContraseña =caracteres[i]+caracteres[x]+caracteres[e]+caracteres[h];
                            if (datos.getContraseña().equals(intentoContraseña)){
                                h=100;e=100;x=100;i=100;
                                contraseñaEncontrada=true;
                                datos.setContraseñaEncontrada(true);
                                System.out.println("=======Hilo "+Thread.currentThread()+" a encontrado la contraseña " +intentoContraseña+"=======");
                            }
                        }
                    }
                }
            }
        }
        if(!contraseñaEncontrada){
            System.out.println("Hilo "+Thread.currentThread()+" ha salido sin encontrar la contraseña");
        }
    }
}
