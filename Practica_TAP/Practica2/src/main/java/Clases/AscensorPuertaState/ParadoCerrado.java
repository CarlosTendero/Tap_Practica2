package Clases.AscensorPuertaState;

import java.util.ArrayList;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoCerrado implements State{

	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {

		ascensor.setAscensor_puerta("Puerta Abierta");	
		ascensor.setAscensor_estado(new ParadoAbriendo());
		ascensor.getAscensor_estado().cambiarEstadoPuerta(ascensor);
	}

	@Override
	public ArrayList<Integer> moverAscensor(Ascensor ascensor, int Destino) {

		//mover el ascensor
		ascensor.setAscensor_estado(new MoviendoAscensor()); 
		
		return null;

	}

	@Override
	public void activarAlarma(Ascensor ascensor, boolean emergencia) {
		// TODO Auto-generated method stub
		
	}
	
}
