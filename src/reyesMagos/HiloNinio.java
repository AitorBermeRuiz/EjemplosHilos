package reyesMagos;

public class HiloNinio implements Runnable {
	private Datos datos;
	
	public HiloNinio(Datos datos) {
		super();
		this.datos = datos;
	}

	@Override
	public void run() {
		
		System.out.print("Hilo Ninio");
		
		boolean volverEjecutarHiloNinio = true;
		while(volverEjecutarHiloNinio){
			if(datos.getReyLibre()) {
				try {
					System.out.println(" -> rey LIBRE");
					datos.setNumHilosRey(-1);
					datos.setNumHilosNinioAtendidos(1);;
					volverEjecutarHiloNinio = false;
					int tiempoDeProceso = (int) (Math.random()*(datos.getTiempoMaxRey()-datos.getTiempoMinRey()) + datos.getTiempoMinRey());
					Thread.sleep(tiempoDeProceso);
					datos.setNumHilosRey(1);
					datos.llamarEsperar(volverEjecutarHiloNinio);
				} catch (InterruptedException e) {e.printStackTrace();}
			}else {
				System.out.println(" -> rey OCUPADO");
				datos.llamarEsperar(volverEjecutarHiloNinio);
			}
		}
				
		
	}

}










