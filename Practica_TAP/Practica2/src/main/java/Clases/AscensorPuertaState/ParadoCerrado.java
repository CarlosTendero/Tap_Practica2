package Clases.AscensorPuertaState;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoCerrado implements State{

	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {

		ascensor.setAscensor_puerta("Puerta Abierta");
		
		ascensor.setAscensor_estado(new ParadoAbriendo());
	}

	@Override
	public void cambiarEstadoAscensor(Ascensor ascensor) {

		//mover el ascensor
		ascensor.setAscensor_estado(new MoviendoAscensor());
		
	}
	
}
