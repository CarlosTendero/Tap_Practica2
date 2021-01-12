package Clases.AscensorPuertaState;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoAbierto implements State{

	//Constructor. Para definir la lista de observers.
	public ParadoAbierto(/*Pasarle como referencia la lista de observers*/) {
		//Lista de observers = 
	}
	
	//Funciones
	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {		
		ascensor.setAscensor_puerta("Puerta Cerrada");	
		ascensor.setAscensor_estado(new ParadoCerrando());
		
		//Lista de observers a quien informar el cambio de estado de la puerta.
	}

	@Override
	public void moverAscensor(Ascensor ascensor) {

		System.out.println("Primero hay que cerrar la puerta");
		//No hacer nada.
	}

}
