package controller;

import java.util.concurrent.Semaphore;

public class cozinheiro extends Thread {
	private int sopa;
	private int lasanha;
	private int entrega;
	private int temp;
	private int idPrato;
	private Semaphore semaforo;
	int Sopa = 0;
	 int Lasanha = 0;

	
	
	public cozinheiro (int idPrato, Semaphore semaforo) {
		
		this.idPrato = idPrato;
		this.semaforo = semaforo;
		
	}

	public void run() {
		
		cozinhando();
		try {
			  p();;
			semaforo.acquire();
		}catch(InterruptedException e) {
			e.printStackTrace();
			
		}finally {
			pronto();
			semaforo.release();
		}	
	}

	
	public void cozinhando(){
		
		this.sopa = alearorio(500, 800);
		 this.lasanha = alearorio(600, 1201);
				
		if (idPrato % 2 != 0) {
			System.out.println(" O prato Sopa de Cebola " +idPrato + " está sendo prepararado no momento");
			} else {
				System.out.println(" O prato Lasanha Bolonhesa " +idPrato + " está sendo prepararado no momento ");
			}
	}
	
  public void pronto() {
	  this.entrega = alearorio(000, 500);
	  
		  try {
				Thread.sleep(this.entrega);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		  
		  if (idPrato % 2 != 0) {  
			System.out.println("A sopa " +idPrato + " foi entregue");
		  }
		  else { 
			  System.out.println("A lasanha " +idPrato +" foi entregue");
		  }
		  }
  

	  
  public void  p() {
	  
	 int somaLasanha = 0;
	  int somaSopa = 0;
	  
	  this.temp = alearorio(000, 100);
	  
	  while (Sopa < 100 && Lasanha < 100) {
	  
	  try {
			Thread.sleep(this.temp);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	 
	  if(idPrato % 2 != 0 ) {

		  
		 somaSopa = somaSopa + this.sopa;
		 
		  Sopa = somaSopa / 100;

		 System.out.println("Percentual da sopa " +idPrato + " = " +Sopa +"%"); 
	  
	  } else {
		 
		  somaLasanha = somaLasanha + this.lasanha;
		 Lasanha = somaLasanha / 100;
		 System.out.println("Percentual da lasanha " +idPrato + " = " +Lasanha +"%");
  }
	  }
	  
	  
	  if(idPrato %2 != 0) {
		  
		  try {
				Thread.sleep(this.sopa);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		  
		System.out.println("A sopa " +idPrato + " está pronta para a entrega depois de " +this.sopa);
		
		
	  }else {
		  
		  try {
				Thread.sleep(this.lasanha);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		  
		System.out.println("A lasanha " +idPrato + " está pronta para a entrega depois de " +this.lasanha);
	  }
	  }
  
	
	public int alearorio(int min, int max) {
		int aleatorio = min + (int)(Math.random() * (max - min));
		return aleatorio;
		
	}
}
