package Clases;

import java.util.ArrayList;

import Clases.Impl.Observer_Notificadores;
import Clases.Impl.State;

public class Ascensor extends Observer_Notificadores implements Clases.Impl.AscensorImpl{

	//--------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------
	
	//Variable donde guardamos la planta actual del ascensor
	private int planta_actual;
	
	//Array donde guardamos los destinos
	private ArrayList<Integer> destinos;
	
	
	private ArrayList<Integer> plantas_visitadas;
	
	//Variable para guardar el estado del ascensor (tipo State)
	private State ascensor_estado;
	
	//String donde guardamos el estado de la puerta
	private String puerta_estado;
	
	//No sabemos si hace falta
	private boolean emergencia;
	
	//Variable que guarda el ascensor al que corresponde de nuestro array de ascensores
	private int numAscensor;

	private String mensaje_altavoz;

	

	//--------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------
	
	public Ascensor(int planta_actual, State ascensor_estado, String puerta_estado, int numAscensor) {
		this.planta_actual = planta_actual;
		this.ascensor_estado = ascensor_estado;
		this.puerta_estado = puerta_estado;
		this.emergencia = false;
		this.destinos = new ArrayList<Integer>();
		this.numAscensor = numAscensor;

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
	
	public String getAscensor_estadostring() {
		return ascensor_estado.toString();
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
	
	public String getMensajeAltavoz() {
		return mensaje_altavoz;
	}
	
	public void setMensajeAltavoz(String mensaje_altavoz) {
		this.mensaje_altavoz = mensaje_altavoz;
	}

	//--------------------------------------------------------------
	//Funciones de ascensor.
	//--------------------------------------------------------------

	//Función para llamar al movimiento del ascensor desde el front
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
	public void activarAlarma() {
		// TODO Auto-generated method stub
		
		this.ascensor_estado.activarAlarma(this, emergencia);
		
		emergencia = true;
	}
	//Función para añadir destinos secuencialmente a la ruta del ascensor
	@Override
	public void anyadirDestino(int destino) {
		// TODO Auto-generated method stub
		if(!this.getDestinos().contains(destino)) {
			this.destinos.add(destino);
			//Petición de que queremos movernos al estado actual.
			this.moverAscensor(this.getDestinos().get(0));
			//this.getDestinos().remove(0);
		}
		
	}

	@Override
	public void mostrarPlantaActual() {
		// TODO Auto-generated method stub
	}
}
