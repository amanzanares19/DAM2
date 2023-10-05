package controlador;

import java.util.Scanner;

import modelos.Interruptor;

public class Circuito {
	
	private Interruptor interruptor1;
	private Interruptor interruptor2;

	public Circuito() {
		this.interruptor1 = new Interruptor();
		this.interruptor2 = new Interruptor();
	}

	public void init() {
		
		boolean acabado = false;
		Scanner sc = new Scanner(System.in);
		int option;
		
		while (!acabado) {
			
			System.out.println("1- Modificar interruptor 1"
					+ "\n2- Modificar interruptor 2"
					+ "\n0- Salir");
			
			option = sc.nextInt();
			
			if (option == 1) {
				
				this.modificarInterruptor(interruptor1, sc);
				
			} else if (option == 2) {
				
				this.modificarInterruptor(interruptor2, sc);
				
			} else if (option != 0) {
				System.out.println("Número incorrecto");
			} else {
				acabado = true;
			}
			
		}
		
	}
	
	private void modificarInterruptor(Interruptor interr, Scanner sc) {
		System.out.println("1- Apretar interruptor" + "\n0- Salir a selección de interruptores");
		int option = sc.nextInt();
		if (option == 1) {
			//Encender o apagar interruptores
			interr.apretarInt();
		}
	}
	
	public Interruptor getInterruptor1() {
		return interruptor1;
	}
	public void setInterruptor1(Interruptor interruptor1) {
		this.interruptor1 = interruptor1;
	}
	
	public Interruptor getInterruptor2() {
		return interruptor2;
	}
	public void setInterruptor2(Interruptor interruptor2) {
		this.interruptor2 = interruptor2;
	}
	
}
