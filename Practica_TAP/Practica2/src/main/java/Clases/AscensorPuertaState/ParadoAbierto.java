package Clases.AscensorPuertaState;

import Clases.Ascensor;
import Clases.Impl.State;

public class ParadoAbierto implements State{

	@Override
	public void cambiarEstadoPuerta(Ascensor ascensor) {

		ascensor.setAscensor_puerta("Puerta Cerrada");
		
		ascensor.setAscensor_estado(new ParadoCerrando());
		
	}

	@Override
	public void cambiarEstadoAscensor(Ascensor ascensor) {

		System.out.println("Primero hay que cerrar la puerta");
		
	}

}
