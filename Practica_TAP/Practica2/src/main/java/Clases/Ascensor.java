package Clases;

import java.util.ArrayList;

import Clases.Impl.State;

public class Ascensor implements Clases.Impl.AscensorImpl{

	private int planta_actual;
	private ArrayList<Integer> destinos;
	private State ascensor_estado;
	private String puerta_estado;
	private boolean emergencia;


	public Ascensor(int planta_actual, State ascensor_estado, String puerta_estado) {
		this.planta_actual = planta_actual;
		this.ascensor_estado = ascensor_estado;
		this.puerta_estado = puerta_estado;

		this.emergencia = false;
		this.destinos = new ArrayList<Integer>();

	}

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
	@Override
	public ArrayList<Integer> moverAscensor(Planta Destino) {		
		return null;

	}
	@Override
	public void cambiarEstadoPuerta() {

		this.ascensor_estado.cambiarEstadoPuerta(this);
	}
	@Override
	public void cambiarEstadoAscensor() {
		this.ascensor_estado.cambiarEstadoAscensor(this);
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
}
