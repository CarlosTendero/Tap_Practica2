package Clases.AscensorPuertaState;

import java.util.ArrayList;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoAbierto implements State{
	
	//Funciones
	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {		
		ascensor.setAscensor_puerta("Puerta Cerrándose");	
		ascensor.setAscensor_estado(new ParadoCerrando());
		ascensor.getAscensor_estado().cambiarEstadoPuerta(ascensor);
		
		//Lista de observers a quien informar el cambio de estado de la puerta.
	}

	@Override
	public ArrayList<Integer> moverAscensor(Ascensor ascensor, int Destino) {

		System.out.println("Primero hay que cerrar la puerta");
		//No hacer nada.
		
		return null;
	}

	@Override
	public void activarAlarma(Ascensor ascensor, boolean emergencia) {
		// TODO Auto-generated method stub
		
	}

}
