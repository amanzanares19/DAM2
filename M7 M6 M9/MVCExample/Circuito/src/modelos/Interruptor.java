package modelos;

public class Interruptor {

	private Bombilla bomb;

	public Interruptor() {
		this.bomb = new Bombilla();
	}
	public Bombilla getBomb() {
		return bomb;
	}

	public void setBomb(Bombilla bomb) {
		this.bomb = bomb;
	}
	
	public void apretarInt() {
		
		if (bomb.isEncendido()) {
			System.out.println("La bombilla está apagada");
			bomb.setEncendido(false);
		} else {
			System.out.println("La bombilla está encendida");
			bomb.setEncendido(true);
		}
		
	}
	
}
