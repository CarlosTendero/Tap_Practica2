package Clases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import Clases.Impl.State;

public class Ascensor implements Clases.Impl.AscensorImpl{

	//--------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------
	
	private int planta_actual;
	private ArrayList<Integer> destinos;
	private State ascensor_estado;
	private String puerta_estado;
	private boolean emergencia;

	//--------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------
	
	public Ascensor(int planta_actual, State ascensor_estado, String puerta_estado) {
		this.planta_actual = planta_actual;
		this.ascensor_estado = ascensor_estado;
		this.puerta_estado = puerta_estado;

		this.emergencia = false;
		this.destinos = new ArrayList<Integer>();

	}
	
	//--------------------------------------------------------------
	//Setters y getters
	//--------------------------------------------------------------
	
	public String getPuerta_estado() {
		return puerta_estado;
	}

	public void setPuerta_estado(String puerta_estado) {
		this.puerta_estado = puerta_estado;
	}

	public boolean isEmergencia() {
		return emergencia;
	}

	public void setEmergencia(boolean emergencia) {
		this.emergencia = emergencia;
	}

	public ArrayList<Integer> getDestinos() {
		return destinos;
	}

	public int getPlanta_actual() {
		return planta_actual;
	}

	public void setPlanta_actual(int planta_actual) {
		this.planta_actual = planta_actual;
	}

	public State getAscensor_estado() {
		return ascensor_estado;
	}

	public void setAscensor_estado(State ascensor_estado) {
		this.ascensor_estado = ascensor_estado;

	}

	public void setAscensor_puerta(String puerta) {
		this.puerta_estado = puerta;
	}	
	
	//--------------------------------------------------------------
	//Funciones de ascensor.
	//--------------------------------------------------------------
	
	//Ya están
	@Override
	public void moverAscensor(int Destino) {
			this.ascensor_estado.moverAscensor(this);
	}
	
	//No están.
	@Override
	public void cambiarEstadoPuerta() {
		this.ascensor_estado.cambiarEstadoPuerta(this);
	}

	@Override
	public void activarAlarma() {
		// TODO Auto-generated method stub
	}
	@Override
	public void anyadirDestino(int destino) {
		// TODO Auto-generated method stub
		if(!this.getDestinos().contains(destino))
			this.destinos.add(destino);
	}
	@Override
	public int calculoDistancia(int destino) {
		// TODO Auto-generated method stub
		int distancia = 0;
		if(this.planta_actual != destino)
			distancia = Math.abs(destino - this.planta_actual);
		return distancia;
	}

	@Override
	public void mostrarPlantaActual() {
		// TODO Auto-generated method stub
		
	}

	public void CambiosLocos() throws InterruptedException {
		for (int i = 0; i < 100; i ++) {
		this.puerta_estado = "A";
		TimeUnit.SECONDS.sleep(2);
		this.puerta_estado = "B";
		TimeUnit.SECONDS.sleep(2);
		this.puerta_estado = "C";
		TimeUnit.SECONDS.sleep(2);
		this.puerta_estado = "D";
		TimeUnit.SECONDS.sleep(2);
		this.puerta_estado = "E";
		TimeUnit.SECONDS.sleep(2);
		this.puerta_estado = "F";
		TimeUnit.SECONDS.sleep(2);
		this.puerta_estado = "G";
		TimeUnit.SECONDS.sleep(2);
		this.puerta_estado = "H";
		TimeUnit.SECONDS.sleep(2);
		this.puerta_estado = "I";
		this.puerta_estado = "J";
		this.puerta_estado = "K";
		this.puerta_estado = "L";
		this.puerta_estado = "M";
		this.puerta_estado = "N";
		this.puerta_estado = "O";
		this.puerta_estado = "P";
		this.puerta_estado = "Q";
		this.puerta_estado = "R";
		this.puerta_estado = "S";
		this.puerta_estado = "T";
		this.puerta_estado = "U";
		this.puerta_estado = "V";
		this.puerta_estado = "W";
		this.puerta_estado = "X";
		this.puerta_estado = "Y";
		this.puerta_estado = "Z";
		}

	}
	

}
