package Clases;

import java.util.ArrayList;
import java.util.Calendar;

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

	// Variable que guarda el mensaje del altavoz
	private String mensaje_altavoz;


	//--------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------
	
	public Ascensor(int planta_actual, State ascensor_estado, String puerta_estado, int numAscensor) {
		this.planta_actual = planta_actual;			// asignamos planta actual
		this.ascensor_estado = ascensor_estado;		// asignamos el estado del ascensor
		this.puerta_estado = puerta_estado;			// asignamos el estado de la puerta
		this.emergencia = false;					// asignamos la emergecia
		this.destinos = new ArrayList<Integer>();	// asignamos los destinos del ascensor
		this.numAscensor = numAscensor;				// asignamos el numero del ascensor

	}
	
	//--------------------------------------------------------------
	//Setters y getters
	//--------------------------------------------------------------
	
	public String getPuerta_estado() {						// Devuelve el valor de la puerta estado
		return puerta_estado;
	}
	public void setPuerta_estado(String puerta_estado) {	// actualiza el valor de la puerta estado
		this.puerta_estado = puerta_estado;
	}	
	public boolean getEmergencia() { // Devuelve la emergencia
		return emergencia;
	}
	public void setEmergencia(boolean emergencia) { 	// actualiza el valor de emergencia
		this.emergencia = emergencia;
	}
	public ArrayList<Integer> getDestinos() { 			// Devuelve el array de destinos
		return destinos;
	}
	public int getPlanta_actual() {						// Devuelve la planta actual
		return planta_actual;
	}
	public void setPlanta_actual(int planta_actual) {	// Actualiza la planta actual
		this.planta_actual = planta_actual;
	}
	public State getAscensor_estado() {					// Devuelve el estado delascensor
		return ascensor_estado;
	}
	public void setAscensor_estado(State ascensor_estado) { // Actualiza el estado del ascensor
		this.ascensor_estado = ascensor_estado;
	}
	public String getAscensor_estadostring() {			 	// Devuelve el estado del Ascensor en formato string
		return ascensor_estado.toString();
	}
	public void setAscensor_puerta(String puerta) {			// Actualiza el estado de la puerta 
		this.puerta_estado = puerta;
	}	
	public int getNumAscensor() {		// Devuelve el Numero del ascensor
		return numAscensor;
	}
	public String getMensajeAltavoz() { // Devuelve el Mensaje del altavoz
		return mensaje_altavoz;
	}
	public void setMensajeAltavoz(String mensaje_altavoz) { // Actualiza el mensaje del altavoz
		this.mensaje_altavoz = mensaje_altavoz;
	}
	//--------------------------------------------------------------
	//Funciones de ascensor.
	//--------------------------------------------------------------
	//Función para llamar al movimiento del ascensor desde el front
	@Override
	public void moverAscensor(int Destino) {
			this.ascensor_estado.moverAscensor(this, Destino);	//llama al state llamar
	}


	//Función para cambiar el estado de la puerta desde el front
	@Override
	public void cambiarEstadoPuerta() {
		this.ascensor_estado.cambiarEstadoPuerta(this);			// cambia el estado de la Puerta
	}

	//Función para activar la alarma
	@Override
	public void activarAlarma() {							
		// TODO Auto-generated method stub
		this.ascensor_estado.activarAlarma(this, emergencia);	// Cambio de estado
		this.emergencia = true;									// Activamos la emergencia
	}
	//Función para añadir destinos secuencialmente a la ruta del ascensor
	@Override
	public void anyadirDestino(int destino) {
		// TODO Auto-generated method stub
		if(!this.getDestinos().contains(destino)) {
			this.destinos.add(destino);						// anyadimos el destino
			//Petición de que queremos movernos al estado actual.
			this.moverAscensor(this.getDestinos().get(0)); 	// movemos el ascensor a dicho destino
					// una vez hemos movido el ascensor a ese destino lo eliminamos
		}		
	}
}
