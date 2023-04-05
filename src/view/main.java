package view;

import java.util.concurrent.Semaphore;

import controller.cozinheiro;

public class main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for (int idPrato = 1; idPrato < 6; idPrato++) {
			Thread Prato = new cozinheiro (idPrato, semaforo);
			Prato.start();
			
					}
		}

	}


