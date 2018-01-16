package Controller;

import java.util.concurrent.Semaphore;

public class ControlaTrafego extends Thread {
	private int idCarro;
	private Semaphore semaforo;
	private static int sentido;
	
	public ControlaTrafego(int idCarro, Semaphore semaforo) {
		this.idCarro=idCarro;
		this.semaforo=semaforo;
	}
	
	public void run() {
		carroParado();
		try {
			semaforo.acquire();
			carroPassando();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			semaforo.release();
		}
	}
	
	
	private void carroParado(){
		System.out.println("Carro "+idCarro+" parou no cruzamento");
		//int tempoEspera = (int)(Math.random()*2501)+500;
//		try {					
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
	
	private void carroPassando(){
		sentido++;
		switch(sentido){
		case 1:
			System.out.println("Carro "+idCarro+" está passando para o sentido norte");
			break;
		case 2:
			System.out.println("Carro "+idCarro+" está passando para o sentido sul");
			break;
		case 3:
			System.out.println("Carro "+idCarro+" está passando para o sentido leste");
			break;
		case 4:
			System.out.println("Carro "+idCarro+" está passando para o sentido oeste");
			break;
		default:
			break;
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
