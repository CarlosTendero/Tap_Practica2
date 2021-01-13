package Clases;

import java.util.ArrayList;

public class Planta extends Clases.Impl.Observer implements Clases.Impl.PlantaImpl{

	//--------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------
	//Arrays con los datos de los ascensores. Pos 0 = Ascensor 0, etc.
	private ArrayList<Integer> pisoActualAscensores;
	private ArrayList<Boolean> emergenciaActualAscensores;
	private int numPlanta;		//Identificador de la planta actual.

	//--------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------
	
	public Planta(ArrayList<Ascensor> ascensores, int numPlanta) {

		this.numPlanta = numPlanta;
		this.pisoActualAscensores = new ArrayList<Integer>();
		this.emergenciaActualAscensores = new ArrayList<Boolean>();
		
		//Inicializamos la planta a su valor de por defecto.
		for(int i = 0; i < ascensores.size(); i++) {
			this.pisoActualAscensores.add(ascensores.get(i).getPlanta_actual());
			this.emergenciaActualAscensores.add(ascensores.get(i).getEmergencia());
		}
	}
	
	//--------------------------------------------------------------
	//Funciones
	//--------------------------------------------------------------
	
	@Override
	public void llamarAscensor(Ascensor ascensor) {
		ascensor.anyadirDestino(this.numPlanta);
	}

	@Override
	public void update(Ascensor ascensor) {
		pisoActualAscensores.set(ascensor.getNumAscensor(), ascensor.getPlanta_actual());
		emergenciaActualAscensores.set(ascensor.getNumAscensor(), ascensor.getEmergencia());
	}

	
	
}
