package reyesMagos;

public class Datos {
	private int tiempoMinRey, tiempoMaxRey, numHilosRey = 3;
	private int tiempoTotalEnLaCola = 0, tiempoTotalAtendidoRey = 0, numHilosNinioAtendidos = 0, numHilosNinioEnLaCola = 0;
	private boolean reyLibre=true;
	
	public Datos(int tiempoMinRey, int tiempoMaxRey) {
		this.tiempoMinRey  = tiempoMinRey;
		this.tiempoMaxRey  = tiempoMaxRey;
	}

	public synchronized void llamarEsperar(boolean volverEjecutarHiloNinio) {
		try {
			if(volverEjecutarHiloNinio) {
				++numHilosNinioEnLaCola;
				wait();
				--numHilosNinioEnLaCola;
			}else {
				notify();
			}
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	public synchronized boolean getReyLibre() {
		if(numHilosRey<=0) reyLibre = false;
		else reyLibre = true;
		
		return reyLibre;
	}
	
	// cada vez que un hilo ni�o pasa con un rey se resta una disponibilidad o se a�ade
	public void setNumHilosRey(int i) {
		this.numHilosRey += i;
	}
	
	public int getNumHilosRey() {
		return numHilosRey;
	}
	
	public int getTiempoTotalEnLaCola() {
		return tiempoTotalEnLaCola;
	}

	public void setTiempoTotalEnLaCola(int tiempoTotalEnLaCola) {
		this.tiempoTotalEnLaCola += tiempoTotalEnLaCola;
	}

	public int getTiempoTotalAtendidoRey() {
		return tiempoTotalAtendidoRey;
	}

	public void setTiempoTotalAtendidoRey(int tiempoTotalAtendidoRey) {
		this.tiempoTotalAtendidoRey += tiempoTotalAtendidoRey;
	}

	public int getNumHilosNinioAtendidos() {
		return numHilosNinioAtendidos;
	}

	public void setNumHilosNinioAtendidos(int numHilosNinioAtendidos) {
		this.numHilosNinioAtendidos += numHilosNinioAtendidos;
	}

	public int getNumHilosNinioEnLaCola() {
		return numHilosNinioEnLaCola;
	}

	public void setNumHilosNinioEnLaCola(int numHilosNinioEnLaCola) {
		this.numHilosNinioEnLaCola += numHilosNinioEnLaCola;
	}

	public int getTiempoMinRey() {
		return tiempoMinRey;
	}

	public int getTiempoMaxRey() {
		return tiempoMaxRey;
	}
	
}




















