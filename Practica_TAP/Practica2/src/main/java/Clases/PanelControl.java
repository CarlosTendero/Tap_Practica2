package Clases;

import java.util.ArrayList;

import Clases.Impl.Observer;

public class PanelControl extends Observer implements Clases.Impl.PanelControlImpl{
	//--------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------
	//Arrays con los datos de los ascensores. Pos 0 = Ascensor 0, etc.
	private ArrayList<Integer> pisoActualAscensores;
	private ArrayList<Boolean> emergenciaActualAscensores;
	private ArrayList<String> estadoActualAscensores;

	
	//--------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------
	
	public PanelControl(ArrayList<Ascensor> ascensores) {
		
		this.pisoActualAscensores 		= new ArrayList<Integer>();
		this.emergenciaActualAscensores = new ArrayList<Boolean>();
		this.estadoActualAscensores 	= new ArrayList<String>();
		
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
	public void update(Ascensor ascensor) {
		pisoActualAscensores.set(ascensor.getNumAscensor(), ascensor.getPlanta_actual());
		emergenciaActualAscensores.set(ascensor.getNumAscensor(), ascensor.getEmergencia());
		estadoActualAscensores.set(ascensor.getNumAscensor(), ascensor.getPuerta_estado());
	}
}
