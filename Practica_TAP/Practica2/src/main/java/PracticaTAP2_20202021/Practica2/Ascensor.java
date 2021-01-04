package PracticaTAP2_20202021.Practica2;

public class Ascensor {
	
	private int pisoActual;
	private boolean emergencia;
	private State current;
	
	public Ascensor() {
		this.pisoActual = 0;
		this.emergencia = false;
		this.current = new State_Parado_Cerrado();
	}

}
