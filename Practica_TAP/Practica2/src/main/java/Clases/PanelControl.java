package Clases;

import java.util.ArrayList;

import Clases.Impl.Observer;

import PracticaTAP2_20202021.MyUI;

public class PanelControl extends Observer implements Clases.Impl.PanelControlImpl{
	//--------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------
	//Arrays con los datos de los ascensores. Pos 0 = Ascensor 0, etc.
	private ArrayList<Integer> pisoActualAscensores;			// Array que guarda el piso Actual de los Ascensores
	private ArrayList<Boolean> emergenciaActualAscensores;		// Array que guarda la emergencia actual de los ascensores
	private ArrayList<String> estadoActualAscensores;			// Array que guarda los estados Actuales de los ascensores

	
	//--------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------
	
	public PanelControl(ArrayList<Ascensor> ascensores) {
		
		this.pisoActualAscensores 		= new ArrayList<Integer>();		// Creamos el ArrayList para pisoActualAscensores
		this.emergenciaActualAscensores = new ArrayList<Boolean>();		// Creamos el ArrayList para emergenciaActualAscensores
		this.estadoActualAscensores 	= new ArrayList<String>();		// Creamos el ArrayList para estadoActualAscensores
		
		for(int i = 0; i < ascensores.size(); i++) {					
			pisoActualAscensores.add(ascensores.get(i).getPlanta_actual());
			emergenciaActualAscensores.add(ascensores.get(i).getEmergencia());
			estadoActualAscensores.add(ascensores.get(i).getPuerta_estado());	
		}
	}
	
	//--------------------------------------------------------------
	//Funciones
	//--------------------------------------------------------------
		
	@Override
	public void update(Ascensor ascensor) {		// Actualiza
		pisoActualAscensores.set(ascensor.getNumAscensor(), ascensor.getPlanta_actual());
		emergenciaActualAscensores.set(ascensor.getNumAscensor(), ascensor.getEmergencia());
		estadoActualAscensores.set(ascensor.getNumAscensor(), ascensor.getPuerta_estado());

		MyUI.ActualizarCaptions();		// Mostramos por MyUI los nuevos valores
	}
}
