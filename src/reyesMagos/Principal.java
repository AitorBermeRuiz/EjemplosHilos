package reyesMagos;

import java.util.ArrayList;

/* Evitar aglomeraciones
 * 
 * Se pide al usuario:
 * - Tiempo min y max para que se a�ada un HiloNinio a la cola
 * - Tiempo min y max que tarda un HiloRey en estar con un HiloNinio
 * 
 * Hay 3 HiloRey, cada vez que hay uno libre se le asigna un HiloNinio, estar� con el unt tiempo aleatorio entre en min y el max,
 * si no hay HiloRey libre esperan a la cola.
 * 
 * Cuando un HiloNinio termina con un HiloRey se guarda en Datos el tiempo que ha estado en la cola y el tiempo que ha tardado con
 * el HiloRey
 * 
 * Cada ve que llega un HiloNinio a la cola se imprime por pantalla (n� de HilosNinio en la cola y n� de HilosNinio atendidos)
 * 
 * El prgrama termina si hay 20 HilosNinio esperando o m�s || se han procesado ya 100 HilosNinio
 */

public class Principal {

	public static void main(String[] args) {
		int tiempoMinHilo = 80, tiempoMaxHilo = 100, tiempoMinRey = 450, tiempoMaxRey = 500;
		Datos datos = new Datos(tiempoMinRey, tiempoMaxRey);

		// vamos creando ni�os cada x tiempo, mientras no se cumpla la condici�n
		HiloNinio hiloNinio = new HiloNinio(datos);
		ArrayList<Thread> threadListaNinios = new ArrayList<>();
		while (datos.getNumHilosNinioEnLaCola()<=20 && datos.getNumHilosNinioAtendidos()<=100) {
			
			int tiempoCrearHilo = (int) (Math.random()*(tiempoMaxHilo-tiempoMinHilo) + tiempoMinHilo);
			try { Thread.sleep(tiempoCrearHilo);
			} catch (InterruptedException e) {e.printStackTrace();}
			
			threadListaNinios.add(new Thread(hiloNinio));
			threadListaNinios.get(threadListaNinios.size()-1).start();

			System.out.println("----------Atendidos: "+datos.getNumHilosNinioAtendidos());
			System.out.println("----------Cola: "+datos.getNumHilosNinioEnLaCola());
		}

		for (Thread threadNinio : threadListaNinios) {
			try {
				threadNinio.join();
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		

		System.out.println("---FIN---");
		System.out.println("----------Atendidos: "+datos.getNumHilosNinioAtendidos());
		System.out.println("----------Cola: "+datos.getNumHilosNinioEnLaCola());
	}
}














