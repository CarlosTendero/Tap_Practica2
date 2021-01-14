package Clases;

import java.util.ArrayList;

import PracticaTAP2_20202021.MyUI;

public class Planta extends Clases.Impl.Observer implements Clases.Impl.PlantaImpl{

	//--------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------
	//Arrays con los datos de los ascensores. Pos 0 = Ascensor 0, etc.
	private ArrayList<Integer> pisoActualAscensores;		// ArrayList que guarda los pisoActualAscensores
	private ArrayList<Boolean> emergenciaActualAscensores;	// ArrayList que guarda la emergencia de los Ascensores
	private int numPlanta;									// Identificador de la planta actual.
	private Altavoz altavoz;								// Identificador para el Altavoz
	
	//--------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------
	
	public Planta(ArrayList<Ascensor> ascensores, int numPlanta) {

		this.numPlanta = numPlanta;										// Asignamos numPlanta
		this.pisoActualAscensores = new ArrayList<Integer>();			// ArrayList de pisoActualAscensores
		this.emergenciaActualAscensores = new ArrayList<Boolean>();		// ArrayList de emergenciaActualAscensores
		
		//Inicializamos la planta a su valor de por defecto.
		for(int i = 0; i < ascensores.size(); i++) {								
			this.pisoActualAscensores.add(ascensores.get(i).getPlanta_actual());
			this.emergenciaActualAscensores.add(ascensores.get(i).getEmergencia());
		}	
		this.altavoz = new Altavoz("");
	}
	
	//Getter de la variable altavoz
	public Altavoz getAltavoz() {
		return this.altavoz;
	}
	
	//--------------------------------------------------------------
	//Funciones
	//--------------------------------------------------------------
	
	@Override
	public void llamarAscensor(Ascensor ascensor) {	// Funcion que llama Ascensor
		ascensor.anyadirDestino(this.numPlanta);
	}

	@Override
	public void update(Ascensor ascensor) {		// FUNCION QUE ACTUALIZA
		pisoActualAscensores.set(ascensor.getNumAscensor(), ascensor.getPlanta_actual());
		emergenciaActualAscensores.set(ascensor.getNumAscensor(), ascensor.getEmergencia());

		altavoz.setAltavoz(ascensor.getMensajeAltavoz());
		MyUI.ActualizarCaptions();

	}
}
