package View;
import java.util.concurrent.Semaphore;

import Controller.ControlaTrafego;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int permissoes=1;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int i=1;i<=4;i++) {
				Thread t = new ControlaTrafego(i, semaforo);
				t.start();
		}
	}

}
