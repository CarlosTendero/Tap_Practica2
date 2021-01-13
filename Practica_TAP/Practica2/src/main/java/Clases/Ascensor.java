package Clases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import Clases.Impl.Observer_Notificadores;
import Clases.Impl.State;

public class Ascensor extends Observer_Notificadores implements Clases.Impl.AscensorImpl{

	//--------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------
	

	private int planta_actual;
	private ArrayList<Integer> destinos;
	private State ascensor_estado;
	private String puerta_estado;
	//No sabemos si hace falta
	private boolean emergencia;
	private int numAscensor; 		//Identificador del ascensor.

	//--------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------
	
	public Ascensor(int planta_actual, State ascensor_estado, String puerta_estado,int numAsc) {
		this.planta_actual = planta_actual;
		this.ascensor_estado = ascensor_estado;
		this.puerta_estado = puerta_estado;
		this.numAscensor = numAsc;
		this.emergencia = false;
		this.destinos = new ArrayList<Integer>();
	}
	
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
	
	public boolean getEmergencia() {
		return emergencia;
	}
	
	public int getNumAscensor() {
		return numAscensor;
	}
	

	//--------------------------------------------------------------
	//Funciones de ascensor.
	//--------------------------------------------------------------
	
	@Override
	public void moverAscensor(int Destino) {
			this.ascensor_estado.moverAscensor(this, Destino);
	}
	
	//Función para cambiar el estado de la puerta desde el front
	@Override
	public void cambiarEstadoPuerta() {
		this.ascensor_estado.cambiarEstadoPuerta(this);
	}

	//Función para activar la alarma
	@Override
	public void activarAlarma(boolean emergencia) {
		// TODO Auto-generated method stub
		
		this.ascensor_estado.activarAlarma(this, emergencia);
		
		emergencia = true;
	}
	//Función para añadir destinos secuencialmente a la ruta del ascensor
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
	

}
